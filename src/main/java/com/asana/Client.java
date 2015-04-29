package com.asana;

import com.asana.dispatcher.BasicAuthDispatcher;
import com.asana.dispatcher.Dispatcher;
import com.asana.dispatcher.OAuthDispatcher;
import com.asana.errors.AsanaError;
import com.asana.errors.RateLimitEnforcedError;
import com.asana.errors.RetryableAsanaError;
import com.asana.requests.Request;
import com.asana.resources.*;
import com.google.api.client.http.*;
import com.google.common.base.Joiner;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main Asana client class
 */
public class Client
{
    /**
     * Number of milliseconds to delay before retrying
     */
    public static double RETRY_DELAY = 1000.0;

    /**
     * Back off retrying by this factor (e.x. 2 would result in doubling of delay each retry)
     */
    public static double RETRY_BACKOFF = 2.0;

    /**
     * Map of default options, from string key to primitive value types (string, numeric, boolean)
     */
    public static final Map<String, Object> DEFAULTS = new HashMap<String, Object>() {{
        put("base_url", "https://localhost.asana.com:8180/api/1.0");
        put("item_limit", -1);
        put("page_size", 50);
        put("poll_interval", 5);
        put("max_retries", 5);
    }};

    public HashMap<String, Object> options;

    public Dispatcher dispatcher;

    public Attachments attachments;
    public Events events;
    public Projects projects;
    public Stories stories;
    public Tags tags;
    public Tasks tasks;
    public Teams teams;
    public Users users;
    public Workspaces workspaces;

    private static final String[] QUERY_OPTIONS   = new String[] { "limit", "offset", "sync" };
    private static final String[] API_OPTIONS     = new String[] { "pretty", "fields", "expand" };

    private static final String CLIENT_VERSION_HEADER_NAME = "X-Asana-Client-Lib";


    /**
     * @param dispatcher Dispatcher to handle authentication
     */
    public Client(Dispatcher dispatcher)
    {
        this(dispatcher, null);
    }

    /**
     * @param dispatcher Dispatcher to handle authentication
     * @param options Map of client options, overrides Client.DEFAULTS, overridden by request options
     */
    public Client(Dispatcher dispatcher, Map<String, Object> options)
    {
        this.dispatcher = dispatcher;

        this.options = new HashMap<String, Object>();
        this.options.putAll(DEFAULTS);
        if (options != null) {
            this.options.putAll(options);
        }

        this.attachments = new Attachments(this);
        this.events = new Events(this);
        this.projects = new Projects(this);
        this.stories = new Stories(this);
        this.tags = new Tags(this);
        this.tasks = new Tasks(this);
        this.teams = new Teams(this);
        this.users = new Users(this);
        this.workspaces = new Workspaces(this);
    }

    /**
     * @param request Asana client request object
     * @return Raw HttpResponse object
     * @throws IOException
     */
    public HttpResponse request(Request request) throws IOException
    {
        GenericUrl url = new GenericUrl(request.options.get("base_url") + request.path);

        HttpContent content = null;
        Map<String,Object> body = new HashMap<String, Object>();

        // API options
        if (request.method.equals("GET")) {
            for (String key: API_OPTIONS) {
                if (request.options.containsKey(key) && !request.query.containsKey("opt_" + key)) {
                    request.query.put("opt_" + key, request.options.get(key));
                }
            }
            for (String key: QUERY_OPTIONS) {
                if (request.options.containsKey(key) && !request.query.containsKey(key)) {
                    request.query.put(key, request.options.get(key));
                }
            }
        } else if (request.method.equals("POST") || request.method.equals("PUT")) {
            Map<String,Object> opts= new HashMap<String, Object>();
            for (String key: API_OPTIONS) {
                if (request.options.containsKey(key)) {
                    opts.put(key, request.options.get(key));
                }
            }
            if (opts.size() > 0) {
                body.put("options", opts);
            }
        }

        // Query string
        for (Map.Entry<String, Object> entry : request.query.entrySet()) {
            Object value = entry.getValue();
            if (value == null || value == "") {
                continue;
            }
            if (value instanceof List) {
                value = Joiner.on(",").join((List)value);
            }
            url.put(entry.getKey(), value);
        }

        if (request.content != null) {
            // Multipart, etc body
            content = request.content;
        } else if (request.method.equals("POST") || request.method.equals("PUT")) {
            // JSON body
            body.put("data", request.data);
            String json = Json.getInstance().toJson(body);
            content = new ByteArrayContent("application/json", json.getBytes());
        }

        int retryCount = 0;
        int maxRetries = (Integer) request.options.get("max_retries");
        while (true) {
            try {
                HttpRequest httpRequest = this.dispatcher.buildRequest(request.method, url, content);

                this.dispatcher.authenticate(httpRequest);
                httpRequest.getHeaders().set(CLIENT_VERSION_HEADER_NAME, versionHeader());

                try {
                    return httpRequest.execute();
                } catch (HttpResponseException e) {
                    throw AsanaError.mapException(e);
                }
            } catch (RetryableAsanaError e) {
                if (retryCount < maxRetries) {
                    this.handleRetryableError(e, retryCount);
                    retryCount++;
                } else {
                    throw e;
                }
            }
        }
    }

    /**
     * @param error Error thrown by Asana request
     * @param retryCount Number of times this request has been retried
     */
    private void handleRetryableError(RetryableAsanaError error, int retryCount)
    {
        if (error instanceof RateLimitEnforcedError) {
            this.dispatcher.sleep(((RateLimitEnforcedError)error).retryAfter);
        } else {
            this.dispatcher.sleep((long)(RETRY_DELAY * Math.pow(RETRY_BACKOFF, retryCount)));
        }
    }


    private String clientVersion()
    {
        String version = getClass().getPackage().getImplementationVersion();
        // This will be null if the class is executed from outside its packaged
        // jar, such as during tests.
        return (version != null) ? version : "0.0.0";
    }


    private String versionHeader()
    {
        StringBuilder builder = new StringBuilder();
        HashMap<String, String> values = new HashMap<String, String>();
        values.put("version", clientVersion());
        values.put("language", "Java");
        values.put("language_version", System.getProperty("java.version"));
        values.put("os", System.getProperty("os.name"));
        values.put("os_version", System.getProperty("os.version"));
        for (Map.Entry<String, String> entry : values.entrySet()) {
            builder.append("&");
            builder.append(URLEncoder.encode(entry.getKey()));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue()));
        }
        return builder.toString().substring(1);
    }

    /**
     * @param apiKey Basic Auth API key
     * @param options Map of options to be passed to the client instance
     * @return Client instance
     */
    public static Client basicAuth(String apiKey, Map<String,Object> options)
    {
        return new Client(new BasicAuthDispatcher(apiKey), options);
    }

    /**
     * @param apiKey Basic Auth API key
     * @return Client instance
     */
    public static Client basicAuth(String apiKey)
    {
        return basicAuth(apiKey, null);
    }

    /**
     * @param apiKey OAuth2 API key
     * @param apiSecret OAuth2 API secret
     * @param redirectUri Redirect URI
     * @return Client instance
     */
    public static Client oauth(String apiKey, String apiSecret, String redirectUri)
    {
        return oauth(apiKey, apiSecret, redirectUri, null);
    }

    /**
     * @param apiKey OAuth2 API key
     * @param apiSecret OAuth2 API secret
     * @param redirectUri Redirect URI
     * @param accessToken Previously obtained access token to initialize the dispatcher with
     * @return Client instance
     */
    public static Client oauth(String apiKey, String apiSecret, String redirectUri, String accessToken)
    {
        return new Client(new OAuthDispatcher(apiKey, apiSecret, redirectUri, accessToken));
    }
}

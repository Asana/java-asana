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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client
{
    public static double RETRY_DELAY = 1000.0;
    public static double RETRY_BACKOFF = 2.0;

    public static final Map<String, Object> DEFAULTS = new HashMap<String, Object>() {{
        put("base_url", "https://app.asana.com/api/1.0");
        put("item_limit", -1);
        put("page_size", 50);
        put("poll_interval", 5);
        put("max_retries", 5);
    }};

    public static final String[] QUERY_OPTIONS   = new String[] { "limit", "offset", "sync" };
    public static final String[] API_OPTIONS     = new String[] { "pretty", "fields", "expand" };

    public Dispatcher dispatcher;
    public HashMap<String, Object> options;

    public Attachments attachments;
    public Events events;
    public Projects projects;
    public Stories stories;
    public Tags tags;
    public Tasks tasks;
    public Teams teams;
    public Users users;
    public Workspaces workspaces;

    public static final Gson parser = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").create();

    public Client(Dispatcher dispatcher)
    {
        this(dispatcher, null);
    }

    public Client(Dispatcher dispatcher, HashMap<String, Object> options)
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

    public HttpResponse request(Request request) throws IOException
    {
        GenericUrl url = new GenericUrl(request.options.get("base_url") + request.path);

        ByteArrayContent content = null;
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

        // JSON body
        if (request.method.equals("POST") || request.method.equals("PUT")) {
            body.put("data", request.data);
            String json = parser.toJson(body);
            System.out.println("!!! > " + json);
            content = new ByteArrayContent("application/json", json.getBytes());
        }

        int retryCount = 0;
        int maxRetries = (Integer) request.options.get("max_retries");
        while (true) {
            try {
                HttpRequest httpRequest = this.dispatcher.buildRequest(request.method, url, content);

                this.dispatcher.authenticate(httpRequest);

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

    private void handleRetryableError(RetryableAsanaError e, int retryCount)
    {
        if (e instanceof RateLimitEnforcedError) {
            this.dispatcher.sleep(((RateLimitEnforcedError)e).retryAfter);
        } else {
            this.dispatcher.sleep((long)(RETRY_DELAY * Math.pow(RETRY_BACKOFF, retryCount)));
        }
    }

    public static Client basicAuth(String apiKey, HashMap<String,Object> options)
    {
        return new Client(new BasicAuthDispatcher(apiKey), options);
    }

    public static Client basicAuth(String apiKey)
    {
        return basicAuth(apiKey, null);
    }

    public static Client oauth(String apiKey, String apiSecret, String redirectUri, String accessToken)
    {
        return new Client(new OAuthDispatcher(apiKey, apiSecret, redirectUri, accessToken));
    }

    public static Client oauth(String apiKey, String apiSecret, String redirectUri)
    {
        return oauth(apiKey, apiSecret, redirectUri, null);
    }
}

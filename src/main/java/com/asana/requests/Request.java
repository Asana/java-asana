package com.asana.requests;

import com.asana.Client;
import com.asana.resources.Resource;
import com.google.api.client.http.HttpContent;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.logging.Logger;

import com.google.api.client.http.HttpHeaders;

/**
 * Encapsulates all the inputs to a request, including the path, query string, headers, and body.
 * A single HTTP request can be initiated using the "execute" or "executeRaw" methods, or for collections methods
 * the CollectionRequest subclass can be used as an Iterable.
 */
public abstract class Request {
    private static Logger logger = null;

    public String method;
    public String path;

    public Map<String, Object> data;
    public Map<String, Object> query;
    public Map<String, Object> options;
    public Map<String, String> headers;
    public HttpContent content;

    protected Client client;
    protected Class elementClass; // required due to type erasure?

    /**
     * @param resource     Parent resource instance
     * @param elementClass The model class that this request returns
     * @param path         HTTP API endpoint path
     * @param method       HTTP API endpoint method
     */
    public Request(Resource resource, Class elementClass, String path, String method) {
        this.client = resource.client;
        this.elementClass = elementClass;

        this.path = path;
        this.method = method;
        this.content = null;

        this.data = new HashMap<String, Object>();
        this.query = new HashMap<String, Object>();
        this.options = new HashMap<String, Object>();
        this.headers = new HashMap<String, String>();

        this.options.putAll(this.client.options);
    }

    /**
     * Sets entire query string object, overrides previously set query string parameters
     *
     * @param query Entire query object
     * @return The request itself
     */
    public Request query(Map<String, Object> query) {
        this.query = query;
        return this;
    }

    /**
     * Sets a single key/value pair in the query string
     *
     * @param key   Name in the query string
     * @param value Value in the query string
     * @return The request itself
     */
    public Request query(String key, Object value) {
        this.query.put(key, value);
        return this;
    }

    /**
     * Sets the raw HTTP content for POST and PUT, overriding the JSON body
     *
     * @param content Raw HTTP content
     * @return The request itself
     */
    public Request data(HttpContent content) {
        this.content = content;
        return this;
    }

    /**
     * Sets the entire JSON body object, overrides previously set body parameters
     *
     * @param data Map of key/values to be used as the JSON body "data" object
     * @return The request itself
     */
    public Request data(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    /**
     * Sets a single key/value pair in the JSON body "data" object
     *
     * @param key   Name in the JSON body "data" object
     * @param value Value in the JSON body "data" object
     * @return The request itself
     */
    public Request data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    /**
     * Sets a client option per-request
     *
     * @param key   Option name
     * @param value Option value
     * @return The request itself
     */
    public Request option(String key, Object value) {
        this.options.put(key, value);
        return this;
    }

    /**
     * Sets a header per-request
     *
     * @param key   Header key
     * @param value Header value
     * @return The request itself
     */
    public Request header(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    /**
     * Reads and logs the Asana-Change header
     *
     * @param requestHeaders   String array of request headers
     * @param responseHeaders  String array of response headers
     * @return The request itself
     */
    @SuppressWarnings("unchecked")
    void handleAsanaChangeHeader(HttpHeaders requestHeaders, HttpHeaders responseHeaders) {
        HashSet<String> flagsAccountedFor = new HashSet<>();

        if (requestHeaders != null) {
            List<String> enabledHeaders = requestHeaders.getHeaderStringValues("asana-enable");
            List<String> disabledHeaders = requestHeaders.getHeaderStringValues("asana-disable");

            for (String header : enabledHeaders) {
                flagsAccountedFor.addAll(Arrays.asList(header.split(",")));
            }
            for (String header : disabledHeaders) {
                flagsAccountedFor.addAll(Arrays.asList(header.split(",")));
            }
        }

        List<String> changesArray = responseHeaders.getHeaderStringValues("asana-change");
        if (changesArray == null) {
            return;
        }

        for (String change : changesArray) {
            String[] changeParams = change.split(";");

            String name = "";
            String info = "";
            boolean affected = false;

            for (String changeParam : changeParams) {
                String[] paramKeyValue = changeParam.split("=");

                paramKeyValue[0] = paramKeyValue[0].trim();
                paramKeyValue[1] = paramKeyValue[1].trim();
                switch (paramKeyValue[0]) {
                    case "name":
                        name = paramKeyValue[1];
                        break;
                    case "info":
                        info = paramKeyValue[1];
                        break;
                    case "affected":
                        affected = Boolean.valueOf(paramKeyValue[1]);
                        break;
                }
            }

            if (!flagsAccountedFor.contains(name) && affected) {
                if (logger == null) {
                    logger = Logger.getLogger(Request.class.getCanonicalName());
                }

                String message = String.format("This request is affected by the \"%s\" deprecation. " +
                        "Please visit this url for more info: %s\n" +
                        "Adding \"%s\" to your \"Asana-Enable\" or \"Asana-Disable\" header " +
                        "will opt in/out to this deprecation and suppress this warning.",
                        name, info, name);

                logger.warning(message);
            }
        }
    }
}

package com.asana.requests;

import com.asana.Client;
import com.asana.resources.Resource;
import com.google.api.client.http.*;
import com.google.common.io.CharStreams;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Encapsulates all the inputs to a request, including the path, query string, headers, and body.
 * A single HTTP request can be initiated using the "execute" or "executeRaw" methods, or for collections methods
 * the CollectionRequest subclass can be used as an Iterable.
 */
public abstract class Request
{
    public String method;
    public String path;

    public Map<String,Object> data;
    public Map<String,Object> query;
    public Map<String,Object> options;
    public HttpContent content;

    protected Client client;
    protected Class elementClass; // required due to type erasure?

    /**
     * @param resource Parent resource instance
     * @param elementClass The model class that this request returns
     * @param path HTTP API endpoint path
     * @param method HTTP API endpoint method
     */
    public Request(Resource resource, Class elementClass, String path, String method)
    {
        this.client = resource.client;
        this.elementClass = elementClass;

        this.path = path;
        this.method = method;
        this.content = null;

        this.data = new HashMap<String,Object>();
        this.query = new HashMap<String,Object>();
        this.options = new HashMap<String,Object>();

        this.options.putAll(this.client.options);
    }

    /**
     * Sets entire query string object, overrides previously set query string parameters
     *
     * @param query Entire query object
     * @return The request itself
     */
    public Request query(Map<String, Object> query)
    {
        this.query = query;
        return this;
    }

    /**
     * Sets a single key/value pair in the query string
     *
     * @param key Name in the query string
     * @param value Value in the query string
     * @return The request itself
     */
    public Request query(String key, Object value)
    {
        this.query.put(key, value);
        return this;
    }

    /**
     * Sets the raw HTTP content for POST and PUT, overriding the JSON body
     *
     * @param content Raw HTTP content
     * @return The request itself
     */
    public Request data(HttpContent content)
    {
        this.content = content;
        return this;
    }

    /**
     * Sets the entire JSON body object, overrides previously set body parameters
     *
     * @param data Map of key/values to be used as the JSON body "data" object
     * @return The request itself
     */
    public Request data(Map<String, Object> data)
    {
        this.data = data;
        return this;
    }

    /**
     * Sets a single key/value pair in the JSON body "data" object
     *
     * @param key Name in the JSON body "data" object
     * @param value Value in the JSON body "data" object
     * @return The request itself
     */
    public Request data(String key, Object value)
    {
        this.data.put(key, value);
        return this;
    }

    /**
     * Sets a client option per-request
     *
     * @param key Option name
     * @param value Option value
     * @return The request itself
     */
    public Request option(String key, Object value)
    {
        this.options.put(key, value);
        return this;
    }
}

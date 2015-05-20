package com.asana.dispatcher;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;

import java.io.IOException;

public class BasicAuthDispatcher extends Dispatcher
{
    private String apiKey;

    public BasicAuthDispatcher(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public HttpRequest buildRequest(String method, GenericUrl url, HttpContent content) throws IOException
    {
        HttpRequest request = super.buildRequest(method, url, content);
        request.getHeaders().setBasicAuthentication(this.apiKey, "");
        return request;
    }
}

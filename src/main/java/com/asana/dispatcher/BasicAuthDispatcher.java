package com.asana.dispatcher;

import com.google.api.client.http.HttpRequest;

public class BasicAuthDispatcher extends Dispatcher
{
    private String apiKey;

    public BasicAuthDispatcher(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public void authenticate(HttpRequest request)
    {
        request.getHeaders().setBasicAuthentication(this.apiKey, "");
    }
}

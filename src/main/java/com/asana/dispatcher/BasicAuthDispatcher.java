package com.asana.dispatcher;

import com.google.api.client.http.*;

import java.io.IOException;

public class BasicAuthDispatcher extends Dispatcher {
    private String apiKey;

    public BasicAuthDispatcher(String apiKey) {
        super();
        this.apiKey = apiKey;
    }

    public BasicAuthDispatcher(String apiKey, HttpRequestInitializer requestInitializer) {
        super(requestInitializer);
        this.apiKey = apiKey;
    }

    public BasicAuthDispatcher(String apiKey, HttpTransport httpTransport) {
        super(httpTransport);
        this.apiKey = apiKey;
    }

    public HttpRequest buildRequest(String method, GenericUrl url, HttpContent content) throws IOException {
        HttpRequest request = super.buildRequest(method, url, content);
        request.getHeaders().setBasicAuthentication(this.apiKey, "");
        return request;
    }
}

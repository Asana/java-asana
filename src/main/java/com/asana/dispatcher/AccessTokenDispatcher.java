package com.asana.dispatcher;

import com.google.api.client.http.*;

import java.io.IOException;

public class AccessTokenDispatcher extends Dispatcher {

    private final String accessToken;

    public AccessTokenDispatcher(String accessToken) {
        super();
        this.accessToken = accessToken;
    }

    public AccessTokenDispatcher(String accessToken, HttpRequestInitializer requestInitializer) {
        super(requestInitializer);
        this.accessToken = accessToken;
    }

    public AccessTokenDispatcher(String accessToken, HttpTransport httpTransport) {
        super(httpTransport);
        this.accessToken = accessToken;
    }

    public HttpRequest buildRequest(String method, GenericUrl url, HttpContent content) throws IOException {
        HttpRequest request = super.buildRequest(method, url, content);
        request.getHeaders().setAuthorization("Bearer " + accessToken);
        return request;
    }
}

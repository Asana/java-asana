package com.asana.dispatcher;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;

import java.io.IOException;

public class AccessTokenDispatcher extends Dispatcher {

    private final String accessToken;

    public AccessTokenDispatcher(String accessToken) {
        super();
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

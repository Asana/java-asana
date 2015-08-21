package com.asana.dispatcher;

import com.asana.OAuthApp;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;

import java.io.IOException;

public class OAuthDispatcher extends Dispatcher {
    public OAuthApp app;

    public OAuthDispatcher(OAuthApp app) {
        super(); //leave it to superclass to set default HttpTransport
        this.app = app;
    }

    public OAuthDispatcher(OAuthApp app, HttpTransport httpTransport) {
        super(httpTransport);
        this.app = app;
    }

    public HttpRequest buildRequest(String method, GenericUrl url, HttpContent content) throws IOException {
        if (app.credential == null) {
            throw new IOException("OAuthDispatcher: access token not set");
        }
        return httpTransport.createRequestFactory(app.credential).buildRequest(method, url, content);
    }
}

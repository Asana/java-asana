package com.asana.dispatcher;

import com.asana.OAuthApp;
import com.google.api.client.http.*;

import java.io.IOException;

public class OAuthDispatcher extends Dispatcher
{
    public OAuthApp app;

    public OAuthDispatcher(OAuthApp app)
    {
        this.app = app;
    }

    public HttpRequest buildRequest(String method, GenericUrl url, HttpContent content) throws IOException
    {
        if (app.credential == null) {
            throw new IOException("OAuthDispatcher: access token not set");
        }
        return HTTP_TRANSPORT.createRequestFactory(app.credential).buildRequest(method, url, content);
    }
}

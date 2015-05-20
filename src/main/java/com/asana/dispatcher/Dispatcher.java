package com.asana.dispatcher;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;

public abstract class Dispatcher
{
    static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    public HttpRequest buildRequest(String method, GenericUrl url, HttpContent content) throws IOException
    {
        return HTTP_TRANSPORT.createRequestFactory().buildRequest(method, url, content);
    }

    public void sleep(long millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}

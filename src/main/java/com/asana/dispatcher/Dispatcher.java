package com.asana.dispatcher;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;

public abstract class Dispatcher
{
    static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    public void authenticate(HttpRequest request)
    {
    }

    public void sleep(long millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    public HttpRequest buildRequest(String method, GenericUrl url, ByteArrayContent content) throws IOException
    {
        return HTTP_TRANSPORT.createRequestFactory().buildRequest(method, url, content);
    }
}

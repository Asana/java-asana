package com.asana.dispatcher;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;

public abstract class Dispatcher {
    protected HttpTransport httpTransport;
    protected HttpRequestInitializer httpRequestInitializer;


    public Dispatcher() {
        this(new NetHttpTransport());
    }

    public Dispatcher(HttpRequestInitializer requestInitializer) {
        this(new NetHttpTransport(), requestInitializer);
    }

    public Dispatcher(HttpTransport httpTransport) {
        this(httpTransport, null);
    }

    public Dispatcher(HttpTransport httpTransport, HttpRequestInitializer requestInitializer) {
        this.httpTransport = httpTransport;
        this.httpRequestInitializer = requestInitializer;
    }

    public HttpRequest buildRequest(String method, GenericUrl url, HttpContent content) throws IOException {
        HttpRequestFactory requestFactory;
        if(httpRequestInitializer == null) {
            requestFactory = httpTransport.createRequestFactory();
        } else {
            requestFactory = httpTransport.createRequestFactory(httpRequestInitializer);
        }
        return requestFactory.buildRequest(method, url, content);
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}

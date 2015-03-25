package com.asana.dispatcher;

import com.google.api.client.http.HttpRequest;

public abstract class Dispatcher
{
    abstract public void authenticate(HttpRequest request);
}

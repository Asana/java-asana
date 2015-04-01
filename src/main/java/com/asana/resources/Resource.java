package com.asana.resources;

import com.asana.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class Resource
{
    public Client client;
    public Gson parser;

    public Resource(Client client)
    {
        this.client = client;
        this.parser = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").create();
    }
}

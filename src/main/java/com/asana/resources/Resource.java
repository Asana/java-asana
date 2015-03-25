package com.asana.resources;

import com.asana.Client;
import com.google.api.client.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

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

    public void logRequest(HttpResponse response) throws IOException
    {
        int k;
        StringBuffer sb=new StringBuffer();
        while((k=response.getContent().read())!=-1)
        {
            sb.append((char)k);
        }
        System.out.println(sb.toString());
    }
}

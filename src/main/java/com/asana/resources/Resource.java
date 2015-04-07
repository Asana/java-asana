package com.asana.resources;

import com.asana.Client;

public abstract class Resource
{
    public Client client;

    public Resource(Client client)
    {
        this.client = client;
    }
}

package com.asana.resources;

import com.asana.Client;

/**
 * Base class for resources
 */
public abstract class Resource {
    public Client client;

    public Resource(Client client) {
        this.client = client;
    }
}

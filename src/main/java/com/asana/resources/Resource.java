package com.asana.resources;

import com.asana.Client;
import com.asana.Json;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Base class for resources
 */
public abstract class Resource {
    public static Gson gson;
    public static Type type;
    public Client client;

    public Resource(Client client) {
        this.client = client;
    }

    public static Map<String, Object> getMapFromResource(Object body) {
        if (gson == null) {
            gson = Json.getInstance();
            type = new TypeToken<Map<String, String>>(){}.getType();
        }
        return(gson.fromJson(gson.toJsonTree(body), type));
    }
}

package com.asana.resources;

import com.asana.Client;
import com.asana.requests.CollectionRequest;
import com.asana.requests.ItemRequest;
import com.asana.models.User;

public class Users extends Resource
{
    public Users(Client client)
    {
        super(client);
    }

    public ItemRequest<User> me()
    {
        return new ItemRequest<User>(this, User.class, "/users/me", "GET");
    }

    public CollectionRequest<User> findAll()
    {
        return new CollectionRequest<User>(this, User.class, "/users", "GET");
    }
}

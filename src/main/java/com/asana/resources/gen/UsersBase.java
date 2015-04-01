package com.asana.resources.gen;

import com.asana.Client;
import com.asana.models.User;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

public class UsersBase extends Resource
{
    public UsersBase(Client client)
    {
        super(client);
    }

    public ItemRequest<User> me()
    {
        return new ItemRequest<User>(this, User.class, "/users/me", "GET");
    }

    public ItemRequest<User> findById(String user)
    {
        String path = String.format("/users/%s", user);
        return new ItemRequest<User>(this, User.class, path, "GET");
    }

    public CollectionRequest<User> findByWorkspace(String workspace)
    {
        String path = String.format("/workspaces/%s/users", workspace);
        return new CollectionRequest<User>(this, User.class, path, "GET");
    }

    public CollectionRequest<User> findAll()
    {
        return new CollectionRequest<User>(this, User.class, "/users", "GET");
    }
}

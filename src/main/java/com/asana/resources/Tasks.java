package com.asana.resources;

import com.asana.Client;
import com.asana.models.Task;
import com.asana.requests.CollectionRequest;
import com.asana.requests.ItemRequest;

import java.io.IOException;

public class Tasks extends Resource
{
    public Tasks(Client client)
    {
        super(client);
    }

    public ItemRequest<Task> create() throws IOException
    {
        return new ItemRequest<Task>(this, Task.class, "/tasks", "POST");
    }

    public ItemRequest<Task> findById(String id) throws IOException
    {
        String path = String.format("/tasks/%s", id);
        return new ItemRequest<Task>(this, Task.class, path, "GET");
    }

    public CollectionRequest<Task> findAll()
    {
        return new CollectionRequest<Task>(this, Task.class, "/tasks", "GET");
    }

    public ItemRequest<Task> update(String id) throws IOException
    {
        String path = String.format("/tasks/%s", id);
        return new ItemRequest<Task>(this, Task.class, path, "PUT");
    }

    public ItemRequest<Task> delete(String id) throws IOException
    {
        String path = String.format("/tasks/%s", id);
        return new ItemRequest<Task>(this, Task.class, path, "DELETE");
    }
}

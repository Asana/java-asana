package com.asana.resources.gen;

import com.asana.Client;
import com.asana.models.Story;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

public class StoriesBase extends Resource
{
    public StoriesBase(Client client)
    {
        super(client);
    }

    public ItemRequest<Story> findById(String story)
    {
        String path = String.format("/stories/%s", story);
        return new ItemRequest<Story>(this, Story.class, path, "GET");
    }

    public CollectionRequest<Story> findByTask(String task)
    {
        String path = String.format("/tasks/%s/stories", task);
        return new CollectionRequest<Story>(this, Story.class, path, "GET");
    }

    public ItemRequest<Story> createOnTask(String task)
    {
        String path = String.format("/tasks/%s/stories", task);
        return new ItemRequest<Story>(this, Story.class, path, "POST");
    }
}

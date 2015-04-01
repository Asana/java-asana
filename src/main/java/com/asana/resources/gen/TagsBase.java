package com.asana.resources.gen;

import com.asana.Client;
import com.asana.models.Tag;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

public class TagsBase extends Resource
{
    public TagsBase(Client client)
    {
        super(client);
    }

    public ItemRequest<Tag> create()
    {
        return new ItemRequest<Tag>(this, Tag.class, "/tags", "POST");
    }

    public ItemRequest<Tag> createInWorkspace(String workspace)
    {
        String path = String.format("/workspaces/%s/tags", workspace);
        return new ItemRequest<Tag>(this, Tag.class, path, "POST");
    }

    public ItemRequest<Tag> findById(String task)
    {
        String path = String.format("/tags/%s", task);
        return new ItemRequest<Tag>(this, Tag.class, path, "GET");
    }

    public ItemRequest<Tag> update(String tag)
    {
        String path = String.format("/tags/%s", tag);
        return new ItemRequest<Tag>(this, Tag.class, path, "PUT");
    }

    public ItemRequest<Tag> delete(String tag)
    {
        String path = String.format("/tags/%s", tag);
        return new ItemRequest<Tag>(this, Tag.class, path, "DELETE");
    }

    public CollectionRequest<Tag> findAll()
    {
        return new CollectionRequest<Tag>(this, Tag.class, "/tags", "GET");
    }

    public CollectionRequest<Tag> findByWorkspace(String workspace)
    {
        String path = String.format("/workspaces/%s/tags", workspace);
        return new CollectionRequest<Tag>(this, Tag.class, path, "GET");
    }
}

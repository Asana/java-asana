package com.asana.resources.gen;

import com.asana.Client;
import com.asana.models.Workspace;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

public class WorkspacesBase extends Resource
{
    public WorkspacesBase(Client client)
    {
        super(client);
    }

    public ItemRequest<Workspace> findById(String workspace)
    {
        String path = String.format("/workspaces/%s", workspace);
        return new ItemRequest<Workspace>(this, Workspace.class, path, "GET");
    }

    public CollectionRequest<Workspace> findAll()
    {
        return new CollectionRequest<Workspace>(this, Workspace.class, "/workspaces", "GET");
    }

    public ItemRequest<Workspace> update(String workspace)
    {
        String path = String.format("/workspaces/%s", workspace);
        return new ItemRequest<Workspace>(this, Workspace.class, path, "PUT");
    }

    public CollectionRequest<Workspace> typeahead(String workspace)
    {
        String path = String.format("/workspaces/%s/typeahead", workspace);
        return new CollectionRequest<Workspace>(this, Workspace.class, path, "GET");
    }
}

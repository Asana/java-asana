package com.asana.resources.gen;

import com.asana.Client;
import com.asana.models.Project;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

public class ProjectsBase extends Resource
{
    public ProjectsBase(Client client)
    {
        super(client);
    }

    public ItemRequest<Project> create()
    {
        return new ItemRequest<Project>(this, Project.class, "/projects", "POST");
    }

    public ItemRequest<Project> createInWorkspace(String workspace)
    {
        String path = String.format("/workspaces/%s/projects", workspace);
        return new ItemRequest<Project>(this, Project.class, path, "POST");
    }

    public ItemRequest<Project> createInTeam(String team)
    {
        String path = String.format("/teams/%s/projects", team);
        return new ItemRequest<Project>(this, Project.class, path, "POST");
    }

    public ItemRequest<Project> findById(String task)
    {
        String path = String.format("/projects/%s", task);
        return new ItemRequest<Project>(this, Project.class, path, "GET");
    }

    public ItemRequest<Project> update(String project)
    {
        String path = String.format("/projects/%s", project);
        return new ItemRequest<Project>(this, Project.class, path, "PUT");
    }

    public ItemRequest<Project> delete(String project)
    {
        String path = String.format("/projects/%s", project);
        return new ItemRequest<Project>(this, Project.class, path, "DELETE");
    }

    public CollectionRequest<Project> findAll()
    {
        return new CollectionRequest<Project>(this, Project.class, "/projects", "GET");
    }

    public CollectionRequest<Project> findByWorkspace(String workspace)
    {
        String path = String.format("/workspaces/%s/projects", workspace);
        return new CollectionRequest<Project>(this, Project.class, path, "GET");
    }

    public CollectionRequest<Project> findByTeam(String team)
    {
        String path = String.format("/teams/%s/projects", team);
        return new CollectionRequest<Project>(this, Project.class, path, "GET");
    }
}

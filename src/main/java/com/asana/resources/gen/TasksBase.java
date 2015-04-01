package com.asana.resources.gen;

import com.asana.Client;
import com.asana.models.Task;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

public class TasksBase extends Resource
{
    public TasksBase(Client client)
    {
        super(client);
    }

    public ItemRequest<Task> create()
    {
        return new ItemRequest<Task>(this, Task.class, "/tasks", "POST");
    }

    public ItemRequest<Task> createInWorkspace(String workspace)
    {
        String path = String.format("/workspaces/%s/tasks", workspace);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    public ItemRequest<Task> findById(String task)
    {
        String path = String.format("/tasks/%s", task);
        return new ItemRequest<Task>(this, Task.class, path, "GET");
    }

    public ItemRequest<Task> update(String task)
    {
        String path = String.format("/tasks/%s", task);
        return new ItemRequest<Task>(this, Task.class, path, "PUT");
    }

    public ItemRequest<Task> delete(String task)
    {
        String path = String.format("/tasks/%s", task);
        return new ItemRequest<Task>(this, Task.class, path, "DELETE");
    }

    public CollectionRequest<Task> findByProject(String projectId)
    {
        String path = String.format("/projects/%s/tasks", projectId);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    public CollectionRequest<Task> findByTag(String tag)
    {
        String path = String.format("/tags/%s/tasks", tag);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    public CollectionRequest<Task> findAll()
    {
        return new CollectionRequest<Task>(this, Task.class, "/tasks", "GET");
    }

    public ItemRequest<Task> addFollowers(String task)
    {
        String path = String.format("/tasks/%s/addFollowers", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    public ItemRequest<Task> removeFollowers(String task)
    {
        String path = String.format("/tasks/%s/removeFollowers", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    public CollectionRequest<Task> projects(String task)
    {
        String path = String.format("/tasks/%s/projects", task);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    public ItemRequest<Task> addProject(String task)
    {
        String path = String.format("/tasks/%s/addProject", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    public ItemRequest<Task> removeProject(String task)
    {
        String path = String.format("/tasks/%s/removeProject", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    public CollectionRequest<Task> tags(String task)
    {
        String path = String.format("/tasks/%s/tags", task);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    public ItemRequest<Task> addTag(String task)
    {
        String path = String.format("/tasks/%s/addTag", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    public ItemRequest<Task> removeTag(String task)
    {
        String path = String.format("/tasks/%s/removeTag", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    public CollectionRequest<Task> subtasks(String task)
    {
        String path = String.format("/tasks/%s/subtasks", task);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    public ItemRequest<Task> addSubtask(String task)
    {
        String path = String.format("/tasks/%s/subtasks", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    public CollectionRequest<Task> stories(String task)
    {
        String path = String.format("/tasks/%s/stories", task);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    public ItemRequest<Task> addComment(String task)
    {
        String path = String.format("/tasks/%s/stories", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }
}

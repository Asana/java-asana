package com.asana.resources;

import com.asana.Client;
import com.asana.models.*;
import com.asana.requests.CollectionRequest;
import com.asana.resources.gen.WorkspacesBase;

public class Workspaces extends WorkspacesBase {
    public Workspaces(Client client) {
        super(client);
    }

    public CollectionRequest<Task> taskTypeahead(String workspace) {
        String path = String.format("/workspaces/%s/typeahead", workspace);
        CollectionRequest<Task> request = new CollectionRequest<>(this, Task.class, path, "GET");
        return request.query("type", "task");
    }

    public CollectionRequest<User> userTypeahead(String workspace) {
        String path = String.format("/workspaces/%s/typeahead", workspace);
        CollectionRequest<User> request = new CollectionRequest<>(this, User.class, path, "GET");
        return request.query("type", "user");
    }

    public CollectionRequest<Project> projectTypeahead(String workspace) {
        String path = String.format("/workspaces/%s/typeahead", workspace);
        CollectionRequest<Project> request = new CollectionRequest<>(this, Project.class, path, "GET");
        return request.query("type", "project");
    }

    public CollectionRequest<Tag> tagTypeahead(String workspace) {
        String path = String.format("/workspaces/%s/typeahead", workspace);
        CollectionRequest<Tag> request = new CollectionRequest<>(this, Tag.class, path, "GET");
        return request.query("type", "tag");
    }
}

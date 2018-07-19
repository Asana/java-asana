package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.models.ProjectMembership;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

/**
 * With the introduction of "comment-only" projects in Asana, a user's membership
 * in a project comes with associated permissions. These permissions (whether a
 * user has full access to the project or comment-only access) are accessible
 * through the project memberships endpoints described here.
 */
public class ProjectMembershipsBase extends Resource {
    /**
     * @param client Parent client instance
     */
    public ProjectMembershipsBase(Client client) {
        super(client);
    }

    /**
     * Returns the compact project membership records for the project.
     *
     * @param  project The project for which to fetch memberships.
     * @return Request object
     */
    public CollectionRequest<ProjectMembership> getMany(String project) {
    
        String path = String.format("/projects/%s/project_memberships", project);
        return new CollectionRequest<ProjectMembership>(this, ProjectMembership.class, path, "GET");
    }

    /**
     * Returns the project membership record.
     *
     * @param  project Globally unique identifier for the project membership.
     * @return Request object
     */
    public ItemRequest<ProjectMembership> getSingle(String project) {
    
        String path = String.format("/project_memberships/%s", project);
        return new ItemRequest<ProjectMembership>(this, ProjectMembership.class, path, "GET");
    }
}

package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.models.User;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

/**
 * A _user_ object represents an account in Asana that can be given access to
 * various workspaces, projects, and tasks.
 * 
 * Like other objects in the system, users are referred to by numerical IDs.
 * However, the special string identifier `me` can be used anywhere
 * a user ID is accepted, to refer to the current authenticated user.
 */
public class UsersBase extends Resource {
    /**
     * @param client Parent client instance
     */
    public UsersBase(Client client) {
        super(client);
    }

    /**
     * Returns the full user record for the currently authenticated user.
     *
     * @return Request object
     */
    public ItemRequest<User> me() {
    
        return new ItemRequest<User>(this, User.class, "/users/me", "GET");
    }

    /**
     * Returns the full user record for the single user with the provided ID.
     *
     * @param  user An identifier for the user. Can be one of an email address,
     * the globally unique identifier for the user, or the keyword `me`
     * to indicate the current user making the request.
     * @return Request object
     */
    public ItemRequest<User> findById(String user) {
    
        String path = String.format("/users/%s", user);
        return new ItemRequest<User>(this, User.class, path, "GET");
    }

    /**
     * Returns the user records for all users in the specified workspace or
     * organization.
     *
     * @param  workspace The workspace in which to get users.
     * @return Request object
     */
    public CollectionRequest<User> findByWorkspace(String workspace) {
    
        String path = String.format("/workspaces/%s/users", workspace);
        return new CollectionRequest<User>(this, User.class, path, "GET");
    }

    /**
     * Returns the user records for all users in all workspaces and organizations
     * accessible to the authenticated user. Accepts an optional workspace ID
     * parameter.
     *
     * @return Request object
     */
    public CollectionRequest<User> findAll() {
    
        return new CollectionRequest<User>(this, User.class, "/users", "GET");
    }
}
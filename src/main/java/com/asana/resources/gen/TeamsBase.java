package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.models.Team;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

/**
 * A _team_ is used to group related projects and people together within an
 * organization. Each project in an organization is associated with a team.
 */
public class TeamsBase extends Resource {
    /**
     * @param client Parent client instance
     */
    public TeamsBase(Client client) {
        super(client);
    }

    /**
     * Returns the full record for a single team.
     *
     * @param  team Globally unique identifier for the team.
     * @return Request object
     */
    public ItemRequest<Team> findById(String team) {
    
        String path = String.format("/teams/%s", team);
        return new ItemRequest<Team>(this, Team.class, path, "GET");
    }

    /**
     * Returns the compact records for all teams in the organization visible to
     * the authorized user.
     *
     * @param  organization Globally unique identifier for the workspace or organization.
     * @return Request object
     */
    public CollectionRequest<Team> findByOrganization(String organization) {
    
        String path = String.format("/organizations/%s/teams", organization);
        return new CollectionRequest<Team>(this, Team.class, path, "GET");
    }

    /**
     * Returns the compact records for all teams to which user is assigned.
     *
     * @param  user An identifier for the user. Can be one of an email address,
     * the globally unique identifier for the user, or the keyword `me`
     * to indicate the current user making the request.
     * @return Request object
     */
    public CollectionRequest<Team> findByUser(String user) {
    
        String path = String.format("/users/%s/teams", user);
        return new CollectionRequest<Team>(this, Team.class, path, "GET");
    }

    /**
     * Returns the compact records for all users that are members of the team.
     *
     * @param  team Globally unique identifier for the team.
     * @return Request object
     */
    public CollectionRequest<Team> users(String team) {
    
        String path = String.format("/teams/%s/users", team);
        return new CollectionRequest<Team>(this, Team.class, path, "GET");
    }

    /**
     * The user making this call must be a member of the team in order to add others.
     * The user to add must exist in the same organization as the team in order to be added.
     * The user to add can be referenced by their globally unique user ID or their email address.
     * Returns the full user record for the added user.
     *
     * @param  team Globally unique identifier for the team.
     * @return Request object
     */
    public ItemRequest<Team> addUser(String team) {
    
        String path = String.format("/teams/%s/addUser", team);
        return new ItemRequest<Team>(this, Team.class, path, "POST");
    }

    /**
     * The user to remove can be referenced by their globally unique user ID or their email address.
     * Removes the user from the specified team. Returns an empty data record.
     *
     * @param  team Globally unique identifier for the team.
     * @return Request object
     */
    public ItemRequest<Team> removeUser(String team) {
    
        String path = String.format("/teams/%s/removeUser", team);
        return new ItemRequest<Team>(this, Team.class, path, "POST");
    }
}
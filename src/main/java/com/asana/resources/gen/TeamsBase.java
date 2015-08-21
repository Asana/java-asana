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
     * Returns the compact records for all users that are members of the team.
     *
     * @param  team Globally unique identifier for the team.
     * @return Request object
     */
    public CollectionRequest<Team> users(String team) {
    
        String path = String.format("/teams/%s/users", team);
        return new CollectionRequest<Team>(this, Team.class, path, "GET");
    }
}

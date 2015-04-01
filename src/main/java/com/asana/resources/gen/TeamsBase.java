package com.asana.resources.gen;

import com.asana.Client;
import com.asana.models.Team;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

public class TeamsBase extends Resource
{
    public TeamsBase(Client client)
    {
        super(client);
    }

    public ItemRequest<Team> findById(String team)
    {
        String path = String.format("/teams/%s", team);
        return new ItemRequest<Team>(this, Team.class, path, "GET");
    }

    public CollectionRequest<Team> findByOrganization(String team)
    {
        String path = String.format("/organizations/%s/teams", team);
        return new CollectionRequest<Team>(this, Team.class, path, "GET");
    }

    public CollectionRequest<Team> users(String team)
    {
        String path = String.format("/team/%s/users", team);
        return new CollectionRequest<Team>(this, Team.class, path, "GET");
    }
}

package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.gen.EmptyObject;
import com.asana.models.gen.ErrorResponse;
import com.asana.models.gen.TeamAddUserRequest;
import com.asana.models.gen.TeamCompact;
import com.asana.models.gen.TeamRemoveUserRequest;
import com.asana.models.gen.TeamResponse;
import com.asana.models.gen.UserResponse;
import java.io.IOException;
import java.util.List;

public class TeamsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public TeamsBase(Client client) { super(client); }

    /**
     * Add a user to a team
     * The user making this call must be a member of the team in order to add others. The user being added must exist in the same organization as the team.
     * @param teamGid Globally unique identifier for the team. (required)
     * @param body The user to add to the team. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<UserResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<UserResponse> addUserForTeam(String teamGid, TeamAddUserRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/teams/{team_gid}/addUser".replace("{team_gid}", teamGid);

        ItemRequest<UserResponse> req = new ItemRequest<UserResponse>(this, UserResponse.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<UserResponse> addUserForTeam(String teamGid, TeamAddUserRequest body) throws IOException {
        return addUserForTeam(teamGid, body, null, false);
    }

    /**
     * Get a team
     * Returns the full record for a single team.
     * @param teamGid Globally unique identifier for the team. (required)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<TeamResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<TeamResponse> getTeam(String teamGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/teams/{team_gid}".replace("{team_gid}", teamGid);

        ItemRequest<TeamResponse> req = new ItemRequest<TeamResponse>(this, TeamResponse.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public ItemRequest<TeamResponse> getTeam(String teamGid) throws IOException {
        return getTeam(teamGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Get teams in an organization
     * Returns the compact records for all teams in the organization visible to the authorized user.
     * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<TeamCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<TeamCompact> getTeamsForOrganization(String workspaceGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/organizations/{workspace_gid}/teams".replace("{workspace_gid}", workspaceGid);

        CollectionRequest<TeamCompact> req = new CollectionRequest<TeamCompact>(this, TeamCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<TeamCompact> getTeamsForOrganization(String workspaceGid) throws IOException {
        return getTeamsForOrganization(workspaceGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Get teams for a user
     * Returns the compact records for all teams to which the given user is assigned.
     * @param userGid Globally unique identifier for the user. (required)
     * @param organizationGid The workspace or organization to filter teams on. (required)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<TeamCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<TeamCompact> getTeamsForUser(String userGid, String organizationGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/users/{user_gid}/teams".replace("{user_gid}", userGid);

        CollectionRequest<TeamCompact> req = new CollectionRequest<TeamCompact>(this, TeamCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset)
            .query("organization_gid", organizationGid);

        return req;
    }

    public CollectionRequest<TeamCompact> getTeamsForUser(String userGid, String organizationGid) throws IOException {
        return getTeamsForUser(userGid, organizationGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Remove a user from a team
     * The user making this call must be a member of the team in order to remove themselves or others.
     * @param teamGid Globally unique identifier for the team. (required)
     * @param body The user to remove from the team. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EmptyObject>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EmptyObject> removeUserForTeam(String teamGid, TeamRemoveUserRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/teams/{team_gid}/removeUser".replace("{team_gid}", teamGid);

        ItemRequest<EmptyObject> req = new ItemRequest<EmptyObject>(this, EmptyObject.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<EmptyObject> removeUserForTeam(String teamGid, TeamRemoveUserRequest body) throws IOException {
        return removeUserForTeam(teamGid, body, null, false);
    }

}

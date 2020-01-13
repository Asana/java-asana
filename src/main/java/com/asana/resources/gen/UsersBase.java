package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.gen.AsanaNamedResource;
import com.asana.models.gen.ErrorResponse;
import com.asana.models.gen.UserCompact;
import com.asana.models.gen.UserResponse;
import java.io.IOException;
import java.util.List;

public class UsersBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public UsersBase(Client client) { super(client); }

    /**
     * Get a user&#x27;s favorites
     * Returns all of a user&#x27;s favorites in the given workspace, of the given type. Results are given in order (The same order as Asana&#x27;s sidebar).
     * @param userGid Globally unique identifier for the user. (required)
     * @param resourceType The resource type of favorites to be returned. (required)
     * @param workspace The workspace in which to get favorites. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<AsanaNamedResource>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<AsanaNamedResource> getFavoritesForUser(String userGid, String resourceType, String workspace, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/users/{user_gid}/favorites".replace("{user_gid}", userGid);

        CollectionRequest<AsanaNamedResource> req = new CollectionRequest<AsanaNamedResource>(this, AsanaNamedResource.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("resource_type", resourceType)
            .query("workspace", workspace);

        return req;
    }

    public CollectionRequest<AsanaNamedResource> getFavoritesForUser(String userGid, String resourceType, String workspace) throws IOException {
        return getFavoritesForUser(userGid, resourceType, workspace, null, false);
    }

    /**
     * Get a user
     * Returns the full user record for the single user with the provided ID. Results are sorted by user ID.
     * @param userGid Globally unique identifier for the user. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<UserResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<UserResponse> getUser(String userGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/users/{user_gid}".replace("{user_gid}", userGid);

        ItemRequest<UserResponse> req = new ItemRequest<UserResponse>(this, UserResponse.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<UserResponse> getUser(String userGid) throws IOException {
        return getUser(userGid, null, false);
    }

    /**
     * Get multiple users
     * Returns the user records for all users in all workspaces and organizations accessible to the authenticated user. Accepts an optional workspace ID parameter. Results are sorted by user ID.
     * @param workspace The workspace or organization ID to filter users on. (optional)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<UserCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<UserCompact> getUsers(String workspace, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/users";

        CollectionRequest<UserCompact> req = new CollectionRequest<UserCompact>(this, UserCompact.class, path, "GET")
            .query("workspace", workspace)
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<UserCompact> getUsers(String workspace) throws IOException {
        return getUsers(workspace, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Get users in a team
     * Returns the compact records for all users that are members of the team.
     * @param teamGid Globally unique identifier for the team. (required)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<UserCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<UserCompact> getUsersForTeam(String teamGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/teams/{team_gid}/users".replace("{team_gid}", teamGid);

        CollectionRequest<UserCompact> req = new CollectionRequest<UserCompact>(this, UserCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<UserCompact> getUsersForTeam(String teamGid) throws IOException {
        return getUsersForTeam(teamGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Get users in a workspace or organization
     * Returns the user records for all users in the specified workspace or organization. Results are sorted alphabetically by user names.
     * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<UserCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<UserCompact> getUsersForWorkspace(String workspaceGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/workspaces/{workspace_gid}/users".replace("{workspace_gid}", workspaceGid);

        CollectionRequest<UserCompact> req = new CollectionRequest<UserCompact>(this, UserCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<UserCompact> getUsersForWorkspace(String workspaceGid) throws IOException {
        return getUsersForWorkspace(workspaceGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

}

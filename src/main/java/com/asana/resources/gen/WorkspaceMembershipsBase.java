package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.gen.ErrorResponse;
import com.asana.models.gen.WorkspaceMembershipCompact;
import com.asana.models.gen.WorkspaceMembershipResponse;
import java.io.IOException;
import java.util.List;

public class WorkspaceMembershipsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public WorkspaceMembershipsBase(Client client) { super(client); }

    /**
     * Get a workspace membership
     * Returns the complete workspace record for a single workspace membership.
     * @param workspaceMembershipPathGid  (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<WorkspaceMembershipResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<WorkspaceMembershipResponse> getWorkspaceMembership(String workspaceMembershipPathGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/workspace_memberships/{workspace_membership_gid}".replace("{workspace_membership_path_gid}", workspaceMembershipPathGid);

        ItemRequest<WorkspaceMembershipResponse> req = new ItemRequest<WorkspaceMembershipResponse>(this, WorkspaceMembershipResponse.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<WorkspaceMembershipResponse> getWorkspaceMembership(String workspaceMembershipPathGid) throws IOException {
        return getWorkspaceMembership(workspaceMembershipPathGid, null, false);
    }

    /**
     * Get workspace memberships for a user
     * Returns the compact workspace membership records for the user.
     * @param userGid Globally unique identifier for the user. (required)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<WorkspaceMembershipCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<WorkspaceMembershipCompact> getWorkspaceMembershipsForUser(String userGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/users/{user_gid}/workspace_memberships".replace("{user_gid}", userGid);

        CollectionRequest<WorkspaceMembershipCompact> req = new CollectionRequest<WorkspaceMembershipCompact>(this, WorkspaceMembershipCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<WorkspaceMembershipCompact> getWorkspaceMembershipsForUser(String userGid) throws IOException {
        return getWorkspaceMembershipsForUser(userGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Get the workspace memberships for a workspace
     * Returns the compact workspace membership records for the workspace.
     * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
     * @param user The user to filter results on. (optional)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<WorkspaceMembershipCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<WorkspaceMembershipCompact> getWorkspaceMembershipsForWorkspace(String workspaceGid, String user, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/workspaces/{workspace_gid}/workspace_memberships".replace("{workspace_gid}", workspaceGid);

        CollectionRequest<WorkspaceMembershipCompact> req = new CollectionRequest<WorkspaceMembershipCompact>(this, WorkspaceMembershipCompact.class, path, "GET")
            .query("user", user)
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<WorkspaceMembershipCompact> getWorkspaceMembershipsForWorkspace(String workspaceGid, String user) throws IOException {
        return getWorkspaceMembershipsForWorkspace(workspaceGid, user, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

}

package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.gen.EmptyObject;
import com.asana.models.gen.ErrorResponse;
import com.asana.models.gen.UserResponse;
import com.asana.models.gen.WorkspaceAddUserRequest;
import com.asana.models.gen.WorkspaceCompact;
import com.asana.models.gen.WorkspaceRemoveUserRequest;
import com.asana.models.gen.WorkspaceResponse;
import java.io.IOException;
import java.util.List;

public class WorkspacesBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public WorkspacesBase(Client client) { super(client); }

    /**
     * Add a user to a workspace or organization
     * Add a user to a workspace or organization. The user can be referenced by their globally unique user ID or their email address. Returns the full user record for the invited user.
     * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
     * @param body The user to add to the workspace. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<UserResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<UserResponse> addUserForWorkspace(String workspaceGid, WorkspaceAddUserRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/workspaces/{workspace_gid}/addUser".replace("{workspace_gid}", workspaceGid);

        ItemRequest<UserResponse> req = new ItemRequest<UserResponse>(this, UserResponse.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<UserResponse> addUserForWorkspace(String workspaceGid, WorkspaceAddUserRequest body) throws IOException {
        return addUserForWorkspace(workspaceGid, body, null, false);
    }

    /**
     * Get a workspace
     * Returns the full workspace record for a single workspace.
     * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<WorkspaceResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<WorkspaceResponse> getWorkspace(String workspaceGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/workspaces/{workspace_gid}".replace("{workspace_gid}", workspaceGid);

        ItemRequest<WorkspaceResponse> req = new ItemRequest<WorkspaceResponse>(this, WorkspaceResponse.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<WorkspaceResponse> getWorkspace(String workspaceGid) throws IOException {
        return getWorkspace(workspaceGid, null, false);
    }

    /**
     * Get multiple workspaces
     * Returns the compact records for all workspaces visible to the authorized user.
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<WorkspaceCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<WorkspaceCompact> getWorkspaces(String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/workspaces";

        CollectionRequest<WorkspaceCompact> req = new CollectionRequest<WorkspaceCompact>(this, WorkspaceCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<WorkspaceCompact> getWorkspaces() throws IOException {
        return getWorkspaces(null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Remove a user from a workspace or organization
     * Remove a user from a workspace or organization. The user making this call must be an admin in the workspace. The user can be referenced by their globally unique user ID or their email address. Returns an empty data record.
     * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
     * @param body The user to remove from the workspace. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EmptyObject>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EmptyObject> removeUserForWorkspace(String workspaceGid, WorkspaceRemoveUserRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/workspaces/{workspace_gid}/removeUser".replace("{workspace_gid}", workspaceGid);

        ItemRequest<EmptyObject> req = new ItemRequest<EmptyObject>(this, EmptyObject.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<EmptyObject> removeUserForWorkspace(String workspaceGid, WorkspaceRemoveUserRequest body) throws IOException {
        return removeUserForWorkspace(workspaceGid, body, null, false);
    }

    /**
     * Update a workspace
     * A specific, existing workspace can be updated by making a PUT request on the URL for that workspace. Only the fields provided in the data block will be updated; any unspecified fields will remain unchanged. Currently the only field that can be modified for a workspace is its name. Returns the complete, updated workspace record.
     * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
     * @param body The workspace object with all updated properties. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<WorkspaceResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<WorkspaceResponse> updateWorkspace(String workspaceGid, WorkspaceCompact body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/workspaces/{workspace_gid}".replace("{workspace_gid}", workspaceGid);

        ItemRequest<WorkspaceResponse> req = new ItemRequest<WorkspaceResponse>(this, WorkspaceResponse.class, path, "PUT")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<WorkspaceResponse> updateWorkspace(String workspaceGid, WorkspaceCompact body) throws IOException {
        return updateWorkspace(workspaceGid, body, null, false);
    }

}

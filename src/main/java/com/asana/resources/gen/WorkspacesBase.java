package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.Workspace;
import com.google.gson.JsonElement;

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
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<User>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<User> addUserForWorkspace(String workspaceGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/workspaces/{workspace_gid}/addUser".replace("{workspace_gid}", workspaceGid);

                ItemRequest<User> req = new ItemRequest<User>(this, User.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<User> addUserForWorkspace(String workspaceGid) throws IOException {
                return addUserForWorkspace(workspaceGid, null, false);
            }

            /**
            * Get a workspace
            * Returns the full workspace record for a single workspace.
                * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Workspace>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Workspace> getWorkspace(String workspaceGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/workspaces/{workspace_gid}".replace("{workspace_gid}", workspaceGid);

                ItemRequest<Workspace> req = new ItemRequest<Workspace>(this, Workspace.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Workspace> getWorkspace(String workspaceGid) throws IOException {
                return getWorkspace(workspaceGid, null, false);
            }

            /**
            * Get multiple workspaces
            * Returns the compact records for all workspaces visible to the authorized user.
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Workspace>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Workspace> getWorkspaces(String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/workspaces";

                CollectionRequest<Workspace> req = new CollectionRequest<Workspace>(this, Workspace.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public CollectionRequest<Workspace> getWorkspaces() throws IOException {
                return getWorkspaces(null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Remove a user from a workspace or organization
            * Remove a user from a workspace or organization. The user making this call must be an admin in the workspace. The user can be referenced by their globally unique user ID or their email address. Returns an empty data record.
                * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> removeUserForWorkspace(String workspaceGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/workspaces/{workspace_gid}/removeUser".replace("{workspace_gid}", workspaceGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> removeUserForWorkspace(String workspaceGid) throws IOException {
                return removeUserForWorkspace(workspaceGid, null, false);
            }

            /**
            * Update a workspace
            * A specific, existing workspace can be updated by making a PUT request on the URL for that workspace. Only the fields provided in the data block will be updated; any unspecified fields will remain unchanged. Currently the only field that can be modified for a workspace is its name. Returns the complete, updated workspace record.
                * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Workspace>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Workspace> updateWorkspace(String workspaceGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/workspaces/{workspace_gid}".replace("{workspace_gid}", workspaceGid);

                ItemRequest<Workspace> req = new ItemRequest<Workspace>(this, Workspace.class, path, "PUT")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Workspace> updateWorkspace(String workspaceGid) throws IOException {
                return updateWorkspace(workspaceGid, null, false);
            }

    }

package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.*;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

    public class ProjectsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public ProjectsBase(Client client) { super(client); }

        /**
        * Add a custom field to a project
        * Custom fields are associated with projects by way of custom field settings.  This method creates a setting for the project.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(CustomFieldSetting)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<CustomFieldSetting> addCustomFieldSettingForProject(String projectGid, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}/addCustomFieldSetting".replace("{project_gid}", projectGid);

            ItemRequest<CustomFieldSetting> req = new ItemRequest<CustomFieldSetting>(this, CustomFieldSetting.class, path, "POST")
                .query("opt_pretty", optPretty);

            return req;
        }

        public ItemRequest<CustomFieldSetting> addCustomFieldSettingForProject(String projectGid) throws IOException {
            return addCustomFieldSettingForProject(projectGid, false);
        }
        /**
        * Add followers to a project
        * Adds the specified list of users as followers to the project. Followers are a subset of members who have opted in to receive \&quot;tasks added\&quot;  notifications for a project. Therefore, if the users are not already members of the project, they will also become members as a result of this operation. Returns the updated project record.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> addFollowersForProject(String projectGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}/addFollowers".replace("{project_gid}", projectGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> addFollowersForProject(String projectGid) throws IOException {
            return addFollowersForProject(projectGid, null, false);
        }
        /**
        * Add users to a project
        * Adds the specified list of users as members of the project. Note that a user being added as a member may also be added as a *follower* as a result of this operation. This is because the user&#x27;s default notification settings (i.e., in the \&quot;Notifcations\&quot; tab of \&quot;My Profile Settings\&quot;) will override this endpoint&#x27;s default behavior of setting \&quot;Tasks added\&quot; notifications to &#x60;false&#x60;. Returns the updated project record.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> addMembersForProject(String projectGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}/addMembers".replace("{project_gid}", projectGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> addMembersForProject(String projectGid) throws IOException {
            return addMembersForProject(projectGid, null, false);
        }
        /**
        * Create a project
        * Create a new project in a workspace or team.  Every project is required to be created in a specific workspace or organization, and this cannot be changed once set. Note that you can use the &#x60;workspace&#x60; parameter regardless of whether or not it is an organization.  If the workspace for your project is an organization, you must also supply a &#x60;team&#x60; to share the project with.  Returns the full record of the newly created project.
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(Project)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Project> createProject(List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects";

            ItemRequest<Project> req = new ItemRequest<Project>(this, Project.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<Project> createProject() throws IOException {
            return createProject(null, false);
        }
        /**
        * Create a project in a team
        * Creates a project shared with the given team.  Returns the full record of the newly created project.
            * @param teamGid Globally unique identifier for the team. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(Project)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Project> createProjectForTeam(String teamGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/teams/{team_gid}/projects".replace("{team_gid}", teamGid);

            ItemRequest<Project> req = new ItemRequest<Project>(this, Project.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<Project> createProjectForTeam(String teamGid) throws IOException {
            return createProjectForTeam(teamGid, null, false);
        }
        /**
        * Create a project in a workspace
        * Returns the compact project records for all projects in the workspace.  If the workspace for your project is an organization, you must also supply a team to share the project with.  Returns the full record of the newly created project.
            * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(Project)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Project> createProjectForWorkspace(String workspaceGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/workspaces/{workspace_gid}/projects".replace("{workspace_gid}", workspaceGid);

            ItemRequest<Project> req = new ItemRequest<Project>(this, Project.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<Project> createProjectForWorkspace(String workspaceGid) throws IOException {
            return createProjectForWorkspace(workspaceGid, null, false);
        }
        /**
        * Delete a project
        * A specific, existing project can be deleted by making a DELETE request on the URL for that project.  Returns an empty data record.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> deleteProject(String projectGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}".replace("{project_gid}", projectGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "DELETE")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> deleteProject(String projectGid) throws IOException {
            return deleteProject(projectGid, null, false);
        }
        /**
        * Duplicate a project
        * Creates and returns a job that will asynchronously handle the duplication.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(Job)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Job> duplicateProject(String projectGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}/duplicate".replace("{project_gid}", projectGid);

            ItemRequest<Job> req = new ItemRequest<Job>(this, Job.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<Job> duplicateProject(String projectGid) throws IOException {
            return duplicateProject(projectGid, null, false);
        }
        /**
        * Get a project
        * Returns the complete project record for a single project.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(Project)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Project> getProject(String projectGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}".replace("{project_gid}", projectGid);

            ItemRequest<Project> req = new ItemRequest<Project>(this, Project.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<Project> getProject(String projectGid) throws IOException {
            return getProject(projectGid, null, false);
        }
        /**
        * Get multiple projects
        * Returns the compact project records for some filtered set of projects. Use one or more of the parameters provided to filter the projects returned. *Note: This endpoint may timeout for large domains. Try filtering by team!*
            * @param archived Only return projects whose &#x60;archived&#x60; field takes on the value of this parameter. (optional)
            * @param team The team to filter projects on. (optional)
            * @param workspace The workspace or organization to filter projects on. (optional)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(Project)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<Project> getProjects(Boolean archived, String team, String workspace, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects";

            CollectionRequest<Project> req = new CollectionRequest<Project>(this, Project.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset)
                .query("workspace", workspace)
                .query("team", team)
                .query("archived", archived);

            return req;
        }

        public CollectionRequest<Project> getProjects(Boolean archived, String team, String workspace) throws IOException {
            return getProjects(archived, team, workspace, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Get projects a task is in
        * Returns a compact representation of all of the projects the task is in.
            * @param taskGid The task to operate on. (required)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(Project)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<Project> getProjectsForTask(String taskGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/tasks/{task_gid}/projects".replace("{task_gid}", taskGid);

            CollectionRequest<Project> req = new CollectionRequest<Project>(this, Project.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        public CollectionRequest<Project> getProjectsForTask(String taskGid) throws IOException {
            return getProjectsForTask(taskGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Get a team&#x27;s projects
        * Returns the compact project records for all projects in the team.
            * @param teamGid Globally unique identifier for the team. (required)
            * @param archived Only return projects whose &#x60;archived&#x60; field takes on the value of this parameter. (optional)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(Project)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<Project> getProjectsForTeam(String teamGid, Boolean archived, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/teams/{team_gid}/projects".replace("{team_gid}", teamGid);

            CollectionRequest<Project> req = new CollectionRequest<Project>(this, Project.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset)
                .query("archived", archived);

            return req;
        }

        public CollectionRequest<Project> getProjectsForTeam(String teamGid, Boolean archived) throws IOException {
            return getProjectsForTeam(teamGid, archived, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Get all projects in a workspace
        * Returns the compact project records for all projects in the workspace. *Note: This endpoint may timeout for large domains. Prefer the &#x60;/teams/{team_gid}/projects&#x60; endpoint.*
            * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
            * @param archived Only return projects whose &#x60;archived&#x60; field takes on the value of this parameter. (optional)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(Project)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<Project> getProjectsForWorkspace(String workspaceGid, Boolean archived, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/workspaces/{workspace_gid}/projects".replace("{workspace_gid}", workspaceGid);

            CollectionRequest<Project> req = new CollectionRequest<Project>(this, Project.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset)
                .query("archived", archived);

            return req;
        }

        public CollectionRequest<Project> getProjectsForWorkspace(String workspaceGid, Boolean archived) throws IOException {
            return getProjectsForWorkspace(workspaceGid, archived, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Get task count of a project
        * Get an object that holds task count fields. **All fields are excluded by default**. You must [opt in](/docs/input-output-options) using &#x60;opt_fields&#x60; to get any information from this endpoint.  This endpoint has an additional [rate limit](/docs/standard-rate-limits) and each field counts especially high against our [cost limits](/docs/cost-limits).  Milestones are just tasks, so they are included in the &#x60;num_tasks&#x60;, &#x60;num_incomplete_tasks&#x60;, and &#x60;num_completed_tasks&#x60; counts.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> getTaskCountsForProject(String projectGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}/task_counts".replace("{project_gid}", projectGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        public ItemRequest<JsonElement> getTaskCountsForProject(String projectGid) throws IOException {
            return getTaskCountsForProject(projectGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Remove a custom field from a project
        * Removes a custom field setting from a project.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> removeCustomFieldSettingForProject(String projectGid, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}/removeCustomFieldSetting".replace("{project_gid}", projectGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty);

            return req;
        }

        public ItemRequest<JsonElement> removeCustomFieldSettingForProject(String projectGid) throws IOException {
            return removeCustomFieldSettingForProject(projectGid, false);
        }
        /**
        * Remove followers from a project
        * Removes the specified list of users from following the project, this will not affect project membership status. Returns the updated project record.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> removeFollowersForProject(String projectGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}/removeFollowers".replace("{project_gid}", projectGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> removeFollowersForProject(String projectGid) throws IOException {
            return removeFollowersForProject(projectGid, null, false);
        }
        /**
        * Remove users from a project
        * Removes the specified list of users from members of the project. Returns the updated project record.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> removeMembersForProject(String projectGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}/removeMembers".replace("{project_gid}", projectGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> removeMembersForProject(String projectGid) throws IOException {
            return removeMembersForProject(projectGid, null, false);
        }
        /**
        * Update a project
        * A specific, existing project can be updated by making a PUT request on the URL for that project. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged.  When using this method, it is best to specify only those fields you wish to change, or else you may overwrite changes made by another user since you last retrieved the task.  Returns the complete updated project record.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(Project)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Project> updateProject(String projectGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}".replace("{project_gid}", projectGid);

            ItemRequest<Project> req = new ItemRequest<Project>(this, Project.class, path, "PUT")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<Project> updateProject(String projectGid) throws IOException {
            return updateProject(projectGid, null, false);
        }
    }

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

    public class ProjectStatusesBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public ProjectStatusesBase(Client client) { super(client); }

        /**
        * Create a project status
        * Creates a new status update on the project. Returns the full record of the newly created project status update.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(ProjectStatus)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<ProjectStatus> createProjectStatusForProject(String projectGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}/project_statuses".replace("{project_gid}", projectGid);

            ItemRequest<ProjectStatus> req = new ItemRequest<ProjectStatus>(this, ProjectStatus.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<ProjectStatus> createProjectStatusForProject(String projectGid) throws IOException {
            return createProjectStatusForProject(projectGid, null, false);
        }
        /**
        * Delete a project status
        * Deletes a specific, existing project status update.  Returns an empty data record.
            * @param projectStatusGid The project status update to get. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> deleteProjectStatus(String projectStatusGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/project_statuses/{project_status_gid}".replace("{project_status_gid}", projectStatusGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "DELETE")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> deleteProjectStatus(String projectStatusGid) throws IOException {
            return deleteProjectStatus(projectStatusGid, null, false);
        }
        /**
        * Get a project status
        * Returns the complete record for a single status update.
            * @param projectStatusGid The project status update to get. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(ProjectStatus)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<ProjectStatus> getProjectStatus(String projectStatusGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/project_statuses/{project_status_gid}".replace("{project_status_gid}", projectStatusGid);

            ItemRequest<ProjectStatus> req = new ItemRequest<ProjectStatus>(this, ProjectStatus.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<ProjectStatus> getProjectStatus(String projectStatusGid) throws IOException {
            return getProjectStatus(projectStatusGid, null, false);
        }
        /**
        * Get statuses from a project
        * Returns the compact project status update records for all updates on the project.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(ProjectStatus)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<ProjectStatus> getProjectStatusesForProject(String projectGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}/project_statuses".replace("{project_gid}", projectGid);

            CollectionRequest<ProjectStatus> req = new CollectionRequest<ProjectStatus>(this, ProjectStatus.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        public CollectionRequest<ProjectStatus> getProjectStatusesForProject(String projectGid) throws IOException {
            return getProjectStatusesForProject(projectGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
    }

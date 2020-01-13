package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.gen.EmptyObject;
import com.asana.models.gen.ErrorResponse;
import com.asana.models.gen.ProjectStatusBase;
import com.asana.models.gen.ProjectStatusCompact;
import com.asana.models.gen.ProjectStatusResponse;
import java.io.IOException;
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
     * @param body The project status to create. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<ProjectStatusResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<ProjectStatusResponse> createProjectStatus(String projectGid, ProjectStatusBase body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/projects/{project_gid}/project_statuses".replace("{project_gid}", projectGid);

        ItemRequest<ProjectStatusResponse> req = new ItemRequest<ProjectStatusResponse>(this, ProjectStatusResponse.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<ProjectStatusResponse> createProjectStatus(String projectGid, ProjectStatusBase body) throws IOException {
        return createProjectStatus(projectGid, body, null, false);
    }

    /**
     * Delete a project status
     * Deletes a specific, existing project status update.  Returns an empty data record.
     * @param projectStatusPathGid The project status update to get. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EmptyObject>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EmptyObject> deleteProjectStatus(String projectStatusPathGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/project_statuses/{project_status_gid}".replace("{project_status_path_gid}", projectStatusPathGid);

        ItemRequest<EmptyObject> req = new ItemRequest<EmptyObject>(this, EmptyObject.class, path, "DELETE")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<EmptyObject> deleteProjectStatus(String projectStatusPathGid) throws IOException {
        return deleteProjectStatus(projectStatusPathGid, null, false);
    }

    /**
     * Get a project status
     * Returns the complete record for a single status update.
     * @param projectStatusPathGid The project status update to get. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<ProjectStatusResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<ProjectStatusResponse> getProjectStatus(String projectStatusPathGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/project_statuses/{project_status_gid}".replace("{project_status_path_gid}", projectStatusPathGid);

        ItemRequest<ProjectStatusResponse> req = new ItemRequest<ProjectStatusResponse>(this, ProjectStatusResponse.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<ProjectStatusResponse> getProjectStatus(String projectStatusPathGid) throws IOException {
        return getProjectStatus(projectStatusPathGid, null, false);
    }

    /**
     * Get statuses from a project
     * Returns the compact project status update records for all updates on the project.
     * @param projectGid Globally unique identifier for the project. (required)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<ProjectStatusCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<ProjectStatusCompact> getProjectStatuses(String projectGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/projects/{project_gid}/project_statuses".replace("{project_gid}", projectGid);

        CollectionRequest<ProjectStatusCompact> req = new CollectionRequest<ProjectStatusCompact>(this, ProjectStatusCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<ProjectStatusCompact> getProjectStatuses(String projectGid) throws IOException {
        return getProjectStatuses(projectGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

}

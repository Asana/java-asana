package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.gen.ErrorResponse;
import com.asana.models.gen.ProjectMembershipCompact;
import com.asana.models.gen.ProjectMembershipResponse;
import java.io.IOException;
import java.util.List;

public class ProjectMembershipsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public ProjectMembershipsBase(Client client) { super(client); }

    /**
     * Get a project membership
     * Returns the complete project record for a single project membership.
     * @param projectMembershipPathGid  (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<ProjectMembershipResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<ProjectMembershipResponse> getProjectMembership(String projectMembershipPathGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/project_memberships/{project_membership_gid}".replace("{project_membership_path_gid}", projectMembershipPathGid);

        ItemRequest<ProjectMembershipResponse> req = new ItemRequest<ProjectMembershipResponse>(this, ProjectMembershipResponse.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<ProjectMembershipResponse> getProjectMembership(String projectMembershipPathGid) throws IOException {
        return getProjectMembership(projectMembershipPathGid, null, false);
    }

    /**
     * Get memberships from a project
     * Returns the compact project membership records for the project.
     * @param projectGid Globally unique identifier for the project. (required)
     * @param user The user to filter results on. (optional)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<ProjectMembershipCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<ProjectMembershipCompact> getProjectMembershipsForProject(String projectGid, String user, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/projects/{project_gid}/project_memberships".replace("{project_gid}", projectGid);

        CollectionRequest<ProjectMembershipCompact> req = new CollectionRequest<ProjectMembershipCompact>(this, ProjectMembershipCompact.class, path, "GET")
            .query("user", user)
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<ProjectMembershipCompact> getProjectMembershipsForProject(String projectGid, String user) throws IOException {
        return getProjectMembershipsForProject(projectGid, user, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

}

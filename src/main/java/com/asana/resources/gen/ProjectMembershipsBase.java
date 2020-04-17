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

    public class ProjectMembershipsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public ProjectMembershipsBase(Client client) { super(client); }

        /**
        * Get a project membership
        * Returns the complete project record for a single project membership.
            * @param projectMembershipGid  (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(ProjectMembership)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<ProjectMembership> getProjectMembership(String projectMembershipGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/project_memberships/{project_membership_gid}".replace("{project_membership_gid}", projectMembershipGid);

            ItemRequest<ProjectMembership> req = new ItemRequest<ProjectMembership>(this, ProjectMembership.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<ProjectMembership> getProjectMembership(String projectMembershipGid) throws IOException {
            return getProjectMembership(projectMembershipGid, null, false);
        }
        /**
        * Get memberships from a project
        * Returns the compact project membership records for the project.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param user A string identifying a user. This can either be the string \&quot;me\&quot;, an email, or the gid of a user. (optional)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(ProjectMembership)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<ProjectMembership> getProjectMembershipsForProject(String projectGid, String user, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}/project_memberships".replace("{project_gid}", projectGid);

            CollectionRequest<ProjectMembership> req = new CollectionRequest<ProjectMembership>(this, ProjectMembership.class, path, "GET")
                .query("user", user)
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        public CollectionRequest<ProjectMembership> getProjectMembershipsForProject(String projectGid, String user) throws IOException {
            return getProjectMembershipsForProject(projectGid, user, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
    }

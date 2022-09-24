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

    public class ProjectTemplatesBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public ProjectTemplatesBase(Client client) { super(client); }

        /**
        * Get a project template
        * Returns the complete project template record for a single project template.
        * @param projectTemplateGid Globally unique identifier for the project template. (required)
        * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
        * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> getProjectTemplate(String projectTemplateGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/project_templates/{project_template_gid}".replace("{project_template_gid}", projectTemplateGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        /**
         * Returns the complete project template record for a single project template.
         *
         * @param projectTemplateGid Globally unique identifier for the project template.
         * @return The complete project template record for a single project template.
         * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body.
         */
        public ItemRequest<JsonElement> getProjectTemplate(String projectTemplateGid) throws IOException {
            return getProjectTemplate(projectTemplateGid, null, false);
        }

        /**
        * Get multiple project templates
        * Returns the compact project template records for all project templates in the given team or workspace.
        * @param team The team to filter projects on. (optional)
        * @param workspace The workspace to filter results on. (optional)
        * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
        * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
        * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
        * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<JsonElement> getProjectTemplates(String team, String workspace, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/project_templates";

            CollectionRequest<JsonElement> req = new CollectionRequest<JsonElement>(this, JsonElement.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("workspace", workspace)
                .query("team", team)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        /**
         * Returns the compact project template records for all project templates in the given team or workspace.
         *
         * @param team The team to filter projects on.
         * @param workspace The workspace to filter results on.
         * @return The compact project template records for all project templates in the given team or workspace.
         * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body.
         */
        public CollectionRequest<JsonElement> getProjectTemplates(String team, String workspace) throws IOException {
            return getProjectTemplates(team, workspace, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }

        /**
        * Get a team&#x27;s project templates
        * Returns the compact project template records for all project templates in the team.
        * @param teamGid Globally unique identifier for the team. (required)
        * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
        * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
        * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
        * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<JsonElement> getProjectTemplatesForTeam(String teamGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/teams/{team_gid}/project_templates".replace("{team_gid}", teamGid);

            CollectionRequest<JsonElement> req = new CollectionRequest<JsonElement>(this, JsonElement.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        /**
         * Returns the compact project template records for all project templates in the team.
         *
         * @param teamGid Globally unique identifier for the team.
         * @return The compact project template records for all project templates in the team.
         * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body.
         */
        public CollectionRequest<JsonElement> getProjectTemplatesForTeam(String teamGid) throws IOException {
            return getProjectTemplatesForTeam(teamGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }

        /**
        * Instantiate a project from a project template
        * Creates and returns a job that will asynchronously handle the project instantiation.  _Note: The body of this request will differ if your workspace is an organization. To determine if your workspace is an organization, use the [is_organization](/docs/workspace) parameter._
        * @param projectTemplateGid Globally unique identifier for the project template. (required)
        * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
        * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(Job)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Job> instantiateProject(String projectTemplateGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/project_templates/{project_template_gid}/instantiateProject".replace("{project_template_gid}", projectTemplateGid);

            ItemRequest<Job> req = new ItemRequest<Job>(this, Job.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        /**
         * Creates and returns a job that will asynchronously handle the project instantiation.
         *
         * The body of this request will differ if your workspace is an organization. To determine if your workspace is
         * an organization, test {@link Workspace#isOrganization}.
         *
         * @apiNote To form this request, it is recommended to first make a request to get a project template using the
         * {@link #getProjectTemplate(String)} method or its overloads. Then, from the response, copy the {@code gid}
         * from the object in the {@code requested_dates} array and pass it into this method.
         *
         * @param projectTemplateGid Globally unique identifier for the project template.
         * @return A job that will asynchronously handle the project instantiation.
         * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body.
         */
        public ItemRequest<Job> instantiateProject(String projectTemplateGid) throws IOException {
            return instantiateProject(projectTemplateGid, null, false);
        }

        /**
         * Creates and returns a job that will asynchronously handle the project instantiation.
         *
         * The body of this request will differ if your workspace is an organization. To determine if your workspace is
         * an organization, test {@link Workspace#isOrganization}.
         *
         * @apiNote To form this request, it is recommended to first make a request to get a project template using the
         * {@link #getProjectTemplate(String)} method or its overloads. Then, from the response, copy the {@code gid}
         * from the object in the {@code requested_dates} array and pass it into this method.
         *
         * @param projectTemplateGid Globally unique identifier for the project template.
         * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order
         *                  to conserve resources and complete the request more efficiently. Other times requests return
         *                  more information than you may need. This option allows you to list the exact set of fields
         *                  that the API should be sure to return for the objects. The field names should be provided as
         *                  paths, described below. The id of included objects will always be returned, regardless of
         *                  the field options.
         * @return A job that will asynchronously handle the project instantiation.
         * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body.
         */
        public ItemRequest<Job> instantiateProject(String projectTemplateGid, List<String> optFields) throws IOException {
            return instantiateProject(projectTemplateGid, optFields, false);
        }
    }

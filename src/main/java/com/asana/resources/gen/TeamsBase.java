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

    public class TeamsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public TeamsBase(Client client) { super(client); }

        /**
        * Add a user to a team
        * The user making this call must be a member of the team in order to add others. The user being added must exist in the same organization as the team.
            * @param teamGid Globally unique identifier for the team. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest<User>
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<User> addUserForTeam(String teamGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/teams/{team_gid}/addUser".replace("{team_gid}", teamGid);

            ItemRequest<User> req = new ItemRequest<User>(this, User.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<User> addUserForTeam(String teamGid) throws IOException {
            return addUserForTeam(teamGid, null, false);
        }
        /**
        * Get a team
        * Returns the full record for a single team.
            * @param teamGid Globally unique identifier for the team. (required)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest<Team>
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Team> getTeam(String teamGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/teams/{team_gid}".replace("{team_gid}", teamGid);

            ItemRequest<Team> req = new ItemRequest<Team>(this, Team.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        public ItemRequest<Team> getTeam(String teamGid) throws IOException {
            return getTeam(teamGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Get teams in an organization
        * Returns the compact records for all teams in the organization visible to the authorized user.
            * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest<Team>
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<Team> getTeamsForOrganization(String workspaceGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/organizations/{workspace_gid}/teams".replace("{workspace_gid}", workspaceGid);

            CollectionRequest<Team> req = new CollectionRequest<Team>(this, Team.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        public CollectionRequest<Team> getTeamsForOrganization(String workspaceGid) throws IOException {
            return getTeamsForOrganization(workspaceGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Get teams for a user
        * Returns the compact records for all teams to which the given user is assigned.
            * @param userGid A string identifying a user. This can either be the string \&quot;me\&quot;, an email, or the gid of a user. (required)
            * @param organization The workspace or organization to filter teams on. (required)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest<Team>
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<Team> getTeamsForUser(String userGid, String organization, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/users/{user_gid}/teams".replace("{user_gid}", userGid);

            CollectionRequest<Team> req = new CollectionRequest<Team>(this, Team.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset)
                .query("organization", organization);

            return req;
        }

        public CollectionRequest<Team> getTeamsForUser(String userGid, String organization) throws IOException {
            return getTeamsForUser(userGid, organization, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Remove a user from a team
        * The user making this call must be a member of the team in order to remove themselves or others.
            * @param teamGid Globally unique identifier for the team. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest<JsonElement>
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> removeUserForTeam(String teamGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/teams/{team_gid}/removeUser".replace("{team_gid}", teamGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> removeUserForTeam(String teamGid) throws IOException {
            return removeUserForTeam(teamGid, null, false);
        }
    }

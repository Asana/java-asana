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

    public class GoalsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public GoalsBase(Client client) { super(client); }

        /**
        * Add a collaborator to a goal
        * Adds followers to a goal. Returns the goal the followers were added to. Each goal can be associated with zero or more followers in the system. Requests to add/remove followers, if successful, will return the complete updated goal record, described above.
            * @param goalGid Globally unique identifier for the goal. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> addFollowers(String goalGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goals/{goal_gid}/addFollowers".replace("{goal_gid}", goalGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> addFollowers(String goalGid) throws IOException {
            return addFollowers(goalGid, null, false);
        }
        /**
        * Create a goal
        * Creates a new goal in a workspace or team.  Returns the full record of the newly created goal.
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> createGoal(String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goals";

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        public ItemRequest<JsonElement> createGoal() throws IOException {
            return createGoal(null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Create a goal metric
        * Creates and adds a goal metric to a specified goal. Note that this replaces an existing goal metric if one already exists.
            * @param goalGid Globally unique identifier for the goal. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> createGoalMetric(String goalGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goals/{goal_gid}/setMetric".replace("{goal_gid}", goalGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> createGoalMetric(String goalGid) throws IOException {
            return createGoalMetric(goalGid, null, false);
        }
        /**
        * Delete a goal
        * A specific, existing goal can be deleted by making a DELETE request on the URL for that goal.  Returns an empty data record.
            * @param goalGid Globally unique identifier for the goal. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> deleteGoal(String goalGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goals/{goal_gid}".replace("{goal_gid}", goalGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "DELETE")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> deleteGoal(String goalGid) throws IOException {
            return deleteGoal(goalGid, null, false);
        }
        /**
        * Get a goal
        * Returns the complete goal record for a single goal.
            * @param goalGid Globally unique identifier for the goal. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> getGoal(String goalGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goals/{goal_gid}".replace("{goal_gid}", goalGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> getGoal(String goalGid) throws IOException {
            return getGoal(goalGid, null, false);
        }
        /**
        * Get goals
        * Returns compact goal records.
            * @param timePeriods Globally unique identifiers for the time periods. (optional)
            * @param workspace Globally unique identifier for the workspace. (optional)
            * @param team Globally unique identifier for the team. (optional)
            * @param isWorkspaceLevel Filter to goals with is_workspace_level set to query value. Must be used with the workspace parameter. (optional)
            * @param project Globally unique identifier for supporting project. (optional)
            * @param portfolio Globally unique identifier for supporting portfolio. (optional)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<JsonElement> getGoals(List<String> timePeriods, String workspace, String team, Boolean isWorkspaceLevel, String project, String portfolio, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goals";

            CollectionRequest<JsonElement> req = new CollectionRequest<JsonElement>(this, JsonElement.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset)
                .query("portfolio", portfolio)
                .query("project", project)
                .query("is_workspace_level", isWorkspaceLevel)
                .query("team", team)
                .query("workspace", workspace)
                .query("time_periods", timePeriods);

            return req;
        }

        public CollectionRequest<JsonElement> getGoals(List<String> timePeriods, String workspace, String team, Boolean isWorkspaceLevel, String project, String portfolio) throws IOException {
            return getGoals(timePeriods, workspace, team, isWorkspaceLevel, project, portfolio, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Get parent goals from a goal
        * Returns a compact representation of all of the parent goals of a goal.
            * @param goalGid Globally unique identifier for the goal. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<JsonElement> getParentGoalsForGoal(String goalGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goals/{goal_gid}/parentGoals".replace("{goal_gid}", goalGid);

            CollectionRequest<JsonElement> req = new CollectionRequest<JsonElement>(this, JsonElement.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public CollectionRequest<JsonElement> getParentGoalsForGoal(String goalGid) throws IOException {
            return getParentGoalsForGoal(goalGid, null, false);
        }
        /**
        * Remove a collaborator from a goal
        * Removes followers from a goal. Returns the goal the followers were removed from. Each goal can be associated with zero or more followers in the system. Requests to add/remove followers, if successful, will return the complete updated goal record, described above.
            * @param goalGid Globally unique identifier for the goal. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> removeFollowers(String goalGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goals/{goal_gid}/removeFollowers".replace("{goal_gid}", goalGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> removeFollowers(String goalGid) throws IOException {
            return removeFollowers(goalGid, null, false);
        }
        /**
        * Update a goal
        * An existing goal can be updated by making a PUT request on the URL for that goal. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged.  Returns the complete updated goal record.
            * @param goalGid Globally unique identifier for the goal. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> updateGoal(String goalGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goals/{goal_gid}".replace("{goal_gid}", goalGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "PUT")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> updateGoal(String goalGid) throws IOException {
            return updateGoal(goalGid, null, false);
        }
        /**
        * Update a goal metric
        * Updates a goal&#x27;s existing metric&#x27;s &#x60;current_number_value&#x60; if one exists, otherwise responds with a 400 status code.  Returns the complete updated goal metric record.
            * @param goalGid Globally unique identifier for the goal. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> updateGoalMetric(String goalGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goals/{goal_gid}/setMetricCurrentValue".replace("{goal_gid}", goalGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> updateGoalMetric(String goalGid) throws IOException {
            return updateGoalMetric(goalGid, null, false);
        }
    }

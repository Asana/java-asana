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

    public class GoalRelationshipsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public GoalRelationshipsBase(Client client) { super(client); }

        /**
        * Add a supporting goal relationship
        * Creates a goal relationship by adding a supporting resource to a given goal.  Returns the newly created goal relationship record.
            * @param goalGid Globally unique identifier for the goal. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> addSupportingRelationship(String goalGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goals/{goal_gid}/addSupportingRelationship".replace("{goal_gid}", goalGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> addSupportingRelationship(String goalGid) throws IOException {
            return addSupportingRelationship(goalGid, null, false);
        }
        /**
        * Get a goal relationship
        * Returns the complete updated goal relationship record for a single goal relationship.
            * @param goalRelationshipGid Globally unique identifier for the goal relationship. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> getGoalRelationship(String goalRelationshipGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goal_relationships/{goal_relationship_gid}".replace("{goal_relationship_gid}", goalRelationshipGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> getGoalRelationship(String goalRelationshipGid) throws IOException {
            return getGoalRelationship(goalRelationshipGid, null, false);
        }
        /**
        * Get goal relationships
        * Returns compact goal relationship records.
            * @param resourceSubtype If provided, filter to goal relationships with a given resource_subtype. (optional)
            * @param supportedGoal Globally unique identifier for the supported goal in the goal relationship. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<JsonElement> getGoalRelationships(String resourceSubtype, String supportedGoal, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goal_relationships";

            CollectionRequest<JsonElement> req = new CollectionRequest<JsonElement>(this, JsonElement.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("supported_goal", supportedGoal)
                .query("resource_subtype", resourceSubtype);

            return req;
        }

        public CollectionRequest<JsonElement> getGoalRelationships(String resourceSubtype, String supportedGoal) throws IOException {
            return getGoalRelationships(resourceSubtype, supportedGoal, null, false);
        }
        /**
        * Removes a supporting goal relationship
        * Removes a goal relationship for a given parent goal.
            * @param goalGid Globally unique identifier for the goal. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> removeSupportingRelationship(String goalGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goals/{goal_gid}/removeSupportingRelationship".replace("{goal_gid}", goalGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> removeSupportingRelationship(String goalGid) throws IOException {
            return removeSupportingRelationship(goalGid, null, false);
        }
        /**
        * Update a goal relationship
        * An existing goal relationship can be updated by making a PUT request on the URL for that goal relationship. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged.  Returns the complete updated goal relationship record.
            * @param goalRelationshipGid Globally unique identifier for the goal relationship. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> updateGoalRelationship(String goalRelationshipGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/goal_relationships/{goal_relationship_gid}".replace("{goal_relationship_gid}", goalRelationshipGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "PUT")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> updateGoalRelationship(String goalRelationshipGid) throws IOException {
            return updateGoalRelationship(goalRelationshipGid, null, false);
        }
    }

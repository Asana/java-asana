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

    public class TypeaheadBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public TypeaheadBase(Client client) { super(client); }

        /**
        * Get objects via typeahead
        * Retrieves objects in the workspace based via an auto-completion/typeahead search algorithm. This feature is meant to provide results quickly, so do not rely on this API to provide extremely accurate search results. The result set is limited to a single page of results with a maximum size, so you won’t be able to fetch large numbers of results.  The typeahead search API provides search for objects from a single workspace. This endpoint should be used to query for objects when creating an auto-completion/typeahead search feature. This API is meant to provide results quickly and should not be relied upon for accurate or exhaustive search results. The results sets are limited in size and cannot be paginated.  Queries return a compact representation of each object which is typically the gid and name fields. Interested in a specific set of fields or all of the fields?! Of course you are. Use field selectors to manipulate what data is included in a response.  Resources with type &#x60;user&#x60; are returned in order of most contacted to least contacted. This is determined by task assignments, adding the user to projects, and adding the user as a follower to tasks, messages, etc.  Resources with type &#x60;project&#x60; are returned in order of recency. This is determined when the user visits the project, is added to the project, and completes tasks in the project.  Resources with type &#x60;task&#x60; are returned with priority placed on tasks the user is following, but no guarantee on the order of those tasks.  Leaving the &#x60;query&#x60; string empty or omitted will give you results, still following the resource ordering above. This could be used to list users or projects that are relevant for the requesting user&#x27;s api token.
            * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
            * @param count The number of results to return. The default is 20 if this parameter is omitted, with a minimum of 1 and a maximum of 100. If there are fewer results found than requested, all will be returned. (optional)
            * @param query The string that will be used to search for relevant objects. If an empty string is passed in, the API will currently return an empty result set. (optional)
            * @param type *Deprecated: new integrations should prefer the resource_type field.* (optional)
            * @param resourceType The type of values the typeahead should return. You can choose from one of the following: &#x60;custom_field&#x60;, &#x60;project&#x60;, &#x60;portfolio&#x60;, &#x60;tag&#x60;, &#x60;task&#x60;, and &#x60;user&#x60;. Note that unlike in the names of endpoints, the types listed here are in singular form (e.g. &#x60;task&#x60;). Using multiple types is not yet supported. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<JsonElement> typeaheadForWorkspace(String workspaceGid, Integer count, String query, String type, String resourceType, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/workspaces/{workspace_gid}/typeahead".replace("{workspace_gid}", workspaceGid);

            CollectionRequest<JsonElement> req = new CollectionRequest<JsonElement>(this, JsonElement.class, path, "GET")
                .query("resource_type", resourceType)
                .query("type", type)
                .query("query", query)
                .query("count", count)
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public CollectionRequest<JsonElement> typeaheadForWorkspace(String workspaceGid, Integer count, String query, String type, String resourceType) throws IOException {
            return typeaheadForWorkspace(workspaceGid, count, query, type, resourceType, null, false);
        }
    }

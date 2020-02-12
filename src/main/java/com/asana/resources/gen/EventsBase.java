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

    public class EventsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public EventsBase(Client client) { super(client); }

        /**
        * Get events on a resource
        * Returns the full record for all events that have occurred since the sync token was created.  A GET request to the endpoint /[path_to_resource]/events can be made in lieu of including the resource ID in the data for the request.  *Note: The resource returned will be the resource that triggered the event. This may be different from the one that the events were requested for. For example, a subscription to a project will contain events for tasks contained within the project.*
            * @param sync A sync token received from the last request, or none on first sync. Events will be returned from the point in time that the sync token was generated. *Note: On your first request, omit the sync token. The response will be the same as for an expired sync token, and will include a new valid sync token.If the sync token is too old (which may happen from time to time) the API will return a &#x60;412 Precondition Failed&#x60; error, and include a fresh sync token in the response.* (optional)
            * @param resource A resource ID to subscribe to. The resource can be a task or project. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest<JsonElement>
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<JsonElement> getEvents(String sync, String resource, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/events";

            CollectionRequest<JsonElement> req = new CollectionRequest<JsonElement>(this, JsonElement.class, path, "GET")
                .query("resource", resource)
                .query("sync", sync)
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public CollectionRequest<JsonElement> getEvents(String sync, String resource) throws IOException {
            return getEvents(sync, resource, null, false);
        }
    }

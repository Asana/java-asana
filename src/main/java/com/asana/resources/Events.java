package com.asana.resources;

import com.asana.Client;
import com.asana.models.Event;
import com.asana.requests.EventsRequest;
import com.asana.resources.gen.EventsBase;

public class Events extends EventsBase {
    public Events(Client client) {
        super(client);
    }

    /**
     * Returns any events for the given resource ID since the last sync token
     *
     * @param resource Globally unique identifier for the resource.
     * @param sync     Sync token provided by a previous call to the events API
     * @return Request object
     */
    public EventsRequest<Event> get(String resource, String sync) {
        return new EventsRequest<Event>(this, Event.class, "/events", "GET")
                .query("resource", resource)
                .query("sync", sync);
    }

    /**
     * Returns any events for the given resource ID. Since no sync token is provided calling "execute" or "executeRaw"
     * will raise a InvalidTokenError. Using the request as an iterator will internally fetch a valid sync token first.
     *
     * @param resource Globally unique identifier for the resource.
     * @return Request object
     */
    public EventsRequest<Event> get(String resource) {
        return new EventsRequest<Event>(this, Event.class, "/events", "GET")
                .query("resource", resource);
    }
}

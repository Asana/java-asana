package com.asana.resources;

import com.asana.Client;
import com.asana.models.Event;
import com.asana.requests.EventsRequest;
import com.asana.resources.gen.EventsBase;

public class Events extends EventsBase
{
    public Events(Client client)
    {
        super(client);
    }

    public EventsRequest<Event> get(String resource, String sync)
    {
        return new EventsRequest<Event>(this, Event.class, "/events", "GET")
                .query("resource", resource)
                .query("sync", sync);
    }

    public EventsRequest<Event> get(String resource)
    {
        return new EventsRequest<Event>(this, Event.class, "/events", "GET")
                .query("resource", resource);
    }
}

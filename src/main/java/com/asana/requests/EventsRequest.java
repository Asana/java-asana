package com.asana.requests;

import com.asana.iterator.EventsPageIterator;
import com.asana.resources.Resource;
import com.google.api.client.http.HttpContent;

import java.util.Iterator;
import java.util.Map;

public class EventsRequest<T> extends CollectionRequest<T> implements Iterable<T>
{
    public EventsRequest(Resource resource, Class<T> elementClass, String path, String method)
    {
        super(resource, elementClass, path, method);
    }

    public Iterator<T> iterator()
    {
        return new EventsPageIterator<T>(this).items();
    }

    public EventsRequest<T> query(Map<String, Object> object) { return (EventsRequest<T>)super.query(object); }
    public EventsRequest<T> query(String key, Object value)   { return (EventsRequest<T>)super.query(key, value); }
    public EventsRequest<T> data(HttpContent content)         { return (EventsRequest<T>)super.data(content); }
    public EventsRequest<T> data(Map<String, Object> object)  { return (EventsRequest<T>)super.data(object); }
    public EventsRequest<T> data(String key, Object value)    { return (EventsRequest<T>)super.data(key, value); }
    public EventsRequest<T> option(String key, Object value)  { return (EventsRequest<T>)super.option(key, value); }
}

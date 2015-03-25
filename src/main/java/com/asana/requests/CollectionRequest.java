package com.asana.requests;

import com.asana.models.ResultBodyCollection;
import com.asana.resources.Resource;
import com.google.api.client.http.HttpResponse;
import com.google.common.reflect.TypeParameter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Map;

public class CollectionRequest<T> extends Request
{
    public CollectionRequest(Resource resource, Class<T> elementClass, String path, String method)
    {
        super(resource, elementClass, path, method);
    }

    public Collection<T> execute() throws IOException
    {
        return this.executeRaw().data;
    }

    public ResultBodyCollection<T> executeRaw() throws IOException
    {
        HttpResponse response = this.resource.client.request(this);
        return this.resource.parser.fromJson(
                new InputStreamReader(this.logContent(response.getContent())),
                new com.google.common.reflect.TypeToken<ResultBodyCollection<T>>(){}.where(
                        new TypeParameter<T>(){},
                        this.elementClass
                ).getType()
        );
    }

    public CollectionRequest<T> query(Map<String, Object> object) { return (CollectionRequest<T>)super.query(object); }
    public CollectionRequest<T> query(String key, Object value)   { return (CollectionRequest<T>)super.query(key, value); }
    public CollectionRequest<T> data(Map<String, Object> object)  { return (CollectionRequest<T>)super.data(object); }
    public CollectionRequest<T> data(String key, Object value)    { return (CollectionRequest<T>)super.data(key, value); }
    public CollectionRequest<T> option(String key, Object value)  { return (CollectionRequest<T>)super.option(key, value); }
}

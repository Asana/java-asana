package com.asana.requests;

import com.asana.models.ResultBody;
import com.asana.resources.Resource;
import com.google.api.client.http.HttpResponse;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class ItemRequest<T> extends Request
{
    public ItemRequest(Resource resource, Class<T> elementClass, String path, String method)
    {
        super(resource, elementClass, path, method);
    }

    public T execute() throws IOException
    {
        ResultBody<T> result = this.executeRaw();
        return result.data;
    }

    public ResultBody<T> executeRaw() throws IOException
    {
        HttpResponse response = this.client.request(this);
        return this.client.parser.fromJson(
                new InputStreamReader(this.logContent(response.getContent())),
                new TypeToken<ResultBody<T>>(){}.where(
                        new TypeParameter<T>(){},
                        this.elementClass
                ).getType()
        );
    }

    public ItemRequest<T> query(Map<String, Object> object) { return (ItemRequest<T>)super.query(object); }
    public ItemRequest<T> query(String key, Object value)   { return (ItemRequest<T>)super.query(key, value); }
    public ItemRequest<T> data(Map<String, Object> object)  { return (ItemRequest<T>)super.data(object); }
    public ItemRequest<T> data(String key, Object value)    { return (ItemRequest<T>)super.data(key, value); }
    public ItemRequest<T> option(String key, Object value)  { return (ItemRequest<T>)super.option(key, value); }

}

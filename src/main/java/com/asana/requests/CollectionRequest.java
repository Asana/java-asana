package com.asana.requests;

import com.asana.Json;
import com.asana.iterator.CollectionPageIterator;
import com.asana.models.ResultBodyCollection;
import com.asana.resources.Resource;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpResponse;
import com.google.common.reflect.TypeParameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CollectionRequest<T> extends Request implements Iterable<T> {
    /**
     * @param resource
     * @param elementClass
     * @param path
     * @param method
     */
    public CollectionRequest(Resource resource, Class<T> elementClass, String path, String method) {
        super(resource, elementClass, path, method);
    }

    /**
     * Executes the request, returning the requested list of items
     *
     * @return requested items
     * @throws IOException
     */
    public List<T> execute() throws IOException {
        return this.executeRaw().data;
    }

    /**
     * Executes the request, returning the full response body
     *
     * @return Body containing the "data" object and other metadata
     * @throws IOException
     */
    public ResultBodyCollection<T> executeRaw() throws IOException {
        HttpResponse response = this.client.request(this);
        return Json.getInstance().fromJson(
                new BufferedReader(new InputStreamReader(response.getContent(), StandardCharsets.UTF_8)),
                new com.google.common.reflect.TypeToken<ResultBodyCollection<T>>() {
                }.where(
                        new TypeParameter<T>() {
                        },
                        this.elementClass
                ).getType()
        );
    }

    /**
     * Returns an iterator that will make one or more paginated requests to the API
     *
     * @return Iterator
     */
    public Iterator<T> iterator() {
        return new CollectionPageIterator<T>(this).items();
    }

    public CollectionRequest<T> query(Map<String, Object> object) {
        return (CollectionRequest<T>) super.query(object);
    }

    public CollectionRequest<T> query(String key, Object value) {
        return (CollectionRequest<T>) super.query(key, value);
    }

    public CollectionRequest<T> data(HttpContent content) {
        return (CollectionRequest<T>) super.data(content);
    }

    public CollectionRequest<T> data(Map<String, Object> object) {
        return (CollectionRequest<T>) super.data(object);
    }

    public CollectionRequest<T> data(String key, Object value) {
        return (CollectionRequest<T>) super.data(key, value);
    }

    public CollectionRequest<T> option(String key, Object value) {
        return (CollectionRequest<T>) super.option(key, value);
    }

    public CollectionRequest<T> header(String key, String value) {
        return (CollectionRequest<T>) super.header(key, value);
    }
}

package com.asana.iterator;

import com.asana.models.ResultBodyCollection;
import com.asana.requests.CollectionRequest;

import java.io.IOException;

public class EventsPageIterator<T> extends PageIterator<T>
{
    public EventsPageIterator(CollectionRequest<T> request) {
        super(request);
    }

    @Override
    protected ResultBodyCollection<T> getInitial() throws IOException {
        return null;
    }

    @Override
    protected ResultBodyCollection<T> getNext() throws IOException {
        return null;
    }

    @Override
    protected Object getContinuation(ResultBodyCollection<T> result) {
        return null;
    }
}

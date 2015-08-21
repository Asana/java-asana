package com.asana.iterator;

import com.asana.models.ResultBodyCollection;
import com.asana.requests.CollectionRequest;

import java.io.IOException;

/**
 * Loads a "page" of items from a collection, automatically updating the "offset" based on the "next_page" token on
 * each request.
 */
public class CollectionPageIterator<T> extends PageIterator<T> {
    public CollectionPageIterator(CollectionRequest<T> request) {
        super(request);
    }

    @Override
    protected ResultBodyCollection<T> getNext() throws IOException {
        this.request.query("offset", this.continuation);
        return this.request.executeRaw();
    }

    @Override
    protected Object getContinuation(ResultBodyCollection<T> result) {
        return result.nextPage != null ? result.nextPage.offset : null;
    }
}

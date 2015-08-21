package com.asana.iterator;

import com.asana.errors.InvalidTokenError;
import com.asana.models.ResultBodyCollection;
import com.asana.requests.EventsRequest;

import java.io.IOException;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Loads a "page" of events at a time, automatically updating the sync token on each request
 */
public class EventsPageIterator<T> extends PageIterator<T> {
    public EventsPageIterator(EventsRequest<T> request) {
        super(request);
    }

    @Override
    protected ResultBodyCollection<T> getNext() throws IOException {
        if (request.query.get("sync") == null) {
            try {
                this.request.executeRaw();
            } catch (InvalidTokenError error) {
                this.continuation = error.sync;
            }
        }
        if (this.continuation != "") {
            this.request.query("sync", this.continuation);
        }
        return this.request.executeRaw();
    }

    @Override
    protected Object getContinuation(ResultBodyCollection<T> result) {
        return result.sync;
    }

    @Override
    public Collection<T> next() throws NoSuchElementException {
        while (true) {
            Collection<T> result = super.next();
            if (result.size() > 0) {
                return result;
            } else {
                try {
                    Thread.sleep((Integer) request.options.get("poll_interval") * 1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

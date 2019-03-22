package com.asana.iterator;

import com.asana.models.ResultBodyCollection;
import com.asana.requests.CollectionRequest;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Abstract iterator (implemented by CollectionPageIterator and EventsPageIterator) that loads one page of items at a
 * time, automatically updating the pagination parameter (e.x. the "offset" or "sync" token). Also exposes an
 * "items" iterator to iterate over the individual items.
 */
abstract public class PageIterator<T> implements Iterator<Collection<T>> {
    protected CollectionRequest<T> request;
    private final long itemLimit;
    private final long pageSize;
    private long count;
    protected Object continuation;
    private Collection<T> nextData;
    private IOException ioException;

    public PageIterator(CollectionRequest<T> request) {
        this.request = request;
        this.continuation = "";
        this.count = 0;
        this.pageSize = maxValueIfNullOrNegative((Number) this.request.options.get("page_size"));
        this.itemLimit = maxValueIfNullOrNegative((Number) this.request.options.get("item_limit"));
    }

    private static long maxValueIfNullOrNegative(Number number) {
        long longValue = number == null
            ? Long.MAX_VALUE
            : number.longValue();
        return longValue < 0
            ? Long.MAX_VALUE
            : longValue;
    }

    /**
     * Retrieve the next page and store the continuation token, the new data, and any IOException that may occur.
     *
     * Note that it is safe to pass null values to {@link CollectionRequest#query(String, Object)}. Method
     * {@link com.asana.Client#request(com.asana.requests.Request)} will not include such options.
     */
    private void retrieveNextPage() {
        if (this.pageSize < Long.MAX_VALUE || this.itemLimit < Long.MAX_VALUE) {
            this.request.query("limit", Math.min(this.pageSize, this.itemLimit - this.count));
        } else {
            this.request.query("limit", null);
        }
        ResultBodyCollection<T> page = null;
        try {
            page = this.getNext();
        } catch (IOException exception) {
            // See comments in hasNext().
            this.ioException = exception;
        }
        if (page != null) {
            this.continuation = this.getContinuation(page);
            if (page.data != null && !page.data.isEmpty()) {
                this.count += page.data.size();
                this.nextData = page.data;
            } else {
                this.nextData = null;
            }
        } else {
            this.continuation = null;
            this.nextData = null;
        }
    }

    @Override
    public boolean hasNext() {
        while (nextData == null && ioException == null && this.continuation != null && this.count < this.itemLimit) {
            retrieveNextPage();
        }

        // If an IOException occurred, we return true to indicate another element is available. However, next() will
        // then throw a NoSuchElementException with the IOException as cause. The motivation for this is keeping the
        // public API backwards compatible.
        return nextData != null || ioException != null;
    }

    @Override
    public Collection<T> next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("No more pages through Asana API.");
        } else if (ioException != null) {
            // Wrapping an IOException in a NoSuchElementException is questionable practice, but the API has been this
            // way since commit 23f13ec from 2015-04-03, so we leave the type for API backwards compatibility.
            NoSuchElementException newException
                = new NoSuchElementException("IOException when communicating through Asana API.");
            newException.initCause(ioException);
            throw newException;
        }

        Collection<T> currentData = nextData;
        nextData = null;
        return currentData;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public ItemIterator<T> items() {
        return new ItemIterator<T>(this);
    }

    abstract protected ResultBodyCollection<T> getNext() throws IOException;

    abstract protected Object getContinuation(ResultBodyCollection<T> result);
}

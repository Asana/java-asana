package com.asana.iterator;

import com.asana.models.ResultBodyCollection;
import com.asana.requests.CollectionRequest;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract public class PageIterator<T> implements Iterator<Collection<T>> {
    protected CollectionRequest<T> request;
    protected long itemLimit;
    protected long pageSize;
    protected long count;
    protected Object continuation;

    public PageIterator(CollectionRequest<T> request)
    {
        this.request = request;
        this.continuation = "";
        this.count = 0;
        this.pageSize = (Integer)request.options.get("page_size");
        this.itemLimit = request.options.containsKey("item_limit") ? (Integer)request.options.get("item_limit") : -1;
        if (this.itemLimit <= 0) {
            this.itemLimit = Long.MAX_VALUE;
        }
    }

    private long currentLimit()
    {
        return Math.min(this.pageSize, this.itemLimit - this.count);
    }

    @Override
    public boolean hasNext() {
        return this.continuation != null && currentLimit() > 0;
    }

    @Override
    public Collection<T> next() throws NoSuchElementException {
        this.request.query("limit", currentLimit());
        try {
            ResultBodyCollection<T> result = this.getNext();
            this.continuation = this.getContinuation(result);
            if (result.data != null) {
                this.count += result.data.size();
            }
            return result.data;
        } catch (IOException error) {
            NoSuchElementException newError = new NoSuchElementException();
            newError.initCause(error);
            throw newError;
        }
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    public ItemIterator<T> items()
    {
        return new ItemIterator<T>(this);
    }

    abstract protected ResultBodyCollection<T> getNext() throws IOException;
    abstract protected Object getContinuation(ResultBodyCollection<T> result);
}

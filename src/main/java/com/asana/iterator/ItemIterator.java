package com.asana.iterator;

import java.util.Collection;
import java.util.Iterator;

public class ItemIterator<T> implements Iterator<T>
{
    PageIterator<T> pages;
    Iterator<T> current;

    public ItemIterator(PageIterator<T> pages)
    {
        this.pages = pages;
        this.current = null;
    }

    @Override
    public boolean hasNext()
    {
        return (current != null && current.hasNext()) || pages.hasNext();
    }

    @Override
    public T next()
    {
        if (current == null || !current.hasNext()) {
            current = pages.next().iterator();
        }
        return current.next();
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}

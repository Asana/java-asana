package com.asana;

import static org.junit.Assert.assertEquals;
import com.asana.errors.*;
import com.asana.models.Task;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorTest extends AsanaTest
{
    @Test
    public void testItemIteratorEmpty() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=2").code(200)
                .content("{\"data\": []}");

        Iterator<Task> iter = client.tasks.findByProject("1")
                .option("item_limit", 2).option("page_size", 2)
                .iterator();
        assertEquals(false, iter.hasNext());
    }

    @Test
    public void testItemIteratorItemLimitLessThanItems() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=2").code(200)
                .content("{\"data\": [{\"gid\":1},{\"gid\":2}],\"next_page\": { \"offset\": \"a\", \"path\": \"/projects/1/tasks?limit=2&offset=a\" }}");

        Iterator<Task> iter = client.tasks.findByProject("1")
                .option("item_limit", 2).option("page_size", 2)
                .iterator();
        assertEquals(true, iter.hasNext());
        assertEquals("1", iter.next().gid);
        assertEquals(true, iter.hasNext());
        assertEquals("2", iter.next().gid);
        assertEquals(false, iter.hasNext());
    }

    @Test
    public void testItemIteratorEmptyPage() throws IOException
    {
        // As of March 2019, the public API does not specify whether the backend would ever return an empty page after
        // previously including the "next_page" attribute. In theory, it could be a legitimate response if at the time
        // of the first request there was another page, but at the time of actually requesting the next page all
        // remaining items have meanwhile been removed. In the spirit of loose coupling, it is probably good not to
        // overly rely on backend implementation details and verify this case, too.
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=2").code(200)
                .content("{\"data\": [{\"gid\":1},{\"gid\":2}],\"next_page\": { \"offset\": \"a\", \"path\": \"/projects/1/tasks?limit=2&offset=a\" }}");
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=1&offset=a").code(200)
                .content("{ \"data\": [], \"next_page\": null }");

        Iterator<Task> iter = client.tasks.findByProject("1")
                .option("item_limit", 3).option("page_size", 2)
                .iterator();
        assertEquals(true, iter.hasNext());
        assertEquals("1", iter.next().gid);
        assertEquals(true, iter.hasNext());
        assertEquals("2", iter.next().gid);
        assertEquals(false, iter.hasNext());
    }

    @Test
    public void testItemIteratorItemLimitEqualItems() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=2").code(200)
                .content("{\"data\": [{\"gid\":1},{\"gid\":2}],\"next_page\": { \"offset\": \"a\", \"path\": \"/projects/1/tasks?limit=2&offset=a\" }}");
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=1&offset=a").code(200)
                .content("{ \"data\": [{\"gid\":3}], \"next_page\": null }");

        Iterator<Task> iter = client.tasks.findByProject("1")
                .option("item_limit", 3).option("page_size", 2)
                .iterator();
        assertEquals(true, iter.hasNext());
        assertEquals("1", iter.next().gid);
        assertEquals(true, iter.hasNext());
        assertEquals("2", iter.next().gid);
        assertEquals(true, iter.hasNext());
        assertEquals("3", iter.next().gid);
        assertEquals(false, iter.hasNext());
    }

    @Test
    public void testItemIteratorItemLimitGreaterThanItems() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=2").code(200)
                .content("{\"data\": [{\"gid\":1},{\"gid\":2}],\"next_page\": { \"offset\": \"a\", \"path\": \"/projects/1/tasks?limit=2&offset=a\" }}");
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=2&offset=a").code(200)
                .content("{ \"data\": [{\"gid\":3}], \"next_page\": null }");

        Iterator<Task> iter = client.tasks.findByProject("1")
                .option("item_limit", 4).option("page_size", 2)
                .iterator();
        assertEquals(true, iter.hasNext());
        assertEquals("1", iter.next().gid);
        assertEquals(true, iter.hasNext());
        assertEquals("2", iter.next().gid);
        assertEquals(true, iter.hasNext());
        assertEquals("3", iter.next().gid);
        assertEquals(false, iter.hasNext());
    }

    @Test
    public void testItemIteratorPreserveOptFields() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=2&opt_fields=foo").code(200)
                .content("{\"data\": [{\"gid\":1},{\"gid\":2}],\"next_page\": { \"offset\": \"a\", \"path\": \"/projects/1/tasks?limit=2&offset=a\" }}");
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=1&offset=a&opt_fields=foo").code(200)
                .content("{ \"data\": [{\"gid\":3}], \"next_page\": null }");

        Iterator<Task> iter = client.tasks.findByProject("1")
                .option("fields", Arrays.asList("foo"))
                .option("item_limit", 3).option("page_size", 2)
                .iterator();
        assertEquals(true, iter.hasNext());
        assertEquals("1", iter.next().gid);
        assertEquals(true, iter.hasNext());
        assertEquals("2", iter.next().gid);
        assertEquals(true, iter.hasNext());
        assertEquals("3", iter.next().gid);
        assertEquals(false, iter.hasNext());
    }
}

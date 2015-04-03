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
    public void testItemIteratorItemLimitLessThanItems() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=2").code(200)
                .content("{\"data\": [{\"id\":1},{\"id\":2}],\"next_page\": { \"offset\": \"a\", \"path\": \"/projects/1/tasks?limit=2&offset=a\" }}");

        Iterator<Task> iter = client.tasks.findByProject("1")
                .option("item_limit", 2).option("page_size", 2)
                .iterator();
        assertEquals(true, iter.hasNext());
        assertEquals("1", iter.next().id);
        assertEquals(true, iter.hasNext());
        assertEquals("2", iter.next().id);
        assertEquals(false, iter.hasNext());
    }

    @Test
    public void testItemIteratorItemLimitEqualItems() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=2").code(200)
                .content("{\"data\": [{\"id\":1},{\"id\":2}],\"next_page\": { \"offset\": \"a\", \"path\": \"/projects/1/tasks?limit=2&offset=a\" }}");
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=1&offset=a").code(200)
                .content("{ \"data\": [{\"id\":3}], \"next_page\": null }");

        Iterator<Task> iter = client.tasks.findByProject("1")
                .option("item_limit", 3).option("page_size", 2)
                .iterator();
        assertEquals(true, iter.hasNext());
        assertEquals("1", iter.next().id);
        assertEquals(true, iter.hasNext());
        assertEquals("2", iter.next().id);
        assertEquals(true, iter.hasNext());
        assertEquals("3", iter.next().id);
        assertEquals(false, iter.hasNext());
    }

    @Test
    public void testItemIteratorItemLimitGreaterThanItems() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=2").code(200)
                .content("{\"data\": [{\"id\":1},{\"id\":2}],\"next_page\": { \"offset\": \"a\", \"path\": \"/projects/1/tasks?limit=2&offset=a\" }}");
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=2&offset=a").code(200)
                .content("{ \"data\": [{\"id\":3}], \"next_page\": null }");

        Iterator<Task> iter = client.tasks.findByProject("1")
                .option("item_limit", 4).option("page_size", 2)
                .iterator();
        assertEquals(true, iter.hasNext());
        assertEquals("1", iter.next().id);
        assertEquals(true, iter.hasNext());
        assertEquals("2", iter.next().id);
        assertEquals(true, iter.hasNext());
        assertEquals("3", iter.next().id);
        assertEquals(false, iter.hasNext());
    }

    @Test
    public void testItemIteratorPreserveOptFields() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=2&opt_fields=foo").code(200)
                .content("{\"data\": [{\"id\":1},{\"id\":2}],\"next_page\": { \"offset\": \"a\", \"path\": \"/projects/1/tasks?limit=2&offset=a\" }}");
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=1&offset=a&opt_fields=foo").code(200)
                .content("{ \"data\": [{\"id\":3}], \"next_page\": null }");

        Iterator<Task> iter = client.tasks.findByProject("1")
                .option("fields", Arrays.asList("foo"))
                .option("item_limit", 3).option("page_size", 2)
                .iterator();
        assertEquals(true, iter.hasNext());
        assertEquals("1", iter.next().id);
        assertEquals(true, iter.hasNext());
        assertEquals("2", iter.next().id);
        assertEquals(true, iter.hasNext());
        assertEquals("3", iter.next().id);
        assertEquals(false, iter.hasNext());
    }
}

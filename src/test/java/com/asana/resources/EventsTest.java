package com.asana.resources;

import com.asana.AsanaTest;
import com.asana.errors.InvalidRequestError;
import com.asana.errors.InvalidTokenError;
import com.asana.models.Event;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EventsTest extends AsanaTest
{
    @Test
    public void testEventsGet() throws IOException
    {
        String req = "{ \"data\": [{\"action\":\"a\"}, {\"action\":\"b\"}], \"sync\": \"b\" }";
        dispatcher.registerResponse("GET", "http://app/events?resource=1&sync=a").code(200).content(req);

        List<Event> events = client.events.get("1", "a").execute();
        assertEquals(2, events.size());
        assertEquals("a", events.get(0).action);
        assertEquals("b", events.get(1).action);
    }

    @Test
    public void testEventsGetIterator()
    {
        client.options.put("poll_interval", 0);

        dispatcher.registerResponse("GET", "http://app/events?resource=1&limit=50").code(412)
                .content("{ \"sync\": \"a\" }");
        dispatcher.registerResponse("GET", "http://app/events?resource=1&limit=50&sync=a").code(200)
                .content("{ \"data\": [], \"sync\": \"b\" }");
        dispatcher.registerResponse("GET", "http://app/events?resource=1&limit=50&sync=b").code(200)
                .content("{ \"data\": [{\"action\":\"a\"}, {\"action\":\"b\"}], \"sync\": \"c\" }");
        dispatcher.registerResponse("GET", "http://app/events?resource=1&limit=50&sync=c").code(200)
                .content("{ \"data\": [{\"action\":\"c\"}], \"sync\": \"d\" }");

        Iterator<Event> iterator = client.events.get("1").iterator();
        assertTrue(iterator.hasNext());
        Event event = iterator.next();
        assertEquals("a", event.action);
        assertTrue(iterator.hasNext());
        event = iterator.next();
        assertEquals("b", event.action);
        assertTrue(iterator.hasNext());
        event = iterator.next();
        assertEquals("c", event.action);
        assertTrue(iterator.hasNext());
    }

    @Test(expected=InvalidRequestError.class)
    public void testEventsGetUnknownObject() throws Exception
    {
        dispatcher.registerResponse("GET", "http://app/events?resource=1&sync=a").code(400)
                .content("{ \"sync\": \"b\" }");

        client.events.get("1", "a").execute();
    }

    @Test(expected=InvalidTokenError.class)
    public void testEventsGetInvalidToken() throws Exception
    {
        dispatcher.registerResponse("GET", "http://app/events?resource=1&sync=a").code(412)
                .content("{ \"sync\": \"b\" }");

        client.events.get("1", "a").execute();
    }

    // TODO: is there a way to get an iterator to throw a InvalidRequestError instead of NoSuchElementException?
    @Test(expected=NoSuchElementException.class)
    public void testEventsGetIteratorUnknownObject() throws Exception
    {
        dispatcher.registerResponse("GET", "http://app/events?resource=1&sync=a&limit=50").code(400)
                .content("{ \"sync\": \"b\" }");

        try {
            client.events.get("1", "a").iterator().next();
        } catch (Exception e) {
            assertTrue(e.getCause() instanceof InvalidRequestError);
            throw e;
        }
    }

    // TODO: is there a way to get an iterator to throw a InvalidTokenError instead of NoSuchElementException?
    @Test(expected=NoSuchElementException.class)
    public void testEventsGetIteratorInvalidToken() throws Exception
    {
        dispatcher.registerResponse("GET", "http://app/events?resource=1&limit=50&sync=invalid").code(412)
                .content("{ \"sync\": \"b\" }");

        try {
            client.events.get("1", "invalid").iterator().next();
        } catch (Exception e) {
            assertEquals(e.getCause().getClass(), InvalidTokenError.class);
            throw e;
        }
    }
}

package com.asana;

import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class HeadersTest extends AsanaTest
{
    @Test
    public void testDefaultHeaders() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(200).content("{}");
        client.headers.put("key", "value");
        client.users.me().execute();
        assertEquals(Collections.singletonList("value"), dispatcher.calls.get(0).headers.get("key"));
    }

    @Test
    public void testRequestHeaders() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(200).content("{}");
        client.users.me().header("key", "value").execute();

        assertEquals(Collections.singletonList("value"), dispatcher.calls.get(0).headers.get("key"));
    }

    @Test
    public void testOverridingHeaders() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(200).content("{}");
        client.headers.put("key", "value");
        client.headers.put("key2", "value2");
        client.users.me().header("key2", "value3").execute();

        assertEquals(Collections.singletonList("value"), dispatcher.calls.get(0).headers.get("key"));
        assertEquals(Collections.singletonList("value3"), dispatcher.calls.get(0).headers.get("key2"));
    }
}

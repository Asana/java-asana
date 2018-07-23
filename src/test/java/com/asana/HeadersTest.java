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
        assertEquals(dispatcher.calls.get(0).headers.get("key"), Collections.singletonList("value"));
    }

    @Test
    public void testRequestHeaders() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(200).content("{}");
        client.users.me().header("another_key", "another_value").execute();

        assertEquals(dispatcher.calls.get(0).headers.get("another_key"), Collections.singletonList("another_value"));
    }
}

package com.asana;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import com.asana.errors.ServerError;
import com.asana.models.User;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class RateLimitTest extends AsanaTest
{
    @Test
    public void testClientGet() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(200).content("{ \"data\": { \"name\": \"me\" }}");

        assertEquals("me", client.users.me().execute().name);
    }

    @Test
    public void testRateLimiting() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(429).addHeader("Retry-After", "1.0");
        dispatcher.registerResponse("GET", "http://app/users/me").code(200).content("{ \"data\": { \"name\": \"me\" }}");

        assertEquals("me", client.users.me().execute().name);
        assertEquals(2, dispatcher.calls.size());
        assertEquals(Arrays.asList(1000), dispatcher.sleepCalls);
    }

    @Test
    public void testRateLimitedTwice() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(429).addHeader("Retry-After", "1.0");
        dispatcher.registerResponse("GET", "http://app/users/me").code(429).addHeader("Retry-After", "1.0");
        dispatcher.registerResponse("GET", "http://app/users/me").code(200).content("{ \"data\": { \"name\": \"me\" }}");

        assertEquals("me", client.users.me().execute().name);
        assertEquals(3, dispatcher.calls.size());
        assertEquals(Arrays.asList(1000, 1000), dispatcher.sleepCalls);
    }

    @Test
    public void testServerErrorRetry() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(500);
        dispatcher.registerResponse("GET", "http://app/users/me").code(200).content("{ \"data\": { \"name\": \"me\" }}");

        assertEquals("me", client.users.me().execute().name);
        assertEquals(2, dispatcher.calls.size());
        assertEquals(Arrays.asList(1000), dispatcher.sleepCalls);
    }

    @Test(expected = ServerError.class)
    public void testServerErrorRetryThenFail() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(500);
        dispatcher.registerResponse("GET", "http://app/users/me").code(500);

        client.users.me().option("max_retries", 1).execute();
    }

    @Test
    public void testServerErrorRetryBackoff() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(500);
        dispatcher.registerResponse("GET", "http://app/users/me").code(500);
        dispatcher.registerResponse("GET", "http://app/users/me").code(500);
        dispatcher.registerResponse("GET", "http://app/users/me").code(200).content("{ \"data\": { \"name\": \"me\" }}");

        assertEquals("me", client.users.me().execute().name);
        assertEquals(4, dispatcher.calls.size());
        assertEquals(Arrays.asList(1000, 2000, 4000), dispatcher.sleepCalls);
    }

}

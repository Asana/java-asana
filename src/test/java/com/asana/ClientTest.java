package com.asana;

import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.IOException;

public class ClientTest extends AsanaTest
{
    public ClientTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( ClientTest.class );
    }

    public void testClient() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me", 200, "{ \"data\": { \"name\": \"me\" }}");
        assertEquals(client.users.me().execute().name, "me");
    }
}

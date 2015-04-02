package com.asana;

import com.asana.errors.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ErrorsTest extends AsanaTest
{
    @Test
    public void testNotAuthorized() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(401).content("{ \"errors\": [{ \"message\": \"Not Authorized\" }]}");
        try {
            client.users.me().execute();
        } catch (NoAuthorizationError error) {
            return;
        }
        Assert.fail("expected NoAuthorizationError to be thrown");
    }

    @Test
    public void testInvalidRequest() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(400).content("{ \"errors\": [{ \"message\": \"Missing input\" }] }");
        try {
            client.users.me().execute();
        } catch (InvalidRequestError error) {
            return;
        }
        Assert.fail("expected InvalidRequestError to be thrown");
    }

    @Test
    public void testServerError() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(500).content("{ \"errors\": [ { \"message\": \"Server Error\", \"phrase\": \"6 sad squid snuggle softly\" } ] }");
        try {
            client.users.me().option("max_retries", 0).execute();
        } catch (ServerError error) {
            return;
        }
        Assert.fail("expected ServerError to be thrown");
    }

    @Test
    public void testNotFound() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(404).content("{ \"errors\": [ { \"message\": \"user: Unknown object: 1234\" } ] }");
        try {
            client.users.me().execute();
        } catch (NotFoundError error) {
            return;
        }
        Assert.fail("expected NotFoundError to be thrown");
    }

    @Test
    public void testForbidden() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(403).content("{ \"errors\": [ { \"message\": \"user: Forbidden\" } ] }");
        try {
            client.users.me().execute();
        } catch (ForbiddenError error) {
            return;
        }
        Assert.fail("expected ForbiddenError to be thrown");
    }
}

package com.asana;

import com.asana.errors.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ErrorsTest extends AsanaTest
{
    @Test(expected = NoAuthorizationError.class)
    public void testNotAuthorized() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(401).content("{ \"errors\": [{ \"message\": \"Not Authorized\" }]}");

        client.users.me().execute();
    }

    @Test(expected = InvalidRequestError.class)
    public void testInvalidRequest() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(400).content("{ \"errors\": [{ \"message\": \"Missing input\" }] }");

        client.users.me().execute();
    }

    @Test(expected = ServerError.class)
    public void testServerError() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(500).content("{ \"errors\": [ { \"message\": \"Server Error\", \"phrase\": \"6 sad squid snuggle softly\" } ] }");

        client.users.me().option("max_retries", 0).execute();
    }

    @Test(expected = NotFoundError.class)
    public void testNotFound() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(404).content("{ \"errors\": [ { \"message\": \"user: Unknown object: 1234\" } ] }");

        client.users.me().execute();
    }

    @Test(expected = ForbiddenError.class)
    public void testForbidden() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(403).content("{ \"errors\": [ { \"message\": \"user: Forbidden\" } ] }");

        client.users.me().execute();
    }

    @Test(expected = PremiumOnlyError.class)
    public void testPremiumOnlyError402() throws IOException
    {
        // Handles actual 402 errors
        dispatcher.registerResponse("GET", "http://app/users/me").code(402).content(
              "{ \"errors\": [ { \"message\": \"Custom Fields are not available for free users or guests.\" } ] }");

        client.users.me().execute();
    }

    @Test(expected = PremiumOnlyError.class)
    public void testPremiumOnlyError403() throws IOException
    {
        // Handles 403 errors with a premium message
        dispatcher.registerResponse("GET", "http://app/users/me").code(403).content(
              "{ \"errors\": [ { \"message\": \"Custom Fields are not available for free users or guests.\" } ] }");

        client.users.me().execute();
    }
}

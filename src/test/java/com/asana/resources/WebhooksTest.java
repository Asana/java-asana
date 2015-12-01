package com.asana.resources;

import com.asana.AsanaTest;
import com.asana.models.Webhook;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class WebhooksTest extends AsanaTest
{
    private final static String RESPONSE =
            "{" +
            "    \"id\": 222," +
            "    \"resource\": {" +
            "        \"id\": 111," +
            "        \"name\": \"the resource\"" +
            "    }," +
            "    \"target\": \"https://foo/123\"," +
            "    \"active\": true" +
            "}";

    private void verifyResponse(Webhook w) {
        assertTrue(w.active);
        assertEquals("https://foo/123", w.target);
        assertEquals("222", w.id);
        assertEquals("111", w.resource.id);
        assertEquals("the resource", w.resource.name);
    }

    @Test
    public void testWebhooksCreate() throws IOException
    {
        final String response = "{\"data\": " + RESPONSE + "}";
        dispatcher.registerResponse("POST", "http://app/webhooks").code(200).content(response);
        verifyResponse(client.webhooks.create().data("resource", 111).data("target", "https://foo/123").execute());
    }

    @Test
    public void testWebhooksGetAll() throws IOException
    {
        final String response = "{\"data\": [" + RESPONSE + "]}";
        dispatcher.registerResponse("GET", "http://app/webhooks?limit=50&workspace=1337").code(200).content(response);
        final Iterator<Webhook> i = client.webhooks.getAll().query("workspace", 1337).iterator();
        assertTrue(i.hasNext());
        verifyResponse(i.next());
        assertFalse(i.hasNext());
    }

    @Test
    public void testWebhooksGetById() throws IOException
    {
        final String response = "{\"data\": " + RESPONSE + "}";
        dispatcher.registerResponse("GET", "http://app/webhooks/222").code(200).content(response);
        verifyResponse(client.webhooks.getById("222").execute());
    }

    @Test
    public void testWebhooksDeleteById() throws IOException
    {
        dispatcher.registerResponse("DELETE", "http://app/webhooks/222").code(200).content("{\"data\": {}}");
        final Webhook w = client.webhooks.deleteById("222").execute();
        assertEquals(null, w.id);
    }

}

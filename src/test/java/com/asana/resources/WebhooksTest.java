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
            "    \"gid\": 222," +
            "    \"resource\": {" +
            "        \"gid\": 111," +
            "        \"name\": \"the resource\"" +
            "    }," +
            "    \"target\": \"https://foo/123\"," +
            "    \"active\": true" +
            "}";

    private void verifyResponse(Webhook w) {
        assertTrue(w.active);
        assertEquals("https://foo/123", w.target);
        assertEquals("222", w.gid);
        assertEquals("111", w.resource.gid);
        assertEquals("the resource", w.resource.name);
    }

    @Test
    public void testWebhooksCreate() throws IOException
    {
        final String response = "{\"data\": " + RESPONSE + "}";
        dispatcher.registerResponse("POST", "http://app/webhooks?opt_pretty=false").code(200).content(response);
        verifyResponse(client.webhooks.createWebhook().data("resource", 111).data("target", "https://foo/123").execute());
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
    public void testWebhooksGetWebhook() throws IOException
    {
        final String response = "{\"data\": " + RESPONSE + "}";
        dispatcher.registerResponse("GET", "http://app/webhooks/222?opt_pretty=false").code(200).content(response);
        verifyResponse(client.webhooks.getWebhook("222").execute());
    }

    @Test
    public void testWebhooksDeleteWebhook() throws IOException
    {
        dispatcher.registerResponse("DELETE", "http://app/webhooks/222?opt_pretty=false").code(200).content("{\"data\": {}}");
        assertEquals(null, client.webhooks.deleteWebhook("222", null, false).execute().getAsJsonObject().get("gid"));
    }

}

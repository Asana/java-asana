package com.asana;

import static org.junit.Assert.assertEquals;

import com.asana.errors.*;
import com.asana.models.Task;
import com.google.gson.JsonElement;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class ClientTest extends AsanaTest {
    @Test
    public void testClientGet() throws IOException {
        dispatcher.registerResponse("GET", "http://app/users/me", 200, "{ \"data\": { \"name\": \"me\" }}");
        assertEquals(client.users.me().execute().name, "me");
    }

    @Test
    public void testGetNamedParameters() throws IOException {
        dispatcher.registerResponse("GET", "http://app/tasks?workspace=14916&assignee=me", 200, "{ \"data\": [{ \"id\": \"1\" }]}");

        Collection<Task> result = client.tasks.findAll()
                .query("workspace", "14916")
                .query("assignee", "me")
                .execute();
        assertEquals(result.iterator().next().id, "1");
    }

    @Test
    public void testPostNamedParameters() throws IOException {
        JsonElement req = parser.parse("{ \"data\": { \"assignee\": \"1235\", \"followers\": [\"5678\"],\"name\": \"Hello, world.\"}}");
        dispatcher.registerResponse("POST", "http://app/tasks", 201, "{ \"data\": { \"id\": \"1\" }}");

        Task result = client.tasks.create()
                .data("assignee", "1235")
                .data("followers", Arrays.asList("5678"))
                .data("name", "Hello, world.")
                .execute();
        assertEquals(result.id, "1");
        assertEquals(dispatcher.calls.get(0).parsedRequestBody, req);
    }

    @Test
    public void testPutNamedParameters() throws IOException {
        JsonElement req = parser.parse("{ \"data\": {\"assignee\": \"1235\", \"followers\": [\"5678\"],\"name\": \"Hello, world.\"}}");
        dispatcher.registerResponse("PUT", "http://app/tasks/1001", 200, "{ \"data\": { \"id\": \"1\" }}");

        Task result = client.tasks.update("1001")
                .data("assignee", "1235")
                .data("followers", Arrays.asList("5678"))
                .data("name", "Hello, world.")
                .execute();
        assertEquals(result.id, "1");
        assertEquals(dispatcher.calls.get(0).parsedRequestBody, req);
    }
}
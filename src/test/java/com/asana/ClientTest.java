package com.asana;

import com.asana.models.ResultBodyCollection;
import com.asana.models.Task;
import com.google.gson.JsonElement;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ClientTest extends AsanaTest
{
    @Test
    public void testClientGet() throws IOException {
        dispatcher.registerResponse("GET", "http://app/users/me").code(200).content("{ \"data\": { \"name\": \"me\" }}");
        assertEquals(client.users.me().execute().name, "me");
    }

    @Test
    public void testGetNamedParameters() throws IOException {
        dispatcher.registerResponse("GET", "http://app/tasks?workspace=14916&assignee=me").code(200).content("{ \"data\": [{ \"id\": \"1\" }]}");

        Collection<Task> result = client.tasks.findAll()
                .query("workspace", "14916")
                .query("assignee", "me")
                .execute();
        assertEquals(result.iterator().next().id, "1");
    }

    @Test
    public void testPostNamedParameters() throws IOException {
        JsonElement req = parser.parse("{ \"data\": { \"assignee\": \"1235\", \"followers\": [\"5678\"],\"name\": \"Hello, world.\"}}");

        dispatcher.registerResponse("POST", "http://app/tasks").code(201).content("{ \"data\": { \"id\": \"1\" }}");

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

        dispatcher.registerResponse("PUT", "http://app/tasks/1001").code(200).content("{ \"data\": { \"id\": \"1\" }}");

        Task result = client.tasks.update("1001")
                .data("assignee", "1235")
                .data("followers", Arrays.asList("5678"))
                .data("name", "Hello, world.")
                .execute();
        assertEquals(result.id, "1");
        assertEquals(dispatcher.calls.get(0).parsedRequestBody, req);
    }

    @Test
    public void testPagination() throws IOException
    {
        String req = "{ \"data\": [ { \"id\": 1 }],\"next_page\": {\"offset\": \"b\",\"path\": \"/tasks?project=1&limit=5&offset=b\",\"uri\": \"https://app.asana.com/api/1.0/tasks?project=1&limit=5&offset=b\"}}";
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=5&offset=a").code(200).content(req);

        ResultBodyCollection<Task> result = client.tasks.findByProject("1")
                .option("limit", 5).option("offset", "a")
                .executeRaw();

        assertEquals("1", result.data.get(0).id);
        assertEquals("b", result.nextPage.offset);
        assertEquals("/tasks?project=1&limit=5&offset=b", result.nextPage.path);
        assertEquals("https://app.asana.com/api/1.0/tasks?project=1&limit=5&offset=b", result.nextPage.uri);
    }
}

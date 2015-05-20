package com.asana;

import com.asana.models.ResultBodyCollection;
import com.asana.models.Task;
import com.google.gson.JsonElement;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClientTest extends AsanaTest
{
    @Test
    public void testClientGet() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me").code(200).content("{ \"data\": { \"name\": \"me\" }}");
        assertEquals(client.users.me().execute().name, "me");
    }

    @Test
    public void testClientGetCollectionList() throws IOException
    {
        String req = "{ \"data\": [ { \"id\": 1 } ]}";
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks").code(200).content(req);

        List<Task> tasks = client.tasks.findByProject("1").execute();
        assertEquals(tasks.size(), 1);
        assertEquals(tasks.get(0).id, "1");
    }

    @Test
    public void testClientGetCollectionIterator() throws IOException
    {
        String req = "{ \"data\": [ { \"id\": 1 } ]}";
        dispatcher.registerResponse("GET", "http://app/projects/1/tasks?limit=50").code(200).content(req);

        Iterator<Task> tasks = client.tasks.findByProject("1").iterator();
        assertEquals(tasks.hasNext(), true);
        assertEquals(tasks.next().id, "1");
        assertEquals(tasks.hasNext(), false);
    }

    @Test
    public void testClientPost() throws IOException
    {
        dispatcher.registerResponse("POST", "http://app/tasks").code(201).content("{ \"data\": { \"id\": \"1\" }}");

        assertEquals(client.tasks.create().execute().id, "1");
    }

    @Test
    public void testClientPut() throws IOException
    {
        dispatcher.registerResponse("PUT", "http://app/tasks/1").code(200).content("{ \"data\": { \"id\": \"1\" }}");

        assertEquals(client.tasks.update("1").execute().id, "1");
    }

    @Test
    public void testClientDelete() throws IOException
    {
        dispatcher.registerResponse("DELETE", "http://app/tasks/1").code(200).content("{ \"data\": { \"id\": \"1\" }}");

        assertEquals(client.tasks.delete("1").execute().id, "1");
    }

    @Test
    public void testGetNamedParameters() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/tasks?workspace=14916&assignee=me").code(200).content("{ \"data\": [{ \"id\": \"1\" }]}");

        Collection<Task> result = client.tasks.findAll()
                .query("workspace", "14916")
                .query("assignee", "me")
                .execute();
        assertEquals(result.iterator().next().id, "1");
    }

    @Test
    public void testPostNamedParameters() throws IOException
    {
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
    public void testPutNamedParameters() throws IOException
    {
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

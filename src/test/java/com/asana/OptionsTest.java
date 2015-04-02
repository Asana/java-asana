package com.asana;

import static org.junit.Assert.assertEquals;

import com.asana.models.Task;
import com.asana.models.User;
import com.google.gson.JsonElement;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class OptionsTest extends AsanaTest
{
    @Test
    public void testOptionPretty() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me?opt_pretty=true").code(200).content("{ \"data\": { \"name\": \"me\" } }");
        User user = client.users.me()
                .option("pretty", true)
                .execute();
        assertEquals(user.name, "me");
    }

    @Test
    public void testOptionPrettyPOST() throws IOException
    {
        dispatcher.registerResponse("POST", "http://app/tasks").code(200).content("{ \"data\": { \"name\": \"task\" } }");
        Task task = client.tasks.create()
                .option("pretty", true)
                .execute();
        assertEquals(task.name, "task");
        assertEquals(dispatcher.calls.get(0).requestBody, "{\"data\":{},\"options\":{\"pretty\":true}}");
    }

    @Test
    public void testOptionFields() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/me?opt_fields=name,notes").code(200).content("{ \"data\": { \"name\": \"me\" } }");
        User user = client.users.me()
                .option("fields", Arrays.asList("name", "notes"))
                .execute();
        assertEquals(user.name, "me");
    }

    @Test
    public void testOptionFieldsPOST() throws IOException
    {
        JsonElement req = parser.parse("{\"data\":{},\"options\":{\"fields\":[\"name\",\"notes\"]}}");

        dispatcher.registerResponse("POST", "http://app/tasks").code(200).content("{ \"data\": { \"name\": \"task\" } }");
        Task task = client.tasks.create()
                .option("fields", Arrays.asList("name", "notes"))
                .execute();
        assertEquals(task.name, "task");
        assertEquals(dispatcher.calls.get(0).parsedRequestBody, req);
    }

    @Test
    public void testOptionExpand() throws IOException
    {
        JsonElement req = parser.parse("{\"data\":{\"assignee\":\"1234\"},\"options\":{\"expand\":[\"projects\"]}}");

        dispatcher.registerResponse("PUT", "http://app/tasks/1001").code(200).content("{ \"data\": { \"name\": \"me\" } }");
        Task task = client.tasks.update("1001")
                .data("assignee", "1234")
                .option("expand", Arrays.asList("projects"))
                .execute();
        assertEquals(task.name, "me");
        assertEquals(dispatcher.calls.get(0).parsedRequestBody, req);
    }
}

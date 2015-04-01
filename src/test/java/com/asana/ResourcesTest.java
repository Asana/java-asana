package com.asana;

import com.asana.resources.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ResourcesTest extends AsanaTest
{
    @Test
    public void testAttachmentsFindById() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/attachments/1", 200, "{ \"data\": { \"name\": \"name\" }}");
        assertEquals(client.attachments.findById("1").execute().name, "name");
    }

    @Test
    public void testProjectsFindById() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/projects/1", 200, "{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.projects.findById("1").execute().id, "1");
    }

    @Test
    public void testStoriesFindById() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/stories/1", 200, "{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.stories.findById("1").execute().id, "1");
    }

    @Test
    public void testTagsFindById() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/tags/1", 200, "{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.tags.findById("1").execute().id, "1");
    }

    @Test
    public void testTasksFindById() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/tasks/1", 200, "{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.tasks.findById("1").execute().id, "1");
    }

    @Test
    public void testTeamsFindById() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/teams/1", 200, "{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.teams.findById("1").execute().id, "1");
    }

    @Test
    public void testUsersFindById() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/users/1", 200, "{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.users.findById("1").execute().id, "1");
    }

    @Test
    public void testWorkspacesFindById() throws IOException
    {
        dispatcher.registerResponse("GET", "http://app/workspaces/1", 200, "{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.workspaces.findById("1").execute().id, "1");
    }
}

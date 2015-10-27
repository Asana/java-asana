package com.asana;

import com.asana.models.Task;
import com.google.api.client.util.DateTime;
import com.google.common.io.Resources;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ResourcesTest extends AsanaTest {
    @Test
    public void testAttachmentsFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/attachments/1").code(200).content("{ \"data\": { \"name\": \"name\" }}");
        assertEquals(client.attachments.findById("1").execute().name, "name");
    }

    @Test
    public void testProjectsFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/projects/1").code(200).content("{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.projects.findById("1").execute().id, "1");
    }

    @Test
    public void testStoriesFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/stories/1").code(200).content("{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.stories.findById("1").execute().id, "1");
    }

    @Test
    public void testTagsFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/tags/1").code(200).content("{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.tags.findById("1").execute().id, "1");
    }

    @Test
    public void testTasksFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/tasks/1").code(200).content("{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.tasks.findById("1").execute().id, "1");
    }

    @Test
    public void testTeamsFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/teams/1").code(200).content("{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.teams.findById("1").execute().id, "1");
    }

    @Test
    public void testUsersFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/users/1").code(200).content("{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.users.findById("1").execute().id, "1");
    }

    @Test
    public void testWorkspacesFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/workspaces/1").code(200).content("{ \"data\": { \"id\": \"1\" }}");
        assertEquals(client.workspaces.findById("1").execute().id, "1");
    }

    @Test
    public void testParseTaskWithDateFields() throws IOException {
        String taskContent = IOUtils.toString(new FileInputStream(Resources.getResource("taskWithDueAt.json").getFile()));
        dispatcher.registerResponse("GET", "http://app/tasks/1").code(200).content(taskContent);
        Task task = client.tasks.findById("1").execute();

        assertEquals("task.dueOn", "2015-10-05", task.dueOn.toString());
        assertEquals("task.dueAt", "2015-10-05T16:30:00.000Z", task.dueAt.toString());
        assertEquals("task.createdAt", "2015-09-11T22:51:12.643Z", task.createdAt.toString());
    }
}

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
        assertEquals("name", client.attachments.findById("1").execute().name);
    }

    @Test
    public void testProjectsFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/projects/1").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.projects.findById("1").execute().gid);
    }

    @Test
    public void testStoriesFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/stories/1").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.stories.findById("1").execute().gid);
    }

    @Test
    public void testTagsFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/tags/1").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.tags.findById("1").execute().gid);
    }

    @Test
    public void testTasksFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/tasks/1").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.tasks.findById("1").execute().gid);
    }

    @Test
    public void testTeamsFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/teams/1").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.teams.findById("1").execute().gid);
    }

    @Test
    public void testUsersFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/users/1").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.users.findById("1").execute().gid);
    }

    @Test
    public void testWorkspacesFindById() throws IOException {
        dispatcher.registerResponse("GET", "http://app/workspaces/1").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.workspaces.findById("1").execute().gid);
    }

    @Test
    public void testParseTaskWithDateFields() throws IOException {
        String taskContent = IOUtils.toString(new FileInputStream(Resources.getResource("taskWithDueAt.json").getFile()));
        dispatcher.registerResponse("GET", "http://app/tasks/1").code(200).content(taskContent);
        Task task = client.tasks.findById("1").execute();

        assertEquals("task.dueOn", task.dueOn.toString(), "2015-10-05");
        assertEquals("task.dueAt", task.dueAt.toString(), "2015-10-05T16:30:00.000Z");
        assertEquals("task.createdAt", task.createdAt.toString(), "2015-09-11T22:51:12.643Z");
    }
}

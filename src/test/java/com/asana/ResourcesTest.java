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
    public void testAttachmentsGetAttachment() throws IOException {
        dispatcher.registerResponse("GET", "http://app/attachments/1?opt_pretty=false").code(200).content("{ \"data\": { \"name\": \"name\" }}");
        assertEquals("name", client.attachments.getAttachment("1").execute().name);
    }

    @Test
    public void testJobsGetJob() throws IOException {
        dispatcher.registerResponse("GET", "http://app/jobs/1?opt_pretty=false").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.jobs.getJob("1").execute().gid);
    }

    @Test
    public void testPortfoliosGetPortfolio() throws IOException {
        dispatcher.registerResponse("GET", "http://app/portfolios/1?opt_pretty=false").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.portfolios.getPortfolio("1").execute().gid);
    }

    @Test
    public void testProjectsGetProject() throws IOException {
        dispatcher.registerResponse("GET", "http://app/projects/1?opt_pretty=false").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.projects.getProject("1").execute().gid);
    }

    @Test
    public void testPortfolioMembershipsGetPortfolioMembership() throws IOException {
        dispatcher.registerResponse("GET", "http://app/portfolio_memberships/1?opt_pretty=false").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        System.out.println(client.toString());
        System.out.println(client.portfolioMemberships);
        System.out.println(client.portfolioMemberships.getPortfolioMembership("1"));
        assertEquals("1", client.portfolioMemberships.getPortfolioMembership("1").execute().gid);
    }

    @Test
    public void testProjectMembershipsGetProjectMembership() throws IOException {
        dispatcher.registerResponse("GET", "http://app/project_memberships/1?opt_pretty=false").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.projectMemberships.getProjectMembership("1").execute().gid);
    }

    @Test
    public void testStoriesGetStory() throws IOException {
        dispatcher.registerResponse("GET", "http://app/stories/1?limit=50&opt_pretty=false").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.stories.getStory("1").execute().gid);
    }

    @Test
    public void testTagsGetTag() throws IOException {
        dispatcher.registerResponse("GET", "http://app/tags/1?limit=50&opt_pretty=false").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.tags.getTag("1").execute().gid);
    }

    @Test
    public void testTasksGetTask() throws IOException {
        dispatcher.registerResponse("GET", "http://app/tasks/1?opt_pretty=false").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.tasks.getTask("1").execute().gid);
    }

    @Test
    public void testTeamsGetTeam() throws IOException {
        dispatcher.registerResponse("GET", "http://app/teams/1?limit=50&opt_pretty=false").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.teams.getTeam("1").execute().gid);
    }

    @Test
    public void testUsersGetUser() throws IOException {
        dispatcher.registerResponse("GET", "http://app/users/1?opt_pretty=false").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.users.getUser("1").execute().gid);
    }

    @Test
    public void testUserTaskListsGetUserTaskList() throws IOException {
        dispatcher.registerResponse("GET", "http://app/user_task_lists/1?opt_pretty=false").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.userTaskLists.getUserTaskList("1").execute().gid);
    }

    @Test
    public void testWorkspacesGetWorkspace() throws IOException {
        dispatcher.registerResponse("GET", "http://app/workspaces/1?opt_pretty=false").code(200).content("{ \"data\": { \"gid\": \"1\" }}");
        assertEquals("1", client.workspaces.getWorkspace("1").execute().gid);
    }

    @Test
    public void testParseTaskWithDateFields() throws IOException {
        String taskContent = IOUtils.toString(new FileInputStream(Resources.getResource("taskWithDueAt.json").getFile()));
        dispatcher.registerResponse("GET", "http://app/tasks/1?opt_pretty=false").code(200).content(taskContent);
        Task task = client.tasks.getTask("1").execute();

        assertEquals("task.dueOn", task.dueOn.toString(), "2015-10-05");
        assertEquals("task.dueAt", task.dueAt.toString(), "2015-10-05T16:30:00.000Z");
        assertEquals("task.createdAt", task.createdAt.toString(), "2015-09-11T22:51:12.643Z");
    }
}

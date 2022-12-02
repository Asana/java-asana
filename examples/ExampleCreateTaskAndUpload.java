package com.asana.examples;

import com.asana.Client;
import com.asana.models.Attachment;
import com.asana.models.Project;
import com.asana.models.Task;
import com.asana.models.Workspace;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * PAT Instructions:
 * <p>
 * 1. set your ASANA_ACCESS_TOKEN environment variable to a personal access token
 */
public class ExampleCreateTaskAndUpload {

    public static void main(String[] args) throws Exception {
        if (System.getenv("ASANA_ACCESS_TOKEN") == null) {
            throw new Error("Please set the ASANA_ACCESS_TOKEN environment variable.");
        }

        // create a client with your Asana PAT
        Client client = Client.accessToken(System.getenv("ASANA_ACCESS_TOKEN"));

        // find your "Personal Projects" project
        Workspace personalProjects = null;
        for (Workspace workspace : client.workspaces.getWorkspaces()) {
            if (workspace.name.equals("Personal Projects")) {
                personalProjects = workspace;
                break;
            }
        }

        // create a "demo project" if it doesn't exist
        List<Project> projects = client.projects.getProjectsForWorkspace(personalProjects.gid, false).execute();
        Project demoProject = null;
        for (Project project : projects) {
            if (project.name.equals("demo project")) {
                demoProject = project;
                break;
            }
        }
        if (demoProject == null) {
            demoProject = client.projects.createProjectForWorkspace(personalProjects.gid)
                    .data("name", "demo project")
                    .execute();
        }

        // create a task in the project
        Task demoTask = client.tasks.createProjectForWorkspace(personalProjects.gid)
                .data("name", "demo task created at " + new Date())
                .data("projects", Arrays.asList(demoProject.gid))
                .execute();
        System.out.println("Task " + demoTask.gid + " created.");

        // add an attachment to the task
        Attachment demoAttachment = client.attachments.createOnTask(
                demoTask.gid,
                new ByteArrayInputStream("hello world".getBytes()),
                "upload.txt",
                "text/plain"
        ).execute();
        System.out.println("Attachment " + demoAttachment.gid + " created.");
    }
}

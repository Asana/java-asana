package com.asana.examples;

import com.asana.Client;
import com.asana.dispatcher.OAuthDispatcher;
import com.asana.models.Event;
import com.asana.models.*;
import com.google.common.io.LineReader;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * API Key Instructions:
 *
 * 1. set your ASANA_API_KEY environment variable to the API key found in Asana Account Settings
 *
 */
public class ExampleCreateTaskAndUpload {

    public static void main( String[] args) throws Exception
    {
        if (System.getenv("ASANA_API_KEY") == null) {
            throw new Error("Please set the ASANA_API_KEY environment variable.");
        }

        // create a client with your Asana API key
        Client client = Client.basicAuth(System.getenv("ASANA_API_KEY"));

        // find your "Personal Projects" project
        Workspace personalProjects = null;
        for (Workspace workspace: client.workspaces.findAll()) {
            if (workspace.name.equals("Personal Projects")) {
                personalProjects = workspace;
                break;
            }
        }

        // create a "demo project" if it doesn't exist
        List<Project> projects = client.projects.findByWorkspace(personalProjects.id).execute();
        Project demoProject = null;
        for (Project project: projects) {
            if (project.name.equals("demo project")) {
                demoProject = project;
                break;
            }
        }
        if (demoProject == null) {
            demoProject = client.projects.createInWorkspace(personalProjects.id)
                    .data("name", "demo project")
                    .execute();
        }

        // create a task in the project
        Task demoTask = client.tasks.createInWorkspace(personalProjects.id)
                .data("name", "demo task created at " + new Date())
                .data("projects", Arrays.asList(demoProject.id))
                .execute();
        System.out.println("Task " + demoTask.id + " created.");

        // add an attachment to the task
        Attachment demoAttachment = client.attachments.createOnTask(
                demoTask.id,
                new ByteArrayInputStream("hello world".getBytes()),
                "upload.txt",
                "text/plain"
        ).execute();
        System.out.println("Attachment " + demoAttachment.id + " created.");
    }
}

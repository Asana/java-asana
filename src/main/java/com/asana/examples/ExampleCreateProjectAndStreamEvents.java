package com.asana.examples;

import com.asana.Client;
import com.asana.models.Event;
import com.asana.models.Project;
import com.asana.models.Workspace;

import java.util.List;

/**
 * API Key Instructions:
 * <p/>
 * 1. set your ASANA_API_KEY environment variable to the API key found in Asana Account Settings
 */
public class ExampleCreateProjectAndStreamEvents {

    public static void main(String[] args) throws Exception {
        if (System.getenv("ASANA_API_KEY") == null) {
            throw new Error("Please set the ASANA_API_KEY environment variable.");
        }

        // create a client with your Asana API key
        Client client = Client.basicAuth(System.getenv("ASANA_API_KEY"));

        // find your "Personal Projects" project
        Workspace personalProjects = null;
        for (Workspace workspace : client.workspaces.findAll()) {
            if (workspace.name.equals("Personal Projects")) {
                personalProjects = workspace;
                break;
            }
        }

        // create a "demo project" if it doesn't exist
        List<Project> projects = client.projects.findByWorkspace(personalProjects.id).execute();
        Project demoProject = null;
        for (Project project : projects) {
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

        // start streaming modifications to the demo project.
        // make some changes in Asana to see this working
        System.out.println("== Streaming events for 'demo project' in 'Personal Projects' workspace:");
        for (Event e : client.events.get(demoProject.id)) {
            System.out.println(e.action + ": " + e.type);
        }
    }
}

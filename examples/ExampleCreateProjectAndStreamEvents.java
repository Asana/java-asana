package com.asana.examples;

import com.asana.Client;
import com.asana.models.Event;
import com.asana.models.Project;
import com.asana.models.Workspace;

import java.util.List;

/**
 * PAT Instructions:
 * <p>
 * 1. set your ASANA_ACCESS_TOKEN environment variable to a personal access token
 */
public class ExampleCreateProjectAndStreamEvents {

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

        // start streaming modifications to the demo project.
        // make some changes in Asana to see this working
        System.out.println("== Streaming events for 'demo project' in 'Personal Projects' workspace:");
        for (Event e : client.events.get(demoProject.gid)) {
            System.out.println(e.action + ": " + e.type);
        }
    }
}

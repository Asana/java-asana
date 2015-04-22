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
 * OAuth Instructions:
 *
 * 1. create a new application in your Asana Account Settings ("App" panel)
 * 2. set the redirect URL to "urn:ietf:wg:oauth:2.0:oob"
 * 3. set your ASANA_CLIENT_ID and ASANA_CLIENT_SECRET environment variables
 *
 */
public class ExampleScript {

    public static void main( String[] args) throws Exception
    {
        String accessToken = null;

        if (System.getenv("ASANA_CLIENT_ID") != null) {
            System.out.println("== Example using OAuth Client ID and Client Secret:");

            // create a client with the OAuth credentials:
            Client client = Client.oauth(
                    System.getenv("ASANA_CLIENT_ID"),
                    System.getenv("ASANA_CLIENT_SECRET"),
                    // this special redirect URI will prompt the user to copy/paste the code.
                    // useful for command line scripts and other non-web apps
                    OAuthDispatcher.NATIVE_REDIRECT_URI
            );
            OAuthDispatcher dispatcher = ((OAuthDispatcher) client.dispatcher);

            System.out.println("isAuthorized=" + dispatcher.isAuthorized());

            // get an authorization URL:
            String url = dispatcher.getAuthorizationUrl();
            System.out.println(url);

            // in a web app you'd redirect the user to this URL when they take action to
            // login with Asana or connect their account to Asana
            Desktop.getDesktop().browse(new URI(url));

            System.out.println("Copy and paste the returned code from the browser and press enter:");

            LineReader reader = new LineReader(new InputStreamReader(System.in));
            String line = reader.readLine();

            // exchange the code for a bearer token
            // normally you'd persist this token somewhere
            accessToken = dispatcher.fetchToken(line);

            System.out.println("isAuthorized=" + dispatcher.isAuthorized());
            System.out.println("token=" + accessToken);

            User user = client.users.me().execute();
            System.out.println("me=" + user.name);
            System.out.println(user.id);
            System.out.println(user.photo.image_128x128);
            System.out.println(user.workspaces.iterator().next().name);
        }

        if (accessToken != null || System.getenv("ASANA_TOKEN") != null) {
            System.out.println("== Example using OAuth Access Token:");

            if (accessToken == null) {
                accessToken = System.getenv("ASANA_TOKEN");
            }

            // create a client with your OAuth client ID and a previously obtained bearer token
            Client client = Client.oauth(
                    System.getenv("ASANA_CLIENT_ID"),
                    System.getenv("ASANA_CLIENT_SECRET"),
                    "urn:ietf:wg:oauth:2.0:oob",
                    accessToken
            );
            OAuthDispatcher dispatcher = ((OAuthDispatcher) client.dispatcher);

            System.out.println("isAuthorized=" + dispatcher.isAuthorized());
            System.out.println("me=" + client.users.me().execute().name);
        }

        if (System.getenv("ASANA_API_KEY") != null) {
            System.out.println("== Example using Basic Auth API Key:");

            // create a client with your Asana API key
            Client client = Client.basicAuth(System.getenv("ASANA_API_KEY"));

            User me = client.users.me().execute();
            System.out.println("me=" + me.name);

            // find your "Personal Projects" project
            Workspace personalProjects = null;
            for (Workspace workspace: client.workspaces.findAll()) {
                if (workspace.name.equals("Personal Projects")) {
                    personalProjects = workspace;
                    break;
                }
            }
            List<Project> projects = client.projects.findByWorkspace(personalProjects.id).execute();
            System.out.println("personal projects=" + projects.size());

            // create a "demo project" if it doesn't exist
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

            // add an attachment to the task
            client.attachments.createOnTask(
                    demoTask.id,
                    new ByteArrayInputStream("hello world".getBytes()),
                    "upload.txt",
                    "text/plain"
            ).execute();

            // start streaming modifications to the demo project.
            // make some changes in Asana to see this working
            for (Event e: client.events.get(demoProject.id)) {
                System.out.println(e.action);
            }
        }
    }
}

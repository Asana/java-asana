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

public class ExampleScript {

    public static void main( String[] args) throws Exception
    {
        String accessToken = null;

        if (System.getenv("ASANA_CLIENT_ID") != null) {
            System.out.println("== Example using OAuth Client ID and Client Secret:");

            Client client = Client.oauth(
                    System.getenv("ASANA_CLIENT_ID"),
                    System.getenv("ASANA_CLIENT_SECRET"),
                    "urn:ietf:wg:oauth:2.0:oob"
            );
            OAuthDispatcher dispatcher = ((OAuthDispatcher) client.dispatcher);

            System.out.println("isAuthorized=" + dispatcher.isAuthorized());

            String url = dispatcher.authorizationUrl();
            System.out.println(url);

            Desktop.getDesktop().browse(new URI(url));

            System.out.println("Copy and paste the returned code from the browser and press enter:");

            LineReader reader = new LineReader(new InputStreamReader(System.in));
            String line = reader.readLine();

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

            Client client = Client.basicAuth(System.getenv("ASANA_API_KEY"));

            User me = client.users.me().execute();
            System.out.println("me=" + me.name);

            Workspace personalProjects = null;
            for (Workspace workspace: client.workspaces.findAll()) {
                if (workspace.name.equals("Personal Projects")) {
                    personalProjects = workspace;
                    break;
                }
            }
            List<Project> projects = client.projects.findByWorkspace(personalProjects.id).execute();
            System.out.println("personal projects=" + projects.size());

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

            Task demoTask = client.tasks.createInWorkspace(personalProjects.id)
                    .data("name", "demo task created at " + new Date())
                    .data("projects", Arrays.asList(demoProject.id))
                    .execute();

            client.attachments.createOnTask(
                    demoTask.id,
                    new ByteArrayInputStream("hello world".getBytes()),
                    "upload.txt",
                    "text/plain"
            ).execute();

            for (Event e: client.events.get(demoProject.id)) {
                System.out.println(e.action);
            }
        }
    }
}

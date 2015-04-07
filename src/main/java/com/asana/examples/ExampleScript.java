package com.asana.examples;

import com.asana.Client;
import com.asana.dispatcher.OAuthDispatcher;
import com.asana.models.*;
import com.asana.models.Event;
import com.google.common.collect.ImmutableList;
import com.google.common.io.LineReader;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class ExampleScript {

    public static void main( String[] args) throws Exception
    {
//        Client.DEFAULTS.put("base_url", "http://localhost:8080");

        String accessToken = null;

        if (System.getenv("ASANA_CLIENT_ID") != null) {
            System.out.println("== Example using OAuth Client ID and Client Secret:");

            Client client = Client.oauth(
                    System.getenv("ASANA_CLIENT_ID"),
                    System.getenv("ASANA_CLIENT_SECRET"),
                    "urn:ietf:wg:oauth:2.0:oob"
            );
            OAuthDispatcher dispatcher = ((OAuthDispatcher) client.dispatcher);

            System.out.println("authorized=" + dispatcher.authorized());

            String url = dispatcher.authorizationUrl();
            System.out.println(url);

            Desktop.getDesktop().browse(new URI(url));

            System.out.println("Copy and paste the returned code from the browser and press enter:");

            LineReader reader = new LineReader(new InputStreamReader(System.in));
            String line = reader.readLine();

            accessToken = dispatcher.fetchToken(line);

            System.out.println("authorized=" + dispatcher.authorized());
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

            System.out.println("authorized=" + dispatcher.authorized());
            System.out.println("me=" + client.users.me().execute().name);
        }

        if (System.getenv("ASANA_API_KEY") != null) {
            System.out.println("== Example using Basic Auth API Key:");

            Client client = Client.basicAuth(System.getenv("ASANA_API_KEY"));

            User me = client.users.me().execute();
            System.out.println("me=" + me.name);

            for (Event e: client.events.get("29898626391464")) {
                System.out.println(e.action);
            }
        }
////        Collection<User> users = client.users.findAll();
////        for (User u: users) {
////            System.out.println(u.name);
////        }
//
//        Task task = client.tasks.create()
//                .option("pretty", true)
//                .data("name", "hello2")
//                .data("workspace", "498346170860")
//                .data("projects", ImmutableList.of("29898626391464"))
//                .execute();
//
//        System.out.println(task.id);
//
//        client.tasks.update(task.id)
//                .data("name", "barrrr2")
//                .execute();
//
//        task = client.tasks.findById(task.id).execute();
//        System.out.println(task.id);
//        System.out.println(task.name);
//
//        client.tasks.delete(task.id).execute();
    }
}

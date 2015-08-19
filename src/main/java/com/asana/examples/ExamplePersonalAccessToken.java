package com.asana.examples;

import com.asana.Client;
import com.asana.models.User;

/**
 *
 * API Key Instructions:
 *
 * 1. set your ASANA_ACCESS_TOKEN environment variable to a Personal Access Token found in Asana Account Settings
 *
 */
public class ExamplePersonalAccessToken {

    public static void main( String[] args) throws Exception
    {
        if (System.getenv("ASANA_ACCESS_TOKEN") == null) {
            throw new Error("Please set the ASANA_API_KEY environment variable.");
        }

        System.out.println("== Example using a personal access token:");

        // create a client with a personal access token
        Client client = Client.accessToken(System.getenv("ASANA_ACCESS_TOKEN"));

        // get the user object for yourself
        User me = client.users.me().execute();
        System.out.println("me=" + me.name);
    }
}

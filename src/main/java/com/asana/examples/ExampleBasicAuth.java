package com.asana.examples;

import com.asana.Client;
import com.asana.models.User;

/**
 *
 * API Key Instructions:
 *
 * 1. set your ASANA_API_KEY environment variable to the API key found in Asana Account Settings
 *
 */
public class ExampleBasicAuth {

    public static void main( String[] args) throws Exception
    {
        if (System.getenv("ASANA_API_KEY") == null) {
            throw new Error("Please set the ASANA_API_KEY environment variable.");
        }

        System.out.println("== Example using Basic Auth API Key:");

        // create a client with your Asana API key
        Client client = Client.basicAuth(System.getenv("ASANA_API_KEY"));

        // get the user object for yourself
        User me = client.users.me().execute();
        System.out.println("me=" + me.name);
    }
}

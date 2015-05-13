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
public class ExampleBasicAuth {

    public static void main( String[] args) throws Exception
    {
        if (System.getenv("ASANA_API_KEY") == null) {
            throw new Error("Please set the ASANA_API_KEY environment variable.");
        }

        System.out.println("== Example using Basic Auth API Key:");

        // create a client with your Asana API key
        Client client = Client.basicAuth(System.getenv("ASANA_API_KEY"));

        User me = client.users.me().execute();
        System.out.println("me=" + me.name);
    }
}

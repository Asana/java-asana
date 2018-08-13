package com.asana.examples;

import com.asana.Client;
import com.asana.OAuthApp;
import com.asana.models.User;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.util.UUID;

/**
 * OAuth Instructions:
 * <p>
 * 1. create a new application in your Asana Account Settings ("App" panel)
 * 2. set the redirect URL to "http://localhost:5000/auth/asana/callback" (or whichever port you choose)
 * 3. set your ASANA_CLIENT_ID and ASANA_CLIENT_SECRET environment variables
 */
public class ExampleServer {
    private static final String ASANA_CLIENT_ID = System.getenv("ASANA_CLIENT_ID");
    private static final String ASANA_CLIENT_SECRET = System.getenv("ASANA_CLIENT_SECRET");
    private static final String REDIRECT_URI = "http://localhost:5000/auth/asana/callback";

    public static void main(String[] args) {
        if (ASANA_CLIENT_ID == null || ASANA_CLIENT_SECRET == null) {
            System.err.println("Please set the ASANA_CLIENT_ID and ASANA_CLIENT_SECRET environment variables.");
            System.exit(1);
        }

        Spark.setPort(5000);

        // main page (http://localhost:5000/)
        Spark.get(new Route("/") {
            public Object handle(Request request, Response response) {
                String token = request.session().attribute("token");
                // if the user has a token they're logged in
                if (token != null) {
                    try {
                        // example request gets information about logged in user
                        Client client = Client.oauth(getApp(token));
                        User me = client.users.me().execute();
                        return "<p>Hello " + me.name + "</p><p><a href=\"/logout\">Logout</a></p>";
                    } catch (IOException e) {
                        return e.getStackTrace().toString();
                    }
                }
                // if we don't have a token show a "Sign in with Asana" button
                else {
                    // get an authorization URL and anti-forgery "state" token
                    String state = UUID.randomUUID().toString();
                    String authUrl = getApp().getAuthorizationUrl(state);
                    // persist the state token in the user's session
                    request.session().attribute("state", state);
                    // link the button to the authorization URL
                    return "<p><a href=\"" + authUrl + "\">" +
                            "<img src=\"https://github.com/Asana/oauth-examples/raw/master/public/asana-oauth-button-blue.png?raw=true\">" +
                            "</a></p>";
                }
            }
        });

        // logout endpoint
        Spark.get(new Route("/logout") {
            public Object handle(Request request, Response response) {
                // delete the session token and redirect back to the main page
                request.session().removeAttribute("token");
                response.redirect("/");
                return null;
            }
        });

        // OAuth callback endpoint
        Spark.get(new Route("/auth/asana/callback") {
            public Object handle(Request request, Response response) {
                // verify the state token matches to prevent CSRF attacks
                if (request.queryParams("state").equals(request.session().attribute("state"))) {
                    try {
                        // exchange the code for a bearer token and persist it in the user's session or database
                        String token = getApp().fetchToken(request.queryParams("code"));
                        request.session().attribute("token", token);
                        response.redirect("/");
                        return null;
                    } catch (IOException e) {
                        return e.getStackTrace().toString();
                    }
                } else {
                    return "State doesn't match";
                }
            }
        });
    }

    /**
     * convenience method to create a client with your credentials
     *
     * @return an instance of Client
     */
    private static OAuthApp getApp() {
        return new OAuthApp(ASANA_CLIENT_ID, ASANA_CLIENT_SECRET, REDIRECT_URI);
    }

    /**
     * convenience method to create a client with your credentials and a 'token'
     *
     * @param token an OAuth2 bearer token
     * @return an instance of Client
     */
    private static OAuthApp getApp(String token) {
        return new OAuthApp(ASANA_CLIENT_ID, ASANA_CLIENT_SECRET, REDIRECT_URI, token);
    }
}

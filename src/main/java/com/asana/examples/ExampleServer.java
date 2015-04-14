package com.asana.examples;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

import com.asana.Client;
import com.asana.dispatcher.OAuthDispatcher;
import com.asana.models.User;
import com.sun.net.httpserver.*;

public class ExampleServer
{
    private static final String ASANA_CLIENT_ID = System.getenv("ASANA_CLIENT_ID");
    private static final String ASANA_CLIENT_SECRET = System.getenv("ASANA_CLIENT_SECRET");
    private static final String REDIRECT_URI = "http://localhost:5000/auth/asana/callback";

    private static final String SESSION_COOKIE_NAME = "example_server_session";
    private static Map<String, Map<String, Object>> sessions = new HashMap<String, Map<String, Object>>();

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(5000), 0);

        HttpContext context = server.createContext("/", new HttpHandler() {
            public void handle(HttpExchange t) throws IOException {
                String path = t.getRequestURI().getPath();
                try {
                    if ("/".equals(path)) {
                        String token = (String) session(t).get("token");
                        if (token != null) {
                            User me = getClient(token).users.me().execute();
                            respond(t, 200, "<p>Hello " + me.name + "</p><p><a href=\"/logout\">Logout</a></p>");
                        } else {
                            Client client = getClient();
                            String state = UUID.randomUUID().toString();
                            session(t).put("state", state);
                            String authUrl = ((OAuthDispatcher) client.dispatcher).getAuthorizationUrl(state);
                            respond(t, 200,
                                    "<p><a href=\"" + authUrl + "\">" +
                                    "<img src=\"https://github.com/Asana/oauth-examples/raw/master/public/asana-oauth-button-blue.png?raw=true\">"+
                                    "</a></p>"
                            );
                        }
                    }
                    else if ("/logout".equals(path)) {
                        session(t).remove("token");
                        redirect(t, "/");
                    }
                    else if ("/auth/asana/callback".equals(path)) {
                        if (params(t).get("state").equals(session(t).get("state"))) {
                            String token = ((OAuthDispatcher) getClient().dispatcher).fetchToken(params(t).get("code"));
                            session(t).put("token", token);
                            redirect(t, "/");
                        } else {
                            respond(t, 200, "State doesn't match");
                        }
                    }
                    else {
                        respond(t, 404, "Not Found");
                    }
                } catch (Exception e) {
                    respond(t, 500, "Internal Error\n" + e.getStackTrace().toString());
                }
            }
        });

        server.setExecutor(null);
        server.start();
    }

    private static Client getClient() {
        return Client.oauth(ASANA_CLIENT_ID, ASANA_CLIENT_SECRET, REDIRECT_URI);
    }

    private static Client getClient(String token) {
        return Client.oauth(ASANA_CLIENT_ID, ASANA_CLIENT_SECRET, REDIRECT_URI, token);
    }

    // misc helpers that would normally be provided by your web framework:

    private static void respond(HttpExchange t, int status, String body) throws IOException {
        byte bytes[] = body.getBytes();
        t.sendResponseHeaders(status, bytes.length);
        t.getResponseBody().write(bytes);
        t.getResponseBody().close();
    }
    private static void redirect(HttpExchange t, String url) throws IOException {
        t.getResponseHeaders().put("Location", Arrays.asList(url));
        t.sendResponseHeaders(302, 0);
        t.getResponseBody().close();
    }

    private static Map<String,String> params(HttpExchange t) {
        Map<String, String> result = new HashMap<String, String>();
        for (String param : t.getRequestURI().getQuery().split("&")) {
            String pair[] = param.split("=");
            result.put(URLDecoder.decode(pair[0]), pair.length > 1 ? URLDecoder.decode(pair[1]) : "");
        }
        return result;
    }

    private static Map<String,Object> session(HttpExchange t) {
        String sessionId = cookies(t).get(SESSION_COOKIE_NAME);
        if (sessionId == null || !sessions.containsKey(sessionId)) {
            sessionId = UUID.randomUUID().toString();
            sessions.put(sessionId, new HashMap<String, Object>());
            setCookie(t, SESSION_COOKIE_NAME, sessionId);
        }
        return sessions.get(sessionId);
    }

    private static Map<String,String> cookies(HttpExchange t) {
        Map<String,String> results = new HashMap<String, String>();
        List<String> headers = t.getRequestHeaders().get("Cookie");
        if (headers != null) {
            for (String header : headers) {
                String cookies[] = header.split(";");
                for (String cookie : cookies) {
                    String components[] = cookie.split("=");
                    results.put(URLDecoder.decode(components[0].trim()), URLDecoder.decode(components[1].trim()));
                }
            }
        }
        return results;
    }

    private static void setCookie(HttpExchange t, String name, String value) {
        // NOTE: only handles setting one cookie per request
        String cookie = URLEncoder.encode(name) + "=" + URLEncoder.encode(value);
        t.getResponseHeaders().put("Set-Cookie", Arrays.asList(cookie));
    }
}
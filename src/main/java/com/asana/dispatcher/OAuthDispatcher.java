package com.asana.dispatcher;

import com.google.api.client.auth.oauth2.*;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

import java.io.IOException;
import java.util.Arrays;

public class OAuthDispatcher extends Dispatcher
{
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new GsonFactory();

    private static final String TOKEN_SERVER_URL = "https://app.asana.com/-/oauth_token";
    private static final String AUTHORIZATION_SERVER_URL = "https://app.asana.com/-/oauth_authorize";

    private String apiKey;
    private String apiSecret;
    private String redirectUri;

    private AuthorizationCodeFlow flow;
    public Credential credential;

    public OAuthDispatcher(String apiKey, String apiSecret, String redirectUri)
    {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.redirectUri = redirectUri;

        this.flow = new AuthorizationCodeFlow.Builder(
                BearerToken.authorizationHeaderAccessMethod(),
                HTTP_TRANSPORT,
                JSON_FACTORY,
                new GenericUrl(TOKEN_SERVER_URL),
                new ClientParametersAuthentication(apiKey, apiSecret),
                apiKey,
                AUTHORIZATION_SERVER_URL
        ).build();
    }

    public String authorizationUrl()
    {
        return authorizationUrl(null);
    }

    public String authorizationUrl(String state)
    {
        AuthorizationCodeRequestUrl url = this.flow.newAuthorizationUrl();
        if (state != null) {
            url.setState(state);
        }
        url.setRedirectUri(this.redirectUri);
        return url.build();
    }

    public String fetchToken(String code) throws IOException
    {
        TokenResponse tokenResponse = this.flow.newTokenRequest(code).setRedirectUri(this.redirectUri).execute();
        this.credential = new Credential.Builder(BearerToken.authorizationHeaderAccessMethod())
                .setTransport(HTTP_TRANSPORT)
                .setJsonFactory(JSON_FACTORY)
                .setTokenServerUrl(new GenericUrl(TOKEN_SERVER_URL))
                .setClientAuthentication(new ClientParametersAuthentication(apiKey, apiSecret))
                .build()
                .setFromTokenResponse(tokenResponse);
        return credential.getAccessToken();
    }

    public void authenticate(HttpRequest request)
    {
        request.getHeaders().setAuthorization("Bearer " + this.credential.getAccessToken());
    }
}

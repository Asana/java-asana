package com.asana.dispatcher;

import com.google.api.client.auth.oauth2.*;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

import java.io.IOException;

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
        this(apiKey, apiSecret, redirectUri, null);
    }

    public OAuthDispatcher(String apiKey, String apiSecret, String redirectUri, String accessToken)
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

        if (accessToken != null) {
            credential = new Credential(BearerToken.authorizationHeaderAccessMethod())
                    .setAccessToken(accessToken);
        }
    }

    public boolean isAuthorized()
    {
        return this.credential != null;
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

    public String authorizationUrl()
    {
        return authorizationUrl(null);
    }

    public String fetchToken(String code, String userId) throws IOException
    {
        TokenResponse tokenResponse = this.flow.newTokenRequest(code)
                .setRedirectUri(this.redirectUri)
                .execute();
        credential = this.flow.createAndStoreCredential(tokenResponse, userId);
        return credential.getAccessToken();
    }

    public String fetchToken(String code) throws IOException
    {
        return fetchToken(code, null);
    }

    public HttpRequest buildRequest(String method, GenericUrl url, HttpContent content) throws IOException
    {
        if (credential == null) {
            throw new IOException("OAuthDispatcher: access token not set");
        }
        return HTTP_TRANSPORT.createRequestFactory(credential).buildRequest(method, url, content);
    }
}

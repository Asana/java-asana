package com.asana;

import com.google.api.client.auth.oauth2.*;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

import java.io.IOException;

public class OAuthApp {
    public static final String NATIVE_REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    private static final String TOKEN_SERVER_URL = "https://app.asana.com/-/oauth_token";
    private static final String AUTHORIZATION_SERVER_URL = "https://app.asana.com/-/oauth_authorize";

    private String redirectUri;

    private AuthorizationCodeFlow flow;
    public Credential credential;

    public OAuthApp(String clientID, String clientSecret, String redirectUri) {
        this(clientID, clientSecret, redirectUri, null);
    }

    public OAuthApp(String clientID, String clientSecret, String redirectUri, String accessToken) {
        this(clientID, clientSecret, redirectUri, accessToken, null, HTTP_TRANSPORT, JSON_FACTORY);
    }
    
    public OAuthApp(String clientID, String clientSecret, String redirectUri, String accessToken, String refreshToken) {
        this(clientID, clientSecret, redirectUri, accessToken, refreshToken, HTTP_TRANSPORT, JSON_FACTORY);
    }

    public OAuthApp(String clientID,
                    String clientSecret,
                    String redirectUri,
                    String accessToken,
                    String refreshToken,
                    HttpTransport transport,
                    JsonFactory jsonFactory) {
        this.redirectUri = redirectUri;

        GenericUrl tokenServerUrl = new GenericUrl(TOKEN_SERVER_URL);
        ClientParametersAuthentication clientAuthentication = new ClientParametersAuthentication(clientID, clientSecret);


        this.flow = new AuthorizationCodeFlow.Builder(
                BearerToken.authorizationHeaderAccessMethod(),
                transport,
                jsonFactory,
                tokenServerUrl,
                clientAuthentication,
                clientID,
                AUTHORIZATION_SERVER_URL
        ).build();

        if (accessToken != null || refreshToken != null) {
            this.credential = new Credential.Builder(BearerToken.authorizationHeaderAccessMethod())
                .setTransport(transport)
                .setJsonFactory(jsonFactory)
                .setClientAuthentication(clientAuthentication)
                .setTokenServerUrl(tokenServerUrl)
                .build();

            this.credential.setAccessToken(accessToken);
            this.credential.setRefreshToken(refreshToken);
        }
    }

    public boolean isAuthorized() {
        return this.credential != null;
    }

    public String getAuthorizationUrl(String state) {
        AuthorizationCodeRequestUrl url = this.flow.newAuthorizationUrl();
        if (state != null) {
            url.setState(state);
        }
        url.setRedirectUri(this.redirectUri);
        return url.build();
    }

    public String fetchToken(String code, String userId) throws IOException {
        TokenResponse tokenResponse = this.flow.newTokenRequest(code)
                .setRedirectUri(this.redirectUri)
                .execute();
        credential = this.flow.createAndStoreCredential(tokenResponse, userId);
        return credential.getAccessToken();
    }

    public String fetchToken(String code) throws IOException {
        return fetchToken(code, null);
    }
}

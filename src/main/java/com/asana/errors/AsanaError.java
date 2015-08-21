package com.asana.errors;

import com.asana.Json;
import com.asana.models.ErrorBody;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.repackaged.com.google.common.base.Joiner;

import java.io.IOException;

public class AsanaError extends IOException {
    public int status;
    public HttpResponseException response;

    public AsanaError(String message, int status, HttpResponseException exception) {
        super(constructMessage(message, exception));

        this.status = status;
        this.response = exception;
    }

    public static AsanaError mapException(HttpResponseException exception) throws AsanaError {
        switch (exception.getStatusCode()) {
            case ForbiddenError.STATUS:
                return new ForbiddenError(exception);
            case InvalidRequestError.STATUS:
                return new InvalidRequestError(exception);
            case InvalidTokenError.STATUS:
                return new InvalidTokenError(exception);
            case NoAuthorizationError.STATUS:
                return new NoAuthorizationError(exception);
            case NotFoundError.STATUS:
                return new NotFoundError(exception);
            case RateLimitEnforcedError.STATUS:
                return new RateLimitEnforcedError(exception);
            case ServerError.STATUS:
                return new ServerError(exception);
            default:
                return new AsanaError(exception.getStatusMessage(), exception.getStatusCode(), exception);
        }
    }

    private static String constructMessage(String message, HttpResponseException exception) {
        try {
            ErrorBody body = Json.getInstance().fromJson(exception.getContent(), ErrorBody.class);
            if (body.errors.size() > 0) {
                return message + " (" + Joiner.on("; ").join(body.errors) + ")";
            }
        } catch (Exception e) {
        }
        return message;
    }
}

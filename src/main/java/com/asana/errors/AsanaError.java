package com.asana.errors;

import com.google.api.client.http.HttpResponseException;

import java.io.IOException;

public class AsanaError extends IOException
{
    public String message;
    public int status;
    public HttpResponseException response;

    public AsanaError(String message, int status, HttpResponseException exception)
    {
        this.message = message;
        this.status = status;
        this.response = exception;
    }

    public static AsanaError mapException(HttpResponseException exception) throws AsanaError
    {
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
}

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

    public static void handleErrorResponse(HttpResponseException exception) throws AsanaError
    {
        switch (exception.getStatusCode()) {
            case ForbiddenError.STATUS:
                throw new ForbiddenError(exception);
            case InvalidRequestError.STATUS:
                throw new InvalidRequestError(exception);
            case InvalidTokenError.STATUS:
                throw new InvalidTokenError(exception);
            case NoAuthorizationError.STATUS:
                throw new NoAuthorizationError(exception);
            case NotFoundError.STATUS:
                throw new NotFoundError(exception);
            case RateLimitEnforcedError.STATUS:
                throw new RateLimitEnforcedError(exception);
            case ServerError.STATUS:
                throw new ServerError(exception);
        }
    }
}

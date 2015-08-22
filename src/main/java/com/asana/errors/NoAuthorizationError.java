package com.asana.errors;

import com.google.api.client.http.HttpResponseException;

public class NoAuthorizationError extends AsanaError {
    final public static String MESSAGE = "NoAuthorizationError";
    final public static int STATUS = 401;

    public NoAuthorizationError(HttpResponseException exception) {
        super(MESSAGE, STATUS, exception);
    }
}
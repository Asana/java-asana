package com.asana.errors;

import com.google.api.client.http.HttpResponseException;

public class NotFoundError extends AsanaError {
    final public static String MESSAGE = "Not Found";
    final public static int STATUS = 404;

    public NotFoundError(HttpResponseException exception) {
        super(MESSAGE, STATUS, exception);
    }
}
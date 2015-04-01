package com.asana.errors;

import com.google.api.client.http.HttpResponseException;

public class InvalidTokenError extends AsanaError
{
    final public static String MESSAGE = "Sync token invalid or too old";
    final public static int STATUS = 412;

    public InvalidTokenError(HttpResponseException exception)
    {
        super(MESSAGE, STATUS, exception);
    }
}
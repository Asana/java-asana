package com.asana.errors;

import com.google.api.client.http.HttpResponseException;

public class ForbiddenError extends AsanaError
{
    final public static String MESSAGE = "Forbidden";
    final public static int STATUS = 403;

    public ForbiddenError(HttpResponseException exception)
    {
        super(MESSAGE, STATUS, exception);
    }
}
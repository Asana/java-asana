package com.asana.errors;

import com.google.api.client.http.HttpResponseException;

public class InvalidRequestError extends AsanaError
{
    final public static String MESSAGE = "Invalid Request";
    final public static int STATUS = 400;

    public InvalidRequestError(HttpResponseException exception)
    {
        super(MESSAGE, STATUS, exception);
    }
}
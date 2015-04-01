package com.asana.errors;

import com.google.api.client.http.HttpResponseException;

public class ServerError extends RetryableAsanaError
{
    final public static String MESSAGE = "Server Error";
    final public static int STATUS = 500;

    public ServerError(HttpResponseException exception)
    {
        super(MESSAGE, STATUS, exception);
    }
}

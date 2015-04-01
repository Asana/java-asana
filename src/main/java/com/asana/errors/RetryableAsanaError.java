package com.asana.errors;

import com.google.api.client.http.HttpResponseException;

public class RetryableAsanaError extends AsanaError
{
    public RetryableAsanaError(String message, int status, HttpResponseException exception)
    {
        super(message, status, exception);
    }
}

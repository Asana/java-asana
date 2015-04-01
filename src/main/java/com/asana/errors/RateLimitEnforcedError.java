package com.asana.errors;

import com.google.api.client.http.HttpResponseException;

public class RateLimitEnforcedError extends RetryableAsanaError
{
    final public static String MESSAGE = "Rate Limit Enforced";
    final public static int STATUS = 429;

    public RateLimitEnforcedError(HttpResponseException exception)
    {
        super(MESSAGE, STATUS, exception);
    }
}
package com.asana.errors;

import com.google.api.client.http.HttpResponseException;

import java.util.List;

public class RateLimitEnforcedError extends RetryableAsanaError {
    final public static String MESSAGE = "Rate Limit Enforced";
    final public static int STATUS = 429;

    public long retryAfter;

    public RateLimitEnforcedError(HttpResponseException exception) {
        super(MESSAGE, STATUS, exception);

        try {
            List<String> headers = (List<String>) exception.getHeaders().get("retry-after");
            retryAfter = (long) (1000 * Float.parseFloat((String) headers.get(0)));
        } catch (Exception e) {
            retryAfter = -1;
        }
    }
}
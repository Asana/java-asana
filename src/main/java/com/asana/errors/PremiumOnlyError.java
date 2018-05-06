package com.asana.errors;

import com.google.api.client.http.HttpResponseException;

public class PremiumOnlyError extends AsanaError {
    final public static String MESSAGE = "Payment Required";
    final public static int STATUS = 402;

    public PremiumOnlyError(HttpResponseException exception) {
        super(MESSAGE, STATUS, exception);
    }
}

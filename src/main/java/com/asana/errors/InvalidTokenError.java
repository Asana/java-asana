package com.asana.errors;

import com.asana.Json;
import com.asana.models.ResultBodyCollection;
import com.google.api.client.http.HttpResponseException;

public class InvalidTokenError extends AsanaError
{
    final public static String MESSAGE = "Sync token invalid or too old";
    final public static int STATUS = 412;

    public String sync;

    public InvalidTokenError(HttpResponseException exception)
    {
        super(MESSAGE, STATUS, exception);

        try {
            ResultBodyCollection body = Json.getInstance().fromJson(exception.getContent(), ResultBodyCollection.class);
            sync = body.sync;
        } catch (Exception e) {
        }
    }
}
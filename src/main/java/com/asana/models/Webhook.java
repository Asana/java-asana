package com.asana.models;

import com.google.gson.annotations.SerializedName;

import com.google.api.client.util.DateTime;

public class Webhook {
    public String id;
    public Event.Entity resource;
    public String target;
    public boolean active;

    @SerializedName("created_at")
    public DateTime createdAt;
    @SerializedName("last_success_at")
    public DateTime lastSuccessAt;
    @SerializedName("last_failure_at")
    public DateTime lastFailureAt;
    @SerializedName("last_failure_content")
    public String lastFailureContent;
}

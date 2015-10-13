package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Webhook {
    public Entity resource;
    public String target;
    public boolean active;

    @SerializedName("created_at")
    public Date createdAt;
    @SerializedName("last_success_at")
    public Date lastSuccessAt;
    @SerializedName("last_failure_at")
    public Date lastFailureAt;
    @SerializedName("last_failure_content")
    public String lastFailureContent;
}

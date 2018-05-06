package com.asana.models;

import com.google.gson.annotations.SerializedName;

import com.google.api.client.util.DateTime;

public class Story extends Resource {
    public String text;
    public String type;

    public Resource target;

    @SerializedName("created_by")
    public User createdBy;
    @SerializedName("created_at")
    public DateTime createdAt;
}

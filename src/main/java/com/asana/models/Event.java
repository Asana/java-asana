package com.asana.models;

import com.google.gson.annotations.SerializedName;

import com.google.api.client.util.DateTime;

public class Event {
    public String action;
    public Entity resource;
    public String type;
    public User user;
    public Entity parent;

    @SerializedName("created_at")
    public DateTime createdAt;
}

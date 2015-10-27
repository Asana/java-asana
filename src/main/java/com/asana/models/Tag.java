package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import com.google.api.client.util.DateTime;

public class Tag {
    public String id;
    public String name;
    public String notes;

    public String color;
    public Collection<User> followers;
    public Workspace workspace;

    @SerializedName("created_at")
    public DateTime createdAt;
}

package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import com.google.api.client.util.DateTime;

public class Tag extends Resource {
    public String name;

    public String color;
    public Collection<User> followers;
    public Workspace workspace;

    @SerializedName("created_at")
    public DateTime createdAt;
}

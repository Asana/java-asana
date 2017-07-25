package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import com.google.api.client.util.DateTime;

public class Project {
    public String id;
    public String name;

    public String notes;
    public String color;
    @SerializedName("archived")
    public boolean isArchived;
    @SerializedName("public")
    public boolean isPublic;

    public Collection<User> followers;
    public Collection<User> members;

    public Team team;
    public Workspace workspace;

    @SerializedName("custom_field_settings")
    public Collection<CustomFieldSetting> customFieldSettings;

    @SerializedName("created_at")
    public DateTime createdAt;
    @SerializedName("modified_at")
    public DateTime modifiedAt;

    public User owner;

    public Project() {
        //no-arg constructor
    }

    // constructor with id arg provided for convenience
    public Project(String id) {
        this.id = id;
    }
}

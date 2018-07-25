package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import com.google.api.client.util.DateTime;

public class Project extends Resource {
    public String name;
    public User owner;
    public String layout;

    @SerializedName("current_status")
    public ProjectStatus currentStatus;

    @SerializedName("due_date")
    public DateTime dueDate;
    @SerializedName("start_on")
    public DateTime startOn;

    public String notes;
    @SerializedName("html_notes")
    public String htmlNotes;

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
}

package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.Date;

public class Project
{
    public String id;
    public String name;

    public String notes;
    public String color;
    @SerializedName("archived") public boolean isArchived;
    @SerializedName("public") public boolean isPublic;

    public Collection<User> followers;
    public Collection<User> members;

    public Team team;
    public Workspace workspace;

    @SerializedName("created_at") public Date createdAt;
    @SerializedName("modified_at") public Date modifiedAt;

    public Project(String id)
    {
        this.id = id;
    }
}

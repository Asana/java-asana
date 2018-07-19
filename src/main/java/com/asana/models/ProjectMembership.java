package com.asana.models;

import com.google.gson.annotations.SerializedName;

public class ProjectMembership extends Resource {
    public User user;

    public Project project;

    @SerializedName("write_access")
    public String writeAccess;
}

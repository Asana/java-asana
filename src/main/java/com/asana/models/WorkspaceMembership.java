package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class WorkspaceMembership extends Resource {
    @SerializedName("user")
    public User user;

    @SerializedName("workspace")
    public Workspace workspace;

    @SerializedName("is_active")
    public Workspace isActive;

    @SerializedName("is_admin")
    public Workspace isAdmin;

    @SerializedName("is_guest")
    public Workspace isGuest;

    @SerializedName("user_task_list")
    public UserTaskList userTaskList;

    public WorkspaceMembership() {
        //no-arg constructor
    }

    // constructor with id arg provided for convenience
    public WorkspaceMembership(String id) {
        this.gid = id;
    }

}

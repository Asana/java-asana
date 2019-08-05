package com.asana.models;

import com.google.gson.annotations.SerializedName;

public class UserTaskList extends Resource {
    public String name;

    public User owner;

    public Workspace workspace;
}

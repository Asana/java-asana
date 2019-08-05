package com.asana.models;

import com.google.gson.annotations.SerializedName;

public class Job extends Resource {
    public String name;

    @SerializedName("resource_subtype")
    public String resourceSubtype;

    public String status;

    public Project new_project;

    public Task new_task;
}

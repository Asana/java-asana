package com.asana.models;

import com.google.gson.annotations.SerializedName;

public class Job extends ResourceWithSubtype {
    public String name;

    public String status;

    public Project new_project;

    public Task new_task;
}

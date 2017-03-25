package com.asana.models;

import java.util.Collection;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

public class Section {
    public String id;
    public String name;

    @SerializedName("created_at")
    public DateTime createdAt;

    public Collection<Project> projects;

    public Section() {
        //no-arg constructor
    }

    // constructor with id arg provided for convenience
    public Section(String id) {
        this.id = id;
    }
}

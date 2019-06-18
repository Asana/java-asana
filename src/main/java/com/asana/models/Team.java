package com.asana.models;

import com.google.gson.annotations.SerializedName;

public class Team extends Resource {
    public String name;

    public String description;

    @SerializedName("html_description")
    public String htmlDescription;

    public Workspace organization;
}

package com.asana.models;

import com.google.gson.annotations.SerializedName;

public class Team extends Resource {
    public String name;

    public Workspace organization;

    public String description;
    @SerializedName("html_description")
    public String htmlDescription;
}

package com.asana.models;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

public class Section extends Resource {
    public String name;
    public Project project;

    @SerializedName("created_at")
    public DateTime createdAt;
}

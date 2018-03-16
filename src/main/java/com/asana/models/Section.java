package com.asana.models;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

public class Section {
    public String id;
    public String name;
    public String project;

    @SerializedName("created_at")
    public DateTime createdAt;
}

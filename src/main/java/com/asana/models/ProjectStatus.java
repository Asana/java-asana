package com.asana.models;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

public class ProjectStatus extends Resource {
    public String title;

    public String text;
    
    @SerializedName("html_text")
    public String htmlText;

    public String color;

    @SerializedName("created_by")
    public User createdBy;

    @SerializedName("created_at")
    public DateTime createdAt;
}

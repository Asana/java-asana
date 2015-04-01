package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Story
{
    public String id;
    public String text;
    public String type;

    @SerializedName("created_by") public User createdBy;
    @SerializedName("created_at") public Date createdAt;
}

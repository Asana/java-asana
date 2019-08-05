package com.asana.models;

import com.google.gson.annotations.SerializedName;

import com.google.api.client.util.DateTime;

import java.util.Collection;

public class Story extends Resource {
    @SerializedName("resource_subtype")
    public String resourceSubtype;

    @SerializedName("created_at")
    public DateTime createdAt;
    @SerializedName("created_by")
    public User createdBy;


    public boolean liked;
    public Collection<Like> likes;
    @SerializedName("num_likes")
    public int numLikes;

    public String text;
    @SerializedName("html_text")
    public String htmlText;

    public Resource target;

    @SerializedName("is_pinned")
    public boolean isPinned;
    @SerializedName("is_edited")
    public boolean isEdited;

    public String source;
    public String type;
}

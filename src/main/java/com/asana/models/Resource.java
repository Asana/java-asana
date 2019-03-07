package com.asana.models;

import com.google.gson.annotations.SerializedName;

public class Resource {
    public String id;

    @SerializedName("resource_type")
    public String resourceType;
    @SerializedName("resource_subtype")
    public String resourceSubtype;
}

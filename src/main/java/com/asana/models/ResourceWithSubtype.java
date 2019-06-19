package com.asana.models;

import com.google.gson.annotations.SerializedName;

public class ResourceWithSubtype extends Resource {
    @SerializedName("resource_subtype")
    public String resourceSubtype;
}

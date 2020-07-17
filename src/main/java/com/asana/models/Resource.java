package com.asana.models;

import com.google.gson.annotations.SerializedName;

public class Resource {
    public String gid;

    @SerializedName("resource_type")
    public String resourceType;
}

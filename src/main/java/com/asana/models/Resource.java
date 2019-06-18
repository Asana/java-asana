package com.asana.models;

import com.google.gson.annotations.SerializedName;

public class Resource {
    public String id;

    public String gid;

    @SerializedName("resource_type")
    public String resourceType;
}

package com.asana.models;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

import java.net.URL;

public class OrganizationExport extends Resource {
    public String state;
    public Workspace organization;

    @SerializedName("download_url")
    public URL downloadUrl;
    @SerializedName("created_at")
    public DateTime createdAt;
}

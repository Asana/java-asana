package com.asana.models;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

import java.net.URL;

public class Attachment extends Resource {
    public String name;

    @SerializedName("created_at")
    public DateTime createdAt;

    @SerializedName("download_url")
    public URL downloadUrl;

    @SerializedName("view_url")
    public URL viewUrl;

    public String host;
    public Task parent;
}

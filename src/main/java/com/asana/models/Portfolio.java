package com.asana.models;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class Portfolio extends Resource {
    public String name;

    public User owner;

    public String color;

    public Collection<User> members;

    public Workspace workspace;

    @SerializedName("custom_field_settings")
    public Collection<CustomFieldSetting> customFieldSettings;

    @SerializedName("created_at")
    public DateTime createdAt;

    @SerializedName("created_by")
    public User createdBy;
}

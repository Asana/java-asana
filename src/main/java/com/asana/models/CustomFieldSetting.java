package com.asana.models;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class CustomFieldSetting extends Resource {

    @SerializedName("created_at")
    public DateTime createdAt;

    @SerializedName("is_important")
    public Boolean isImportant;

    public Project project;

    @SerializedName("custom_field")
    public CustomField customField;

}

package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class CustomFieldSetting {

    public String id;
    @SerializedName("is_important")
    public Boolean isImportant;

    public Project project;

    @SerializedName("custom_field")
    public CustomField customField;

}

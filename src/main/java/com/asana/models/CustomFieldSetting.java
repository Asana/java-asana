package com.asana.models;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class CustomFieldSetting {

    


    public String id;
    @SerializedName("created_at")
    public DateTime createdAt;
    @SerializedName("is_important")
    public Boolean isImportant;

    public Project project;
    public CustomField customField;


}

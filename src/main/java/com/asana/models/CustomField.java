package com.asana.models;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class CustomField {

    public static class EnumOptions {
      public Integer id;
      public String name;
      public Boolean enabled;
      public String color;
    }


    public String id;
    @SerializedName("created_at")
    public DateTime createdAt;

    public String name;
    public String type;

    // Only for type "number"
    public Integer precision;
    // Only for type "enum"
    @SerializedName("enum_options")
    public EnumOptions enumOptions;

}

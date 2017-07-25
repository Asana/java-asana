package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class CustomField {

    public static class EnumOption {
      public String id;
      public String name;
      public Boolean enabled;
      public String color;
    }


    public String id;
    public String name;
    public String type;

    // Only for type "number"
    public Integer precision;
    // Only for type "enum"
    @SerializedName("enum_options")
    public Collection<EnumOption> enumOptions;

}

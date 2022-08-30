package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class CustomField extends ResourceWithSubtype {

    public static class EnumOption extends ResourceWithSubtype {
        public String name;
        public Boolean enabled;
        public String color;
    }

    public String name;
    public String description;
    public String type;

    // Only for type "text"
    @SerializedName("text_value")
    public String textValue;

    // Only for type "number"
    public int precision;
    @SerializedName("number_value")
    public String numberValue;

    // Only for type "enum"
    @SerializedName("enum_options")
    public Collection<EnumOption> enumOptions;
    @SerializedName("enum_value")
    public EnumOption enumValue;

    // Only for type "multi_enum"
    @SerializedName("multi_enum_values")
    public Collection<EnumOption> multiEnumValues;
}

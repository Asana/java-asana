package com.asana.models;

import java.math.BigDecimal;
import java.util.Collection;

import com.google.gson.annotations.SerializedName;

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

    @SerializedName("number_value")
    public BigDecimal numberValue;

    public BigDecimal getNumberValue() {
        if ((numberValue == null) || (precision == null)) {
            return numberValue;
        } else {
            return numberValue.setScale(this.precision);
        }
    }

    public void setNumberValue(final BigDecimal numberValue) {
        if ((numberValue == null) || (precision == null)) {
            this.numberValue = numberValue;
        } else {
            this.numberValue = numberValue.setScale(this.precision);
        }
    }

}

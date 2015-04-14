package com.asana;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Class to handle serialization/deserialization of JSON
 */
public class Json
{
    private static Gson instance;

    /**
     * Implements ISO 3339 date/time deserialization since SimpleDateFormat in Java 6 does not support the "X" format specifier
     */
    private static class ISO3339DateDeserializer implements JsonDeserializer<Date>
    {
        @Override
        public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            format.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                return format.parse(jsonElement.getAsString());
            } catch (ParseException e) {
                System.err.println("Couldn't parse date: " + jsonElement.getAsString());
                return null;
            }
        }
    }

    /**
     * @return Singleton instance of the Gson parser that handle Asana's date format (ISO 3339)
     */
    static public Gson getInstance()
    {
        if (instance == null) {
            instance = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new ISO3339DateDeserializer())
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
        }
        return instance;
    }
}

package com.asana;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Json
{
    private static Gson instance;

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

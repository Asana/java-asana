package com.asana;

import com.google.api.client.util.DateTime;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;

/**
 * Class to handle serialization/deserialization of JSON
 */
public class Json {
    private static Gson instance;

    /**
     * Implements ISO 3339 date/time deserialization since SimpleDateFormat in Java 6 does not support the "X" format specifier
     */
    private static class ISO3339DateDeserializer implements JsonDeserializer<DateTime> {
        @Override
        public DateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            DateTime result = null;
            try {
                String date = jsonElement.getAsString();
                result = DateTime.parseRfc3339(date);
            } catch (NumberFormatException e)  {
                System.err.println("Couldn't parse date: " + jsonElement.getAsString());
            }
            return result;
        }
    }

    /**
     * @return Singleton instance of the Gson parser that handle Asana's date format (ISO 3339)
     */
    static public Gson getInstance() {
        if (instance == null) {
            instance = new GsonBuilder()
                    .registerTypeAdapter(DateTime.class, new ISO3339DateDeserializer())
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
        }
        return instance;
    }
}

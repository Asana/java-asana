package com.asana;

import com.google.gson.annotations.SerializedName;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class JsonTest
{
    class DemoModel
    {
        public String name;
        @SerializedName("created_at") public Date createdAt;
    }

    @Test
    public void testJsonParsing()
    {
        String json = "{\"name\":\"abc\", \"created_at\":\"2015-01-02T03:04:05.006Z\"}";
        DemoModel model = Json.getInstance().fromJson(json, DemoModel.class);

        assertNotEquals(null, model);
        assertEquals("abc", model.name);

        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        cal.setTime(model.createdAt);

        assertEquals(2015, cal.get(Calendar.YEAR));
        assertEquals(1, cal.get(Calendar.MONTH)+1);
        assertEquals(2, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(3, cal.get(Calendar.HOUR_OF_DAY));
        assertEquals(4, cal.get(Calendar.MINUTE));
        assertEquals(5, cal.get(Calendar.SECOND));
        assertEquals(6, cal.get(Calendar.MILLISECOND));
        assertEquals(0, cal.get(Calendar.ZONE_OFFSET));
    }
}

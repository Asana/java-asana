package com.asana.resources;

import com.asana.AsanaTest;
import com.asana.models.Attachment;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AttachmentsTest extends AsanaTest
{
    @Test
    public void testAttachmentsCreateOnTask() throws IOException
    {
        String fileName = "filename";
        String fileType = "text/plain";
        String fileContent = "hello world";

        String res = "{\"data\":{\"id\":\"2\",\"name\":\"" + fileName + "\"}}";
        dispatcher.registerResponse("POST", "http://app/tasks/1/attachments").code(200).content(res);

        Attachment attachment = client.attachments.createOnTask(
                "1",
                new ByteArrayInputStream(fileContent.getBytes()),
                fileName,
                fileType
        ).execute();

        assertEquals("2", attachment.id);
        assertEquals(fileName, attachment.name);

        // TODO: real multipart parsing?
        String body = dispatcher.calls.get(0).requestBody;
        String contentType = dispatcher.calls.get(0).request.getContentType();

        Matcher contentTypeMatcher = Pattern.compile("^multipart/form-data; boundary=(.*)$", Pattern.CASE_INSENSITIVE).matcher(contentType);
        assertTrue(contentTypeMatcher.matches());
        String boundary = contentTypeMatcher.group(1);

        assertTrue(Pattern.compile("\r\n[cC]ontent-[tT]ype: " + Pattern.quote(fileType) + "\r\n").matcher(body).find());
        assertTrue(Pattern.compile("\r\n[cC]ontent-[dD]isposition: .*form-data(;|\r\n)").matcher(body).find());
        assertTrue(Pattern.compile("\r\n[cC]ontent-[dD]isposition: .*name=\"file\"(;|\r\n)").matcher(body).find());
        assertTrue(Pattern.compile("\r\n[cC]ontent-[dD]isposition: .*filename=\"" + Pattern.quote(fileName) + "\"(;|\r\n)").matcher(body).find());
        assertTrue(Pattern.compile("\r\n\r\n" +  Pattern.quote(fileContent) + "\r\n--" + Pattern.quote(boundary) + "--\r\n$").matcher(body).find());
    }
}

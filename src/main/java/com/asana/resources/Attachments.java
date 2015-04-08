package com.asana.resources;

import com.asana.Client;
import com.asana.models.Attachment;
import com.asana.requests.ItemRequest;
import com.asana.resources.gen.AttachmentsBase;
import com.google.api.client.http.*;

import java.io.InputStream;
import java.util.UUID;

public class Attachments extends AttachmentsBase
{
    public Attachments(Client client)
    {
        super(client);
    }

    public ItemRequest<Attachment> createOnTask(String task, InputStream fileContent, String fileName, String fileType)
    {
        MultipartContent.Part part = new MultipartContent.Part()
                .setContent(new InputStreamContent(fileType, fileContent))
                .setHeaders(new HttpHeaders().set(
                        "Content-Disposition",
                        String.format("form-data; name=\"file\"; filename=\"%s\"", fileName) // TODO: escape fileName?
                ));
        MultipartContent content = new MultipartContent()
                .setMediaType(new HttpMediaType("multipart/form-data").setParameter("boundary", UUID.randomUUID().toString()))
                .addPart(part);

        String path = String.format("/tasks/%s/attachments", task);
        return new ItemRequest<Attachment>(this, Attachment.class, path, "POST")
                .data(content);
    }
}

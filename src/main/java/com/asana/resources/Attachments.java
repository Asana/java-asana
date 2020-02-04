package com.asana.resources;

import com.asana.Client;
import com.asana.models.Attachment;
import com.asana.requests.CollectionRequest;
import com.asana.requests.ItemRequest;
import com.asana.resources.gen.AttachmentsBase;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.MultipartContent;

import java.io.InputStream;
import java.util.UUID;

public class Attachments extends AttachmentsBase {
    public Attachments(Client client) {
        super(client);
    }

    /**
     * Upload a file and attach it to a task
     *
     * @param task        Globally unique identifier for the task.
     * @param fileContent Content of the file to be uploaded
     * @param fileName    Name of the file to be uploaded
     * @param fileType    MIME type of the file to be uploaded
     * @return Request object
     */
    public ItemRequest<Attachment> createOnTask(String task, InputStream fileContent, String fileName, String fileType) {
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

    /**
     * Returns the full record for a single attachment.
     *
     * @param  attachment Globally unique identifier for the attachment.
     * @return Request object
     */
    public ItemRequest<Attachment> findById(String attachment) {

        String path = String.format("/attachments/%s", attachment);
        return new ItemRequest<Attachment>(this, Attachment.class, path, "GET");
    }

    /**
     * Returns the compact records for all attachments on the task.
     *
     * @param  task Globally unique identifier for the task.
     * @return Request object
     */
    public CollectionRequest<Attachment> findByTask(String task) {

        String path = String.format("/tasks/%s/attachments", task);
        return new CollectionRequest<Attachment>(this, Attachment.class, path, "GET");
    }
}

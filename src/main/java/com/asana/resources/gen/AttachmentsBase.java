package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.models.Attachment;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

/**
 * An _attachment_ object represents any file attached to a task in Asana,
 * whether it's an uploaded file or one associated via a third-party service
 * such as Dropbox or Google Drive.
 */
public class AttachmentsBase extends Resource {
    /**
     * @param client Parent client instance
     */
    public AttachmentsBase(Client client) {
        super(client);
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

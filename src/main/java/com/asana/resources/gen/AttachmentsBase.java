package com.asana.resources.gen;

import com.asana.Client;
import com.asana.models.Attachment;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

public class AttachmentsBase extends Resource
{
    public AttachmentsBase(Client client)
    {
        super(client);
    }

    public ItemRequest<Attachment> findById(String attachment)
    {
        String path = String.format("/attachments/%s", attachment);
        return new ItemRequest<Attachment>(this, Attachment.class, path, "GET");
    }

    public CollectionRequest<Attachment> findByTask(String task)
    {
        String path = String.format("/tasks/%s/attachments", task);
        return new CollectionRequest<Attachment>(this, Attachment.class, path, "GET");
    }
}

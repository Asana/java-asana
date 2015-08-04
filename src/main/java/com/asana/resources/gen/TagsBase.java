package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.models.Tag;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

/**
 * A _tag_ is a label that can be attached to any task in Asana. It exists in a
 * single workspace or organization.
 * 
 * Tags have some metadata associated with them, but it is possible that we will
 * simplify them in the future so it is not encouraged to rely too heavily on it.
 * Unlike projects, tags do not provide any ordering on the tasks they
 * are associated with.
 */
public class TagsBase extends Resource
{
    /**
     * @param client Parent client instance
     */
    public TagsBase(Client client)
    {
        super(client);
    }

    /**
     * Creates a new tag in a workspace or organization.
     * 
     * Every tag is required to be created in a specific workspace or
     * organization, and this cannot be changed once set. Note that you can use
     * the `workspace` parameter regardless of whether or not it is an
     * organization.
     * 
     * Returns the full record of the newly created tag.
     *
     * @return Request object
     */
    public ItemRequest<Tag> create()
    {
        return new ItemRequest<Tag>(this, Tag.class, "/tags", "POST");
    }

    /**
     * Creates a new tag in a workspace or organization.
     * 
     * Every tag is required to be created in a specific workspace or
     * organization, and this cannot be changed once set. Note that you can use
     * the `workspace` parameter regardless of whether or not it is an
     * organization.
     * 
     * Returns the full record of the newly created tag.
     *
     * @param  workspace The workspace or organization to create the tag in.
     * @return Request object
     */
    public ItemRequest<Tag> createInWorkspace(String workspace)
    {
        String path = String.format("/workspaces/%s/tags", workspace);
        return new ItemRequest<Tag>(this, Tag.class, path, "POST");
    }

    /**
     * Returns the complete tag record for a single tag.
     *
     * @param  tag The tag to get.
     * @return Request object
     */
    public ItemRequest<Tag> findById(String tag)
    {
        String path = String.format("/tags/%s", tag);
        return new ItemRequest<Tag>(this, Tag.class, path, "GET");
    }

    /**
     * Updates the properties of a tag. Only the fields provided in the `data`
     * block will be updated; any unspecified fields will remain unchanged.
     * 
     * When using this method, it is best to specify only those fields you wish
     * to change, or else you may overwrite changes made by another user since
     * you last retrieved the task.
     * 
     * Returns the complete updated tag record.
     *
     * @param  tag The tag to update.
     * @return Request object
     */
    public ItemRequest<Tag> update(String tag)
    {
        String path = String.format("/tags/%s", tag);
        return new ItemRequest<Tag>(this, Tag.class, path, "PUT");
    }

    /**
     * A specific, existing tag can be deleted by making a DELETE request
     * on the URL for that tag.
     * 
     * Returns an empty data record.
     *
     * @param  tag The tag to delete.
     * @return Request object
     */
    public ItemRequest<Tag> delete(String tag)
    {
        String path = String.format("/tags/%s", tag);
        return new ItemRequest<Tag>(this, Tag.class, path, "DELETE");
    }

    /**
     * Returns the compact tag records for some filtered set of tags.
     * Use one or more of the parameters provided to filter the tags returned.
     *
     * @return Request object
     */
    public CollectionRequest<Tag> findAll()
    {
        return new CollectionRequest<Tag>(this, Tag.class, "/tags", "GET");
    }

    /**
     * Returns the compact tag records for all tags in the workspace.
     *
     * @param  workspace The workspace or organization to find tags in.
     * @return Request object
     */
    public CollectionRequest<Tag> findByWorkspace(String workspace)
    {
        String path = String.format("/workspaces/%s/tags", workspace);
        return new CollectionRequest<Tag>(this, Tag.class, path, "GET");
    }
}

package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.models.CustomField;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

/**
 * Custom Fields store the metadata that is used in order to add user-specified
 * information to tasks in Asana. Be sure to reference the [Custom
 * Fields](/developers/documentation/getting-started/custom-fields) developer
 * documentation for more information about how custom fields relate to various
 * resources in Asana.
 */
public class CustomFieldsBase extends Resource {
    /**
     * @param client Parent client instance
     */
    public CustomFieldsBase(Client client) {
        super(client);
    }

    /**
     * Returns the complete definition of a custom field's metadata.
     *
     * @param  customField Globally unique identifier for the custom field.
     * @return Request object
     */
    public ItemRequest<CustomField> findById(String customField) {
    
        String path = String.format("/custom_fields/%s", customField);
        return new ItemRequest<CustomField>(this, CustomField.class, path, "GET");
    }

    /**
     * Returns a list of the compact representation of all of the custom fields in a workspace.
     *
     * @param  workspace The workspace or organization to find custom field definitions in.
     * @return Request object
     */
    public CollectionRequest<CustomField> findByWorkspace(String workspace) {
    
        String path = String.format("/workspaces/%s/custom_fields", workspace);
        return new CollectionRequest<CustomField>(this, CustomField.class, path, "GET");
    }
}
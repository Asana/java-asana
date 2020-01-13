package com.asana.resources;

import com.asana.Client;
import com.asana.models.CustomField;
import com.asana.requests.CollectionRequest;
import com.asana.requests.ItemRequest;
import com.asana.resources.gen.CustomFieldsBase;

public class CustomFields extends CustomFieldsBase {
    public CustomFields(Client client) {
        super(client);
    }

    /**
     * Creates a new custom field in a workspace. Every custom field is required to be created in a specific workspace, and this workspace cannot be changed once set.
     *
     * A custom field's `name` must be unique within a workspace and not conflict with names of existing task properties such as 'Due Date' or 'Assignee'. A custom field's `type` must be one of  'text', 'enum', or 'number'.
     *
     * Returns the full record of the newly created custom field.
     *
     * @return Request object
     */
    public ItemRequest<CustomField> create() {

        return new ItemRequest<CustomField>(this, CustomField.class, "/custom_fields", "POST");
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

    /**
     * A specific, existing custom field can be updated by making a PUT request on the URL for that custom field. Only the fields provided in the `data` block will be updated; any unspecified fields will remain unchanged
     *
     * When using this method, it is best to specify only those fields you wish to change, or else you may overwrite changes made by another user since you last retrieved the custom field.
     *
     * An enum custom field's `enum_options` cannot be updated with this endpoint. Instead see "Work With Enum Options" for information on how to update `enum_options`.
     *
     * Locked custom fields can only be updated by the user who locked the field.
     *
     * Returns the complete updated custom field record.
     *
     * @param  customField Globally unique identifier for the custom field.
     * @return Request object
     */
    public ItemRequest<CustomField> update(String customField) {

        String path = String.format("/custom_fields/%s", customField);
        return new ItemRequest<CustomField>(this, CustomField.class, path, "PUT");
    }

    /**
     * A specific, existing custom field can be deleted by making a DELETE request on the URL for that custom field.
     *
     * Locked custom fields can only be deleted by the user who locked the field.
     *
     * Returns an empty data record.
     *
     * @param  customField Globally unique identifier for the custom field.
     * @return Request object
     */
    public ItemRequest<CustomField> delete(String customField) {

        String path = String.format("/custom_fields/%s", customField);
        return new ItemRequest<CustomField>(this, CustomField.class, path, "DELETE");
    }

    /**
     * Creates an enum option and adds it to this custom field's list of enum options. A custom field can have at most 50 enum options (including disabled options). By default new enum options are inserted at the end of a custom field's list.
     *
     * Locked custom fields can only have enum options added by the user who locked the field.
     *
     * Returns the full record of the newly created enum option.
     *
     * @param  customField Globally unique identifier for the custom field.
     * @return Request object
     */
    public ItemRequest<CustomField> createEnumOption(String customField) {

        String path = String.format("/custom_fields/%s/enum_options", customField);
        return new ItemRequest<CustomField>(this, CustomField.class, path, "POST");
    }

    /**
     * Updates an existing enum option. Enum custom fields require at least one enabled enum option.
     *
     * Locked custom fields can only be updated by the user who locked the field.
     *
     * Returns the full record of the updated enum option.
     *
     * @param  enumOption Globally unique identifier for the enum option.
     * @return Request object
     */
    public ItemRequest<CustomField> updateEnumOption(String enumOption) {

        String path = String.format("/enum_options/%s", enumOption);
        return new ItemRequest<CustomField>(this, CustomField.class, path, "PUT");
    }

    /**
     * Moves a particular enum option to be either before or after another specified enum option in the custom field.
     *
     * Locked custom fields can only be reordered by the user who locked the field.
     *
     * @param  customField Globally unique identifier for the custom field.
     * @return Request object
     */
    public ItemRequest<CustomField> insertEnumOption(String customField) {

        String path = String.format("/custom_fields/%s/enum_options/insert", customField);
        return new ItemRequest<CustomField>(this, CustomField.class, path, "POST");
    }
}

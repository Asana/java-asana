package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.gen.CustomFieldRequest;
import com.asana.models.gen.CustomFieldResponse;
import com.asana.models.gen.EmptyObject;
import com.asana.models.gen.EnumOptionCompact;
import com.asana.models.gen.EnumOptionInsertRequest;
import com.asana.models.gen.EnumOptionRequest;
import com.asana.models.gen.ErrorResponse;
import java.io.IOException;
import java.util.List;

public class CustomFieldsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public CustomFieldsBase(Client client) { super(client); }

    /**
     * Create a custom field
     * Creates a new custom field in a workspace. Every custom field is required to be created in a specific workspace, and this workspace cannot be changed once set.  A custom field’s name must be unique within a workspace and not conflict with names of existing task properties such as ‘Due Date’ or ‘Assignee’. A custom field’s type must be one of ‘text’, ‘enum’, or ‘number’.  Returns the full record of the newly created custom field.
     * @param body The custom field object to create. (optional)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<CustomFieldResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<CustomFieldResponse> createCustomField(CustomFieldRequest body, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/custom_fields";

        ItemRequest<CustomFieldResponse> req = new ItemRequest<CustomFieldResponse>(this, CustomFieldResponse.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<CustomFieldResponse> createCustomField(CustomFieldRequest body) throws IOException {
        return createCustomField(body, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Create an enum option
     * Creates an enum option and adds it to this custom field’s list of enum options. A custom field can have at most 50 enum options (including disabled options). By default new enum options are inserted at the end of a custom field’s list. Locked custom fields can only have enum options added by the user who locked the field. Returns the full record of the newly created enum option.
     * @param customFieldGid Globally unique identifier for the custom field. (required)
     * @param body The enum option object to create. (optional)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EnumOptionCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EnumOptionCompact> createEnumOptionForCustomField(String customFieldGid, EnumOptionRequest body, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/custom_fields/{custom_field_gid}/enum_options".replace("{custom_field_gid}", customFieldGid);

        ItemRequest<EnumOptionCompact> req = new ItemRequest<EnumOptionCompact>(this, EnumOptionCompact.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<EnumOptionCompact> createEnumOptionForCustomField(String customFieldGid, EnumOptionRequest body) throws IOException {
        return createEnumOptionForCustomField(customFieldGid, body, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Delete a custom field
     * A specific, existing custom field can be deleted by making a DELETE request on the URL for that custom field. Locked custom fields can only be deleted by the user who locked the field. Returns an empty data record.
     * @param customFieldGid Globally unique identifier for the custom field. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EmptyObject>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EmptyObject> deleteCustomField(String customFieldGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/custom_fields/{custom_field_gid}".replace("{custom_field_gid}", customFieldGid);

        ItemRequest<EmptyObject> req = new ItemRequest<EmptyObject>(this, EmptyObject.class, path, "DELETE")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<EmptyObject> deleteCustomField(String customFieldGid) throws IOException {
        return deleteCustomField(customFieldGid, null, false);
    }

    /**
     * Get a custom field
     * Get the complete definition of a custom field’s metadata.  Since custom fields can be defined for one of a number of types, and these types have different data and behaviors, there are fields that are relevant to a particular type. For instance, as noted above, enum_options is only relevant for the enum type and defines the set of choices that the enum could represent. The examples below show some of these type-specific custom field definitions.
     * @param customFieldGid Globally unique identifier for the custom field. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<CustomFieldResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<CustomFieldResponse> getCustomField(String customFieldGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/custom_fields/{custom_field_gid}".replace("{custom_field_gid}", customFieldGid);

        ItemRequest<CustomFieldResponse> req = new ItemRequest<CustomFieldResponse>(this, CustomFieldResponse.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<CustomFieldResponse> getCustomField(String customFieldGid) throws IOException {
        return getCustomField(customFieldGid, null, false);
    }

    /**
     * Get a workspace&#x27;s custom fields
     * Returns a list of the compact representation of all of the custom fields in a workspace.
     * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<EnumOptionCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<EnumOptionCompact> getCustomFieldsForWorkspace(String workspaceGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/workspaces/{workspace_gid}/custom_fields".replace("{workspace_gid}", workspaceGid);

        CollectionRequest<EnumOptionCompact> req = new CollectionRequest<EnumOptionCompact>(this, EnumOptionCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<EnumOptionCompact> getCustomFieldsForWorkspace(String workspaceGid) throws IOException {
        return getCustomFieldsForWorkspace(workspaceGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Reorder a custom field&#x27;s enum
     * Moves a particular enum option to be either before or after another specified enum option in the custom field. Locked custom fields can only be reordered by the user who locked the field.
     * @param customFieldGid Globally unique identifier for the custom field. (required)
     * @param body The enum option object to create. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EnumOptionCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EnumOptionCompact> insertEnumOptionForCustomField(String customFieldGid, EnumOptionInsertRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/custom_fields/{custom_field_gid}/enum_options/insert".replace("{custom_field_gid}", customFieldGid);

        ItemRequest<EnumOptionCompact> req = new ItemRequest<EnumOptionCompact>(this, EnumOptionCompact.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<EnumOptionCompact> insertEnumOptionForCustomField(String customFieldGid, EnumOptionInsertRequest body) throws IOException {
        return insertEnumOptionForCustomField(customFieldGid, body, null, false);
    }

    /**
     * Update a custom field
     * A specific, existing custom field can be updated by making a PUT request on the URL for that custom field. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged When using this method, it is best to specify only those fields you wish to change, or else you may overwrite changes made by another user since you last retrieved the custom field. A custom field’s &#x60;type&#x60; cannot be updated. An enum custom field’s &#x60;enum_options&#x60; cannot be updated with this endpoint. Instead see “Work With Enum Options” for information on how to update &#x60;enum_options&#x60;. Locked custom fields can only be updated by the user who locked the field. Returns the complete updated custom field record.
     * @param customFieldGid Globally unique identifier for the custom field. (required)
     * @param body The custom field object with all updated properties. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<CustomFieldResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<CustomFieldResponse> updateCustomField(String customFieldGid, CustomFieldRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/custom_fields/{custom_field_gid}".replace("{custom_field_gid}", customFieldGid);

        ItemRequest<CustomFieldResponse> req = new ItemRequest<CustomFieldResponse>(this, CustomFieldResponse.class, path, "PUT")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<CustomFieldResponse> updateCustomField(String customFieldGid, CustomFieldRequest body) throws IOException {
        return updateCustomField(customFieldGid, body, null, false);
    }

    /**
     * Update an enum option
     * Updates an existing enum option. Enum custom fields require at least one enabled enum option. Locked custom fields can only be updated by the user who locked the field. Returns the full record of the updated enum option.
     * @param enumOptionGid Globally unique identifier for the enum option. (required)
     * @param body The enum option object to update (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EnumOptionCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EnumOptionCompact> updateEnumOption(String enumOptionGid, EnumOptionRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/enum_options/{enum_option_gid}".replace("{enum_option_gid}", enumOptionGid);

        ItemRequest<EnumOptionCompact> req = new ItemRequest<EnumOptionCompact>(this, EnumOptionCompact.class, path, "PUT")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<EnumOptionCompact> updateEnumOption(String enumOptionGid, EnumOptionRequest body) throws IOException {
        return updateEnumOption(enumOptionGid, body, null, false);
    }

}

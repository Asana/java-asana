package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.models.CustomFieldSetting;
import com.asana.requests.ItemRequest;

/**
 * Custom fields are attached to a particular project with the Custom
 * Field Settings resource. This resource both represents the many-to-many join
 * of the Custom Field and Project as well as stores information that is relevant to that
 * particular pairing; for instance, the `is_important` property determines
 * some possible application-specific handling of that custom field (see below)
 */
public class CustomFieldSettingsBase extends Resource {
    /**
     * @param client Parent client instance
     */
    public CustomFieldSettingsBase(Client client) {
        super(client);
    }

    /**
     * Returns a list of all of the custom fields settings on a project, in compact form. Note that, as in all queries to collections which return compact representation, `opt_fields` and `opt_expand` can be used to include more data than is returned in the compact representation. See the getting started guide on [input/output options](/developers/documentation/getting-started/input-output-options) for more information.
     *
     * @param  project The ID of the project for which to list custom field settings
     * @return Request object
     */
    public ItemRequest<CustomFieldSetting> findByProject(String project) {
    
        String path = String.format("/projects/%s/custom_field_settings", project);
        return new ItemRequest<CustomFieldSetting>(this, CustomFieldSetting.class, path, "GET");
    }
}

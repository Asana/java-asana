package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.models.CustomFieldSetting;
import com.asana.requests.CollectionRequest;

/**
 * Custom fields are applied to a particular project or portfolio with the
 * Custom Field Settings resource. This resource both represents the
 * many-to-many join of the Custom Field and Project or Portfolio as well as
 * stores information that is relevant to that particular pairing; for instance,
 * the `is_important` property determines some possible application-specific
 * handling of that custom field and parent.
 */
public class CustomFieldSettingsBase extends Resource {
    /**
     * @param client Parent client instance
     */
    public CustomFieldSettingsBase(Client client) {
        super(client);
    }

    /**
     * Returns a list of all of the custom fields settings on a project.
     *
     * @param  project The ID of the project for which to list custom field settings
     * @return Request object
     */
    public CollectionRequest<CustomFieldSetting> findByProject(String project) {

        String path = String.format("/projects/%s/custom_field_settings", project);
        return new CollectionRequest<CustomFieldSetting>(this, CustomFieldSetting.class, path, "GET");
    }

    /**
     * Returns a list of all of the custom fields settings on a portfolio.
     *
     * @param  portfolio The ID of the portfolio for which to list custom field settings
     * @return Request object
     */
    public CollectionRequest<CustomFieldSetting> findByPortfolio(String portfolio) {

        String path = String.format("/portfolios/%s/custom_field_settings", portfolio);
        return new CollectionRequest<CustomFieldSetting>(this, CustomFieldSetting.class, path, "GET");
    }
}

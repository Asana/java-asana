package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.models.OrganizationExport;
import com.asana.requests.ItemRequest;

/**
 * An _organization_export_ object represents a request to export the complete data of an Organization
 * in JSON format.
 * 
 * To export an Organization using this API:
 * 
 * * Create an `organization_export` [request](#create) and store the id that is returned.\
 * * Request the `organization_export` every few minutes, until the `state` field contains 'finished'.\
 * * Download the file located at the URL in the `download_url` field.
 * 
 * Exports can take a long time, from several minutes to a few hours for large Organizations.
 * 
 * **Note:** These endpoints are only available to [Service Accounts](/guide/help/premium/service-accounts)
 * of an [Enterprise](/enterprise) Organization.
 */
public class OrganizationExportsBase extends Resource {
    /**
     * @param client Parent client instance
     */
    public OrganizationExportsBase(Client client) {
        super(client);
    }

    /**
     * Returns details of a previously-requested Organization export.
     *
     * @param  organizationExport Globally unique identifier for the Organization export.
     * @return Request object
     */
    public ItemRequest<OrganizationExport> findById(String organizationExport) {
    
        String path = String.format("/organization_exports/%s", organizationExport);
        return new ItemRequest<OrganizationExport>(this, OrganizationExport.class, path, "GET");
    }

    /**
     * This method creates a request to export an Organization. Asana will complete the export at some
     * point after you create the request.
     *
     * @return Request object
     */
    public ItemRequest<OrganizationExport> create() {
    
        return new ItemRequest<OrganizationExport>(this, OrganizationExport.class, "/organization_exports", "POST");
    }
}
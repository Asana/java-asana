package com.asana.resources;

import com.asana.Client;
import com.asana.models.OrganizationExport;
import com.asana.requests.ItemRequest;
import com.asana.resources.gen.OrganizationExportsBase;

public class OrganizationExports extends OrganizationExportsBase {
    public OrganizationExports(Client client) {
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

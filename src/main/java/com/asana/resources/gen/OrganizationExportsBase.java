package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.OrganizationExport;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.util.List;

    public class OrganizationExportsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public OrganizationExportsBase(Client client) { super(client); }

            /**
            * Create an organization export request
            * This method creates a request to export an Organization. Asana will complete the export at some point after you create the request.
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<OrganizationExport>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<OrganizationExport> createOrganizationExport(String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/organization_exports";

                ItemRequest<OrganizationExport> req = new ItemRequest<OrganizationExport>(this, OrganizationExport.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public ItemRequest<OrganizationExport> createOrganizationExport() throws IOException {
                return createOrganizationExport(null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Get details on an org export request
            * Returns details of a previously-requested Organization export.
                * @param organizationExportGid Globally unique identifier for the organization export. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<OrganizationExport>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<OrganizationExport> getOrganizationExport(String organizationExportGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/organization_exports/{organization_export_gid}".replace("{organization_export_gid}", organizationExportGid);

                ItemRequest<OrganizationExport> req = new ItemRequest<OrganizationExport>(this, OrganizationExport.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<OrganizationExport> getOrganizationExport(String organizationExportGid) throws IOException {
                return getOrganizationExport(organizationExportGid, null, false);
            }

    }

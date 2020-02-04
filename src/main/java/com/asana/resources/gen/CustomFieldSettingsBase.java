package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.*;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

    public class CustomFieldSettingsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public CustomFieldSettingsBase(Client client) { super(client); }

        /**
        * Get a portfolio&#x27;s custom fields
        * Returns a list of all of the custom fields settings on a portfolio, in compact form.
            * @param portfolioGid Globally unique identifier for the portfolio. (required)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest<CustomFieldSetting>
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<CustomFieldSetting> getCustomFieldSettingsForPortfolio(String portfolioGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/portfolios/{portfolio_gid}/custom_field_settings".replace("{portfolio_gid}", portfolioGid);

            CollectionRequest<CustomFieldSetting> req = new CollectionRequest<CustomFieldSetting>(this, CustomFieldSetting.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        public CollectionRequest<CustomFieldSetting> getCustomFieldSettingsForPortfolio(String portfolioGid) throws IOException {
            return getCustomFieldSettingsForPortfolio(portfolioGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Get a project&#x27;s custom fields
        * Returns a list of all of the custom fields settings on a project, in compact form. Note that, as in all queries to collections which return compact representation, &#x60;opt_fields&#x60; can be used to include more data than is returned in the compact representation. See the [getting started guide on input/output options](https://developers.asana.com/docs/#input-output-options) for more information.
            * @param projectGid Globally unique identifier for the project. (required)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest<CustomFieldSetting>
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<CustomFieldSetting> getCustomFieldSettingsForProject(String projectGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/projects/{project_gid}/custom_field_settings".replace("{project_gid}", projectGid);

            CollectionRequest<CustomFieldSetting> req = new CollectionRequest<CustomFieldSetting>(this, CustomFieldSetting.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        public CollectionRequest<CustomFieldSetting> getCustomFieldSettingsForProject(String projectGid) throws IOException {
            return getCustomFieldSettingsForProject(projectGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
    }

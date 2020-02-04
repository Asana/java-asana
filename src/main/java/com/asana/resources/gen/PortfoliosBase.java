package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.Portfolio;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.util.List;

    public class PortfoliosBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public PortfoliosBase(Client client) { super(client); }

            /**
            * Add a custom field to a portfolio
            * Custom fields are associated with portfolios by way of custom field settings.  This method creates a setting for the portfolio.
                * @param portfolioGid Globally unique identifier for the portfolio. (required)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> addCustomFieldSettingForPortfolio(String portfolioGid, Boolean optPretty) throws IOException {
                String path = "/portfolios/{portfolio_gid}/addCustomFieldSetting".replace("{portfolio_gid}", portfolioGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty);

                return req;
            }

            public ItemRequest<JsonElement> addCustomFieldSettingForPortfolio(String portfolioGid) throws IOException {
                return addCustomFieldSettingForPortfolio(portfolioGid, false);
            }

            /**
            * Add a portfolio item
            * Add an item to a portfolio. Returns an empty data block.
                * @param portfolioGid Globally unique identifier for the portfolio. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> addItemForPortfolio(String portfolioGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/portfolios/{portfolio_gid}/addItem".replace("{portfolio_gid}", portfolioGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> addItemForPortfolio(String portfolioGid) throws IOException {
                return addItemForPortfolio(portfolioGid, null, false);
            }

            /**
            * Add users to a portfolio
            * Adds the specified list of users as members of the portfolio. Returns the updated portfolio record.
                * @param portfolioGid Globally unique identifier for the portfolio. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> addMembersForPortfolio(String portfolioGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/portfolios/{portfolio_gid}/addMembers".replace("{portfolio_gid}", portfolioGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> addMembersForPortfolio(String portfolioGid) throws IOException {
                return addMembersForPortfolio(portfolioGid, null, false);
            }

            /**
            * Create a portfolio
            * Creates a new portfolio in the given workspace with the supplied name.  Note that portfolios created in the Asana UI may have some state (like the “Priority” custom field) which is automatically added to the portfolio when it is created. Portfolios created via our API will *not* be created with the same initial state to allow integrations to create their own starting state on a portfolio.
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Portfolio>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Portfolio> createPortfolio(List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/portfolios";

                ItemRequest<Portfolio> req = new ItemRequest<Portfolio>(this, Portfolio.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Portfolio> createPortfolio() throws IOException {
                return createPortfolio(null, false);
            }

            /**
            * Delete a portfolio
            * An existing portfolio can be deleted by making a DELETE request on the URL for that portfolio.  Returns an empty data record.
                * @param portfolioGid Globally unique identifier for the portfolio. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> deletePortfolio(String portfolioGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/portfolios/{portfolio_gid}".replace("{portfolio_gid}", portfolioGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "DELETE")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> deletePortfolio(String portfolioGid) throws IOException {
                return deletePortfolio(portfolioGid, null, false);
            }

            /**
            * Get portfolio items
            * Get a list of the items in compact form in a portfolio.
                * @param portfolioGid Globally unique identifier for the portfolio. (required)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Project>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Project> getItemsForPortfolio(String portfolioGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/portfolios/{portfolio_gid}/items".replace("{portfolio_gid}", portfolioGid);

                CollectionRequest<Project> req = new CollectionRequest<Project>(this, Project.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public CollectionRequest<Project> getItemsForPortfolio(String portfolioGid) throws IOException {
                return getItemsForPortfolio(portfolioGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Get a portfolio
            * Returns the complete portfolio record for a single portfolio.
                * @param portfolioGid Globally unique identifier for the portfolio. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Portfolio>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Portfolio> getPortfolio(String portfolioGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/portfolios/{portfolio_gid}".replace("{portfolio_gid}", portfolioGid);

                ItemRequest<Portfolio> req = new ItemRequest<Portfolio>(this, Portfolio.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Portfolio> getPortfolio(String portfolioGid) throws IOException {
                return getPortfolio(portfolioGid, null, false);
            }

            /**
            * Get multiple portfolios
            * Returns a list of the portfolios in compact representation that are owned by the current API user.
                * @param owner The user who owns the portfolio. Currently, API users can only get a list of portfolios that they themselves own. (required)
                * @param workspace The workspace or organization to filter portfolios on. (required)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Portfolio>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Portfolio> getPortfolios(String owner, String workspace, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/portfolios";

                CollectionRequest<Portfolio> req = new CollectionRequest<Portfolio>(this, Portfolio.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset)
                    .query("workspace", workspace)
                    .query("owner", owner);

                return req;
            }

            public CollectionRequest<Portfolio> getPortfolios(String owner, String workspace) throws IOException {
                return getPortfolios(owner, workspace, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Remove a custom field from a portfolio
            * Removes a custom field setting from a portfolio.
                * @param portfolioGid Globally unique identifier for the portfolio. (required)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> removeCustomFieldSettingForPortfolio(String portfolioGid, Boolean optPretty) throws IOException {
                String path = "/portfolios/{portfolio_gid}/removeCustomFieldSetting".replace("{portfolio_gid}", portfolioGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty);

                return req;
            }

            public ItemRequest<JsonElement> removeCustomFieldSettingForPortfolio(String portfolioGid) throws IOException {
                return removeCustomFieldSettingForPortfolio(portfolioGid, false);
            }

            /**
            * Remove a portfolio item
            * Remove an item from a portfolio. Returns an empty data block.
                * @param portfolioGid Globally unique identifier for the portfolio. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> removeItemForPortfolio(String portfolioGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/portfolios/{portfolio_gid}/removeItem".replace("{portfolio_gid}", portfolioGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> removeItemForPortfolio(String portfolioGid) throws IOException {
                return removeItemForPortfolio(portfolioGid, null, false);
            }

            /**
            * Remove users from a portfolio
            * Removes the specified list of users from members of the portfolio. Returns the updated portfolio record.
                * @param portfolioGid Globally unique identifier for the portfolio. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> removeMembersForPortfolio(String portfolioGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/portfolios/{portfolio_gid}/removeMembers".replace("{portfolio_gid}", portfolioGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> removeMembersForPortfolio(String portfolioGid) throws IOException {
                return removeMembersForPortfolio(portfolioGid, null, false);
            }

            /**
            * Update a portfolio
            * An existing portfolio can be updated by making a PUT request on the URL for that portfolio. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged.  Returns the complete updated portfolio record.
                * @param portfolioGid Globally unique identifier for the portfolio. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Portfolio>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Portfolio> updatePortfolio(String portfolioGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/portfolios/{portfolio_gid}".replace("{portfolio_gid}", portfolioGid);

                ItemRequest<Portfolio> req = new ItemRequest<Portfolio>(this, Portfolio.class, path, "PUT")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Portfolio> updatePortfolio(String portfolioGid) throws IOException {
                return updatePortfolio(portfolioGid, null, false);
            }

    }

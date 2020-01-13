package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.gen.EmptyObject;
import com.asana.models.gen.ErrorResponse;
import com.asana.models.gen.PortfolioAddItemRequest;
import com.asana.models.gen.PortfolioAddMembersRequest;
import com.asana.models.gen.PortfolioCompact;
import com.asana.models.gen.PortfolioRemoveItemRequest;
import com.asana.models.gen.PortfolioRemoveMembersRequest;
import com.asana.models.gen.PortfolioRequest;
import com.asana.models.gen.PortfolioResponse;
import com.asana.models.gen.ProjectCompact;
import java.io.IOException;
import java.util.List;

public class PortfoliosBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public PortfoliosBase(Client client) { super(client); }

    /**
     * Add a portfolio item
     * Add an item to a portfolio. Returns an empty data block.
     * @param portfolioGid Globally unique identifier for the portfolio. (required)
     * @param body Information about the item being inserted. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EmptyObject>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EmptyObject> addItemForPortfolio(String portfolioGid, PortfolioAddItemRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/portfolios/{portfolio_gid}/addItem".replace("{portfolio_gid}", portfolioGid);

        ItemRequest<EmptyObject> req = new ItemRequest<EmptyObject>(this, EmptyObject.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<EmptyObject> addItemForPortfolio(String portfolioGid, PortfolioAddItemRequest body) throws IOException {
        return addItemForPortfolio(portfolioGid, body, null, false);
    }

    /**
     * Add users to a portfolio
     * Adds the specified list of users as members of the portfolio. Returns the updated portfolio record.
     * @param portfolioGid Globally unique identifier for the portfolio. (required)
     * @param body Information about the members being added. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EmptyObject>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EmptyObject> addMembersForPortfolio(String portfolioGid, PortfolioAddMembersRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/portfolios/{portfolio_gid}/addMembers".replace("{portfolio_gid}", portfolioGid);

        ItemRequest<EmptyObject> req = new ItemRequest<EmptyObject>(this, EmptyObject.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<EmptyObject> addMembersForPortfolio(String portfolioGid, PortfolioAddMembersRequest body) throws IOException {
        return addMembersForPortfolio(portfolioGid, body, null, false);
    }

    /**
     * Create a portfolio
     * Creates a new portfolio in the given workspace with the supplied name.  Note that portfolios created in the Asana UI may have some state (like the “Priority” custom field) which is automatically added to the portfolio when it is created. Portfolios created via our API will *not* be created with the same initial state to allow integrations to create their own starting state on a portfolio.
     * @param body The portfolio to create. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<PortfolioResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<PortfolioResponse> createPortfolio(PortfolioRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/portfolios";

        ItemRequest<PortfolioResponse> req = new ItemRequest<PortfolioResponse>(this, PortfolioResponse.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<PortfolioResponse> createPortfolio(PortfolioRequest body) throws IOException {
        return createPortfolio(body, null, false);
    }

    /**
     * Delete a portfolio
     * An existing portfolio can be deleted by making a DELETE request on the URL for that portfolio.  Returns an empty data record.
     * @param portfolioGid Globally unique identifier for the portfolio. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EmptyObject>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EmptyObject> deletePortfolio(String portfolioGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/portfolios/{portfolio_gid}".replace("{portfolio_gid}", portfolioGid);

        ItemRequest<EmptyObject> req = new ItemRequest<EmptyObject>(this, EmptyObject.class, path, "DELETE")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<EmptyObject> deletePortfolio(String portfolioGid) throws IOException {
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
     * @return CollectionRequest<ProjectCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<ProjectCompact> getItemsForPortfolio(String portfolioGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/portfolios/{portfolio_gid}/items".replace("{portfolio_gid}", portfolioGid);

        CollectionRequest<ProjectCompact> req = new CollectionRequest<ProjectCompact>(this, ProjectCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<ProjectCompact> getItemsForPortfolio(String portfolioGid) throws IOException {
        return getItemsForPortfolio(portfolioGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Get a portfolio
     * Returns the complete portfolio record for a single portfolio.
     * @param portfolioGid Globally unique identifier for the portfolio. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<PortfolioResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<PortfolioResponse> getPortfolio(String portfolioGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/portfolios/{portfolio_gid}".replace("{portfolio_gid}", portfolioGid);

        ItemRequest<PortfolioResponse> req = new ItemRequest<PortfolioResponse>(this, PortfolioResponse.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<PortfolioResponse> getPortfolio(String portfolioGid) throws IOException {
        return getPortfolio(portfolioGid, null, false);
    }

    /**
     * Get multiple portfolios
     * Returns a list of the portfolios in compact representation that are owned by the current API user.
     * @param workspace The workspace or organization to filter portfolios on. (required)
     * @param owner The user who owns the portfolio. Currently, API users can only get a list of portfolios that they themselves own. (required)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<PortfolioCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<PortfolioCompact> getPortfolios(String workspace, String owner, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/portfolios";

        CollectionRequest<PortfolioCompact> req = new CollectionRequest<PortfolioCompact>(this, PortfolioCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset)
            .query("workspace", workspace)
            .query("owner", owner);

        return req;
    }

    public CollectionRequest<PortfolioCompact> getPortfolios(String workspace, String owner) throws IOException {
        return getPortfolios(workspace, owner, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Remove a portfolio item
     * Remove an item from a portfolio. Returns an empty data block.
     * @param portfolioGid Globally unique identifier for the portfolio. (required)
     * @param body Information about the item being removed. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EmptyObject>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EmptyObject> removeItemForPortfolio(String portfolioGid, PortfolioRemoveItemRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/portfolios/{portfolio_gid}/removeItem".replace("{portfolio_gid}", portfolioGid);

        ItemRequest<EmptyObject> req = new ItemRequest<EmptyObject>(this, EmptyObject.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<EmptyObject> removeItemForPortfolio(String portfolioGid, PortfolioRemoveItemRequest body) throws IOException {
        return removeItemForPortfolio(portfolioGid, body, null, false);
    }

    /**
     * Remove users from a portfolio
     * Removes the specified list of users from members of the portfolio. Returns the updated portfolio record.
     * @param portfolioGid Globally unique identifier for the portfolio. (required)
     * @param body Information about the members being removed. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EmptyObject>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EmptyObject> removeMembersForPortfolio(String portfolioGid, PortfolioRemoveMembersRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/portfolios/{portfolio_gid}/removeMembers".replace("{portfolio_gid}", portfolioGid);

        ItemRequest<EmptyObject> req = new ItemRequest<EmptyObject>(this, EmptyObject.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<EmptyObject> removeMembersForPortfolio(String portfolioGid, PortfolioRemoveMembersRequest body) throws IOException {
        return removeMembersForPortfolio(portfolioGid, body, null, false);
    }

    /**
     * Update a portfolio
     * An existing portfolio can be updated by making a PUT request on the URL for that portfolio. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged.  Returns the complete updated portfolio record.
     * @param portfolioGid Globally unique identifier for the portfolio. (required)
     * @param body The updated fields for the portfolio. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<PortfolioResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<PortfolioResponse> updatePortfolio(String portfolioGid, PortfolioRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/portfolios/{portfolio_gid}".replace("{portfolio_gid}", portfolioGid);

        ItemRequest<PortfolioResponse> req = new ItemRequest<PortfolioResponse>(this, PortfolioResponse.class, path, "PUT")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<PortfolioResponse> updatePortfolio(String portfolioGid, PortfolioRequest body) throws IOException {
        return updatePortfolio(portfolioGid, body, null, false);
    }

}

# PortfoliosApi

All URIs are relative to *https://app.asana.com/api/1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addCustomFieldSettingForPortfolio**](PortfoliosApi.md#addCustomFieldSettingForPortfolio) | **POST** /portfolios/{portfolio_gid}/addCustomFieldSetting | Add a custom field to a portfolio
[**addItemForPortfolio**](PortfoliosApi.md#addItemForPortfolio) | **POST** /portfolios/{portfolio_gid}/addItem | Add a portfolio item
[**addMembersForPortfolio**](PortfoliosApi.md#addMembersForPortfolio) | **POST** /portfolios/{portfolio_gid}/addMembers | Add users to a portfolio
[**createPortfolio**](PortfoliosApi.md#createPortfolio) | **POST** /portfolios | Create a portfolio
[**deletePortfolio**](PortfoliosApi.md#deletePortfolio) | **DELETE** /portfolios/{portfolio_gid} | Delete a portfolio
[**getItemsForPortfolio**](PortfoliosApi.md#getItemsForPortfolio) | **GET** /portfolios/{portfolio_gid}/items | Get portfolio items
[**getPortfolio**](PortfoliosApi.md#getPortfolio) | **GET** /portfolios/{portfolio_gid} | Get a portfolio
[**getPortfolios**](PortfoliosApi.md#getPortfolios) | **GET** /portfolios | Get multiple portfolios
[**removeCustomFieldSettingForPortfolio**](PortfoliosApi.md#removeCustomFieldSettingForPortfolio) | **POST** /portfolios/{portfolio_gid}/removeCustomFieldSetting | Remove a custom field from a portfolio
[**removeItemForPortfolio**](PortfoliosApi.md#removeItemForPortfolio) | **POST** /portfolios/{portfolio_gid}/removeItem | Remove a portfolio item
[**removeMembersForPortfolio**](PortfoliosApi.md#removeMembersForPortfolio) | **POST** /portfolios/{portfolio_gid}/removeMembers | Remove users from a portfolio
[**updatePortfolio**](PortfoliosApi.md#updatePortfolio) | **PUT** /portfolios/{portfolio_gid} | Update a portfolio

<a name="addCustomFieldSettingForPortfolio"></a>
# **addCustomFieldSettingForPortfolio**
> InlineResponse20017 addCustomFieldSettingForPortfolio(body, portfolioGid, optPretty)

Add a custom field to a portfolio

Custom fields are associated with portfolios by way of custom field settings.  This method creates a setting for the portfolio.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.PortfoliosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


PortfoliosApi apiInstance = new PortfoliosApi();
PortfolioGidAddCustomFieldSettingBody body = new PortfolioGidAddCustomFieldSettingBody(); // PortfolioGidAddCustomFieldSettingBody | Information about the custom field setting.
String portfolioGid = "portfolioGid_example"; // String | Globally unique identifier for the portfolio.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
try {
    InlineResponse20017 result = apiInstance.addCustomFieldSettingForPortfolio(body, portfolioGid, optPretty);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfoliosApi#addCustomFieldSettingForPortfolio");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PortfolioGidAddCustomFieldSettingBody**](PortfolioGidAddCustomFieldSettingBody.md)| Information about the custom field setting. |
 **portfolioGid** | **String**| Globally unique identifier for the portfolio. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]

### Return type

[**InlineResponse20017**](InlineResponse20017.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addItemForPortfolio"></a>
# **addItemForPortfolio**
> InlineResponse2001 addItemForPortfolio(body, portfolioGid, optPretty, optFields)

Add a portfolio item

Add an item to a portfolio. Returns an empty data block.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.PortfoliosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


PortfoliosApi apiInstance = new PortfoliosApi();
PortfolioGidAddItemBody body = new PortfolioGidAddItemBody(); // PortfolioGidAddItemBody | Information about the item being inserted.
String portfolioGid = "portfolioGid_example"; // String | Globally unique identifier for the portfolio.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.addItemForPortfolio(body, portfolioGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfoliosApi#addItemForPortfolio");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PortfolioGidAddItemBody**](PortfolioGidAddItemBody.md)| Information about the item being inserted. |
 **portfolioGid** | **String**| Globally unique identifier for the portfolio. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addMembersForPortfolio"></a>
# **addMembersForPortfolio**
> InlineResponse2013 addMembersForPortfolio(body, portfolioGid, optPretty, optFields)

Add users to a portfolio

Adds the specified list of users as members of the portfolio. Returns the updated portfolio record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.PortfoliosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


PortfoliosApi apiInstance = new PortfoliosApi();
PortfolioGidAddMembersBody body = new PortfolioGidAddMembersBody(); // PortfolioGidAddMembersBody | Information about the members being added.
String portfolioGid = "portfolioGid_example"; // String | Globally unique identifier for the portfolio.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2013 result = apiInstance.addMembersForPortfolio(body, portfolioGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfoliosApi#addMembersForPortfolio");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PortfolioGidAddMembersBody**](PortfolioGidAddMembersBody.md)| Information about the members being added. |
 **portfolioGid** | **String**| Globally unique identifier for the portfolio. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2013**](InlineResponse2013.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createPortfolio"></a>
# **createPortfolio**
> InlineResponse2013 createPortfolio(body, optPretty, optFields)

Create a portfolio

Creates a new portfolio in the given workspace with the supplied name.  Note that portfolios created in the Asana UI may have some state (like the “Priority” custom field) which is automatically added to the portfolio when it is created. Portfolios created via our API will *not* be created with the same initial state to allow integrations to create their own starting state on a portfolio.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.PortfoliosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


PortfoliosApi apiInstance = new PortfoliosApi();
PortfoliosBody body = new PortfoliosBody(); // PortfoliosBody | The portfolio to create.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2013 result = apiInstance.createPortfolio(body, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfoliosApi#createPortfolio");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PortfoliosBody**](PortfoliosBody.md)| The portfolio to create. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2013**](InlineResponse2013.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deletePortfolio"></a>
# **deletePortfolio**
> InlineResponse2001 deletePortfolio(portfolioGid, optPretty, optFields)

Delete a portfolio

An existing portfolio can be deleted by making a DELETE request on the URL for that portfolio.  Returns an empty data record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.PortfoliosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


PortfoliosApi apiInstance = new PortfoliosApi();
String portfolioGid = "portfolioGid_example"; // String | Globally unique identifier for the portfolio.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.deletePortfolio(portfolioGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfoliosApi#deletePortfolio");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **portfolioGid** | **String**| Globally unique identifier for the portfolio. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getItemsForPortfolio"></a>
# **getItemsForPortfolio**
> InlineResponse20016 getItemsForPortfolio(portfolioGid, optPretty, optFields, limit, offset)

Get portfolio items

Get a list of the items in compact form in a portfolio.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.PortfoliosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


PortfoliosApi apiInstance = new PortfoliosApi();
String portfolioGid = "portfolioGid_example"; // String | Globally unique identifier for the portfolio.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20016 result = apiInstance.getItemsForPortfolio(portfolioGid, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfoliosApi#getItemsForPortfolio");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **portfolioGid** | **String**| Globally unique identifier for the portfolio. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20016**](InlineResponse20016.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPortfolio"></a>
# **getPortfolio**
> InlineResponse2013 getPortfolio(portfolioGid, optPretty, optFields)

Get a portfolio

Returns the complete portfolio record for a single portfolio.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.PortfoliosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


PortfoliosApi apiInstance = new PortfoliosApi();
String portfolioGid = "portfolioGid_example"; // String | Globally unique identifier for the portfolio.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2013 result = apiInstance.getPortfolio(portfolioGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfoliosApi#getPortfolio");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **portfolioGid** | **String**| Globally unique identifier for the portfolio. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2013**](InlineResponse2013.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPortfolios"></a>
# **getPortfolios**
> InlineResponse20015 getPortfolios(workspace, owner, optPretty, optFields, limit, offset)

Get multiple portfolios

Returns a list of the portfolios in compact representation that are owned by the current API user.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.PortfoliosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


PortfoliosApi apiInstance = new PortfoliosApi();
String workspace = "workspace_example"; // String | The workspace or organization to filter portfolios on.
String owner = "owner_example"; // String | The user who owns the portfolio. Currently, API users can only get a list of portfolios that they themselves own.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20015 result = apiInstance.getPortfolios(workspace, owner, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfoliosApi#getPortfolios");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workspace** | **String**| The workspace or organization to filter portfolios on. |
 **owner** | **String**| The user who owns the portfolio. Currently, API users can only get a list of portfolios that they themselves own. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20015**](InlineResponse20015.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeCustomFieldSettingForPortfolio"></a>
# **removeCustomFieldSettingForPortfolio**
> InlineResponse2001 removeCustomFieldSettingForPortfolio(body, portfolioGid, optPretty)

Remove a custom field from a portfolio

Removes a custom field setting from a portfolio.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.PortfoliosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


PortfoliosApi apiInstance = new PortfoliosApi();
PortfolioGidRemoveCustomFieldSettingBody body = new PortfolioGidRemoveCustomFieldSettingBody(); // PortfolioGidRemoveCustomFieldSettingBody | Information about the custom field setting being removed.
String portfolioGid = "portfolioGid_example"; // String | Globally unique identifier for the portfolio.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
try {
    InlineResponse2001 result = apiInstance.removeCustomFieldSettingForPortfolio(body, portfolioGid, optPretty);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfoliosApi#removeCustomFieldSettingForPortfolio");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PortfolioGidRemoveCustomFieldSettingBody**](PortfolioGidRemoveCustomFieldSettingBody.md)| Information about the custom field setting being removed. |
 **portfolioGid** | **String**| Globally unique identifier for the portfolio. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeItemForPortfolio"></a>
# **removeItemForPortfolio**
> InlineResponse2001 removeItemForPortfolio(body, portfolioGid, optPretty, optFields)

Remove a portfolio item

Remove an item from a portfolio. Returns an empty data block.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.PortfoliosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


PortfoliosApi apiInstance = new PortfoliosApi();
PortfolioGidRemoveItemBody body = new PortfolioGidRemoveItemBody(); // PortfolioGidRemoveItemBody | Information about the item being removed.
String portfolioGid = "portfolioGid_example"; // String | Globally unique identifier for the portfolio.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.removeItemForPortfolio(body, portfolioGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfoliosApi#removeItemForPortfolio");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PortfolioGidRemoveItemBody**](PortfolioGidRemoveItemBody.md)| Information about the item being removed. |
 **portfolioGid** | **String**| Globally unique identifier for the portfolio. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeMembersForPortfolio"></a>
# **removeMembersForPortfolio**
> InlineResponse2013 removeMembersForPortfolio(body, portfolioGid, optPretty, optFields)

Remove users from a portfolio

Removes the specified list of users from members of the portfolio. Returns the updated portfolio record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.PortfoliosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


PortfoliosApi apiInstance = new PortfoliosApi();
PortfolioGidRemoveMembersBody body = new PortfolioGidRemoveMembersBody(); // PortfolioGidRemoveMembersBody | Information about the members being removed.
String portfolioGid = "portfolioGid_example"; // String | Globally unique identifier for the portfolio.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2013 result = apiInstance.removeMembersForPortfolio(body, portfolioGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfoliosApi#removeMembersForPortfolio");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PortfolioGidRemoveMembersBody**](PortfolioGidRemoveMembersBody.md)| Information about the members being removed. |
 **portfolioGid** | **String**| Globally unique identifier for the portfolio. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2013**](InlineResponse2013.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updatePortfolio"></a>
# **updatePortfolio**
> InlineResponse2013 updatePortfolio(body, portfolioGid, optPretty, optFields)

Update a portfolio

An existing portfolio can be updated by making a PUT request on the URL for that portfolio. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged.  Returns the complete updated portfolio record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.PortfoliosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


PortfoliosApi apiInstance = new PortfoliosApi();
PortfoliosPortfolioGidBody body = new PortfoliosPortfolioGidBody(); // PortfoliosPortfolioGidBody | The updated fields for the portfolio.
String portfolioGid = "portfolioGid_example"; // String | Globally unique identifier for the portfolio.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2013 result = apiInstance.updatePortfolio(body, portfolioGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfoliosApi#updatePortfolio");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PortfoliosPortfolioGidBody**](PortfoliosPortfolioGidBody.md)| The updated fields for the portfolio. |
 **portfolioGid** | **String**| Globally unique identifier for the portfolio. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2013**](InlineResponse2013.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


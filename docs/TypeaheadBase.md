# TypeaheadBase

All URIs are relative to *https://app.asana.com/api/1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**typeaheadForWorkspace**](TypeaheadBase.md#typeaheadForWorkspace) | **GET** /workspaces/{workspace_gid}/typeahead | Get objects via typeahead

<a name="typeaheadForWorkspace"></a>
# **typeaheadForWorkspace**
> AsanaNamedResource typeaheadForWorkspace(workspaceGid, resourceType, type, query, count, optPrettyoptFields, )

Get objects via typeahead

Retrieves objects in the workspace based via an auto-completion/typeahead search algorithm. This feature is meant to provide results quickly, so do not rely on this API to provide extremely accurate search results. The result set is limited to a single page of results with a maximum size, so you won’t be able to fetch large numbers of results.  The typeahead search API provides search for objects from a single workspace. This endpoint should be used to query for objects when creating an auto-completion/typeahead search feature. This API is meant to provide results quickly and should not be relied upon for accurate or exhaustive search results. The results sets are limited in size and cannot be paginated.  Queries return a compact representation of each object which is typically the gid and name fields. Interested in a specific set of fields or all of the fields?! Of course you are. Use field selectors to manipulate what data is included in a response.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TypeaheadBase;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TypeaheadBase apiInstance = new TypeaheadBase();
String workspaceGid = "workspaceGid_example"; // String | Globally unique identifier for the workspace or organization.
String resourceType = "resourceType_example"; // String | The type of values the typeahead should return. You can choose from one of the following: `custom_field`, `project`, `tag`, `task`, and `user`. Note that unlike in the names of endpoints, the types listed here are in singular form (e.g. `task`). Using multiple types is not yet supported.
String type = "type_example"; // String | *Deprecated: new integrations should prefer the resource_type field.*
String query = "query_example"; // String | The string that will be used to search for relevant objects. If an empty string is passed in, the API will currently return an empty result set.
Integer count = 56; // Integer | The number of results to return. The default is 20 if this parameter is omitted, with a minimum of 1 and a maximum of 100. If there are fewer results found than requested, all will be returned.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    AsanaNamedResource result = apiInstance.typeaheadForWorkspace(workspaceGid, resourceType, type, query, count, optPrettyoptFields, );
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TypeaheadBase#typeaheadForWorkspace");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workspaceGid** | **String**| Globally unique identifier for the workspace or organization. |
 **resourceType** | **String**| The type of values the typeahead should return. You can choose from one of the following: &#x60;custom_field&#x60;, &#x60;project&#x60;, &#x60;tag&#x60;, &#x60;task&#x60;, and &#x60;user&#x60;. Note that unlike in the names of endpoints, the types listed here are in singular form (e.g. &#x60;task&#x60;). Using multiple types is not yet supported. | [enum: custom_field, portfolio, project, tag, task, user]
 **type** | **String**| *Deprecated: new integrations should prefer the resource_type field.* | [optional] [enum: custom_field, portfolio, project, tag, task, user]
 **query** | **String**| The string that will be used to search for relevant objects. If an empty string is passed in, the API will currently return an empty result set. | [optional]
 **count** | **Integer**| The number of results to return. The default is 20 if this parameter is omitted, with a minimum of 1 and a maximum of 100. If there are fewer results found than requested, all will be returned. | [optional]
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**AsanaNamedResource**](AsanaNamedResource.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


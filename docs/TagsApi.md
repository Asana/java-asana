# TagsApi

All URIs are relative to *https://app.asana.com/api/1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTag**](TagsApi.md#createTag) | **POST** /tags | Create a tag
[**createTagForWorkspace**](TagsApi.md#createTagForWorkspace) | **POST** /workspaces/{workspace_gid}/tags | Create a tag in a workspace
[**deleteTag**](TagsApi.md#deleteTag) | **DELETE** /tags/{tag_gid} | Delete a tag
[**getTag**](TagsApi.md#getTag) | **GET** /tags/{tag_gid} | Get a tag
[**getTags**](TagsApi.md#getTags) | **GET** /tags | Get multiple tags
[**getTagsForTask**](TagsApi.md#getTagsForTask) | **GET** /tasks/{task_gid}/tags | Get a task&#x27;s tags
[**getTagsForWorkspace**](TagsApi.md#getTagsForWorkspace) | **GET** /workspaces/{workspace_gid}/tags | Get tags in a workspace
[**updateTag**](TagsApi.md#updateTag) | **PUT** /tags/{tag_gid} | Update a tag

<a name="createTag"></a>
# **createTag**
> InlineResponse2015 createTag(body, optPretty, optFields)

Create a tag

Creates a new tag in a workspace or organization.  Every tag is required to be created in a specific workspace or organization, and this cannot be changed once set. Note that you can use the workspace parameter regardless of whether or not it is an organization.  Returns the full record of the newly created tag.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TagsApi apiInstance = new TagsApi();
TagsBody body = new TagsBody(); // TagsBody | The tag to create.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2015 result = apiInstance.createTag(body, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#createTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TagsBody**](TagsBody.md)| The tag to create. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2015**](InlineResponse2015.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createTagForWorkspace"></a>
# **createTagForWorkspace**
> WorkspaceGidTagsBody createTagForWorkspace(body, workspaceGid, optPretty, optFields)

Create a tag in a workspace

Creates a new tag in a workspace or organization.  Every tag is required to be created in a specific workspace or organization, and this cannot be changed once set. Note that you can use the workspace parameter regardless of whether or not it is an organization.  Returns the full record of the newly created tag.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TagsApi apiInstance = new TagsApi();
WorkspaceGidTagsBody body = new WorkspaceGidTagsBody(); // WorkspaceGidTagsBody | The tag to create.
String workspaceGid = "workspaceGid_example"; // String | Globally unique identifier for the workspace or organization.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    WorkspaceGidTagsBody result = apiInstance.createTagForWorkspace(body, workspaceGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#createTagForWorkspace");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**WorkspaceGidTagsBody**](WorkspaceGidTagsBody.md)| The tag to create. |
 **workspaceGid** | **String**| Globally unique identifier for the workspace or organization. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**WorkspaceGidTagsBody**](WorkspaceGidTagsBody.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteTag"></a>
# **deleteTag**
> InlineResponse2001 deleteTag(tagGid, optPretty, optFields, limit, offset)

Delete a tag

A specific, existing tag can be deleted by making a DELETE request on the URL for that tag.  Returns an empty data record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TagsApi apiInstance = new TagsApi();
String tagGid = "tagGid_example"; // String | Globally unique identifier for the tag.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse2001 result = apiInstance.deleteTag(tagGid, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#deleteTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tagGid** | **String**| Globally unique identifier for the tag. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTag"></a>
# **getTag**
> InlineResponse2015 getTag(tagGid, optPretty, optFields, limit, offset)

Get a tag

Returns the complete tag record for a single tag.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TagsApi apiInstance = new TagsApi();
String tagGid = "tagGid_example"; // String | Globally unique identifier for the tag.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse2015 result = apiInstance.getTag(tagGid, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#getTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tagGid** | **String**| Globally unique identifier for the tag. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse2015**](InlineResponse2015.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTags"></a>
# **getTags**
> InlineResponse20032 getTags(optPretty, optFields, limit, offset, workspace)

Get multiple tags

Returns the compact tag records for some filtered set of tags. Use one or more of the parameters provided to filter the tags returned.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TagsApi apiInstance = new TagsApi();
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
String workspace = "workspace_example"; // String | The workspace to filter tags on.
try {
    InlineResponse20032 result = apiInstance.getTags(optPretty, optFields, limit, offset, workspace);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#getTags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]
 **workspace** | **String**| The workspace to filter tags on. | [optional]

### Return type

[**InlineResponse20032**](InlineResponse20032.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTagsForTask"></a>
# **getTagsForTask**
> InlineResponse20032 getTagsForTask(taskGid, optPretty, optFields, limit, offset)

Get a task&#x27;s tags

Get a compact representation of all of the tags the task has.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TagsApi apiInstance = new TagsApi();
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20032 result = apiInstance.getTagsForTask(taskGid, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#getTagsForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20032**](InlineResponse20032.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTagsForWorkspace"></a>
# **getTagsForWorkspace**
> InlineResponse20032 getTagsForWorkspace(workspaceGid, optPretty, optFields, limit, offset)

Get tags in a workspace

Returns the compact tag records for some filtered set of tags. Use one or more of the parameters provided to filter the tags returned.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TagsApi apiInstance = new TagsApi();
String workspaceGid = "workspaceGid_example"; // String | Globally unique identifier for the workspace or organization.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20032 result = apiInstance.getTagsForWorkspace(workspaceGid, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#getTagsForWorkspace");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workspaceGid** | **String**| Globally unique identifier for the workspace or organization. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20032**](InlineResponse20032.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateTag"></a>
# **updateTag**
> InlineResponse2015 updateTag(tagGid, optPretty, optFields, limit, offset)

Update a tag

Updates the properties of a tag. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged.  When using this method, it is best to specify only those fields you wish to change, or else you may overwrite changes made by another user since you last retrieved the tag.  Returns the complete updated tag record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TagsApi apiInstance = new TagsApi();
String tagGid = "tagGid_example"; // String | Globally unique identifier for the tag.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse2015 result = apiInstance.updateTag(tagGid, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#updateTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tagGid** | **String**| Globally unique identifier for the tag. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse2015**](InlineResponse2015.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


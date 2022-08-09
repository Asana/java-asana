# WebhooksApi

All URIs are relative to *https://app.asana.com/api/1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createWebhook**](WebhooksApi.md#createWebhook) | **POST** /webhooks | Establish a webhook
[**deleteWebhook**](WebhooksApi.md#deleteWebhook) | **DELETE** /webhooks/{webhook_gid} | Delete a webhook
[**getWebhook**](WebhooksApi.md#getWebhook) | **GET** /webhooks/{webhook_gid} | Get a webhook
[**getWebhooks**](WebhooksApi.md#getWebhooks) | **GET** /webhooks | Get multiple webhooks
[**updateWebhook**](WebhooksApi.md#updateWebhook) | **PUT** /webhooks/{webhook_gid} | Update a webhook

<a name="createWebhook"></a>
# **createWebhook**
> InlineResponse2017 createWebhook(body, optPretty, optFields)

Establish a webhook

Establishing a webhook is a two-part process. First, a simple HTTP POST request initiates the creation similar to creating any other resource.  Next, in the middle of this request comes the confirmation handshake. When a webhook is created, we will send a test POST to the target with an &#x60;X-Hook-Secret&#x60; header. The target must respond with a &#x60;200 OK&#x60; or &#x60;204 No Content&#x60; and a matching &#x60;X-Hook-Secret&#x60; header to confirm that this webhook subscription is indeed expected. We strongly recommend storing this secret to be used to verify future webhook event signatures.  The POST request to create the webhook will then return with the status of the request. If you do not acknowledge the webhook’s confirmation handshake it will fail to setup, and you will receive an error in response to your attempt to create it. This means you need to be able to receive and complete the webhook *while* the POST request is in-flight (in other words, have a server that can handle requests asynchronously).  Invalid hostnames like localhost will recieve a 403 Forbidden status code.  &#x60;&#x60;&#x60; # Request curl -H \&quot;Authorization: Bearer &lt;personal_access_token&gt;\&quot; \\ -X POST https://app.asana.com/api/1.0/webhooks \\ -d \&quot;resource&#x3D;8675309\&quot; \\ -d \&quot;target&#x3D;https://example.com/receive-webhook/7654\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; # Handshake sent to https://example.com/ POST /receive-webhook/7654 X-Hook-Secret: b537207f20cbfa02357cf448134da559e8bd39d61597dcd5631b8012eae53e81 &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; # Handshake response sent by example.com HTTP/1.1 200 X-Hook-Secret: b537207f20cbfa02357cf448134da559e8bd39d61597dcd5631b8012eae53e81 &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; # Response HTTP/1.1 201 {   \&quot;data\&quot;: {     \&quot;gid\&quot;: \&quot;43214\&quot;,     \&quot;resource\&quot;: {       \&quot;gid\&quot;: \&quot;8675309\&quot;,       \&quot;name\&quot;: \&quot;Bugs\&quot;     },     \&quot;target\&quot;: \&quot;https://example.com/receive-webhook/7654\&quot;,     \&quot;active\&quot;: false,     \&quot;last_success_at\&quot;: null,     \&quot;last_failure_at\&quot;: null,     \&quot;last_failure_content\&quot;: null   } } &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.WebhooksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


WebhooksApi apiInstance = new WebhooksApi();
WebhooksBody body = new WebhooksBody(); // WebhooksBody | The webhook workspace and target.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2017 result = apiInstance.createWebhook(body, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhooksApi#createWebhook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**WebhooksBody**](WebhooksBody.md)| The webhook workspace and target. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2017**](InlineResponse2017.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteWebhook"></a>
# **deleteWebhook**
> InlineResponse2001 deleteWebhook(webhookGid, optPretty, optFields)

Delete a webhook

This method *permanently* removes a webhook. Note that it may be possible to receive a request that was already in flight after deleting the webhook, but no further requests will be issued.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.WebhooksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


WebhooksApi apiInstance = new WebhooksApi();
String webhookGid = "webhookGid_example"; // String | Globally unique identifier for the webhook.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.deleteWebhook(webhookGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhooksApi#deleteWebhook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhookGid** | **String**| Globally unique identifier for the webhook. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getWebhook"></a>
# **getWebhook**
> InlineResponse2017 getWebhook(webhookGid, optPretty, optFields)

Get a webhook

Returns the full record for the given webhook.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.WebhooksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


WebhooksApi apiInstance = new WebhooksApi();
String webhookGid = "webhookGid_example"; // String | Globally unique identifier for the webhook.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2017 result = apiInstance.getWebhook(webhookGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhooksApi#getWebhook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhookGid** | **String**| Globally unique identifier for the webhook. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2017**](InlineResponse2017.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getWebhooks"></a>
# **getWebhooks**
> InlineResponse20045 getWebhooks(workspace, optPretty, optFields, limit, offset, resource)

Get multiple webhooks

Get the compact representation of all webhooks your app has registered for the authenticated user in the given workspace.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.WebhooksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


WebhooksApi apiInstance = new WebhooksApi();
String workspace = "workspace_example"; // String | The workspace to query for webhooks in.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
String resource = "resource_example"; // String | Only return webhooks for the given resource.
try {
    InlineResponse20045 result = apiInstance.getWebhooks(workspace, optPretty, optFields, limit, offset, resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhooksApi#getWebhooks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workspace** | **String**| The workspace to query for webhooks in. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]
 **resource** | **String**| Only return webhooks for the given resource. | [optional]

### Return type

[**InlineResponse20045**](InlineResponse20045.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateWebhook"></a>
# **updateWebhook**
> InlineResponse2017 updateWebhook(body, webhookGid, optPretty, optFields)

Update a webhook

An existing webhook&#x27;s filters can be updated by making a PUT request on the URL for that webhook. Note that the webhook&#x27;s previous &#x60;filters&#x60; array will be completely overwritten by the &#x60;filters&#x60; sent in the PUT request. 

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.WebhooksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


WebhooksApi apiInstance = new WebhooksApi();
WebhooksWebhookGidBody body = new WebhooksWebhookGidBody(); // WebhooksWebhookGidBody | The updated filters for the webhook.
String webhookGid = "webhookGid_example"; // String | Globally unique identifier for the webhook.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2017 result = apiInstance.updateWebhook(body, webhookGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhooksApi#updateWebhook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**WebhooksWebhookGidBody**](WebhooksWebhookGidBody.md)| The updated filters for the webhook. |
 **webhookGid** | **String**| Globally unique identifier for the webhook. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2017**](InlineResponse2017.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


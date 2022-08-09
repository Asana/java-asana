# JobsApi

All URIs are relative to *https://app.asana.com/api/1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getJob**](JobsApi.md#getJob) | **GET** /jobs/{job_gid} | Get a job by id

<a name="getJob"></a>
# **getJob**
> InlineResponse20012 getJob(jobGid, optPretty, optFields)

Get a job by id

Returns the full record for a job.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.JobsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


JobsApi apiInstance = new JobsApi();
String jobGid = "jobGid_example"; // String | Globally unique identifier for the job.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse20012 result = apiInstance.getJob(jobGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobsApi#getJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobGid** | **String**| Globally unique identifier for the job. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse20012**](InlineResponse20012.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


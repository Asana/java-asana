# GoalRelationshipsApi

All URIs are relative to *https://app.asana.com/api/1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addSupportingRelationship**](GoalRelationshipsApi.md#addSupportingRelationship) | **POST** /goals/{goal_gid}/addSupportingRelationship | Add a supporting goal relationship
[**getGoalRelationship**](GoalRelationshipsApi.md#getGoalRelationship) | **GET** /goal_relationships/{goal_relationship_gid} | Get a goal relationship
[**getGoalRelationships**](GoalRelationshipsApi.md#getGoalRelationships) | **GET** /goal_relationships | Get goal relationships
[**removeSupportingRelationship**](GoalRelationshipsApi.md#removeSupportingRelationship) | **POST** /goals/{goal_gid}/removeSupportingRelationship | Removes a supporting goal relationship
[**updateGoalRelationship**](GoalRelationshipsApi.md#updateGoalRelationship) | **PUT** /goal_relationships/{goal_relationship_gid} | Update a goal relationship

<a name="addSupportingRelationship"></a>
# **addSupportingRelationship**
> InlineResponse2008 addSupportingRelationship(body, goalGid, optPretty, optFields)

Add a supporting goal relationship

Creates a goal relationship by adding a supporting resource to a given goal.  Returns the newly created goal relationship record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalRelationshipsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalRelationshipsApi apiInstance = new GoalRelationshipsApi();
GoalGidAddSupportingRelationshipBody body = new GoalGidAddSupportingRelationshipBody(); // GoalGidAddSupportingRelationshipBody | The supporting resource to be added to the goal
String goalGid = "goalGid_example"; // String | Globally unique identifier for the goal.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2008 result = apiInstance.addSupportingRelationship(body, goalGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalRelationshipsApi#addSupportingRelationship");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**GoalGidAddSupportingRelationshipBody**](GoalGidAddSupportingRelationshipBody.md)| The supporting resource to be added to the goal |
 **goalGid** | **String**| Globally unique identifier for the goal. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2008**](InlineResponse2008.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getGoalRelationship"></a>
# **getGoalRelationship**
> InlineResponse2008 getGoalRelationship(goalRelationshipGid, optPretty, optFields)

Get a goal relationship

Returns the complete updated goal relationship record for a single goal relationship.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalRelationshipsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalRelationshipsApi apiInstance = new GoalRelationshipsApi();
String goalRelationshipGid = "goalRelationshipGid_example"; // String | Globally unique identifier for the goal relationship.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2008 result = apiInstance.getGoalRelationship(goalRelationshipGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalRelationshipsApi#getGoalRelationship");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **goalRelationshipGid** | **String**| Globally unique identifier for the goal relationship. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2008**](InlineResponse2008.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGoalRelationships"></a>
# **getGoalRelationships**
> InlineResponse2009 getGoalRelationships(supportedGoal, optPretty, optFields, resourceSubtype)

Get goal relationships

Returns compact goal relationship records.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalRelationshipsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalRelationshipsApi apiInstance = new GoalRelationshipsApi();
String supportedGoal = "supportedGoal_example"; // String | Globally unique identifier for the supported goal in the goal relationship.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
String resourceSubtype = "resourceSubtype_example"; // String | If provided, filter to goal relationships with a given resource_subtype.
try {
    InlineResponse2009 result = apiInstance.getGoalRelationships(supportedGoal, optPretty, optFields, resourceSubtype);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalRelationshipsApi#getGoalRelationships");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **supportedGoal** | **String**| Globally unique identifier for the supported goal in the goal relationship. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **resourceSubtype** | **String**| If provided, filter to goal relationships with a given resource_subtype. | [optional]

### Return type

[**InlineResponse2009**](InlineResponse2009.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeSupportingRelationship"></a>
# **removeSupportingRelationship**
> InlineResponse2001 removeSupportingRelationship(body, goalGid, optPretty, optFields)

Removes a supporting goal relationship

Removes a goal relationship for a given parent goal.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalRelationshipsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalRelationshipsApi apiInstance = new GoalRelationshipsApi();
GoalGidRemoveSupportingRelationshipBody body = new GoalGidRemoveSupportingRelationshipBody(); // GoalGidRemoveSupportingRelationshipBody | The supporting resource to be removed from the goal
String goalGid = "goalGid_example"; // String | Globally unique identifier for the goal.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.removeSupportingRelationship(body, goalGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalRelationshipsApi#removeSupportingRelationship");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**GoalGidRemoveSupportingRelationshipBody**](GoalGidRemoveSupportingRelationshipBody.md)| The supporting resource to be removed from the goal |
 **goalGid** | **String**| Globally unique identifier for the goal. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateGoalRelationship"></a>
# **updateGoalRelationship**
> InlineResponse2008 updateGoalRelationship(body, goalRelationshipGid, optPretty, optFields)

Update a goal relationship

An existing goal relationship can be updated by making a PUT request on the URL for that goal relationship. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged.  Returns the complete updated goal relationship record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalRelationshipsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalRelationshipsApi apiInstance = new GoalRelationshipsApi();
GoalRelationshipsGoalRelationshipGidBody body = new GoalRelationshipsGoalRelationshipGidBody(); // GoalRelationshipsGoalRelationshipGidBody | The updated fields for the goal relationship.
String goalRelationshipGid = "goalRelationshipGid_example"; // String | Globally unique identifier for the goal relationship.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2008 result = apiInstance.updateGoalRelationship(body, goalRelationshipGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalRelationshipsApi#updateGoalRelationship");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**GoalRelationshipsGoalRelationshipGidBody**](GoalRelationshipsGoalRelationshipGidBody.md)| The updated fields for the goal relationship. |
 **goalRelationshipGid** | **String**| Globally unique identifier for the goal relationship. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2008**](InlineResponse2008.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


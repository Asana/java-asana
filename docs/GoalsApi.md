# GoalsApi

All URIs are relative to *https://app.asana.com/api/1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addFollowers**](GoalsApi.md#addFollowers) | **POST** /goals/{goal_gid}/addFollowers | Add a collaborator to a goal
[**createGoal**](GoalsApi.md#createGoal) | **POST** /goals | Create a goal
[**createGoalMetric**](GoalsApi.md#createGoalMetric) | **POST** /goals/{goal_gid}/setMetric | Create a goal metric
[**deleteGoal**](GoalsApi.md#deleteGoal) | **DELETE** /goals/{goal_gid} | Delete a goal
[**getGoal**](GoalsApi.md#getGoal) | **GET** /goals/{goal_gid} | Get a goal
[**getGoals**](GoalsApi.md#getGoals) | **GET** /goals | Get goals
[**getParentGoalsForGoal**](GoalsApi.md#getParentGoalsForGoal) | **GET** /goals/{goal_gid}/parentGoals | Get parent goals from a goal
[**removeFollowers**](GoalsApi.md#removeFollowers) | **POST** /goals/{goal_gid}/removeFollowers | Remove a collaborator from a goal
[**updateGoal**](GoalsApi.md#updateGoal) | **PUT** /goals/{goal_gid} | Update a goal
[**updateGoalMetric**](GoalsApi.md#updateGoalMetric) | **POST** /goals/{goal_gid}/setMetricCurrentValue | Update a goal metric

<a name="addFollowers"></a>
# **addFollowers**
> InlineResponse20010 addFollowers(body, goalGid, optPretty, optFields)

Add a collaborator to a goal

Adds followers to a goal. Returns the goal the followers were added to. Each goal can be associated with zero or more followers in the system. Requests to add/remove followers, if successful, will return the complete updated goal record, described above.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalsApi apiInstance = new GoalsApi();
GoalGidAddFollowersBody body = new GoalGidAddFollowersBody(); // GoalGidAddFollowersBody | The followers to be added as collaborators
String goalGid = "goalGid_example"; // String | Globally unique identifier for the goal.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse20010 result = apiInstance.addFollowers(body, goalGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalsApi#addFollowers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**GoalGidAddFollowersBody**](GoalGidAddFollowersBody.md)| The followers to be added as collaborators |
 **goalGid** | **String**| Globally unique identifier for the goal. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse20010**](InlineResponse20010.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGoal"></a>
# **createGoal**
> InlineResponse20010 createGoal(body, optPretty, optFields, limit, offset)

Create a goal

Creates a new goal in a workspace or team.  Returns the full record of the newly created goal.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalsApi apiInstance = new GoalsApi();
GoalsBody body = new GoalsBody(); // GoalsBody | The goal to create.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20010 result = apiInstance.createGoal(body, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalsApi#createGoal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**GoalsBody**](GoalsBody.md)| The goal to create. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20010**](InlineResponse20010.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGoalMetric"></a>
# **createGoalMetric**
> InlineResponse20010 createGoalMetric(body, goalGid, optPretty, optFields)

Create a goal metric

Creates and adds a goal metric to a specified goal. Note that this replaces an existing goal metric if one already exists.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalsApi apiInstance = new GoalsApi();
GoalGidSetMetricBody body = new GoalGidSetMetricBody(); // GoalGidSetMetricBody | The goal metric to create.
String goalGid = "goalGid_example"; // String | Globally unique identifier for the goal.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse20010 result = apiInstance.createGoalMetric(body, goalGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalsApi#createGoalMetric");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**GoalGidSetMetricBody**](GoalGidSetMetricBody.md)| The goal metric to create. |
 **goalGid** | **String**| Globally unique identifier for the goal. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse20010**](InlineResponse20010.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteGoal"></a>
# **deleteGoal**
> InlineResponse2001 deleteGoal(goalGid, optPretty, optFields)

Delete a goal

A specific, existing goal can be deleted by making a DELETE request on the URL for that goal.  Returns an empty data record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalsApi apiInstance = new GoalsApi();
String goalGid = "goalGid_example"; // String | Globally unique identifier for the goal.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.deleteGoal(goalGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalsApi#deleteGoal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **goalGid** | **String**| Globally unique identifier for the goal. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGoal"></a>
# **getGoal**
> InlineResponse20010 getGoal(goalGid, optPretty, optFields)

Get a goal

Returns the complete goal record for a single goal.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalsApi apiInstance = new GoalsApi();
String goalGid = "goalGid_example"; // String | Globally unique identifier for the goal.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse20010 result = apiInstance.getGoal(goalGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalsApi#getGoal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **goalGid** | **String**| Globally unique identifier for the goal. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse20010**](InlineResponse20010.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGoals"></a>
# **getGoals**
> InlineResponse20011 getGoals(optPretty, optFields, limit, offset, portfolio, project, isWorkspaceLevel, team, workspace, timePeriods)

Get goals

Returns compact goal records.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalsApi apiInstance = new GoalsApi();
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
String portfolio = "portfolio_example"; // String | Globally unique identifier for supporting portfolio.
String project = "project_example"; // String | Globally unique identifier for supporting project.
Boolean isWorkspaceLevel = true; // Boolean | Filter to goals with is_workspace_level set to query value. Must be used with the workspace parameter.
String team = "team_example"; // String | Globally unique identifier for the team.
String workspace = "workspace_example"; // String | Globally unique identifier for the workspace.
List<String> timePeriods = Arrays.asList("timePeriods_example"); // List<String> | Globally unique identifiers for the time periods.
try {
    InlineResponse20011 result = apiInstance.getGoals(optPretty, optFields, limit, offset, portfolio, project, isWorkspaceLevel, team, workspace, timePeriods);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalsApi#getGoals");
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
 **portfolio** | **String**| Globally unique identifier for supporting portfolio. | [optional]
 **project** | **String**| Globally unique identifier for supporting project. | [optional]
 **isWorkspaceLevel** | **Boolean**| Filter to goals with is_workspace_level set to query value. Must be used with the workspace parameter. | [optional]
 **team** | **String**| Globally unique identifier for the team. | [optional]
 **workspace** | **String**| Globally unique identifier for the workspace. | [optional]
 **timePeriods** | [**List&lt;String&gt;**](String.md)| Globally unique identifiers for the time periods. | [optional]

### Return type

[**InlineResponse20011**](InlineResponse20011.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getParentGoalsForGoal"></a>
# **getParentGoalsForGoal**
> InlineResponse20011 getParentGoalsForGoal(goalGid, optPretty, optFields)

Get parent goals from a goal

Returns a compact representation of all of the parent goals of a goal.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalsApi apiInstance = new GoalsApi();
String goalGid = "goalGid_example"; // String | Globally unique identifier for the goal.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse20011 result = apiInstance.getParentGoalsForGoal(goalGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalsApi#getParentGoalsForGoal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **goalGid** | **String**| Globally unique identifier for the goal. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse20011**](InlineResponse20011.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeFollowers"></a>
# **removeFollowers**
> InlineResponse20010 removeFollowers(body, goalGid, optPretty, optFields)

Remove a collaborator from a goal

Removes followers from a goal. Returns the goal the followers were removed from. Each goal can be associated with zero or more followers in the system. Requests to add/remove followers, if successful, will return the complete updated goal record, described above.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalsApi apiInstance = new GoalsApi();
GoalGidRemoveFollowersBody body = new GoalGidRemoveFollowersBody(); // GoalGidRemoveFollowersBody | The followers to be removed as collaborators
String goalGid = "goalGid_example"; // String | Globally unique identifier for the goal.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse20010 result = apiInstance.removeFollowers(body, goalGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalsApi#removeFollowers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**GoalGidRemoveFollowersBody**](GoalGidRemoveFollowersBody.md)| The followers to be removed as collaborators |
 **goalGid** | **String**| Globally unique identifier for the goal. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse20010**](InlineResponse20010.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateGoal"></a>
# **updateGoal**
> InlineResponse20010 updateGoal(body, goalGid, optPretty, optFields)

Update a goal

An existing goal can be updated by making a PUT request on the URL for that goal. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged.  Returns the complete updated goal record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalsApi apiInstance = new GoalsApi();
GoalsGoalGidBody body = new GoalsGoalGidBody(); // GoalsGoalGidBody | The updated fields for the goal.
String goalGid = "goalGid_example"; // String | Globally unique identifier for the goal.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse20010 result = apiInstance.updateGoal(body, goalGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalsApi#updateGoal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**GoalsGoalGidBody**](GoalsGoalGidBody.md)| The updated fields for the goal. |
 **goalGid** | **String**| Globally unique identifier for the goal. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse20010**](InlineResponse20010.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateGoalMetric"></a>
# **updateGoalMetric**
> InlineResponse20010 updateGoalMetric(body, goalGid, optPretty, optFields)

Update a goal metric

Updates a goal&#x27;s existing metric&#x27;s &#x60;current_number_value&#x60; if one exists, otherwise responds with a 400 status code.  Returns the complete updated goal metric record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.GoalsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


GoalsApi apiInstance = new GoalsApi();
GoalGidSetMetricCurrentValueBody body = new GoalGidSetMetricCurrentValueBody(); // GoalGidSetMetricCurrentValueBody | The updated fields for the goal metric.
String goalGid = "goalGid_example"; // String | Globally unique identifier for the goal.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse20010 result = apiInstance.updateGoalMetric(body, goalGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GoalsApi#updateGoalMetric");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**GoalGidSetMetricCurrentValueBody**](GoalGidSetMetricCurrentValueBody.md)| The updated fields for the goal metric. |
 **goalGid** | **String**| Globally unique identifier for the goal. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse20010**](InlineResponse20010.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


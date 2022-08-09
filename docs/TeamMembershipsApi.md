# TeamMembershipsApi

All URIs are relative to *https://app.asana.com/api/1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTeamMembership**](TeamMembershipsApi.md#getTeamMembership) | **GET** /team_memberships/{team_membership_gid} | Get a team membership
[**getTeamMemberships**](TeamMembershipsApi.md#getTeamMemberships) | **GET** /team_memberships | Get team memberships
[**getTeamMembershipsForTeam**](TeamMembershipsApi.md#getTeamMembershipsForTeam) | **GET** /teams/{team_gid}/team_memberships | Get memberships from a team
[**getTeamMembershipsForUser**](TeamMembershipsApi.md#getTeamMembershipsForUser) | **GET** /users/{user_gid}/team_memberships | Get memberships from a user

<a name="getTeamMembership"></a>
# **getTeamMembership**
> InlineResponse20034 getTeamMembership(teamMembershipGid, optPretty, optFields)

Get a team membership

Returns the complete team membership record for a single team membership.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TeamMembershipsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TeamMembershipsApi apiInstance = new TeamMembershipsApi();
String teamMembershipGid = "teamMembershipGid_example"; // String | 
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse20034 result = apiInstance.getTeamMembership(teamMembershipGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamMembershipsApi#getTeamMembership");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamMembershipGid** | **String**|  |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse20034**](InlineResponse20034.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTeamMemberships"></a>
# **getTeamMemberships**
> InlineResponse20035 getTeamMemberships(optPretty, optFields, limit, offset, team, user, workspace)

Get team memberships

Returns compact team membership records.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TeamMembershipsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TeamMembershipsApi apiInstance = new TeamMembershipsApi();
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
String team = "team_example"; // String | Globally unique identifier for the team.
String user = "user_example"; // String | A string identifying a user. This can either be the string \"me\", an email, or the gid of a user. This parameter must be used with the workspace parameter.
String workspace = "workspace_example"; // String | Globally unique identifier for the workspace. This parameter must be used with the user parameter.
try {
    InlineResponse20035 result = apiInstance.getTeamMemberships(optPretty, optFields, limit, offset, team, user, workspace);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamMembershipsApi#getTeamMemberships");
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
 **team** | **String**| Globally unique identifier for the team. | [optional]
 **user** | **String**| A string identifying a user. This can either be the string \&quot;me\&quot;, an email, or the gid of a user. This parameter must be used with the workspace parameter. | [optional]
 **workspace** | **String**| Globally unique identifier for the workspace. This parameter must be used with the user parameter. | [optional]

### Return type

[**InlineResponse20035**](InlineResponse20035.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTeamMembershipsForTeam"></a>
# **getTeamMembershipsForTeam**
> InlineResponse20035 getTeamMembershipsForTeam(teamGid, optPretty, optFields, limit, offset)

Get memberships from a team

Returns the compact team memberships for the team.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TeamMembershipsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TeamMembershipsApi apiInstance = new TeamMembershipsApi();
String teamGid = "teamGid_example"; // String | Globally unique identifier for the team.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20035 result = apiInstance.getTeamMembershipsForTeam(teamGid, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamMembershipsApi#getTeamMembershipsForTeam");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamGid** | **String**| Globally unique identifier for the team. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20035**](InlineResponse20035.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTeamMembershipsForUser"></a>
# **getTeamMembershipsForUser**
> InlineResponse20035 getTeamMembershipsForUser(userGid, workspace, optPretty, optFields, limit, offset)

Get memberships from a user

Returns the compact team membership records for the user.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TeamMembershipsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TeamMembershipsApi apiInstance = new TeamMembershipsApi();
String userGid = "userGid_example"; // String | A string identifying a user. This can either be the string \"me\", an email, or the gid of a user.
String workspace = "workspace_example"; // String | Globally unique identifier for the workspace.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20035 result = apiInstance.getTeamMembershipsForUser(userGid, workspace, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamMembershipsApi#getTeamMembershipsForUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userGid** | **String**| A string identifying a user. This can either be the string \&quot;me\&quot;, an email, or the gid of a user. |
 **workspace** | **String**| Globally unique identifier for the workspace. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20035**](InlineResponse20035.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


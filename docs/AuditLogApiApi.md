# AuditLogApiApi

All URIs are relative to *https://app.asana.com/api/1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAuditLogEvents**](AuditLogApiApi.md#getAuditLogEvents) | **GET** /workspaces/{workspace_gid}/audit_log_events | Get audit log events

<a name="getAuditLogEvents"></a>
# **getAuditLogEvents**
> InlineResponse2003 getAuditLogEvents(workspaceGid, startAt, endAt, eventType, actorType, actorGid, resourceGid, limit, offset)

Get audit log events

Retrieve the audit log events that have been captured in your domain.  This endpoint will return a list of [AuditLogEvent](/docs/audit-log-event) objects, sorted by creation time in ascending order. Note that the Audit Log API captures events from October 8th, 2021 and later. Queries for events before this date will not return results.  There are a number of query parameters (below) that can be used to filter the set of [AuditLogEvent](/docs/audit-log-event) objects that are returned in the response. Any combination of query parameters is valid. When no filters are provided, all of the events that have been captured in your domain will match.  The list of events will always be [paginated](/docs/pagination). The default limit is 1000 events. The next set of events can be retrieved using the &#x60;offset&#x60; from the previous response. If there are no events that match the provided filters in your domain, the endpoint will return &#x60;null&#x60; for the &#x60;next_page&#x60; field. Querying again with the same filters may return new events if they were captured after the last request. Once a response includes a &#x60;next_page&#x60; with an &#x60;offset&#x60;, subsequent requests can be made with the latest &#x60;offset&#x60; to poll for new events that match the provided filters.  When no &#x60;offset&#x60; is provided, the response will begin with the oldest events that match the provided filters. It is important to note that [AuditLogEvent](/docs/audit-log-event) objects will be permanently deleted from our systems after 90 days. If you wish to keep a permanent record of these events, we recommend using a SIEM tool to ingest and store these logs.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.AuditLogApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


AuditLogApiApi apiInstance = new AuditLogApiApi();
String workspaceGid = "workspaceGid_example"; // String | Globally unique identifier for the workspace or organization.
OffsetDateTime startAt = new OffsetDateTime(); // OffsetDateTime | Filter to events created after this time (inclusive).
OffsetDateTime endAt = new OffsetDateTime(); // OffsetDateTime | Filter to events created before this time (exclusive).
String eventType = "eventType_example"; // String | Filter to events of this type. Refer to the [Supported AuditLogEvents](/docs/supported-auditlogevents) for a full list of values.
String actorType = "actorType_example"; // String | Filter to events with an actor of this type. This only needs to be included if querying for actor types without an ID. If `actor_gid` is included, this should be excluded.
String actorGid = "actorGid_example"; // String | Filter to events triggered by the actor with this ID.
String resourceGid = "resourceGid_example"; // String | Filter to events with this resource ID.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse2003 result = apiInstance.getAuditLogEvents(workspaceGid, startAt, endAt, eventType, actorType, actorGid, resourceGid, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuditLogApiApi#getAuditLogEvents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workspaceGid** | **String**| Globally unique identifier for the workspace or organization. |
 **startAt** | **OffsetDateTime**| Filter to events created after this time (inclusive). | [optional]
 **endAt** | **OffsetDateTime**| Filter to events created before this time (exclusive). | [optional]
 **eventType** | **String**| Filter to events of this type. Refer to the [Supported AuditLogEvents](/docs/supported-auditlogevents) for a full list of values. | [optional]
 **actorType** | **String**| Filter to events with an actor of this type. This only needs to be included if querying for actor types without an ID. If &#x60;actor_gid&#x60; is included, this should be excluded. | [optional] [enum: user, asana, asana_support, anonymous, external_administrator]
 **actorGid** | **String**| Filter to events triggered by the actor with this ID. | [optional]
 **resourceGid** | **String**| Filter to events with this resource ID. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


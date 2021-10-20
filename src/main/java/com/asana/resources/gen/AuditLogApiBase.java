package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.*;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

    public class AuditLogApiBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public AuditLogApiBase(Client client) { super(client); }

        /**
        * Get audit log events
        * Retrieve the audit log events that have been captured in your domain.  This endpoint will return a list of [AuditLogEvent](/docs/audit-log-event) objects, sorted by creation time in ascending order. Note that the Audit Log API captures events from October 8th, 2021 and later. Queries for events before this date will not return results.  There are a number of query parameters (below) that can be used to filter the set of [AuditLogEvent](/docs/audit-log-event) objects that are returned in the response. Any combination of query parameters is valid. When no filters are provided, all of the events that have been captured in your domain will match.  The list of events will always be [paginated](/docs/pagination). The default limit is 1000 events. The next set of events can be retrieved using the &#x60;offset&#x60; from the previous response. If there are no events that match the provided filters in your domain, the endpoint will return &#x60;null&#x60; for the &#x60;next_page&#x60; field. Querying again with the same filters may return new events if they were captured after the last request. Once a response includes a &#x60;next_page&#x60; with an &#x60;offset&#x60;, subsequent requests can be made with the latest &#x60;offset&#x60; to poll for new events that match the provided filters.  When no &#x60;offset&#x60; is provided, the response will begin with the oldest events that match the provided filters. It is important to note that [AuditLogEvent](/docs/audit-log-event) objects will be permanently deleted from our systems after 90 days. If you wish to keep a permanent record of these events, we recommend using a SIEM tool to ingest and store these logs.
            * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
            * @param resourceGid Filter to events with this resource ID. (optional)
            * @param actorGid Filter to events triggered by the actor with this ID. (optional)
            * @param actorType Filter to events with an actor of this type. This only needs to be included if querying for actor types without an ID. If &#x60;actor_gid&#x60; is included, this should be excluded. (optional)
            * @param eventType Filter to events of this type. Refer to the [Supported AuditLogEvents](/docs/supported-auditlogevents) for a full list of values. (optional)
            * @param endAt Filter to events created before this time (exclusive). (optional)
            * @param startAt Filter to events created after this time (inclusive). (optional)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
        * @return CollectionRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<JsonElement> getAuditLogEvents(String workspaceGid, String resourceGid, String actorGid, String actorType, String eventType, OffsetDateTime endAt, OffsetDateTime startAt, String offset, Integer limit) throws IOException {
            String path = "/workspaces/{workspace_gid}/audit_log_events".replace("{workspace_gid}", workspaceGid);

            CollectionRequest<JsonElement> req = new CollectionRequest<JsonElement>(this, JsonElement.class, path, "GET")
                .query("start_at", startAt)
                .query("end_at", endAt)
                .query("event_type", eventType)
                .query("actor_type", actorType)
                .query("actor_gid", actorGid)
                .query("resource_gid", resourceGid)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        public CollectionRequest<JsonElement> getAuditLogEvents(String workspaceGid, String resourceGid, String actorGid, String actorType, String eventType, OffsetDateTime endAt, OffsetDateTime startAt) throws IOException {
            return getAuditLogEvents(workspaceGid, resourceGid, actorGid, actorType, eventType, endAt, startAt, null, (int)Client.DEFAULTS.get("page_size"));
        }
    }

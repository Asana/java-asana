# OrganizationExportResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which this resource was created. |  [optional]
**downloadUrl** | **String** | Download this URL to retreive the full export of the organization in JSON format. It will be compressed in a gzip (.gz) container.  *Note: May be null if the export is still in progress or failed.  If present, this URL may only be valid for 1 hour from the time of retrieval. You should avoid persisting this URL somewhere and rather refresh on demand to ensure you do not keep stale URLs.* |  [optional]
**state** | [**StateEnum**](#StateEnum) | The current state of the export. |  [optional]
**organization** | [**WorkspaceCompact**](WorkspaceCompact.md) |  |  [optional]

<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
PENDING | &quot;pending&quot;
STARTED | &quot;started&quot;
FINISHED | &quot;finished&quot;
ERROR | &quot;error&quot;

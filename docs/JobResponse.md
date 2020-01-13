# JobResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**resourceSubtype** | **String** | The subtype of this resource. Different subtypes retain many of the same fields and behavior, but may render differently in Asana or represent resources with different semantic meaning. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**newProject** | [**ProjectCompact**](ProjectCompact.md) |  |  [optional]
**newTask** | [**TaskCompact**](TaskCompact.md) |  |  [optional]

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
NOT_STARTED | &quot;not_started&quot;
IN_PROGRESS | &quot;in_progress&quot;
COMPLETED | &quot;completed&quot;
FAILED | &quot;failed&quot;

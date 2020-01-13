# StoryCompact

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which this resource was created. |  [optional]
**createdBy** | [**UserCompact**](UserCompact.md) |  |  [optional]
**resourceSubtype** | **String** | The subtype of this resource. Different subtypes retain many of the same fields and behavior, but may render differently in Asana or represent resources with different semantic meaning. |  [optional]
**text** | **String** | *Create-only*. Human-readable text for the story or comment. This will not include the name of the creator. *Note: This is not guaranteed to be stable for a given type of story. For example, text for a reassignment may not always say “assigned to …” as the text for a story can both be edited and change based on the language settings of the user making the request.* Use the &#x60;resource_subtype&#x60; property to discover the action that created the story. |  [optional]
**type** | **String** | *Deprecated: new integrations should prefer the &#x60;resource_subtype&#x60; field.*  |  [optional]

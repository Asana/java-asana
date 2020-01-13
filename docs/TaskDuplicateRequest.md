# TaskDuplicateRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | The name of the new task. |  [optional]
**include** | [**IncludeEnum**](#IncludeEnum) | The fields that will be duplicated to the new task. |  [optional]

<a name="IncludeEnum"></a>
## Enum: IncludeEnum
Name | Value
---- | -----
NOTES | &quot;notes&quot;
ASSIGNEE | &quot;assignee&quot;
SUBTASKS | &quot;subtasks&quot;
ATTACHMENTS | &quot;attachments&quot;
TAGS | &quot;tags&quot;
FOLLOWERS | &quot;followers&quot;
PROJECTS | &quot;projects&quot;
DATES | &quot;dates&quot;
DEPENDENCIES | &quot;dependencies&quot;
PARENT | &quot;parent&quot;

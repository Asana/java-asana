# TaskResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**assignee** | **Object** |  |  [optional]
**followers** | [**List&lt;UserCompact&gt;**](UserCompact.md) | Array of users following this task. |  [optional]
**parent** | **Object** |  |  [optional]
**projects** | [**List&lt;ProjectCompact&gt;**](ProjectCompact.md) | *Create-only.* Array of projects this task is associated with. At task creation time, this array can be used to add the task to many projects at once. After task creation, these associations can be modified using the addProject and removeProject endpoints. |  [optional]
**tags** | [**List&lt;TagCompact&gt;**](TagCompact.md) | Array of tags associated with this task. In order to change tags on an existing task use &#x60;addTag&#x60; and &#x60;removeTag&#x60;. |  [optional]
**workspace** | **Object** |  |  [optional]

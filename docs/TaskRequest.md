# TaskRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**assignee** | **String** | Gid of a user. |  [optional]
**followers** | **List&lt;String&gt;** | *Create-Only* Array of user gids. In order to change followers on an existing task use &#x60;addFollowers&#x60; and &#x60;removeFollowers&#x60;. |  [optional]
**parent** | **String** | Gid of a task. |  [optional]
**projects** | **List&lt;String&gt;** | *Create-Only* Array of project gids. In order to change projects on an existing task use &#x60;addProject&#x60; and &#x60;removeProject&#x60;. |  [optional]
**tags** | **List&lt;String&gt;** | *Create-Only* Array of tag gids. In order to change tags on an existing task use &#x60;addTag&#x60; and &#x60;removeTag&#x60;. |  [optional]
**workspace** | **String** | Gid of a workspace. |  [optional]

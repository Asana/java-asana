# CustomFieldBase

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | [Opt In](#input-output-options). The description of the custom field. |  [optional]
**enumOptions** | [**List&lt;EnumOptionCompact&gt;**](EnumOptionCompact.md) | *Conditional*. Only relevant for custom fields of type &#x60;enum&#x60;. This array specifies the possible values which an &#x60;enum&#x60; custom field can adopt. To modify the enum options, refer to [working with enum options](#create-an-enum-option). |  [optional]
**precision** | **Integer** | Only relevant for custom fields of type ‘Number’. This field dictates the number of places after the decimal to round to, i.e. 0 is integer values, 1 rounds to the nearest tenth, and so on. Must be between 0 and 6, inclusive. |  [optional]
**isGlobalToWorkspace** | **Boolean** | This flag describes whether this custom field is available to every container in the workspace. Before project-specific custom fields, this field was always true. |  [optional]
**hasNotificationsEnabled** | **Boolean** | This flag describes whether a follower of a task with this field should receive inbox notifications from changes to this field. |  [optional]

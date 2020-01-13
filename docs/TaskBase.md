# TaskBase

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**assigneeStatus** | [**AssigneeStatusEnum**](#AssigneeStatusEnum) | Scheduling status of this task for the user it is assigned to. This field can only be set if the assignee is non-null. Setting this field to \&quot;inbox\&quot; or \&quot;upcoming\&quot; inserts it at the top of the section, while the other options will insert at the bottom. |  [optional]
**completed** | **Boolean** | True if the task is currently marked complete, false if not. |  [optional]
**completedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which this task was completed, or null if the task is incomplete. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which this resource was created. |  [optional]
**customFields** | [**List&lt;CustomFieldResponse&gt;**](CustomFieldResponse.md) | Array of custom field values applied to the project. These represent the custom field values recorded on this project for a particular custom field. For example, these custom field values will contain an &#x60;enum_value&#x60; property for custom fields of type &#x60;enum&#x60;, a &#x60;text_value&#x60; property for custom fields of type &#x60;text&#x60;, and so on. Please note that the &#x60;gid&#x60; returned on each custom field value *is identical* to the &#x60;gid&#x60; of the custom field, which allows referencing the custom field metadata through the &#x60;/custom_fields/custom_field-gid&#x60; endpoint. |  [optional]
**dependencies** | [**List&lt;AsanaResource&gt;**](AsanaResource.md) | [Opt In](#input-output-options). Array of resources referencing tasks that this task depends on. The objects contain only the gid of the dependency. |  [optional]
**dependents** | [**List&lt;AsanaResource&gt;**](AsanaResource.md) | [Opt In](#input-output-options). Array of resources referencing tasks that depend on this task. The objects contain only the ID of the dependent. |  [optional]
**dueAt** | [**LocalDate**](LocalDate.md) | Date and time on which this task is due, or null if the task has no due time. This takes a UTC timestamp and should not be used together with &#x60;due_on&#x60;. |  [optional]
**dueOn** | [**LocalDate**](LocalDate.md) | Date on which this task is due, or null if the task has no due date.  This takes a date with &#x60;YYYY-MM-DD&#x60; format and should not be used together with due_at. |  [optional]
**external** | [**TaskBaseExternal**](TaskBaseExternal.md) |  |  [optional]
**htmlNotes** | **String** | [Opt In](#input-output-options). The notes of the text with formatting as HTML. *Note: This field is under active migration—please see our blog post for more information.* |  [optional]
**hearted** | **Boolean** | *Deprecated - please use liked instead* True if the task is hearted by the authorized user, false if not. |  [optional]
**hearts** | [**List&lt;UserCompact&gt;**](UserCompact.md) | *Deprecated - please use likes instead* Array of users who have hearted this task. |  [optional]
**isRenderedAsSeparator** | **Boolean** | [Opt In](#input-output-options). In some contexts tasks can be rendered as a visual separator; for instance, subtasks can appear similar to [sections](#asana-sections) without being true &#x60;section&#x60; objects. If a &#x60;task&#x60; object is rendered this way in any context it will have the property &#x60;is_rendered_as_separator&#x60; set to &#x60;true&#x60;.&lt;br /&gt;&lt;br /&gt;*Note: Until the default behavior for our API changes integrations must [opt in to the &#x60;new_sections&#x60; change] (https://forum.asana.com/t/sections-are-dead-long-live-sections/33951) to modify the &#x60;is_rendered_as_separator&#x60; property.* |  [optional]
**liked** | **Boolean** | True if the task is liked by the authorized user, false if not. |  [optional]
**likes** | [**List&lt;UserCompact&gt;**](UserCompact.md) | Array of users who have liked this task. |  [optional]
**memberships** | [**List&lt;TaskBaseMemberships&gt;**](TaskBaseMemberships.md) | *Create-only*. Array of projects this task is associated with and the section it is in. At task creation time, this array can be used to add the task to specific sections. After task creation, these associations can be modified using the &#x60;addProject&#x60; and &#x60;removeProject&#x60; endpoints. Note that over time, more types of memberships may be added to this property. |  [optional]
**modifiedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which this task was last modified.  *Note: This does not currently reflect any changes in associations such as projects or comments that may have been added or removed from the task.* |  [optional]
**name** | **String** | Name of the task. This is generally a short sentence fragment that fits on a line in the UI for maximum readability. However, it can be longer. |  [optional]
**notes** | **String** | More detailed, free-form textual information associated with the task. |  [optional]
**numHearts** | **Integer** | *Deprecated - please use likes instead* The number of users who have hearted this task. |  [optional]
**numLikes** | **Integer** | The number of users who have liked this task. |  [optional]
**numSubtasks** | **Integer** | [Opt In](#input-output-options). The number of subtasks on this task.  |  [optional]
**resourceSubtype** | [**ResourceSubtypeEnum**](#ResourceSubtypeEnum) | The subtype of this resource. Different subtypes retain many of the same fields and behavior, but may render differently in Asana or represent resources with different semantic meaning. The resource_subtype &#x60;milestone&#x60; represent a single moment in time. This means tasks with this subtype cannot have a start_date. *Note: The resource_subtype of &#x60;section&#x60; is under active migration—please see our [forum post](https://forum.asana.com/t/sections-are-dead-long-live-sections) for more information.* |  [optional]
**startOn** | [**LocalDate**](LocalDate.md) | The day on which work begins for the task , or null if the task has no start date. This takes a date with &#x60;YYYY-MM-DD&#x60; format. *Note: &#x60;due_on&#x60; or &#x60;due_at&#x60; must be present in the request when setting or unsetting the &#x60;start_on&#x60; parameter.* |  [optional]

<a name="AssigneeStatusEnum"></a>
## Enum: AssigneeStatusEnum
Name | Value
---- | -----
TODAY | &quot;today&quot;
UPCOMING | &quot;upcoming&quot;
LATER | &quot;later&quot;
NEW | &quot;new&quot;
INBOX | &quot;inbox&quot;

<a name="ResourceSubtypeEnum"></a>
## Enum: ResourceSubtypeEnum
Name | Value
---- | -----
DEFAULT_TASK | &quot;default_task&quot;
MILESTONE | &quot;milestone&quot;
SECTION | &quot;section&quot;

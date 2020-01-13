# ProjectBase

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**archived** | **Boolean** | True if the project is archived, false if not. Archived projects do not show in the UI by default and may be treated differently for queries. |  [optional]
**color** | [**ColorEnum**](#ColorEnum) | Color of the project. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which this resource was created. |  [optional]
**currentStatus** | [**ProjectStatusResponse**](ProjectStatusResponse.md) |  |  [optional]
**customFields** | [**List&lt;CustomFieldCompact&gt;**](CustomFieldCompact.md) | Array of Custom Fields. |  [optional]
**customFieldSettings** | [**List&lt;CustomFieldSettingCompact&gt;**](CustomFieldSettingCompact.md) | Array of Custom Field Settings (in compact form). |  [optional]
**defaultView** | [**DefaultViewEnum**](#DefaultViewEnum) | The default view (list, board, calendar, or timeline) of a project. |  [optional]
**dueDate** | [**OffsetDateTime**](OffsetDateTime.md) | *Deprecated: new integrations should prefer the due_on field.* |  [optional]
**dueOn** | [**OffsetDateTime**](OffsetDateTime.md) | The day on which this project is due. This takes a date with format YYYY-MM-DD. |  [optional]
**followers** | [**List&lt;UserCompact&gt;**](UserCompact.md) | Array of users following this project. Followers are a subset of members who receive all notifications for a project, the default notification setting when adding members to a project in-product. |  [optional]
**htmlNotes** | **String** | [Opt In](#input-output-options). The notes of the project with formatting as HTML. *Note: This field is under active migration—please see our [blog post] (https://developers.asana.com/docs/#rich-text) for more information.* |  [optional]
**isTemplate** | **Boolean** | [Opt In](#input-output-options). Determines if the project is a template. |  [optional]
**layout** | [**LayoutEnum**](#LayoutEnum) | The layout (board or list view) of a project |  [optional]
**members** | [**List&lt;UserCompact&gt;**](UserCompact.md) | Array of users who are members of this project. |  [optional]
**modifiedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which this project was last modified. *Note: This does not currently reflect any changes in associations such as tasks or comments that may have been added or removed from the project.* |  [optional]
**notes** | **String** | More detailed, free-form textual information associated with the project. |  [optional]
**owner** | **Object** | The current owner of the project, may be null. |  [optional]
**_public** | **Boolean** | True if the project is public to the organization. If false, do not share this project with other users in this organization without explicitly checking to see if they have access. |  [optional]
**sectionMigrationStatus** | [**SectionMigrationStatusEnum**](#SectionMigrationStatusEnum) | *Read-only* The section migration status of this project. |  [optional]
**startOn** | [**LocalDate**](LocalDate.md) | The day on which work for this project begins, or null if the project has no start date. This takes a date with &#x60;YYYY-MM-DD&#x60; format. *Note: &#x60;due_on&#x60; or &#x60;due_at&#x60; must be present in the request when setting or unsetting the &#x60;start_on&#x60; parameter.* |  [optional]
**team** | **Object** |  |  [optional]
**workspace** | **Object** |  |  [optional]

<a name="ColorEnum"></a>
## Enum: ColorEnum
Name | Value
---- | -----
DARK_PINK | &quot;dark-pink&quot;
DARK_GREEN | &quot;dark-green&quot;
DARK_BLUE | &quot;dark-blue&quot;
DARK_RED | &quot;dark-red&quot;
DARK_TEAL | &quot;dark-teal&quot;
DARK_BROWN | &quot;dark-brown&quot;
DARK_ORANGE | &quot;dark-orange&quot;
DARK_PURPLE | &quot;dark-purple&quot;
DARK_WARM_GRAY | &quot;dark-warm-gray&quot;
LIGHT_PINK | &quot;light-pink&quot;
LIGHT_GREEN | &quot;light-green&quot;
LIGHT_BLUE | &quot;light-blue&quot;
LIGHT_RED | &quot;light-red&quot;
LIGHT_TEAL | &quot;light-teal&quot;
LIGHT_BROWN | &quot;light-brown&quot;
LIGHT_ORANGE | &quot;light-orange&quot;
LIGHT_PURPLE | &quot;light-purple&quot;
LIGHT_WARM_GRAY | &quot;light-warm-gray&quot;

<a name="DefaultViewEnum"></a>
## Enum: DefaultViewEnum
Name | Value
---- | -----
LIST | &quot;list&quot;
BOARD | &quot;board&quot;
CALENDAR | &quot;calendar&quot;
TIMELINE | &quot;timeline&quot;

<a name="LayoutEnum"></a>
## Enum: LayoutEnum
Name | Value
---- | -----
LIST | &quot;list&quot;
BOARD | &quot;board&quot;

<a name="SectionMigrationStatusEnum"></a>
## Enum: SectionMigrationStatusEnum
Name | Value
---- | -----
NOT_MIGRATED | &quot;not_migrated&quot;
IN_PROGRESS | &quot;in_progress&quot;
COMPLETED | &quot;completed&quot;

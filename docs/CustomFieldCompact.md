# CustomFieldCompact

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | The name of the custom field. |  [optional]
**resourceSubtype** | [**ResourceSubtypeEnum**](#ResourceSubtypeEnum) | The type of the custom field. Must be one of the given values.  |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | *Deprecated: new integrations should prefer the resource_subtype field.* The type of the custom field. Must be one of the given values.  |  [optional]
**enumOptions** | [**List&lt;EnumOptionCompact&gt;**](EnumOptionCompact.md) | *Conditional*. Only relevant for custom fields of type &#x60;enum&#x60;. This array specifies the possible values which an &#x60;enum&#x60; custom field can adopt. To modify the enum options, refer to [working with enum options](#create-an-enum-option). |  [optional]
**enumValue** | **Object** |  |  [optional]
**enabled** | **Boolean** | *Conditional*. Determines if the custom field is enabled or not. |  [optional]
**textValue** | **String** | *Conditional*. This string is the value of a text custom field. |  [optional]

<a name="ResourceSubtypeEnum"></a>
## Enum: ResourceSubtypeEnum
Name | Value
---- | -----
TEXT | &quot;text&quot;
ENUM | &quot;enum&quot;
NUMBER | &quot;number&quot;

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
TEXT | &quot;text&quot;
ENUM | &quot;enum&quot;
NUMBER | &quot;number&quot;

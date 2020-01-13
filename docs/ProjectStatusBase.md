# ProjectStatusBase

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which this resource was created. |  [optional]
**createdBy** | [**UserCompact**](UserCompact.md) |  |  [optional]
**project** | **String** | Globally unique identifier for the project. | 
**text** | **String** | The text content of the status update. | 
**htmlText** | **String** | [Opt In](#input-output-options). The text content of the status update with formatting as HTML. |  [optional]
**color** | [**ColorEnum**](#ColorEnum) | The color associated with the status update. | 

<a name="ColorEnum"></a>
## Enum: ColorEnum
Name | Value
---- | -----
GREEN | &quot;green&quot;
YELLOW | &quot;yellow&quot;
RED | &quot;red&quot;

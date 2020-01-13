# WebhookResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which this resource was created. |  [optional]
**lastFailureAt** | [**OffsetDateTime**](OffsetDateTime.md) | The timestamp when the webhook last received an error when sending an event to the target. |  [optional]
**lastFailureContent** | **String** | The contents of the last error response sent to the webhook when attempting to deliver events to the target. |  [optional]
**lastSuccessAt** | [**OffsetDateTime**](OffsetDateTime.md) | The timestamp when the webhook last successfully sent an event to the target. |  [optional]

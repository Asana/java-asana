# AttachmentResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which this resource was created. |  [optional]
**downloadUrl** | **String** | The URL containing the content of the attachment. *Note:* May be null if the attachment is hosted by [Box](https://www.box.com/). If present, this URL may only be valid for 1 hour from the time of retrieval. You should avoid persisting this URL somewhere and just refresh it on demand to ensure you do not keep stale URLs. |  [optional]
**host** | **String** | The service hosting the attachment. Valid values are &#x60;asana&#x60;, &#x60;dropbox&#x60;, &#x60;gdrive&#x60; and &#x60;box&#x60;. |  [optional]
**parent** | **Object** |  |  [optional]
**viewUrl** | **String** | The URL where the attachment can be viewed, which may be friendlier to users in a browser than just directing them to a raw file. May be null if no view URL exists for the service. |  [optional]

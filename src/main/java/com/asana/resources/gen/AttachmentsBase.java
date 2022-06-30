package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.*;
import java.io.File;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

    public class AttachmentsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public AttachmentsBase(Client client) { super(client); }

        /**
        * Delete an attachment
        * Deletes a specific, existing attachment.  Returns an empty data record.
            * @param attachmentGid Globally unique identifier for the attachment. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> deleteAttachment(String attachmentGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/attachments/{attachment_gid}".replace("{attachment_gid}", attachmentGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "DELETE")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> deleteAttachment(String attachmentGid) throws IOException {
            return deleteAttachment(attachmentGid, null, false);
        }
        /**
        * Get an attachment
        * Get the full record for a single attachment.
            * @param attachmentGid Globally unique identifier for the attachment. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(Attachment)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Attachment> getAttachment(String attachmentGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/attachments/{attachment_gid}".replace("{attachment_gid}", attachmentGid);

            ItemRequest<Attachment> req = new ItemRequest<Attachment>(this, Attachment.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<Attachment> getAttachment(String attachmentGid) throws IOException {
            return getAttachment(attachmentGid, null, false);
        }
        /**
        * Get attachments from an object
        * Returns the compact records for all attachments on the object.
            * @param parent Globally unique identifier for object to fetch statuses from. Must be a GID for a task or project_brief. (required)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(Attachment)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<Attachment> getAttachmentsForObject(String parent, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/attachments";

            CollectionRequest<Attachment> req = new CollectionRequest<Attachment>(this, Attachment.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset)
                .query("parent", parent);

            return req;
        }

        public CollectionRequest<Attachment> getAttachmentsForObject(String parent) throws IOException {
            return getAttachmentsForObject(parent, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
    }

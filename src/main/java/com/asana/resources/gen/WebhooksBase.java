package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.*;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

    public class WebhooksBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public WebhooksBase(Client client) { super(client); }

        /**
        * Establish a webhook
        * Establishing a webhook is a two-part process. First, a simple HTTP POST similar to any other resource creation. Since you could have multiple webhooks we recommend specifying a unique local id for each target.  Next comes the confirmation handshake. When a webhook is created, we will send a test POST to the target with an &#x60;X-Hook-Secret&#x60; header as described in the [Resthooks Security documentation](http://resthooks.org/docs/security/). The target must respond with a &#x60;200 OK&#x60; and a matching &#x60;X-Hook-Secret&#x60; header to confirm that this webhook subscription is indeed expected.  If you do not acknowledge the webhook’s confirmation handshake it will fail to setup, and you will receive an error in response to your attempt to create it. This means you need to be able to receive and complete the webhook *while* the POST request is in-flight.  &#x60;&#x60;&#x60; # Request curl -H \&quot;Authorization: Bearer &lt;personal_access_token&gt;\&quot; \\ -X POST https://app.asana.com/api/1.0/webhooks \\ -d \&quot;resource&#x3D;8675309\&quot; \\ -d \&quot;target&#x3D;https://example.com/receive-webhook/7654\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; # Handshake sent to https://example.com/ POST /receive-webhook/7654 X-Hook-Secret: b537207f20cbfa02357cf448134da559e8bd39d61597dcd5631b8012eae53e81 &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; # Handshake response sent by example.com HTTP/1.1 200 X-Hook-Secret: b537207f20cbfa02357cf448134da559e8bd39d61597dcd5631b8012eae53e81 &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; # Response HTTP/1.1 201 {   \&quot;data\&quot;: {     \&quot;gid\&quot;: \&quot;43214\&quot;,     \&quot;resource\&quot;: {       \&quot;gid\&quot;: \&quot;8675309\&quot;,       \&quot;name\&quot;: \&quot;Bugs\&quot;     },     \&quot;target\&quot;: \&quot;https://example.com/receive-webhook/7654\&quot;,     \&quot;active\&quot;: false,     \&quot;last_success_at\&quot;: null,     \&quot;last_failure_at\&quot;: null,     \&quot;last_failure_content\&quot;: null   } } &#x60;&#x60;&#x60;
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest<Webhook>
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Webhook> createWebhook(List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/webhooks";

            ItemRequest<Webhook> req = new ItemRequest<Webhook>(this, Webhook.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<Webhook> createWebhook() throws IOException {
            return createWebhook(null, false);
        }
        /**
        * Delete a webhook
        * This method *permanently* removes a webhook. Note that it may be possible to receive a request that was already in flight after deleting the webhook, but no further requests will be issued.
            * @param webhookGid Globally unique identifier for the webhook. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest<JsonElement>
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> deleteWebhook(String webhookGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/webhooks/{webhook_gid}".replace("{webhook_gid}", webhookGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "DELETE")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> deleteWebhook(String webhookGid) throws IOException {
            return deleteWebhook(webhookGid, null, false);
        }
        /**
        * Get a webhook
        * Returns the full record for the given webhook.
            * @param webhookGid Globally unique identifier for the webhook. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest<Webhook>
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Webhook> getWebhook(String webhookGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/webhooks/{webhook_gid}".replace("{webhook_gid}", webhookGid);

            ItemRequest<Webhook> req = new ItemRequest<Webhook>(this, Webhook.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<Webhook> getWebhook(String webhookGid) throws IOException {
            return getWebhook(webhookGid, null, false);
        }
        /**
        * Get multiple webhooks
        * Get the compact representation of all webhooks your app has registered for the authenticated user in the given workspace.
            * @param resource Only return webhooks for the given resource. (optional)
            * @param workspace The workspace to query for webhooks in. (required)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest<Webhook>
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<Webhook> getWebhooks(String resource, String workspace, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/webhooks";

            CollectionRequest<Webhook> req = new CollectionRequest<Webhook>(this, Webhook.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset)
                .query("workspace", workspace)
                .query("resource", resource);

            return req;
        }

        public CollectionRequest<Webhook> getWebhooks(String resource, String workspace) throws IOException {
            return getWebhooks(resource, workspace, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
    }

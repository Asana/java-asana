package com.asana.resources;

import com.asana.Client;
import com.asana.models.Webhook;
import com.asana.requests.CollectionRequest;
import com.asana.requests.ItemRequest;
import com.asana.resources.gen.WebhooksBase;

public class Webhooks extends WebhooksBase {
    public Webhooks(Client client) {
        super(client);
    }

    /**
     * Establishing a webhook is a two-part process. First, a simple HTTP POST
     * similar to any other resource creation. Since you could have multiple
     * webhooks we recommend specifying a unique local id for each target.
     *
     * Next comes the confirmation handshake. When a webhook is created, we will
     * send a test POST to the `target` with an `X-Hook-Secret` header as
     * described in the
     * [Resthooks Security documentation](http://resthooks.org/docs/security/).
     * The target must respond with a `200 OK` and a matching `X-Hook-Secret`
     * header to confirm that this webhook subscription is indeed expected.
     *
     * If you do not acknowledge the webhook's confirmation handshake it will
     * fail to setup, and you will receive an error in response to your attempt
     * to create it. This means you need to be able to receive and complete the
     * webhook *while* the POST request is in-flight.
     *
     * @return Request object
     */
    public ItemRequest<Webhook> create() {

        return new ItemRequest<Webhook>(this, Webhook.class, "/webhooks", "POST");
    }

    /**
     * Returns the compact representation of all webhooks your app has
     * registered for the authenticated user in the given workspace.
     *
     * @return Request object
     */
    public CollectionRequest<Webhook> getAll() {

        return new CollectionRequest<Webhook>(this, Webhook.class, "/webhooks", "GET");
    }

    /**
     * Returns the full record for the given webhook.
     *
     * @param  webhook The webhook to get.
     * @return Request object
     */
    public ItemRequest<Webhook> getById(String webhook) {

        String path = String.format("/webhooks/%s", webhook);
        return new ItemRequest<Webhook>(this, Webhook.class, path, "GET");
    }

    /**
     * This method permanently removes a webhook. Note that it may be possible
     * to receive a request that was already in flight after deleting the
     * webhook, but no further requests will be issued.
     *
     * @param  webhook The webhook to delete.
     * @return Request object
     */
    public ItemRequest<Webhook> deleteById(String webhook) {

        String path = String.format("/webhooks/%s", webhook);
        return new ItemRequest<Webhook>(this, Webhook.class, path, "DELETE");
    }
}

package com.asana.resources.gen;

import com.asana.Client;
import com.asana.requests.CollectionRequest;
import com.asana.resources.Resource;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.util.List;

    public class BatchApiBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public BatchApiBase(Client client) { super(client); }

        /**
        * Submit parallel requests
        * Make multiple requests in parallel to Asana&#x27;s API.
        * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
        * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<JsonElement> createBatchRequest(List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/batch";

            CollectionRequest<JsonElement> req = new CollectionRequest<JsonElement>(this, JsonElement.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public CollectionRequest<JsonElement> createBatchRequest() throws IOException {
            return createBatchRequest(null, false);
        }
    }

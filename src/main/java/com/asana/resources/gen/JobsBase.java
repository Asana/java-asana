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

    public class JobsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public JobsBase(Client client) { super(client); }

        /**
        * Get a job by id
        * Returns the full record for a job.
            * @param jobGid Globally unique identifier for the job. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(Job)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Job> getJob(String jobGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/jobs/{job_gid}".replace("{job_gid}", jobGid);

            ItemRequest<Job> req = new ItemRequest<Job>(this, Job.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<Job> getJob(String jobGid) throws IOException {
            return getJob(jobGid, null, false);
        }
    }

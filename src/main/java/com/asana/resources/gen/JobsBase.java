package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.models.Job;
import com.asana.requests.ItemRequest;

/**
 * A _job_ represents a process that handles asynchronous work.
 *
 * Jobs are created when an endpoint requests an action that will be handled asynchronously.
 * Such as project or task duplication.
 */
public class JobsBase extends Resource {
    /**
     * @param client Parent client instance
     */
    public JobsBase(Client client) {
        super(client);
    }

    /**
     * Returns the complete job record for a single job.
     *
     * @param  job The job to get.
     * @return Request object
     */
    public ItemRequest<Job> findById(String job) {

        String path = String.format("/jobs/%s", job);
        return new ItemRequest<Job>(this, Job.class, path, "GET");
    }
}

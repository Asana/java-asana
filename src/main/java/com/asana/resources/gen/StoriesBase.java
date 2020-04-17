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

    public class StoriesBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public StoriesBase(Client client) { super(client); }

        /**
        * Create a story on a task
        * Adds a story to a task. This endpoint currently only allows for comment stories to be created. The comment will be authored by the currently authenticated user, and timestamped when the server receives the request.  Returns the full record for the new story added to the task.
            * @param taskGid The task to operate on. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(Story)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Story> createStoryForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/tasks/{task_gid}/stories".replace("{task_gid}", taskGid);

            ItemRequest<Story> req = new ItemRequest<Story>(this, Story.class, path, "POST")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<Story> createStoryForTask(String taskGid) throws IOException {
            return createStoryForTask(taskGid, null, false);
        }
        /**
        * Delete a story
        * Deletes a story. A user can only delete stories they have created.  Returns an empty data record.
            * @param storyGid Globally unique identifier for the story. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(JsonElement)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<JsonElement> deleteStory(String storyGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/stories/{story_gid}".replace("{story_gid}", storyGid);

            ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "DELETE")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<JsonElement> deleteStory(String storyGid) throws IOException {
            return deleteStory(storyGid, null, false);
        }
        /**
        * Get stories from a task
        * Returns the compact records for all stories on the task.
            * @param taskGid The task to operate on. (required)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return CollectionRequest(Story)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public CollectionRequest<Story> getStoriesForTask(String taskGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/tasks/{task_gid}/stories".replace("{task_gid}", taskGid);

            CollectionRequest<Story> req = new CollectionRequest<Story>(this, Story.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        public CollectionRequest<Story> getStoriesForTask(String taskGid) throws IOException {
            return getStoriesForTask(taskGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Get a story
        * Returns the full record for a single story.
            * @param storyGid Globally unique identifier for the story. (required)
            * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
            * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(Story)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Story> getStory(String storyGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/stories/{story_gid}".replace("{story_gid}", storyGid);

            ItemRequest<Story> req = new ItemRequest<Story>(this, Story.class, path, "GET")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields)
                .query("limit", limit)
                .query("offset", offset);

            return req;
        }

        public ItemRequest<Story> getStory(String storyGid) throws IOException {
            return getStory(storyGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
        }
        /**
        * Update a story
        * Updates the story and returns the full record for the updated story. Only comment stories can have their text updated, and only comment stories and attachment stories can be pinned. Only one of &#x60;text&#x60; and &#x60;html_text&#x60; can be specified.
            * @param storyGid Globally unique identifier for the story. (required)
            * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
            * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
        * @return ItemRequest(Story)
        * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
        */
        public ItemRequest<Story> updateStory(String storyGid, List<String> optFields, Boolean optPretty) throws IOException {
            String path = "/stories/{story_gid}".replace("{story_gid}", storyGid);

            ItemRequest<Story> req = new ItemRequest<Story>(this, Story.class, path, "PUT")
                .query("opt_pretty", optPretty)
                .query("opt_fields", optFields);

            return req;
        }

        public ItemRequest<Story> updateStory(String storyGid) throws IOException {
            return updateStory(storyGid, null, false);
        }
    }

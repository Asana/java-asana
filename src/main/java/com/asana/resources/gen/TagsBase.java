package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.Tag;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.util.List;

    public class TagsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public TagsBase(Client client) { super(client); }

            /**
            * Create a tag
            * Creates a new tag in a workspace or organization.  Every tag is required to be created in a specific workspace or organization, and this cannot be changed once set. Note that you can use the workspace parameter regardless of whether or not it is an organization.  Returns the full record of the newly created tag.
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Tag>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Tag> createTag(List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tags";

                ItemRequest<Tag> req = new ItemRequest<Tag>(this, Tag.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Tag> createTag() throws IOException {
                return createTag(null, false);
            }

            /**
            * Create a tag in a workspace
            * Creates a new tag in a workspace or organization.  Every tag is required to be created in a specific workspace or organization, and this cannot be changed once set. Note that you can use the workspace parameter regardless of whether or not it is an organization.  Returns the full record of the newly created tag.
                * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Tag>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Tag> createTagForWorkspace(String workspaceGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/workspaces/{workspace_gid}/tags".replace("{workspace_gid}", workspaceGid);

                ItemRequest<Tag> req = new ItemRequest<Tag>(this, Tag.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Tag> createTagForWorkspace(String workspaceGid) throws IOException {
                return createTagForWorkspace(workspaceGid, null, false);
            }

            /**
            * Get a tag
            * Returns the complete tag record for a single tag.
                * @param tagGid Globally unique identifier for the tag. (required)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Tag>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Tag> getTag(String tagGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tags/{tag_gid}".replace("{tag_gid}", tagGid);

                ItemRequest<Tag> req = new ItemRequest<Tag>(this, Tag.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public ItemRequest<Tag> getTag(String tagGid) throws IOException {
                return getTag(tagGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Get multiple tags
            * Returns the compact tag records for some filtered set of tags. Use one or more of the parameters provided to filter the tags returned.
                * @param archived Only return tags whose &#x60;archived&#x60; field takes on the value of this parameter. (optional)
                * @param workspace The workspace to filter tags on. (optional)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Tag>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Tag> getTags(Boolean archived, String workspace, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tags";

                CollectionRequest<Tag> req = new CollectionRequest<Tag>(this, Tag.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset)
                    .query("workspace", workspace)
                    .query("archived", archived);

                return req;
            }

            public CollectionRequest<Tag> getTags(Boolean archived, String workspace) throws IOException {
                return getTags(archived, workspace, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Get a task&#x27;s tags
            * Get a compact representation of all of the tags the task has.
                * @param taskGid The task to operate on. (required)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Tag>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Tag> getTagsForTask(String taskGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/tags".replace("{task_gid}", taskGid);

                CollectionRequest<Tag> req = new CollectionRequest<Tag>(this, Tag.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public CollectionRequest<Tag> getTagsForTask(String taskGid) throws IOException {
                return getTagsForTask(taskGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Get tags in a workspace
            * Returns the compact tag records for some filtered set of tags. Use one or more of the parameters provided to filter the tags returned.
                * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Tag>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Tag> getTagsForWorkspace(String workspaceGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/workspaces/{workspace_gid}/tags".replace("{workspace_gid}", workspaceGid);

                CollectionRequest<Tag> req = new CollectionRequest<Tag>(this, Tag.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public CollectionRequest<Tag> getTagsForWorkspace(String workspaceGid) throws IOException {
                return getTagsForWorkspace(workspaceGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Update a tag
            * Updates the properties of a tag. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged.  When using this method, it is best to specify only those fields you wish to change, or else you may overwrite changes made by another user since you last retrieved the task.  Returns the complete updated tag record.
                * @param tagGid Globally unique identifier for the tag. (required)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Tag>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Tag> updateTag(String tagGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tags/{tag_gid}".replace("{tag_gid}", tagGid);

                ItemRequest<Tag> req = new ItemRequest<Tag>(this, Tag.class, path, "PUT")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public ItemRequest<Tag> updateTag(String tagGid) throws IOException {
                return updateTag(tagGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

    }

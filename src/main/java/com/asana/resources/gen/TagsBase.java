package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.gen.ErrorResponse;
import com.asana.models.gen.TagCompact;
import com.asana.models.gen.TagRequest;
import com.asana.models.gen.TagResponse;
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
     * @param body The tag to create. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<TagResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<TagResponse> createTag(TagRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/tags";

        ItemRequest<TagResponse> req = new ItemRequest<TagResponse>(this, TagResponse.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<TagResponse> createTag(TagRequest body) throws IOException {
        return createTag(body, null, false);
    }

    /**
     * Create a tag in a workspace
     * Creates a new tag in a workspace or organization.  Every tag is required to be created in a specific workspace or organization, and this cannot be changed once set. Note that you can use the workspace parameter regardless of whether or not it is an organization.  Returns the full record of the newly created tag.
     * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
     * @param body The tag to create. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<TagResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<TagResponse> createTagForWorkspace(String workspaceGid, TagResponse body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/workspaces/{workspace_gid}/tags".replace("{workspace_gid}", workspaceGid);

        ItemRequest<TagResponse> req = new ItemRequest<TagResponse>(this, TagResponse.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<TagResponse> createTagForWorkspace(String workspaceGid, TagResponse body) throws IOException {
        return createTagForWorkspace(workspaceGid, body, null, false);
    }

    /**
     * Get a tag
     * Returns the complete tag record for a single tag.
     * @param tagGid Globally unique identifier for the tag. (required)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<TagResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<TagResponse> getTag(String tagGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/tags/{tag_gid}".replace("{tag_gid}", tagGid);

        ItemRequest<TagResponse> req = new ItemRequest<TagResponse>(this, TagResponse.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public ItemRequest<TagResponse> getTag(String tagGid) throws IOException {
        return getTag(tagGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Get multiple tags
     * Returns the compact tag records for some filtered set of tags. Use one or more of the parameters provided to filter the tags returned.
     * @param workspace The workspace to filter tags on. (optional)
     * @param archived Only return tags whose &#x60;archived&#x60; field takes on the value of this parameter. (optional)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<TagCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<TagCompact> getTags(String workspace, Boolean archived, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/tags";

        CollectionRequest<TagCompact> req = new CollectionRequest<TagCompact>(this, TagCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset)
            .query("workspace", workspace)
            .query("archived", archived);

        return req;
    }

    public CollectionRequest<TagCompact> getTags(String workspace, Boolean archived) throws IOException {
        return getTags(workspace, archived, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Get a task&#x27;s tags
     * Get a compact representation of all of the tags the task has.
     * @param taskGid The task to operate on. (required)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<TagCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<TagCompact> getTagsForTask(String taskGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/tasks/{task_gid}/tags".replace("{task_gid}", taskGid);

        CollectionRequest<TagCompact> req = new CollectionRequest<TagCompact>(this, TagCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<TagCompact> getTagsForTask(String taskGid) throws IOException {
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
     * @return CollectionRequest<TagCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<TagCompact> getTagsForWorkspace(String workspaceGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/workspaces/{workspace_gid}/tags".replace("{workspace_gid}", workspaceGid);

        CollectionRequest<TagCompact> req = new CollectionRequest<TagCompact>(this, TagCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<TagCompact> getTagsForWorkspace(String workspaceGid) throws IOException {
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
     * @return ItemRequest<TagResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<TagResponse> updateTag(String tagGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/tags/{tag_gid}".replace("{tag_gid}", tagGid);

        ItemRequest<TagResponse> req = new ItemRequest<TagResponse>(this, TagResponse.class, path, "PUT")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public ItemRequest<TagResponse> updateTag(String tagGid) throws IOException {
        return updateTag(tagGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

}

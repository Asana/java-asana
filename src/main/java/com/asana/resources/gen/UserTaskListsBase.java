package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.gen.ErrorResponse;
import com.asana.models.gen.TaskCompact;
import com.asana.models.gen.UserTaskListResponse;
import java.io.IOException;
import java.util.List;

public class UserTaskListsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public UserTaskListsBase(Client client) { super(client); }

    /**
     * Get tasks from a user task list
     * Returns the compact list of tasks in a user’s My Tasks list. The returned tasks will be in order within each assignee status group of &#x60;Inbox&#x60;, &#x60;Today&#x60;, and &#x60;Upcoming&#x60;. *Note: tasks in &#x60;Later&#x60; have a different ordering in the Asana web app than the other assignee status groups; this endpoint will still return them in list order in &#x60;Later&#x60; (differently than they show up in Asana, but the same order as in Asana’s mobile apps).* *Note: Access control is enforced for this endpoint as with all Asana API endpoints, meaning a user’s private tasks will be filtered out if the API-authenticated user does not have access to them.* *Note: Both complete and incomplete tasks are returned by default unless they are filtered out (for example, setting &#x60;completed_since&#x3D;now&#x60; will return only incomplete tasks, which is the default view for “My Tasks” in Asana.)*
     * @param userTaskListGid Globally unique identifier for the user task list. (required)
     * @param completedSince Only return tasks that are either incomplete or that have been completed since this time. Accepts a date-time string or the keyword *now*.  (optional)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<TaskCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<TaskCompact> getTasksForUserTaskList(String userTaskListGid, String completedSince, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/user_task_lists/{user_task_list_gid}/tasks".replace("{user_task_list_gid}", userTaskListGid);

        CollectionRequest<TaskCompact> req = new CollectionRequest<TaskCompact>(this, TaskCompact.class, path, "GET")
            .query("completed_since", completedSince)
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<TaskCompact> getTasksForUserTaskList(String userTaskListGid, String completedSince) throws IOException {
        return getTasksForUserTaskList(userTaskListGid, completedSince, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Get a user task list
     * Returns the full record for a user task list.
     * @param userTaskListGid Globally unique identifier for the user task list. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<UserTaskListResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<UserTaskListResponse> getUserTaskList(String userTaskListGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/user_task_list/{user_task_list_gid}".replace("{user_task_list_gid}", userTaskListGid);

        ItemRequest<UserTaskListResponse> req = new ItemRequest<UserTaskListResponse>(this, UserTaskListResponse.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<UserTaskListResponse> getUserTaskList(String userTaskListGid) throws IOException {
        return getUserTaskList(userTaskListGid, null, false);
    }

    /**
     * Get a user&#x27;s task list
     * Returns the full record for a user&#x27;s task list.
     * @param userGid Globally unique identifier for the user. (required)
     * @param workspace The workspace in which to get the user task list. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<UserTaskListResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<UserTaskListResponse> getUserTaskListForUser(String userGid, String workspace, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/users/{user_gid}/user_task_list".replace("{user_gid}", userGid);

        ItemRequest<UserTaskListResponse> req = new ItemRequest<UserTaskListResponse>(this, UserTaskListResponse.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("workspace", workspace);

        return req;
    }

    public ItemRequest<UserTaskListResponse> getUserTaskListForUser(String userGid, String workspace) throws IOException {
        return getUserTaskListForUser(userGid, workspace, null, false);
    }

}

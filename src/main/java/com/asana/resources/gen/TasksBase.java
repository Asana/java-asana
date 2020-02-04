package com.asana.resources.gen;

import com.asana.Client;
import com.asana.models.Job;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.Task;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

    public class TasksBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public TasksBase(Client client) { super(client); }

            /**
            * Set dependencies for a task
            * Marks a set of tasks as dependencies of this task, if they are not already dependencies. *A task can have at most 15 dependencies*.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> addDependenciesForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/addDependencies".replace("{task_gid}", taskGid);

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public CollectionRequest<Task> addDependenciesForTask(String taskGid) throws IOException {
                return addDependenciesForTask(taskGid, null, false);
            }

            /**
            * Set dependents for a task
            * Marks a set of tasks as dependents of this task, if they are not already dependents. *A task can have at most 30 dependents*.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> addDependentsForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/addDependents".replace("{task_gid}", taskGid);

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public CollectionRequest<Task> addDependentsForTask(String taskGid) throws IOException {
                return addDependentsForTask(taskGid, null, false);
            }

            /**
            * Add followers to a task
            * Adds followers to a task. Returns an empty data block. Each task can be associated with zero or more followers in the system. Requests to add/remove followers, if successful, will return the complete updated task record, described above.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> addFollowersForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/addFollowers".replace("{task_gid}", taskGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> addFollowersForTask(String taskGid) throws IOException {
                return addFollowersForTask(taskGid, null, false);
            }

            /**
            * Add a project to a task
            * Adds the task to the specified project, in the optional location specified. If no location arguments are given, the task will be added to the end of the project.  &#x60;addProject&#x60; can also be used to reorder a task within a project or section that already contains it.  At most one of &#x60;insert_before&#x60;, &#x60;insert_after&#x60;, or &#x60;section&#x60; should be specified. Inserting into a section in an non-order-dependent way can be done by specifying section, otherwise, to insert within a section in a particular place, specify &#x60;insert_before&#x60; or &#x60;insert_after&#x60; and a task within the section to anchor the position of this task.  Returns an empty data block.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> addProjectForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/addProject".replace("{task_gid}", taskGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> addProjectForTask(String taskGid) throws IOException {
                return addProjectForTask(taskGid, null, false);
            }

            /**
            * Add a tag to a task
            * Adds a tag to a task. Returns an empty data block.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> addTagForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/addTag".replace("{task_gid}", taskGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> addTagForTask(String taskGid) throws IOException {
                return addTagForTask(taskGid, null, false);
            }

            /**
            * Create a subtask
            * Creates a new subtask and adds it to the parent task. Returns the full record for the newly created subtask.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Task> createSubtaskForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/subtasks".replace("{task_gid}", taskGid);

                ItemRequest<Task> req = new ItemRequest<Task>(this, Task.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Task> createSubtaskForTask(String taskGid) throws IOException {
                return createSubtaskForTask(taskGid, null, false);
            }

            /**
            * Create a task
            * Creating a new task is as easy as POSTing to the &#x60;/tasks&#x60; endpoint with a data block containing the fields you’d like to set on the task. Any unspecified fields will take on default values.  Every task is required to be created in a specific workspace, and this workspace cannot be changed once set. The workspace need not be set explicitly if you specify &#x60;projects&#x60; or a &#x60;parent&#x60; task instead.
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Task> createTask(List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks";

                ItemRequest<Task> req = new ItemRequest<Task>(this, Task.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Task> createTask() throws IOException {
                return createTask(null, false);
            }

            /**
            * Delete a task
            * A specific, existing task can be deleted by making a DELETE request on the URL for that task. Deleted tasks go into the “trash” of the user making the delete request. Tasks can be recovered from the trash within a period of 30 days; afterward they are completely removed from the system.  Returns an empty data record.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> deleteTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}".replace("{task_gid}", taskGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "DELETE")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> deleteTask(String taskGid) throws IOException {
                return deleteTask(taskGid, null, false);
            }

            /**
            * Duplicate a task
            * Creates and returns a job that will asynchronously handle the duplication.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Job>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Job> duplicateTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/duplicate".replace("{task_gid}", taskGid);

                ItemRequest<Job> req = new ItemRequest<Job>(this, Job.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Job> duplicateTask(String taskGid) throws IOException {
                return duplicateTask(taskGid, null, false);
            }

            /**
            * Get dependencies from a task
            * Returns the compact representations of all of the dependencies of a task.
                * @param taskGid The task to operate on. (required)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> getDependenciesForTask(String taskGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/dependencies".replace("{task_gid}", taskGid);

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public CollectionRequest<Task> getDependenciesForTask(String taskGid) throws IOException {
                return getDependenciesForTask(taskGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Get dependents from a task
            * Returns the compact representations of all of the dependents of a task.
                * @param taskGid The task to operate on. (required)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> getDependentsForTask(String taskGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/dependents".replace("{task_gid}", taskGid);

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public CollectionRequest<Task> getDependentsForTask(String taskGid) throws IOException {
                return getDependentsForTask(taskGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Get subtasks from a task
            * Returns a compact representation of all of the subtasks of a task.
                * @param taskGid The task to operate on. (required)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> getSubtasksForTask(String taskGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/subtasks".replace("{task_gid}", taskGid);

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public CollectionRequest<Task> getSubtasksForTask(String taskGid) throws IOException {
                return getSubtasksForTask(taskGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Get a task
            * Returns the complete task record for a single task.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Task> getTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}".replace("{task_gid}", taskGid);

                ItemRequest<Task> req = new ItemRequest<Task>(this, Task.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Task> getTask(String taskGid) throws IOException {
                return getTask(taskGid, null, false);
            }

            /**
            * Get multiple tasks
            * Returns the compact task records for some filtered set of tasks. Use one or more of the parameters provided to filter the tasks returned. You must specify a &#x60;project&#x60; or &#x60;tag&#x60; if you do not specify &#x60;assignee&#x60; and &#x60;workspace&#x60;.  For more complex task retrieval, use [workspaces/{workspace_gid}/tasks/search](#search-tasks-in-a-workspace).
                * @param modifiedSince Only return tasks that have been modified since the given time.  *Note: A task is considered “modified” if any of its properties change, or associations between it and other objects are modified (e.g.  a task being added to a project). A task is not considered modified just because another object it is associated with (e.g. a subtask) is modified. Actions that count as modifying the task include assigning, renaming, completing, and adding stories.* (optional)
                * @param completedSince Only return tasks that are either incomplete or that have been completed since this time. (optional)
                * @param workspace The workspace to filter tasks on. *Note: If you specify &#x60;workspace&#x60;, you must also specify the &#x60;assignee&#x60; to filter on.* (optional)
                * @param section The section to filter tasks on. *Note: Currently, this is only supported in board views.* (optional)
                * @param project The project to filter tasks on. (optional)
                * @param assignee The assignee to filter tasks on. *Note: If you specify &#x60;assignee&#x60;, you must also specify the &#x60;workspace&#x60; to filter on.* (optional)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> getTasks(OffsetDateTime modifiedSince, OffsetDateTime completedSince, String workspace, String section, String project, String assignee, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks";

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset)
                    .query("assignee", assignee)
                    .query("project", project)
                    .query("section", section)
                    .query("workspace", workspace)
                    .query("completed_since", completedSince)
                    .query("modified_since", modifiedSince);

                return req;
            }

            public CollectionRequest<Task> getTasks(OffsetDateTime modifiedSince, OffsetDateTime completedSince, String workspace, String section, String project, String assignee) throws IOException {
                return getTasks(modifiedSince, completedSince, workspace, section, project, assignee, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Get tasks from a project
            * Returns the compact task records for all tasks within the given project, ordered by their priority within the project. Tasks can exist in more than one project at a time.
                * @param projectGid Globally unique identifier for the project. (required)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> getTasksForProject(String projectGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/projects/{project_gid}/tasks".replace("{project_gid}", projectGid);

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public CollectionRequest<Task> getTasksForProject(String projectGid) throws IOException {
                return getTasksForProject(projectGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Get tasks from a section
            * *Board view only*: Returns the compact section records for all tasks within the given section.
                * @param sectionGid The globally unique identifier for the section. (required)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> getTasksForSection(String sectionGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/sections/{section_gid}/tasks".replace("{section_gid}", sectionGid);

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public CollectionRequest<Task> getTasksForSection(String sectionGid) throws IOException {
                return getTasksForSection(sectionGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Get tasks from a tag
            * Returns the compact task records for all tasks with the given tag. Tasks can have more than one tag at a time.
                * @param tagGid Globally unique identifier for the tag. (required)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> getTasksForTag(String tagGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tags/{tag_gid}/tasks".replace("{tag_gid}", tagGid);

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public CollectionRequest<Task> getTasksForTag(String tagGid) throws IOException {
                return getTasksForTag(tagGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Get tasks from a user task list
            * Returns the compact list of tasks in a user’s My Tasks list. The returned tasks will be in order within each assignee status group of &#x60;Inbox&#x60;, &#x60;Today&#x60;, and &#x60;Upcoming&#x60;. *Note: tasks in &#x60;Later&#x60; have a different ordering in the Asana web app than the other assignee status groups; this endpoint will still return them in list order in &#x60;Later&#x60; (differently than they show up in Asana, but the same order as in Asana’s mobile apps).* *Note: Access control is enforced for this endpoint as with all Asana API endpoints, meaning a user’s private tasks will be filtered out if the API-authenticated user does not have access to them.* *Note: Both complete and incomplete tasks are returned by default unless they are filtered out (for example, setting &#x60;completed_since&#x3D;now&#x60; will return only incomplete tasks, which is the default view for “My Tasks” in Asana.)*
                * @param userTaskListGid Globally unique identifier for the user task list. (required)
                * @param completedSince Only return tasks that are either incomplete or that have been completed since this time. Accepts a date-time string or the keyword *now*.  (optional)
                * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
                * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> getTasksForUserTaskList(String userTaskListGid, String completedSince, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/user_task_lists/{user_task_list_gid}/tasks".replace("{user_task_list_gid}", userTaskListGid);

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "GET")
                    .query("completed_since", completedSince)
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("limit", limit)
                    .query("offset", offset);

                return req;
            }

            public CollectionRequest<Task> getTasksForUserTaskList(String userTaskListGid, String completedSince) throws IOException {
                return getTasksForUserTaskList(userTaskListGid, completedSince, null, (int)Client.DEFAULTS.get("page_size"), null, false);
            }

            /**
            * Unlink dependencies from a task
            * Unlinks a set of dependencies from this task.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> removeDependenciesForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/removeDependencies".replace("{task_gid}", taskGid);

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public CollectionRequest<Task> removeDependenciesForTask(String taskGid) throws IOException {
                return removeDependenciesForTask(taskGid, null, false);
            }

            /**
            * Unlink dependents from a task
            * Unlinks a set of dependents from this task.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> removeDependentsForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/removeDependents".replace("{task_gid}", taskGid);

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public CollectionRequest<Task> removeDependentsForTask(String taskGid) throws IOException {
                return removeDependentsForTask(taskGid, null, false);
            }

            /**
            * Remove followers from a task
            * Removes each of the specified followers from the task if they are following. Returns the complete, updated record for the affected task.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> removeFollowerForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/removeFollowers".replace("{task_gid}", taskGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> removeFollowerForTask(String taskGid) throws IOException {
                return removeFollowerForTask(taskGid, null, false);
            }

            /**
            * Remove a project from a task
            * Removes the task from the specified project. The task will still exist in the system, but it will not be in the project anymore.  Returns an empty data block.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> removeProjectForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/removeProject".replace("{task_gid}", taskGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> removeProjectForTask(String taskGid) throws IOException {
                return removeProjectForTask(taskGid, null, false);
            }

            /**
            * Remove a tag from a task
            * Removes a tag from a task. Returns an empty data block.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<JsonElement>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<JsonElement> removeTagForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/removeTag".replace("{task_gid}", taskGid);

                ItemRequest<JsonElement> req = new ItemRequest<JsonElement>(this, JsonElement.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<JsonElement> removeTagForTask(String taskGid) throws IOException {
                return removeTagForTask(taskGid, null, false);
            }

            /**
            * Search tasks in a workspace
            * To mirror the functionality of the Asana web app&#x27;s advanced search feature, the Asana API has a task search endpoint that allows you to build complex filters to find and retrieve the exact data you need. #### Premium access Like the Asana web product&#x27;s advance search feature, this search endpoint will only be available to premium Asana users. A user is premium if any of the following is true:  - The workspace in which the search is being performed is a premium workspace - The user is a member of a premium team inside the workspace  Even if a user is only a member of a premium team inside a non-premium workspace, search will allow them to find data anywhere in the workspace, not just inside the premium team. Making a search request using credentials of a non-premium user will result in a &#x60;402 Payment Required&#x60; error. #### Pagination Search results are not stable; repeating the same query multiple times may return the data in a different order, even if the data do not change. Because of this, the traditional [pagination](https://developers.asana.com/docs/#pagination) available elsewhere in the Asana API is not available here. However, you can paginate manually by sorting the search results by their creation time and then modifying each subsequent query to exclude data you have already seen. Page sizes are limited to a maximum of 100 items, and can be specified by the &#x60;limit&#x60; query parameter. #### Eventual consistency Changes in Asana (regardless of whether they’re made though the web product or the API) are forwarded to our search infrastructure to be indexed. This process can take between 10 and 60 seconds to complete under normal operation, and longer during some production incidents. Making a change to a task that would alter its presence in a particular search query will not be reflected immediately. This is also true of the advanced search feature in the web product. #### Rate limits You may receive a &#x60;429 Too Many Requests&#x60; response if you hit any of our [rate limits](https://developers.asana.com/docs/#rate-limits). #### Custom field parameters | Parameter name | Custom field type | Accepted type | |---|---|---| | custom_fields.{gid}.is_set | All | Boolean | | custom_fields.{gid}.value | Text | String | | custom_fields.{gid}.value | Number | Number | | custom_fields.{gid}.value | Enum | Enum option ID | | custom_fields.{gid}.starts_with | Text only | String | | custom_fields.{gid}.ends_with | Text only | String | | custom_fields.{gid}.contains | Text only | String | | custom_fields.{gid}.less_than | Number only | Number | | custom_fields.{gid}.greater_than | Number only | Number |   For example, if the gid of the custom field is 12345, these query parameter to find tasks where it is set would be &#x60;custom_fields.12345.is_set&#x3D;true&#x60;. To match an exact value for an enum custom field, use the gid of the desired enum option and not the name of the enum option: &#x60;custom_fields.12345.value&#x3D;67890&#x60;.  Searching for multiple exact matches of a custom field is not supported.
                * @param workspaceGid Globally unique identifier for the workspace or organization. (required)
                * @param sortAscending Default &#x60;false&#x60; (optional)
                * @param sortBy One of &#x60;due_date&#x60;, &#x60;created_at&#x60;, &#x60;completed_at&#x60;, &#x60;likes&#x60;, or &#x60;modified_at&#x60;, defaults to &#x60;modified_at&#x60; (optional)
                * @param isSubtask Filter to subtasks (optional)
                * @param completed Filter to completed tasks (optional)
                * @param hasAttachment Filter to tasks with attachments (optional)
                * @param isBlocked Filter to tasks with incomplete dependencies (optional)
                * @param isBlocking Filter to incomplete tasks with dependents (optional)
                * @param modifiedAtAfter ISO 8601 datetime string (optional)
                * @param modifiedAtBefore ISO 8601 datetime string (optional)
                * @param dueOnBefore ISO 8601 date string (optional)
                * @param modifiedOn ISO 8601 date string or &#x60;null&#x60; (optional)
                * @param modifiedOnAfter ISO 8601 date string (optional)
                * @param modifiedOnBefore ISO 8601 date string (optional)
                * @param completedAtAfter ISO 8601 datetime string (optional)
                * @param completedAtBefore ISO 8601 datetime string (optional)
                * @param completedOn ISO 8601 date string or &#x60;null&#x60; (optional)
                * @param completedOnAfter ISO 8601 date string (optional)
                * @param completedOnBefore ISO 8601 date string (optional)
                * @param createdAtAfter ISO 8601 datetime string (optional)
                * @param commentedOnByNot Comma-separated list of user identifiers (optional)
                * @param createdAtBefore ISO 8601 datetime string (optional)
                * @param createdOn ISO 8601 date string or &#x60;null&#x60; (optional)
                * @param createdOnAfter ISO 8601 date string (optional)
                * @param createdOnBefore ISO 8601 date string (optional)
                * @param startOn ISO 8601 date string or &#x60;null&#x60; (optional)
                * @param startOnAfter ISO 8601 date string (optional)
                * @param startOnBefore ISO 8601 date string (optional)
                * @param dueAtAfter ISO 8601 datetime string (optional)
                * @param dueAtBefore ISO 8601 datetime string (optional)
                * @param dueOn ISO 8601 date string or &#x60;null&#x60; (optional)
                * @param commentedOnByAny Comma-separated list of user identifiers (optional)
                * @param dueOnAfter ISO 8601 date string (optional)
                * @param likedByNot Comma-separated list of user identifiers (optional)
                * @param likedByAny Comma-separated list of user identifiers (optional)
                * @param assignedByNot Comma-separated list of user identifiers (optional)
                * @param assignedByAny Comma-separated list of user identifiers (optional)
                * @param createdByNot Comma-separated list of user identifiers (optional)
                * @param createdByAny Comma-separated list of user identifiers (optional)
                * @param followersNot Comma-separated list of user identifiers (optional)
                * @param followersAny Comma-separated list of user identifiers (optional)
                * @param teamsAny Comma-separated list of team IDs (optional)
                * @param tagsAll Comma-separated list of tag IDs (optional)
                * @param tagsNot Comma-separated list of tag IDs (optional)
                * @param tagsAny Comma-separated list of tag IDs (optional)
                * @param sectionsAll Comma-separated list of section or column IDs (optional)
                * @param sectionsNot Comma-separated list of section or column IDs (optional)
                * @param sectionsAny Comma-separated list of section or column IDs (optional)
                * @param projectsAll Comma-separated list of project IDs (optional)
                * @param projectsNot Comma-separated list of project IDs (optional)
                * @param projectsAny Comma-separated list of project IDs (optional)
                * @param assigneeStatus One of &#x60;inbox&#x60;, &#x60;today&#x60;, &#x60;upcoming&#x60;, or &#x60;later&#x60; (optional)
                * @param assigneeNot Comma-separated list of user identifiers (optional)
                * @param assigneeAny Comma-separated list of user identifiers (optional)
                * @param resourceSubtype Filters results by the task&#x27;s resource_subtype (optional)
                * @param text Performs full-text search on both task name and description (optional)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return CollectionRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public CollectionRequest<Task> searchTasksForWorkspace(String workspaceGid, Boolean sortAscending, String sortBy, Boolean isSubtask, Boolean completed, Boolean hasAttachment, Boolean isBlocked, Boolean isBlocking, OffsetDateTime modifiedAtAfter, OffsetDateTime modifiedAtBefore, LocalDate dueOnBefore, LocalDate modifiedOn, LocalDate modifiedOnAfter, LocalDate modifiedOnBefore, OffsetDateTime completedAtAfter, OffsetDateTime completedAtBefore, LocalDate completedOn, LocalDate completedOnAfter, LocalDate completedOnBefore, OffsetDateTime createdAtAfter, String commentedOnByNot, OffsetDateTime createdAtBefore, LocalDate createdOn, LocalDate createdOnAfter, LocalDate createdOnBefore, LocalDate startOn, LocalDate startOnAfter, LocalDate startOnBefore, OffsetDateTime dueAtAfter, OffsetDateTime dueAtBefore, LocalDate dueOn, String commentedOnByAny, LocalDate dueOnAfter, String likedByNot, String likedByAny, String assignedByNot, String assignedByAny, String createdByNot, String createdByAny, String followersNot, String followersAny, String teamsAny, String tagsAll, String tagsNot, String tagsAny, String sectionsAll, String sectionsNot, String sectionsAny, String projectsAll, String projectsNot, String projectsAny, String assigneeStatus, String assigneeNot, String assigneeAny, String resourceSubtype, String text, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/workspaces/{workspace_gid}/tasks/search".replace("{workspace_gid}", workspaceGid);

                CollectionRequest<Task> req = new CollectionRequest<Task>(this, Task.class, path, "GET")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields)
                    .query("text", text)
                    .query("resource_subtype", resourceSubtype)
                    .query("assignee.any", assigneeAny)
                    .query("assignee.not", assigneeNot)
                    .query("assignee_status", assigneeStatus)
                    .query("projects.any", projectsAny)
                    .query("projects.not", projectsNot)
                    .query("projects.all", projectsAll)
                    .query("sections.any", sectionsAny)
                    .query("sections.not", sectionsNot)
                    .query("sections.all", sectionsAll)
                    .query("tags.any", tagsAny)
                    .query("tags.not", tagsNot)
                    .query("tags.all", tagsAll)
                    .query("teams.any", teamsAny)
                    .query("followers.any", followersAny)
                    .query("followers.not", followersNot)
                    .query("created_by.any", createdByAny)
                    .query("created_by.not", createdByNot)
                    .query("assigned_by.any", assignedByAny)
                    .query("assigned_by.not", assignedByNot)
                    .query("liked_by.any", likedByAny)
                    .query("liked_by.not", likedByNot)
                    .query("commented_on_by.any", commentedOnByAny)
                    .query("commented_on_by.not", commentedOnByNot)
                    .query("due_on.before", dueOnBefore)
                    .query("due_on.after", dueOnAfter)
                    .query("due_on", dueOn)
                    .query("due_at.before", dueAtBefore)
                    .query("due_at.after", dueAtAfter)
                    .query("start_on.before", startOnBefore)
                    .query("start_on.after", startOnAfter)
                    .query("start_on", startOn)
                    .query("created_on.before", createdOnBefore)
                    .query("created_on.after", createdOnAfter)
                    .query("created_on", createdOn)
                    .query("created_at.before", createdAtBefore)
                    .query("created_at.after", createdAtAfter)
                    .query("completed_on.before", completedOnBefore)
                    .query("completed_on.after", completedOnAfter)
                    .query("completed_on", completedOn)
                    .query("completed_at.before", completedAtBefore)
                    .query("completed_at.after", completedAtAfter)
                    .query("modified_on.before", modifiedOnBefore)
                    .query("modified_on.after", modifiedOnAfter)
                    .query("modified_on", modifiedOn)
                    .query("modified_at.before", modifiedAtBefore)
                    .query("modified_at.after", modifiedAtAfter)
                    .query("is_blocking", isBlocking)
                    .query("is_blocked", isBlocked)
                    .query("has_attachment", hasAttachment)
                    .query("completed", completed)
                    .query("is_subtask", isSubtask)
                    .query("sort_by", sortBy)
                    .query("sort_ascending", sortAscending);

                return req;
            }

            public CollectionRequest<Task> searchTasksForWorkspace(String workspaceGid, Boolean sortAscending, String sortBy, Boolean isSubtask, Boolean completed, Boolean hasAttachment, Boolean isBlocked, Boolean isBlocking, OffsetDateTime modifiedAtAfter, OffsetDateTime modifiedAtBefore, LocalDate dueOnBefore, LocalDate modifiedOn, LocalDate modifiedOnAfter, LocalDate modifiedOnBefore, OffsetDateTime completedAtAfter, OffsetDateTime completedAtBefore, LocalDate completedOn, LocalDate completedOnAfter, LocalDate completedOnBefore, OffsetDateTime createdAtAfter, String commentedOnByNot, OffsetDateTime createdAtBefore, LocalDate createdOn, LocalDate createdOnAfter, LocalDate createdOnBefore, LocalDate startOn, LocalDate startOnAfter, LocalDate startOnBefore, OffsetDateTime dueAtAfter, OffsetDateTime dueAtBefore, LocalDate dueOn, String commentedOnByAny, LocalDate dueOnAfter, String likedByNot, String likedByAny, String assignedByNot, String assignedByAny, String createdByNot, String createdByAny, String followersNot, String followersAny, String teamsAny, String tagsAll, String tagsNot, String tagsAny, String sectionsAll, String sectionsNot, String sectionsAny, String projectsAll, String projectsNot, String projectsAny, String assigneeStatus, String assigneeNot, String assigneeAny, String resourceSubtype, String text) throws IOException {
                return searchTasksForWorkspace(workspaceGid, sortAscending, sortBy, isSubtask, completed, hasAttachment, isBlocked, isBlocking, modifiedAtAfter, modifiedAtBefore, dueOnBefore, modifiedOn, modifiedOnAfter, modifiedOnBefore, completedAtAfter, completedAtBefore, completedOn, completedOnAfter, completedOnBefore, createdAtAfter, commentedOnByNot, createdAtBefore, createdOn, createdOnAfter, createdOnBefore, startOn, startOnAfter, startOnBefore, dueAtAfter, dueAtBefore, dueOn, commentedOnByAny, dueOnAfter, likedByNot, likedByAny, assignedByNot, assignedByAny, createdByNot, createdByAny, followersNot, followersAny, teamsAny, tagsAll, tagsNot, tagsAny, sectionsAll, sectionsNot, sectionsAny, projectsAll, projectsNot, projectsAny, assigneeStatus, assigneeNot, assigneeAny, resourceSubtype, text, null, false);
            }

            /**
            * Set the parent of a task
            * parent, or no parent task at all. Returns an empty data block. When using &#x60;insert_before&#x60; and &#x60;insert_after&#x60;, at most one of those two options can be specified, and they must already be subtasks of the parent.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Task> setParentForTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}/setParent".replace("{task_gid}", taskGid);

                ItemRequest<Task> req = new ItemRequest<Task>(this, Task.class, path, "POST")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Task> setParentForTask(String taskGid) throws IOException {
                return setParentForTask(taskGid, null, false);
            }

            /**
            * Update a task
            * A specific, existing task can be updated by making a PUT request on the URL for that task. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged.  When using this method, it is best to specify only those fields you wish to change, or else you may overwrite changes made by another user since you last retrieved the task.  Returns the complete updated task record.
                * @param taskGid The task to operate on. (required)
                * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
                * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
            * @return ItemRequest<Task>
            * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
            */
            public ItemRequest<Task> updateTask(String taskGid, List<String> optFields, Boolean optPretty) throws IOException {
                String path = "/tasks/{task_gid}".replace("{task_gid}", taskGid);

                ItemRequest<Task> req = new ItemRequest<Task>(this, Task.class, path, "PUT")
                    .query("opt_pretty", optPretty)
                    .query("opt_fields", optFields);

                return req;
            }

            public ItemRequest<Task> updateTask(String taskGid) throws IOException {
                return updateTask(taskGid, null, false);
            }

    }

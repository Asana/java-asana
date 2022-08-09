# TasksApi

All URIs are relative to *https://app.asana.com/api/1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addDependenciesForTask**](TasksApi.md#addDependenciesForTask) | **POST** /tasks/{task_gid}/addDependencies | Set dependencies for a task
[**addDependentsForTask**](TasksApi.md#addDependentsForTask) | **POST** /tasks/{task_gid}/addDependents | Set dependents for a task
[**addFollowersForTask**](TasksApi.md#addFollowersForTask) | **POST** /tasks/{task_gid}/addFollowers | Add followers to a task
[**addProjectForTask**](TasksApi.md#addProjectForTask) | **POST** /tasks/{task_gid}/addProject | Add a project to a task
[**addTagForTask**](TasksApi.md#addTagForTask) | **POST** /tasks/{task_gid}/addTag | Add a tag to a task
[**createSubtaskForTask**](TasksApi.md#createSubtaskForTask) | **POST** /tasks/{task_gid}/subtasks | Create a subtask
[**createTask**](TasksApi.md#createTask) | **POST** /tasks | Create a task
[**deleteTask**](TasksApi.md#deleteTask) | **DELETE** /tasks/{task_gid} | Delete a task
[**duplicateTask**](TasksApi.md#duplicateTask) | **POST** /tasks/{task_gid}/duplicate | Duplicate a task
[**getDependenciesForTask**](TasksApi.md#getDependenciesForTask) | **GET** /tasks/{task_gid}/dependencies | Get dependencies from a task
[**getDependentsForTask**](TasksApi.md#getDependentsForTask) | **GET** /tasks/{task_gid}/dependents | Get dependents from a task
[**getSubtasksForTask**](TasksApi.md#getSubtasksForTask) | **GET** /tasks/{task_gid}/subtasks | Get subtasks from a task
[**getTask**](TasksApi.md#getTask) | **GET** /tasks/{task_gid} | Get a task
[**getTasks**](TasksApi.md#getTasks) | **GET** /tasks | Get multiple tasks
[**getTasksForProject**](TasksApi.md#getTasksForProject) | **GET** /projects/{project_gid}/tasks | Get tasks from a project
[**getTasksForSection**](TasksApi.md#getTasksForSection) | **GET** /sections/{section_gid}/tasks | Get tasks from a section
[**getTasksForTag**](TasksApi.md#getTasksForTag) | **GET** /tags/{tag_gid}/tasks | Get tasks from a tag
[**getTasksForUserTaskList**](TasksApi.md#getTasksForUserTaskList) | **GET** /user_task_lists/{user_task_list_gid}/tasks | Get tasks from a user task list
[**removeDependenciesForTask**](TasksApi.md#removeDependenciesForTask) | **POST** /tasks/{task_gid}/removeDependencies | Unlink dependencies from a task
[**removeDependentsForTask**](TasksApi.md#removeDependentsForTask) | **POST** /tasks/{task_gid}/removeDependents | Unlink dependents from a task
[**removeFollowerForTask**](TasksApi.md#removeFollowerForTask) | **POST** /tasks/{task_gid}/removeFollowers | Remove followers from a task
[**removeProjectForTask**](TasksApi.md#removeProjectForTask) | **POST** /tasks/{task_gid}/removeProject | Remove a project from a task
[**removeTagForTask**](TasksApi.md#removeTagForTask) | **POST** /tasks/{task_gid}/removeTag | Remove a tag from a task
[**searchTasksForWorkspace**](TasksApi.md#searchTasksForWorkspace) | **GET** /workspaces/{workspace_gid}/tasks/search | Search tasks in a workspace
[**setParentForTask**](TasksApi.md#setParentForTask) | **POST** /tasks/{task_gid}/setParent | Set the parent of a task
[**updateTask**](TasksApi.md#updateTask) | **PUT** /tasks/{task_gid} | Update a task

<a name="addDependenciesForTask"></a>
# **addDependenciesForTask**
> InlineResponse2001 addDependenciesForTask(body, taskGid, optPretty, optFields)

Set dependencies for a task

Marks a set of tasks as dependencies of this task, if they are not already dependencies. *A task can have at most 30 dependents and dependencies combined*.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidAddDependenciesBody body = new TaskGidAddDependenciesBody(); // TaskGidAddDependenciesBody | The list of tasks to set as dependencies.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.addDependenciesForTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#addDependenciesForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidAddDependenciesBody**](TaskGidAddDependenciesBody.md)| The list of tasks to set as dependencies. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addDependentsForTask"></a>
# **addDependentsForTask**
> InlineResponse2001 addDependentsForTask(body, taskGid, optPretty, optFields)

Set dependents for a task

Marks a set of tasks as dependents of this task, if they are not already dependents. *A task can have at most 30 dependents and dependencies combined*.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidAddDependentsBody body = new TaskGidAddDependentsBody(); // TaskGidAddDependentsBody | The list of tasks to add as dependents.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.addDependentsForTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#addDependentsForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidAddDependentsBody**](TaskGidAddDependentsBody.md)| The list of tasks to add as dependents. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addFollowersForTask"></a>
# **addFollowersForTask**
> InlineResponse2016 addFollowersForTask(body, taskGid, optPretty, optFields)

Add followers to a task

Adds followers to a task. Returns an empty data block. Each task can be associated with zero or more followers in the system. Requests to add/remove followers, if successful, will return the complete updated task record, described above.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidAddFollowersBody body = new TaskGidAddFollowersBody(); // TaskGidAddFollowersBody | The followers to add to the task.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2016 result = apiInstance.addFollowersForTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#addFollowersForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidAddFollowersBody**](TaskGidAddFollowersBody.md)| The followers to add to the task. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2016**](InlineResponse2016.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addProjectForTask"></a>
# **addProjectForTask**
> InlineResponse2001 addProjectForTask(body, taskGid, optPretty, optFields)

Add a project to a task

Adds the task to the specified project, in the optional location specified. If no location arguments are given, the task will be added to the end of the project.  &#x60;addProject&#x60; can also be used to reorder a task within a project or section that already contains it.  At most one of &#x60;insert_before&#x60;, &#x60;insert_after&#x60;, or &#x60;section&#x60; should be specified. Inserting into a section in an non-order-dependent way can be done by specifying section, otherwise, to insert within a section in a particular place, specify &#x60;insert_before&#x60; or &#x60;insert_after&#x60; and a task within the section to anchor the position of this task.  Returns an empty data block.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidAddProjectBody body = new TaskGidAddProjectBody(); // TaskGidAddProjectBody | The project to add the task to.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.addProjectForTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#addProjectForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidAddProjectBody**](TaskGidAddProjectBody.md)| The project to add the task to. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addTagForTask"></a>
# **addTagForTask**
> InlineResponse2001 addTagForTask(body, taskGid, optPretty, optFields)

Add a tag to a task

Adds a tag to a task. Returns an empty data block.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidAddTagBody body = new TaskGidAddTagBody(); // TaskGidAddTagBody | The tag to add to the task.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.addTagForTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#addTagForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidAddTagBody**](TaskGidAddTagBody.md)| The tag to add to the task. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createSubtaskForTask"></a>
# **createSubtaskForTask**
> InlineResponse2016 createSubtaskForTask(body, taskGid, optPretty, optFields)

Create a subtask

Creates a new subtask and adds it to the parent task. Returns the full record for the newly created subtask.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidSubtasksBody body = new TaskGidSubtasksBody(); // TaskGidSubtasksBody | The new subtask to create.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2016 result = apiInstance.createSubtaskForTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#createSubtaskForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidSubtasksBody**](TaskGidSubtasksBody.md)| The new subtask to create. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2016**](InlineResponse2016.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createTask"></a>
# **createTask**
> InlineResponse2016 createTask(body, optPretty, optFields)

Create a task

Creating a new task is as easy as POSTing to the &#x60;/tasks&#x60; endpoint with a data block containing the fields you’d like to set on the task. Any unspecified fields will take on default values.  Every task is required to be created in a specific workspace, and this workspace cannot be changed once set. The workspace need not be set explicitly if you specify &#x60;projects&#x60; or a &#x60;parent&#x60; task instead.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TasksBody body = new TasksBody(); // TasksBody | The task to create.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2016 result = apiInstance.createTask(body, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#createTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TasksBody**](TasksBody.md)| The task to create. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2016**](InlineResponse2016.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteTask"></a>
# **deleteTask**
> InlineResponse2001 deleteTask(taskGid, optPretty, optFields)

Delete a task

A specific, existing task can be deleted by making a DELETE request on the URL for that task. Deleted tasks go into the “trash” of the user making the delete request. Tasks can be recovered from the trash within a period of 30 days; afterward they are completely removed from the system.  Returns an empty data record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.deleteTask(taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#deleteTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="duplicateTask"></a>
# **duplicateTask**
> InlineResponse20012 duplicateTask(body, taskGid, optPretty, optFields)

Duplicate a task

Creates and returns a job that will asynchronously handle the duplication.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidDuplicateBody body = new TaskGidDuplicateBody(); // TaskGidDuplicateBody | Describes the duplicate's name and the fields that will be duplicated.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse20012 result = apiInstance.duplicateTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#duplicateTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidDuplicateBody**](TaskGidDuplicateBody.md)| Describes the duplicate&#x27;s name and the fields that will be duplicated. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse20012**](InlineResponse20012.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getDependenciesForTask"></a>
# **getDependenciesForTask**
> InlineResponse20033 getDependenciesForTask(taskGid, optPretty, optFields, limit, offset)

Get dependencies from a task

Returns the compact representations of all of the dependencies of a task.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20033 result = apiInstance.getDependenciesForTask(taskGid, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getDependenciesForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20033**](InlineResponse20033.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDependentsForTask"></a>
# **getDependentsForTask**
> InlineResponse20033 getDependentsForTask(taskGid, optPretty, optFields, limit, offset)

Get dependents from a task

Returns the compact representations of all of the dependents of a task.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20033 result = apiInstance.getDependentsForTask(taskGid, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getDependentsForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20033**](InlineResponse20033.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSubtasksForTask"></a>
# **getSubtasksForTask**
> InlineResponse20033 getSubtasksForTask(taskGid, optPretty, optFields, limit, offset)

Get subtasks from a task

Returns a compact representation of all of the subtasks of a task.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20033 result = apiInstance.getSubtasksForTask(taskGid, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getSubtasksForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20033**](InlineResponse20033.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTask"></a>
# **getTask**
> InlineResponse2016 getTask(taskGid, optPretty, optFields)

Get a task

Returns the complete task record for a single task.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2016 result = apiInstance.getTask(taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2016**](InlineResponse2016.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTasks"></a>
# **getTasks**
> InlineResponse20033 getTasks(optPretty, optFields, limit, offset, assignee, project, section, workspace, completedSince, modifiedSince)

Get multiple tasks

Returns the compact task records for some filtered set of tasks. Use one or more of the parameters provided to filter the tasks returned. You must specify a &#x60;project&#x60; or &#x60;tag&#x60; if you do not specify &#x60;assignee&#x60; and &#x60;workspace&#x60;.  For more complex task retrieval, use [workspaces/{workspace_gid}/tasks/search](/docs/search-tasks-in-a-workspace).

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
String assignee = "assignee_example"; // String | The assignee to filter tasks on. If searching for unassigned tasks, assignee.any = null can be specified. *Note: If you specify `assignee`, you must also specify the `workspace` to filter on.*
String project = "project_example"; // String | The project to filter tasks on.
String section = "section_example"; // String | The section to filter tasks on. *Note: Currently, this is only supported in board views.*
String workspace = "workspace_example"; // String | The workspace to filter tasks on. *Note: If you specify `workspace`, you must also specify the `assignee` to filter on.*
OffsetDateTime completedSince = new OffsetDateTime(); // OffsetDateTime | Only return tasks that are either incomplete or that have been completed since this time.
OffsetDateTime modifiedSince = new OffsetDateTime(); // OffsetDateTime | Only return tasks that have been modified since the given time.  *Note: A task is considered “modified” if any of its properties change, or associations between it and other objects are modified (e.g.  a task being added to a project). A task is not considered modified just because another object it is associated with (e.g. a subtask) is modified. Actions that count as modifying the task include assigning, renaming, completing, and adding stories.*
try {
    InlineResponse20033 result = apiInstance.getTasks(optPretty, optFields, limit, offset, assignee, project, section, workspace, completedSince, modifiedSince);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getTasks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]
 **assignee** | **String**| The assignee to filter tasks on. If searching for unassigned tasks, assignee.any &#x3D; null can be specified. *Note: If you specify &#x60;assignee&#x60;, you must also specify the &#x60;workspace&#x60; to filter on.* | [optional]
 **project** | **String**| The project to filter tasks on. | [optional]
 **section** | **String**| The section to filter tasks on. *Note: Currently, this is only supported in board views.* | [optional]
 **workspace** | **String**| The workspace to filter tasks on. *Note: If you specify &#x60;workspace&#x60;, you must also specify the &#x60;assignee&#x60; to filter on.* | [optional]
 **completedSince** | **OffsetDateTime**| Only return tasks that are either incomplete or that have been completed since this time. | [optional]
 **modifiedSince** | **OffsetDateTime**| Only return tasks that have been modified since the given time.  *Note: A task is considered “modified” if any of its properties change, or associations between it and other objects are modified (e.g.  a task being added to a project). A task is not considered modified just because another object it is associated with (e.g. a subtask) is modified. Actions that count as modifying the task include assigning, renaming, completing, and adding stories.* | [optional]

### Return type

[**InlineResponse20033**](InlineResponse20033.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTasksForProject"></a>
# **getTasksForProject**
> InlineResponse20033 getTasksForProject(projectGid, completedSince, optPretty, optFields, limit, offset)

Get tasks from a project

Returns the compact task records for all tasks within the given project, ordered by their priority within the project. Tasks can exist in more than one project at a time.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
String projectGid = "projectGid_example"; // String | Globally unique identifier for the project.
String completedSince = "completedSince_example"; // String | Only return tasks that are either incomplete or that have been completed since this time. Accepts a date-time string or the keyword *now*. 
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20033 result = apiInstance.getTasksForProject(projectGid, completedSince, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getTasksForProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectGid** | **String**| Globally unique identifier for the project. |
 **completedSince** | **String**| Only return tasks that are either incomplete or that have been completed since this time. Accepts a date-time string or the keyword *now*.  | [optional]
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20033**](InlineResponse20033.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTasksForSection"></a>
# **getTasksForSection**
> InlineResponse20033 getTasksForSection(sectionGid, optPretty, optFields, limit, offset)

Get tasks from a section

*Board view only*: Returns the compact section records for all tasks within the given section.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
String sectionGid = "sectionGid_example"; // String | The globally unique identifier for the section.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20033 result = apiInstance.getTasksForSection(sectionGid, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getTasksForSection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sectionGid** | **String**| The globally unique identifier for the section. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20033**](InlineResponse20033.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTasksForTag"></a>
# **getTasksForTag**
> InlineResponse20033 getTasksForTag(tagGid, optPretty, optFields, limit, offset)

Get tasks from a tag

Returns the compact task records for all tasks with the given tag. Tasks can have more than one tag at a time.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
String tagGid = "tagGid_example"; // String | Globally unique identifier for the tag.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20033 result = apiInstance.getTasksForTag(tagGid, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getTasksForTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tagGid** | **String**| Globally unique identifier for the tag. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20033**](InlineResponse20033.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTasksForUserTaskList"></a>
# **getTasksForUserTaskList**
> InlineResponse20033 getTasksForUserTaskList(userTaskListGid, completedSince, optPretty, optFields, limit, offset)

Get tasks from a user task list

Returns the compact list of tasks in a user’s My Tasks list. *Note: Access control is enforced for this endpoint as with all Asana API endpoints, meaning a user’s private tasks will be filtered out if the API-authenticated user does not have access to them.* *Note: Both complete and incomplete tasks are returned by default unless they are filtered out (for example, setting &#x60;completed_since&#x3D;now&#x60; will return only incomplete tasks, which is the default view for “My Tasks” in Asana.)*

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
String userTaskListGid = "userTaskListGid_example"; // String | Globally unique identifier for the user task list.
String completedSince = "completedSince_example"; // String | Only return tasks that are either incomplete or that have been completed since this time. Accepts a date-time string or the keyword *now*. 
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
Integer limit = 56; // Integer | Results per page. The number of objects to return per page. The value must be between 1 and 100.
String offset = "offset_example"; // String | Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. 'Note: You can only pass in an offset that was returned to you via a previously paginated request.'
try {
    InlineResponse20033 result = apiInstance.getTasksForUserTaskList(userTaskListGid, completedSince, optPretty, optFields, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getTasksForUserTaskList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userTaskListGid** | **String**| Globally unique identifier for the user task list. |
 **completedSince** | **String**| Only return tasks that are either incomplete or that have been completed since this time. Accepts a date-time string or the keyword *now*.  | [optional]
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **limit** | **Integer**| Results per page. The number of objects to return per page. The value must be between 1 and 100. | [optional]
 **offset** | **String**| Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; | [optional]

### Return type

[**InlineResponse20033**](InlineResponse20033.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeDependenciesForTask"></a>
# **removeDependenciesForTask**
> InlineResponse2001 removeDependenciesForTask(body, taskGid, optPretty, optFields)

Unlink dependencies from a task

Unlinks a set of dependencies from this task.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidRemoveDependenciesBody body = new TaskGidRemoveDependenciesBody(); // TaskGidRemoveDependenciesBody | The list of tasks to unlink as dependencies.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.removeDependenciesForTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#removeDependenciesForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidRemoveDependenciesBody**](TaskGidRemoveDependenciesBody.md)| The list of tasks to unlink as dependencies. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeDependentsForTask"></a>
# **removeDependentsForTask**
> InlineResponse2001 removeDependentsForTask(body, taskGid, optPretty, optFields)

Unlink dependents from a task

Unlinks a set of dependents from this task.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidRemoveDependentsBody body = new TaskGidRemoveDependentsBody(); // TaskGidRemoveDependentsBody | The list of tasks to remove as dependents.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.removeDependentsForTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#removeDependentsForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidRemoveDependentsBody**](TaskGidRemoveDependentsBody.md)| The list of tasks to remove as dependents. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeFollowerForTask"></a>
# **removeFollowerForTask**
> InlineResponse2016 removeFollowerForTask(body, taskGid, optPretty, optFields)

Remove followers from a task

Removes each of the specified followers from the task if they are following. Returns the complete, updated record for the affected task.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidRemoveFollowersBody body = new TaskGidRemoveFollowersBody(); // TaskGidRemoveFollowersBody | The followers to remove from the task.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2016 result = apiInstance.removeFollowerForTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#removeFollowerForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidRemoveFollowersBody**](TaskGidRemoveFollowersBody.md)| The followers to remove from the task. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2016**](InlineResponse2016.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeProjectForTask"></a>
# **removeProjectForTask**
> InlineResponse2001 removeProjectForTask(body, taskGid, optPretty, optFields)

Remove a project from a task

Removes the task from the specified project. The task will still exist in the system, but it will not be in the project anymore.  Returns an empty data block.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidRemoveProjectBody body = new TaskGidRemoveProjectBody(); // TaskGidRemoveProjectBody | The project to remove the task from.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.removeProjectForTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#removeProjectForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidRemoveProjectBody**](TaskGidRemoveProjectBody.md)| The project to remove the task from. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeTagForTask"></a>
# **removeTagForTask**
> InlineResponse2001 removeTagForTask(body, taskGid, optPretty, optFields)

Remove a tag from a task

Removes a tag from a task. Returns an empty data block.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidRemoveTagBody body = new TaskGidRemoveTagBody(); // TaskGidRemoveTagBody | The tag to remove from the task.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2001 result = apiInstance.removeTagForTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#removeTagForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidRemoveTagBody**](TaskGidRemoveTagBody.md)| The tag to remove from the task. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchTasksForWorkspace"></a>
# **searchTasksForWorkspace**
> InlineResponse20033 searchTasksForWorkspace(workspaceGid, optPretty, optFields, text, resourceSubtype, assigneeAny, assigneeNot, portfoliosAny, projectsAny, projectsNot, projectsAll, sectionsAny, sectionsNot, sectionsAll, tagsAny, tagsNot, tagsAll, teamsAny, followersNot, createdByAny, createdByNot, assignedByAny, assignedByNot, likedByNot, commentedOnByNot, dueOnBefore, dueOnAfter, dueOn, dueAtBefore, dueAtAfter, startOnBefore, startOnAfter, startOn, createdOnBefore, createdOnAfter, createdOn, createdAtBefore, createdAtAfter, completedOnBefore, completedOnAfter, completedOn, completedAtBefore, completedAtAfter, modifiedOnBefore, modifiedOnAfter, modifiedOn, modifiedAtBefore, modifiedAtAfter, isBlocking, isBlocked, hasAttachment, completed, isSubtask, sortBy, sortAscending)

Search tasks in a workspace

To mirror the functionality of the Asana web app&#x27;s advanced search feature, the Asana API has a task search endpoint that allows you to build complex filters to find and retrieve the exact data you need. #### Premium access Like the Asana web product&#x27;s advance search feature, this search endpoint will only be available to premium Asana users. A user is premium if any of the following is true:  - The workspace in which the search is being performed is a premium workspace - The user is a member of a premium team inside the workspace  Even if a user is only a member of a premium team inside a non-premium workspace, search will allow them to find data anywhere in the workspace, not just inside the premium team. Making a search request using credentials of a non-premium user will result in a &#x60;402 Payment Required&#x60; error. #### Pagination Search results are not stable; repeating the same query multiple times may return the data in a different order, even if the data do not change. Because of this, the traditional [pagination](https://developers.asana.com/docs/#pagination) available elsewhere in the Asana API is not available here. However, you can paginate manually by sorting the search results by their creation time and then modifying each subsequent query to exclude data you have already seen. Page sizes are limited to a maximum of 100 items, and can be specified by the &#x60;limit&#x60; query parameter. #### Eventual consistency Changes in Asana (regardless of whether they’re made though the web product or the API) are forwarded to our search infrastructure to be indexed. This process can take between 10 and 60 seconds to complete under normal operation, and longer during some production incidents. Making a change to a task that would alter its presence in a particular search query will not be reflected immediately. This is also true of the advanced search feature in the web product. #### Rate limits You may receive a &#x60;429 Too Many Requests&#x60; response if you hit any of our [rate limits](https://developers.asana.com/docs/#rate-limits). #### Custom field parameters | Parameter name | Custom field type | Accepted type | |---|---|---| | custom_fields.{gid}.is_set | All | Boolean | | custom_fields.{gid}.value | Text | String | | custom_fields.{gid}.value | Number | Number | | custom_fields.{gid}.value | Enum | Enum option ID | | custom_fields.{gid}.starts_with | Text only | String | | custom_fields.{gid}.ends_with | Text only | String | | custom_fields.{gid}.contains | Text only | String | | custom_fields.{gid}.less_than | Number only | Number | | custom_fields.{gid}.greater_than | Number only | Number |   For example, if the gid of the custom field is 12345, these query parameter to find tasks where it is set would be &#x60;custom_fields.12345.is_set&#x3D;true&#x60;. To match an exact value for an enum custom field, use the gid of the desired enum option and not the name of the enum option: &#x60;custom_fields.12345.value&#x3D;67890&#x60;.  Searching for multiple exact matches of a custom field is not supported.  *Note: If you specify &#x60;projects.any&#x60; and &#x60;sections.any&#x60;, you will receive tasks for the project **and** tasks for the section. If you&#x27;re looking for only tasks in a section, omit the &#x60;projects.any&#x60; from the request.*

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
String workspaceGid = "workspaceGid_example"; // String | Globally unique identifier for the workspace or organization.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
String text = "text_example"; // String | Performs full-text search on both task name and description
String resourceSubtype = "milestone"; // String | Filters results by the task's resource_subtype
String assigneeAny = "assigneeAny_example"; // String | Comma-separated list of user identifiers
String assigneeNot = "assigneeNot_example"; // String | Comma-separated list of user identifiers
String portfoliosAny = "portfoliosAny_example"; // String | Comma-separated list of portfolio IDs
String projectsAny = "projectsAny_example"; // String | Comma-separated list of project IDs
String projectsNot = "projectsNot_example"; // String | Comma-separated list of project IDs
String projectsAll = "projectsAll_example"; // String | Comma-separated list of project IDs
String sectionsAny = "sectionsAny_example"; // String | Comma-separated list of section or column IDs
String sectionsNot = "sectionsNot_example"; // String | Comma-separated list of section or column IDs
String sectionsAll = "sectionsAll_example"; // String | Comma-separated list of section or column IDs
String tagsAny = "tagsAny_example"; // String | Comma-separated list of tag IDs
String tagsNot = "tagsNot_example"; // String | Comma-separated list of tag IDs
String tagsAll = "tagsAll_example"; // String | Comma-separated list of tag IDs
String teamsAny = "teamsAny_example"; // String | Comma-separated list of team IDs
String followersNot = "followersNot_example"; // String | Comma-separated list of user identifiers
String createdByAny = "createdByAny_example"; // String | Comma-separated list of user identifiers
String createdByNot = "createdByNot_example"; // String | Comma-separated list of user identifiers
String assignedByAny = "assignedByAny_example"; // String | Comma-separated list of user identifiers
String assignedByNot = "assignedByNot_example"; // String | Comma-separated list of user identifiers
String likedByNot = "likedByNot_example"; // String | Comma-separated list of user identifiers
String commentedOnByNot = "commentedOnByNot_example"; // String | Comma-separated list of user identifiers
LocalDate dueOnBefore = new LocalDate(); // LocalDate | ISO 8601 date string
LocalDate dueOnAfter = new LocalDate(); // LocalDate | ISO 8601 date string
LocalDate dueOn = new LocalDate(); // LocalDate | ISO 8601 date string or `null`
OffsetDateTime dueAtBefore = new OffsetDateTime(); // OffsetDateTime | ISO 8601 datetime string
OffsetDateTime dueAtAfter = new OffsetDateTime(); // OffsetDateTime | ISO 8601 datetime string
LocalDate startOnBefore = new LocalDate(); // LocalDate | ISO 8601 date string
LocalDate startOnAfter = new LocalDate(); // LocalDate | ISO 8601 date string
LocalDate startOn = new LocalDate(); // LocalDate | ISO 8601 date string or `null`
LocalDate createdOnBefore = new LocalDate(); // LocalDate | ISO 8601 date string
LocalDate createdOnAfter = new LocalDate(); // LocalDate | ISO 8601 date string
LocalDate createdOn = new LocalDate(); // LocalDate | ISO 8601 date string or `null`
OffsetDateTime createdAtBefore = new OffsetDateTime(); // OffsetDateTime | ISO 8601 datetime string
OffsetDateTime createdAtAfter = new OffsetDateTime(); // OffsetDateTime | ISO 8601 datetime string
LocalDate completedOnBefore = new LocalDate(); // LocalDate | ISO 8601 date string
LocalDate completedOnAfter = new LocalDate(); // LocalDate | ISO 8601 date string
LocalDate completedOn = new LocalDate(); // LocalDate | ISO 8601 date string or `null`
OffsetDateTime completedAtBefore = new OffsetDateTime(); // OffsetDateTime | ISO 8601 datetime string
OffsetDateTime completedAtAfter = new OffsetDateTime(); // OffsetDateTime | ISO 8601 datetime string
LocalDate modifiedOnBefore = new LocalDate(); // LocalDate | ISO 8601 date string
LocalDate modifiedOnAfter = new LocalDate(); // LocalDate | ISO 8601 date string
LocalDate modifiedOn = new LocalDate(); // LocalDate | ISO 8601 date string or `null`
OffsetDateTime modifiedAtBefore = new OffsetDateTime(); // OffsetDateTime | ISO 8601 datetime string
OffsetDateTime modifiedAtAfter = new OffsetDateTime(); // OffsetDateTime | ISO 8601 datetime string
Boolean isBlocking = true; // Boolean | Filter to incomplete tasks with dependents
Boolean isBlocked = true; // Boolean | Filter to tasks with incomplete dependencies
Boolean hasAttachment = true; // Boolean | Filter to tasks with attachments
Boolean completed = true; // Boolean | Filter to completed tasks
Boolean isSubtask = true; // Boolean | Filter to subtasks
String sortBy = "modified_at"; // String | One of `due_date`, `created_at`, `completed_at`, `likes`, or `modified_at`, defaults to `modified_at`
Boolean sortAscending = false; // Boolean | Default `false`
try {
    InlineResponse20033 result = apiInstance.searchTasksForWorkspace(workspaceGid, optPretty, optFields, text, resourceSubtype, assigneeAny, assigneeNot, portfoliosAny, projectsAny, projectsNot, projectsAll, sectionsAny, sectionsNot, sectionsAll, tagsAny, tagsNot, tagsAll, teamsAny, followersNot, createdByAny, createdByNot, assignedByAny, assignedByNot, likedByNot, commentedOnByNot, dueOnBefore, dueOnAfter, dueOn, dueAtBefore, dueAtAfter, startOnBefore, startOnAfter, startOn, createdOnBefore, createdOnAfter, createdOn, createdAtBefore, createdAtAfter, completedOnBefore, completedOnAfter, completedOn, completedAtBefore, completedAtAfter, modifiedOnBefore, modifiedOnAfter, modifiedOn, modifiedAtBefore, modifiedAtAfter, isBlocking, isBlocked, hasAttachment, completed, isSubtask, sortBy, sortAscending);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#searchTasksForWorkspace");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workspaceGid** | **String**| Globally unique identifier for the workspace or organization. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]
 **text** | **String**| Performs full-text search on both task name and description | [optional]
 **resourceSubtype** | **String**| Filters results by the task&#x27;s resource_subtype | [optional] [default to milestone] [enum: default_task, milestone]
 **assigneeAny** | **String**| Comma-separated list of user identifiers | [optional]
 **assigneeNot** | **String**| Comma-separated list of user identifiers | [optional]
 **portfoliosAny** | **String**| Comma-separated list of portfolio IDs | [optional]
 **projectsAny** | **String**| Comma-separated list of project IDs | [optional]
 **projectsNot** | **String**| Comma-separated list of project IDs | [optional]
 **projectsAll** | **String**| Comma-separated list of project IDs | [optional]
 **sectionsAny** | **String**| Comma-separated list of section or column IDs | [optional]
 **sectionsNot** | **String**| Comma-separated list of section or column IDs | [optional]
 **sectionsAll** | **String**| Comma-separated list of section or column IDs | [optional]
 **tagsAny** | **String**| Comma-separated list of tag IDs | [optional]
 **tagsNot** | **String**| Comma-separated list of tag IDs | [optional]
 **tagsAll** | **String**| Comma-separated list of tag IDs | [optional]
 **teamsAny** | **String**| Comma-separated list of team IDs | [optional]
 **followersNot** | **String**| Comma-separated list of user identifiers | [optional]
 **createdByAny** | **String**| Comma-separated list of user identifiers | [optional]
 **createdByNot** | **String**| Comma-separated list of user identifiers | [optional]
 **assignedByAny** | **String**| Comma-separated list of user identifiers | [optional]
 **assignedByNot** | **String**| Comma-separated list of user identifiers | [optional]
 **likedByNot** | **String**| Comma-separated list of user identifiers | [optional]
 **commentedOnByNot** | **String**| Comma-separated list of user identifiers | [optional]
 **dueOnBefore** | **LocalDate**| ISO 8601 date string | [optional]
 **dueOnAfter** | **LocalDate**| ISO 8601 date string | [optional]
 **dueOn** | **LocalDate**| ISO 8601 date string or &#x60;null&#x60; | [optional]
 **dueAtBefore** | **OffsetDateTime**| ISO 8601 datetime string | [optional]
 **dueAtAfter** | **OffsetDateTime**| ISO 8601 datetime string | [optional]
 **startOnBefore** | **LocalDate**| ISO 8601 date string | [optional]
 **startOnAfter** | **LocalDate**| ISO 8601 date string | [optional]
 **startOn** | **LocalDate**| ISO 8601 date string or &#x60;null&#x60; | [optional]
 **createdOnBefore** | **LocalDate**| ISO 8601 date string | [optional]
 **createdOnAfter** | **LocalDate**| ISO 8601 date string | [optional]
 **createdOn** | **LocalDate**| ISO 8601 date string or &#x60;null&#x60; | [optional]
 **createdAtBefore** | **OffsetDateTime**| ISO 8601 datetime string | [optional]
 **createdAtAfter** | **OffsetDateTime**| ISO 8601 datetime string | [optional]
 **completedOnBefore** | **LocalDate**| ISO 8601 date string | [optional]
 **completedOnAfter** | **LocalDate**| ISO 8601 date string | [optional]
 **completedOn** | **LocalDate**| ISO 8601 date string or &#x60;null&#x60; | [optional]
 **completedAtBefore** | **OffsetDateTime**| ISO 8601 datetime string | [optional]
 **completedAtAfter** | **OffsetDateTime**| ISO 8601 datetime string | [optional]
 **modifiedOnBefore** | **LocalDate**| ISO 8601 date string | [optional]
 **modifiedOnAfter** | **LocalDate**| ISO 8601 date string | [optional]
 **modifiedOn** | **LocalDate**| ISO 8601 date string or &#x60;null&#x60; | [optional]
 **modifiedAtBefore** | **OffsetDateTime**| ISO 8601 datetime string | [optional]
 **modifiedAtAfter** | **OffsetDateTime**| ISO 8601 datetime string | [optional]
 **isBlocking** | **Boolean**| Filter to incomplete tasks with dependents | [optional]
 **isBlocked** | **Boolean**| Filter to tasks with incomplete dependencies | [optional]
 **hasAttachment** | **Boolean**| Filter to tasks with attachments | [optional]
 **completed** | **Boolean**| Filter to completed tasks | [optional]
 **isSubtask** | **Boolean**| Filter to subtasks | [optional]
 **sortBy** | **String**| One of &#x60;due_date&#x60;, &#x60;created_at&#x60;, &#x60;completed_at&#x60;, &#x60;likes&#x60;, or &#x60;modified_at&#x60;, defaults to &#x60;modified_at&#x60; | [optional] [default to modified_at] [enum: due_date, created_at, completed_at, likes, modified_at]
 **sortAscending** | **Boolean**| Default &#x60;false&#x60; | [optional] [default to false]

### Return type

[**InlineResponse20033**](InlineResponse20033.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="setParentForTask"></a>
# **setParentForTask**
> InlineResponse2016 setParentForTask(body, taskGid, optPretty, optFields)

Set the parent of a task

parent, or no parent task at all. Returns an empty data block. When using &#x60;insert_before&#x60; and &#x60;insert_after&#x60;, at most one of those two options can be specified, and they must already be subtasks of the parent.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TaskGidSetParentBody body = new TaskGidSetParentBody(); // TaskGidSetParentBody | The new parent of the subtask.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2016 result = apiInstance.setParentForTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#setParentForTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TaskGidSetParentBody**](TaskGidSetParentBody.md)| The new parent of the subtask. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2016**](InlineResponse2016.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateTask"></a>
# **updateTask**
> InlineResponse2016 updateTask(body, taskGid, optPretty, optFields)

Update a task

A specific, existing task can be updated by making a PUT request on the URL for that task. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged.  When using this method, it is best to specify only those fields you wish to change, or else you may overwrite changes made by another user since you last retrieved the task.  Returns the complete updated task record.

### Example
```java
// Import classes:
//import com.asana.ApiClient;
//import com.asana.ApiException;
//import com.asana.Configuration;
//import com.asana.auth.*;
//import com.asana.resources.gen.TasksApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");


TasksApi apiInstance = new TasksApi();
TasksTaskGidBody body = new TasksTaskGidBody(); // TasksTaskGidBody | The task to update.
String taskGid = "taskGid_example"; // String | The task to operate on.
Boolean optPretty = true; // Boolean | Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging.
List<String> optFields = Arrays.asList("optFields_example"); // List<String> | Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options.
try {
    InlineResponse2016 result = apiInstance.updateTask(body, taskGid, optPretty, optFields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#updateTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TasksTaskGidBody**](TasksTaskGidBody.md)| The task to update. |
 **taskGid** | **String**| The task to operate on. |
 **optPretty** | **Boolean**| Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. | [optional]
 **optFields** | [**List&lt;String&gt;**](String.md)| Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. | [optional]

### Return type

[**InlineResponse2016**](InlineResponse2016.md)

### Authorization

[oauth2](../README.md#oauth2)[personalAccessToken](../README.md#personalAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


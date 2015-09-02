package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.models.Task;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

/**
 * The _task_ is the basic object around which many operations in Asana are
 * centered. In the Asana application, multiple tasks populate the middle pane
 * according to some view parameters, and the set of selected tasks determines
 * the more detailed information presented in the details pane.
 */
public class TasksBase extends Resource {
    /**
     * @param client Parent client instance
     */
    public TasksBase(Client client) {
        super(client);
    }

    /**
     * Creating a new task is as easy as POSTing to the `/tasks` endpoint
     * with a data block containing the fields you'd like to set on the task.
     * Any unspecified fields will take on default values.
     * 
     * Every task is required to be created in a specific workspace, and this
     * workspace cannot be changed once set. The workspace need not be set
     * explicitly if you specify a `project` or a `parent` task instead.
     *
     * @return Request object
     */
    public ItemRequest<Task> create() {
    
        return new ItemRequest<Task>(this, Task.class, "/tasks", "POST");
    }

    /**
     * Creating a new task is as easy as POSTing to the `/tasks` endpoint
     * with a data block containing the fields you'd like to set on the task.
     * Any unspecified fields will take on default values.
     * 
     * Every task is required to be created in a specific workspace, and this
     * workspace cannot be changed once set. The workspace need not be set
     * explicitly if you specify a `project` or a `parent` task instead.
     *
     * @param  workspace The workspace to create a task in.
     * @return Request object
     */
    public ItemRequest<Task> createInWorkspace(String workspace) {
    
        String path = String.format("/workspaces/%s/tasks", workspace);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    /**
     * Returns the complete task record for a single task.
     *
     * @param  task The task to get.
     * @return Request object
     */
    public ItemRequest<Task> findById(String task) {
    
        String path = String.format("/tasks/%s", task);
        return new ItemRequest<Task>(this, Task.class, path, "GET");
    }

    /**
     * A specific, existing task can be updated by making a PUT request on the
     * URL for that task. Only the fields provided in the `data` block will be
     * updated; any unspecified fields will remain unchanged.
     * 
     * When using this method, it is best to specify only those fields you wish
     * to change, or else you may overwrite changes made by another user since
     * you last retrieved the task.
     * 
     * Returns the complete updated task record.
     *
     * @param  task The task to update.
     * @return Request object
     */
    public ItemRequest<Task> update(String task) {
    
        String path = String.format("/tasks/%s", task);
        return new ItemRequest<Task>(this, Task.class, path, "PUT");
    }

    /**
     * A specific, existing task can be deleted by making a DELETE request on the
     * URL for that task. Deleted tasks go into the "trash" of the user making
     * the delete request. Tasks can be recovered from the trash within a period
     * of 30 days; afterward they are completely removed from the system.
     * 
     * Returns an empty data record.
     *
     * @param  task The task to delete.
     * @return Request object
     */
    public ItemRequest<Task> delete(String task) {
    
        String path = String.format("/tasks/%s", task);
        return new ItemRequest<Task>(this, Task.class, path, "DELETE");
    }

    /**
     * Returns the compact task records for all tasks within the given project,
     * ordered by their priority within the project.
     *
     * @param  projectId The project in which to search for tasks.
     * @return Request object
     */
    public CollectionRequest<Task> findByProject(String projectId) {
    
        String path = String.format("/projects/%s/tasks", projectId);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    /**
     * Returns the compact task records for all tasks with the given tag.
     *
     * @param  tag The tag in which to search for tasks.
     * @return Request object
     */
    public CollectionRequest<Task> findByTag(String tag) {
    
        String path = String.format("/tags/%s/tasks", tag);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    /**
     * Returns the compact task records for some filtered set of tasks. Use one
     * or more of the parameters provided to filter the tasks returned.
     *
     * @return Request object
     */
    public CollectionRequest<Task> findAll() {
    
        return new CollectionRequest<Task>(this, Task.class, "/tasks", "GET");
    }

    /**
     * Adds each of the specified followers to the task, if they are not already
     * following. Returns the complete, updated record for the affected task.
     *
     * @param  task The task to add followers to.
     * @return Request object
     */
    public ItemRequest<Task> addFollowers(String task) {
    
        String path = String.format("/tasks/%s/addFollowers", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    /**
     * Removes each of the specified followers from the task if they are
     * following. Returns the complete, updated record for the affected task.
     *
     * @param  task The task to remove followers from.
     * @return Request object
     */
    public ItemRequest<Task> removeFollowers(String task) {
    
        String path = String.format("/tasks/%s/removeFollowers", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    /**
     * Returns a compact representation of all of the projects the task is in.
     *
     * @param  task The task to get projects on.
     * @return Request object
     */
    public CollectionRequest<Task> projects(String task) {
    
        String path = String.format("/tasks/%s/projects", task);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    /**
     * Adds the task to the specified project, in the optional location
     * specified. If no location arguments are given, the task will be added to
     * the beginning of the project.
     * 
     * `addProject` can also be used to reorder a task within a project that
     * already contains it.
     * 
     * Returns an empty data block.
     *
     * @param  task The task to add to a project.
     * @return Request object
     */
    public ItemRequest<Task> addProject(String task) {
    
        String path = String.format("/tasks/%s/addProject", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    /**
     * Removes the task from the specified project. The task will still exist
     * in the system, but it will not be in the project anymore.
     * 
     * Returns an empty data block.
     *
     * @param  task The task to remove from a project.
     * @return Request object
     */
    public ItemRequest<Task> removeProject(String task) {
    
        String path = String.format("/tasks/%s/removeProject", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    /**
     * Returns a compact representation of all of the tags the task has.
     *
     * @param  task The task to get tags on.
     * @return Request object
     */
    public CollectionRequest<Task> tags(String task) {
    
        String path = String.format("/tasks/%s/tags", task);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    /**
     * Adds a tag to a task. Returns an empty data block.
     *
     * @param  task The task to add a tag to.
     * @return Request object
     */
    public ItemRequest<Task> addTag(String task) {
    
        String path = String.format("/tasks/%s/addTag", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    /**
     * Removes a tag from the task. Returns an empty data block.
     *
     * @param  task The task to remove a tag from.
     * @return Request object
     */
    public ItemRequest<Task> removeTag(String task) {
    
        String path = String.format("/tasks/%s/removeTag", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    /**
     * Returns a compact representation of all of the subtasks of a task.
     *
     * @param  task The task to get the subtasks of.
     * @return Request object
     */
    public CollectionRequest<Task> subtasks(String task) {
    
        String path = String.format("/tasks/%s/subtasks", task);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    /**
     * Creates a new subtask and adds it to the parent task. Returns the full record
     * for the newly created subtask.
     *
     * @param  task The task to add a subtask to.
     * @return Request object
     */
    public ItemRequest<Task> addSubtask(String task) {
    
        String path = String.format("/tasks/%s/subtasks", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    /**
     * Returns a compact representation of all of the stories on the task.
     *
     * @param  task The task containing the stories to get.
     * @return Request object
     */
    public CollectionRequest<Task> stories(String task) {
    
        String path = String.format("/tasks/%s/stories", task);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    /**
     * Adds a comment to a task. The comment will be authored by the
     * currently authenticated user, and timestamped when the server receives
     * the request.
     * 
     * Returns the full record for the new story added to the task.
     *
     * @param  task Globally unique identifier for the task.
     * @return Request object
     */
    public ItemRequest<Task> addComment(String task) {
    
        String path = String.format("/tasks/%s/stories", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }
}
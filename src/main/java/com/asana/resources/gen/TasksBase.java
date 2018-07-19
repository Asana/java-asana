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
     * explicitly if you specify `projects` or a `parent` task instead.
     * 
     * `projects` can be a comma separated list of projects, or just a single
     * project the task should belong to.
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
     * <b>Board view only:</b> Returns the compact section records for all tasks within the given section.
     *
     * @param  section The section in which to search for tasks.
     * @return Request object
     */
    public CollectionRequest<Task> findBySection(String section) {
    
        String path = String.format("/sections/%s/tasks", section);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    /**
     * Returns the compact task records for some filtered set of tasks. Use one
     * or more of the parameters provided to filter the tasks returned. You must
     * specify a `project` or `tag` if you do not specify `assignee` and `workspace`.
     *
     * @return Request object
     */
    public CollectionRequest<Task> findAll() {
    
        return new CollectionRequest<Task>(this, Task.class, "/tasks", "GET");
    }

    /**
     * The search endpoint allows you to build complex queries to find and fetch exactly the data you need from Asana. For a more comprehensive description of all the query parameters and limitations of this endpoint, see our [long-form documentation](/developers/documentation/getting-started/search-api) for this feature.
     *
     * @param  workspace The workspace or organization in which to search for tasks.
     * @return Request object
     */
    public CollectionRequest<Task> search(String workspace) {
    
        String path = String.format("/workspaces/%s/tasks/search", workspace);
        return new CollectionRequest<Task>(this, Task.class, path, "GET");
    }

    /**
     * Returns the compact representations of all of the dependencies of a task.
     *
     * @param  task The task to get dependencies on.
     * @return Request object
     */
    public ItemRequest<Task> dependencies(String task) {
    
        String path = String.format("/tasks/%s/dependencies", task);
        return new ItemRequest<Task>(this, Task.class, path, "GET");
    }

    /**
     * Returns the compact representations of all of the dependents of a task.
     *
     * @param  task The task to get dependents on.
     * @return Request object
     */
    public ItemRequest<Task> dependents(String task) {
    
        String path = String.format("/tasks/%s/dependents", task);
        return new ItemRequest<Task>(this, Task.class, path, "GET");
    }

    /**
     * Marks a set of tasks as dependencies of this task, if they are not
     * already dependencies. *A task can have at most 15 dependencies.*
     *
     * @param  task The task to add dependencies to.
     * @return Request object
     */
    public ItemRequest<Task> addDependencies(String task) {
    
        String path = String.format("/tasks/%s/addDependencies", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    /**
     * Marks a set of tasks as dependents of this task, if they are not already
     * dependents. *A task can have at most 30 dependents.*
     *
     * @param  task The task to add dependents to.
     * @return Request object
     */
    public ItemRequest<Task> addDependents(String task) {
    
        String path = String.format("/tasks/%s/addDependents", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    /**
     * Unlinks a set of dependencies from this task.
     *
     * @param  task The task to remove dependencies from.
     * @return Request object
     */
    public ItemRequest<Task> removeDependencies(String task) {
    
        String path = String.format("/tasks/%s/removeDependencies", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
    }

    /**
     * Unlinks a set of dependents from this task.
     *
     * @param  task The task to remove dependents from.
     * @return Request object
     */
    public ItemRequest<Task> removeDependents(String task) {
    
        String path = String.format("/tasks/%s/removeDependents", task);
        return new ItemRequest<Task>(this, Task.class, path, "POST");
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
     * the end of the project.
     * 
     * `addProject` can also be used to reorder a task within a project or section that
     * already contains it.
     * 
     * At most one of `insert_before`, `insert_after`, or `section` should be
     * specified. Inserting into a section in an non-order-dependent way can be
     * done by specifying `section`, otherwise, to insert within a section in a
     * particular place, specify `insert_before` or `insert_after` and a task
     * within the section to anchor the position of this task.
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

package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.models.Section;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;

/**
 * A _section_ is a subdivision of a project that groups tasks together. It can
 * either be a header above a list of tasks in a list view or a column in a
 * board view of a project.
 */
public class SectionsBase extends Resource {
    /**
     * @param client Parent client instance
     */
    public SectionsBase(Client client) {
        super(client);
    }

    /**
     * Creates a new section in a project.
     *
     * Returns the full record of the newly created section.
     *
     * @param  project The project to create the section in
     * @return Request object
     */
    public ItemRequest<Section> createInProject(String project) {

        String path = String.format("/projects/%s/sections", project);
        return new ItemRequest<Section>(this, Section.class, path, "POST");
    }

    /**
     * Returns the compact records for all sections in the specified project.
     *
     * @param  project The project to get sections from.
     * @return Request object
     */
    public CollectionRequest<Section> findByProject(String project) {

        String path = String.format("/projects/%s/sections", project);
        return new CollectionRequest<Section>(this, Section.class, path, "GET");
    }

    /**
     * Returns the complete record for a single section.
     *
     * @param  section The section to get.
     * @return Request object
     */
    public ItemRequest<Section> findById(String section) {

        String path = String.format("/sections/%s", section);
        return new ItemRequest<Section>(this, Section.class, path, "GET");
    }

    /**
     * A specific, existing section can be updated by making a PUT request on
     * the URL for that project. Only the fields provided in the `data` block
     * will be updated; any unspecified fields will remain unchanged. (note that
     * at this time, the only field that can be updated is the `name` field.)
     *
     * When using this method, it is best to specify only those fields you wish
     * to change, or else you may overwrite changes made by another user since
     * you last retrieved the task.
     *
     * Returns the complete updated section record.
     *
     * @param  section The section to update.
     * @return Request object
     */
    public ItemRequest<Section> update(String section) {

        String path = String.format("/sections/%s", section);
        return new ItemRequest<Section>(this, Section.class, path, "PUT");
    }

    /**
     * A specific, existing section can be deleted by making a DELETE request
     * on the URL for that section.
     *
     * Note that sections must be empty to be deleted.
     *
     * The last remaining section in a board view cannot be deleted.
     *
     * Returns an empty data block.
     *
     * @param  section The section to delete.
     * @return Request object
     */
    public ItemRequest<Section> delete(String section) {

        String path = String.format("/sections/%s", section);
        return new ItemRequest<Section>(this, Section.class, path, "DELETE");
    }

    /**
     * Add a task to a specific, existing section. This will remove the task from other sections of the project.
     *
     * The task will be inserted at the top of a section unless an `insert_before` or `insert_after` parameter is declared.
     *
     * This does not work for separators (tasks with the `resource_subtype` of section).
     *
     * @param  task The task to add to this section
     * @return Request object
     */
    public ItemRequest<Section> addTask(String task) {

        String path = String.format("/sections/%s/addTask", task);
        return new ItemRequest<Section>(this, Section.class, path, "POST");
    }

    /**
     * Move sections relative to each other in a board view. One of
     * `before_section` or `after_section` is required.
     *
     * Sections cannot be moved between projects.
     *
     * At this point in time, moving sections is not supported in list views, only board views.
     *
     * Returns an empty data block.
     *
     * @param  project The project in which to reorder the given section
     * @return Request object
     */
    public ItemRequest<Section> insertInProject(String project) {

        String path = String.format("/projects/%s/sections/insert", project);
        return new ItemRequest<Section>(this, Section.class, path, "POST");
    }
}

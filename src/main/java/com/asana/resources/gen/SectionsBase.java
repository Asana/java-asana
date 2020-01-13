package com.asana.resources.gen;

import com.asana.Client;
import com.asana.resources.Resource;
import com.asana.requests.ItemRequest;
import com.asana.requests.CollectionRequest;
import com.asana.models.gen.EmptyObject;
import com.asana.models.gen.ErrorResponse;
import com.asana.models.gen.ProjectSectionInsertRequest;
import com.asana.models.gen.SectionCompact;
import com.asana.models.gen.SectionRequest;
import com.asana.models.gen.SectionResponse;
import com.asana.models.gen.SectionTaskInsertRequest;
import java.io.IOException;
import java.util.List;

public class SectionsBase extends Resource {
    /**
    * @param client Parent client instance
    */
    public SectionsBase(Client client) { super(client); }

    /**
     * Add task to section
     * Add a task to a specific, existing section. This will remove the task from other sections of the project.  The task will be inserted at the top of a section unless an insert_before or insert_after parameter is declared.  This does not work for separators (tasks with the resource_subtype of section).
     * @param sectionGid The globally unique identifier for the section. (required)
     * @param body The task and optionally the insert location. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EmptyObject>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EmptyObject> addTaskForSection(String sectionGid, SectionTaskInsertRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/sections/{section_gid}/addTask".replace("{section_gid}", sectionGid);

        ItemRequest<EmptyObject> req = new ItemRequest<EmptyObject>(this, EmptyObject.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<EmptyObject> addTaskForSection(String sectionGid, SectionTaskInsertRequest body) throws IOException {
        return addTaskForSection(sectionGid, body, null, false);
    }

    /**
     * Create a section in a project
     * Creates a new section in a project. Returns the full record of the newly created section.
     * @param projectGid Globally unique identifier for the project. (required)
     * @param body The section to create. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<SectionResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<SectionResponse> createSectionForProject(String projectGid, SectionRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/projects/{project_gid}/sections".replace("{project_gid}", projectGid);

        ItemRequest<SectionResponse> req = new ItemRequest<SectionResponse>(this, SectionResponse.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<SectionResponse> createSectionForProject(String projectGid, SectionRequest body) throws IOException {
        return createSectionForProject(projectGid, body, null, false);
    }

    /**
     * Delete a section
     * A specific, existing section can be deleted by making a DELETE request on the URL for that section.  Note that sections must be empty to be deleted.  The last remaining section in a board view cannot be deleted.  Returns an empty data block.
     * @param sectionGid The globally unique identifier for the section. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EmptyObject>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EmptyObject> deleteSection(String sectionGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/sections/{section_gid}".replace("{section_gid}", sectionGid);

        ItemRequest<EmptyObject> req = new ItemRequest<EmptyObject>(this, EmptyObject.class, path, "DELETE")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<EmptyObject> deleteSection(String sectionGid) throws IOException {
        return deleteSection(sectionGid, null, false);
    }

    /**
     * Get a section
     * Returns the complete record for a single section.
     * @param sectionGid The globally unique identifier for the section. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<SectionResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<SectionResponse> getSection(String sectionGid, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/sections/{section_gid}".replace("{section_gid}", sectionGid);

        ItemRequest<SectionResponse> req = new ItemRequest<SectionResponse>(this, SectionResponse.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        return req;
    }

    public ItemRequest<SectionResponse> getSection(String sectionGid) throws IOException {
        return getSection(sectionGid, null, false);
    }

    /**
     * Get sections in a project
     * Returns the compact records for all sections in the specified project.
     * @param projectGid Globally unique identifier for the project. (required)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return CollectionRequest<SectionCompact>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CollectionRequest<SectionCompact> getSectionsForProject(String projectGid, String offset, Integer limit, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/projects/{project_gid}/sections".replace("{project_gid}", projectGid);

        CollectionRequest<SectionCompact> req = new CollectionRequest<SectionCompact>(this, SectionCompact.class, path, "GET")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields)
            .query("limit", limit)
            .query("offset", offset);

        return req;
    }

    public CollectionRequest<SectionCompact> getSectionsForProject(String projectGid) throws IOException {
        return getSectionsForProject(projectGid, null, (int)Client.DEFAULTS.get("page_size"), null, false);
    }

    /**
     * Move or Insert sections
     * Move sections relative to each other in a board view. One of &#x60;before_section&#x60; or &#x60;after_section&#x60; is required.  Sections cannot be moved between projects.  Returns an empty data block.
     * @param projectGid Globally unique identifier for the project. (required)
     * @param body The section&#x27;s move action. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<EmptyObject>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<EmptyObject> insertSectionForProject(String projectGid, ProjectSectionInsertRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/projects/{project_gid}/sections/insert".replace("{project_gid}", projectGid);

        ItemRequest<EmptyObject> req = new ItemRequest<EmptyObject>(this, EmptyObject.class, path, "POST")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<EmptyObject> insertSectionForProject(String projectGid, ProjectSectionInsertRequest body) throws IOException {
        return insertSectionForProject(projectGid, body, null, false);
    }

    /**
     * Update a section
     * A specific, existing section can be updated by making a PUT request on the URL for that project. Only the fields provided in the &#x60;data&#x60; block will be updated; any unspecified fields will remain unchanged. (note that at this time, the only field that can be updated is the &#x60;name&#x60; field.)  When using this method, it is best to specify only those fields you wish to change, or else you may overwrite changes made by another user since you last retrieved the task.  Returns the complete updated section record.
     * @param sectionGid The globally unique identifier for the section. (required)
     * @param body The section to create. (required)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @return ItemRequest<SectionResponse>
     * @throws IOException If we fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemRequest<SectionResponse> updateSection(String sectionGid, SectionRequest body, List<String> optFields, Boolean optPretty) throws IOException {
        String path = "/sections/{section_gid}".replace("{section_gid}", sectionGid);

        ItemRequest<SectionResponse> req = new ItemRequest<SectionResponse>(this, SectionResponse.class, path, "PUT")
            .query("opt_pretty", optPretty)
            .query("opt_fields", optFields);

        req.data = Resource.getMapFromResource(body);

        return req;
    }

    public ItemRequest<SectionResponse> updateSection(String sectionGid, SectionRequest body) throws IOException {
        return updateSection(sectionGid, body, null, false);
    }

}

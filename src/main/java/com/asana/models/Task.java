package com.asana.models;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class Task extends Resource {
    public static class Membership {
        public Project project;
        public Task section;
    }

    @SerializedName("resource_subtype")
    public String resourceSubtype;

    public User assignee;

    @SerializedName("assignee_status")
    public String assigneeStatus;

    @SerializedName("created_at")
    public DateTime createdAt;

    public boolean completed;

    @SerializedName("completed_at")
    public DateTime completedAt;

    @SerializedName("custom_fields")
    public Collection<CustomField> customFields;

    public Collection<Task> dependencies;
    public Collection<Task> dependents;

    @SerializedName("due_on")
    public DateTime dueOn;
    @SerializedName("due_at")
    public DateTime dueAt;

    public External external;

    public Collection<User> followers;

    @SerializedName("is_rendered_as_separator")
    public boolean isRenderedAsSeparator;

    public boolean liked;
    public Collection<Like> likes;

    public Collection<Membership> memberships;

    @SerializedName("modified_at")
    public DateTime modifiedAt;

    public String name;

    public String notes;
    @SerializedName("html_notes")
    public String htmlNotes;

    @SerializedName("num_likes")
    public int numLikes;

    @SerializedName("num_subtasks")
    public int numSubtasks;

    public Task parent;

    public Collection<Project> projects;

    @SerializedName("start_on")
    public DateTime startOn;

    public Workspace workspace;

    public Collection<Tag> tags;

    public boolean hearted;
    public Collection<Heart> hearts;
    @SerializedName("num_hearts")
    public int numHearts;
}

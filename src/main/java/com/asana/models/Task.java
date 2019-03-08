package com.asana.models;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class Task extends Resource {
    public static class Membership {
        public Project project;
        public Task section;
    }

    public String name;

    public String notes;
    @SerializedName("html_notes")
    public String htmlNotes;

    @SerializedName("completed_at")
    public DateTime completedAt;
    @SerializedName("due_at")
    public DateTime dueAt;
    @SerializedName("due_on")
    public DateTime dueOn;
    @SerializedName("start_on")
    public DateTime startOn;

    public User assignee;
    @SerializedName("assignee_status")
    public String assigneeStatus;
    public boolean completed;

    public boolean hearted;
    public Collection<Heart> hearts;
    @SerializedName("num_hearts")
    public int numHearts;

    public boolean liked;
    public Collection<Like> likes;
    @SerializedName("num_likes")
    public int numLikes;

    public Task parent;
    public Collection<User> followers;
    public Collection<Membership> memberships;
    public Collection<Project> projects;
    public Collection<Tag> tags;
    public Workspace workspace;

    @SerializedName("custom_fields")
    public Collection<CustomField> customFields;
    public External external;

    public Collection<Task> dependencies;
    public Collection<Task> dependents;

    @SerializedName("created_by")
    public User createdBy;
    @SerializedName("created_at")
    public DateTime createdAt;
    @SerializedName("modified_at")
    public DateTime modifiedAt;
}

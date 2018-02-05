package com.asana.models;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class Task {
    public static class Membership {
        public Project project;
        public Task section;
    }

    public static class Heart {
        public String id;
        public User user;
    }

    public String id;
    public String name;
    public String notes;

    @SerializedName("completed_at")
    public DateTime completedAt;
    @SerializedName("due_at")
    public DateTime dueAt;
    @SerializedName("due_on")
    public DateTime dueOn;

    public User assignee;
    @SerializedName("assignee_status")
    public String assigneeStatus;
    public boolean completed;

    public boolean hearted;
    public Collection<Heart> hearts;
    @SerializedName("num_hearts")
    public int numHearts;

    public Task parent;
    public Collection<User> followers;
    public Collection<Membership> memberships;
    public Collection<Project> projects;
    public Collection<Tag> tags;
    public Workspace workspace;

    @SerializedName("created_at")
    public DateTime createdAt;
    @SerializedName("modified_at")
    public DateTime modifiedAt;

    @SerializedName("custom_fields")
    public Collection<CustomField> customFields;

}

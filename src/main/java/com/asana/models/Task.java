package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.Date;

public class Task
{
    public static class Membership
    {
        public Project project;
        public Section section;
    }

    public static class Section
    {
        public String id;
        public String name;
    }

    public static class Heart
    {
        public String id;
        public User user;
    }

    public String id;
    public String name;
    public String notes;

    @SerializedName("completed_at") public Date completedAt;
    @SerializedName("due_at") public Date dueAt;
    @SerializedName("due_on") public Date dueOn;

    public User assignee;
    @SerializedName("assignee_status") public String assigneeStatus;
    public boolean completed;

    public boolean hearted;
    public Collection<Heart> hearts;
    @SerializedName("num_hearts") public int numHearts;

    public Task parent;
    public Collection<User> followers;
    public Collection<Membership> memberships;
    public Collection<Project> projects;
    public Collection<Tag> tags;
    public Workspace workspace;
    
    @SerializedName("created_at") public Date createdAt;
    @SerializedName("modified_at") public Date modifiedAt;
}

package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Event {
    public class Entity {
        public String id;
        public String name;
    }

    public String action;
    public Entity resource;
    public String type;
    public User user;
    public Entity parent;

    @SerializedName("created_at") public Date createdAt;
}

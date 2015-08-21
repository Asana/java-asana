package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class Workspace {
    public String id;
    public String name;

    @SerializedName("email_domains")
    public Collection<String> emailDomains;
    @SerializedName("is_organization")
    public boolean isOrganization;

    public Workspace() {
        //no-arg constructor
    }

    // constructor with id arg provided for convenience
    public Workspace(String id) {
        this.id = id;
    }

}

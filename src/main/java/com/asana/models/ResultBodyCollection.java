package com.asana.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultBodyCollection<T> {
    public class NextPage {
        public String offset;
        public String path;
        public String uri;
    }

    public List<T> data;

    public String sync;
    @SerializedName("next_page")
    public NextPage nextPage;
}

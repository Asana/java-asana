package com.asana.models;

import java.util.Collection;

public class User {
    public static class Photo {
        public String image_128x128;
        public String image_21x21;
        public String image_27x27;
        public String image_36x36;
        public String image_60x60;
    }

    public String id;
    public String name;

    public String email;
    public Photo photo;
    public Collection<Workspace> workspaces;
}

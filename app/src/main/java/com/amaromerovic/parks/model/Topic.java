package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

public class Topic {
    public String id;
    public String name;

    public Topic(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Topic() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Topic{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
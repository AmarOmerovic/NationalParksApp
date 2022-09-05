package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

public class Activity{
    public String id;
    public String name;

    public Activity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Activity() {
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
        return "Activity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

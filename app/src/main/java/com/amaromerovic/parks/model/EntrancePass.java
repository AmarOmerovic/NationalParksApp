package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

public class EntrancePass {
    public String cost;
    public String description;
    public String title;

    public EntrancePass(String cost, String description, String title) {
        this.cost = cost;
        this.description = description;
        this.title = title;
    }

    public EntrancePass() {
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @NonNull
    @Override
    public String toString() {
        return "EntrancePass{" +
                "cost='" + cost + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
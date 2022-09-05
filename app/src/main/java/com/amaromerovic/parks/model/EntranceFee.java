package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

public class EntranceFee{
    public String cost;
    public String description;
    public String title;

    public EntranceFee(String cost, String description, String title) {
        this.cost = cost;
        this.description = description;
        this.title = title;
    }

    public EntranceFee() {
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
        return "EntranceFee{" +
                "cost='" + cost + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
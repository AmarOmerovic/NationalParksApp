package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class OperatingHour {
    public ArrayList<Exception> exceptions;
    public String description;
    public StandardHours standardHours;
    public String name;

    public OperatingHour(ArrayList<Exception> exceptions, String description, StandardHours standardHours, String name) {
        this.exceptions = exceptions;
        this.description = description;
        this.standardHours = standardHours;
        this.name = name;
    }

    public OperatingHour() {
    }

    public ArrayList<Exception> getExceptions() {
        return exceptions;
    }

    public void setExceptions(ArrayList<Exception> exceptions) {
        this.exceptions = exceptions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StandardHours getStandardHours() {
        return standardHours;
    }

    public void setStandardHours(StandardHours standardHours) {
        this.standardHours = standardHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @NonNull
    @Override
    public String toString() {
        return "OperatingHour{" +
                "exceptions=" + exceptions +
                ", description='" + description + '\'' +
                ", standardHours=" + standardHours +
                ", name='" + name + '\'' +
                '}';
    }
}

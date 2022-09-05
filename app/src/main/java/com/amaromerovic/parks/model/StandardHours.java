package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

public class StandardHours {
    public String wednesday;
    public String monday;
    public String thursday;
    public String sunday;
    public String tuesday;
    public String friday;
    public String saturday;

    public StandardHours(String wednesday, String monday, String thursday, String sunday, String tuesday, String friday, String saturday) {
        this.wednesday = wednesday;
        this.monday = monday;
        this.thursday = thursday;
        this.sunday = sunday;
        this.tuesday = tuesday;
        this.friday = friday;
        this.saturday = saturday;
    }

    public StandardHours() {
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    @NonNull
    @Override
    public String toString() {
        return "StandardHours{" +
                "wednesday='" + wednesday + '\'' +
                ", monday='" + monday + '\'' +
                ", thursday='" + thursday + '\'' +
                ", sunday='" + sunday + '\'' +
                ", tuesday='" + tuesday + '\'' +
                ", friday='" + friday + '\'' +
                ", saturday='" + saturday + '\'' +
                '}';
    }
}
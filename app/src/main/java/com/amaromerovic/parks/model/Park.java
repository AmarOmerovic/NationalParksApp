package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Park {
    public String id;//
    public String url;//
    public String fullName;//
    public String parkCode;//
    public String description;//
    public String latitude;//
    public String longitude;//
    public ArrayList<Activity> activities;//
    public ArrayList<Topic> topics;//
    public String states;//
    public ArrayList<EntranceFee> entranceFees;//
    public ArrayList<EntrancePass> entrancePasses;//
    public String directionsInfo;//
    public Contacts contacts;
    public String directionsUrl; //
    public ArrayList<OperatingHour> operatingHours; //
    public ArrayList<Address> addresses; //
    public ArrayList<Image> images;//
    public String weatherInfo; //
    public String name;//
    public String designation;//

    public Park() {
    }

    public Park(String id, String url, String fullName, String parkCode, String description, String latitude, String longitude, ArrayList<Activity> activities, ArrayList<Topic> topics, String states, Contacts contacts, ArrayList<EntranceFee> entranceFees, ArrayList<EntrancePass> entrancePasses, String directionsInfo, String directionsUrl, ArrayList<OperatingHour> operatingHours, ArrayList<Address> addresses, ArrayList<Image> images, String weatherInfo, String name, String designation) {
        this.id = id;
        this.url = url;
        this.fullName = fullName;
        this.parkCode = parkCode;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.activities = activities;
        this.topics = topics;
        this.states = states;
        this.contacts = contacts;
        this.entranceFees = entranceFees;
        this.entrancePasses = entrancePasses;
        this.directionsInfo = directionsInfo;
        this.directionsUrl = directionsUrl;
        this.operatingHours = operatingHours;
        this.addresses = addresses;
        this.images = images;
        this.weatherInfo = weatherInfo;
        this.name = name;
        this.designation = designation;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public ArrayList<EntranceFee> getEntranceFees() {
        return entranceFees;
    }

    public void setEntranceFees(ArrayList<EntranceFee> entranceFees) {
        this.entranceFees = entranceFees;
    }

    public ArrayList<EntrancePass> getEntrancePasses() {
        return entrancePasses;
    }

    public void setEntrancePasses(ArrayList<EntrancePass> entrancePasses) {
        this.entrancePasses = entrancePasses;
    }

    public String getDirectionsInfo() {
        return directionsInfo;
    }

    public void setDirectionsInfo(String directionsInfo) {
        this.directionsInfo = directionsInfo;
    }

    public String getDirectionsUrl() {
        return directionsUrl;
    }

    public void setDirectionsUrl(String directionsUrl) {
        this.directionsUrl = directionsUrl;
    }

    public ArrayList<OperatingHour> getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(ArrayList<OperatingHour> operatingHours) {
        this.operatingHours = operatingHours;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public String getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(String weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @NonNull
    @Override
    public String toString() {
        return "Park{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", fullName='" + fullName + '\'' +
                ", parkCode='" + parkCode + '\'' +
                ", description='" + description + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", activities=" + activities +
                ", topics=" + topics +
                ", states='" + states + '\'' +
                ", contacts=" + contacts +
                ", entranceFees=" + entranceFees +
                ", entrancePasses=" + entrancePasses +
                ", directionsInfo='" + directionsInfo + '\'' +
                ", directionsUrl='" + directionsUrl + '\'' +
                ", operatingHours=" + operatingHours +
                ", addresses=" + addresses +
                ", images=" + images +
                ", weatherInfo='" + weatherInfo + '\'' +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}

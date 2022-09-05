package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

public class PhoneNumber {
    public String phoneNumber;
    public String description;
    public String extension;
    public String type;

    public PhoneNumber(String phoneNumber, String description, String extension, String type) {
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.extension = extension;
        this.type = type;
    }

    public PhoneNumber() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getExtension() {
        return extension;
    }

    public String getType() {
        return type;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setType(String type) {
        this.type = type;
    }

    @NonNull
    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", description='" + description + '\'' +
                ", extension='" + extension + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
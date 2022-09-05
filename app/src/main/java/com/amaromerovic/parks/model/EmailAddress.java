package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

public class EmailAddress{
    public String description;
    public String emailAddress;

    public EmailAddress(String description, String emailAddress) {
        this.description = description;
        this.emailAddress = emailAddress;
    }

    public EmailAddress() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @NonNull
    @Override
    public String toString() {
        return "EmailAddress{" +
                "description='" + description + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
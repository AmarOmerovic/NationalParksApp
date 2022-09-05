package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Contacts {
    public ArrayList<PhoneNumber> phoneNumbers;
    public ArrayList<EmailAddress> emailAddresses;

    public Contacts(ArrayList<PhoneNumber> phoneNumbers, ArrayList<EmailAddress> emailAddresses) {
        this.phoneNumbers = phoneNumbers;
        this.emailAddresses = emailAddresses;
    }


    public Contacts() {
    }

    public ArrayList<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public ArrayList<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(ArrayList<EmailAddress> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    @NonNull
    @Override
    public String toString() {
        return "Contacts{" +
                "phoneNumbers=" + phoneNumbers +
                ", emailAddresses=" + emailAddresses +
                '}';
    }
}
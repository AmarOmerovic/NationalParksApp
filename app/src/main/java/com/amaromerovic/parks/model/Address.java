package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

public class Address{
    public String postalCode;
    public String city;
    public String stateCode;
    public String line1;
    public String type;
    public String line3;
    public String line2;

    public Address(String postalCode, String city, String stateCode, String line1, String type) {
        this.postalCode = postalCode;
        this.city = city;
        this.stateCode = stateCode;
        this.line1 = line1;
        this.type = type;
    }

    public Address() {
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    @NonNull
    @Override
    public String toString() {
        return "Address{" +
                "postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", line1='" + line1 + '\'' +
                ", type='" + type + '\'' +
                ", line3='" + line3 + '\'' +
                ", line2='" + line2 + '\'' +
                '}';
    }
}
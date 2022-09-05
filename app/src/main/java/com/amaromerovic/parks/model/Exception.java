package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

public class Exception {
    public ExceptionHours exceptionHours;
    public String startDate;
    public String name;
    public String endDate;

    public Exception(ExceptionHours exceptionHours, String startDate, String name, String endDate) {
        this.exceptionHours = exceptionHours;
        this.startDate = startDate;
        this.name = name;
        this.endDate = endDate;
    }

    public Exception() {
    }

    public ExceptionHours getExceptionHours() {
        return exceptionHours;
    }

    public void setExceptionHours(ExceptionHours exceptionHours) {
        this.exceptionHours = exceptionHours;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    @NonNull
    @Override
    public String toString() {
        return "Exception{" +
                "exceptionHours=" + exceptionHours +
                ", startDate='" + startDate + '\'' +
                ", name='" + name + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
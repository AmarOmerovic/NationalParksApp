package com.amaromerovic.parks.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ParkViewModel extends ViewModel {
    private final MutableLiveData<Park> park = new MutableLiveData<>();
    private final MutableLiveData<List<Park>> parkList = new MutableLiveData<>();

    public void setPark(Park park) {
        this.park.setValue(park);
    }

    public LiveData<Park> getPark() {
        return park;
    }

    public void setParkList(List<Park> parkList) {
        this.parkList.setValue(parkList);
    }

    public LiveData<List<Park>> getParkList() {
        return parkList;
    }
}

package com.amaromerovic.parks.data;

import com.amaromerovic.parks.model.Park;

import java.util.List;

public interface AsyncResponse {
    void processPark(List<Park> parks);
}

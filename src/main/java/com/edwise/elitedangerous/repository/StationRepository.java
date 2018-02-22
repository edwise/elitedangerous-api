package com.edwise.elitedangerous.repository;

import com.edwise.elitedangerous.bean.Station;
import com.edwise.elitedangerous.bean.System;

import java.util.List;

public interface StationRepository {

    void fillData(List<Station> stationsList);

    List<Station> getStations(System system);
}

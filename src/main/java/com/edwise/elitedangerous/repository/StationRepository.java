package com.edwise.elitedangerous.repository;

import com.edwise.elitedangerous.bean.Station;

import java.util.List;

public interface StationRepository {

    void fillData(List<Station> stationsList);

    List<Station> getStationsBySystemId(Integer id);
}

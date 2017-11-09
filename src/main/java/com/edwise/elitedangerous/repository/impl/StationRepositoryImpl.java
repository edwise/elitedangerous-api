package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.Station;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StationRepositoryImpl {

    private Map<Integer, Station> stations = new HashMap<>();

    public void fillData(List<Station> stationsList) {
        stations = stationsList.stream()
                               .collect(Collectors.toMap(Station::getId, Function.identity()));
    }
}

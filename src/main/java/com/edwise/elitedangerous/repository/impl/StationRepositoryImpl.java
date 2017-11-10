package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.Station;
import com.edwise.elitedangerous.repository.StationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class StationRepositoryImpl implements StationRepository {
    private static final Logger log = LoggerFactory.getLogger(StationRepositoryImpl.class);

    private Map<Integer, Station> stations = new HashMap<>();

    @Override
    public void fillData(List<Station> stationsList) {
        stations = stationsList.stream()
                               .collect(Collectors.toMap(Station::getId, Function.identity()));
        log.info("Size of stations json downloaded: {}", stations.size());
    }
}

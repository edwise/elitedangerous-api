package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.Station;
import com.edwise.elitedangerous.repository.StationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class StationRepositoryImpl implements StationRepository {

    private Map<Integer, Station> stations = new HashMap<>();

    @Override
    public void fillData(List<Station> stationsList) {
        stations = stationsList.stream()
                               .collect(Collectors.toMap(Station::getId, Function.identity()));
        log.info("Size of stations json downloaded: {}", stations.size());
    }

    @Override
    public List<Station> getStationsBySystemId(Integer id) {
        return stations.values()
                       .stream()
                       .filter(station -> Objects.nonNull(station.getSystemId()))
                       .filter(station -> station.getSystemId().equals(id))
                       .collect(Collectors.toList());
    }
}

package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.Station;
import com.edwise.elitedangerous.repository.StationRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StationRepositoryImplTest {

    private StationRepository stationRepository;

    @Before
    public void setUp() {
        this.stationRepository = new StationRepositoryImpl();
    }

    @Test
    public void fillDataShouldFillField() {
        Station station1 = new Station();
        station1.setId(1234);
        Station station2 = new Station();
        station2.setId(4567);

        stationRepository.fillData(Arrays.asList(station1, station2));
    }

    @Test
    public void getStationsShouldReturnListStationOfSystem() {
        Station station1 = createMockStation(1234, 123);
        Station station2 = createMockStation(5678, 123);
        Station station3 = createMockStation(9999, 456);
        stationRepository.fillData(Arrays.asList(station1, station2, station3));

        List<Station> stations = stationRepository.getStationsBySystemId(123);

        assertThat(stations).containsExactlyInAnyOrder(station1, station2);
    }

    private Station createMockStation(Integer id, Integer systemId) {
        Station station = new Station();
        station.setId(id);
        station.setSystemId(systemId);
        return station;
    }

}
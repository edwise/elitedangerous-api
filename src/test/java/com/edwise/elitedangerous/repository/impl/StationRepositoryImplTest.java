package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.Station;
import com.edwise.elitedangerous.repository.StationRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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

}
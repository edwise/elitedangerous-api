package com.edwise.elitedangerous.service.impl;

import com.edwise.elitedangerous.bean.System;
import com.edwise.elitedangerous.bean.SystemPair;
import com.edwise.elitedangerous.bean.enums.Allegiance;
import com.edwise.elitedangerous.model.SystemModel;
import com.edwise.elitedangerous.model.SystemPairModel;
import com.edwise.elitedangerous.repository.FactionRepository;
import com.edwise.elitedangerous.repository.StationRepository;
import com.edwise.elitedangerous.repository.SystemRepository;
import com.edwise.elitedangerous.service.SystemService;
import ma.glasnost.orika.MapperFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SystemServiceImplTest {

    @Mock
    private SystemRepository systemRepository;

    @Mock
    private StationRepository stationRepository;

    @Mock
    private FactionRepository factionRepository;

    @Mock
    private MapperFacade mapper;

    private SystemService systemService;

    @Before
    public void setUp() {
        this.systemService = new SystemServiceImpl(systemRepository, stationRepository, factionRepository, mapper);
    }

    @Test
    public void obtainClosestLonelySystemsShouldCalculateLonelySystems() {
        List<SystemPair> repositoryResult = Arrays.asList(createSystemPairMock(), createSystemPairMock());
        when(systemRepository.getClosestLonelySystems()).thenReturn(repositoryResult);
        when(mapper.mapAsList(repositoryResult, SystemPairModel.class))
                .thenReturn(Arrays.asList(createSystemPairModelMock(), createSystemPairModelMock()));

        List<SystemPairModel> systemPairs = systemService.obtainClosestLonelySystems();

        assertThat(systemPairs).hasSize(2);
    }

    @Test
    public void obtainClosestLonelySystemsWithParamsShouldCalculateLonelySystems() {
        List<SystemPair> repositoryResult = Arrays.asList(createSystemPairMock(), createSystemPairMock());
        when(systemRepository.getClosestLonelySystems(Allegiance.FEDERATION, 12.0D)).thenReturn(repositoryResult);
        when(mapper.mapAsList(repositoryResult, SystemPairModel.class))
                .thenReturn(Arrays.asList(createSystemPairModelMock(), createSystemPairModelMock()));

        List<SystemPairModel> systemPairs = systemService.obtainClosestLonelySystems(Allegiance.FEDERATION, 12.0D, true);

        assertThat(systemPairs).hasSize(2);
    }

    private SystemPair createSystemPairMock() {
        return new SystemPair(new System(), new System());
    }

    private SystemPairModel createSystemPairModelMock() {
        SystemModel systemA = new SystemModel();
        systemA.setFactions(Collections.emptyList());
        SystemModel systemB = new SystemModel();
        systemB.setFactions(Collections.emptyList());
        return new SystemPairModel(systemA, systemB);
    }
}
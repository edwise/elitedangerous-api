package com.edwise.elitedangerous.service.impl;

import com.edwise.elitedangerous.bean.System;
import com.edwise.elitedangerous.bean.SystemPair;
import com.edwise.elitedangerous.repository.SystemRepository;
import com.edwise.elitedangerous.service.SystemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SystemServiceImplTest {

    @Mock
    private SystemRepository systemRepository;

    private SystemService systemService;

    @Before
    public void setUp() {
        this.systemService = new SystemServiceImpl(systemRepository);
    }


    @Test
    public void obtainClosestLonelySystemsShouldCalculateLonelySystems() {
        when(systemRepository.getClosestLonelySystems())
                .thenReturn(Arrays.asList(createSystemPairMock(), createSystemPairMock()));

        List<SystemPair> systemPairs = systemService.obtainClosestLonelySystems();

        assertThat(systemPairs).hasSize(2);
    }

    private SystemPair createSystemPairMock() {
        return new SystemPair(new System(), new System());
    }
}
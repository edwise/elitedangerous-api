package com.edwise.elitedangerous.controller;

import com.edwise.elitedangerous.bean.System;
import com.edwise.elitedangerous.bean.SystemPair;
import com.edwise.elitedangerous.service.SystemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClosestLonelySystemsControllerTest {

    @Mock
    private SystemService systemService;

    private ClosestLonelySystemsController closestLonelySystemsController;

    @Before
    public void setUp() {
        this.closestLonelySystemsController = new ClosestLonelySystemsController(systemService);
    }

    @Test
    public void getAllClosestLonelySystemsShouldReturnPairs() {
        when(systemService.obtainClosestLonelySystems())
                .thenReturn(Arrays.asList(new SystemPair(new System(), new System()),
                                          new SystemPair(new System(), new System())));

        ResponseEntity<List<SystemPair>> allClosestLonelySystems = closestLonelySystemsController.getAllClosestLonelySystems();

        assertThat(allClosestLonelySystems.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(allClosestLonelySystems.getBody()).hasSize(2);
    }

}
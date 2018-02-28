package com.edwise.elitedangerous.controller;

import com.edwise.elitedangerous.bean.enums.Allegiance;
import com.edwise.elitedangerous.model.SystemModel;
import com.edwise.elitedangerous.model.SystemPairModel;
import com.edwise.elitedangerous.model.SystemsQuery;
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
                .thenReturn(Arrays.asList(new SystemPairModel(new SystemModel(), new SystemModel()),
                                          new SystemPairModel(new SystemModel(), new SystemModel())));

        ResponseEntity<List<SystemPairModel>> allClosestLonelySystems =
                closestLonelySystemsController.getAllClosestLonelySystems();

        assertThat(allClosestLonelySystems.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(allClosestLonelySystems.getBody()).hasSize(2);
    }

    @Test
    public void postGetAllClosestLonelySystemsShouldReturnPairs() {
        when(systemService.obtainClosestLonelySystems(Allegiance.FEDERATION, 12.0D, false))
                .thenReturn(Arrays.asList(new SystemPairModel(new SystemModel(), new SystemModel()),
                                          new SystemPairModel(new SystemModel(), new SystemModel())));
        SystemsQuery systemsQuery = new SystemsQuery();
        systemsQuery.setAllegiance(Allegiance.FEDERATION);
        systemsQuery.setClosestDistance(12.0D);

        ResponseEntity<List<SystemPairModel>> allClosestLonelySystems =
                closestLonelySystemsController.getAllClosestLonelySystems(systemsQuery);

        assertThat(allClosestLonelySystems.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(allClosestLonelySystems.getBody()).hasSize(2);
    }

}
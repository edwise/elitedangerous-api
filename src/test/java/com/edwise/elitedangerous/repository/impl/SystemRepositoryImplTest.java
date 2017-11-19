package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.System;
import com.edwise.elitedangerous.bean.SystemPair;
import com.edwise.elitedangerous.repository.SystemRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class SystemRepositoryImplTest {
    private static final double LIGHT_YEARS_BETWEEN_SOL_AND_ALPHA_CENTAURI = 4.38D;
    private static final double LIGHT_YEARS_BETWEEN_ODUDURO_AND_SIKSIKAS = 163.91D;

    private SystemRepository systemRepository;

    @Before
    public void setUp() {
        this.systemRepository = new SystemRepositoryImpl();
    }

    @Test
    public void fillDataShouldFillField() {

        systemRepository.fillData(Arrays.asList(new System(), new System()));
    }

    @Test
    public void calculateDistanceBetweenSOLandOther() {
        System system1 = createSOLSystem();
        System system2 = createAlphaCentauriSystem();

        double result = systemRepository.calculateDistance(system1, system2);

        assertThat(result).isCloseTo(LIGHT_YEARS_BETWEEN_SOL_AND_ALPHA_CENTAURI, within(0.005D));
    }

    @Test
    public void calculateDistanceBetweenNoSOLSystems() {
        System system1 = createOduduroSystem();
        System system2 = createSiksikasSystem();

        double result = systemRepository.calculateDistance(system1, system2);

        assertThat(result).isCloseTo(LIGHT_YEARS_BETWEEN_ODUDURO_AND_SIKSIKAS, within(0.005D));
    }

    @Test
    public void getClosestLonelySystemsShouldReturnPairOfClosestLonelySystem() {
        SystemPair expectedResult = new SystemPair(createSOLSystem(), createAlphaCentauriSystem());
        systemRepository.fillData(Arrays.asList(createSOLSystem(), createAlphaCentauriSystem(),
                                                createSiksikasSystem(), createOduduroSystem()));

        List<SystemPair> closestLonelySystems = systemRepository.getClosestLonelySystems();

        assertThat(closestLonelySystems).containsExactly(expectedResult);

    }

    private System createSiksikasSystem() {
        System solSystem = new System();
        solSystem.setId(16942);
        solSystem.setName("Siksikas");
        solSystem.setX(105.09375D);
        solSystem.setY(-140.78125D);
        solSystem.setZ(-13.96875D);
        return solSystem;
    }

    private System createOduduroSystem() {
        System solSystem = new System();
        solSystem.setId(14900);
        solSystem.setName("Oduduro");
        solSystem.setX(-7.90625D);
        solSystem.setY(-23.375D);
        solSystem.setZ(-31.625D);
        return solSystem;
    }

    private System createSOLSystem() {
        System solSystem = new System();
        solSystem.setId(17072);
        solSystem.setName("SOL");
        solSystem.setX(0D);
        solSystem.setY(0D);
        solSystem.setZ(0D);
        return solSystem;
    }

    private System createAlphaCentauriSystem() {
        System alphaCentauriSystem = new System();
        alphaCentauriSystem.setId(764);
        alphaCentauriSystem.setName("Alpha Centauri");
        alphaCentauriSystem.setX(3.03125D);
        alphaCentauriSystem.setY(-0.09375D);
        alphaCentauriSystem.setZ(3.15625D);
        return alphaCentauriSystem;
    }

}
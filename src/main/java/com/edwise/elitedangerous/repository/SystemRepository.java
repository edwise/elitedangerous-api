package com.edwise.elitedangerous.repository;

import com.edwise.elitedangerous.bean.System;
import com.edwise.elitedangerous.bean.SystemPair;
import com.edwise.elitedangerous.bean.enums.Allegiance;

import java.util.List;

public interface SystemRepository {
    double DEFAULT_CLOSE_DISTANCE = 20D;

    void fillData(List<System> systemsList);

    double calculateDistance(System system1, System system2);

    List<SystemPair> getClosestLonelySystems();

    List<SystemPair> getClosestLonelySystems(Allegiance allegiance, double closeDistance);
}

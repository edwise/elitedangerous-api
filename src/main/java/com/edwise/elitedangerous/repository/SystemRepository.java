package com.edwise.elitedangerous.repository;

import com.edwise.elitedangerous.bean.System;
import com.edwise.elitedangerous.bean.SystemPair;

import java.util.List;

public interface SystemRepository {

    void fillData(List<System> systemsList);

    double calculateDistance(System system1, System system2);

    List<SystemPair> getClosestLonelySystems();
}

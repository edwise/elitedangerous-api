package com.edwise.elitedangerous.repository;

import com.edwise.elitedangerous.bean.System;

import java.util.List;

public interface SystemRepository {

    void fillData(List<System> systemsList);

    double calculateDistance(System system1, System system2);
}

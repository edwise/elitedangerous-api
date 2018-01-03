package com.edwise.elitedangerous.service;

import com.edwise.elitedangerous.model.SystemPairModel;

import java.util.List;

public interface SystemService {

    List<SystemPairModel> obtainClosestLonelySystems();
}

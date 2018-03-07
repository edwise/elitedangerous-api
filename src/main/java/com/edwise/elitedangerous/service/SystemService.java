package com.edwise.elitedangerous.service;

import com.edwise.elitedangerous.bean.enums.Allegiance;
import com.edwise.elitedangerous.model.SystemPairModel;

import java.util.List;

public interface SystemService {

    List<SystemPairModel> obtainClosestLonelySystems();

    List<SystemPairModel> obtainClosestLonelySystems(Allegiance allegiance, double closestDistance,
                                                     boolean withFactionsAndStations);

    List<SystemPairModel> obtainClosestLonelySystemsOneStation();

    List<SystemPairModel> obtainClosestLonelySystemsOneStation(Allegiance allegiance, double closestDistance,
                                                               boolean withFactionsAndStations);
}

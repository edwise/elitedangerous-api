package com.edwise.elitedangerous.service;

import com.edwise.elitedangerous.bean.SystemPair;

import java.util.List;

public interface SystemService {

    List<SystemPair> obtainClosestLonelySystems();
}

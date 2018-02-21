package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.System;
import com.edwise.elitedangerous.bean.SystemPair;
import com.edwise.elitedangerous.bean.enums.Allegiance;
import com.edwise.elitedangerous.repository.SystemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class SystemRepositoryImpl implements SystemRepository {

    private List<System> systems = new ArrayList<>();

    @Override
    public void fillData(List<System> systemsList) {
        systems = systemsList;
        log.info("Size of systems json downloaded: {}", systems.size());
    }

    @Override
    public double calculateDistance(System system1, System system2) {
        return system1.distanceTo(system2);
    }

    @Override
    public List<SystemPair> getClosestLonelySystems() {
        return systems.parallelStream()
                      .map(system -> findSystemPair(system, DEFAULT_CLOSE_DISTANCE))
                      .filter(Objects::nonNull)
                      .distinct()
                      .collect(Collectors.toList());
    }

    @Override
    public List<SystemPair> getClosestLonelySystems(Allegiance allegiance, double closeDistance) {
        return systems.parallelStream()
                      .map(system -> findSystemPair(system, closeDistance))
                      .filter(Objects::nonNull)
                      .distinct()
                      .filter(pair -> pair.hasAllegiance(allegiance))
                      .collect(Collectors.toList());
    }

    private SystemPair findSystemPair(System system, double closeDistance) {
        List<System> nearSystems = findNearSystems(system, closeDistance);
        return nearSystems.size() == 1 ? new SystemPair(system, nearSystems.get(0)) : null;
    }

    private List<System> findNearSystems(System system, double closeDistance) {
        return systems.stream()
                      .filter(otherSystem -> !system.equals(otherSystem))
                      .filter(otherSystem -> system.distanceTo(otherSystem) < closeDistance)
                      .collect(Collectors.toList());
    }

}

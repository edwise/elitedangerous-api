package com.edwise.elitedangerous.service.impl;

import com.edwise.elitedangerous.bean.Station;
import com.edwise.elitedangerous.bean.SystemPair;
import com.edwise.elitedangerous.bean.enums.Allegiance;
import com.edwise.elitedangerous.model.FactionModel;
import com.edwise.elitedangerous.model.StationModel;
import com.edwise.elitedangerous.model.SystemModel;
import com.edwise.elitedangerous.model.SystemPairModel;
import com.edwise.elitedangerous.repository.FactionRepository;
import com.edwise.elitedangerous.repository.StationRepository;
import com.edwise.elitedangerous.repository.SystemRepository;
import com.edwise.elitedangerous.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class SystemServiceImpl implements SystemService {

    private SystemRepository systemRepository;
    private StationRepository stationRepository;
    private FactionRepository factionRepository;
    private MapperFacade mapper;

    @Autowired
    public SystemServiceImpl(SystemRepository systemRepository, StationRepository stationRepository,
                             FactionRepository factionRepository, MapperFacade mapper) {
        this.systemRepository = systemRepository;
        this.factionRepository = factionRepository;
        this.stationRepository = stationRepository;
        this.mapper = mapper;
    }

    @Override
    public List<SystemPairModel> obtainClosestLonelySystems() {
        long startDownloadTime = java.lang.System.nanoTime();
        List<SystemPair> closestLonelySystems = systemRepository.getClosestLonelySystems();
        long endDownloadTime = java.lang.System.nanoTime();
        log.info("Total closest lonely system calculation (millis): {}", (endDownloadTime - startDownloadTime) / 1_000_000);
        return removeNotNeed(mapper.mapAsList(closestLonelySystems, SystemPairModel.class));
    }

    @Override
    public List<SystemPairModel> obtainClosestLonelySystems(Allegiance allegiance, double closestDistance,
                                                            boolean withFactionsAndStations) {
        long startDownloadTime = java.lang.System.nanoTime();
        List<SystemPair> closestLonelySystems = systemRepository.getClosestLonelySystems(allegiance, closestDistance);
        long endDownloadTime = java.lang.System.nanoTime();
        log.info("Total closest lonely system calculation with params (millis): {}",
                 (endDownloadTime - startDownloadTime) / 1_000_000);

        List<SystemPairModel> systemPairModels = mapper.mapAsList(closestLonelySystems, SystemPairModel.class);
        if (withFactionsAndStations) {
            enrichSystems(systemPairModels);
        } else {
            removeNotNeed(systemPairModels);
        }
        return systemPairModels;
    }

    @Override
    public List<SystemPairModel> obtainClosestLonelySystemsOneStation() {
        List<SystemPair> oneStationPairs = filterOneStation(systemRepository.getClosestLonelySystems(), 0D);
        return removeNotNeed(mapper.mapAsList(oneStationPairs, SystemPairModel.class));
    }

    private List<SystemPair> filterOneStation(List<SystemPair> closestLonelySystems, double minStationDistance) {
        return closestLonelySystems.stream()
                                   .filter(pair -> hasSystemWithOneStation(pair, minStationDistance))
                                   .collect(Collectors.toList());
    }

    @Override
    public List<SystemPairModel> obtainClosestLonelySystemsOneStation(Allegiance allegiance, double closestDistance,
                                                                      boolean withFactionsAndStations,
                                                                      double minStationDistance) {
        long startDownloadTime = java.lang.System.nanoTime();
        List<SystemPair> oneStationPairs = filterOneStation(systemRepository.getClosestLonelySystems(allegiance,
                                                                                                     closestDistance),
                                                            minStationDistance);
        long endDownloadTime = java.lang.System.nanoTime();
        log.info("Total closest lonely system calculation with params (millis): {}",
                 (endDownloadTime - startDownloadTime) / 1_000_000);

        List<SystemPairModel> systemPairModels = mapper.mapAsList(oneStationPairs, SystemPairModel.class);
        if (withFactionsAndStations) {
            enrichSystems(systemPairModels);
        } else {
            removeNotNeed(systemPairModels);
        }
        return systemPairModels;
    }

    private boolean hasSystemWithOneStation(SystemPair pair, double minStationDistance) {
        List<Station> stationsSystemA =
                stationRepository.getStationsBySystemId(pair.getSystemA().getId());
        List<Station> stationsSystemB =
                stationRepository.getStationsBySystemId(pair.getSystemB().getId());
        return stationsSystemA.size() == 1 && isOnDistance(stationsSystemA.get(0), minStationDistance) ||
               stationsSystemB.size() == 1 && isOnDistance(stationsSystemB.get(0), minStationDistance);
    }

    private boolean isOnDistance(Station station, double minStationDistance) {
        return station.getDistanceToStar() == null || station.getDistanceToStar() > minStationDistance;
    }

    private List<SystemPairModel> removeNotNeed(List<SystemPairModel> systemPairModels) {
        systemPairModels.stream()
                        .flatMap(systemPairModel -> Stream.of(systemPairModel.getSystemA(), systemPairModel.getSystemB()))
                        .forEach(systemModel -> systemModel.setFactions(null));
        return systemPairModels;
    }

    private void enrichSystems(List<SystemPairModel> systemPairModels) {
        systemPairModels.stream()
                        .flatMap(systemPairModel -> Stream.of(systemPairModel.getSystemA(), systemPairModel.getSystemB()))
                        .forEach(this::enrichSystem);
    }

    private void enrichSystem(SystemModel systemModel) {
        enrichStations(systemModel);
        enrichFactions(systemModel);
    }

    private void enrichStations(SystemModel systemModel) {
        List<Station> stations = stationRepository.getStationsBySystemId(systemModel.getId());
        systemModel.setStations(mapper.mapAsList(stations, StationModel.class));
        systemModel.getStations()
                   .forEach(this::enrichStation);
    }

    private void enrichStation(StationModel station) {
        factionRepository.getFactionById(station.getControllingMinorFactionId())
                         .ifPresent(faction -> station.setControllingMinorFaction(faction.getName()));
    }

    private void enrichFactions(SystemModel systemModel) {
        systemModel.getFactions()
                   .forEach(this::enrichFaction);
    }

    private void enrichFaction(FactionModel factionModel) {
        factionRepository.getFactionById(factionModel.getId())
                         .ifPresent(faction -> {
                             factionModel.setAllegiance(faction.getAllegiance());
                             factionModel.setName(faction.getName());
                         });
    }
}

package com.edwise.elitedangerous.config;

import com.edwise.elitedangerous.bean.Faction;
import com.edwise.elitedangerous.bean.Station;
import com.edwise.elitedangerous.bean.System;
import com.edwise.elitedangerous.bean.SystemPair;
import com.edwise.elitedangerous.config.bean.EddbConfig;
import com.edwise.elitedangerous.repository.FactionRepository;
import com.edwise.elitedangerous.repository.StationRepository;
import com.edwise.elitedangerous.repository.SystemRepository;
import com.edwise.elitedangerous.service.DownloadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(AppStartupRunner.class);

    private final EddbConfig eddbConfig;

    private ObjectMapper objectMapper;

    private DownloadService   downloadService;
    private FactionRepository factionRepository;
    private StationRepository stationRepository;
    private SystemRepository  systemRepository;

    @Autowired
    public AppStartupRunner(EddbConfig eddbConfig, DownloadService downloadService, ObjectMapper objectMapper,
                            FactionRepository factionRepository, StationRepository stationRepository,
                            SystemRepository systemRepository) {
        this.eddbConfig = eddbConfig;
        this.objectMapper = objectMapper;
        this.downloadService = downloadService;
        this.factionRepository = factionRepository;
        this.stationRepository = stationRepository;
        this.systemRepository = systemRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Initializing app, filling repositories...");

        long startDownloadTime = java.lang.System.nanoTime();
        CompletableFuture<Void> factionsFuture = CompletableFuture.runAsync(this::downloadFactionData);
        CompletableFuture<Void> stationsFuture = CompletableFuture.runAsync(this::downloadStationData);
        CompletableFuture<Void> systemsFuture = CompletableFuture.runAsync(this::downloadSystemData);

        CompletableFuture.allOf(factionsFuture, stationsFuture, systemsFuture)
                         .thenRun(() -> {
                             log.info("Application started! Data filled in repositories.");
                             long endDownloadTime = java.lang.System.nanoTime();
                             log.info("Total download time (millis): {}", (endDownloadTime - startDownloadTime) / 1_000_000);
                             obtainClosestLonelySystems();
                         });
    }

    private void obtainClosestLonelySystems() {
        List<SystemPair> closestLonelySystems = systemRepository.getClosestLonelySystems();
        log.info("Systems paired:");
        closestLonelySystems.forEach(pair -> log.info("- {} <-> {} -", pair.getSystemA().getName(),
                                                      pair.getSystemB().getName()));
        log.info("--------");
        log.info("- Total pairs: {}", closestLonelySystems.size());
    }

    private void downloadSystemData() {
        log.info("Starting systems download...");

        Optional<String> systemsFileContent =
                downloadService.downloadFileTextContent(eddbConfig.getUrl() + eddbConfig.getSystemsFile());

        CollectionType systemsType = objectMapper.getTypeFactory()
                                                 .constructCollectionType(List.class, System.class);
        List<System> systems;
        try {
            systems = objectMapper.readValue(systemsFileContent.orElse("[]"), systemsType);
        } catch (IOException e) {
            log.error("Cant parser systems data with objectMapper", e);
            systems = Collections.emptyList();
        }
        systemRepository.fillData(systems);
    }

    private void downloadStationData() {
        log.info("Starting stations download...");

        Optional<String> stationsFileContent =
                downloadService.downloadFileTextContent(eddbConfig.getUrl() + eddbConfig.getStationsFile());

        CollectionType stationsType = objectMapper.getTypeFactory()
                                                  .constructCollectionType(List.class, Station.class);
        List<Station> stations;
        try {
            stations = objectMapper.readValue(stationsFileContent.orElse("[]"), stationsType);
        } catch (IOException e) {
            log.error("Cant parser stations data with objectMapper", e);
            stations = Collections.emptyList();
        }
        stationRepository.fillData(stations);
    }

    private void downloadFactionData() {
        log.info("Starting factions download...");

        Optional<String> factionsFileContent =
                downloadService.downloadFileTextContent(eddbConfig.getUrl() + eddbConfig.getFactionsFile());

        CollectionType factionsType = objectMapper.getTypeFactory()
                                                  .constructCollectionType(List.class, Faction.class);
        List<Faction> factions;
        try {
            factions = objectMapper.readValue(factionsFileContent.orElse("[]"), factionsType);
        } catch (IOException e) {
            log.error("Cant parser factions data with objectMapper", e);
            factions = Collections.emptyList();
        }
        factionRepository.fillData(factions);
    }
}

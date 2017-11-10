package com.edwise.elitedangerous.config;

import com.edwise.elitedangerous.bean.Faction;
import com.edwise.elitedangerous.bean.Station;
import com.edwise.elitedangerous.bean.System;
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

import java.util.List;
import java.util.Optional;

@Component
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(AppStartupRunner.class);

    private final EddbConfig eddbConfig;

    private DownloadService downloadService;
    private FactionRepository factionRepository;
    private StationRepository stationRepository;
    private SystemRepository systemRepository;

    private ObjectMapper objectMapper;

    @Autowired
    public AppStartupRunner(EddbConfig eddbConfig, DownloadService downloadService, ObjectMapper objectMapper,
                            FactionRepository factionRepository, StationRepository stationRepository,
                            SystemRepository systemRepository) {
        this.eddbConfig = eddbConfig;
        this.downloadService = downloadService;
        this.factionRepository = factionRepository;
        this.stationRepository = stationRepository;
        this.systemRepository = systemRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Initializing app, filling repositories...");

        Optional<String> factionsFileContent =
                downloadService.downloadFileTextContent(eddbConfig.getUrl() + eddbConfig.getFactionsFile());

        CollectionType factionsType = objectMapper.getTypeFactory()
                                                  .constructCollectionType(List.class, Faction.class);
        List<Faction> factions = objectMapper.readValue(factionsFileContent.orElse("[]"), factionsType);
        factionRepository.fillData(factions);


        Optional<String> stationsFileContent =
                downloadService.downloadFileTextContent(eddbConfig.getUrl() + eddbConfig.getStationsFile());

        CollectionType stationsType = objectMapper.getTypeFactory()
                                                  .constructCollectionType(List.class, Station.class);
        List<Station> stations = objectMapper.readValue(stationsFileContent.orElse("[]"), stationsType);
        stationRepository.fillData(stations);


        Optional<String> systemsFileContent =
                downloadService.downloadFileTextContent(eddbConfig.getUrl() + eddbConfig.getSystemsFile());

        CollectionType systemsType = objectMapper.getTypeFactory()
                                                 .constructCollectionType(List.class, System.class);
        List<System> systems = objectMapper.readValue(systemsFileContent.orElse("[]"), systemsType);
        systemRepository.fillData(systems);

        log.info("Application started! Data filled in repositories.");
    }
}

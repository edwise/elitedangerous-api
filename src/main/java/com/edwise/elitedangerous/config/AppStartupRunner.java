package com.edwise.elitedangerous.config;

import com.edwise.elitedangerous.bean.Faction;
import com.edwise.elitedangerous.bean.Station;
import com.edwise.elitedangerous.bean.System;
import com.edwise.elitedangerous.config.bean.EddbConfig;
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
import java.util.Random;

@Component
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(AppStartupRunner.class);

    private final EddbConfig eddbConfig;

    private final DownloadService downloadService;

    private ObjectMapper objectMapper;

    @Autowired
    public AppStartupRunner(EddbConfig eddbConfig, DownloadService downloadService, ObjectMapper objectMapper) {
        this.eddbConfig = eddbConfig;
        this.downloadService = downloadService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Random rand = new Random();

        Optional<String> factionsFileContent =
                downloadService.downloadFileTextContent(eddbConfig.getUrl() + eddbConfig.getFactionsFile());

        CollectionType factionsType = objectMapper.getTypeFactory()
                                                  .constructCollectionType(List.class, Faction.class);
        List<Faction> factions = objectMapper.readValue(factionsFileContent.orElse("[]"), factionsType);
        log.info("Size of factions json downloaded: {}", factions.size());
        log.info("Faction example: {}", factions.get(rand.nextInt(factions.size())).getName());


        Optional<String> stationsFileContent =
                downloadService.downloadFileTextContent(eddbConfig.getUrl() + eddbConfig.getStationsFile());

        CollectionType stationsType = objectMapper.getTypeFactory()
                                                  .constructCollectionType(List.class, Station.class);
        List<Station> stations = objectMapper.readValue(stationsFileContent.orElse("[]"), stationsType);
        log.info("Size of stations json downloaded: {}", stations.size());
        log.info("Station example: {}", stations.get(rand.nextInt(stations.size())).getName());


        Optional<String> systemsFileContent =
                downloadService.downloadFileTextContent(eddbConfig.getUrl() + eddbConfig.getSystemsFile());

        CollectionType systemsType = objectMapper.getTypeFactory()
                                                 .constructCollectionType(List.class, System.class);
        List<System> systems = objectMapper.readValue(systemsFileContent.orElse("[]"), systemsType);
        log.info("Size of system json downloaded: {}", systems.size());
        log.info("System example: {}", systems.get(rand.nextInt(systems.size())).getName());

    }
}

package com.edwise.elitedangerous.config;

import com.edwise.elitedangerous.bean.Faction;
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

/**
 * Created by Eduardo Antón <eduardo.anton@taptapnetworks.com> on 08/11/2017.
 */
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
        Optional<String> fileContent =
                downloadService.downloadFileTextContent(eddbConfig.getUrl() + eddbConfig.getFactionsFile());

        CollectionType javaType = objectMapper.getTypeFactory()
                                              .constructCollectionType(List.class, Faction.class);
        List<Faction> factions = objectMapper.readValue(fileContent.orElse("[]"), javaType);
        log.info("Size of json downloaded: {}", factions.size());
    }
}

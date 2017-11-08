package com.edwise.elitedangerous.config;

import com.edwise.elitedangerous.config.bean.EddbConfig;
import com.edwise.elitedangerous.service.DownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by Eduardo Antón <eduardo.anton@taptapnetworks.com> on 08/11/2017.
 */
@Slf4j
@Component
public class AppStartupRunner implements ApplicationRunner {

    @Autowired
    private EddbConfig eddbConfig;

    @Autowired
    private DownloadService downloadService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<String> fileContent =
                downloadService.downloadFileTextContent(eddbConfig.getUrl() + eddbConfig.getFactionsFile());

        log.info("Size of json downloaded: {}", fileContent.map(String::length).orElse(-1));
    }
}

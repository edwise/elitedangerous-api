package com.edwise.elitedangerous.service.impl;

import com.edwise.elitedangerous.service.DownloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * Created by Eduardo Antón <eduardo.anton@taptapnetworks.com> on 08/11/2017.
 */
@Service
public class DownloadServiceImpl implements DownloadService {
    private static final Logger log = LoggerFactory.getLogger(DownloadServiceImpl.class);

    private RestTemplate restTemplate;

    @Autowired
    public DownloadServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<String> downloadFileTextContent(String url) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            return Optional.ofNullable(responseEntity.getBody());
        } else {
            log.error(String.format("Cant download file from url [%s], statusCode [%s]", url, responseEntity.getStatusCode()));
            return Optional.empty();
        }
    }
}

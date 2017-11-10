package com.edwise.elitedangerous.service.impl;

import com.edwise.elitedangerous.service.DownloadService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DownloadServiceImplTest {
    private static final String FILE_CONTENT = "[{fileContent}]";
    private static final String UR_FILE      = "http://test.com/file.json";

    @Mock
    private RestTemplate restTemplate;

    private DownloadService downloadService;

    @Before
    public void setUp() {
        this.downloadService = new DownloadServiceImpl(restTemplate);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void downloadFileTextContentShouldReturnFileContent() {
        ResponseEntity responseEntity = mock(ResponseEntity.class);
        when(restTemplate.getForEntity(anyString(), any())).thenReturn(responseEntity);
        when(responseEntity.getStatusCode()).thenReturn(HttpStatus.OK);
        when(responseEntity.getBody()).thenReturn(FILE_CONTENT);

        Optional<String> fileTextContent = downloadService.downloadFileTextContent(UR_FILE);

        assertThat(fileTextContent).isPresent()
                                   .contains(FILE_CONTENT);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void downloadFileTextContentShouldReturnEmptyContentWhenHttpStatusError() {
        ResponseEntity responseEntity = mock(ResponseEntity.class);
        when(restTemplate.getForEntity(anyString(), any())).thenReturn(responseEntity);
        when(responseEntity.getStatusCode()).thenReturn(HttpStatus.NOT_FOUND);

        Optional<String> fileTextContent = downloadService.downloadFileTextContent(UR_FILE);

        assertThat(fileTextContent).isNotPresent();
    }

}
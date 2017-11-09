package com.edwise.elitedangerous.service;

import java.util.Optional;

public interface DownloadService {

    Optional<String> downloadFileTextContent(String url);
}

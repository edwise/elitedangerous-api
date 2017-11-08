package com.edwise.elitedangerous.service;

import java.util.Optional;

/**
 * Created by Eduardo Antón <eduardo.anton@taptapnetworks.com> on 08/11/2017.
 */
public interface DownloadService {

    Optional<String> downloadFileTextContent(String url);
}

package com.edwise.elitedangerous.config.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Eduardo Antón <eduardo.anton@taptapnetworks.com> on 08/11/2017.
 */
@ConfigurationProperties(prefix = "eddb")
@Configuration("eddbConfig")
public class EddbConfig {

    private String url;
    private String factionsFile;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFactionsFile() {
        return factionsFile;
    }

    public void setFactionsFile(String factionsFile) {
        this.factionsFile = factionsFile;
    }
}

package com.edwise.elitedangerous.config.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "eddb")
@Configuration("eddbConfig")
public class EddbConfig {

    private String url;
    private String factionsFile;
    private String systemsFile;
    private String stationsFile;

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

    public String getSystemsFile() {
        return systemsFile;
    }

    public void setSystemsFile(String systemsFile) {
        this.systemsFile = systemsFile;
    }

    public String getStationsFile() {
        return stationsFile;
    }

    public void setStationsFile(String stationsFile) {
        this.stationsFile = stationsFile;
    }
}

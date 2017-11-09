package com.edwise.elitedangerous.config.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

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

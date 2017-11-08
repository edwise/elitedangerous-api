package com.edwise.elitedangerous.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Eduardo Antón <eduardo.anton@taptapnetworks.com> on 08/11/2017.
 */
@Data
@ConfigurationProperties(prefix = "eddb")
@Configuration("eddbConfig")
public class EddbConfig {

    private String url;
    private String factionsFile;
}

package com.edwise.elitedangerous.config;

import com.edwise.elitedangerous.bean.Faction;
import com.edwise.elitedangerous.bean.Station;
import com.edwise.elitedangerous.bean.System;
import com.edwise.elitedangerous.bean.SystemPair;
import com.edwise.elitedangerous.model.FactionModel;
import com.edwise.elitedangerous.model.StationModel;
import com.edwise.elitedangerous.model.SystemModel;
import com.edwise.elitedangerous.model.SystemPairModel;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public MapperFacade mapperFacade() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(System.class, SystemModel.class)
                     .byDefault()
                     .field("minorFactionPresences", "factions")
                     .register();
        mapperFactory.classMap(System.MinorFactionPresence.class, FactionModel.class)
                     .byDefault()
                     .field("minorFactionId", "id")
                     .register();
        mapperFactory.classMap(Station.class, StationModel.class).byDefault().register();
        mapperFactory.classMap(Faction.class, FactionModel.class).byDefault().register();

        mapperFactory.classMap(SystemPair.class, SystemPairModel.class).byDefault().register();

        return mapperFactory.getMapperFacade();
    }
}

package com.edwise.elitedangerous.service.impl;

import com.edwise.elitedangerous.bean.SystemPair;
import com.edwise.elitedangerous.model.SystemPairModel;
import com.edwise.elitedangerous.repository.SystemRepository;
import com.edwise.elitedangerous.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SystemServiceImpl implements SystemService {

    private SystemRepository systemRepository;
    private MapperFacade mapper;

    @Autowired
    public SystemServiceImpl(SystemRepository systemRepository, MapperFacade mapper) {
        this.systemRepository = systemRepository;
        this.mapper = mapper;
    }

    @Override
    public List<SystemPairModel> obtainClosestLonelySystems() {
        long startDownloadTime = java.lang.System.nanoTime();
        List<SystemPair> closestLonelySystems = systemRepository.getClosestLonelySystems();
        long endDownloadTime = java.lang.System.nanoTime();
        log.info("Total closest lonely system calculation (millis): {}", (endDownloadTime - startDownloadTime) / 1_000_000);
        return mapper.mapAsList(closestLonelySystems, SystemPairModel.class);
    }
}

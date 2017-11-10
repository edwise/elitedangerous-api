package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.System;
import com.edwise.elitedangerous.repository.SystemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SystemRepositoryImpl implements SystemRepository {
    private static final Logger log = LoggerFactory.getLogger(SystemRepositoryImpl.class);

    private List<System> systems = new ArrayList<>();

    @Override
    public void fillData(List<System> systemsList) {
        systems = systemsList;
        log.info("Size of systems json downloaded: {}", systems.size());
    }
}

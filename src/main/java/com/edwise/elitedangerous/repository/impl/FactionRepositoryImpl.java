package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.Faction;
import com.edwise.elitedangerous.repository.FactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class FactionRepositoryImpl implements FactionRepository {
    private static final Logger log = LoggerFactory.getLogger(FactionRepositoryImpl.class);

    private Map<Integer, Faction> factions = new HashMap<>();

    @Override
    public void fillData(List<Faction> factionList) {
        factions = factionList.stream()
                              .collect(Collectors.toMap(Faction::getId, Function.identity()));
        log.info("Size of factions json downloaded: {}", factions.size());
    }
}

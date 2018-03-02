package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.Faction;
import com.edwise.elitedangerous.repository.FactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class FactionRepositoryImpl implements FactionRepository {

    private Map<Integer, Faction> factions = new HashMap<>();

    @Override
    public void fillData(List<Faction> factionList) {
        factions = factionList.stream()
                              .collect(Collectors.toMap(Faction::getId, Function.identity()));
        log.info("Size of factions json downloaded: {}", factions.size());
    }

    @Override
    public Optional<Faction> getFactionById(Integer id) {
        return Optional.ofNullable(factions.get(id));
    }
}

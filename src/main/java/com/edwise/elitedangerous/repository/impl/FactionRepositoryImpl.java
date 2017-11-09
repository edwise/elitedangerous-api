package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.Faction;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class FactionRepositoryImpl {

    private Map<Integer, Faction> factions = new HashMap<>();

    public void fillData(List<Faction> factionList) {
        factions = factionList.stream()
                              .collect(Collectors.toMap(Faction::getId, Function.identity()));
    }
}

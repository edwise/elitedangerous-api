package com.edwise.elitedangerous.repository;

import com.edwise.elitedangerous.bean.Faction;

import java.util.List;
import java.util.Optional;

public interface FactionRepository {

    void fillData(List<Faction> factionList);

    Optional<Faction> getFactionById(Integer id);
}

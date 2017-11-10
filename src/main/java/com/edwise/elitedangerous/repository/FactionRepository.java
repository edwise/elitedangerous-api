package com.edwise.elitedangerous.repository;

import com.edwise.elitedangerous.bean.Faction;

import java.util.List;

public interface FactionRepository {

    void fillData(List<Faction> factionList);
}

package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.Faction;
import com.edwise.elitedangerous.repository.FactionRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FactionRepositoryImplTest {

    private FactionRepository factionRepository;

    @Before
    public void setUp() {
        this.factionRepository = new FactionRepositoryImpl();
    }

    @Test
    public void fillDataShouldFillField() {
        Faction faction1 = new Faction();
        faction1.setId(1234);
        Faction faction2 = new Faction();
        faction2.setId(4567);

        factionRepository.fillData(Arrays.asList(faction1, faction2));
    }

    @Test
    public void getFactionByIdShouldReturnFaction() {
        Faction faction1 = new Faction();
        faction1.setId(1234);
        Faction faction2 = new Faction();
        faction2.setId(4567);
        factionRepository.fillData(Arrays.asList(faction1, faction2));

        Faction faction = factionRepository.getFactionById(1234);

        assertThat(faction).isEqualTo(faction1);
    }

}
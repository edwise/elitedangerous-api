package com.edwise.elitedangerous.repository.impl;

import com.edwise.elitedangerous.bean.System;
import com.edwise.elitedangerous.repository.SystemRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SystemRepositoryImplTest {

    private SystemRepository systemRepository;

    @Before
    public void setUp() {
        this.systemRepository = new SystemRepositoryImpl();
    }

    @Test
    public void fillDataShouldFillField() {

        systemRepository.fillData(Arrays.asList(new System(), new System()));
    }

}
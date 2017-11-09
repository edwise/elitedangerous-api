package com.edwise.elitedangerous.repository.impl;

import java.util.ArrayList;
import java.util.List;

public class SystemRepositoryImpl {

    private List<System> systems = new ArrayList<>();

    public void fillData(List<System> systemsList) {
        systems = systemsList;
    }
}

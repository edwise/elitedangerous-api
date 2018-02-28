package com.edwise.elitedangerous.model;

import com.edwise.elitedangerous.bean.enums.Allegiance;
import lombok.Data;

@Data
public class SystemsQuery {

    private Allegiance allegiance;
    private Double closestDistance;
    private boolean withFactionsAndStations;
}

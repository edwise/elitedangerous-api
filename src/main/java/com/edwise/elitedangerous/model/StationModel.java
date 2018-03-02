package com.edwise.elitedangerous.model;

import com.edwise.elitedangerous.bean.enums.Allegiance;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StationModel {

    private Integer id;
    private String name;
    private String maxLandingPadSize;
    private Integer distanceToStar;
    private Allegiance allegiance;
    private String state;
    private Boolean hasShipyard;
    private Boolean isPlanetary;
    private Integer controllingMinorFactionId;

    private String controllingMinorFaction;
}

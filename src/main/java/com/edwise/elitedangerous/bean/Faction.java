package com.edwise.elitedangerous.bean;

import com.edwise.elitedangerous.bean.enums.Allegiance;
import lombok.Data;

@Data
public class Faction {

    private Integer id;
    private String name;
    private Integer updatedAt;
    private Integer governmentId;
    private String government;
    private Integer allegianceId;
    private Allegiance allegiance;
    private Integer stateId;
    private String state;
    private Integer homeSystemId;
    private Boolean isPlayerFaction;
}

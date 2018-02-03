package com.edwise.elitedangerous.bean;

import com.edwise.elitedangerous.bean.enums.Allegiance;
import com.edwise.elitedangerous.bean.enums.Security;
import com.edwise.elitedangerous.bean.enums.State;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class System {

    @Data
    private class MinorFactionPresence {

        private Integer minorFactionId;
        private Integer stateId;
        private Double influence;
        private String state;
    }

    private Integer id;
    private Integer edsmId;
    private String name;
    private Double x;
    private Double y;
    private Double z;
    private Long population;
    private Boolean isPopulated;
    private Integer governmentId;
    private String government;
    private Integer allegianceId;
    private Allegiance allegiance;
    private Integer stateId;
    private State state;
    private Integer securityId;
    private Security security;
    private Integer primaryEconomyId;
    private String primaryEconomy;
    private String power;
    private String powerState;
    private Integer powerStateId;
    private Boolean needsPermit;
    private Integer updatedAt;
    private String simbadRef;
    private Integer controllingMinorFactionId;
    private String controllingMinorFaction;
    private Integer reserveTypeId;
    private String reserveType;
    private List<MinorFactionPresence> minorFactionPresences = new ArrayList<>();

    public double distanceTo(System otherSystem) {
        return Math.sqrt(Math.pow(x - otherSystem.getX(), 2)
                         + Math.pow(y - otherSystem.getY(), 2)
                         + Math.pow(z - otherSystem.getZ(), 2));
    }

}

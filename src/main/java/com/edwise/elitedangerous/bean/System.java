package com.edwise.elitedangerous.bean;

import com.edwise.elitedangerous.bean.enums.Allegiance;
import com.edwise.elitedangerous.bean.enums.Security;
import com.edwise.elitedangerous.bean.enums.State;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class System {

    @Data
    public static class MinorFactionPresence {

        @JsonProperty("minor_faction_id")
        private Integer minorFactionId;

        @JsonProperty("state_id")
        private Integer stateId;
        private Double influence;
        private String state;
    }

    private Integer id;

    @JsonProperty("edsm_id")
    private Integer edsmId;
    private String name;
    private Double x;
    private Double y;
    private Double z;
    private Long population;

    @JsonProperty("is_populated")
    private Boolean isPopulated;

    @JsonProperty("government_id")
    private Integer governmentId;
    private String government;

    @JsonProperty("allegiance_id")
    private Integer allegianceId;
    private Allegiance allegiance;

    @JsonProperty("state_id")
    private Integer stateId;
    private State state;

    @JsonProperty("security_id")
    private Integer securityId;
    private Security security;

    @JsonProperty("primary_economy_id")
    private Integer primaryEconomyId;

    @JsonProperty("primary_economy")
    private String primaryEconomy;
    private String power;

    @JsonProperty("power_state")
    private String powerState;

    @JsonProperty("power_state_id")
    private Integer powerStateId;

    @JsonProperty("needs_permit")
    private Boolean needsPermit;

    @JsonProperty("updated_at")
    private Integer updatedAt;

    @JsonProperty("simbad_ref")
    private String simbadRef;

    @JsonProperty("controlling_minor_faction_id")
    private Integer controllingMinorFactionId;

    @JsonProperty("controlling_minor_faction")
    private String controllingMinorFaction;

    @JsonProperty("reserve_type_id")
    private Integer reserveTypeId;

    @JsonProperty("reserve_type")
    private String reserveType;

    @JsonProperty("minor_faction_presences")
    private List<MinorFactionPresence> minorFactionPresences = new ArrayList<>();

    public double distanceTo(System otherSystem) {
        return Math.sqrt(Math.pow(x - otherSystem.getX(), 2)
                         + Math.pow(y - otherSystem.getY(), 2)
                         + Math.pow(z - otherSystem.getZ(), 2));
    }

}

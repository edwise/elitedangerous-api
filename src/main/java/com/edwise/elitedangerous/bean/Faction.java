package com.edwise.elitedangerous.bean;

import com.edwise.elitedangerous.bean.enums.Allegiance;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Faction {

    private Integer id;
    private String name;

    @JsonProperty("updated_at")
    private Integer updatedAt;

    @JsonProperty("government_id")
    private Integer governmentId;
    private String government;

    @JsonProperty("allegiance_id")
    private Integer allegianceId;
    private Allegiance allegiance;

    @JsonProperty("state_id")
    private Integer stateId;
    private String state;

    @JsonProperty("home_system_id")
    private Integer homeSystemId;

    @JsonProperty("is_player_faction")
    private Boolean isPlayerFaction;
}

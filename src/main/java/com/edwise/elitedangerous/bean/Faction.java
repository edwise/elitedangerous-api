package com.edwise.elitedangerous.bean;

import java.util.Objects;

public class Faction {

    private Integer id;
    private String  name;
    private Integer updatedAt;
    private Integer governmentId;
    private String  government;
    private Integer allegianceId;
    private String  allegiance;
    private Integer stateId;
    private String  state;
    private Integer homeSystemId;
    private Boolean isPlayerFaction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getGovernmentId() {
        return governmentId;
    }

    public void setGovernmentId(Integer governmentId) {
        this.governmentId = governmentId;
    }

    public String getGovernment() {
        return government;
    }

    public void setGovernment(String government) {
        this.government = government;
    }

    public Integer getAllegianceId() {
        return allegianceId;
    }

    public void setAllegianceId(Integer allegianceId) {
        this.allegianceId = allegianceId;
    }

    public String getAllegiance() {
        return allegiance;
    }

    public void setAllegiance(String allegiance) {
        this.allegiance = allegiance;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getHomeSystemId() {
        return homeSystemId;
    }

    public void setHomeSystemId(Integer homeSystemId) {
        this.homeSystemId = homeSystemId;
    }

    public Boolean getPlayerFaction() {
        return isPlayerFaction;
    }

    public void setPlayerFaction(Boolean playerFaction) {
        isPlayerFaction = playerFaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Faction faction = (Faction) o;
        return Objects.equals(id, faction.id) &&
               Objects.equals(name, faction.name) &&
               Objects.equals(updatedAt, faction.updatedAt) &&
               Objects.equals(governmentId, faction.governmentId) &&
               Objects.equals(government, faction.government) &&
               Objects.equals(allegianceId, faction.allegianceId) &&
               Objects.equals(allegiance, faction.allegiance) &&
               Objects.equals(stateId, faction.stateId) &&
               Objects.equals(state, faction.state) &&
               Objects.equals(homeSystemId, faction.homeSystemId) &&
               Objects.equals(isPlayerFaction, faction.isPlayerFaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, updatedAt, governmentId, government, allegianceId, allegiance, stateId, state, homeSystemId,
                            isPlayerFaction);
    }

    @Override
    public String toString() {
        return "Faction{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", updatedAt=" + updatedAt +
               ", governmentId=" + governmentId +
               ", government='" + government + '\'' +
               ", allegianceId=" + allegianceId +
               ", allegiance='" + allegiance + '\'' +
               ", stateId=" + stateId +
               ", state='" + state + '\'' +
               ", homeSystemId=" + homeSystemId +
               ", isPlayerFaction=" + isPlayerFaction +
               '}';
    }
}

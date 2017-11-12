package com.edwise.elitedangerous.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class System {

    class MinorFactionPresence {

        private Integer minorFactionId;
        private Integer stateId;
        private Double  influence;
        private String  state;

        public Integer getMinorFactionId() {
            return minorFactionId;
        }

        public void setMinorFactionId(Integer minorFactionId) {
            this.minorFactionId = minorFactionId;
        }

        public Integer getStateId() {
            return stateId;
        }

        public void setStateId(Integer stateId) {
            this.stateId = stateId;
        }

        public Double getInfluence() {
            return influence;
        }

        public void setInfluence(Double influence) {
            this.influence = influence;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MinorFactionPresence that = (MinorFactionPresence) o;
            return Objects.equals(minorFactionId, that.minorFactionId) &&
                   Objects.equals(stateId, that.stateId) &&
                   Objects.equals(influence, that.influence) &&
                   Objects.equals(state, that.state);
        }

        @Override
        public int hashCode() {
            return Objects.hash(minorFactionId, stateId, influence, state);
        }

        @Override
        public String toString() {
            return "MinorFactionPresence{" +
                   "minorFactionId=" + minorFactionId +
                   ", stateId=" + stateId +
                   ", influence=" + influence +
                   ", state='" + state + '\'' +
                   '}';
        }
    }

    private Integer id;
    private Integer edsmId;
    private String  name;
    private Double  x;
    private Double  y;
    private Double  z;
    private Long    population;
    private Boolean isPopulated;
    private Integer governmentId;
    private String  government;
    private Integer allegianceId;
    private String  allegiance;
    private Integer stateId;
    private String  state;
    private Integer securityId;
    private String  security;
    private Integer primaryEconomyId;
    private String  primaryEconomy;
    private String  power;
    private String  powerState;
    private Integer powerStateId;
    private Boolean needsPermit;
    private Integer updatedAt;
    private String  simbadRef;
    private Integer controllingMinorFactionId;
    private String  controllingMinorFaction;
    private Integer reserveTypeId;
    private String  reserveType;
    private List<MinorFactionPresence> minorFactionPresences = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEdsmId() {
        return edsmId;
    }

    public void setEdsmId(Integer edsmId) {
        this.edsmId = edsmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Boolean getPopulated() {
        return isPopulated;
    }

    public void setPopulated(Boolean populated) {
        isPopulated = populated;
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

    public Integer getSecurityId() {
        return securityId;
    }

    public void setSecurityId(Integer securityId) {
        this.securityId = securityId;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public Integer getPrimaryEconomyId() {
        return primaryEconomyId;
    }

    public void setPrimaryEconomyId(Integer primaryEconomyId) {
        this.primaryEconomyId = primaryEconomyId;
    }

    public String getPrimaryEconomy() {
        return primaryEconomy;
    }

    public void setPrimaryEconomy(String primaryEconomy) {
        this.primaryEconomy = primaryEconomy;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getPowerState() {
        return powerState;
    }

    public void setPowerState(String powerState) {
        this.powerState = powerState;
    }

    public Integer getPowerStateId() {
        return powerStateId;
    }

    public void setPowerStateId(Integer powerStateId) {
        this.powerStateId = powerStateId;
    }

    public Boolean getNeedsPermit() {
        return needsPermit;
    }

    public void setNeedsPermit(Boolean needsPermit) {
        this.needsPermit = needsPermit;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSimbadRef() {
        return simbadRef;
    }

    public void setSimbadRef(String simbadRef) {
        this.simbadRef = simbadRef;
    }

    public Integer getControllingMinorFactionId() {
        return controllingMinorFactionId;
    }

    public void setControllingMinorFactionId(Integer controllingMinorFactionId) {
        this.controllingMinorFactionId = controllingMinorFactionId;
    }

    public String getControllingMinorFaction() {
        return controllingMinorFaction;
    }

    public void setControllingMinorFaction(String controllingMinorFaction) {
        this.controllingMinorFaction = controllingMinorFaction;
    }

    public Integer getReserveTypeId() {
        return reserveTypeId;
    }

    public void setReserveTypeId(Integer reserveTypeId) {
        this.reserveTypeId = reserveTypeId;
    }

    public String getReserveType() {
        return reserveType;
    }

    public void setReserveType(String reserveType) {
        this.reserveType = reserveType;
    }

    public List<MinorFactionPresence> getMinorFactionPresences() {
        return minorFactionPresences;
    }

    public void setMinorFactionPresences(List<MinorFactionPresence> minorFactionPresences) {
        this.minorFactionPresences = minorFactionPresences;
    }

    public double distanceTo(System otherSystem) {
        return Math.sqrt(Math.pow(x - otherSystem.getX(), 2)
                         + Math.pow(y - otherSystem.getY(), 2)
                         + Math.pow(z - otherSystem.getZ(), 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        System system = (System) o;
        return Objects.equals(id, system.id) &&
               Objects.equals(edsmId, system.edsmId) &&
               Objects.equals(name, system.name) &&
               Objects.equals(x, system.x) &&
               Objects.equals(y, system.y) &&
               Objects.equals(z, system.z) &&
               Objects.equals(population, system.population) &&
               Objects.equals(isPopulated, system.isPopulated) &&
               Objects.equals(governmentId, system.governmentId) &&
               Objects.equals(government, system.government) &&
               Objects.equals(allegianceId, system.allegianceId) &&
               Objects.equals(allegiance, system.allegiance) &&
               Objects.equals(stateId, system.stateId) &&
               Objects.equals(state, system.state) &&
               Objects.equals(securityId, system.securityId) &&
               Objects.equals(security, system.security) &&
               Objects.equals(primaryEconomyId, system.primaryEconomyId) &&
               Objects.equals(primaryEconomy, system.primaryEconomy) &&
               Objects.equals(power, system.power) &&
               Objects.equals(powerState, system.powerState) &&
               Objects.equals(powerStateId, system.powerStateId) &&
               Objects.equals(needsPermit, system.needsPermit) &&
               Objects.equals(updatedAt, system.updatedAt) &&
               Objects.equals(simbadRef, system.simbadRef) &&
               Objects.equals(controllingMinorFactionId, system.controllingMinorFactionId) &&
               Objects.equals(controllingMinorFaction, system.controllingMinorFaction) &&
               Objects.equals(reserveTypeId, system.reserveTypeId) &&
               Objects.equals(reserveType, system.reserveType) &&
               Objects.equals(minorFactionPresences, system.minorFactionPresences);
    }

    @Override
    public int hashCode() {
        return Objects
                .hash(id, edsmId, name, x, y, z, population, isPopulated, governmentId, government, allegianceId, allegiance,
                      stateId,
                      state, securityId, security, primaryEconomyId, primaryEconomy, power, powerState, powerStateId, needsPermit,
                      updatedAt, simbadRef, controllingMinorFactionId, controllingMinorFaction, reserveTypeId, reserveType,
                      minorFactionPresences);
    }

    @Override
    public String toString() {
        return "System{" +
               "id=" + id +
               ", edsmId=" + edsmId +
               ", name='" + name + '\'' +
               ", x=" + x +
               ", y=" + y +
               ", z=" + z +
               ", population=" + population +
               ", isPopulated=" + isPopulated +
               ", governmentId=" + governmentId +
               ", government='" + government + '\'' +
               ", allegianceId=" + allegianceId +
               ", allegiance='" + allegiance + '\'' +
               ", stateId=" + stateId +
               ", state='" + state + '\'' +
               ", securityId=" + securityId +
               ", security='" + security + '\'' +
               ", primaryEconomyId=" + primaryEconomyId +
               ", primaryEconomy='" + primaryEconomy + '\'' +
               ", power='" + power + '\'' +
               ", powerState='" + powerState + '\'' +
               ", powerStateId=" + powerStateId +
               ", needsPermit=" + needsPermit +
               ", updatedAt=" + updatedAt +
               ", simbadRef='" + simbadRef + '\'' +
               ", controllingMinorFactionId=" + controllingMinorFactionId +
               ", controllingMinorFaction='" + controllingMinorFaction + '\'' +
               ", reserveTypeId=" + reserveTypeId +
               ", reserveType='" + reserveType + '\'' +
               ", minorFactionPresences=" + minorFactionPresences +
               '}';
    }
}

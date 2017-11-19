package com.edwise.elitedangerous.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Station {

    private Integer id;
    private String name;
    private Integer systemId;
    private Integer updatedAt;
    private String maxLandingPadSize;
    private Integer distanceToStar;
    private Integer governmentId;
    private String government;
    private Integer allegianceId;
    private String allegiance;
    private Integer stateId;
    private String state;
    private Integer typeId;
    private String type;
    private Boolean hasBlackmarket;
    private Boolean hasMarket;
    private Boolean hasRefuel;
    private Boolean hasRepair;
    private Boolean hasRearm;
    private Boolean hasOutfitting;
    private Boolean hasShipyard;
    private Boolean hasDocking;
    private Boolean hasCommodities;
    private List<String> importCommodities = new ArrayList<>();
    private List<String> exportCommodities = new ArrayList<>();
    private List<String> prohibitedCommodities = new ArrayList<>();
    private List<String> economies = new ArrayList<>();
    private Integer shipyardUpdatedAt;
    private Integer outfittingUpdatedAt;
    private Integer marketUpdatedAt;
    private Boolean isPlanetary;
    private List<String> sellingShips = new ArrayList<>();
    private List<Integer> sellingModules = new ArrayList<>();
    private Object settlementSizeId;
    private Object settlementSize;
    private Object settlementSecurityId;
    private Object settlementSecurity;
    private Integer bodyId;
    private Integer controllingMinorFactionId;

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

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getMaxLandingPadSize() {
        return maxLandingPadSize;
    }

    public void setMaxLandingPadSize(String maxLandingPadSize) {
        this.maxLandingPadSize = maxLandingPadSize;
    }

    public Integer getDistanceToStar() {
        return distanceToStar;
    }

    public void setDistanceToStar(Integer distanceToStar) {
        this.distanceToStar = distanceToStar;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getHasBlackmarket() {
        return hasBlackmarket;
    }

    public void setHasBlackmarket(Boolean hasBlackmarket) {
        this.hasBlackmarket = hasBlackmarket;
    }

    public Boolean getHasMarket() {
        return hasMarket;
    }

    public void setHasMarket(Boolean hasMarket) {
        this.hasMarket = hasMarket;
    }

    public Boolean getHasRefuel() {
        return hasRefuel;
    }

    public void setHasRefuel(Boolean hasRefuel) {
        this.hasRefuel = hasRefuel;
    }

    public Boolean getHasRepair() {
        return hasRepair;
    }

    public void setHasRepair(Boolean hasRepair) {
        this.hasRepair = hasRepair;
    }

    public Boolean getHasRearm() {
        return hasRearm;
    }

    public void setHasRearm(Boolean hasRearm) {
        this.hasRearm = hasRearm;
    }

    public Boolean getHasOutfitting() {
        return hasOutfitting;
    }

    public void setHasOutfitting(Boolean hasOutfitting) {
        this.hasOutfitting = hasOutfitting;
    }

    public Boolean getHasShipyard() {
        return hasShipyard;
    }

    public void setHasShipyard(Boolean hasShipyard) {
        this.hasShipyard = hasShipyard;
    }

    public Boolean getHasDocking() {
        return hasDocking;
    }

    public void setHasDocking(Boolean hasDocking) {
        this.hasDocking = hasDocking;
    }

    public Boolean getHasCommodities() {
        return hasCommodities;
    }

    public void setHasCommodities(Boolean hasCommodities) {
        this.hasCommodities = hasCommodities;
    }

    public List<String> getImportCommodities() {
        return importCommodities;
    }

    public void setImportCommodities(List<String> importCommodities) {
        this.importCommodities = importCommodities;
    }

    public List<String> getExportCommodities() {
        return exportCommodities;
    }

    public void setExportCommodities(List<String> exportCommodities) {
        this.exportCommodities = exportCommodities;
    }

    public List<String> getProhibitedCommodities() {
        return prohibitedCommodities;
    }

    public void setProhibitedCommodities(List<String> prohibitedCommodities) {
        this.prohibitedCommodities = prohibitedCommodities;
    }

    public List<String> getEconomies() {
        return economies;
    }

    public void setEconomies(List<String> economies) {
        this.economies = economies;
    }

    public Integer getShipyardUpdatedAt() {
        return shipyardUpdatedAt;
    }

    public void setShipyardUpdatedAt(Integer shipyardUpdatedAt) {
        this.shipyardUpdatedAt = shipyardUpdatedAt;
    }

    public Integer getOutfittingUpdatedAt() {
        return outfittingUpdatedAt;
    }

    public void setOutfittingUpdatedAt(Integer outfittingUpdatedAt) {
        this.outfittingUpdatedAt = outfittingUpdatedAt;
    }

    public Integer getMarketUpdatedAt() {
        return marketUpdatedAt;
    }

    public void setMarketUpdatedAt(Integer marketUpdatedAt) {
        this.marketUpdatedAt = marketUpdatedAt;
    }

    public Boolean getPlanetary() {
        return isPlanetary;
    }

    public void setPlanetary(Boolean planetary) {
        isPlanetary = planetary;
    }

    public List<String> getSellingShips() {
        return sellingShips;
    }

    public void setSellingShips(List<String> sellingShips) {
        this.sellingShips = sellingShips;
    }

    public List<Integer> getSellingModules() {
        return sellingModules;
    }

    public void setSellingModules(List<Integer> sellingModules) {
        this.sellingModules = sellingModules;
    }

    public Object getSettlementSizeId() {
        return settlementSizeId;
    }

    public void setSettlementSizeId(Object settlementSizeId) {
        this.settlementSizeId = settlementSizeId;
    }

    public Object getSettlementSize() {
        return settlementSize;
    }

    public void setSettlementSize(Object settlementSize) {
        this.settlementSize = settlementSize;
    }

    public Object getSettlementSecurityId() {
        return settlementSecurityId;
    }

    public void setSettlementSecurityId(Object settlementSecurityId) {
        this.settlementSecurityId = settlementSecurityId;
    }

    public Object getSettlementSecurity() {
        return settlementSecurity;
    }

    public void setSettlementSecurity(Object settlementSecurity) {
        this.settlementSecurity = settlementSecurity;
    }

    public Integer getBodyId() {
        return bodyId;
    }

    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public Integer getControllingMinorFactionId() {
        return controllingMinorFactionId;
    }

    public void setControllingMinorFactionId(Integer controllingMinorFactionId) {
        this.controllingMinorFactionId = controllingMinorFactionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Station station = (Station) o;
        return Objects.equals(id, station.id) &&
               Objects.equals(name, station.name) &&
               Objects.equals(systemId, station.systemId) &&
               Objects.equals(updatedAt, station.updatedAt) &&
               Objects.equals(maxLandingPadSize, station.maxLandingPadSize) &&
               Objects.equals(distanceToStar, station.distanceToStar) &&
               Objects.equals(governmentId, station.governmentId) &&
               Objects.equals(government, station.government) &&
               Objects.equals(allegianceId, station.allegianceId) &&
               Objects.equals(allegiance, station.allegiance) &&
               Objects.equals(stateId, station.stateId) &&
               Objects.equals(state, station.state) &&
               Objects.equals(typeId, station.typeId) &&
               Objects.equals(type, station.type) &&
               Objects.equals(hasBlackmarket, station.hasBlackmarket) &&
               Objects.equals(hasMarket, station.hasMarket) &&
               Objects.equals(hasRefuel, station.hasRefuel) &&
               Objects.equals(hasRepair, station.hasRepair) &&
               Objects.equals(hasRearm, station.hasRearm) &&
               Objects.equals(hasOutfitting, station.hasOutfitting) &&
               Objects.equals(hasShipyard, station.hasShipyard) &&
               Objects.equals(hasDocking, station.hasDocking) &&
               Objects.equals(hasCommodities, station.hasCommodities) &&
               Objects.equals(importCommodities, station.importCommodities) &&
               Objects.equals(exportCommodities, station.exportCommodities) &&
               Objects.equals(prohibitedCommodities, station.prohibitedCommodities) &&
               Objects.equals(economies, station.economies) &&
               Objects.equals(shipyardUpdatedAt, station.shipyardUpdatedAt) &&
               Objects.equals(outfittingUpdatedAt, station.outfittingUpdatedAt) &&
               Objects.equals(marketUpdatedAt, station.marketUpdatedAt) &&
               Objects.equals(isPlanetary, station.isPlanetary) &&
               Objects.equals(sellingShips, station.sellingShips) &&
               Objects.equals(sellingModules, station.sellingModules) &&
               Objects.equals(settlementSizeId, station.settlementSizeId) &&
               Objects.equals(settlementSize, station.settlementSize) &&
               Objects.equals(settlementSecurityId, station.settlementSecurityId) &&
               Objects.equals(settlementSecurity, station.settlementSecurity) &&
               Objects.equals(bodyId, station.bodyId) &&
               Objects.equals(controllingMinorFactionId, station.controllingMinorFactionId);
    }

    @Override
    public int hashCode() {
        return Objects
                .hash(id, name, systemId, updatedAt, maxLandingPadSize, distanceToStar, governmentId, government, allegianceId,
                      allegiance, stateId, state, typeId, type, hasBlackmarket, hasMarket, hasRefuel, hasRepair, hasRearm,
                      hasOutfitting, hasShipyard, hasDocking, hasCommodities, importCommodities, exportCommodities,
                      prohibitedCommodities, economies, shipyardUpdatedAt, outfittingUpdatedAt, marketUpdatedAt, isPlanetary,
                      sellingShips, sellingModules, settlementSizeId, settlementSize, settlementSecurityId, settlementSecurity,
                      bodyId, controllingMinorFactionId);
    }

    @Override
    public String toString() {
        return "Station{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", systemId=" + systemId +
               ", updatedAt=" + updatedAt +
               ", maxLandingPadSize='" + maxLandingPadSize + '\'' +
               ", distanceToStar=" + distanceToStar +
               ", governmentId=" + governmentId +
               ", government='" + government + '\'' +
               ", allegianceId=" + allegianceId +
               ", allegiance='" + allegiance + '\'' +
               ", stateId=" + stateId +
               ", state='" + state + '\'' +
               ", typeId=" + typeId +
               ", type='" + type + '\'' +
               ", hasBlackmarket=" + hasBlackmarket +
               ", hasMarket=" + hasMarket +
               ", hasRefuel=" + hasRefuel +
               ", hasRepair=" + hasRepair +
               ", hasRearm=" + hasRearm +
               ", hasOutfitting=" + hasOutfitting +
               ", hasShipyard=" + hasShipyard +
               ", hasDocking=" + hasDocking +
               ", hasCommodities=" + hasCommodities +
               ", importCommodities=" + importCommodities +
               ", exportCommodities=" + exportCommodities +
               ", prohibitedCommodities=" + prohibitedCommodities +
               ", economies=" + economies +
               ", shipyardUpdatedAt=" + shipyardUpdatedAt +
               ", outfittingUpdatedAt=" + outfittingUpdatedAt +
               ", marketUpdatedAt=" + marketUpdatedAt +
               ", isPlanetary=" + isPlanetary +
               ", sellingShips=" + sellingShips +
               ", sellingModules=" + sellingModules +
               ", settlementSizeId=" + settlementSizeId +
               ", settlementSize=" + settlementSize +
               ", settlementSecurityId=" + settlementSecurityId +
               ", settlementSecurity=" + settlementSecurity +
               ", bodyId=" + bodyId +
               ", controllingMinorFactionId=" + controllingMinorFactionId +
               '}';
    }
}

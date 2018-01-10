package com.edwise.elitedangerous.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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
}

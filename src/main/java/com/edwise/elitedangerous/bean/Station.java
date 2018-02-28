package com.edwise.elitedangerous.bean;

import com.edwise.elitedangerous.bean.enums.Allegiance;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Station {

    private Integer id;
    private String name;

    @JsonProperty("system_id")
    private Integer systemId;

    @JsonProperty("updated_at")
    private Integer updatedAt;

    @JsonProperty("max_landing_pad_size")
    private String maxLandingPadSize;

    @JsonProperty("distance_to_star")
    private Integer distanceToStar;

    @JsonProperty("government_id")
    private Integer governmentId;
    private String government;

    @JsonProperty("allegiance_id")
    private Integer allegianceId;
    private Allegiance allegiance;

    @JsonProperty("state_id")
    private Integer stateId;
    private String state;

    @JsonProperty("type_id")
    private Integer typeId;
    private String type;

    @JsonProperty("has_blackmarket")
    private Boolean hasBlackmarket;

    @JsonProperty("has_market")
    private Boolean hasMarket;

    @JsonProperty("has_refuel")
    private Boolean hasRefuel;

    @JsonProperty("has_repair")
    private Boolean hasRepair;

    @JsonProperty("has_rearm")
    private Boolean hasRearm;

    @JsonProperty("has_outfitting")
    private Boolean hasOutfitting;

    @JsonProperty("has_shipyard")
    private Boolean hasShipyard;

    @JsonProperty("has_docking")
    private Boolean hasDocking;

    @JsonProperty("has_commodities")
    private Boolean hasCommodities;

    @JsonProperty("import_commodities")
    private List<String> importCommodities = new ArrayList<>();

    @JsonProperty("export_commodities")
    private List<String> exportCommodities = new ArrayList<>();

    @JsonProperty("prohibited_commodities")
    private List<String> prohibitedCommodities = new ArrayList<>();
    private List<String> economies = new ArrayList<>();

    @JsonProperty("shipyard_updated_at")
    private Integer shipyardUpdatedAt;

    @JsonProperty("outfitting_updated_at")
    private Integer outfittingUpdatedAt;

    @JsonProperty("market_updated_at")
    private Integer marketUpdatedAt;

    @JsonProperty("is_planetary")
    private Boolean isPlanetary;

    @JsonProperty("selling_ships")
    private List<String> sellingShips = new ArrayList<>();

    @JsonProperty("selling_modules")
    private List<Integer> sellingModules = new ArrayList<>();

    @JsonProperty("settlement_size_id")
    private Object settlementSizeId;

    @JsonProperty("settlement_size")
    private Object settlementSize;

    @JsonProperty("settlement_security_id")
    private Object settlementSecurityId;

    @JsonProperty("settlement_security")
    private Object settlementSecurity;

    @JsonProperty("body_id")
    private Integer bodyId;

    @JsonProperty("controlling_minor_faction_id")
    private Integer controllingMinorFactionId;
}

package com.edwise.elitedangerous.model;

import com.edwise.elitedangerous.bean.enums.Allegiance;
import com.edwise.elitedangerous.bean.enums.Security;
import com.edwise.elitedangerous.bean.enums.State;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SystemModel {

    private Integer id;
    private String name;
    private Allegiance allegiance;
    private State state;
    private Security security;
    private Long population;

    private List<FactionModel> factions;
    private List<StationModel> stations;
}

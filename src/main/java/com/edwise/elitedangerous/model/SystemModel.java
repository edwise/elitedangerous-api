package com.edwise.elitedangerous.model;

import com.edwise.elitedangerous.bean.enums.Allegiance;
import com.edwise.elitedangerous.bean.enums.Security;
import com.edwise.elitedangerous.bean.enums.State;
import lombok.Data;

@Data
public class SystemModel {

    private Integer id;
    private String name;
    private Allegiance allegiance;
    private State state;
    private Security security;
    private Long population;
}

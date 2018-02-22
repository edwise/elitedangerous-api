package com.edwise.elitedangerous.model;

import com.edwise.elitedangerous.bean.enums.Allegiance;
import lombok.Data;

@Data
public class FactionModel {

    private Integer id;
    private String name;
    private Allegiance allegiance;
    private String state;
}

package com.edwise.elitedangerous.bean.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public enum Security {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High"),
    ANARCHY("Anarchy"),
    LAWLESS("Lawless");

    private String name;

    Security(String name) {
        this.name = name;
    }

    @JsonCreator
    public static Security getEnumFromValue(String name) {
        return Stream.of(values())
                     .filter(security -> security.name.equalsIgnoreCase(name))
                     .findFirst()
                     .orElseGet(() -> {
                         log.warn("Security not exists: " + name);
                         return null;
                     });
    }

    @JsonValue
    @Override
    public String toString() {
        return name;
    }
}

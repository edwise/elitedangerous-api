package com.edwise.elitedangerous.bean.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public enum Allegiance {
    FEDERATION("Federation"),
    EMPIRE("Empire"),
    ALLIANCE("Alliance"),
    INDEPENDENT("Independent"),
    PILOTS_FEDERATION("Pilots Federation");

    private String name;

    Allegiance(String name) {
        this.name = name;
    }

    @JsonCreator
    public static Allegiance getEnumFromValue(String name) {
        return Stream.of(values())
                     .filter(allegiance -> allegiance.name.equalsIgnoreCase(name))
                     .findFirst()
                     .orElseGet(() -> {
                         log.warn("Allegiance not exists: " + name);
                         return null;
                     });
    }

    @JsonValue
    @Override
    public String toString() {
        return name;
    }
}

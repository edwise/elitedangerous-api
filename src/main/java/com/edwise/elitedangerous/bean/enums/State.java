package com.edwise.elitedangerous.bean.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public enum State {
    BOOM("Boom"),
    BUST("Bust"),
    FAMINE("Famine"),
    CIVIL_UNREST("Civil Unrest"),
    CIVIL_WAR("Civil War"),
    ELECTION("Election"),
    EXPANSION("Expansion"),
    LOCKDOWN("Lockdown"),
    OUTBREAK("Outbreak"),
    WAR("War"),
    RETREAT("Retreat"),
    INVESTMENT("Investment"),
    NONE("None");

    private String name;

    State(String name) {
        this.name = name;
    }

    @JsonCreator
    public static State getEnumFromValue(String name) {
        return Stream.of(values())
                     .filter(state -> state.name.equalsIgnoreCase(name))
                     .findFirst()
                     .orElseGet(() -> {
                         log.warn("State not exists: " + name);
                         return null;
                     });
    }

    @JsonValue
    @Override
    public String toString() {
        return name;
    }
}

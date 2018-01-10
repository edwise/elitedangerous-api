package com.edwise.elitedangerous.model;

import lombok.Data;

import java.util.Objects;

@Data
public class SystemPairModel {

    private SystemModel systemA;
    private SystemModel systemB;

    public SystemPairModel(SystemModel systemA, SystemModel systemB) {
        this.systemA = systemA;
        this.systemB = systemB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SystemPairModel that = (SystemPairModel) o;
        return Objects.equals(systemA, that.systemA) &&
               Objects.equals(systemB, that.systemB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemA, systemB);
    }

}

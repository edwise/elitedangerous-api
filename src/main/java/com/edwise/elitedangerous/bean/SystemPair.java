package com.edwise.elitedangerous.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemPair {

    private System systemA;
    private System systemB;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SystemPair that = (SystemPair) o;
        return (Objects.equals(systemA, that.systemA) &&
                Objects.equals(systemB, that.systemB)) ||
               (Objects.equals(systemB, that.systemA) &&
                Objects.equals(systemA, that.systemB));
    }

    @Override
    public int hashCode() {
        int hash = 17;
        int hashMultiplikator = 79;
        int hashSum = systemA.hashCode() + systemB.hashCode();
        hash = hashMultiplikator * hash * hashSum;
        return hash;
    }
}

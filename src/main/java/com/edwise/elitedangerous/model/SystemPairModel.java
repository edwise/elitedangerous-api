package com.edwise.elitedangerous.model;

import java.util.Objects;

/**
 * Created by Eduardo Antón <eduardo.anton@taptapnetworks.com> on 03/01/2018.
 */
public class SystemPairModel {

    private SystemModel systemA;
    private SystemModel systemB;

    public SystemPairModel(SystemModel systemA, SystemModel systemB) {
        this.systemA = systemA;
        this.systemB = systemB;
    }

    public SystemModel getSystemA() {
        return systemA;
    }

    public void setSystemA(SystemModel systemA) {
        this.systemA = systemA;
    }

    public SystemModel getSystemB() {
        return systemB;
    }

    public void setSystemB(SystemModel systemB) {
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

    @Override
    public String toString() {
        return "SystemPairModel{" +
               "systemA=" + systemA +
               ", systemB=" + systemB +
               '}';
    }
}

package com.edwise.elitedangerous.bean;

import java.util.Objects;

public class SystemPair {

    private System systemA;
    private System systemB;

    public SystemPair(System systemA, System systemB) {
        this.systemA = systemA;
        this.systemB = systemB;
    }

    public System getSystemA() {
        return systemA;
    }

    public void setSystemA(System systemA) {
        this.systemA = systemA;
    }

    public System getSystemB() {
        return systemB;
    }

    public void setSystemB(System systemB) {
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

    @Override
    public String toString() {
        return "SystemPair{" +
               "systemA=" + systemA +
               ", systemB=" + systemB +
               '}';
    }
}

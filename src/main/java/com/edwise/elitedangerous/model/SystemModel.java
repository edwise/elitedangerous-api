package com.edwise.elitedangerous.model;

import java.util.Objects;

public class SystemModel {

    private Integer id;
    private String name;
    private String allegiance;
    private String state;
    private String security;
    private Long population;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllegiance() {
        return allegiance;
    }

    public void setAllegiance(String allegiance) {
        this.allegiance = allegiance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SystemModel that = (SystemModel) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(name, that.name) &&
               Objects.equals(allegiance, that.allegiance) &&
               Objects.equals(state, that.state) &&
               Objects.equals(security, that.security) &&
               Objects.equals(population, that.population);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, allegiance, state, security, population);
    }

    @Override
    public String toString() {
        return "SystemModel{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", allegiance='" + allegiance + '\'' +
               ", state='" + state + '\'' +
               ", security='" + security + '\'' +
               ", population=" + population +
               '}';
    }
}

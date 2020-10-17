package com.meli.lv3.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticsDNA {

    @JsonProperty("count_human_dna")
    private int totalHuman;

    @JsonProperty("count_mutant_dna")
    private int totalMutant;

    @JsonProperty("ratio")
    public double getRatio() {
        return (double) totalMutant / totalHuman;
    }

    public int getTotalMutant() {
        return totalMutant;
    }

    public void setTotalMutant(int totalMutant) {
        this.totalMutant = totalMutant;
    }

    public int getTotalHuman() {
        return totalHuman;
    }

    public void setTotalHuman(int totalHuman) {
        this.totalHuman = totalHuman;
    }
}

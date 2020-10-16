package com.meli.lv3.db.entity;

import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "dna_checked")
public class DNA {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @Column
    private String dna;

    @Column
    private boolean isMutant;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIsMutant() {
        return isMutant;
    }

    public void setIsMutant(boolean isMutant) {
        this.isMutant = isMutant;
    }

    public String[] getDna() {
        if (StringUtils.isEmpty(dna)) {
            return new String[]{};
        }

        return dna.split(",");
    }

    public void setDna(String dna) {
        this.dna = dna;
    }
}

package com.meli.lv1.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MutantCheckerTest {

    @Test
    public void test_horizontal_firt_have_one() {
//        String[] dna = {"A T G C G A",
//                        "C A G T G C",
//                        "T T A T G T",
//                        "A G A A G G",
//                        "C C C C T A",
//                        "T C A C T G"};

        String[] dna = {"A T T T T A",
                "C A G T G C",
                "T T A T G T",
                "A G A A G G",
                "C C C C T A",
                "T C A C T G"};

        for (int i = 0; i < dna.length; i++){
            dna[i] = dna[i].replaceAll("\\W", "");
        }
        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void test_horizonatl_firtHaveTwo() {
        String[] dna = {"A T T T T G G G G A" ,
                "C A G T G C",
                "T T A T G T",
                "A G A A G G",
                "C C C C T A",
                "T C A C T G"};

        for (int i = 0; i < dna.length; i++){
            dna[i] = dna[i].replaceAll("\\W", "");
        }
        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void test_horizontal_lastHaveTwo() {
        String[] dna = {
                "A T T C T G G G C A G T" ,
                "C A G T G C C A G T G C",
                "T T A T G T T T A T G T",
                "A G A A G G A G A A G G",
                "C C A C T A C C A C T A",
                "T C A C T G T C A C T G",
                "A G A A G G A G A A G G",
                "C C A C T A C A C C T A",
                "T C A C T G T C A C T G",
                "T C A C T G T C A C T G",
                "T C A C T G T C A C T G",
                "T T T T T T T C G G G G"};

        for (int i = 0; i < dna.length; i++){
            dna[i] = dna[i].replaceAll("\\W", "");
        }
        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void test_horizontal_lastFirstAndLastHave1() {
        String[] dna = {
                "A T T C T G G G G A G T" ,
                "C A G T G C C A G T G C",
                "T T A T G T T T A T G T",
                "A G A A G G A G A A G G",
                "C C A C T A C C A C T A",
                "T C A C T G T C A C T G",
                "A G A A G G A G A A G G",
                "C C A C T A C A C C T A",
                "T C A C T G T C A C T G",
                "T C A C T G T C A C T G",
                "T C A C T G T C A C T G",
                "T T A T T A T C G G G G"};

        for (int i = 0; i < dna.length; i++){
            dna[i] = dna[i].replaceAll("\\W", "");
        }
        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void test_horizontal_onlyOne() {
        String[] dna = {
                "A T T C T G G G T A G T" ,
                "C A G T G C C A G T G C",
                "T T A T G T T T A T G T",
                "A G A A G G A G A A G G",
                "C C A C T A C C A C T A",
                "T C A C T G T C A C T G",
                "A G A A G G A G A A G G",
                "C C A C T A C A C C T A",
                "T C A C T G T C A C T G",
                "T C A C T G T C A C T G",
                "T C A C T G T C A C T G",
                "T T A T T A T C G G G G"};

        for (int i = 0; i < dna.length; i++){
            dna[i] = dna[i].replaceAll("\\W", "");
        }
        boolean result = MutantChecker.isMutant(dna);

        assertFalse(result);
    }

    @Test
    public void test_vertical_firt_have_one() {
        String[] dna = {"A T G C G A",
                        "C A A T G C",
                        "C T A T G T",
                        "C G A A G G",
                        "C C A C T A",
                        "T C A C T G"};

        for (int i = 0; i < dna.length; i++){
            dna[i] = dna[i].replaceAll("\\W", "");
        }
        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void test_vertical_firt_have_two() {
        String[] dna = {"A T G C G A T G C G A A",
                "C A A T G C T G C G A A",
                "C T A T G T T A T G T T",
                "C G G A G G G A T G T A",
                "C C A C T A C C A C A A",
                "T C A C T G C T A C T A",
                "A T G C G A C C T A T T",
                "C A A T T C C T A C A A",
                "C T G T G T C C A C T T",
                "C G A A G G C T T A T A",
                "C C A C T A C C A C A A",
                "T C A C T G C C A C T A"};

        for (int i = 0; i < dna.length; i++){
            dna[i] = dna[i].replaceAll("\\W", "");
        }
        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void test_vertical_firtAndLast_have_One() {
        String[] dna = {"A T G C G A T G C G A A",
                        "C A A T G C T G C A A A",
                        "C T A T A T T A T G T T",
                        "A G G A G G G A T G T A",
                        "C C A C T A C C A C A A",
                        "T C A C T G A T A C T A",
                        "A T G C G A C C T A T T",
                        "C A A T T C C T A C A A",
                        "C T G T G T C C A C T A",
                        "C G A A G G A T T A T A",
                        "C C A C T A C C A C A A",
                        "T C A C T G C C A C T A"};

        for (int i = 0; i < dna.length; i++){
            dna[i] = dna[i].replaceAll("\\W", "");
        }
        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }


}
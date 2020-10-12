package com.meli.lv1.service;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MutantCheckerTest {


    public void testMeliExample() {
        String[] dna = {
                "A T G C G A",
                "C A G T G C",
                "T T A T G T",
                "A G A A G G",
                "C C C C T A",
                "T C A C T G"};
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void testIsNoMutant_onlyOneCoincidence() {
        String[] dna = {
                "A T G C G A",
                "C A G T G C",
                "T T A T A T",
                "A G A A G G",
                "C G C C T A",
                "T C A C T G"};
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertFalse(result);
    }

    @Test
    public void testIsNoMutant_noCoincidence() {
        String[] dna = {
                "A T G C G A",
                "C A G T G C",
                "T T G T A T",
                "A G A A G G",
                "C G C C T A",
                "T C A C T G"};
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertFalse(result);
    }

    @Test
    public void testIsNoMutant_noCoincidenceBig() {
        String[] dna = {
                "A T G C G A A T G C G A",
                "C A G T G C C A G T G C",
                "T T G T A T T T G T A T",
                "A G A A G G A G A A G G",
                "C G C C T A C G C C T A",
                "T C A C T G T C A C T G",
                "A T G C G A A T G C G A",
                "C A G T G C C A G T G C",
                "T T G T A T T T G T A T",
                "A G A A G G A G A A G G",
                "C G C C T A C G C C T A",
                "T C A C T G T C A C T G"
        };
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertFalse(result);
    }

    @Test
    public void testIsNoMutant_noCoincidenceBig_manyWith3() {
        String[] dna = {
                "A T T A T A A A T T T A",
                "G G G C G G G C C C G C",
                "A A A T A T T T A T T T",
                "A G A A G G A G A A G G",
                "C A C C T A C A C C T A",
                "T C A C T G T C A C T A",
                "A T G C G T A T G C G A",
                "C A G T T C C A G T G C",
                "T T G A A C T T G T A C",
                "A G T A G G A G A A A C",
                "C T C C T A C C C C T A",
                "T C A C T G T C C C T G"
        };
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertFalse(result);
    }

    @Test
    public void testIsNoMutant_twoConsecutiveHorizontal() {
        String[] dna = {
                "A T G C G A A T G C G A",
                "C A G T G C C A G T G C",
                "T T G T A T T T G T A T",
                "A G A A G G A G A A G G",
                "C G C C T A C G C C T A",
                "T C A C T G T C A C T G",
                "A T G C G A A T G C G A",
                "C A A A A A A A A T G C",
                "T T G T A T T T G T A T",
                "A G A C G G A G A A G G",
                "C G C C T A C G C C T A",
                "T C A C T G T C A C T G"
        };
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void testIsNoMutant_twoConsecutiveVertical() {
        String[] dna = {
                "A T G C G A A T G C G A",
                "C A G T G C C A G T G C",
                "T T G T A T T T G T A T",
                "A G A A G G A G A A G G",
                "C G C C T A C G C C T G",
                "T C A C T G T C A C T G",
                "A T G C G A A T G C G G",
                "C A T A A T A A A T G G",
                "T T G G A T T T G T A G",
                "A G A C G G A G A A G G",
                "C G C C T A C G C C T G",
                "T C A C T G T C A C T G"
        };
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void testIsNoMutant_twoConsecutiveObliqueRight() {
        String[] dna = {
                "A T T A T A A A T T T A",
                "G G G C G G G C C C G C",
                "A A A T A T T T A T T T",
                "A G A A G G A G A A G G",
                "C A C C T A C A C C T A",
                "T C A C T G T C A C T A",
                "A T C A G T A T G C G A",
                "C A G C T C C A G T G C",
                "T T G A C C T T G T A C",
                "A G T A G C A G A A A C",
                "C T C C T A C C C C T A",
                "T C A C T G T C C C T G"
        };
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void testIsNoMutant_twoConsecutiveObliqueLeft() {
        String[] dna = {
                "A T T A T A A A T T T A",
                "G G G C G G G C C C A C",
                "A A A T A T T T A A T T",
                "A G A A G G A G A A G G",
                "C A C C T A C A C C T A",
                "T C A C T G A C A C T A",
                "A T G C G A A T G C G A",
                "C A G T A C C A G T G C",
                "T T G A A C T T G T A C",
                "A G T A G G A G A T A C",
                "C T C C T A C C A C T A",
                "T C A C T G T C C C T G"
        };
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void testIsNoMutant_superimposedVerticalAndHorizontal() {
        String[] dna = {
                "A T G C G A A T G C G A",
                "C A G T G C C A G T G C",
                "T T G T A T T T G T A T",
                "A G A A G G A G A A G G",
                "C G C C T A C G C C T A",
                "T C A C T G T C A C T G",
                "A T G C G A A T G C G A",
                "C A G T G C C T G T G C",
                "T T G T A T T T T T A T",
                "A G A A G G A T A A G G",
                "C G C C T A C G C C T A",
                "T C A C T G T C A C T G"
        };
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void testIsNoMutant_superimposedVerticalAndOblique() {
        String[] dna = {
                "A T G C G A A T G C G A",
                "C A G T G C C A G T G C",
                "T T G T A T T T G T A T",
                "A G A A G G A G A A G G",
                "C G C C T A C G C C T A",
                "T C A C T G T C A C T G",
                "A T G C G A A T G C G A",
                "C A G T G C C T G T G C",
                "T T G T A T A T T T A T",
                "A G A A G G A T A T G G",
                "C G C C T A C G C C T A",
                "T C A C T G T C A C T G"
        };
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void testIsNoMutant_superimposedHorizontalAndOblique() {
        String[] dna = {
                "A T G C G A A T G C G A",
                "C A G T G C C A G T G C",
                "T T G T A T T T G T A T",
                "A G A A G G A G A A G G",
                "C G C C T A C G C C T A",
                "T C A C T G T C A C T G",
                "A T G C G A A T G C G A",
                "C A G T G C C G G T G C",
                "T T G T A T A G T A T T",
                "A G A A G G A T A T G G",
                "C G C C T A G T T T T C",
                "T C A C T G T T A C T G"
        };
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertTrue(result);
    }

    @Test
    public void testSmallDna() {
        String[] dna = {
                "A T G",
                "C A G",
                "T T G",
        };
        removeSpace(dna);

        boolean result = MutantChecker.isMutant(dna);

        assertFalse(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDna_nxm() {
        String[] dna = {
                "A T G G",
                "C A G G",
                "T T G G"
        };
        removeSpace(dna);

        MutantChecker.isMutant(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDna_mxn() {
        String[] dna = {
                "A T G",
                "C A G",
                "T T G",
                "T T G"
        };
        removeSpace(dna);

        MutantChecker.isMutant(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDna_empty() {
        String[] dna = {};
        removeSpace(dna);

        MutantChecker.isMutant(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDna_null() {
        MutantChecker.isMutant(null);
    }

    private void removeSpace(String[] dna) {
        for (int i = 0; i < dna.length; i++) {
            dna[i] = dna[i].replaceAll("\\W", "");
        }
    }

}
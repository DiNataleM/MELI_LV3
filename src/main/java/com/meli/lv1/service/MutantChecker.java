package com.meli.lv1.service;

import static org.springframework.util.ObjectUtils.isEmpty;

public class MutantChecker {
    public static final int MAX_SEQUENCE = 4;
    public static final int SEQUENCES_TO_FIND = 2;


    /*
        Level-1
        En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
        de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
        cuales representa cada base nitrogenada del ADN

        Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras
        iguales, de forma oblicua, horizontal o vertical
     */

    static boolean isMutant(String[] dna) {
        chekParameterState(dna); // Chek if dna is not null or empty and if it is NXN

        // dna is NXN. so, is a square. i can use same size.
        int size = dna.length;

        // In this case can not exist 4 letters in sequence.
        if (size < MAX_SEQUENCE) {
            return false;
        }


        int count = 0;
        for (int i = 0; i < dna.length; i++) {
            count += hasHorizontalSequence(dna[i]); // search in all line
            count += hasVerticalSequence(dna, i);
            count += hasObliqueDownSequence(dna, i);
            if (i != 0 && i != (dna.length - 1)) {
                count += hasObliqueTopSequence(dna, i);
            }

            if (count >= SEQUENCES_TO_FIND) {
                return true;
            }
        }

        return false;
    }

    private static void chekParameterState(String[] dna) {

        if (isEmpty(dna)) {
            throw new IllegalArgumentException("The dna parameter is empty.");
        }

        if (dna.length != dna[0].length()) {
            throw new IllegalArgumentException("The dna parameter is not NXN.");
        }
    }

    private static int hasHorizontalSequence(String s) {
        int coincidence = 0;
        char letter = s.charAt(0);
        int count = 0;
        int sSize = s.length();
        for (int i = 1; i < sSize; i++) {
            if (letter == s.charAt(i)) {
                count++; // if letter is the same ++.

                if (count == MAX_SEQUENCE - 1) { // Found 4 equas
                    coincidence++;
                    if (i < sSize - MAX_SEQUENCE) { // if i can found other
                        count = 0; // resert count
                        letter = s.charAt(i + 1); // resert letter
                        i++; // move two to the rigth.
                    } else {
                        return coincidence;
                    }
                }
            } else {
                letter = s.charAt(i);
                count = 0;
            }

        }

        return coincidence;
    }

    private static int hasVerticalSequence(String[] dna, int pos) {
        int coincidence = 0;
        char letter = dna[0].charAt(pos);
        int count = 0;
        int sSize = dna.length;
        for (int i = 1; i < sSize; i++) {
            if (letter == dna[i].charAt(pos)) {
                count++; // if letter is the same ++.

                if (count == MAX_SEQUENCE - 1) { // Found 4 equas
                    coincidence++;
                    if (i < sSize - MAX_SEQUENCE) { // if i can found other
                        count = 0; // resert count
                        letter = dna[i + 1].charAt(pos); // resert letter
                        i++; // move two to the rigth.
                    } else {
                        return coincidence;
                    }
                }
            } else {
                letter = dna[i].charAt(pos);
                count = 0;
            }

        }

        return coincidence;
    }

    private static int hasObliqueTopSequence(String[] dna, int pos) {
        int size = dna.length;

        char letterR = dna[size - 1].charAt(pos); // letra derecha
        char letterL = dna[size - 1].charAt(pos); // letra izquierda
        int countR = 0;
        int countL = 0;
        int coincidence = 0;

        for (int r = 1; r < size; r++) {
            //rigth
            if (pos + r < size) { // has element in the rigth
                char newLeterR = dna[size - 1 - r].charAt(pos + r);
                if (letterR == newLeterR) {
                    countR++;
                    if (countR == MAX_SEQUENCE - 1) {
                        coincidence++;
                        countR = 0;
                        letterR = ';';
                    }
                } else {
                    letterR = newLeterR;
                    countR = 0;
                }
            }

            //left
            int l = r;
            if (pos - l >= 0) { // has element in the rigth
                char newLeterL = dna[size - 1 - l].charAt(pos - l);
                if (letterL == newLeterL) {
                    countL++;
                    if (countL == MAX_SEQUENCE - 1) {
                        coincidence++;
                        countL = 0;
                        letterL = ';';
                    }
                } else {
                    letterL = newLeterL;
                    countL = 0;
                }
            }
        }
        return coincidence;
    }

    private static int hasObliqueDownSequence(String[] dna, int pos) {
        int size = dna.length;

        char letterR = dna[0].charAt(pos); // letra derecha
        char letterL = dna[0].charAt(pos); // letra izquierda
        int countR = 0;
        int countL = 0;
        int coincidence = 0;

        for (int r = 1; r < size; r++) {
            //rigth
            if (pos + r < size) { // has element in the rigth
                char newLeterR = dna[r].charAt(pos + r);
                if (letterR == newLeterR) {
                    countR++;
                    if (countR == MAX_SEQUENCE - 1) {
                        coincidence++;
                        countR = 0;
                        letterR = ';';
                    }
                } else {
                    letterR = newLeterR;
                    countR = 0;
                }
            }

            //left
            int l = r;
            if (pos - l >= 0) { // has element in the rigth
                char newLeterL = dna[l].charAt(pos - l);
                if (letterL == newLeterL) {
                    countL++;
                    if (countL == MAX_SEQUENCE - 1) {
                        coincidence++;
                        countL = 0;
                        letterL = ';';
                    }
                } else {
                    letterL = newLeterL;
                    countL = 0;
                }
            }
        }
        return coincidence;
    }
}

package com.meli.lv1.service;

public class MutantChecker {
    public static final int MAX_SEQUENCE = 4;
    public static final int SEQUENCES_TO_FIND = 2;


    /*
        En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
        de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
        cuales representa cada base nitrogenada del ADN

        Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras
        iguales, de forma oblicua, horizontal o vertical
     */

    static boolean isMutant(String[] dna) {
        // dna is NXN. so, is a square. i can use same size.
        int size = dna.length;
        // In this case can not exist 4 letters in sequence.
        if (size < MAX_SEQUENCE) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == 0) {
                    count += hasHorizontalSequence(dna[i]); // search in all line
                }

                if (i == 0){
                    count += hasVerticalSequence(dna, j); // search in all vertical
                }

                count += hasOliqueSequence(dna, i, j);

                if (count >= SEQUENCES_TO_FIND) {
                    return true;
                }
            }
        }

        return false;
    }

    private static int hasHorizontalSequence(String s) {
        /*
                          j j j j
                        i"A T T T",
                        i"C A G T",
                        i"T T A T",
                        i"A G A A"
         */
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
        /*
                          j j j j
                        i"A T T T",
                        i"T A T T",
                        i"T T T T",
                        i"A G T A"
         */
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
                        letter = dna[i+1].charAt(pos); // resert letter
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

    private static int hasOliqueSequence(String[] dna, int i, int j) {
//        String letter = dna[0].;
        return 0;
    }
}

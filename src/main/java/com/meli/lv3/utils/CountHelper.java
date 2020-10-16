package com.meli.lv3.utils;

/**
 * This class will save the last letter, and count if is the same to before.
 */
public class CountHelper {

    private int maxSequence;

    private int coincidence;
    private int count;
    private Character actualLetter;

    public CountHelper(int maxSequence) {
        this.maxSequence = maxSequence;
        coincidence = 0;
        resetLoop();
    }

    /**
     * Reset the letter and actual count.
     */
    public void resetLoop() {
        actualLetter = null;
        count = 0;
    }

    /**
     * will check if the newLetter parameter is the same to actualLetter (savedLetter).
     * If is diferent will replace the saveLetter for this and will reset the count.
     * If it is the same will increace the count.
     * -> If the count is the expected (maxSequence) will increase coincidence and reset the others values.
     *
     * @param newLetter
     */
    public void check(Character newLetter) {
        if (isEquals(actualLetter, newLetter)) {
            count++;
            if (count == (maxSequence - 1)) {
                coincidence++;
                resetLoop();
            }
        } else {
            actualLetter = newLetter;
            count = 0;
        }
    }

    private boolean isEquals(Character actualLetter, Character newLetter) {
        return actualLetter != null && actualLetter.equals(newLetter);
    }

    /**
     * return the coincidences count.
     *
     * @return
     */
    public int getCoincidence() {
        return coincidence;
    }
}

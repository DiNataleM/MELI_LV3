package com.meli.lv1.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountHelperTest {

    public static final int MAX_SEQUENCE = 3;

    CountHelper countHelper;

    @Before
    public void setUp() {
        countHelper = new CountHelper(MAX_SEQUENCE);
    }

    @Test
    public void resetLoop() {
        countHelper.check('A');
        countHelper.check('A');
        countHelper.resetLoop();
        countHelper.check('A');

        int result = countHelper.getCoincidence();

        assertEquals(0, result);

    }

    @Test
    public void resetLoopWithCoincidence() {
        countHelper.check('A');
        countHelper.check('A');
        countHelper.resetLoop();
        countHelper.check('A');
        countHelper.check('A');
        countHelper.check('A');
        countHelper.resetLoop();

        int result = countHelper.getCoincidence();

        assertEquals(1, result);

    }

    @Test
    public void check() {
        countHelper.check('A');
        countHelper.check('B');
        countHelper.check('A');
        countHelper.check('A');
        countHelper.check('A');
        countHelper.check('A');
        countHelper.check('A');
        countHelper.check('A');
        countHelper.check('B');
        countHelper.check('B');
        countHelper.check('B');

        int result = countHelper.getCoincidence();

        assertEquals(3, result);
    }

    @Test
    public void checkNoCoincidence() {
        countHelper.check('A');
        countHelper.check('B');
        countHelper.check('A');
        countHelper.check('A');
        countHelper.check('C');
        countHelper.check('A');
        countHelper.check('A');
        countHelper.check('B');
        countHelper.check('B');
        countHelper.check('C');
        countHelper.check('B');

        int result = countHelper.getCoincidence();

        assertEquals(0, result);
    }

}
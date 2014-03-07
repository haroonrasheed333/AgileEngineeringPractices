package edu.berkeley.ischool.aep;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * Created by haroon on 1/31/14.
 */
public class ChanceTest {
    @Test
    public void eventNotOccurred () {
        Chance coinToss = new Chance(0.5);
        Chance dieThrow = new Chance(1/6);
        assertEquals(coinToss, coinToss);
        assertFalse(dieThrow.equals(coinToss));
    }

    @Test
    public void equalsShouldOWrkAccordingToContract() {
        Chance coinToss = new Chance(0.5);
        assertFalse(coinToss.equals(null));
        assertFalse(coinToss.equals(new Object()));
        Map<Chance, String> map = new HashMap<Chance, String>();
        map.put(new Chance(0.5), "Coin Toss");
        assertEquals("Coin Toss", map.get(new Chance(0.5)));
    }

    @Test
    public void andShouldWorkAccordingToContract() {
        Chance dieThrow = new Chance(1/6);
        assertEquals(new Chance(5/36), dieThrow.and(new Chance(5/6)));
    }

    @Test
    public void orShouldWorkAccordingToContract() {
        Chance dieThrow = new Chance(1/6);
        assertEquals(new Chance(1/6+5/6-(1/6*5/6)), dieThrow.or(new Chance(5/6)));
    }
}

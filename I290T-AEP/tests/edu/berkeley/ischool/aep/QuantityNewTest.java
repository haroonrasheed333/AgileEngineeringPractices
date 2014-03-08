package edu.berkeley.ischool.aep;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by haroon on 2/14/14.
 */
public class QuantityNewTest {

    @Test
    public void threeFeetShouldEqualOneYard(){
        assertEquals(new QuantityNew(Unit.YARDS, 1.0), new QuantityNew(Unit.FEET, 3));
    }

    @Test
    public void oneMileShouldEqual1760Yard(){
        assertEquals(new QuantityNew(Unit.MILES, 1.0), new QuantityNew(Unit.YARDS, 1760));
    }

    @Test
    public void oneCupShouldEqualEightOz(){
        assertEquals(new QuantityNew(Unit.CUP, 1.0), new QuantityNew(Unit.OZ, 8));
    }

    @Test
    public void oneTbspShouldEqualThreeTsp(){
        assertEquals(new QuantityNew(Unit.TBSP, 1.0),new QuantityNew(Unit.TSP, 3));
    }

    @Test
    public void twoInchesAddTwoInchesEqualsFourInches(){
                new QuantityNew(Unit.INCHES, 2).add(new QuantityNew(Unit.INCHES, 2));
    }

    @Test
    public void twoTbspAddOneOzEqualsTwelveTsp(){
        assertEquals(new QuantityNew(Unit.TSP, 12.0), new QuantityNew(Unit.TBSP, 2).add(new QuantityNew(Unit.OZ, 1)));
        assertEquals(new QuantityNew(Unit.TSP, 12.0),
                new QuantityNew(Unit.OZ, 1).add(new QuantityNew(Unit.TBSP, 2)));

        assertEquals(new QuantityNew(Unit.TSP, 1.0), new QuantityNew(Unit.FEET, 1));
    }

    @Test(expected = RuntimeException.class)
    public void twoOzPlusOneFootShouldThrowException() throws Exception {
        assertEquals(new QuantityNew(Unit.FEET, 2),
                new QuantityNew(Unit.FEET, 1).add(new QuantityNew(Unit.OZ, 2)));
    }

    @Test
    public void tenCelsiusShouldEqualFiftyFahrenheit(){
        assertEquals(new QuantityNew(Unit.FAHRENHEIT, 50), new QuantityNew(Unit.CELSIUS, 10));
    }

    @Test
    public void oneFahrenheitShouldEqualMinusSeventeenCelsius(){
        assertEquals(new QuantityNew(Unit.CELSIUS, -17.22), new QuantityNew(Unit.FAHRENHEIT, 1));
    }

    @Test(expected = RuntimeException.class)
    public void twoCelsiusPlusOneFahrenheitShouldThrowException() throws Exception {
        assertEquals(new QuantityNew(Unit.FAHRENHEIT, 2),
                new QuantityNew(Unit.CELSIUS, 2).add(new QuantityNew(Unit.FAHRENHEIT, 1)));
    }

    @Test
    public void betterThan() throws Exception {
        assertTrue(new ScaledQuantity(Unit.INCHES, 13).betterThan(new ScaledQuantity(Unit.FEET, 1)));
        assertFalse(new ScaledQuantity(Unit.INCHES, 11).betterThan(new ScaledQuantity(Unit.FEET, 1)));
        assertFalse(new ScaledQuantity(Unit.INCHES, 12).betterThan(new ScaledQuantity(Unit.FEET, 1)));
    }

    @Test
    public void shouldReturn100FeetAsTheBestQuantity() throws Exception {
        ScaledQuantity[] quantityArray = new ScaledQuantity[3];
        quantityArray[0] = new ScaledQuantity(Unit.FEET, 30);
        quantityArray[1] = new ScaledQuantity(Unit.FEET, 100);
        quantityArray[2] = new ScaledQuantity(Unit.INCHES, 100);

        assertEquals(new ScaledQuantity(Unit.FEET, 100), new Bester(quantityArray).findBest());
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionForUnComparableQuantities() throws Exception {
        ScaledQuantity[] quantityArray = new ScaledQuantity[3];
        quantityArray[0] = new ScaledQuantity(Unit.FEET, 30);
        quantityArray[1] = new ScaledQuantity(Unit.INCHES, 100);
        quantityArray[2] = new ScaledQuantity(Unit.FAHRENHEIT, 50);

        assertEquals(new ScaledQuantity(Unit.FEET, 100), new Bester(quantityArray).findBest());
    }
}

package edu.berkeley.ischool.aep;
import org.junit.Test;


import static junit.framework.Assert.assertEquals;
/**
 * Created by haroon on 2/7/14.
 */
public class QuantityTest {
//    @Test
//    public void test12InchesEquals1Foot() {
//        assertEquals(Quantity.createInches(12), Quantity.convertFeetToInches(Quantity.createFeet(1)));
//    }

    @Test
    public void test12InchesEquals1Foot() {
        assertEquals(Quantity.createQuantity(12, "in"), Quantity.createQuantity(1, "ft").convertToInches());
        assertEquals(Quantity.createQuantity(1, "ft"), Quantity.createQuantity(12, "in").convertToFeet());
        assertEquals(Quantity.createQuantity(0, "Invalid"), Quantity.createQuantity(1, "ft").convertToTsp());
    }

    @Test
    public void test1MileEquals1760Yards() {
        assertEquals(Quantity.createQuantity(1, "mi"), Quantity.createQuantity(1760, "yd").convertToMiles());
        assertEquals(Quantity.createQuantity(0, "Invalid"), Quantity.createQuantity(1, "mi").convertToTsp());
    }

    @Test
    public void test1MileEquals63360Inches() {
        assertEquals(Quantity.createQuantity(1, "mi"), Quantity.createQuantity(63360, "in").convertToMiles());
    }

    @Test
    public void test1YardEquals3Feet() {
        assertEquals(Quantity.createQuantity(1, "yd"), Quantity.createQuantity(3, "ft").convertToYards());
    }

    @Test
    public void test8OzEquals1Cup() {
        assertEquals(Quantity.createQuantity(8, "oz"), Quantity.createQuantity(1, "cup").convertToOz());
        assertEquals(Quantity.createQuantity(3, "tsp"), Quantity.createQuantity(1, "tbsp").convertToTsp());
        assertEquals(Quantity.createQuantity(1, "oz"), Quantity.createQuantity(2, "tbsp").convertToOz());
        assertEquals(Quantity.createQuantity(1, "tbsp"), Quantity.createQuantity(0.5, "oz").convertToTbsp());

        assertEquals(Quantity.createQuantity(0, "Invalid"), Quantity.createQuantity(1, "ft").convertToTsp());
    }
}

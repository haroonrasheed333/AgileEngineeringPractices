package edu.berkeley.ischool.aep;

/**
 * Test the Area of a four sided figure with sides at right angles
 */

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
public class RectangleTests {
    @Test
    public void shouldReturnAreaOfZeroForZeroByZeroRectangle() {
        Rectangle rectangle = new Rectangle(0, 0);
        assertEquals(0, rectangle.area());
    }

    @Test
    public void shouldReturnAreaOfTenForFiveByTwoRectangle() {
        Rectangle rectangle = new Rectangle(5, 2);
        assertEquals(10, rectangle.area());
    }

    @Test
    public void allSidesShouldBeEqual() {
        Rectangle square = new Rectangle(2,2);
        assertEquals(true, square.isSquare());
    }

    @Test
    public void isRectangleWithBothSidesEqualIsASquare() {
        assertEquals((new Rectangle(5, 5).area()), (new Rectangle(5).area()));
        assertEquals((new Rectangle(5, 5).area()), Rectangle.createSquare(5).area());
    }
}

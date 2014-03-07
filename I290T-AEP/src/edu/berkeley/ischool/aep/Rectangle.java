package edu.berkeley.ischool.aep;

/**
 * Understands a 4 sided figure with sides at right angles
 */
public class Rectangle {

    int length, breadth;
    public Rectangle () {
        length = 0;
        breadth = 0;
    }

    public Rectangle (int l, int b) {
        length = l;
        breadth = b;
    }

    public Rectangle (int side){
        //length = breadth = side;
        this(side, side);
    }

    public int area () {
        return length * breadth;
    }

    public boolean isSquare() {
        return this.length==this.breadth;
    }

    public static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }
}

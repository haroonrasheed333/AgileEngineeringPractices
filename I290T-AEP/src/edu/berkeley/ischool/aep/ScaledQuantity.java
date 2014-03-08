package edu.berkeley.ischool.aep;

/**
 * Created by haroon on 2/21/14.
 */
public class ScaledQuantity implements Bestable {
    protected final double value;
    protected final Unit units;

    public ScaledQuantity(Unit units, double size) {
        this.value = size;
        this.units = units;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof ScaledQuantity)) return false;
        ScaledQuantity otherQuantity = (ScaledQuantity) other;

        if (this.units.isConvertibleTo(otherQuantity.units)) {
            double otherValue = otherQuantity.units.convertTo(otherQuantity.value, this.units);
            return Math.abs(this.value - otherValue) < 0.01;
        }
        return false;
    }

    @Override
    public int hashCode() {
        long longBits = Double.doubleToLongBits(value);
        return (int) (longBits ^ (longBits >>> 32));
    }

    protected boolean isCompatible(ScaledQuantity otherQ) {
        return this.units.isConvertibleTo(otherQ.units);
    }

    protected double convertValueTo(Unit units) throws Exception {
        return this.units.convertTo(this.value, units);
    }

    @Override
    public String toString() {
        return value + " " + units;
    }

    @Override
    public boolean betterThan(Bestable oth) {
        ScaledQuantity other = (ScaledQuantity) oth;
        if (this.units.isConvertibleTo(other.units)) {
            double otherValue = other.units.convertTo(other.value, this.units);
            return this.value > otherValue;
        }
        else {
            throw new RuntimeException("Cannot compare " + this.units + " with " + other.units);
        }
    }
}

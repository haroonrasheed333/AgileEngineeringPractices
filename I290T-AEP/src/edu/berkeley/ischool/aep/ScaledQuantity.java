package edu.berkeley.ischool.aep;

/**
 * Created by haroon on 2/21/14.
 */
public class ScaledQuantity {
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

    public boolean betterThan(ScaledQuantity other) {
        if (this.units.isConvertibleTo(other.units)) {
            double otherValue = other.units.convertTo(other.value, this.units);
            return this.value > otherValue;
        }
        else {
            throw new RuntimeException("Cannot compare " + this.units + " with " + other.units);
        }
    }

    public static ScaledQuantity findBestQuantity(ScaledQuantity[] quantityArray) {
        for (int i = 0; i < quantityArray.length - 1; i++) {
            for (int j = 0; j < quantityArray.length - (i + 1); j++) {
                if (!quantityArray[j].betterThan(quantityArray[j+1])) {
                    ScaledQuantity temp = quantityArray[j];
                    quantityArray[j] = quantityArray[j+1];
                    quantityArray[j+1] = temp;
                }
            }
        }
        return quantityArray[0];
    }
}

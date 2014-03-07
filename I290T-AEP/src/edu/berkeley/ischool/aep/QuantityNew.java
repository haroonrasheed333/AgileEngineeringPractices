package edu.berkeley.ischool.aep;

import java.io.IOException;

/**
 * Created by haroon on 2/14/14.
 */
public class QuantityNew {
    private final Unit unit;
    private final double value;

    public QuantityNew(Unit unit, double value){
        this.unit = unit;
        this.value = value;
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof QuantityNew)) return false;
        QuantityNew otherQuantity =  (QuantityNew) other;
        double otherValue = otherQuantity.unit.convertTo(otherQuantity.value, this.unit);
        return Math.abs(this.value - otherValue) < 0.01;

    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    @Override
    public int hashCode(){
        long longBits = Double.doubleToLongBits(value);
        return (int) (longBits ^ (longBits >>> 32));
    }

    public QuantityNew add(QuantityNew otherQuantity) {
        if (this.unit.isConvertibleTo(otherQuantity.unit) && this.unit.isAdditionPossible(otherQuantity.unit)) {
            double otherValue = otherQuantity.unit.convertTo(otherQuantity.value, this.unit);
            return new QuantityNew(this.unit, this.value + otherValue);
        }
        else {
            throw new RuntimeException("Cannot add " + this.unit + " with " + otherQuantity.unit);
        }
    }

}

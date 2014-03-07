package edu.berkeley.ischool.aep;

/**
 * Created by haroon on 2/14/14.
 */
public class Unit {

    public enum UnitType{LENGTH, VOLUME, TEMPERATURE}

    public static Unit INCHES = new Unit(1.0/12, "Inches", UnitType.LENGTH);

    public static Unit FEET = new Unit(1, "Feet", UnitType.LENGTH);
    public static Unit YARDS = new Unit(3, "Yards", UnitType.LENGTH);
    public static Unit MILES = new Unit(1760 * 3, "Miles", UnitType.LENGTH);

    public static Unit TSP = new Unit(1, "Tsp", UnitType.VOLUME);
    public static Unit TBSP = new Unit(3, "Tbsp", UnitType.VOLUME);
    public static Unit OZ = new Unit(2 * 3, "Oz", UnitType.VOLUME);
    public static Unit CUP = new Unit(2 * 3 * 8, "Cup", UnitType.VOLUME);

    public static Unit FAHRENHEIT = new Unit(1, "Fahrenheit", UnitType.TEMPERATURE);
    public static Unit CELSIUS = new Unit(9.0/5, "Celsius", UnitType.TEMPERATURE);

    private final double conversionFactor;
    private final String name;
    private final UnitType type;

    @Override
    public String toString() {
        return name;
    }

    private Unit(double inBaseUnits, String name, UnitType type) {

        this.conversionFactor = inBaseUnits;
        this.name = name;
        this.type = type;
    }

    public boolean isConvertibleTo(Unit otherUnit) {
        return (otherUnit.type.equals(this.type));
    }

    public boolean isAdditionPossible(Unit otherUnit) {
        return (!(otherUnit.type.equals(UnitType.TEMPERATURE)));
    }

    public double convertTo(double size, Unit otherUnit) {
        if (this.name.equals(otherUnit.name)) {
            return size;
        }
        else if (otherUnit.name.equals("Fahrenheit")) {
            return size*this.conversionFactor*otherUnit.conversionFactor + 32;
        }
        else if (otherUnit.name.equals("Celsius")) {
            return (size*this.conversionFactor - 32) / otherUnit.conversionFactor;
        }
        else
            return size * conversionFactor / otherUnit.conversionFactor;
    }
}


//
//212 F = 100C
//32F = 0C
//F->C -32*5/9
//C-->F
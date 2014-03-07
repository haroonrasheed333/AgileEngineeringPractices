package edu.berkeley.ischool.aep;

/**
 * Created by haroon on 2/7/14.
 */
public class Quantity {

    private final double value;
    private final String unit;

    public Quantity(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Quantity createQuantity(double value, String unit) {
        return new Quantity(value, unit);
    }

    public Quantity convertToInches() {
        if (this.unit.equals("in")) {
            return this;
        }
        else if (this.unit.equals("ft")) {
            return new Quantity((this.value * 12), "in");
        }
        else if (this.unit.equals("yd")) {
            return new Quantity((this.value * 36), "in");
        }
        else if (this.unit.equals("mi")) {
            return new Quantity((this.value * 63360), "in");
        }
        else return new Quantity(0, "Invalid");
    }

    public Quantity convertToFeet() {
        if (this.unit.equals("ft")) {
            return this;
        }
        else if (this.unit.equals("in")) {
            return new Quantity((this.value / 12), "ft");
        }
        else if (this.unit.equals("yd")) {
            return new Quantity((this.value * 3), "ft");
        }
        else if (this.unit.equals("mi")) {
            return new Quantity((this.value * 1760 * 3), "ft");
        }
        else return new Quantity(0, "Invalid");
    }

    public Quantity convertToYards() {
        if (this.unit.equals("yd")) {
            return this;
        }
        else if (this.unit.equals("ft")) {
            return new Quantity((this.value / 3), "yd");
        }
        else if (this.unit.equals("in")) {
            return new Quantity((this.value / 36), "yd");
        }
        else if (this.unit.equals("mi")) {
            return new Quantity((this.value * 1760), "yd");
        }
        else return new Quantity(0, "Invalid");
    }

    public Quantity convertToMiles() {
        if (this.unit.equals("mi")) {
            return this;
        }
        else if (this.unit.equals("ft")) {
            return new Quantity((this.value / (3 * 1760)), "mi");
        }
        else if (this.unit.equals("yd")) {
            return new Quantity((this.value / 1760), "mi");
        }
        else if (this.unit.equals("in")) {
            return new Quantity((this.value / (63360)), "mi");
        }
        else return new Quantity(0, "Invalid");
    }

    public Quantity convertToTsp() {
        if (this.unit.equals("tsp")) {
            return this;
        }
        else if (this.unit.equals("tbsp")) {
            return new Quantity((this.value * 3), "tsp");
        }
        else if (this.unit.equals("oz")) {
            return new Quantity((this.value * 2 * 3), "tsp");
        }
        else if (this.unit.equals("cup")) {
            return new Quantity((this.value * 2 * 3 * 8), "tsp");
        }
        else return new Quantity(0, "Invalid");
    }

    public Quantity convertToTbsp() {
        if (this.unit.equals("tbsp")) {
            return this;
        }
        else if (this.unit.equals("tsp")) {
            return new Quantity((this.value / 3), "tbsp");
        }
        else if (this.unit.equals("oz")) {
            return new Quantity((this.value * 2), "tbsp");
        }
        else if (this.unit.equals("cup")) {
            return new Quantity((this.value * 2 * 8), "tbsp");
        }
        else return new Quantity(0, "Invalid");
    }

    public Quantity convertToOz() {
        if (this.unit.equals("oz")) {
            return this;
        }
        else if (this.unit.equals("tbsp")) {
            return new Quantity((this.value / 2), "oz");
        }
        else if (this.unit.equals("tsp")) {
            return new Quantity((this.value / (2 * 3)), "oz");
        }
        else if (this.unit.equals("cup")) {
            return new Quantity((this.value * 8), "oz");
        }
        else return new Quantity(0, "Invalid");
    }

    public Quantity convertToCups() {
        if (this.unit.equals("cup")) {
            return this;
        }
        else if (this.unit.equals("tbsp")) {
            return new Quantity((this.value / (2 * 8)), "cup");
        }
        else if (this.unit.equals("oz")) {
            return new Quantity((this.value / 8), "cup");
        }
        else if (this.unit.equals("tsp")) {
            return new Quantity((this.value / (2 * 3 * 8)), "cup");
        }
        else return new Quantity(0, "Invalid");
    }

//    public Quantity convertTo(String toUnit) {
//        if (this.unit.equals(toUnit)) {
//            return this;
//        }
//
//        if (this.unit.equals("in")) {
//            if (toUnit.equals("ft")) {
//                return new Quantity((this.value / 12), "ft");
//            }
//            else if (toUnit.equals("yd")) {
//                return new Quantity((this.value / 36), "yd");
//            }
//            else if (toUnit.equals("mi")) {
//                return new Quantity((this.value / 63360), "mi");
//            }
//        }
//        else if (this.unit.equals("ft")) {
//            if (toUnit.equals("in")) {
//                return new Quantity((this.value * 12), "in");
//            }
//            else if (toUnit.equals("yd")) {
//                return new Quantity((this.value / 3), "yd");
//            }
//            else if (toUnit.equals("mi")) {
//                return new Quantity((this.value / 5280), "mi");
//            }
//        }
//        else if (this.unit.equals("yd")) {
//            if (toUnit.equals("in")) {
//                return new Quantity((this.value * 36), "in");
//            }
//            else if (toUnit.equals("ft")) {
//                return new Quantity((this.value * 3), "ft");
//            }
//            else if (toUnit.equals("mi")) {
//                return new Quantity((this.value / 1760), "mi");
//            }
//        }
//        else if (this.unit.equals("mi")) {
//            if (toUnit.equals("in")) {
//                return new Quantity((this.value * 63360), "in");
//            }
//            else if (toUnit.equals("yd")) {
//                return new Quantity((this.value * 1760), "yd");
//            }
//            else if (toUnit.equals("ft")) {
//                return new Quantity((this.value * 5280), "ft");
//            }
//        }
//
//        else if (this.unit.equals("tsp")) {
//            if (toUnit.equals("tbsp")) {
//                return new Quantity((this.value / 3), "tbsp");
//            }
//            else if (toUnit.equals("oz")) {
//                return new Quantity((this.value / 6), "oz");
//            }
//            else if (toUnit.equals("cup")) {
//                return new Quantity((this.value / 48), "cup");
//            }
//        }
//
//        else if (this.unit.equals("tbsp")) {
//            if (toUnit.equals("tsp")) {
//                return new Quantity((this.value * 3), "tsp");
//            }
//            else if (toUnit.equals("oz")) {
//                return new Quantity((this.value / 2), "oz");
//            }
//            else if (toUnit.equals("cup")) {
//                return new Quantity((this.value / 16), "cup");
//            }
//        }
//
//        else if (this.unit.equals("oz")) {
//            if (toUnit.equals("tbsp")) {
//                return new Quantity((this.value * 2), "tbsp");
//            }
//            else if (toUnit.equals("tsp")) {
//                return new Quantity((this.value * 6), "tsp");
//            }
//            else if (toUnit.equals("cup")) {
//                return new Quantity((this.value / 8), "cup");
//            }
//        }
//
//        else if (this.unit.equals("cup")) {
//            if (toUnit.equals("tbsp")) {
//                return new Quantity((this.value * 16), "tbsp");
//            }
//            else if (toUnit.equals("oz")) {
//                return new Quantity((this.value * 8), "oz");
//            }
//            else if (toUnit.equals("tsp")) {
//                return new Quantity((this.value * 48), "tsp");
//            }
//        }
//        return new Quantity(0, "Invalid");
//    }

    @Override
    public boolean equals (Object other) {
        if (other == this) return true;
        if (!(other instanceof Quantity)) return false;
        return value == ((Quantity) other).value;
    }

    @Override
    public int hashCode() {
        long longBits = Double.doubleToLongBits(value);
        return (int) (longBits ^ (longBits >>> 32));
    }

//    public static Quantity createInches(double value) {
//        return new Quantity(value);
//    }
//
//    public static Quantity createFeet(double value) {
//        return new Quantity(value);
//    }
//
//    public static Quantity convertFeetToInches(Quantity object) {
//        return new Quantity(12*object.value);
//    }

//    public static Quantity convertTo(String toUnits) {
//
//    }

}

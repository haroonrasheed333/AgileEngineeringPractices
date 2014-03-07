package edu.berkeley.ischool.aep;

/**
 * Created by haroon on 1/31/14.
 */
public class Chance {
    private final double probability;

    public Chance (double probability) {
        this.probability = probability;
    }

    @Override
    public boolean equals (Object other) {
        if (other == this) return true;
        if (!(other instanceof Chance)) return false;
        return probability == ((Chance) other).probability;
    }

    @Override
    public int hashCode () {
        return 42;
        // long longBits =
    }

    public Chance and (Chance other) {
        double result = this.probability * other.probability;

        return (new Chance(result));
    }

    public Chance not() {
        return new Chance(1-probability);
    }

    public Chance or (Chance other){
        //return (new Chance(this.probability+other.probability-this.probability*other.probability));
        return (this.not().and(other.not())).not();
    }
}

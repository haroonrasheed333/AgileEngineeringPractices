package edu.berkeley.ischool.aep;

/**
 * Created by haroon on 3/7/14.
 */
public class Bester {
    private final Bestable[] Array;

    public Bester(Bestable[] array) {
        Array = array;
    }

    public Bestable findBest() {

        for (int i = 0; i < Array.length - 1; i++) {
            for (int j = 0; j < Array.length - (i + 1); j++) {
                if (!Array[j].betterThan(Array[j+1])) {
                    Bestable temp = Array[j];
                    Array[j] = Array[j+1];
                    Array[j+1] = temp;
                }
            }
        }
        return Array[0];
    }
}

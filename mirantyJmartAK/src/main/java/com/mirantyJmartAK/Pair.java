package com.mirantyJmartAK;

/**
 * This is class for representing a pair of two object
 * @param <T>
 * @param <U>
 * @author Miranty Anjani Putri
 */

public class Pair <T,U> {
    public T first;
    public U second;

    public Pair() {

    }

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

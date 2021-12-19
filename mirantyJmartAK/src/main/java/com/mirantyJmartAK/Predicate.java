package com.mirantyJmartAK;

/**
 * This is a functional interface and can therefore be used
 * as the assignment target for a lambda expression or method reference.
 * @param <T>
 */

public interface Predicate<T> {
    public abstract boolean predicate(T arg);
}

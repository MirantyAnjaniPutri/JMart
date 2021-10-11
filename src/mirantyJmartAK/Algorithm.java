package mirantyJmartAK;

import java.util.Arrays;
import java.util.Iterator;
import java.util.*;

public class Algorithm {

    private static java.lang.Object Object;

    private Algorithm() {
    }

    // ---------------------------- COLLECT ---------------------------
    public static <T> List<T> collect (T[] array, T value) {
        return null;
    }

    public static <T> List<T> collect (Iterable<T> iterable, T value) {
        return null;
    }

    public static <T> List<T> collect (Iterator<T> iterator, T value) {
        return null;
    }

    public <T> List<T> collect (T[] array, Predicate<T> pred) {
        return null;
    }

    public static <T> List<T> collect (Iterable<T> iterable, Predicate<T> pred) {
        return null;
    }

    public static <T> List<T> collect (Iterator<T> iterator, Predicate<T> pred) {
        return null;
    }

    // ------------------------- COUNT ---------------------
    public static <T> int count(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        return 0;
    }

    // ----------------------------- EXISTS -------------------------
    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        return false;
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        return false;
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        return false;
    }

    //-------------------------------- FIND ----------------------------
    public static <T> T find(T[] array, T value) {
        final Iterator<T> check = Arrays.stream(array).iterator();
        return find(check, value);
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        final Iterator<T> check = Arrays.stream(array).iterator();
        return find(check, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> check = iterable.iterator();
        return find(check, pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        return find(iterator, pred);
    }

    // ------------------ MAX --------------------------------
    public static <T> T max(T first, T second) {
        return null;
    }

    public static <T> T max (T[] array) {
        return null;
    }

    public static <T> T max (Iterable<T> iterable) {
        return null;
    }

    public static <T> T max (Iterator<T> iterator) {
        return null;
    }

    public static <T, comparator> T max (T first, T second, Comparator<? super T>comparator) {
        return null;
    }

    public static <T, comparator> T max (T[] array, Comparator<? super T>comparator) {
        return null;
    }

    public static <T, comparator> T max (Iterable<T> iterable, Comparator<? super T>comparator) {
        return null;
    }

    public static <T, comparator> T max (Iterator<T> iterator, Comparator<? super T>comparator) {
        return null;
    }

    // ------------------ MIN --------------------------------
    public static <T> T min(T first, T second) {
        return null;
    }

    public static <T> T min(T[] array) {
        return null;
    }

    public static <T> T min(Iterable<T> iterable) {
        return null;
    }

    public static <T> T min(Iterator<T> iterator) {
        return null;
    }

    public static <T, comparator> T min(T first, T second, Comparator<? super T>comparator) {
        return null;
    }

    public static <T, comparator> T min(T[] array, Comparator<? super T>comparator) {
        return null;
    }

    public static <T, comparator> T min(Iterable<T> iterable, Comparator<? super T>comparator) {
        return null;
    }

    public static <T, comparator> T min(Iterator<T> iterator, Comparator<? super T>comparator) {
        return null;
    }
}
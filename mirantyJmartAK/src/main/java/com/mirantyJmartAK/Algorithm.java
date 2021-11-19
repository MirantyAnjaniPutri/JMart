package com.mirantyJmartAK;

import java.util.Arrays;
import java.util.Iterator;
import java.util.*;

public class Algorithm {

    private static java.lang.Object Object;

    private Algorithm() {
    }

    // ---------------------------- COLLECT ---------------------------
    public static <T> List<T> collect (T[] array, T value) {
        List<T> list = new ArrayList<T>();
        for (T i : array) {
            if (i.equals(value)) {
                list.add(i);
            }
        }
        return list;
    }

    public static <T> List<T> collect (Iterable<T> iterable, T value) {
        List<T> list = new ArrayList<T>();
        for (T i : iterable) {
            if (i.equals(value)) {
                list.add(i);
            }
        }
        return list;
    }

    public static <T> List<T> collect (Iterator<T> iterator, T value) {
        List<T> list = new ArrayList<T>();
        if (iterator.hasNext()) {
            T i = iterator.next();
            if (i.equals(value)) {
                list.add(i);
            }
        }
        return list;
    }

    public <T> List<T> collect (T[] array, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T i : array) {
            if (pred.predicate(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static <T> List<T> collect (Iterable<T> iterable, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T i : iterable) {
            if (pred.predicate(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static <T> List<T> collect (Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        if (iterator.hasNext()) {
            T i = iterator.next();
            if (pred.predicate(i)) {
                list.add(i);
            }
        }
        return list;
    }

    // ------------------------- COUNT ---------------------
    public static <T> int count(T[] array, T value) {
        return array.length;
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        int count = 0;
        for (Object i : iterable) {
            count++;
        }
        return count;
    }

    public static <T> int count(Iterator<T> iterator, T value) {
        int count = 0;
        if (iterator.hasNext()) {
            count++;
        }
        return count;
    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        int count = 0;
        if (pred.equals(false)) {
            return 0;
        }

        for (T i : array) {
            count++;
        }
        return count;
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        int count = 0;
        if (pred.equals(false)) {
            return 0;
        }

        for (T i : iterable) {
            count++;
        }
        return count;
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int count = 0;
        if (pred.equals(false)) {
            return 0;
        }

        if (iterator.hasNext()) {
            count++;
        }
        return count;
    }

    // ----------------------------- EXISTS -------------------------
    public static <T> boolean exists(T[] array, T value) {
        boolean result = false;
        for (T i : array) {
            if (i.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        boolean result = false;
        for (T i : iterable) {
            if (i.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        boolean result = false;
        while (iterator.hasNext()) {
            if (iterator.equals(value)) {
                result = true;
            }
        }
        return result;
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        boolean result = false;
        for (T i : array) {
            if (i.equals(pred)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        boolean result = false;
        for (T i : iterable) {
            if (i.equals(pred)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        boolean result = false;
        while (iterator.hasNext()) {
            if (iterator.equals(pred)) {
                result = true;
            }
        }
        return result;
    }

    //-------------------------------- FIND ----------------------------
    public static <T> T find(T[] array, T value) {
        for (T i : array) {
            if (i.equals(value)) {
                return i;
            }
        }
        // Jika nilai tidak terdapat pada list, maka akan return null
        return null;
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        for (T i : iterable) {
            if (i.equals(value)) {
                return i;
            }
        }
        // Jika nilai tidak terdapat pada list, maka akan return null
        return null;
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        while (iterator.hasNext()) {
            if (iterator.next().equals(value)) {
                return iterator.next();
            }
        }
        // Jika nilai tidak terdapat pada list, maka akan return null
        return null;
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        for (T i : array) {
            if (i.equals(pred)) {
                return i;
            }
        }
        // Jika nilai tidak terdapat pada list, maka akan return null
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        for (T i : iterable) {
            if (i.equals(pred)) {
                return i;
            }
        }
        // Jika nilai tidak terdapat pada list, maka akan return null
        return null;
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            if (iterator.next().equals(pred)) {
                return iterator.next();
            }
        }
        // Jika nilai tidak terdapat pada list, maka akan return null
        return null;
    }

    // ------------------ MAX --------------------------------
    public static <T> T max(T first, T second) {
        if (first.hashCode() > second.hashCode()) {
            return first;
        }
        else {
            return second;
        }
    }

    public static <T> T max (T[] array) {
        int max = 0;
        T maxT = null;
        for (T t : array) {
            if (t.hashCode() > max) {
                max = t.hashCode();
                maxT = t;
            }
        }
        return maxT;
    }

    public static <T> T max (Iterable<T> iterable) {
        int max = 0;
        T maxT = null;
        for (T t : iterable) {
            if (t.hashCode() > max) {
                max = t.hashCode();
                maxT = t;
            }
        }
        return maxT;
    }

    public static <T> T max (Iterator<T> iterator) {
        int max = 0;
        T maxT = null;
        while (iterator.hasNext()) {
            if (iterator.next().hashCode() > max) {
                max = iterator.next().hashCode();
                maxT = iterator.next();
            }
        }
        return maxT;
    }

    public static <T, comparator> T max (T first, T second, Comparator<? super T>comparator) {
        int res = ((Comparable<T>)first).compareTo(second);
        return res == -1 ? second : first;
    }

    public static <T, comparator> T max (T[] array, Comparator<? super T>comparator) {
        int max = 0;
        T maxT = null;
        for (T t : array) {
            if (t.hashCode() > max) {
                max = t.hashCode();
                maxT = t;
            }
        }
        int res = ((Comparable<T>)comparator).compareTo((T) array);
        return max(array, comparator);
    }

    public static <T, comparator> T max (Iterable<T> iterable, Comparator<? super T>comparator) {
        return null;
    }

    public static <T, comparator> T max (Iterator<T> iterator, Comparator<? super T>comparator) {
        return null;
    }

    // ------------------ MIN --------------------------------
    public static <T> T min(T first, T second) {
        if (first.hashCode() < second.hashCode()) {
            return first;
        }
        else {
            return second;
        }
    }

    public static <T> T min(T[] array) {
        int min = 0;
        T minT = null;
        for (T t : array) {
            if (t.hashCode() < min) {
                min = t.hashCode();
                minT = t;
            }
        }
        return minT;
    }

    public static <T> T min(Iterable<T> iterable) {
        int min = 0;
        T minT = null;
        for (T t : iterable) {
            if (t.hashCode() < min) {
                min = t.hashCode();
                minT = t;
            }
        }
        return minT;
    }

    public static <T> T min(Iterator<T> iterator) {
        int min = 0;
        T minT = null;
        while (iterator.hasNext()) {
            if (iterator.next().hashCode() < min) {
                min = iterator.next().hashCode();
                minT = iterator.next();
            }
        }
        return minT;
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

    // ------------------ PAGINATE --------------------------------
    public static <T> List paginate (T[] [] array, int page, int pageSize, Predicate<T> pred) {
        return null;
    }

    public static <T> List paginate (Iterable<T> iterable, int page, int pageSize, Predicate<T> predicate) {
        return null;
    }

    public static <T> List paginate (Iterator<T> iterator, int page, int pageSize, Predicate<T> predicate) {
        return null;
    }
}
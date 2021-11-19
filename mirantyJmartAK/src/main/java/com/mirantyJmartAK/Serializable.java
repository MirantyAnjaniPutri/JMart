package com.mirantyJmartAK;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Write a description of class Recognizable here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class Serializable implements Comparable<Serializable>
{
    public int id = 0;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap();

    protected Serializable () {
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    public static <T> int setClosingId(Class<T> clazz, int id) {
        return mapCounter.put(clazz, id);
    }

    public static <T> int getClosingId(Class<T> clazz) {
        return mapCounter.get(clazz);
    }

    public boolean equals (Object other) {
        return (other instanceof Serializable) && ((Serializable) other).id == id;
    }
    
    public boolean equals (Serializable other) {
        return other.id == id;
    }

    public int compareTo(Serializable other) {
        if (id == other.id) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Account id: " + new Account(null, null, null, -1).id);
        System.out.println("Account id: " + new Account(null, null, null, -1).id);
        System.out.println("Account id: " + new Account(null, null, null, -1).id);

        System.out.println("Payment id: " + new Payment(-1, -1, -1, null).id);
        System.out.println("Payment id: " + new Payment(-1, -1, -1, null).id);
        System.out.println("Payment id: " + new Payment(-1, -1, -1, null).id);
    }
}
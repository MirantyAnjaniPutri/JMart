package com.mirantyJmartAK;

import java.util.Iterator;
import java.util.Vector;
import java.util.function.Function;

public class ObjectPoolThread <T> extends Thread {
    private boolean exitSignal;
    private Vector<T> objectPool = new Vector<T>();
    private Function<T, Boolean> routine;

    public ObjectPoolThread(String name, Function<T,Boolean> routine) {
        super(name);
        this.routine = routine;
    }

    public ObjectPoolThread(Function<T,Boolean> routine) {
        this.routine = routine;
    }

    public void add (T object) {
        objectPool.add(object);
    }

    public void exit() {
        exitSignal = true;
    }

    public void run () {
        exitSignal = false;
        synchronized (this) {
            for (int i = 0; i < size(); i++) {
                T object = objectPool.get(i);
                boolean temporary = routine.apply(object);
                if (temporary == false) {
                    this.objectPool.add(object);
                }
                while (this.objectPool == null) {
                    try {
                        routine.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (exitSignal == true) {
                    break;
                }
            }
        }
    }

    public int size () {
        return objectPool.size();
    }
}

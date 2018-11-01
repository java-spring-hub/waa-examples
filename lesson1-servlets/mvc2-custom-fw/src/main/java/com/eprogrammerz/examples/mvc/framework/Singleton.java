package com.eprogrammerz.examples.mvc.framework;


// Sample implementation...not used
public class Singleton {
    // Private constructor. Prevents instantiation from other classes.
    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Initializes singleton.
     * <p>
     * SingletonHolder is loaded on the first execution of Singleton.getInstance()
     * or the first access to SingletonHolder.INSTANCE, not before.
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
}
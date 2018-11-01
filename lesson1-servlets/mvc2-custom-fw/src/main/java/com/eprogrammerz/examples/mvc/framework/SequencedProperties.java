package com.eprogrammerz.examples.mvc.framework;

import java.util.*;


public class SequencedProperties extends Properties {

    private static final long serialVersionUID = -7032434592318855760L;

    private List keyList = new ArrayList();

    @Override
    public synchronized Enumeration keys() {
        return Collections.enumeration(keyList);
    }

    @Override
    public synchronized Object put(Object key, Object value) {
        if (!containsKey(key)) {
            keyList.add(key);
        }

        return super.put(key, value);
    }

    @Override
    public synchronized Object remove(Object key) {
        keyList.remove(key);

        return super.remove(key);
    }

    @Override
    public synchronized void putAll(Map values) {
        for (Object key : values.keySet()) {
            if (!containsKey(key)) {
                keyList.add(key);
            }
        }

    }
}
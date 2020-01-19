package com.crossover.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cashe_Solution_LRU {

    private LinkedHashMap<Integer, Integer> cache;

    public Cashe_Solution_LRU(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 100.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (cache.containsValue(key)){
            return cache.get(key);
        }
        return -1;
    }

    public void set(int key, int val){
        cache.put(key, val);
    }

}

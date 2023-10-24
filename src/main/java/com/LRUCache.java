package com;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache{

    LRUMap map;

    public LRUCache(int capacity) {
        map = new LRUMap(capacity);
    }

    public int get(int key) {
        if(map.get(key)==null) {
            return -1;
        }
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }
}

class LRUMap extends LinkedHashMap<Integer,Integer> {
    private int capacity;


    public LRUMap(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> entry) {
        return super.size()>capacity;
    }
}

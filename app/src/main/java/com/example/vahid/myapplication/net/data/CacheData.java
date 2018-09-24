package com.example.vahid.myapplication.net.data;

import android.util.LruCache;

public class CacheData {

    LruCache<String,Object> cache;

    public CacheData (Integer size){
        cache=new LruCache<>(size);
    }

    public void add(String key,Object value){
        cache.put(key,value);
    }

    public Object get(String key){
        return cache.get(key);
    }

}

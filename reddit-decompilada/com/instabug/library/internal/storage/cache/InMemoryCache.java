package com.instabug.library.internal.storage.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class InMemoryCache<K, V> extends Cache<K, V> {
    private final LinkedHashMap<K, V> map;

    public InMemoryCache(String str) {
        this(str, 1);
    }

    public InMemoryCache(String str, int i) {
        super(str, i);
        this.map = new LinkedHashMap();
    }

    public V get(K k) {
        synchronized (this.map) {
            k = this.map.get(k);
        }
        return k;
    }

    public V put(K k, V v) {
        if (v == null || k == null) {
            return null;
        }
        synchronized (this.map) {
            k = this.map.put(k, v);
        }
        if (k == null) {
            notifyItemAdded(v);
            return v;
        }
        notifyItemUpdated(k, v);
        return k;
    }

    public V delete(K k) {
        synchronized (this.map) {
            k = this.map.remove(k);
        }
        if (k != null) {
            notifyItemRemoved(k);
        }
        return k;
    }

    public long size() {
        long size;
        synchronized (this.map) {
            size = (long) this.map.size();
        }
        return size;
    }

    public void invalidate() {
        synchronized (this.map) {
            this.map.clear();
        }
        notifyCacheInvalidated();
    }

    public List<V> getValues() {
        List<V> arrayList = new ArrayList();
        synchronized (this.map) {
            for (Object obj : this.map.keySet()) {
                arrayList.add(get(obj));
            }
        }
        return arrayList;
    }
}

package com.instabug.library.internal.storage.cache;

import java.util.ArrayList;
import java.util.List;

public abstract class Cache<K, V> {
    private int appVersion;
    private String id;
    private final List<CacheChangedListener<V>> listeners;

    public abstract V delete(K k);

    public abstract V get(K k);

    public abstract List<V> getValues();

    public abstract void invalidate();

    public abstract V put(K k, V v);

    public abstract long size();

    public Cache(String str) {
        this(str, 1);
    }

    protected Cache(String str, int i) {
        this.appVersion = -1;
        this.id = str;
        this.appVersion = i;
        this.listeners = new ArrayList();
    }

    public void notifyItemRemoved(V v) {
        for (CacheChangedListener onCachedItemRemoved : this.listeners) {
            onCachedItemRemoved.onCachedItemRemoved(v);
        }
    }

    public void notifyItemAdded(V v) {
        for (CacheChangedListener onCachedItemAdded : this.listeners) {
            onCachedItemAdded.onCachedItemAdded(v);
        }
    }

    public void notifyItemUpdated(V v, V v2) {
        for (CacheChangedListener onCachedItemUpdated : this.listeners) {
            onCachedItemUpdated.onCachedItemUpdated(v, v2);
        }
    }

    public void notifyCacheInvalidated() {
        for (CacheChangedListener onCacheInvalidated : this.listeners) {
            onCacheInvalidated.onCacheInvalidated();
        }
    }

    public String getId() {
        return this.id;
    }

    public int getAppVersion() {
        return this.appVersion;
    }

    public boolean addOnCacheChangedListener(CacheChangedListener<V> cacheChangedListener) {
        return (this.listeners.contains(cacheChangedListener) || this.listeners.add(cacheChangedListener) == null) ? null : true;
    }

    public boolean removeOnCacheChangedListener(CacheChangedListener<V> cacheChangedListener) {
        return this.listeners.remove(cacheChangedListener);
    }
}

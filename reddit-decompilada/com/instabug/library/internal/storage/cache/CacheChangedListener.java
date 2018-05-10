package com.instabug.library.internal.storage.cache;

public interface CacheChangedListener<V> {
    void onCacheInvalidated();

    void onCachedItemAdded(V v);

    void onCachedItemRemoved(V v);

    void onCachedItemUpdated(V v, V v2);
}

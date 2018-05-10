package com.instabug.library.internal.storage.cache;

import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;

public class CacheManager {
    public static final String DEFAULT_IN_MEMORY_CACHE_KEY = "DEFAULT_IN_MEMORY_CACHE_KEY";
    private static CacheManager INSTANCE;
    private final List<Cache> caches = new ArrayList();

    public static abstract class KeyExtractor<K, V> {
        public abstract K extractKey(V v);
    }

    public CacheManager() {
        this.caches.add(new InMemoryCache(DEFAULT_IN_MEMORY_CACHE_KEY));
    }

    public static synchronized CacheManager getInstance() {
        CacheManager cacheManager;
        synchronized (CacheManager.class) {
            if (INSTANCE == null) {
                INSTANCE = new CacheManager();
            }
            cacheManager = INSTANCE;
        }
        return cacheManager;
    }

    public Cache getCache(String str) {
        synchronized (this.caches) {
            for (Cache cache : this.caches) {
                if (cache.getId().equals(str)) {
                    return cache;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("No cache with this ID was found ");
            stringBuilder.append(str);
            stringBuilder.append(" returning null");
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            return null;
        }
    }

    public Cache addCache(Cache cache) {
        Cache cache2 = getCache(cache.getId());
        if (cache2 != null) {
            return cache2;
        }
        synchronized (this.caches) {
            this.caches.add(cache);
        }
        return cache;
    }

    public boolean deleteCache(String str) {
        Cache cache = getCache(str);
        if (cache != null) {
            synchronized (this.caches) {
                str = this.caches.remove(cache);
            }
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("No cache was this ID was found ");
        stringBuilder.append(str);
        stringBuilder.append(" to be deleted");
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        return null;
    }

    public boolean cacheExists(String str) {
        return getCache(str) != null ? true : null;
    }

    public boolean subscribe(String str, CacheChangedListener cacheChangedListener) {
        if (cacheExists(str)) {
            return getCache(str).addOnCacheChangedListener(cacheChangedListener);
        }
        throw new IllegalArgumentException("No cache exists with this ID to subscribe to");
    }

    public boolean unSubscribe(String str, CacheChangedListener cacheChangedListener) {
        return cacheExists(str) ? getCache(str).removeOnCacheChangedListener(cacheChangedListener) : null;
    }

    public void invalidateAllCaches() {
        synchronized (this.caches) {
            for (Cache invalidate : this.caches) {
                invalidate.invalidate();
            }
        }
        InstabugSDKLogger.m8356d(this, "All caches have been invalidated");
    }

    public void invalidateAllCachesButUserAttributes() {
        synchronized (this.caches) {
            for (Cache cache : this.caches) {
                if (!(cache.getId().equalsIgnoreCase(UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY) || cache.getId().equalsIgnoreCase(UserAttributesCacheManager.USER_ATTRIBUTES_DISK_CACHE_FILE_NAME) || cache.getId().equalsIgnoreCase(UserAttributesCacheManager.USER_ATTRIBUTES_DISK_CACHE_KEY) || cache.getId().equalsIgnoreCase(UserAttributesCacheManager.USER_ATTRIBUTES_MEMORY_CACHE_KEY))) {
                    cache.invalidate();
                }
            }
        }
        InstabugSDKLogger.m8356d(this, "All caches have been invalidated");
    }

    public <K, V> void migrateCache(String str, String str2, KeyExtractor<K, V> keyExtractor) throws IllegalArgumentException {
        Cache cache = getCache(str);
        Cache cache2 = getCache(str2);
        StringBuilder stringBuilder = new StringBuilder("Caches to be migrated ");
        stringBuilder.append(cache);
        stringBuilder.append(" - ");
        stringBuilder.append(cache2);
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        if (cache == null) {
            InstabugSDKLogger.m8358e(this, "Migration exception ", new IllegalArgumentException("No cache with these keys was found to migrate from"));
            return;
        }
        if (cache2 == null) {
            cache2 = new InMemoryCache(str2);
            addCache(cache2);
        }
        migrateCache(cache, cache2, (KeyExtractor) keyExtractor);
    }

    public <K, V> void migrateCache(Cache<K, V> cache, Cache<K, V> cache2, KeyExtractor<K, V> keyExtractor) {
        InstabugSDKLogger.m8356d(this, "Invalidated migratingTo cache");
        if (cache2 != null) {
            if (cache != null) {
                cache2.invalidate();
                cache = cache.getValues();
                if (cache != null) {
                    if (!cache.isEmpty()) {
                        for (Object next : cache) {
                            if (next != null) {
                                StringBuilder stringBuilder = new StringBuilder("Adding value ");
                                stringBuilder.append(next);
                                stringBuilder.append(" with key ");
                                stringBuilder.append(keyExtractor.extractKey(next));
                                InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                                cache2.put(keyExtractor.extractKey(next), next);
                            }
                        }
                        return;
                    }
                }
                InstabugSDKLogger.m8361w(this, "Cache to migrate from doesn't contain any elements, not going further with the migration");
                return;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("cache migration process got failure, migratingToCache: ");
        stringBuilder2.append(cache2);
        stringBuilder2.append(", migratingFromCache: ");
        stringBuilder2.append(cache);
        InstabugSDKLogger.m8361w(CacheManager.class, stringBuilder2.toString());
    }
}

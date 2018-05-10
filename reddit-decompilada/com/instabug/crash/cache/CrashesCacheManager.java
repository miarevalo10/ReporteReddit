package com.instabug.crash.cache;

import com.instabug.crash.models.Crash;
import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.CacheManager.KeyExtractor;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;

public class CrashesCacheManager {
    public static final String CRASHES_DISK_CACHE_FILE_NAME = "/crashes.cache";
    public static final String CRASHES_DISK_CACHE_KEY = "crashes_disk_cache";
    public static final String CRASHES_MEMORY_CACHE_KEY = "crashes_memory_cache";

    static class C13331 extends KeyExtractor<String, Crash> {
        C13331() {
        }

        public final /* synthetic */ Object extractKey(Object obj) {
            return ((Crash) obj).f15422a;
        }
    }

    static class C13342 extends KeyExtractor<String, Crash> {
        C13342() {
        }

        public final /* synthetic */ Object extractKey(Object obj) {
            return ((Crash) obj).f15422a;
        }
    }

    public static InMemoryCache<String, Crash> getCache() throws IllegalArgumentException {
        if (!CacheManager.getInstance().cacheExists(CRASHES_MEMORY_CACHE_KEY)) {
            StringBuilder stringBuilder = new StringBuilder("In-memory Crashes cache not found, loading it from disk ");
            stringBuilder.append(CacheManager.getInstance().getCache(CRASHES_MEMORY_CACHE_KEY));
            InstabugSDKLogger.m8356d(CrashesCacheManager.class, stringBuilder.toString());
            CacheManager.getInstance().migrateCache(CRASHES_DISK_CACHE_KEY, CRASHES_MEMORY_CACHE_KEY, new C13331());
            Cache cache = CacheManager.getInstance().getCache(CRASHES_MEMORY_CACHE_KEY);
            if (cache != null) {
                StringBuilder stringBuilder2 = new StringBuilder("In-memory Crashes cache restored from disk, ");
                stringBuilder2.append(cache.getValues().size());
                stringBuilder2.append(" elements restored");
                InstabugSDKLogger.m8356d(CrashesCacheManager.class, stringBuilder2.toString());
            }
        }
        InstabugSDKLogger.m8356d(CrashesCacheManager.class, "In-memory Crashes cache found");
        return (InMemoryCache) CacheManager.getInstance().getCache(CRASHES_MEMORY_CACHE_KEY);
    }

    public static void saveCacheToDisk() {
        Cache cache = CacheManager.getInstance().getCache(CRASHES_MEMORY_CACHE_KEY);
        Cache cache2 = CacheManager.getInstance().getCache(CRASHES_DISK_CACHE_KEY);
        if (cache != null && cache2 != null) {
            CacheManager.getInstance().migrateCache(cache, cache2, new C13342());
        }
    }

    public static void addCrash(Crash crash) {
        InMemoryCache cache = getCache();
        if (cache != null) {
            cache.put(crash.f15422a, crash);
        }
    }

    public static Crash getCrash(String str) {
        InMemoryCache cache = getCache();
        return cache != null ? (Crash) cache.get(str) : null;
    }

    public static List<Crash> getCrashes() {
        if (getCache() != null) {
            return getCache().getValues();
        }
        return new ArrayList();
    }

    public static Crash deleteCrash(String str) {
        return getCache() != null ? (Crash) getCache().delete(str) : null;
    }
}

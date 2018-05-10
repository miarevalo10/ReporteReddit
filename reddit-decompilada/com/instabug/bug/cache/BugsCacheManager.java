package com.instabug.bug.cache;

import android.content.Intent;
import com.instabug.bug.model.Bug;
import com.instabug.bug.model.Bug.BugState;
import com.instabug.bug.network.InstabugBugsUploaderService;
import com.instabug.library.Instabug;
import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.CacheManager.KeyExtractor;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;

public class BugsCacheManager {
    public static final String BUGS_DISK_CACHE_FILE_NAME = "/bugs.cache";
    public static final String BUGS_DISK_CACHE_KEY = "bugs_disk_cache";
    public static final String BUGS_MEMORY_CACHE_KEY = "bugs_memory_cache";

    static class C12621 extends KeyExtractor<String, Bug> {
        C12621() {
        }

        public final /* synthetic */ Object extractKey(Object obj) {
            return ((Bug) obj).getId();
        }
    }

    static class C12632 extends KeyExtractor<String, Bug> {
        C12632() {
        }

        public final /* synthetic */ Object extractKey(Object obj) {
            return ((Bug) obj).getId();
        }
    }

    public static InMemoryCache<String, Bug> getCache() throws IllegalArgumentException {
        if (!CacheManager.getInstance().cacheExists(BUGS_MEMORY_CACHE_KEY)) {
            StringBuilder stringBuilder = new StringBuilder("In-memory Bugs cache not found, loading it from disk ");
            stringBuilder.append(CacheManager.getInstance().getCache(BUGS_MEMORY_CACHE_KEY));
            InstabugSDKLogger.m8356d(BugsCacheManager.class, stringBuilder.toString());
            CacheManager.getInstance().migrateCache(BUGS_DISK_CACHE_KEY, BUGS_MEMORY_CACHE_KEY, new C12621());
            Cache cache = CacheManager.getInstance().getCache(BUGS_MEMORY_CACHE_KEY);
            if (cache != null) {
                StringBuilder stringBuilder2 = new StringBuilder("In-memory Bugs cache restored from disk, ");
                stringBuilder2.append(cache.getValues().size());
                stringBuilder2.append(" elements restored");
                InstabugSDKLogger.m8356d(BugsCacheManager.class, stringBuilder2.toString());
            }
        }
        InstabugSDKLogger.m8356d(BugsCacheManager.class, "In-memory Bugs cache found");
        return (InMemoryCache) CacheManager.getInstance().getCache(BUGS_MEMORY_CACHE_KEY);
    }

    public static void saveCacheToDisk() {
        Cache cache = CacheManager.getInstance().getCache(BUGS_MEMORY_CACHE_KEY);
        Cache cache2 = CacheManager.getInstance().getCache(BUGS_DISK_CACHE_KEY);
        if (cache != null && cache2 != null) {
            CacheManager.getInstance().migrateCache(cache, cache2, new C12632());
        }
    }

    public static void addBug(Bug bug) {
        InMemoryCache cache = getCache();
        if (cache != null) {
            cache.put(bug.getId(), bug);
        }
        sendBug(bug);
    }

    public static Bug getBug(String str) {
        InMemoryCache cache = getCache();
        return cache != null ? (Bug) cache.get(str) : null;
    }

    public static List<Bug> getBugs() {
        InMemoryCache cache = getCache();
        if (cache != null) {
            return cache.getValues();
        }
        return new ArrayList();
    }

    public static Bug deleteBug(String str) {
        InMemoryCache cache = getCache();
        return cache != null ? (Bug) cache.delete(str) : null;
    }

    private static void sendBug(Bug bug) {
        if (bug.f15315f == BugState.READY_TO_BE_SENT) {
            InstabugSDKLogger.m8356d(BugsCacheManager.class, "sending bug report to the server");
            Instabug.getApplicationContext().startService(new Intent(Instabug.getApplicationContext(), InstabugBugsUploaderService.class));
        }
    }
}

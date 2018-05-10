package com.instabug.library.internal.storage.cache;

import com.instabug.library.internal.storage.cache.CacheManager.KeyExtractor;
import com.instabug.library.model.C1388b;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.HashMap;

public class UserAttributesCacheManager {
    public static final String USER_ATTRIBUTES_CACHE_KEY = "attrs";
    public static final String USER_ATTRIBUTES_DISK_CACHE_FILE_NAME = "/user_attributes.cache";
    public static final String USER_ATTRIBUTES_DISK_CACHE_KEY = "user_attributes_disk_cache";
    public static final String USER_ATTRIBUTES_MEMORY_CACHE_KEY = "user_attributes_memory_cache";

    static class C13621 extends KeyExtractor<String, C1388b> {
        public final /* synthetic */ Object extractKey(Object obj) {
            return UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY;
        }

        C13621() {
        }
    }

    static class C13632 extends KeyExtractor<String, C1388b> {
        public final /* synthetic */ Object extractKey(Object obj) {
            return UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY;
        }

        C13632() {
        }
    }

    public static InMemoryCache<String, C1388b> getCache() {
        if (!CacheManager.getInstance().cacheExists(USER_ATTRIBUTES_MEMORY_CACHE_KEY)) {
            Cache cache = CacheManager.getInstance().getCache(USER_ATTRIBUTES_MEMORY_CACHE_KEY);
            StringBuilder stringBuilder = new StringBuilder("In-memory user attributes cache not found, loading it from disk ");
            stringBuilder.append(cache);
            InstabugSDKLogger.m8356d(UserAttributesCacheManager.class, stringBuilder.toString());
            CacheManager.getInstance().migrateCache(USER_ATTRIBUTES_DISK_CACHE_KEY, USER_ATTRIBUTES_MEMORY_CACHE_KEY, new C13621());
        }
        InstabugSDKLogger.m8356d(UserAttributesCacheManager.class, "In-memory user attributes cache found");
        return (InMemoryCache) CacheManager.getInstance().getCache(USER_ATTRIBUTES_MEMORY_CACHE_KEY);
    }

    public static void saveCacheToDisk() {
        Cache cache = CacheManager.getInstance().getCache(USER_ATTRIBUTES_MEMORY_CACHE_KEY);
        Cache cache2 = CacheManager.getInstance().getCache(USER_ATTRIBUTES_DISK_CACHE_KEY);
        if (cache != null && cache2 != null) {
            CacheManager.getInstance().migrateCache(cache, cache2, new C13632());
        }
    }

    public static void putAttribute(String str, String str2) {
        InMemoryCache cache = getCache();
        if (cache != null) {
            if (cache.get(USER_ATTRIBUTES_CACHE_KEY) == null) {
                cache.put(USER_ATTRIBUTES_CACHE_KEY, new C1388b());
            }
            C1388b c1388b = (C1388b) cache.get(USER_ATTRIBUTES_CACHE_KEY);
            if (c1388b.f15531a == null) {
                c1388b.f15531a = new HashMap();
            }
            c1388b.f15531a.put(str, str2);
        }
    }

    public static String getAttribute(String str) {
        InMemoryCache cache = getCache();
        if (cache != null) {
            C1388b c1388b = (C1388b) cache.get(USER_ATTRIBUTES_CACHE_KEY);
            if (c1388b != null) {
                return (String) c1388b.f15531a.get(str);
            }
        }
        return null;
    }

    public static void deleteAttribute(String str) {
        InMemoryCache cache = getCache();
        if (cache != null) {
            C1388b c1388b = (C1388b) cache.get(USER_ATTRIBUTES_CACHE_KEY);
            if (c1388b != null) {
                c1388b.f15531a.remove(str);
            }
        }
    }

    public static void deleteAll() {
        InMemoryCache cache = getCache();
        if (cache != null) {
            cache.invalidate();
        }
    }

    public static HashMap<String, String> getAll() {
        C1388b c1388b = getCache() != null ? (C1388b) getCache().get(USER_ATTRIBUTES_CACHE_KEY) : null;
        if (!(c1388b == null || c1388b.f15531a == null)) {
            if (!c1388b.f15531a.isEmpty()) {
                return c1388b.f15531a;
            }
        }
        return null;
    }

    public static String getUserAttributes() {
        String str = "{}";
        HashMap all = getAll();
        if (all == null || all.size() == 0) {
            return str;
        }
        C1388b c1388b = new C1388b();
        c1388b.f15531a = all;
        try {
            return c1388b.toJson();
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("parsing user attributes got error: ");
            stringBuilder.append(e.getMessage());
            InstabugSDKLogger.m8358e(State.class, stringBuilder.toString(), e);
            return str;
        }
    }
}

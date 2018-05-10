package com.instabug.library.internal.storage.cache;

import com.instabug.library.internal.storage.cache.CacheManager.KeyExtractor;
import com.instabug.library.model.Session;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;

public class SessionsCacheManager {
    public static final String SESSIONS_DISK_CACHE_FILE_NAME = "/sessions.cache";
    public static final String SESSIONS_DISK_CACHE_KEY = "sessions_disk_cache";
    public static final String SESSIONS_MEMORY_CACHE_KEY = "sessions_memory_cache";

    static class C13601 extends KeyExtractor<Long, Session> {
        C13601() {
        }

        public final /* synthetic */ Object extractKey(Object obj) {
            return Long.valueOf(((Session) obj).f15525b);
        }
    }

    public static InMemoryCache<Long, Session> getCache() throws IllegalArgumentException {
        if (!CacheManager.getInstance().cacheExists(SESSIONS_MEMORY_CACHE_KEY)) {
            StringBuilder stringBuilder = new StringBuilder("In-memory Sessions cache not found, loading it from disk ");
            stringBuilder.append(CacheManager.getInstance().getCache(SESSIONS_MEMORY_CACHE_KEY));
            InstabugSDKLogger.m8356d(SessionsCacheManager.class, stringBuilder.toString());
            CacheManager.getInstance().migrateCache(SESSIONS_DISK_CACHE_KEY, SESSIONS_MEMORY_CACHE_KEY, new C13601());
            Cache cache = CacheManager.getInstance().getCache(SESSIONS_MEMORY_CACHE_KEY);
            if (cache != null) {
                StringBuilder stringBuilder2 = new StringBuilder("In-memory Sessions cache restored from disk, ");
                stringBuilder2.append(cache.getValues().size());
                stringBuilder2.append(" elements restored");
                InstabugSDKLogger.m8356d(SessionsCacheManager.class, stringBuilder2.toString());
            }
        }
        InstabugSDKLogger.m8356d(SessionsCacheManager.class, "In-memory Sessions cache found");
        return (InMemoryCache) CacheManager.getInstance().getCache(SESSIONS_MEMORY_CACHE_KEY);
    }

    public static void saveCacheToDisk() {
        final Cache cache = CacheManager.getInstance().getCache(SESSIONS_MEMORY_CACHE_KEY);
        final Cache cache2 = CacheManager.getInstance().getCache(SESSIONS_DISK_CACHE_KEY);
        if (cache != null && cache2 != null) {
            new Thread(new Runnable() {

                class C13611 extends KeyExtractor<String, Session> {
                    final /* synthetic */ C06822 f15466a;

                    C13611(C06822 c06822) {
                        this.f15466a = c06822;
                    }

                    public /* synthetic */ Object extractKey(Object obj) {
                        return String.valueOf(((Session) obj).f15525b);
                    }
                }

                public final void run() {
                    CacheManager.getInstance().migrateCache(cache, cache2, new C13611(this));
                }
            }).start();
        }
    }

    public static void addSession(Session session) {
        InMemoryCache cache = getCache();
        if (cache != null) {
            cache.put(Long.valueOf(session.f15525b), session);
        }
    }

    public static Session getSession(long j) {
        InMemoryCache cache = getCache();
        return cache != null ? (Session) cache.get(Long.valueOf(j)) : 0;
    }

    public static Session deleteSession(Session session) {
        InMemoryCache cache = getCache();
        return cache != null ? (Session) cache.delete(Long.valueOf(session.f15525b)) : null;
    }

    public static List<Session> getSessions() {
        InMemoryCache cache = getCache();
        if (cache != null) {
            return cache.getValues();
        }
        return new ArrayList();
    }
}

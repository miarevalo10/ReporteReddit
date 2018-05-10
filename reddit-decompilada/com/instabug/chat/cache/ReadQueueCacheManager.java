package com.instabug.chat.cache;

import com.instabug.chat.model.C1309d;
import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.CacheManager.KeyExtractor;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadQueueCacheManager {
    public static final String READ_QUEUE_DISK_CACHE_FILE_NAME = "/read_queue.cache";
    public static final String READ_QUEUE_DISK_CACHE_KEY = "read_queue_disk_cache_key";
    public static final String READ_QUEUE_MEMORY_CACHE_KEY = "read_queue_memory_cache_key";
    private static ReadQueueCacheManager mReadQueueCacheManager;

    static class C13031 extends KeyExtractor<String, C1309d> {
        C13031() {
        }

        public final /* synthetic */ Object extractKey(Object obj) {
            return ((C1309d) obj).f15392a;
        }
    }

    static class C13042 extends KeyExtractor<String, C1309d> {
        C13042() {
        }

        public final /* synthetic */ Object extractKey(Object obj) {
            return String.valueOf(((C1309d) obj).f15392a);
        }
    }

    private ReadQueueCacheManager() {
        InstabugSDKLogger.m8356d(this, "Initializing ReadQueueCacheManager");
        CacheManager.getInstance().addCache(new InMemoryCache(READ_QUEUE_MEMORY_CACHE_KEY));
    }

    public static ReadQueueCacheManager getInstance() {
        if (mReadQueueCacheManager == null) {
            mReadQueueCacheManager = new ReadQueueCacheManager();
        }
        return mReadQueueCacheManager;
    }

    public static InMemoryCache<String, C1309d> getCache() {
        if (!CacheManager.getInstance().cacheExists(READ_QUEUE_MEMORY_CACHE_KEY) || CacheManager.getInstance().getCache(READ_QUEUE_MEMORY_CACHE_KEY).getValues().size() > 0) {
            StringBuilder stringBuilder = new StringBuilder("In-memory cache not found, loading it from disk ");
            stringBuilder.append(CacheManager.getInstance().getCache(READ_QUEUE_MEMORY_CACHE_KEY));
            InstabugSDKLogger.m8356d(ReadQueueCacheManager.class, stringBuilder.toString());
            CacheManager.getInstance().migrateCache(READ_QUEUE_DISK_CACHE_KEY, READ_QUEUE_MEMORY_CACHE_KEY, new C13031());
            Cache cache = CacheManager.getInstance().getCache(READ_QUEUE_MEMORY_CACHE_KEY);
            if (cache != null) {
                StringBuilder stringBuilder2 = new StringBuilder("In-memory cache restored from disk, ");
                stringBuilder2.append(cache.getValues().size());
                stringBuilder2.append(" elements restored");
                InstabugSDKLogger.m8356d(ReadQueueCacheManager.class, stringBuilder2.toString());
            }
        }
        InstabugSDKLogger.m8356d(ReadQueueCacheManager.class, "In-memory cache found");
        return (InMemoryCache) CacheManager.getInstance().getCache(READ_QUEUE_MEMORY_CACHE_KEY);
    }

    public static void saveCacheToDisk() {
        Cache cache = CacheManager.getInstance().getCache(READ_QUEUE_MEMORY_CACHE_KEY);
        Cache cache2 = CacheManager.getInstance().getCache(READ_QUEUE_DISK_CACHE_KEY);
        if (cache != null) {
            if (cache2 != null) {
                StringBuilder stringBuilder = new StringBuilder("Saving In-memory cache to disk, no. of items to save is ");
                stringBuilder.append(cache.getValues());
                InstabugSDKLogger.m8356d(ReadQueueCacheManager.class, stringBuilder.toString());
                CacheManager.getInstance().migrateCache(cache, cache2, new C13042());
            }
        }
    }

    public void add(C1309d c1309d) {
        StringBuilder stringBuilder = new StringBuilder("Adding message ");
        stringBuilder.append(c1309d);
        stringBuilder.append(" to read queue in-memory cache");
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        Cache cache = CacheManager.getInstance().getCache(READ_QUEUE_MEMORY_CACHE_KEY);
        if (cache != null) {
            cache.put(c1309d.f15392a, c1309d);
            StringBuilder stringBuilder2 = new StringBuilder("Added message ");
            stringBuilder2.append(c1309d);
            stringBuilder2.append(" to read queue in-memory cache ");
            stringBuilder2.append(cache.size());
            InstabugSDKLogger.m8360v(this, stringBuilder2.toString());
        }
    }

    public JSONArray getReadMessagesArray() {
        JSONArray jSONArray = new JSONArray();
        for (C1309d c1309d : getAll()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("chat_number", c1309d.f15392a);
                jSONObject.put("message_id", c1309d.f15394c);
                jSONObject.put("read_at", c1309d.f15393b);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray;
    }

    public List<C1309d> getAll() {
        Cache cache = CacheManager.getInstance().getCache(READ_QUEUE_MEMORY_CACHE_KEY);
        if (cache != null) {
            return cache.getValues();
        }
        return new ArrayList();
    }

    private void remove(String str) {
        Cache cache = CacheManager.getInstance().getCache(READ_QUEUE_MEMORY_CACHE_KEY);
        if (cache != null) {
            cache.delete(str);
        }
    }

    public void notify(List<C1309d> list) {
        for (C1309d c1309d : getAll()) {
            for (C1309d c1309d2 : list) {
                if (c1309d.f15392a.equals(c1309d2.f15392a) && c1309d.f15394c.equals(c1309d2.f15394c)) {
                    remove(c1309d2.f15392a);
                }
            }
        }
    }
}

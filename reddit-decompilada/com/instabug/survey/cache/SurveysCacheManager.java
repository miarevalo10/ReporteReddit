package com.instabug.survey.cache;

import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.CacheManager.KeyExtractor;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.p027a.C1413c;
import java.util.ArrayList;
import java.util.List;

public class SurveysCacheManager {
    public static final String SURVEYS_DISK_CACHE_FILE_NAME = "/surveys.cache";
    public static final String SURVEYS_DISK_CACHE_KEY = "surveys_disk_cache";
    public static final String SURVEYS_MEMORY_CACHE_KEY = "surveys_memory_cache";

    static class C14151 extends KeyExtractor<Long, C1413c> {
        C14151() {
        }

        public final /* synthetic */ Object extractKey(Object obj) {
            return Long.valueOf(((C1413c) obj).f15571a);
        }
    }

    static class C14162 extends KeyExtractor<String, C1413c> {
        C14162() {
        }

        public final /* synthetic */ Object extractKey(Object obj) {
            return String.valueOf(((C1413c) obj).f15571a);
        }
    }

    public static InMemoryCache<Long, C1413c> getCache() throws IllegalArgumentException {
        if (!CacheManager.getInstance().cacheExists(SURVEYS_MEMORY_CACHE_KEY)) {
            StringBuilder stringBuilder = new StringBuilder("In-memory Surveys cache not found, loading it from disk ");
            stringBuilder.append(CacheManager.getInstance().getCache(SURVEYS_MEMORY_CACHE_KEY));
            InstabugSDKLogger.m8356d(SurveysCacheManager.class, stringBuilder.toString());
            CacheManager.getInstance().migrateCache(SURVEYS_DISK_CACHE_KEY, SURVEYS_MEMORY_CACHE_KEY, new C14151());
            Cache cache = CacheManager.getInstance().getCache(SURVEYS_MEMORY_CACHE_KEY);
            if (cache != null) {
                StringBuilder stringBuilder2 = new StringBuilder("In-memory Surveys cache restored from disk, ");
                stringBuilder2.append(cache.size());
                stringBuilder2.append(" elements restored");
                InstabugSDKLogger.m8356d(SurveysCacheManager.class, stringBuilder2.toString());
            }
        }
        InstabugSDKLogger.m8356d(SurveysCacheManager.class, "In-memory Surveys cache found");
        return (InMemoryCache) CacheManager.getInstance().getCache(SURVEYS_MEMORY_CACHE_KEY);
    }

    public static void saveCacheToDisk() {
        Cache cache = CacheManager.getInstance().getCache(SURVEYS_DISK_CACHE_KEY);
        Cache cache2 = CacheManager.getInstance().getCache(SURVEYS_MEMORY_CACHE_KEY);
        if (cache != null && cache2 != null) {
            CacheManager.getInstance().migrateCache(cache2, cache, new C14162());
        }
    }

    public static void addSurvey(C1413c c1413c) {
        InMemoryCache cache = getCache();
        if (cache != null) {
            cache.put(Long.valueOf(c1413c.f15571a), c1413c);
        }
    }

    public static void addSurveys(List<C1413c> list) {
        for (C1413c addSurvey : list) {
            addSurvey(addSurvey);
        }
    }

    public static List<C1413c> getSurveys() {
        InMemoryCache cache = getCache();
        if (cache != null) {
            return cache.getValues();
        }
        return new ArrayList();
    }

    public static List<C1413c> getNotAnsweredSurveys() {
        List<C1413c> arrayList = new ArrayList();
        InMemoryCache cache = getCache();
        if (cache != null) {
            for (C1413c c1413c : cache.getValues()) {
                if ((c1413c.f15572b == null || String.valueOf(c1413c.f15572b).equals("null")) && !c1413c.f15578h) {
                    arrayList.add(c1413c);
                    StringBuilder stringBuilder = new StringBuilder("survey id: ");
                    stringBuilder.append(c1413c.f15571a);
                    InstabugSDKLogger.m8356d(SurveysCacheManager.class, stringBuilder.toString());
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("NotAnsweredSurveys size: ");
        stringBuilder2.append(arrayList.size());
        InstabugSDKLogger.m8356d(SurveysCacheManager.class, stringBuilder2.toString());
        return arrayList;
    }

    public static List<C1413c> getAnsweredAndNotSubmittedSurveys() {
        List<C1413c> arrayList = new ArrayList();
        InMemoryCache cache = getCache();
        if (cache != null) {
            List<C1413c> values = cache.getValues();
            StringBuilder stringBuilder = new StringBuilder("size: ");
            stringBuilder.append(values.size());
            InstabugSDKLogger.m8356d(SurveysCacheManager.class, stringBuilder.toString());
            for (C1413c c1413c : values) {
                if (c1413c.f15578h && !c1413c.f15579i) {
                    arrayList.add(c1413c);
                }
            }
        }
        return arrayList;
    }
}

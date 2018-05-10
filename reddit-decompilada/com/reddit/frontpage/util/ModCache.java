package com.reddit.frontpage.util;

import android.util.LruCache;

public class ModCache {
    final LruCache<String, Boolean> CACHE_APPROVED = new LruCache(30);
    final LruCache<String, Boolean> CACHE_DISTINGUISH = new LruCache(30);
    final LruCache<String, Boolean> CACHE_DISTINGUISH_ADMIN = new LruCache(30);
    final LruCache<String, Boolean> CACHE_PINS = new LruCache(30);
    final LruCache<String, Boolean> CACHE_REMOVED = new LruCache(30);
    final int CACHE_SIZE = 30;
    final LruCache<String, Boolean> CACHE_SPAM = new LruCache(30);

    ModCache() {
    }

    public void cacheApprovedState(String str, Boolean bool) {
        if (bool.booleanValue()) {
            this.CACHE_REMOVED.remove(str);
            this.CACHE_SPAM.remove(str);
        }
        putValue(this.CACHE_APPROVED, str, bool);
    }

    public boolean getApprovedState(String str, boolean z) {
        return getValue(this.CACHE_APPROVED, str, Boolean.valueOf(z));
    }

    public void cacheRemovedState(String str, Boolean bool) {
        if (bool.booleanValue()) {
            this.CACHE_APPROVED.remove(str);
            this.CACHE_SPAM.remove(str);
        }
        putValue(this.CACHE_REMOVED, str, bool);
    }

    public boolean getRemovedState(String str, boolean z) {
        return getValue(this.CACHE_REMOVED, str, Boolean.valueOf(z));
    }

    public void cacheStickyState(String str, Boolean bool) {
        putValue(this.CACHE_PINS, str, bool);
    }

    public boolean getStickyState(String str, boolean z) {
        return getValue(this.CACHE_PINS, str, Boolean.valueOf(z));
    }

    public void cacheDistinguishState(String str, Boolean bool) {
        putValue(this.CACHE_DISTINGUISH, str, bool);
    }

    public boolean getDistinguishState(String str, boolean z) {
        return getValue(this.CACHE_DISTINGUISH, str, Boolean.valueOf(z));
    }

    public void cacheDistinguishAdminState(String str, Boolean bool) {
        putValue(this.CACHE_DISTINGUISH_ADMIN, str, bool);
    }

    public boolean getDistinguishAdminState(String str, boolean z) {
        return getValue(this.CACHE_DISTINGUISH_ADMIN, str, Boolean.valueOf(z));
    }

    public void clearCache() {
        this.CACHE_APPROVED.evictAll();
        this.CACHE_REMOVED.evictAll();
        this.CACHE_PINS.evictAll();
        this.CACHE_SPAM.evictAll();
        this.CACHE_DISTINGUISH.evictAll();
        this.CACHE_DISTINGUISH_ADMIN.evictAll();
    }

    void putValue(LruCache<String, Boolean> lruCache, String str, Boolean bool) {
        lruCache.put(str, bool);
    }

    public boolean getValue(LruCache<String, Boolean> lruCache, String str, Boolean bool) {
        Boolean bool2 = (Boolean) lruCache.get(str);
        if (bool2 == null) {
            return bool.booleanValue();
        }
        return bool2.booleanValue();
    }
}

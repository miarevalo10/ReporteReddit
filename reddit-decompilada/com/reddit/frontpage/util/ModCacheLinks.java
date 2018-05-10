package com.reddit.frontpage.util;

import android.util.LruCache;

public class ModCacheLinks extends ModCache {
    final LruCache<String, Boolean> f29387a = new LruCache(30);
    final LruCache<String, Boolean> f29388b = new LruCache(30);
    final LruCache<String, Boolean> f29389c = new LruCache(30);
    public final LruCache<String, Boolean> f29390d = new LruCache(30);
    public final LruCache<String, Boolean> f29391e = new LruCache(30);
    public final LruCache<String, Boolean> f29392f = new LruCache(30);

    public final void m30452a(String str, Boolean bool) {
        putValue(this.f29387a, str, bool);
    }

    public final boolean m30453a(String str, boolean z) {
        return getValue(this.f29387a, str, Boolean.valueOf(z));
    }

    public final void m30454b(String str, Boolean bool) {
        putValue(this.f29388b, str, bool);
    }

    public final boolean m30455b(String str, boolean z) {
        return getValue(this.f29388b, str, Boolean.valueOf(z));
    }

    public final void m30456c(String str, Boolean bool) {
        putValue(this.f29389c, str, bool);
    }

    public final boolean m30457c(String str, boolean z) {
        return getValue(this.f29389c, str, Boolean.valueOf(z));
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

    public final boolean m30459d(String str, boolean z) {
        return getValue(this.CACHE_SPAM, str, Boolean.valueOf(z));
    }

    public final void m30458d(String str, Boolean bool) {
        if (bool.booleanValue()) {
            this.CACHE_APPROVED.remove(str);
            this.CACHE_REMOVED.remove(str);
        }
        putValue(this.CACHE_SPAM, str, bool);
    }

    public final void m30460e(String str, Boolean bool) {
        putValue(this.f29390d, str, bool);
    }

    public final void m30461f(String str, Boolean bool) {
        putValue(this.f29391e, str, bool);
    }

    public final void m30462g(String str, Boolean bool) {
        putValue(this.f29392f, str, bool);
    }

    public void clearCache() {
        super.clearCache();
        this.f29387a.evictAll();
        this.f29388b.evictAll();
        this.f29389c.evictAll();
        this.CACHE_SPAM.evictAll();
        this.f29390d.evictAll();
        this.f29391e.evictAll();
        this.f29392f.evictAll();
    }
}

package com.reddit.frontpage.util;

import android.util.LruCache;

public final class VoteUtil {
    private static final LruCache<String, Integer> f21820a = new LruCache(100);

    public static void m24066a(String str, Integer num) {
        f21820a.put(str, num);
    }

    public static Integer m24064a(String str) {
        return (Integer) f21820a.get(str);
    }

    public static void m24065a() {
        f21820a.evictAll();
    }
}

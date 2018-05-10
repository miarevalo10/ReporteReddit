package com.google.android.exoplayer2.upstream.cache;

import java.io.File;

public class CacheSpan implements Comparable<CacheSpan> {
    public final String f5192a;
    public final long f5193b;
    public final long f5194c;
    public final boolean f5195d;
    public final File f5196e;
    public final long f5197f;

    public /* synthetic */ int compareTo(Object obj) {
        CacheSpan cacheSpan = (CacheSpan) obj;
        if (!this.f5192a.equals(cacheSpan.f5192a)) {
            return this.f5192a.compareTo(cacheSpan.f5192a);
        }
        obj = ((this.f5193b - cacheSpan.f5193b) > 0 ? 1 : ((this.f5193b - cacheSpan.f5193b) == 0 ? 0 : -1));
        if (obj == null) {
            return null;
        }
        return obj < null ? -1 : 1;
    }

    public CacheSpan(String str, long j, long j2, long j3, File file) {
        this.f5192a = str;
        this.f5193b = j;
        this.f5194c = j2;
        this.f5195d = file != null ? true : null;
        this.f5196e = file;
        this.f5197f = j3;
    }
}

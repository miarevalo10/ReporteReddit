package com.google.android.exoplayer2.upstream.cache;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.TreeSet;

final class CachedContent {
    public final int f5198a;
    public final String f5199b;
    final TreeSet<SimpleCacheSpan> f5200c;
    long f5201d;

    public CachedContent(DataInputStream dataInputStream) throws IOException {
        this(dataInputStream.readInt(), dataInputStream.readUTF(), dataInputStream.readLong());
    }

    public CachedContent(int i, String str, long j) {
        this.f5198a = i;
        this.f5199b = str;
        this.f5201d = j;
        this.f5200c = new TreeSet();
    }

    public final SimpleCacheSpan m4170a(long j) {
        SimpleCacheSpan a = SimpleCacheSpan.m12710a(this.f5199b, j);
        SimpleCacheSpan simpleCacheSpan = (SimpleCacheSpan) this.f5200c.floor(a);
        if (simpleCacheSpan != null && simpleCacheSpan.b + simpleCacheSpan.c > j) {
            return simpleCacheSpan;
        }
        a = (SimpleCacheSpan) this.f5200c.ceiling(a);
        if (a == null) {
            return SimpleCacheSpan.m12713b(this.f5199b, j);
        }
        return SimpleCacheSpan.m12711a(this.f5199b, j, a.b - j);
    }

    public final long m4169a(long j, long j2) {
        CacheSpan a = m4170a(j);
        int i = 1;
        if ((a.f5195d ^ 1) != 0) {
            if (a.f5194c != -1) {
                i = 0;
            }
            return -Math.min(i != 0 ? Long.MAX_VALUE : a.c, j2);
        }
        long j3 = j + j2;
        long j4 = a.b + a.c;
        if (j4 < j3) {
            for (SimpleCacheSpan simpleCacheSpan : this.f5200c.tailSet(a, false)) {
                if (simpleCacheSpan.b > j4) {
                    break;
                }
                j4 = Math.max(j4, simpleCacheSpan.b + simpleCacheSpan.c);
                if (j4 >= j3) {
                    break;
                }
            }
        }
        return Math.min(j4 - j, j2);
    }

    public final int m4168a() {
        return (31 * ((this.f5198a * 31) + this.f5199b.hashCode())) + ((int) (this.f5201d ^ (this.f5201d >>> 32)));
    }
}

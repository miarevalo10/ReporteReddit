package com.google.common.cache;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class CacheStats {
    final long f8271a;
    final long f8272b;
    final long f8273c;
    final long f8274d;
    final long f8275e;
    final long f8276f;

    public CacheStats(long j, long j2, long j3, long j4, long j5, long j6) {
        CacheStats cacheStats = this;
        long j7 = j;
        long j8 = j2;
        long j9 = j3;
        long j10 = j4;
        long j11 = j5;
        long j12 = j6;
        Preconditions.m6913a(j7 >= 0);
        Preconditions.m6913a(j8 >= 0);
        Preconditions.m6913a(j9 >= 0);
        Preconditions.m6913a(j10 >= 0);
        Preconditions.m6913a(j11 >= 0);
        Preconditions.m6913a(j12 >= 0);
        cacheStats.f8271a = j7;
        cacheStats.f8272b = j8;
        cacheStats.f8273c = j9;
        cacheStats.f8274d = j10;
        cacheStats.f8275e = j11;
        cacheStats.f8276f = j12;
    }

    public final int hashCode() {
        return Objects.m14556a(Long.valueOf(this.f8271a), Long.valueOf(this.f8272b), Long.valueOf(this.f8273c), Long.valueOf(this.f8274d), Long.valueOf(this.f8275e), Long.valueOf(this.f8276f));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CacheStats)) {
            return false;
        }
        CacheStats cacheStats = (CacheStats) obj;
        if (this.f8271a == cacheStats.f8271a && this.f8272b == cacheStats.f8272b && this.f8273c == cacheStats.f8273c && this.f8274d == cacheStats.f8274d && this.f8275e == cacheStats.f8275e && this.f8276f == cacheStats.f8276f) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return MoreObjects.m6894a(this).m6892a("hitCount", this.f8271a).m6892a("missCount", this.f8272b).m6892a("loadSuccessCount", this.f8273c).m6892a("loadExceptionCount", this.f8274d).m6892a("totalLoadTime", this.f8275e).m6892a("evictionCount", this.f8276f).toString();
    }
}

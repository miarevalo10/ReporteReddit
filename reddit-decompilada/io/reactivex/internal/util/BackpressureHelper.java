package io.reactivex.internal.util;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;

public final class BackpressureHelper {
    public static long m26669a(long j, long j2) {
        j += j2;
        return j < 0 ? Long.MAX_VALUE : j;
    }

    public static long m26671b(long j, long j2) {
        long j3 = j * j2;
        return (((j | j2) >>> 31) == 0 || j3 / j == j2) ? j3 : Long.MAX_VALUE;
    }

    public static long m26670a(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j2, m26669a(j2, j)));
        return j2;
    }

    public static long m26672b(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j2, m26669a(j2, j)));
        return j2;
    }

    public static long m26673c(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j2 = j3 - j;
            if (j2 < 0) {
                StringBuilder stringBuilder = new StringBuilder("More produced than requested: ");
                stringBuilder.append(j2);
                RxJavaPlugins.m26757a(new IllegalStateException(stringBuilder.toString()));
                j2 = 0;
            }
        } while (!atomicLong.compareAndSet(j3, j2));
        return j2;
    }

    public static long m26674d(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j3 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j2 = j3 - j;
            if (j2 < 0) {
                StringBuilder stringBuilder = new StringBuilder("More produced than requested: ");
                stringBuilder.append(j2);
                RxJavaPlugins.m26757a(new IllegalStateException(stringBuilder.toString()));
                j2 = 0;
            }
        } while (!atomicLong.compareAndSet(j3, j2));
        return j2;
    }
}

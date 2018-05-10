package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;

public final class BackpressureUtils {
    public static long m43444a(long j, long j2) {
        j += j2;
        return j < 0 ? Long.MAX_VALUE : j;
    }

    public static long m43445a(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, m43444a(j2, j)));
        return j2;
    }

    public static long m43447b(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j2 = j3 - j;
            if (j2 < 0) {
                j = new StringBuilder("More produced than requested: ");
                j.append(j2);
                throw new IllegalStateException(j.toString());
            }
        } while (!atomicLong.compareAndSet(j3, j2));
        return j2;
    }

    public static boolean m43446a(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            return i != 0 ? 1 : 0;
        } else {
            StringBuilder stringBuilder = new StringBuilder("n >= 0 required but it was ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}

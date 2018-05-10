package rx.internal.util.unsafe;

public abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {
    private static final long f42029e = ((long) (UnsafeAccess.f41383a.arrayBaseOffset(long[].class) + (32 << (f42030f - a))));
    private static final int f42030f = (3 + a);
    protected final long[] f42031d;

    static {
        if (8 == UnsafeAccess.f41383a.arrayIndexScale(long[].class)) {
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public ConcurrentSequencedCircularArrayQueue(int i) {
        super(i);
        i = (int) (this.b + 1);
        this.f42031d = new long[((i << a) + 64)];
        for (long j = 0; j < ((long) i); j++) {
            m44131a(this.f42031d, m44132d(j), j);
        }
    }

    protected final long m44132d(long j) {
        return f42029e + ((j & this.b) << f42030f);
    }

    protected static void m44131a(long[] jArr, long j, long j2) {
        UnsafeAccess.f41383a.putOrderedLong(jArr, j, j2);
    }

    protected static long m44130a(long[] jArr, long j) {
        return UnsafeAccess.f41383a.getLongVolatile(jArr, j);
    }
}

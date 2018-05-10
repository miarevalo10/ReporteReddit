package rx.internal.util.unsafe;

import java.util.Iterator;

public abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueueL0Pad<E> {
    protected static final int f41811a = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long f41812d = ((long) (UnsafeAccess.f41383a.arrayBaseOffset(Object[].class) + (32 << (f41813e - f41811a))));
    private static final int f41813e;
    protected final long f41814b;
    protected final E[] f41815c;

    static {
        int arrayIndexScale = UnsafeAccess.f41383a.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f41813e = 2 + f41811a;
        } else if (8 == arrayIndexScale) {
            f41813e = 3 + f41811a;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
    }

    public ConcurrentCircularArrayQueue(int i) {
        i = Pow2.m43481a(i);
        this.f41814b = (long) (i - 1);
        this.f41815c = (Object[]) new Object[((i << f41811a) + 64)];
    }

    protected final long m43917a(long j) {
        return f41812d + ((j & this.f41814b) << f41813e);
    }

    protected final void m43918a(long j, E e) {
        m43914a(this.f41815c, j, e);
    }

    protected static void m43914a(E[] eArr, long j, E e) {
        UnsafeAccess.f41383a.putObject(eArr, j, e);
    }

    protected static void m43916b(E[] eArr, long j, E e) {
        UnsafeAccess.f41383a.putOrderedObject(eArr, j, e);
    }

    protected final E m43919b(long j) {
        return m43913a(this.f41815c, j);
    }

    protected static E m43913a(E[] eArr, long j) {
        return UnsafeAccess.f41383a.getObject(eArr, j);
    }

    protected final E m43920c(long j) {
        return m43915b(this.f41815c, j);
    }

    protected static E m43915b(E[] eArr, long j) {
        return UnsafeAccess.f41383a.getObjectVolatile(eArr, j);
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }
}

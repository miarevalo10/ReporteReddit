package rx.internal.util.unsafe;

public final class SpscArrayQueue<E> extends SpscArrayQueueL3Pad<E> {
    public SpscArrayQueue(int i) {
        super(i);
    }

    public final boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        Object[] objArr = this.c;
        long j = this.producerIndex;
        long a = m43917a(j);
        if (ConcurrentCircularArrayQueue.m43915b(objArr, a) != null) {
            return null;
        }
        ConcurrentCircularArrayQueue.m43916b(objArr, a, e);
        UnsafeAccess.f41383a.putOrderedLong(this, f, j + 1);
        return true;
    }

    public final E poll() {
        long j = this.consumerIndex;
        long a = m43917a(j);
        Object[] objArr = this.c;
        E b = ConcurrentCircularArrayQueue.m43915b(objArr, a);
        if (b == null) {
            return null;
        }
        ConcurrentCircularArrayQueue.m43916b(objArr, a, null);
        UnsafeAccess.f41383a.putOrderedLong(this, e, j + 1);
        return b;
    }

    public final E peek() {
        return m43920c(m43917a(this.consumerIndex));
    }

    public final int size() {
        long b = m44248b();
        while (true) {
            long a = m44247a();
            long b2 = m44248b();
            if (b == b2) {
                return (int) (a - b2);
            }
            b = b2;
        }
    }

    public final boolean isEmpty() {
        return m44247a() == m44248b();
    }

    private long m44247a() {
        return UnsafeAccess.f41383a.getLongVolatile(this, f);
    }

    private long m44248b() {
        return UnsafeAccess.f41383a.getLongVolatile(this, e);
    }
}

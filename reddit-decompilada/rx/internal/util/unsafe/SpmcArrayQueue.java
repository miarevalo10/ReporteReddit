package rx.internal.util.unsafe;

public final class SpmcArrayQueue<E> extends SpmcArrayQueueL3Pad<E> {
    public SpmcArrayQueue(int i) {
        super(i);
    }

    public final boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        Object[] objArr = this.c;
        long j = this.b;
        long j2 = this.producerIndex;
        long a = m43917a(j2);
        if (ConcurrentCircularArrayQueue.m43915b(objArr, a) == null) {
            ConcurrentCircularArrayQueue.m43914a(objArr, a, e);
            m44214d(j2 + 1);
        } else if (j2 - this.consumerIndex > j) {
            return null;
        } else {
            do {
            } while (ConcurrentCircularArrayQueue.m43915b(objArr, a) != null);
        }
        ConcurrentCircularArrayQueue.m43914a(objArr, a, e);
        m44214d(j2 + 1);
        return true;
    }

    public final E poll() {
        long j;
        long j2 = this.f42070f;
        do {
            j = this.consumerIndex;
            if (j >= j2) {
                long j3 = this.producerIndex;
                if (j >= j3) {
                    return null;
                }
                this.f42070f = j3;
            }
        } while (!m44246a(j, 1 + j));
        j2 = m43917a(j);
        Object[] objArr = this.c;
        E a = ConcurrentCircularArrayQueue.m43913a(objArr, j2);
        ConcurrentCircularArrayQueue.m43916b(objArr, j2, null);
        return a;
    }

    public final E peek() {
        E c;
        long j = this.f42070f;
        do {
            long j2 = this.consumerIndex;
            if (j2 >= j) {
                long j3 = this.producerIndex;
                if (j2 >= j3) {
                    return null;
                }
                this.f42070f = j3;
            }
            c = m43920c(m43917a(j2));
        } while (c == null);
        return c;
    }

    public final int size() {
        long j = this.consumerIndex;
        while (true) {
            long j2 = this.producerIndex;
            long j3 = this.consumerIndex;
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    public final boolean isEmpty() {
        return this.consumerIndex == this.producerIndex;
    }
}

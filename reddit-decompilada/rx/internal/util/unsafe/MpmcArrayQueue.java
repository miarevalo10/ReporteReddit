package rx.internal.util.unsafe;

public class MpmcArrayQueue<E> extends MpmcArrayQueueConsumerField<E> {
    public MpmcArrayQueue(int i) {
        super(Math.max(2, i));
    }

    public boolean offer(E e) {
        MpmcArrayQueueProducerField mpmcArrayQueueProducerField = this;
        E e2 = e;
        if (e2 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        long j = 1;
        long j2 = mpmcArrayQueueProducerField.b + 1;
        long[] jArr = mpmcArrayQueueProducerField.d;
        long j3 = Long.MAX_VALUE;
        while (true) {
            long j4;
            long j5 = mpmcArrayQueueProducerField.producerIndex;
            long d = m44132d(j5);
            int i = ((ConcurrentSequencedCircularArrayQueue.m44130a(jArr, d) - j5) > 0 ? 1 : ((ConcurrentSequencedCircularArrayQueue.m44130a(jArr, d) - j5) == 0 ? 0 : -1));
            if (i == 0) {
                long j6 = j5 + j;
                j = d;
                j4 = j2;
                j2 = j5;
                if (UnsafeAccess.f41383a.compareAndSwapLong(mpmcArrayQueueProducerField, MpmcArrayQueueProducerField.f42065f, j5, j6)) {
                    m43918a(m43917a(j2), (Object) e2);
                    ConcurrentSequencedCircularArrayQueue.m44131a(jArr, j, j6);
                    return true;
                }
            } else {
                j4 = j2;
                j2 = j5;
                if (i < 0) {
                    j5 = j2 - j4;
                    if (j5 <= j3) {
                        long j7 = mpmcArrayQueueProducerField.consumerIndex;
                        if (j5 <= j7) {
                            return false;
                        }
                        j3 = j7;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            j2 = j4;
            j = 1;
        }
    }

    public E poll() {
        E e;
        long[] jArr = this.d;
        long j = -1;
        long j2;
        do {
            long j3 = j;
            while (true) {
                long j4;
                j2 = r8.consumerIndex;
                long d = m44132d(j2);
                long j5 = j2 + 1;
                int i = ((ConcurrentSequencedCircularArrayQueue.m44130a(jArr, d) - j5) > 0 ? 1 : ((ConcurrentSequencedCircularArrayQueue.m44130a(jArr, d) - j5) == 0 ? 0 : -1));
                if (i == 0) {
                    j4 = j3;
                    Object obj = null;
                    if (UnsafeAccess.f41383a.compareAndSwapLong(r8, MpmcArrayQueueConsumerField.f42068e, j2, j5)) {
                        j = m43917a(j2);
                        E b = m43919b(j);
                        m43918a(j, obj);
                        ConcurrentSequencedCircularArrayQueue.m44131a(jArr, d, (j2 + r8.b) + 1);
                        return b;
                    }
                } else {
                    j4 = j3;
                    e = null;
                    if (i < 0 && j2 >= j4) {
                        j = r8.producerIndex;
                    }
                }
                j3 = j4;
            }
        } while (j2 != j);
        return e;
    }

    public E peek() {
        E b;
        long j;
        do {
            j = this.consumerIndex;
            b = m43919b(m43917a(j));
            if (b != null) {
                break;
            }
        } while (j != this.producerIndex);
        return b;
    }

    public int size() {
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

    public boolean isEmpty() {
        return this.consumerIndex == this.producerIndex;
    }
}

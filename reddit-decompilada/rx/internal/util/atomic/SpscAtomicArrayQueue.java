package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscAtomicArrayQueue<E> extends AtomicReferenceArrayQueue<E> {
    private static final Integer f41806g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong f41807c = new AtomicLong();
    long f41808d;
    final AtomicLong f41809e = new AtomicLong();
    final int f41810f;

    public final /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public SpscAtomicArrayQueue(int i) {
        super(i);
        this.f41810f = Math.min(i / 4, f41806g.intValue());
    }

    public final boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.a;
        int i = this.b;
        long j = this.f41807c.get();
        int i2 = ((int) j) & i;
        if (j >= this.f41808d) {
            long j2 = ((long) this.f41810f) + j;
            if (atomicReferenceArray.get(i & ((int) j2)) == null) {
                this.f41808d = j2;
            } else if (atomicReferenceArray.get(i2) != null) {
                return null;
            }
        }
        atomicReferenceArray.lazySet(i2, e);
        this.f41807c.lazySet(j + 1);
        return true;
    }

    public final E poll() {
        long j = this.f41809e.get();
        int a = m43475a(j);
        AtomicReferenceArray atomicReferenceArray = this.a;
        E e = atomicReferenceArray.get(a);
        if (e == null) {
            return null;
        }
        atomicReferenceArray.lazySet(a, null);
        this.f41809e.lazySet(j + 1);
        return e;
    }

    public final E peek() {
        return m43476a(m43475a(this.f41809e.get()));
    }

    public final int size() {
        long j = this.f41809e.get();
        while (true) {
            long j2 = this.f41807c.get();
            long j3 = this.f41809e.get();
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    public final boolean isEmpty() {
        return this.f41807c.get() == this.f41809e.get();
    }
}

package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

abstract class AtomicReferenceArrayQueue<E> extends AbstractQueue<E> {
    protected final AtomicReferenceArray<E> f41367a;
    protected final int f41368b;

    public AtomicReferenceArrayQueue(int i) {
        i = Pow2.m43481a(i);
        this.f41368b = i - 1;
        this.f41367a = new AtomicReferenceArray(i);
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

    protected final int m43475a(long j) {
        return ((int) j) & this.f41368b;
    }

    protected final E m43476a(int i) {
        return this.f41367a.get(i);
    }
}

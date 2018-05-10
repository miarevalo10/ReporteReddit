package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

public final class SpscUnboundedAtomicArrayQueue<T> implements Queue<T> {
    static final int f41373a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object f41374j = new Object();
    final AtomicLong f41375b = new AtomicLong();
    int f41376c;
    long f41377d;
    int f41378e;
    AtomicReferenceArray<Object> f41379f;
    int f41380g;
    AtomicReferenceArray<Object> f41381h;
    final AtomicLong f41382i = new AtomicLong();

    public SpscUnboundedAtomicArrayQueue(int i) {
        i = Pow2.m43481a(Math.max(8, i));
        int i2 = i - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i + 1);
        this.f41379f = atomicReferenceArray;
        this.f41378e = i2;
        this.f41376c = Math.min(i / 4, f41373a);
        this.f41381h = atomicReferenceArray;
        this.f41380g = i2;
        this.f41377d = (long) (i2 - 1);
        m43478a(0);
    }

    public final boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray atomicReferenceArray = this.f41379f;
        long j = this.f41375b.get();
        int i = this.f41378e;
        int i2 = ((int) j) & i;
        if (j < this.f41377d) {
            return m43479a(atomicReferenceArray, t, j, i2);
        }
        long j2 = ((long) this.f41376c) + j;
        if (atomicReferenceArray.get(((int) j2) & i) == null) {
            this.f41377d = j2 - 1;
            return m43479a(atomicReferenceArray, t, j, i2);
        }
        j2 = j + 1;
        if (atomicReferenceArray.get(((int) j2) & i) != null) {
            return m43479a(atomicReferenceArray, t, j, i2);
        }
        long j3 = (long) i;
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f41379f = atomicReferenceArray2;
        this.f41377d = (j + j3) - 1;
        m43478a(j2);
        atomicReferenceArray2.lazySet(i2, t);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i2, f41374j);
        return true;
    }

    private boolean m43479a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m43478a(j + 1);
        atomicReferenceArray.lazySet(i, t);
        return true;
    }

    private static AtomicReferenceArray<Object> m43477a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) atomicReferenceArray.get(atomicReferenceArray.length() - 1);
    }

    public final T poll() {
        AtomicReferenceArray atomicReferenceArray = this.f41381h;
        long j = this.f41382i.get();
        int i = this.f41380g & ((int) j);
        T t = atomicReferenceArray.get(i);
        Object obj = t == f41374j ? 1 : null;
        if (t != null && obj == null) {
            m43480b(j + 1);
            atomicReferenceArray.lazySet(i, null);
            return t;
        } else if (obj == null) {
            return null;
        } else {
            atomicReferenceArray = m43477a(atomicReferenceArray);
            this.f41381h = atomicReferenceArray;
            t = atomicReferenceArray.get(i);
            if (t == null) {
                return null;
            }
            m43480b(j + 1);
            atomicReferenceArray.lazySet(i, null);
            return t;
        }
    }

    public final T peek() {
        AtomicReferenceArray atomicReferenceArray = this.f41381h;
        int i = ((int) this.f41382i.get()) & this.f41380g;
        T t = atomicReferenceArray.get(i);
        if (t != f41374j) {
            return t;
        }
        atomicReferenceArray = m43477a(atomicReferenceArray);
        this.f41381h = atomicReferenceArray;
        return atomicReferenceArray.get(i);
    }

    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    private void m43478a(long j) {
        this.f41375b.lazySet(j);
    }

    private void m43480b(long j) {
        this.f41382i.lazySet(j);
    }

    public final Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public final <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    public final T remove() {
        throw new UnsupportedOperationException();
    }

    public final T element() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        long j = this.f41382i.get();
        while (true) {
            long j2 = this.f41375b.get();
            long j3 = this.f41382i.get();
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    public final boolean isEmpty() {
        return this.f41375b.get() == this.f41382i.get();
    }
}

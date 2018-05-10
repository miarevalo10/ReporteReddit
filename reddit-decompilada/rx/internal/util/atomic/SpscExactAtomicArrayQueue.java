package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

public final class SpscExactAtomicArrayQueue<T> extends AtomicReferenceArray<T> implements Queue<T> {
    final int f41369a;
    final int f41370b;
    final AtomicLong f41371c = new AtomicLong();
    final AtomicLong f41372d = new AtomicLong();

    public SpscExactAtomicArrayQueue(int i) {
        super(Pow2.m43481a(i));
        int length = length();
        this.f41369a = length - 1;
        this.f41370b = length - i;
    }

    public final boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        long j = this.f41371c.get();
        int i = this.f41369a;
        if (get(((int) (((long) this.f41370b) + j)) & i) != null) {
            return null;
        }
        i &= (int) j;
        this.f41371c.lazySet(j + 1);
        lazySet(i, t);
        return true;
    }

    public final T poll() {
        long j = this.f41372d.get();
        int i = ((int) j) & this.f41369a;
        T t = get(i);
        if (t == null) {
            return null;
        }
        this.f41372d.lazySet(j + 1);
        lazySet(i, null);
        return t;
    }

    public final T peek() {
        return get(((int) this.f41372d.get()) & this.f41369a);
    }

    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final boolean isEmpty() {
        return this.f41371c == this.f41372d;
    }

    public final int size() {
        long j = this.f41372d.get();
        while (true) {
            long j2 = this.f41371c.get();
            long j3 = this.f41372d.get();
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    public final boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Iterator<T> iterator() {
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
}

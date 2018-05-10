package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    static final int f35873a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object f35874j = new Object();
    final AtomicLong f35875b = new AtomicLong();
    int f35876c;
    long f35877d;
    final int f35878e;
    AtomicReferenceArray<Object> f35879f;
    final int f35880g;
    AtomicReferenceArray<Object> f35881h;
    final AtomicLong f35882i = new AtomicLong();

    public SpscLinkedArrayQueue(int i) {
        i = Pow2.m26717a(Math.max(8, i));
        int i2 = i - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i + 1);
        this.f35879f = atomicReferenceArray;
        this.f35878e = i2;
        this.f35876c = Math.min(i / 4, f35873a);
        this.f35881h = atomicReferenceArray;
        this.f35880g = i2;
        this.f35877d = (long) (i2 - 1);
        m35959a(0);
    }

    public final boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.f35879f;
        long j = this.f35875b.get();
        int i = this.f35878e;
        int i2 = ((int) j) & i;
        if (j < this.f35877d) {
            return m35961a(atomicReferenceArray, t, j, i2);
        }
        long j2 = ((long) this.f35876c) + j;
        if (atomicReferenceArray.get(((int) j2) & i) == null) {
            this.f35877d = j2 - 1;
            return m35961a(atomicReferenceArray, t, j, i2);
        }
        j2 = j + 1;
        if (atomicReferenceArray.get(((int) j2) & i) == null) {
            return m35961a(atomicReferenceArray, t, j, i2);
        }
        long j3 = (long) i;
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f35879f = atomicReferenceArray2;
        this.f35877d = (j + j3) - 1;
        atomicReferenceArray2.lazySet(i2, t);
        m35960a(atomicReferenceArray, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i2, f35874j);
        m35959a(j2);
        return true;
    }

    private static void m35960a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
    }

    public final T poll() {
        AtomicReferenceArray atomicReferenceArray = this.f35881h;
        long j = this.f35882i.get();
        int i = this.f35880g;
        int i2 = ((int) j) & i;
        T t = atomicReferenceArray.get(i2);
        int i3 = t == f35874j ? 1 : 0;
        if (t != null && i3 == 0) {
            atomicReferenceArray.lazySet(i2, null);
            m35962b(j + 1);
            return t;
        } else if (i3 == 0) {
            return null;
        } else {
            atomicReferenceArray = m35958a(atomicReferenceArray, i + 1);
            this.f35881h = atomicReferenceArray;
            T t2 = atomicReferenceArray.get(i2);
            if (t2 != null) {
                atomicReferenceArray.lazySet(i2, null);
                m35962b(j + 1);
            }
            return t2;
        }
    }

    public final T m35963a() {
        AtomicReferenceArray atomicReferenceArray = this.f35881h;
        long j = this.f35882i.get();
        int i = this.f35880g;
        int i2 = ((int) j) & i;
        T t = atomicReferenceArray.get(i2);
        if (t != f35874j) {
            return t;
        }
        atomicReferenceArray = m35958a(atomicReferenceArray, i + 1);
        this.f35881h = atomicReferenceArray;
        return atomicReferenceArray.get(i2);
    }

    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    private void m35959a(long j) {
        this.f35875b.lazySet(j);
    }

    private void m35962b(long j) {
        this.f35882i.lazySet(j);
    }

    public final boolean m35964a(T t, T t2) {
        AtomicReferenceArray atomicReferenceArray = this.f35879f;
        long j = this.f35875b.get();
        int i = this.f35878e;
        long j2 = 2 + j;
        int i2;
        if (atomicReferenceArray.get(((int) j2) & i) == null) {
            i2 = ((int) j) & i;
            atomicReferenceArray.lazySet(i2 + 1, t2);
            atomicReferenceArray.lazySet(i2, t);
            m35959a(j2);
        } else {
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
            this.f35879f = atomicReferenceArray2;
            i2 = ((int) j) & i;
            atomicReferenceArray2.lazySet(i2 + 1, t2);
            atomicReferenceArray2.lazySet(i2, t);
            m35960a(atomicReferenceArray, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i2, f35874j);
            m35959a(j2);
        }
        return true;
    }

    private boolean m35961a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        atomicReferenceArray.lazySet(i, t);
        m35959a(j + 1);
        return true;
    }

    private static AtomicReferenceArray<Object> m35958a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i);
        atomicReferenceArray.lazySet(i, null);
        return atomicReferenceArray2;
    }

    public final int m35965b() {
        long j = this.f35882i.get();
        while (true) {
            long j2 = this.f35875b.get();
            long j3 = this.f35882i.get();
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    public final boolean isEmpty() {
        return this.f35875b.get() == this.f35882i.get();
    }
}

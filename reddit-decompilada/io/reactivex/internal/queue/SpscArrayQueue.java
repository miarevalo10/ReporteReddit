package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {
    private static final Integer f35867f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final int f35868a = (length() - 1);
    final AtomicLong f35869b = new AtomicLong();
    long f35870c;
    final AtomicLong f35871d = new AtomicLong();
    final int f35872e;

    public SpscArrayQueue(int i) {
        super(Pow2.m26717a(i));
        this.f35872e = Math.min(i / 4, f35867f.intValue());
    }

    public final boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i = this.f35868a;
        long j = this.f35869b.get();
        int i2 = ((int) j) & i;
        if (j >= this.f35870c) {
            long j2 = ((long) this.f35872e) + j;
            if (get(i & ((int) j2)) == null) {
                this.f35870c = j2;
            } else if (get(i2) != null) {
                return null;
            }
        }
        lazySet(i2, e);
        this.f35869b.lazySet(j + 1);
        return true;
    }

    public final E poll() {
        long j = this.f35871d.get();
        int i = ((int) j) & this.f35868a;
        E e = get(i);
        if (e == null) {
            return null;
        }
        this.f35871d.lazySet(j + 1);
        lazySet(i, null);
        return e;
    }

    public final boolean isEmpty() {
        return this.f35869b.get() == this.f35871d.get();
    }

    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }
}

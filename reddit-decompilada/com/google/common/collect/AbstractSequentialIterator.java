package com.google.common.collect;

import java.util.NoSuchElementException;

public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    private T f14878a;

    public abstract T mo3591a(T t);

    protected AbstractSequentialIterator(T t) {
        this.f14878a = t;
    }

    public final boolean hasNext() {
        return this.f14878a != null;
    }

    public final T next() {
        if (hasNext()) {
            try {
                T t = this.f14878a;
                return t;
            } finally {
                this.f14878a = mo3591a(this.f14878a);
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}

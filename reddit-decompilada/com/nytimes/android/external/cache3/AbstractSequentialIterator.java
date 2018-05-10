package com.nytimes.android.external.cache3;

import java.util.NoSuchElementException;

public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    private T f15640a;

    protected abstract T mo3693a(T t);

    protected AbstractSequentialIterator(T t) {
        this.f15640a = t;
    }

    public final boolean hasNext() {
        return this.f15640a != null;
    }

    public final T next() {
        if (hasNext()) {
            try {
                T t = this.f15640a;
                return t;
            } finally {
                this.f15640a = mo3693a(this.f15640a);
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}

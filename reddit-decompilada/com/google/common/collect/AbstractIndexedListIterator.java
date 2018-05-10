package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {
    private final int f18433a;
    private int f18434b;

    protected abstract E mo4056a(int i);

    protected AbstractIndexedListIterator(int i, int i2) {
        Preconditions.m6920b(i2, i);
        this.f18433a = i;
        this.f18434b = i2;
    }

    public final boolean hasNext() {
        return this.f18434b < this.f18433a;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.f18434b;
            this.f18434b = i + 1;
            return mo4056a(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f18434b;
    }

    public final boolean hasPrevious() {
        return this.f18434b > 0;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.f18434b - 1;
            this.f18434b = i;
            return mo4056a(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f18434b - 1;
    }
}

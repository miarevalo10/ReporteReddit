package com.google.common.collect;

import java.util.ListIterator;

abstract class TransformedListIterator<F, T> extends TransformedIterator<F, T> implements ListIterator<T> {
    TransformedListIterator(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    public void set(T t) {
        throw new UnsupportedOperationException();
    }

    public void add(T t) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasPrevious() {
        return Iterators.m7159g(this.b).hasPrevious();
    }

    public final T previous() {
        return mo2401a(Iterators.m7159g(this.b).previous());
    }

    public final int nextIndex() {
        return Iterators.m7159g(this.b).nextIndex();
    }

    public final int previousIndex() {
        return Iterators.m7159g(this.b).previousIndex();
    }
}

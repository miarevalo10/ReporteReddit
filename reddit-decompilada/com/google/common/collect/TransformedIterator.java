package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

abstract class TransformedIterator<F, T> implements Iterator<T> {
    final Iterator<? extends F> f8480b;

    abstract T mo2401a(F f);

    TransformedIterator(Iterator<? extends F> it) {
        this.f8480b = (Iterator) Preconditions.m6908a((Object) it);
    }

    public final boolean hasNext() {
        return this.f8480b.hasNext();
    }

    public final T next() {
        return mo2401a(this.f8480b.next());
    }

    public final void remove() {
        this.f8480b.remove();
    }
}

package com.nytimes.android.external.cache3;

import java.util.Iterator;

public abstract class UnmodifiableIterator<E> implements Iterator<E> {
    protected UnmodifiableIterator() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

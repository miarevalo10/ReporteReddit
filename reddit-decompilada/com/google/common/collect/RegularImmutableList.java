package com.google.common.collect;

import com.google.common.base.Preconditions;

class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> f18458a = new RegularImmutableList(new Object[0], 0);
    final transient Object[] f18459b;
    private final transient int f18460c;

    final boolean mo3604c() {
        return false;
    }

    RegularImmutableList(Object[] objArr, int i) {
        this.f18459b = objArr;
        this.f18460c = i;
    }

    public int size() {
        return this.f18460c;
    }

    final int mo2396a(Object[] objArr, int i) {
        System.arraycopy(this.f18459b, 0, objArr, i, this.f18460c);
        return i + this.f18460c;
    }

    public E get(int i) {
        Preconditions.m6907a(i, this.f18460c);
        return this.f18459b[i];
    }
}

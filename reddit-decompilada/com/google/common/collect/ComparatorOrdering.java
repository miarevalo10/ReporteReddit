package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;

final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {
    final Comparator<T> f14887a;

    ComparatorOrdering(Comparator<T> comparator) {
        this.f14887a = (Comparator) Preconditions.m6908a((Object) comparator);
    }

    public final int compare(T t, T t2) {
        return this.f14887a.compare(t, t2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ComparatorOrdering)) {
            return null;
        }
        return this.f14887a.equals(((ComparatorOrdering) obj).f14887a);
    }

    public final int hashCode() {
        return this.f14887a.hashCode();
    }

    public final String toString() {
        return this.f14887a.toString();
    }
}

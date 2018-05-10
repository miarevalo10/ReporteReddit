package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    final Ordering<? super T> f14936a;

    ReverseOrdering(Ordering<? super T> ordering) {
        this.f14936a = (Ordering) Preconditions.m6908a((Object) ordering);
    }

    public final int compare(T t, T t2) {
        return this.f14936a.compare(t2, t);
    }

    public final <S extends T> Ordering<S> mo2422a() {
        return this.f14936a;
    }

    public final int hashCode() {
        return -this.f14936a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReverseOrdering)) {
            return null;
        }
        return this.f14936a.equals(((ReverseOrdering) obj).f14936a);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f14936a);
        stringBuilder.append(".reverse()");
        return stringBuilder.toString();
    }
}

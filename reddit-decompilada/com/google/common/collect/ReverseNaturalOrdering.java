package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final ReverseNaturalOrdering f14935a = new ReverseNaturalOrdering();

    public final String toString() {
        return "Ordering.natural().reverse()";
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        Preconditions.m6908a((Object) comparable);
        if (comparable == comparable2) {
            return null;
        }
        return comparable2.compareTo(comparable);
    }

    private ReverseNaturalOrdering() {
    }

    public final <S extends Comparable> Ordering<S> mo2422a() {
        return NaturalOrdering.f14930a;
    }
}

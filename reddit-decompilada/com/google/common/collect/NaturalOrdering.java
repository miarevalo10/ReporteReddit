package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final NaturalOrdering f14930a = new NaturalOrdering();

    public final String toString() {
        return "Ordering.natural()";
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        obj = (Comparable) obj;
        obj2 = (Comparable) obj2;
        Preconditions.m6908a(obj);
        Preconditions.m6908a(obj2);
        return obj.compareTo(obj2);
    }

    public final <S extends Comparable> Ordering<S> mo2422a() {
        return ReverseNaturalOrdering.f14935a;
    }

    private NaturalOrdering() {
    }
}

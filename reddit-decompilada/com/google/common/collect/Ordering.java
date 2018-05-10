package com.google.common.collect;

import java.util.Comparator;

public abstract class Ordering<T> implements Comparator<T> {
    public abstract int compare(T t, T t2);

    public static <C extends Comparable> Ordering<C> m7245b() {
        return NaturalOrdering.f14930a;
    }

    public static <T> Ordering<T> m7244a(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    protected Ordering() {
    }

    public <S extends T> Ordering<S> mo2422a() {
        return new ReverseOrdering(this);
    }
}

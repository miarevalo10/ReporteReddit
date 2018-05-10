package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    protected abstract SortedSet<E> mo4298c();

    protected /* synthetic */ Collection mo3603a() {
        return mo4298c();
    }

    protected /* synthetic */ Set mo4055b() {
        return mo4298c();
    }

    protected /* synthetic */ Object delegate() {
        return mo4298c();
    }

    protected ForwardingSortedSet() {
    }

    public Comparator<? super E> comparator() {
        return mo4298c().comparator();
    }

    public E first() {
        return mo4298c().first();
    }

    public SortedSet<E> headSet(E e) {
        return mo4298c().headSet(e);
    }

    public E last() {
        return mo4298c().last();
    }

    public SortedSet<E> subSet(E e, E e2) {
        return mo4298c().subSet(e, e2);
    }

    public SortedSet<E> tailSet(E e) {
        return mo4298c().tailSet(e);
    }
}

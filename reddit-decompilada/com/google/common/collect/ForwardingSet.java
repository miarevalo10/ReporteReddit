package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

public abstract class ForwardingSet<E> extends ForwardingCollection<E> implements Set<E> {
    public abstract Set<E> mo4055b();

    public /* synthetic */ Collection mo3603a() {
        return mo4055b();
    }

    public /* synthetic */ Object delegate() {
        return mo4055b();
    }

    protected ForwardingSet() {
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (mo4055b().equals(obj) == null) {
                return null;
            }
        }
        return true;
    }

    public int hashCode() {
        return mo4055b().hashCode();
    }
}

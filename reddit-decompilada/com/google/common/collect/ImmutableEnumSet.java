package com.google.common.collect;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {
    private final transient EnumSet<E> f18443a;
    private transient int f18444b;

    final boolean mo3604c() {
        return false;
    }

    final boolean mo3605d() {
        return true;
    }

    public final /* synthetic */ Iterator iterator() {
        return mo2397a();
    }

    static ImmutableSet m19272a(EnumSet enumSet) {
        switch (enumSet.size()) {
            case 0:
                return RegularImmutableSet.f18471a;
            case 1:
                return ImmutableSet.m14745a(Iterables.m7142b(enumSet));
            default:
                return new ImmutableEnumSet(enumSet);
        }
    }

    private ImmutableEnumSet(EnumSet<E> enumSet) {
        this.f18443a = enumSet;
    }

    public final UnmodifiableIterator<E> mo2397a() {
        return Iterators.m7147a(this.f18443a.iterator());
    }

    public final int size() {
        return this.f18443a.size();
    }

    public final boolean contains(Object obj) {
        return this.f18443a.contains(obj);
    }

    public final boolean containsAll(Collection<?> collection) {
        if (collection instanceof ImmutableEnumSet) {
            collection = ((ImmutableEnumSet) collection).f18443a;
        }
        return this.f18443a.containsAll(collection);
    }

    public final boolean isEmpty() {
        return this.f18443a.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumSet) {
            obj = ((ImmutableEnumSet) obj).f18443a;
        }
        return this.f18443a.equals(obj);
    }

    public final int hashCode() {
        int i = this.f18444b;
        if (i != 0) {
            return i;
        }
        i = this.f18443a.hashCode();
        this.f18444b = i;
        return i;
    }

    public final String toString() {
        return this.f18443a.toString();
    }
}

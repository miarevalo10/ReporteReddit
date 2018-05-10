package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    final transient E f18477a;
    private transient int f18478b;

    final boolean mo3604c() {
        return false;
    }

    public final int size() {
        return 1;
    }

    SingletonImmutableSet(E e) {
        this.f18477a = Preconditions.m6908a((Object) e);
    }

    SingletonImmutableSet(E e, int i) {
        this.f18477a = e;
        this.f18478b = i;
    }

    public final boolean contains(Object obj) {
        return this.f18477a.equals(obj);
    }

    public final UnmodifiableIterator<E> mo2397a() {
        return Iterators.m7146a(this.f18477a);
    }

    final ImmutableList<E> mo3616f() {
        return ImmutableList.m14726a(this.f18477a);
    }

    final int mo2396a(Object[] objArr, int i) {
        objArr[i] = this.f18477a;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.f18478b;
        if (i != 0) {
            return i;
        }
        i = this.f18477a.hashCode();
        this.f18478b = i;
        return i;
    }

    final boolean mo3605d() {
        return this.f18478b != 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(this.f18477a.toString());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final /* synthetic */ Iterator iterator() {
        return Iterators.m7146a(this.f18477a);
    }
}

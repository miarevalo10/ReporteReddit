package com.google.common.collect;

import java.util.Iterator;

final class RegularImmutableSet<E> extends ImmutableSet<E> {
    static final RegularImmutableSet<Object> f18471a = new RegularImmutableSet(new Object[0], 0, null, 0, 0);
    final transient Object[] f18472b;
    final transient Object[] f18473c;
    private final transient int f18474d;
    private final transient int f18475e;
    private final transient int f18476f;

    final boolean mo3604c() {
        return false;
    }

    final boolean mo3605d() {
        return true;
    }

    public final /* synthetic */ Iterator iterator() {
        return mo2397a();
    }

    RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.f18472b = objArr;
        this.f18473c = objArr2;
        this.f18474d = i2;
        this.f18475e = i;
        this.f18476f = i3;
    }

    public final boolean contains(Object obj) {
        Object[] objArr = this.f18473c;
        if (obj != null) {
            if (objArr != null) {
                int a = Hashing.m7113a(obj);
                while (true) {
                    a &= this.f18474d;
                    Object obj2 = objArr[a];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    a++;
                }
            }
        }
        return false;
    }

    public final int size() {
        return this.f18476f;
    }

    public final UnmodifiableIterator<E> mo2397a() {
        return mo2398b().m14740a(0);
    }

    final int mo2396a(Object[] objArr, int i) {
        System.arraycopy(this.f18472b, 0, objArr, i, this.f18476f);
        return i + this.f18476f;
    }

    final ImmutableList<E> mo3616f() {
        return ImmutableList.m14734b(this.f18472b, this.f18476f);
    }

    public final int hashCode() {
        return this.f18475e;
    }
}

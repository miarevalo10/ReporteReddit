package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

final class zzfho<E> extends zzfeo<E> {
    private static final zzfho<Object> f18043b;
    private final List<E> f18044c;

    zzfho() {
        this(new ArrayList(10));
    }

    private zzfho(List<E> list) {
        this.f18044c = list;
    }

    public static <E> zzfho<E> m18703d() {
        return f18043b;
    }

    public final /* synthetic */ zzfgd mo3535a(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        List arrayList = new ArrayList(i);
        arrayList.addAll(this.f18044c);
        return new zzfho(arrayList);
    }

    public final void add(int i, E e) {
        m13741c();
        this.f18044c.add(i, e);
        this.modCount++;
    }

    public final E get(int i) {
        return this.f18044c.get(i);
    }

    public final E remove(int i) {
        m13741c();
        E remove = this.f18044c.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e) {
        m13741c();
        E e2 = this.f18044c.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.f18044c.size();
    }

    static {
        zzfeo com_google_android_gms_internal_zzfho = new zzfho();
        f18043b = com_google_android_gms_internal_zzfho;
        com_google_android_gms_internal_zzfho.f14425a = false;
    }
}

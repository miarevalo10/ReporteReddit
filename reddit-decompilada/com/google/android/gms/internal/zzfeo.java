package com.google.android.gms.internal;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzfeo<E> extends AbstractList<E> implements zzfgd<E> {
    boolean f14425a = true;

    zzfeo() {
    }

    public final boolean mo1875a() {
        return this.f14425a;
    }

    public void add(int i, E e) {
        m13741c();
        super.add(i, e);
    }

    public boolean add(E e) {
        m13741c();
        return super.add(e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        m13741c();
        return super.addAll(i, collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        m13741c();
        return super.addAll(collection);
    }

    public final void mo1876b() {
        this.f14425a = false;
    }

    protected final void m13741c() {
        if (!this.f14425a) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        m13741c();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public E remove(int i) {
        m13741c();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        m13741c();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        m13741c();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        m13741c();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        m13741c();
        return super.set(i, e);
    }
}

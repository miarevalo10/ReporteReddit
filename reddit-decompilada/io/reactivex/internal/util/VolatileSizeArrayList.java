package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    final ArrayList<T> f25205a = new ArrayList();

    public final int size() {
        return get();
    }

    public final boolean isEmpty() {
        return get() == 0;
    }

    public final boolean contains(Object obj) {
        return this.f25205a.contains(obj);
    }

    public final Iterator<T> iterator() {
        return this.f25205a.iterator();
    }

    public final Object[] toArray() {
        return this.f25205a.toArray();
    }

    public final <E> E[] toArray(E[] eArr) {
        return this.f25205a.toArray(eArr);
    }

    public final boolean add(T t) {
        t = this.f25205a.add(t);
        lazySet(this.f25205a.size());
        return t;
    }

    public final boolean remove(Object obj) {
        obj = this.f25205a.remove(obj);
        lazySet(this.f25205a.size());
        return obj;
    }

    public final boolean containsAll(Collection<?> collection) {
        return this.f25205a.containsAll(collection);
    }

    public final boolean addAll(Collection<? extends T> collection) {
        collection = this.f25205a.addAll(collection);
        lazySet(this.f25205a.size());
        return collection;
    }

    public final boolean addAll(int i, Collection<? extends T> collection) {
        i = this.f25205a.addAll(i, collection);
        lazySet(this.f25205a.size());
        return i;
    }

    public final boolean removeAll(Collection<?> collection) {
        collection = this.f25205a.removeAll(collection);
        lazySet(this.f25205a.size());
        return collection;
    }

    public final boolean retainAll(Collection<?> collection) {
        collection = this.f25205a.retainAll(collection);
        lazySet(this.f25205a.size());
        return collection;
    }

    public final void clear() {
        this.f25205a.clear();
        lazySet(0);
    }

    public final T get(int i) {
        return this.f25205a.get(i);
    }

    public final T set(int i, T t) {
        return this.f25205a.set(i, t);
    }

    public final void add(int i, T t) {
        this.f25205a.add(i, t);
        lazySet(this.f25205a.size());
    }

    public final T remove(int i) {
        i = this.f25205a.remove(i);
        lazySet(this.f25205a.size());
        return i;
    }

    public final int indexOf(Object obj) {
        return this.f25205a.indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        return this.f25205a.lastIndexOf(obj);
    }

    public final ListIterator<T> listIterator() {
        return this.f25205a.listIterator();
    }

    public final ListIterator<T> listIterator(int i) {
        return this.f25205a.listIterator(i);
    }

    public final List<T> subList(int i, int i2) {
        return this.f25205a.subList(i, i2);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof VolatileSizeArrayList) {
            return this.f25205a.equals(((VolatileSizeArrayList) obj).f25205a);
        }
        return this.f25205a.equals(obj);
    }

    public final int hashCode() {
        return this.f25205a.hashCode();
    }

    public final String toString() {
        return this.f25205a.toString();
    }
}

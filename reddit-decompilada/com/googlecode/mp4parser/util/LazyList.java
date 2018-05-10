package com.googlecode.mp4parser.util;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LazyList<E> extends AbstractList<E> {
    private static final Logger f9065c = Logger.m7708a(LazyList.class);
    List<E> f9066a;
    Iterator<E> f9067b;

    class C04621 implements Iterator<E> {
        int f9063a = null;
        final /* synthetic */ LazyList f9064b;

        C04621(LazyList lazyList) {
            this.f9064b = lazyList;
        }

        public boolean hasNext() {
            return this.f9063a < this.f9064b.f9066a.size() || this.f9064b.f9067b.hasNext();
        }

        public E next() {
            if (this.f9063a < this.f9064b.f9066a.size()) {
                List list = this.f9064b.f9066a;
                int i = this.f9063a;
                this.f9063a = i + 1;
                return list.get(i);
            }
            this.f9064b.f9066a.add(this.f9064b.f9067b.next());
            return next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public LazyList(List<E> list, Iterator<E> it) {
        this.f9066a = list;
        this.f9067b = it;
    }

    public E get(int i) {
        if (this.f9066a.size() > i) {
            return this.f9066a.get(i);
        }
        if (this.f9067b.hasNext()) {
            this.f9066a.add(this.f9067b.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public Iterator<E> iterator() {
        return new C04621(this);
    }

    public int size() {
        f9065c.mo2531a("potentially expensive size() call");
        f9065c.mo2531a("blowup running");
        while (this.f9067b.hasNext()) {
            this.f9066a.add(this.f9067b.next());
        }
        return this.f9066a.size();
    }
}

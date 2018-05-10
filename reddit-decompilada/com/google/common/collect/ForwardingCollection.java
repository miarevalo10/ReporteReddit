package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    public abstract Collection<E> mo3603a();

    public /* synthetic */ Object delegate() {
        return mo3603a();
    }

    protected ForwardingCollection() {
    }

    public Iterator<E> iterator() {
        return mo3603a().iterator();
    }

    public int size() {
        return mo3603a().size();
    }

    public boolean removeAll(Collection<?> collection) {
        return mo3603a().removeAll(collection);
    }

    public boolean isEmpty() {
        return mo3603a().isEmpty();
    }

    public boolean contains(Object obj) {
        return mo3603a().contains(obj);
    }

    public boolean add(E e) {
        return mo3603a().add(e);
    }

    public boolean remove(Object obj) {
        return mo3603a().remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return mo3603a().containsAll(collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return mo3603a().addAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return mo3603a().retainAll(collection);
    }

    public void clear() {
        mo3603a().clear();
    }

    public Object[] toArray() {
        return mo3603a().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return mo3603a().toArray(tArr);
    }
}

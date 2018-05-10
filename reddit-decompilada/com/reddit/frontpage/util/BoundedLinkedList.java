package com.reddit.frontpage.util;

import android.annotation.TargetApi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BoundedLinkedList<T> implements Iterable<T> {
    public final LinkedList<T> f21704a;
    public final int f21705b;

    public BoundedLinkedList() {
        this((byte) 0);
    }

    private BoundedLinkedList(byte b) {
        this.f21704a = new LinkedList();
        this.f21705b = (byte) 100;
    }

    public Iterator<T> iterator() {
        return this.f21704a.iterator();
    }

    @TargetApi(24)
    public void forEach(Consumer<? super T> consumer) {
        this.f21704a.forEach(consumer);
    }

    @TargetApi(24)
    public Spliterator<T> spliterator() {
        return this.f21704a.spliterator();
    }
}

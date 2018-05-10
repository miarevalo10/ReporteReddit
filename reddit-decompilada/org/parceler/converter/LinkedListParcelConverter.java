package org.parceler.converter;

import java.util.Collection;
import java.util.LinkedList;

public abstract class LinkedListParcelConverter<T> extends CollectionParcelConverter<T, LinkedList<T>> {
    public final /* synthetic */ Collection mo6863a() {
        return new LinkedList();
    }
}

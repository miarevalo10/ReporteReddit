package org.parceler.converter;

import java.util.Collection;
import java.util.HashSet;

public abstract class HashSetParcelConverter<T> extends CollectionParcelConverter<T, HashSet<T>> {
    public final /* synthetic */ Collection mo6863a() {
        return new HashSet();
    }
}

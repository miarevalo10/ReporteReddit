package org.parceler.converter;

import java.util.Collection;
import java.util.LinkedHashSet;

public abstract class LinkedHashSetParcelConverter<T> extends CollectionParcelConverter<T, LinkedHashSet<T>> {
    public final /* synthetic */ Collection mo6863a() {
        return new LinkedHashSet();
    }
}

package org.parceler.converter;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class LinkedHashMapParcelConverter<K, V> extends MapParcelConverter<K, V, LinkedHashMap<K, V>> {
    public final /* synthetic */ Map mo6864a() {
        return new LinkedHashMap();
    }
}

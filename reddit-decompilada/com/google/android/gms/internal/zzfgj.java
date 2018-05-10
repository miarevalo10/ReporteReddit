package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzfgj<K> implements Iterator<Entry<K, Object>> {
    private Iterator<Entry<K, Object>> f7424a;

    public zzfgj(Iterator<Entry<K, Object>> it) {
        this.f7424a = it;
    }

    public final boolean hasNext() {
        return this.f7424a.hasNext();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.f7424a.next();
        return entry.getValue() instanceof zzfgg ? new zzfgi(entry) : entry;
    }

    public final void remove() {
        this.f7424a.remove();
    }
}

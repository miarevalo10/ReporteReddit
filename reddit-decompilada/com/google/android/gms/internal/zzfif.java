package com.google.android.gms.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzfif extends AbstractSet<Entry<K, V>> {
    private /* synthetic */ zzfhy f7463a;

    private zzfif(zzfhy com_google_android_gms_internal_zzfhy) {
        this.f7463a = com_google_android_gms_internal_zzfhy;
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f7463a.m6069a((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.f7463a.clear();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.f7463a.get(entry.getKey());
        obj = entry.getValue();
        if (obj2 != obj) {
            if (obj2 == null || !obj2.equals(obj)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzfie(this.f7463a, (byte) 0);
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f7463a.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.f7463a.size();
    }
}

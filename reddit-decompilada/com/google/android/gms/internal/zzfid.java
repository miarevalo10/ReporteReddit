package com.google.android.gms.internal;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Map.Entry;

final class zzfid implements Comparable<zzfid>, Entry<K, V> {
    private final K f7456a;
    private V f7457b;
    private /* synthetic */ zzfhy f7458c;

    zzfid(zzfhy com_google_android_gms_internal_zzfhy, K k, V v) {
        this.f7458c = com_google_android_gms_internal_zzfhy;
        this.f7456a = k;
        this.f7457b = v;
    }

    zzfid(zzfhy com_google_android_gms_internal_zzfhy, Entry<K, V> entry) {
        this(com_google_android_gms_internal_zzfhy, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean m6076a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzfid) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return m6076a(this.f7456a, entry.getKey()) && m6076a(this.f7457b, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.f7456a;
    }

    public final V getValue() {
        return this.f7457b;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.f7456a == null ? 0 : this.f7456a.hashCode();
        if (this.f7457b != null) {
            i = this.f7457b.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.f7458c.m6067d();
        V v2 = this.f7457b;
        this.f7457b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f7456a);
        String valueOf2 = String.valueOf(this.f7457b);
        StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
        stringBuilder.append(valueOf);
        stringBuilder.append(Operation.EQUALS);
        stringBuilder.append(valueOf2);
        return stringBuilder.toString();
    }
}

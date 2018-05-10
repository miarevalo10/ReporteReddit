package com.google.android.gms.internal;

import java.util.Map.Entry;

final class zzfgi<K> implements Entry<K, Object> {
    Entry<K, zzfgg> f7423a;

    private zzfgi(Entry<K, zzfgg> entry) {
        this.f7423a = entry;
    }

    public final K getKey() {
        return this.f7423a.getKey();
    }

    public final Object getValue() {
        return ((zzfgg) this.f7423a.getValue()) == null ? null : zzfgg.m13852a();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzfhe) {
            zzfgg com_google_android_gms_internal_zzfgg = (zzfgg) this.f7423a.getValue();
            zzfhe com_google_android_gms_internal_zzfhe = (zzfhe) obj;
            zzfhe com_google_android_gms_internal_zzfhe2 = com_google_android_gms_internal_zzfgg.f7427b;
            com_google_android_gms_internal_zzfgg.f7426a = null;
            com_google_android_gms_internal_zzfgg.f7428c = null;
            com_google_android_gms_internal_zzfgg.f7427b = com_google_android_gms_internal_zzfhe;
            return com_google_android_gms_internal_zzfhe2;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}

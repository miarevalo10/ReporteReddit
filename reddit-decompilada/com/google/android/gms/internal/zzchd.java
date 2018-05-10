package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;

public final class zzchd<V> {
    final V f6893a;
    final String f6894b;
    private final zzbey<V> f6895c;

    private zzchd(String str, zzbey<V> com_google_android_gms_internal_zzbey_V, V v) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzbey_V);
        this.f6895c = com_google_android_gms_internal_zzbey_V;
        this.f6893a = v;
        this.f6894b = str;
    }

    static zzchd<Integer> m5672a(String str, int i, int i2) {
        return new zzchd(str, zzbey.m5507a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    static zzchd<Long> m5673a(String str, long j, long j2) {
        return new zzchd(str, zzbey.m5508a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    static zzchd<String> m5674a(String str, String str2, String str3) {
        return new zzchd(str, zzbey.m5509a(str, str3), str2);
    }

    static zzchd<Boolean> m5675a(String str, boolean z, boolean z2) {
        return new zzchd(str, zzbey.m5510a(str, z2), Boolean.valueOf(z));
    }

    public final V m5676a(V v) {
        return v != null ? v : this.f6893a;
    }
}

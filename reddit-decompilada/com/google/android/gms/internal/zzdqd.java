package com.google.android.gms.internal;

import java.util.Arrays;

public final class zzdqd<P> {
    final P f7246a;
    private final byte[] f7247b;
    private final zzdtb f7248c;
    private final zzdtt f7249d;

    public zzdqd(P p, byte[] bArr, zzdtb com_google_android_gms_internal_zzdtb, zzdtt com_google_android_gms_internal_zzdtt) {
        this.f7246a = p;
        this.f7247b = Arrays.copyOf(bArr, bArr.length);
        this.f7248c = com_google_android_gms_internal_zzdtb;
        this.f7249d = com_google_android_gms_internal_zzdtt;
    }

    public final byte[] m5867a() {
        return this.f7247b == null ? null : Arrays.copyOf(this.f7247b, this.f7247b.length);
    }
}

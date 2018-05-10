package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzdqn implements zzdpp {
    private static final byte[] f14305a = new byte[0];
    private final zzdtd f14306b;
    private final zzdpp f14307c;

    public zzdqn(zzdtd com_google_android_gms_internal_zzdtd, zzdpp com_google_android_gms_internal_zzdpp) {
        this.f14306b = com_google_android_gms_internal_zzdtd;
        this.f14307c = com_google_android_gms_internal_zzdpp;
    }

    public final byte[] mo1861a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] h = zzdqe.m5878b(this.f14306b).mo3500h();
        byte[] a = this.f14307c.mo1861a(h, f14305a);
        bArr = ((zzdpp) zzdqe.m5873a(this.f14306b.f19666a, h)).mo1861a(bArr, bArr2);
        return ByteBuffer.allocate((4 + a.length) + bArr.length).putInt(a.length).put(a).put(bArr).array();
    }
}

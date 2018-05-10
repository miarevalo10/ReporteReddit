package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class zzdut implements zzdpp {
    private final zzdvf f14393a;
    private final zzdqa f14394b;
    private final int f14395c;

    public zzdut(zzdvf com_google_android_gms_internal_zzdvf, zzdqa com_google_android_gms_internal_zzdqa, int i) {
        this.f14393a = com_google_android_gms_internal_zzdvf;
        this.f14394b = com_google_android_gms_internal_zzdqa;
        this.f14395c = i;
    }

    public final byte[] mo1861a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        bArr = this.f14393a.mo1866a(bArr);
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(8 * ((long) bArr2.length)).array(), 8);
        bArr2 = this.f14394b.mo1868a(zzdua.m5902a(bArr2, bArr, copyOf));
        return zzdua.m5902a(bArr, bArr2);
    }
}

package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

public final class zzduk implements zzdpu {
    private static final byte[] f14380a = new byte[0];
    private final ECPrivateKey f14381b;
    private final zzdum f14382c;
    private final String f14383d;
    private final byte[] f14384e;
    private final zzdus f14385f;
    private final zzduj f14386g;

    public zzduk(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzdus com_google_android_gms_internal_zzdus, zzduj com_google_android_gms_internal_zzduj) throws GeneralSecurityException {
        this.f14381b = eCPrivateKey;
        this.f14382c = new zzdum(eCPrivateKey);
        this.f14384e = bArr;
        this.f14383d = str;
        this.f14385f = com_google_android_gms_internal_zzdus;
        this.f14386g = com_google_android_gms_internal_zzduj;
    }
}

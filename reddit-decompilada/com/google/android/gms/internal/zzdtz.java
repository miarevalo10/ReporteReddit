package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzdtz implements zzdpp {
    private final SecretKey f14375a;

    public zzdtz(byte[] bArr) {
        this.f14375a = new SecretKeySpec(bArr, "AES");
    }

    public final byte[] mo1861a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Object obj = new byte[((bArr.length + 12) + 16)];
        Object a = zzdvi.m5921a(12);
        System.arraycopy(a, 0, obj, 0, 12);
        Cipher cipher = (Cipher) zzduu.f7327a.m5911a("AES/GCM/NoPadding");
        cipher.init(1, this.f14375a, new GCMParameterSpec(128, a));
        cipher.updateAAD(bArr2);
        cipher.doFinal(bArr, 0, bArr.length, obj, 12);
        return obj;
    }
}

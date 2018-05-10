package com.google.android.gms.internal;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzdtx implements zzdvf {
    private final SecretKeySpec f14368a;
    private final int f14369b;
    private final int f14370c = ((Cipher) zzduu.f7327a.m5911a("AES/CTR/NoPadding")).getBlockSize();

    public zzdtx(byte[] bArr, int i) throws GeneralSecurityException {
        this.f14368a = new SecretKeySpec(bArr, "AES");
        if (i >= 12) {
            if (i <= this.f14370c) {
                this.f14369b = i;
                return;
            }
        }
        throw new GeneralSecurityException("invalid IV size");
    }

    public final byte[] mo1866a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > RedditJobManager.f10810d - this.f14369b) {
            int i = RedditJobManager.f10810d - this.f14369b;
            StringBuilder stringBuilder = new StringBuilder(43);
            stringBuilder.append("plaintext length can not exceed ");
            stringBuilder.append(i);
            throw new GeneralSecurityException(stringBuilder.toString());
        }
        Object obj = new byte[(this.f14369b + bArr.length)];
        Object a = zzdvi.m5921a(this.f14369b);
        System.arraycopy(a, 0, obj, 0, this.f14369b);
        int length = bArr.length;
        int i2 = this.f14369b;
        Cipher cipher = (Cipher) zzduu.f7327a.m5911a("AES/CTR/NoPadding");
        Object obj2 = new byte[this.f14370c];
        System.arraycopy(a, 0, obj2, 0, this.f14369b);
        cipher.init(1, this.f14368a, new IvParameterSpec(obj2));
        if (cipher.doFinal(bArr, 0, length, obj, i2) == length) {
            return obj;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}

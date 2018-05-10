package com.google.android.gms.internal;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.security.GeneralSecurityException;

public final class zzdua {
    public static byte[] m5902a(byte[]... bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = 0;
        int i2 = i;
        while (i < length) {
            byte[] bArr2 = bArr[i];
            if (i2 > RedditJobManager.f10810d - bArr2.length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            i2 += bArr2.length;
            i++;
        }
        Object obj = new byte[i2];
        i = bArr.length;
        i2 = 0;
        int i3 = i2;
        while (i2 < i) {
            Object obj2 = bArr[i2];
            System.arraycopy(obj2, 0, obj, i3, obj2.length);
            i3 += obj2.length;
            i2++;
        }
        return obj;
    }
}

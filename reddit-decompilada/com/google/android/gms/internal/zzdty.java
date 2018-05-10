package com.google.android.gms.internal;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzdty implements zzdpp {
    private final byte[] f14371a;
    private final byte[] f14372b;
    private final SecretKeySpec f14373c;
    private final int f14374d;

    public zzdty(byte[] bArr, int i) throws GeneralSecurityException {
        if (i == 12 || i == 16) {
            this.f14374d = i;
            this.f14373c = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/NOPADDING");
            instance.init(1, this.f14373c);
            this.f14371a = m13679a(instance.doFinal(new byte[16]));
            this.f14372b = m13679a(this.f14371a);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    private final byte[] m13678a(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] b;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        if (i3 == 0) {
            b = m13680b(bArr2, this.f14371a);
        } else {
            b = cipher.doFinal(bArr2);
            int i4 = 0;
            byte[] bArr3 = b;
            i = 0;
            while (i3 - i > 16) {
                for (int i5 = 0; i5 < 16; i5++) {
                    bArr3[i5] = (byte) (bArr3[i5] ^ bArr[(i2 + i) + i5]);
                }
                bArr3 = cipher.doFinal(bArr3);
                i += 16;
            }
            b = Arrays.copyOfRange(bArr, i + i2, i2 + i3);
            if (b.length == 16) {
                b = m13680b(b, this.f14371a);
            } else {
                bArr = Arrays.copyOf(this.f14372b, 16);
                while (i4 < b.length) {
                    bArr[i4] = (byte) (bArr[i4] ^ b[i4]);
                    i4++;
                }
                bArr[b.length] = (byte) (bArr[b.length] ^ 128);
                b = bArr;
            }
            b = m13680b(bArr3, b);
        }
        return cipher.doFinal(b);
    }

    private static byte[] m13679a(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & 255) >>> 7));
            i2 = i3;
        }
        i2 = bArr[15] << 1;
        if ((bArr[0] & 128) != 0) {
            i = 135;
        }
        bArr2[15] = (byte) (i2 ^ i);
        return bArr2;
    }

    private static byte[] m13680b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public final byte[] mo1861a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = bArr;
        if (bArr3.length > (RedditJobManager.f10810d - this.f14374d) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        int i = 0;
        Object obj = new byte[((r6.f14374d + bArr3.length) + 16)];
        Object a = zzdvi.m5921a(r6.f14374d);
        System.arraycopy(a, 0, obj, 0, r6.f14374d);
        Cipher instance = Cipher.getInstance("AES/ECB/NOPADDING");
        instance.init(1, r6.f14373c);
        Cipher cipher = instance;
        byte[] a2 = m13678a(cipher, 0, a, 0, a.length);
        byte[] bArr4 = bArr2;
        byte[] a3 = m13678a(cipher, 1, bArr4, 0, bArr4.length);
        Cipher instance2 = Cipher.getInstance("AES/CTR/NOPADDING");
        instance2.init(1, r6.f14373c, new IvParameterSpec(a2));
        instance2.doFinal(bArr3, 0, bArr3.length, obj, r6.f14374d);
        byte[] a4 = m13678a(instance, 2, obj, r6.f14374d, bArr3.length);
        int length = bArr3.length + r6.f14374d;
        while (i < 16) {
            obj[length + i] = (byte) ((a3[i] ^ a2[i]) ^ a4[i]);
            i++;
        }
        return obj;
    }
}

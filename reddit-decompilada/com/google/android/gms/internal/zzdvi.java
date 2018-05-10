package com.google.android.gms.internal;

import java.security.SecureRandom;

public final class zzdvi {
    private static final SecureRandom f7341a = new SecureRandom();

    public static byte[] m5921a(int i) {
        byte[] bArr = new byte[i];
        f7341a.nextBytes(bArr);
        return bArr;
    }
}

package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzffz {
    static final Charset f7417a = Charset.forName("UTF-8");
    public static final byte[] f7418b;
    private static Charset f7419c = Charset.forName("ISO-8859-1");
    private static ByteBuffer f7420d;
    private static zzffb f7421e = zzffb.m5963a(f7418b);

    static {
        byte[] bArr = new byte[0];
        f7418b = bArr;
        f7420d = ByteBuffer.wrap(bArr);
    }

    static int m6011a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (i = i2; i < i2 + i3; i++) {
            i4 = (i4 * 31) + bArr[i];
        }
        return i4;
    }

    public static int m6012a(boolean z) {
        return z ? 1231 : 1237;
    }

    static <T> T m6013a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    static <T> T m6014a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static boolean m6015a() {
        return false;
    }
}

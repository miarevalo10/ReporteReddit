package com.sendbird.android.shadow.okio;

import java.nio.charset.Charset;

public final class Util {
    public static final Charset f23620a = Charset.forName("UTF-8");

    public static int m25641a(int i) {
        return ((i & 255) << 24) | ((((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8)) | ((65280 & i) << 8));
    }

    public static short m25642a(short s) {
        int i = s & 65535;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    public static void m25643a(long j, long j2, long j3) {
        if ((j2 | j3) >= 0 && j2 <= j) {
            if (j - j2 >= j3) {
                return;
            }
        }
        throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
    }

    public static boolean m25645a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return 1;
    }

    public static void m25644a(Throwable th) {
        throw th;
    }
}

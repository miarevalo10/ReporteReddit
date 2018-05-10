package com.sendbird.android.shadow.okhttp3.internal.ws;

import com.facebook.stetho.websocket.CloseCodes;

public final class WebSocketProtocol {
    static void m25579a(byte[] bArr, long j, byte[] bArr2, long j2) {
        int i = 0;
        int length = bArr2.length;
        while (((long) i) < j) {
            int i2 = (int) (j2 % ((long) length));
            bArr[i] = (byte) (bArr2[i2] ^ bArr[i]);
            i++;
            j2++;
        }
    }

    static String m25578a(int i) {
        StringBuilder stringBuilder;
        if (i >= 1000) {
            if (i < 5000) {
                if ((i < 1004 || i > CloseCodes.CLOSED_ABNORMALLY) && (i < 1012 || i > 2999)) {
                    return 0;
                }
                stringBuilder = new StringBuilder("Code ");
                stringBuilder.append(i);
                stringBuilder.append(" is reserved and may not be used.");
                return stringBuilder.toString();
            }
        }
        stringBuilder = new StringBuilder("Code must be in range [1000,5000): ");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    static void m25580b(int i) {
        i = m25578a(i);
        if (i != 0) {
            throw new IllegalArgumentException(i);
        }
    }
}

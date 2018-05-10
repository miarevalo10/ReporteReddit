package com.coremedia.iso;

import java.nio.ByteBuffer;

public final class IsoTypeWriter {
    static final /* synthetic */ boolean f3718a = true;

    public static void m3296a(ByteBuffer byteBuffer, long j) {
        if (f3718a || j >= 0) {
            byteBuffer.putLong(j);
            return;
        }
        throw new AssertionError("The given long is negative");
    }

    public static void m3300b(ByteBuffer byteBuffer, long j) {
        if (f3718a || (j >= 0 && j <= 4294967296L)) {
            byteBuffer.putInt((int) j);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("The given long is not in the range of uint32 (");
        stringBuilder.append(j);
        stringBuilder.append(")");
        throw new AssertionError(stringBuilder.toString());
    }

    public static void m3295a(ByteBuffer byteBuffer, int i) {
        i &= 16777215;
        m3299b(byteBuffer, i >> 8);
        m3303c(byteBuffer, i);
    }

    public static void m3304c(ByteBuffer byteBuffer, long j) {
        j &= 281474976710655L;
        m3299b(byteBuffer, (int) (j >> 32));
        m3300b(byteBuffer, j & 4294967295L);
    }

    public static void m3299b(ByteBuffer byteBuffer, int i) {
        i &= 65535;
        m3303c(byteBuffer, i >> 8);
        m3303c(byteBuffer, i & 255);
    }

    public static void m3303c(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) (i & 255));
    }

    public static void m3294a(ByteBuffer byteBuffer, double d) {
        d = (int) (d * 65536.0d);
        byteBuffer.put((byte) ((-16777216 & d) >> 24));
        byteBuffer.put((byte) ((16711680 & d) >> 16));
        byteBuffer.put((byte) ((65280 & d) >> 8));
        byteBuffer.put((byte) (d & 255));
    }

    public static void m3298b(ByteBuffer byteBuffer, double d) {
        d = (int) (d * 1.073741824E9d);
        byteBuffer.put((byte) ((-16777216 & d) >> 24));
        byteBuffer.put((byte) ((16711680 & d) >> 16));
        byteBuffer.put((byte) ((65280 & d) >> 8));
        byteBuffer.put((byte) (d & 255));
    }

    public static void m3302c(ByteBuffer byteBuffer, double d) {
        d = (short) ((int) (d * 256.0d));
        byteBuffer.put((byte) ((65280 & d) >> 8));
        byteBuffer.put((byte) (d & 255));
    }

    public static void m3297a(ByteBuffer byteBuffer, String str) {
        if (str.getBytes().length != 3) {
            StringBuilder stringBuilder = new StringBuilder("\"");
            stringBuilder.append(str);
            stringBuilder.append("\" language string isn't exactly 3 characters long!");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i = 0;
        int i2 = 0;
        while (i < 3) {
            i2 += (str.getBytes()[i] - 96) << ((2 - i) * 5);
            i++;
        }
        m3299b(byteBuffer, i2);
    }

    public static void m3301b(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(Utf8.m3308a(str));
        m3303c(byteBuffer, (int) null);
    }

    public static void m3305c(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(Utf8.m3308a(str));
        m3303c(byteBuffer, (int) null);
    }
}

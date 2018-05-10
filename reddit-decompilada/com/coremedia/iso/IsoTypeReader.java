package com.coremedia.iso;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public final class IsoTypeReader {
    private static int m3279a(byte b) {
        return b < (byte) 0 ? b + 256 : b;
    }

    public static long m3280a(ByteBuffer byteBuffer) {
        long j = (long) byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    public static int m3282b(ByteBuffer byteBuffer) {
        return (0 + (m3283c(byteBuffer) << 8)) + m3279a(byteBuffer.get());
    }

    public static int m3283c(ByteBuffer byteBuffer) {
        return (0 + (m3279a(byteBuffer.get()) << 8)) + m3279a(byteBuffer.get());
    }

    public static int m3284d(ByteBuffer byteBuffer) {
        return m3279a(byteBuffer.get());
    }

    public static String m3285e(ByteBuffer byteBuffer) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            byte b = byteBuffer.get();
            if (b == (byte) 0) {
                return Utf8.m3307a(byteArrayOutputStream.toByteArray());
            }
            byteArrayOutputStream.write(b);
        }
    }

    public static String m3281a(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return Utf8.m3307a(bArr);
    }

    public static long m3286f(ByteBuffer byteBuffer) {
        long a = (m3280a(byteBuffer) << 32) + 0;
        if (a >= 0) {
            return a + m3280a(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static double m3287g(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((double) ((((null | ((bArr[0] << 24) & -16777216)) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & 65280)) | (bArr[3] & 255))) / 65536.0d;
    }

    public static double m3288h(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((double) ((((null | ((bArr[0] << 24) & -16777216)) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & 65280)) | (bArr[3] & 255))) / 1.073741824E9d;
    }

    public static float m3289i(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        return ((float) ((short) (((short) (null | ((bArr[0] << 8) & 65280))) | (bArr[1] & 255)))) / 256.0f;
    }

    public static String m3290j(ByteBuffer byteBuffer) {
        byteBuffer = m3283c(byteBuffer);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append((char) (((byteBuffer >> ((2 - i) * 5)) & 31) + 96));
        }
        return stringBuilder.toString();
    }

    public static String m3291k(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (ByteBuffer byteBuffer2) {
            throw new RuntimeException(byteBuffer2);
        }
    }

    public static long m3292l(ByteBuffer byteBuffer) {
        long c = ((long) m3283c(byteBuffer)) << 32;
        if (c >= 0) {
            return c + m3280a(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }
}

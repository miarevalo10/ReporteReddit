package org.jcodec.codecs.mjpeg.tools;

public class Asserts {
    public static void assertEquals(int i, int i2) {
        if (i != i2) {
            StringBuilder stringBuilder = new StringBuilder("assert failed: ");
            stringBuilder.append(i);
            stringBuilder.append(" != ");
            stringBuilder.append(i2);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public static void assertInRange(String str, int i, int i2, int i3) {
        if (i3 >= i) {
            if (i3 <= i2) {
                return;
            }
        }
        throw new IllegalStateException(str);
    }

    public static void assertEpsilonEquals(int[] iArr, int[] iArr2, int i) {
        if (iArr.length != iArr2.length) {
            throw new IllegalStateException("arrays of different size");
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (Math.abs(iArr[i2] - iArr2[i2]) > i) {
                throw new IllegalStateException("array element out of expected diff range");
            }
        }
    }

    public static void assertEpsilonEquals(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length != bArr2.length) {
            throw new IllegalStateException("arrays of different size");
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = (bArr[i2] & 255) - (bArr2[i2] & 255);
            if (Math.abs(i3) > i) {
                bArr2 = new StringBuilder("array element out of expected diff range: ");
                bArr2.append(Math.abs(i3));
                throw new IllegalStateException(bArr2.toString());
            }
        }
    }
}

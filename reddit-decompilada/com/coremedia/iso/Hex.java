package com.coremedia.iso;

public class Hex {
    private static final char[] f3717a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String m3277a(byte[] bArr) {
        return m3278a(bArr, 0);
    }

    public static String m3278a(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        char[] cArr = new char[((length << 1) + (i > 0 ? length / i : 0))];
        int i3 = 0;
        while (i2 < length) {
            int i4;
            if (i > 0 && i2 % i == 0 && i3 > 0) {
                i4 = i3 + 1;
                cArr[i3] = '-';
                i3 = i4;
            }
            i4 = i3 + 1;
            cArr[i3] = f3717a[(240 & bArr[i2]) >>> 4];
            i3 = i4 + 1;
            cArr[i4] = f3717a[15 & bArr[i2]];
            i2++;
        }
        return new String(cArr);
    }
}

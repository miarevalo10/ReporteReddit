package com.google.android.gms.internal;

abstract class zzdue extends zzdub {
    private zzdue(byte[] bArr) {
        super(bArr);
    }

    private static void m18662a(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = zzdub.m13683a(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = zzdub.m13683a(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = zzdub.m13683a(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = zzdub.m13683a(iArr[i2] ^ iArr[i3], 7);
    }

    final void mo3497b(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i = 0; i < 10; i++) {
            m18662a(iArr2, 0, 4, 8, 12);
            m18662a(iArr2, 1, 5, 9, 13);
            m18662a(iArr2, 2, 6, 10, 14);
            m18662a(iArr2, 3, 7, 11, 15);
            m18662a(iArr2, 0, 5, 10, 15);
            m18662a(iArr2, 1, 6, 11, 12);
            m18662a(iArr2, 2, 7, 8, 13);
            m18662a(iArr2, 3, 4, 9, 14);
        }
    }
}

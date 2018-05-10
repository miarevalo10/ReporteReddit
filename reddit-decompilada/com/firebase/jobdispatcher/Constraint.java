package com.firebase.jobdispatcher;

public final class Constraint {
    static final int[] f3842a = new int[]{2, 1, 4, 8};

    static int m3451a(int[] iArr) {
        int i = 0;
        if (iArr == null) {
            return 0;
        }
        int i2 = 0;
        while (i < iArr.length) {
            i2 |= iArr[i];
            i++;
        }
        return i2;
    }

    static int[] m3452a(int i) {
        int[] iArr = f3842a;
        int i2 = 0;
        int length = iArr.length;
        int i3 = 0;
        int i4 = i3;
        while (i3 < length) {
            int i5 = iArr[i3];
            i4 += (i & i5) == i5 ? 1 : 0;
            i3++;
        }
        iArr = new int[i4];
        int[] iArr2 = f3842a;
        i3 = iArr2.length;
        i4 = 0;
        while (i2 < i3) {
            i5 = iArr2[i2];
            if ((i & i5) == i5) {
                int i6 = i4 + 1;
                iArr[i4] = i5;
                i4 = i6;
            }
            i2++;
        }
        return iArr;
    }
}

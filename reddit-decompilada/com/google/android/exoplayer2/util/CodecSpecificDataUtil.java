package com.google.android.exoplayer2.util;

import android.util.Pair;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.ArrayList;
import java.util.List;

public final class CodecSpecificDataUtil {
    private static final byte[] f5217a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    private static final int[] f5218b = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, EventsFilesManager.MAX_BYTE_SIZE_PER_FILE, 7350};
    private static final int[] f5219c = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> m4192a(byte[] bArr) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        bArr = m4190a(parsableBitArray);
        int b = m4196b(parsableBitArray);
        int c = parsableBitArray.m4236c(4);
        if (bArr == 5 || bArr == 29) {
            b = m4196b(parsableBitArray);
            if (m4190a(parsableBitArray) == 22) {
                c = parsableBitArray.m4236c(4);
            }
        }
        bArr = f5219c[c];
        Assertions.m4184a(bArr != -1);
        return Pair.create(Integer.valueOf(b), Integer.valueOf(bArr));
    }

    public static byte[] m4193a(int i, int i2) {
        int i3;
        int i4 = 0;
        int i5 = -1;
        for (i3 = 0; i3 < f5218b.length; i3++) {
            if (i == f5218b[i3]) {
                i5 = i3;
            }
        }
        i3 = -1;
        while (i4 < f5219c.length) {
            if (i2 == f5219c[i4]) {
                i3 = i4;
            }
            i4++;
        }
        if (i != -1) {
            if (i3 != -1) {
                return m4194a(2, i5, i3);
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid sample rate or number of channels: ");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(i2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static byte[] m4194a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] m4195a(byte[] bArr, int i, int i2) {
        Object obj = new byte[(f5217a.length + i2)];
        System.arraycopy(f5217a, 0, obj, 0, f5217a.length);
        System.arraycopy(bArr, i, obj, f5217a.length, i2);
        return obj;
    }

    public static byte[][] m4198b(byte[] bArr) {
        if (!m4197b(bArr, 0)) {
            return null;
        }
        List arrayList = new ArrayList();
        int i = 0;
        do {
            arrayList.add(Integer.valueOf(i));
            i = m4191a(bArr, i + f5217a.length);
        } while (i != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            Object obj = new byte[((i2 < arrayList.size() + -1 ? ((Integer) arrayList.get(i2 + 1)).intValue() : bArr.length) - intValue)];
            System.arraycopy(bArr, intValue, obj, 0, obj.length);
            bArr2[i2] = obj;
            i2++;
        }
        return bArr2;
    }

    private static int m4191a(byte[] bArr, int i) {
        int length = bArr.length - f5217a.length;
        while (i <= length) {
            if (m4197b(bArr, i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static boolean m4197b(byte[] bArr, int i) {
        if (bArr.length - i <= f5217a.length) {
            return false;
        }
        for (int i2 = 0; i2 < f5217a.length; i2++) {
            if (bArr[i + i2] != f5217a[i2]) {
                return false;
            }
        }
        return 1;
    }

    private static int m4190a(ParsableBitArray parsableBitArray) {
        int c = parsableBitArray.m4236c(5);
        return c == 31 ? 32 + parsableBitArray.m4236c(6) : c;
    }

    private static int m4196b(ParsableBitArray parsableBitArray) {
        int c = parsableBitArray.m4236c(4);
        if (c == 15) {
            return parsableBitArray.m4236c(24);
        }
        Assertions.m4184a(c < 13 ? true : null);
        return f5218b[c];
    }
}

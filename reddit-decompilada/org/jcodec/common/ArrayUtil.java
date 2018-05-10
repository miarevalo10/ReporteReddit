package org.jcodec.common;

import java.lang.reflect.Array;

public class ArrayUtil {
    public static <T> void shiftRight(T[] tArr) {
        for (int i = 1; i < tArr.length; i++) {
            tArr[i] = tArr[i - 1];
        }
        tArr[0] = null;
    }

    public static <T> void shiftLeft(T[] tArr) {
        int i = 0;
        while (i < tArr.length - 1) {
            int i2 = i + 1;
            tArr[i] = tArr[i2];
            i = i2;
        }
        tArr[tArr.length - 1] = null;
    }

    public static <T> void shiftRight(T[] tArr, int i, int i2) {
        for (i2--; i2 > i; i2--) {
            tArr[i2] = tArr[i2 - 1];
        }
        tArr[i] = 0;
    }

    public static <T> void shiftLeft(T[] tArr, int i, int i2) {
        while (true) {
            int i3 = i2 - 1;
            if (i < i3) {
                i3 = i + 1;
                tArr[i] = tArr[i3];
                i = i3;
            } else {
                tArr[i3] = 0;
                return;
            }
        }
    }

    public static <T> void shiftLeft(T[] tArr, int i) {
        shiftLeft(tArr, i, tArr.length);
    }

    public static <T> void shiftRight(T[] tArr, int i) {
        shiftRight(tArr, 0, i);
    }

    public static final void swap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    public static final int sum(int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i2 += iArr[i];
            i++;
        }
        return i2;
    }

    public static int sum(int[] iArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public static void add(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    public static int[] addAll(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return clone(iArr2);
        }
        if (iArr2 == null) {
            return clone(iArr);
        }
        Object obj = new int[(iArr.length + iArr2.length)];
        System.arraycopy(iArr, 0, obj, 0, iArr.length);
        System.arraycopy(iArr2, 0, obj, iArr.length, iArr2.length);
        return obj;
    }

    public static long[] addAll(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            return clone(jArr2);
        }
        if (jArr2 == null) {
            return clone(jArr);
        }
        Object obj = new long[(jArr.length + jArr2.length)];
        System.arraycopy(jArr, 0, obj, 0, jArr.length);
        System.arraycopy(jArr2, 0, obj, jArr.length, jArr2.length);
        return obj;
    }

    public static Object[] addAll(Object[] objArr, Object[] objArr2) {
        if (objArr == null) {
            return clone(objArr2);
        }
        if (objArr2 == null) {
            return clone(objArr);
        }
        Object[] objArr3 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + objArr2.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        return objArr3;
    }

    public static int[] clone(int[] iArr) {
        return iArr == null ? null : (int[]) iArr.clone();
    }

    public static long[] clone(long[] jArr) {
        return jArr == null ? null : (long[]) jArr.clone();
    }

    public static Object[] clone(Object[] objArr) {
        return objArr == null ? null : (Object[]) objArr.clone();
    }

    public static byte[] toByteArray(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = (byte) iArr[i];
        }
        return bArr;
    }

    public static int[] toUnsignedIntArray(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            iArr[i] = bArr[i] & 255;
        }
        return iArr;
    }

    public static <T> void reverse(T[] tArr) {
        int i = 0;
        int length = tArr.length - 1;
        while (i < (tArr.length >> 1)) {
            T t = tArr[i];
            tArr[i] = tArr[length];
            tArr[length] = t;
            i++;
            length--;
        }
    }
}

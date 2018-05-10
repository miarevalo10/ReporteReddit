package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zzbg;
import java.lang.reflect.Array;
import java.util.Arrays;

public final class zza {
    public static <T> T[] m4892a(T[] tArr, T... tArr2) {
        if (tArr == null) {
            return null;
        }
        T[] tArr3 = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length);
        int length = tArr.length;
        int i = 0;
        int i2 = i;
        while (i < length) {
            Object obj = tArr[i];
            if (!zzbg.m4806a(tArr2[0], obj)) {
                int i3 = i2 + 1;
                tArr3[i2] = obj;
                i2 = i3;
            }
            i++;
        }
        if (tArr3 == null) {
            return null;
        }
        if (i2 != tArr3.length) {
            tArr3 = Arrays.copyOf(tArr3, i2);
        }
        return tArr3;
    }
}

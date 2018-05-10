package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzfjq {
    protected static final Charset f7553a = Charset.forName("UTF-8");
    public static final Object f7554b = new Object();
    private static Charset f7555c = Charset.forName("ISO-8859-1");

    public static int m6194a(long[] jArr) {
        if (jArr != null) {
            if (jArr.length != 0) {
                return Arrays.hashCode(jArr);
            }
        }
        return 0;
    }

    public static int m6195a(Object[] objArr) {
        int i = 0;
        int length = objArr == null ? 0 : objArr.length;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            if (obj != null) {
                i2 = (i2 * 31) + obj.hashCode();
            }
            i++;
        }
        return i2;
    }

    public static void m6196a(zzfjm com_google_android_gms_internal_zzfjm, zzfjm com_google_android_gms_internal_zzfjm2) {
        if (com_google_android_gms_internal_zzfjm.f14454X != null) {
            com_google_android_gms_internal_zzfjm2.f14454X = (zzfjo) com_google_android_gms_internal_zzfjm.f14454X.clone();
        }
    }

    public static boolean m6197a(long[] jArr, long[] jArr2) {
        if (jArr != null) {
            if (jArr.length != 0) {
                return Arrays.equals(jArr, jArr2);
            }
        }
        if (jArr2 != null) {
            if (jArr2.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean m6198a(Object[] objArr, Object[] objArr2) {
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i = 0;
        int i2 = i;
        while (true) {
            if (i >= length || objArr[i] != null) {
                while (i2 < length2 && objArr2[i2] == null) {
                    i2++;
                }
                boolean z = i >= length;
                boolean z2 = i2 >= length2;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !objArr[i].equals(objArr2[i2])) {
                    return false;
                }
                i++;
                i2++;
            } else {
                i++;
            }
        }
    }
}

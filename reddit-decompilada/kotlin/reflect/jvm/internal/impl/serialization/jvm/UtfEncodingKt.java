package kotlin.reflect.jvm.internal.impl.serialization.jvm;

import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: utfEncoding.kt */
public final class UtfEncodingKt {
    public static final byte[] m27913a(String[] strArr) {
        Intrinsics.m26847b(strArr, "strings");
        Object[] objArr = (Object[]) strArr;
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i2 < objArr.length) {
            i3 += ((String) objArr[i2]).length();
            i2++;
        }
        byte[] bArr = new byte[i3];
        i2 = 0;
        i3 = i2;
        while (i2 < strArr.length) {
            String str = strArr[i2];
            int length = str.length() - 1;
            if (length >= 0) {
                int i4;
                int i5 = 0;
                while (true) {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) str.charAt(i5);
                    if (i5 == length) {
                        break;
                    }
                    i5++;
                    i3 = i4;
                }
                i3 = i4;
            }
            i2++;
        }
        if (i3 == bArr.length) {
            i = 1;
        }
        if (_Assertions.f25274a == null || r1 != 0) {
            return bArr;
        }
        throw new AssertionError("Should have reached the end");
    }
}

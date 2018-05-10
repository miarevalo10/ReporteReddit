package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public final class UriUtil {
    public static Uri m4291a(String str, String str2) {
        return Uri.parse(m4294b(str, str2));
    }

    public static String m4294b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] a = m4293a(str2);
        if (a[0] != -1) {
            stringBuilder.append(str2);
            m4292a(stringBuilder, a[1], a[2]);
            return stringBuilder.toString();
        }
        int[] a2 = m4293a(str);
        if (a[3] == 0) {
            stringBuilder.append(str, 0, a2[3]);
            stringBuilder.append(str2);
            return stringBuilder.toString();
        } else if (a[2] == 0) {
            stringBuilder.append(str, 0, a2[2]);
            stringBuilder.append(str2);
            return stringBuilder.toString();
        } else if (a[1] != 0) {
            int i = a2[0] + 1;
            stringBuilder.append(str, 0, i);
            stringBuilder.append(str2);
            return m4292a(stringBuilder, a[1] + i, i + a[2]);
        } else if (str2.charAt(a[1]) == '/') {
            stringBuilder.append(str, 0, a2[1]);
            stringBuilder.append(str2);
            return m4292a(stringBuilder, a2[1], a2[1] + a[2]);
        } else if (a2[0] + 2 >= a2[1] || a2[1] != a2[2]) {
            int lastIndexOf = str.lastIndexOf(47, a2[2] - 1);
            int i2 = lastIndexOf == -1 ? a2[1] : lastIndexOf + 1;
            stringBuilder.append(str, 0, i2);
            stringBuilder.append(str2);
            return m4292a(stringBuilder, a2[1], i2 + a[2]);
        } else {
            stringBuilder.append(str, 0, a2[1]);
            stringBuilder.append('/');
            stringBuilder.append(str2);
            return m4292a(stringBuilder, a2[1], (a2[1] + a[2]) + 1);
        }
    }

    private static String m4292a(StringBuilder stringBuilder, int i, int i2) {
        if (i >= i2) {
            return stringBuilder.toString();
        }
        if (stringBuilder.charAt(i) == '/') {
            i++;
        }
        int i3 = i;
        int i4 = i2;
        while (true) {
            i2 = i3;
            while (i2 <= i4) {
                int i5;
                if (i2 == i4) {
                    i5 = i2;
                } else if (stringBuilder.charAt(i2) == '/') {
                    i5 = i2 + 1;
                } else {
                    i2++;
                }
                int i6 = i3 + 1;
                if (i2 == i6 && stringBuilder.charAt(i3) == '.') {
                    stringBuilder.delete(i3, i5);
                    i4 -= i5 - i3;
                } else if (i2 == i3 + 2 && stringBuilder.charAt(i3) == '.' && stringBuilder.charAt(i6) == '.') {
                    i3 = stringBuilder.lastIndexOf(Operation.DIVISION, i3 - 2) + 1;
                    i2 = i3 > i ? i3 : i;
                    stringBuilder.delete(i2, i5);
                    i4 -= i5 - i2;
                } else {
                    i3 = i2 + 1;
                }
            }
            return stringBuilder.toString();
        }
    }

    private static int[] m4293a(String str) {
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        indexOf = str.indexOf(63);
        if (indexOf == -1 || indexOf > length) {
            indexOf = length;
        }
        int indexOf2 = str.indexOf(47);
        if (indexOf2 == -1 || indexOf2 > indexOf) {
            indexOf2 = indexOf;
        }
        int indexOf3 = str.indexOf(58);
        if (indexOf3 > indexOf2) {
            indexOf3 = -1;
        }
        indexOf2 = indexOf3 + 2;
        indexOf2 = (indexOf2 < indexOf && str.charAt(indexOf3 + 1) == '/' && str.charAt(indexOf2) == '/') ? 1 : 0;
        if (indexOf2 != 0) {
            str = str.indexOf(47, indexOf3 + 3);
            if (str == -1 || str > indexOf) {
                str = indexOf;
            }
        } else {
            str = indexOf3 + 1;
        }
        iArr[0] = indexOf3;
        iArr[1] = str;
        iArr[2] = indexOf;
        iArr[3] = length;
        return iArr;
    }
}

package com.google.android.gms.internal;

import android.text.TextUtils;

final class zznr extends zzno {
    zznr() {
    }

    private static String m14101a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        return (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }

    public final String mo2059a(String str, String str2) {
        str = m14101a(str);
        Object a = m14101a(str2);
        if (TextUtils.isEmpty(str)) {
            return a;
        }
        if (TextUtils.isEmpty(a)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(str).length()) + String.valueOf(a).length());
        stringBuilder.append(str);
        stringBuilder.append(",");
        stringBuilder.append(a);
        return stringBuilder.toString();
    }
}

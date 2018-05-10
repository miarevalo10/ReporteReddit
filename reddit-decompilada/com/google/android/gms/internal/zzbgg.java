package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzal;

public final class zzbgg {
    private final String f6698a;
    private final String f6699b;
    private final zzal f6700c;
    private final int f6701d;

    private zzbgg(String str, String str2) {
        this.f6699b = str2;
        this.f6698a = str;
        this.f6700c = new zzal(str, (byte) 0);
        this.f6701d = m5564a();
    }

    public zzbgg(String str, String... strArr) {
        this(str, m5565a(strArr));
    }

    private final int m5564a() {
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.f6698a, i)) {
            i++;
        }
        return i;
    }

    private static String m5565a(String... strArr) {
        if (strArr.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (String str : strArr) {
            if (stringBuilder.length() > 1) {
                stringBuilder.append(",");
            }
            stringBuilder.append(str);
        }
        stringBuilder.append(']');
        stringBuilder.append(' ');
        return stringBuilder.toString();
    }

    public final void m5566a(String str) {
        if ((this.f6701d <= 3 ? 1 : null) != null) {
            Log.d(this.f6698a, this.f6699b.concat(str));
        }
    }
}

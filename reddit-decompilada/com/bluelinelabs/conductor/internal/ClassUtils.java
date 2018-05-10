package com.bluelinelabs.conductor.internal;

import android.text.TextUtils;

public class ClassUtils {
    public static <T> Class<? extends T> m2753a(String str, boolean z) {
        if (z && TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (boolean z2) {
            StringBuilder stringBuilder = new StringBuilder("An exception occurred while finding class for name ");
            stringBuilder.append(str);
            stringBuilder.append(". ");
            stringBuilder.append(z2.getMessage());
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public static <T> T m2754a(String str) {
        try {
            Class a = m2753a(str, true);
            return a != null ? a.newInstance() : null;
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("An exception occurred while creating a new instance of ");
            stringBuilder.append(str);
            stringBuilder.append(". ");
            stringBuilder.append(e.getMessage());
            throw new RuntimeException(stringBuilder.toString());
        }
    }
}

package com.google.android.exoplayer2.util;

import android.text.TextUtils;

public final class Assertions {
    public static void m4184a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m4185a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int m4181a(int i, int i2) {
        if (i >= 0) {
            if (i < i2) {
                return i;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public static void m4186b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m4187b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static <T> T m4182a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static String m4183a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }
}

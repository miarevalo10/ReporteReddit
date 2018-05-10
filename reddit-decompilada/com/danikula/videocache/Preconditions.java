package com.danikula.videocache;

public final class Preconditions {
    public static <T> T m3330a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void m3334a(Object... objArr) {
        for (int i = 0; i < 2; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException();
            }
        }
    }

    public static <T> T m3331a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static void m3332a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    static void m3333a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}

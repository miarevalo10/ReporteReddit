package com.google.gson.internal;

public final class C$Gson$Preconditions {
    public static <T> T m7521a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void m7522a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}

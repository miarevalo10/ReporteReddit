package com.sendbird.android.shadow.com.google.gson.internal;

public final class C$Gson$Preconditions {
    public static <T> T m25093a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void m25094a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}

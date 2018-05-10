package com.google.common.base;

public final class Verify {
    public static <T> T m6943a(T t, String str, Object... objArr) {
        if ((t != null ? 1 : null) != null) {
            return t;
        }
        throw new VerifyException(Preconditions.m6911a(str, objArr));
    }
}

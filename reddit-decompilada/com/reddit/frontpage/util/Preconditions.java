package com.reddit.frontpage.util;

public class Preconditions {
    public static <T> T m23870a(T t, String str) {
        if (t != null) {
            return t;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" must not be null");
        throw new NullPointerException(stringBuilder.toString());
    }
}

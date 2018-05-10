package com.google.android.exoplayer2;

import java.util.HashSet;

public final class ExoPlayerLibraryInfo {
    private static final HashSet<String> f4010a = new HashSet();
    private static String f4011b = "goog.exo.core";

    public static synchronized String m3552a() {
        String str;
        synchronized (ExoPlayerLibraryInfo.class) {
            str = f4011b;
        }
        return str;
    }

    public static synchronized void m3553a(String str) {
        synchronized (ExoPlayerLibraryInfo.class) {
            if (f4010a.add(str)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(f4011b);
                stringBuilder.append(", ");
                stringBuilder.append(str);
                f4011b = stringBuilder.toString();
            }
        }
    }
}

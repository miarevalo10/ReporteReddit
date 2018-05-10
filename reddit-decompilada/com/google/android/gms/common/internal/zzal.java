package com.google.android.gms.common.internal;

public final class zzal {
    private static int f5892a = 15;
    private static final String f5893b = null;
    private final String f5894c;
    private final String f5895d;

    private zzal(String str) {
        zzbq.m4809a((Object) str, (Object) "log tag cannot be null");
        zzbq.m4819b(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, Integer.valueOf(23));
        this.f5894c = str;
        this.f5895d = null;
    }

    public zzal(String str, byte b) {
        this(str);
    }
}

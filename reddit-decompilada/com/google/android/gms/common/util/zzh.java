package com.google.android.gms.common.util;

import android.os.SystemClock;

public final class zzh implements zzd {
    private static zzh f14015a = new zzh();

    private zzh() {
    }

    public static zzd m13111d() {
        return f14015a;
    }

    public final long mo1632a() {
        return System.currentTimeMillis();
    }

    public final long mo1633b() {
        return SystemClock.elapsedRealtime();
    }

    public final long mo1634c() {
        return System.nanoTime();
    }
}

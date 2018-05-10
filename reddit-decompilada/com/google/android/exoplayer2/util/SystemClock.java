package com.google.android.exoplayer2.util;

final class SystemClock implements Clock {
    SystemClock() {
    }

    public final long mo1496a() {
        return android.os.SystemClock.elapsedRealtime();
    }
}

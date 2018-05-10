package com.google.android.exoplayer2;

import java.io.IOException;

public final class ExoPlaybackException extends Exception {
    public final int f3975a;
    public final int f3976b;

    public static ExoPlaybackException m3542a(Exception exception, int i) {
        return new ExoPlaybackException(1, exception, i);
    }

    public static ExoPlaybackException m3541a(IOException iOException) {
        return new ExoPlaybackException(0, iOException, -1);
    }

    static ExoPlaybackException m3543a(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, runtimeException, -1);
    }

    private ExoPlaybackException(int i, Throwable th, int i2) {
        super(null, th);
        this.f3975a = i;
        this.f3976b = i2;
    }
}

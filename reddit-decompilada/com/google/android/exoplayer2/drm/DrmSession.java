package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@TargetApi(16)
public interface DrmSession<T extends ExoMediaCrypto> {

    public static class DrmSessionException extends Exception {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    int m3726a();

    DrmSessionException m3727b();

    T m3728c();
}

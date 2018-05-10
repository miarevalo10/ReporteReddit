package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;

@TargetApi(16)
public interface DrmSessionManager<T extends ExoMediaCrypto> {
    boolean m3729a();

    DrmSession<T> m3730b();
}

package com.google.android.exoplayer2.drm;

public interface ExoMediaDrm<T extends ExoMediaCrypto> {

    public interface KeyRequest {
        byte[] getData();

        String getDefaultUrl();
    }

    public interface ProvisionRequest {
        byte[] getData();

        String getDefaultUrl();
    }
}

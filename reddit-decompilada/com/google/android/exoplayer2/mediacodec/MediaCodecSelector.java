package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;

public interface MediaCodecSelector {
    public static final MediaCodecSelector f4656a = new C11391();

    static class C11391 implements MediaCodecSelector {
        C11391() {
        }

        public final MediaCodecInfo mo1389a(String str, boolean z) throws DecoderQueryException {
            return MediaCodecUtil.m3901a(str, z);
        }

        public final MediaCodecInfo mo1388a() throws DecoderQueryException {
            return MediaCodecUtil.m3900a();
        }
    }

    MediaCodecInfo mo1388a() throws DecoderQueryException;

    MediaCodecInfo mo1389a(String str, boolean z) throws DecoderQueryException;
}

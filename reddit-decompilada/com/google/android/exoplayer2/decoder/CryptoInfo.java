package com.google.android.exoplayer2.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.util.Util;

public final class CryptoInfo {
    public byte[] f4223a;
    public byte[] f4224b;
    public int f4225c;
    public int[] f4226d;
    public int[] f4227e;
    public int f4228f;
    public int f4229g;
    public int f4230h;
    public final android.media.MediaCodec.CryptoInfo f4231i;
    public final PatternHolderV24 f4232j;

    @TargetApi(24)
    private static final class PatternHolderV24 {
        private final android.media.MediaCodec.CryptoInfo f4221a;
        private final Pattern f4222b;

        private PatternHolderV24(android.media.MediaCodec.CryptoInfo cryptoInfo) {
            this.f4221a = cryptoInfo;
            this.f4222b = new Pattern(0, 0);
        }

        public static /* synthetic */ void m3717a(PatternHolderV24 patternHolderV24, int i, int i2) {
            patternHolderV24.f4222b.set(i, i2);
            patternHolderV24.f4221a.setPattern(patternHolderV24.f4222b);
        }
    }

    public CryptoInfo() {
        PatternHolderV24 patternHolderV24 = null;
        this.f4231i = Util.f5283a >= 16 ? new android.media.MediaCodec.CryptoInfo() : null;
        if (Util.f5283a >= 24) {
            patternHolderV24 = new PatternHolderV24(this.f4231i);
        }
        this.f4232j = patternHolderV24;
    }
}

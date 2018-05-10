package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.util.Util;

final class ConstantBitrateSeeker implements Seeker {
    private final long f16850a;
    private final int f16851b;
    private final long f16852c;

    public ConstantBitrateSeeker(long j, int i, long j2) {
        this.f16850a = j;
        this.f16851b = i;
        if (j2 == -1) {
            j = -9223372036854775807L;
        } else {
            j = mo3349a(j2);
        }
        this.f16852c = j;
    }

    public final boolean a_() {
        return this.f16852c != -9223372036854775807L;
    }

    public final long mo1329b(long j) {
        if (this.f16852c == -9223372036854775807L) {
            return 0;
        }
        return this.f16850a + ((Util.m4318b(j, this.f16852c) * ((long) this.f16851b)) / 8000000);
    }

    public final long mo3349a(long j) {
        return ((Math.max(0, j - this.f16850a) * 1000000) * 8) / ((long) this.f16851b);
    }

    public final long mo1328b() {
        return this.f16852c;
    }
}

package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Util;

public final class ChunkIndex implements SeekMap {
    public final int f12820a;
    public final int[] f12821b;
    public final long[] f12822c;
    public final long[] f12823d;
    public final long[] f12824e;
    private final long f12825f;

    public final boolean a_() {
        return true;
    }

    public ChunkIndex(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f12821b = iArr;
        this.f12822c = jArr;
        this.f12823d = jArr2;
        this.f12824e = jArr3;
        this.f12820a = iArr.length;
        if (this.f12820a > null) {
            this.f12825f = jArr2[this.f12820a - 1] + jArr3[this.f12820a - 1];
        } else {
            this.f12825f = null;
        }
    }

    public final int m11994a(long j) {
        return Util.m4300a(this.f12824e, j, true);
    }

    public final long mo1328b() {
        return this.f12825f;
    }

    public final long mo1329b(long j) {
        return this.f12822c[m11994a(j)];
    }
}

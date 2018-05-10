package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

final class TrackSampleTable {
    public final int f4488a;
    public final long[] f4489b;
    public final int[] f4490c;
    public final int f4491d;
    public final long[] f4492e;
    public final int[] f4493f;

    public TrackSampleTable(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = false;
        Assertions.m4184a(iArr.length == jArr2.length);
        Assertions.m4184a(jArr.length == jArr2.length);
        if (iArr2.length == jArr2.length) {
            z = true;
        }
        Assertions.m4184a(z);
        this.f4489b = jArr;
        this.f4490c = iArr;
        this.f4491d = i;
        this.f4492e = jArr2;
        this.f4493f = iArr2;
        this.f4488a = jArr.length;
    }

    public final int m3822a(long j) {
        for (j = Util.m4300a(this.f4492e, j, false); j >= null; j--) {
            if ((this.f4493f[j] & 1) != 0) {
                return j;
            }
        }
        return -1;
    }

    public final int m3823b(long j) {
        for (j = Util.m4301a(this.f4492e, j, true, false); j < this.f4492e.length; j++) {
            if ((this.f4493f[j] & 1) != 0) {
                return j;
            }
        }
        return -1;
    }
}

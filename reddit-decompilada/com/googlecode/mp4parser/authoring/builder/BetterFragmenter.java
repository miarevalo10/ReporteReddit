package com.googlecode.mp4parser.authoring.builder;

import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.util.Mp4Arrays;
import java.util.Arrays;

public class BetterFragmenter implements Fragmenter {
    private double f15125a = 2.0d;

    public final long[] mo2520a(Track track) {
        double d = (double) track.mo3626m().f8889b;
        long j = (long) (this.f15125a * d);
        long[] jArr = new long[0];
        long[] b = track.mo2513b();
        long[] k = track.mo3624k();
        if (b != null) {
            int i;
            long[] jArr2 = new long[b.length];
            long e = track.mo2516e();
            long j2 = 0;
            for (i = 0; i < k.length; i++) {
                int binarySearch = Arrays.binarySearch(b, ((long) i) + 1);
                if (binarySearch >= 0) {
                    jArr2[binarySearch] = j2;
                }
                j2 += k[i];
            }
            i = 0;
            long j3 = 0;
            while (i < jArr2.length - 1) {
                long j4 = jArr2[i];
                int i2 = i + 1;
                long j5 = jArr2[i2];
                if (j3 <= j5 && Math.abs(j4 - j3) < Math.abs(j5 - j3)) {
                    jArr = Mp4Arrays.m7715a(jArr, b[i]);
                    j3 = jArr2[i] + j;
                }
                i = i2;
            }
            if (e - jArr2[jArr2.length - 1] <= j / 2) {
                return jArr;
            }
            return Mp4Arrays.m7715a(jArr, b[jArr2.length - 1]);
        }
        long[] jArr3 = new long[]{1};
        double d2 = 0.0d;
        for (int i3 = 1; i3 < k.length; i3++) {
            d2 += ((double) k[i3]) / d;
            if (d2 >= r0.f15125a) {
                if (i3 > 0) {
                    jArr3 = Mp4Arrays.m7715a(jArr3, (long) (i3 + 1));
                }
                d2 = 0.0d;
            }
        }
        if (d2 < r0.f15125a && jArr3.length > 1) {
            jArr3[jArr3.length - 1] = jArr3[jArr3.length - 2] + ((((long) (k.length + 1)) - jArr3[jArr3.length - 2]) / 2);
        }
        return jArr3;
    }
}

package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class VbriSeeker implements Seeker {
    private final long[] f16853a;
    private final long[] f16854b;
    private final long f16855c;

    public final boolean a_() {
        return true;
    }

    public static VbriSeeker m17180a(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j, long j2) {
        MpegAudioHeader mpegAudioHeader2 = mpegAudioHeader;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        long j3 = j2;
        parsableByteArray2.m4251d(10);
        int j4 = parsableByteArray.m4259j();
        VbriSeeker vbriSeeker = null;
        if (j4 <= 0) {
            return null;
        }
        int i = mpegAudioHeader2.f4264d;
        long a = Util.m4303a((long) j4, 1000000 * ((long) (i >= 32000 ? 1152 : 576)), (long) i);
        j4 = parsableByteArray.m4252e();
        int e = parsableByteArray.m4252e();
        int e2 = parsableByteArray.m4252e();
        parsableByteArray2.m4251d(2);
        long j5 = j + ((long) mpegAudioHeader2.f4263c);
        int i2 = j4 + 1;
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        jArr[0] = 0;
        jArr2[0] = j5;
        int i3 = 1;
        while (i3 < jArr.length) {
            int d;
            long j6;
            switch (e2) {
                case 1:
                    d = parsableByteArray.m4250d();
                    break;
                case 2:
                    d = parsableByteArray.m4252e();
                    break;
                case 3:
                    d = parsableByteArray.m4256g();
                    break;
                case 4:
                    d = parsableByteArray.m4263n();
                    break;
                default:
                    return vbriSeeker;
            }
            j5 += (long) (d * e);
            long j7 = a;
            jArr[i3] = (((long) i3) * a) / ((long) j4);
            if (j3 == -1) {
                j6 = j5;
            } else {
                j6 = Math.min(j3, j5);
            }
            jArr2[i3] = j6;
            i3++;
            a = j7;
            vbriSeeker = null;
        }
        return new VbriSeeker(jArr, jArr2, a);
    }

    private VbriSeeker(long[] jArr, long[] jArr2, long j) {
        this.f16853a = jArr;
        this.f16854b = jArr2;
        this.f16855c = j;
    }

    public final long mo1329b(long j) {
        return this.f16854b[Util.m4300a(this.f16853a, j, true)];
    }

    public final long mo3349a(long j) {
        return this.f16853a[Util.m4300a(this.f16854b, j, true)];
    }

    public final long mo1328b() {
        return this.f16855c;
    }
}

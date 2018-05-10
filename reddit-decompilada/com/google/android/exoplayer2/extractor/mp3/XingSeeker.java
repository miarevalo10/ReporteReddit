package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class XingSeeker implements Seeker {
    private final long f16856a;
    private final long f16857b;
    private final long f16858c;
    private final long[] f16859d;
    private final long f16860e;
    private final int f16861f;

    public static XingSeeker m17185a(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j, long j2) {
        MpegAudioHeader mpegAudioHeader2 = mpegAudioHeader;
        int i = mpegAudioHeader2.f4267g;
        int i2 = mpegAudioHeader2.f4264d;
        long j3 = j + ((long) mpegAudioHeader2.f4263c);
        int j4 = parsableByteArray.m4259j();
        if ((j4 & 1) == 1) {
            int n = parsableByteArray.m4263n();
            if (n != 0) {
                long a = Util.m4303a((long) n, ((long) i) * 1000000, (long) i2);
                if ((j4 & 6) != 6) {
                    return new XingSeeker(j3, a, j2);
                }
                long n2 = (long) parsableByteArray.m4263n();
                parsableByteArray.m4251d(1);
                long[] jArr = new long[99];
                for (j4 = 0; j4 < 99; j4++) {
                    jArr[j4] = (long) parsableByteArray.m4250d();
                }
                return new XingSeeker(j3, a, j2, jArr, n2, mpegAudioHeader2.f4263c);
            }
        }
        return null;
    }

    private XingSeeker(long j, long j2, long j3) {
        this(j, j2, j3, null, 0, 0);
    }

    private XingSeeker(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.f16856a = j;
        this.f16857b = j2;
        this.f16858c = j3;
        this.f16859d = jArr;
        this.f16860e = j4;
        this.f16861f = i;
    }

    public final boolean a_() {
        return this.f16859d != null;
    }

    public final long mo1329b(long j) {
        if (!a_()) {
            return this.f16856a;
        }
        j = (((float) j) * 1120403456) / ((float) this.f16857b);
        float f = 0.0f;
        float f2 = 256.0f;
        if (j > 0) {
            if (j >= 1120403456) {
                f = 256.0f;
            } else {
                int i = (int) j;
                if (i != 0) {
                    f = (float) this.f16859d[i - 1];
                }
                if (i < 99) {
                    f2 = (float) this.f16859d[i];
                }
                f += (f2 - f) * (j - ((float) i));
            }
        }
        return Math.min(Math.round((4571153621781053440L * ((double) f)) * ((double) this.f16860e)) + this.f16856a, (this.f16858c != -1 ? this.f16858c : (this.f16856a - ((long) this.f16861f)) + this.f16860e) - 1);
    }

    public final long mo3349a(long j) {
        long j2 = 0;
        if (a_()) {
            if (j >= this.f16856a) {
                long j3;
                long j4;
                double d = (256.0d * ((double) (j - this.f16856a))) / ((double) this.f16860e);
                int a = Util.m4300a(this.f16859d, (long) d, false) + 1;
                long a2 = m17184a(a);
                if (a == 0) {
                    j3 = 0;
                } else {
                    j3 = this.f16859d[a - 1];
                }
                if (a == 99) {
                    j4 = 256;
                } else {
                    j4 = this.f16859d[a];
                }
                j = m17184a(a + 1);
                if (j4 != j3) {
                    j2 = (long) ((((double) (j - a2)) * (d - ((double) j3))) / ((double) (j4 - j3)));
                }
                return a2 + j2;
            }
        }
        return 0;
    }

    public final long mo1328b() {
        return this.f16857b;
    }

    private long m17184a(int i) {
        return (this.f16857b * ((long) i)) / 100;
    }
}

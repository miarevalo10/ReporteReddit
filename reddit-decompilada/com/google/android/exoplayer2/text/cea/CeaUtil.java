package com.google.android.exoplayer2.text.cea;

import android.util.Log;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import org.jcodec.codecs.mpeg12.MPEGConst;

public final class CeaUtil {
    public static void m4064a(long j, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        TrackOutput[] trackOutputArr2 = trackOutputArr;
        while (parsableByteArray.m4246b() > 1) {
            int a = m4063a(parsableByteArray);
            int a2 = m4063a(parsableByteArray);
            if (a2 != -1) {
                if (a2 <= parsableByteArray.m4246b()) {
                    int d;
                    int i;
                    TrackOutput trackOutput;
                    int i2 = 0;
                    if (a == 4) {
                        if (a2 >= 8) {
                            a = parsableByteArray2.f5257b;
                            d = parsableByteArray.m4250d();
                            int e = parsableByteArray.m4252e();
                            int j2 = parsableByteArray.m4259j();
                            int d2 = parsableByteArray.m4250d();
                            parsableByteArray2.m4249c(a);
                            if (d == MPEGConst.EXTENSION_START_CODE && e == 49 && j2 == 1195456820 && d2 == 3) {
                                a = 1;
                                if (a == 0) {
                                    parsableByteArray2.m4251d(8);
                                    a = parsableByteArray.m4250d() & 31;
                                    parsableByteArray2.m4251d(1);
                                    a *= 3;
                                    i = parsableByteArray2.f5257b;
                                    d = trackOutputArr2.length;
                                    while (i2 < d) {
                                        trackOutput = trackOutputArr2[i2];
                                        parsableByteArray2.m4249c(i);
                                        trackOutput.mo1346a(parsableByteArray2, a);
                                        trackOutput.mo1344a(j, 1, a, 0, null);
                                        i2++;
                                    }
                                    parsableByteArray2.m4251d(a2 - (10 + a));
                                } else {
                                    parsableByteArray2.m4251d(a2);
                                }
                            }
                        }
                    }
                    a = 0;
                    if (a == 0) {
                        parsableByteArray2.m4251d(a2);
                    } else {
                        parsableByteArray2.m4251d(8);
                        a = parsableByteArray.m4250d() & 31;
                        parsableByteArray2.m4251d(1);
                        a *= 3;
                        i = parsableByteArray2.f5257b;
                        d = trackOutputArr2.length;
                        while (i2 < d) {
                            trackOutput = trackOutputArr2[i2];
                            parsableByteArray2.m4249c(i);
                            trackOutput.mo1346a(parsableByteArray2, a);
                            trackOutput.mo1344a(j, 1, a, 0, null);
                            i2++;
                        }
                        parsableByteArray2.m4251d(a2 - (10 + a));
                    }
                }
            }
            Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
            parsableByteArray2.m4249c(parsableByteArray2.f5258c);
        }
    }

    private static int m4063a(ParsableByteArray parsableByteArray) {
        int i = 0;
        while (parsableByteArray.m4246b() != 0) {
            int d = parsableByteArray.m4250d();
            i += d;
            if (d != 255) {
                return i;
            }
        }
        return -1;
    }
}

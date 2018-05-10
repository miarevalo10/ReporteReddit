package com.google.android.exoplayer2.extractor.mp4;

import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

final class Sniffer {
    private static final int[] f4452a = new int[]{Util.m4326g("isom"), Util.m4326g("iso2"), Util.m4326g("iso3"), Util.m4326g("iso4"), Util.m4326g("iso5"), Util.m4326g("iso6"), Util.m4326g(VisualSampleEntry.TYPE3), Util.m4326g(VisualSampleEntry.TYPE6), Util.m4326g(VisualSampleEntry.TYPE7), Util.m4326g("mp41"), Util.m4326g("mp42"), Util.m4326g("3g2a"), Util.m4326g("3g2b"), Util.m4326g("3gr6"), Util.m4326g("3gs6"), Util.m4326g("3ge6"), Util.m4326g("3gg6"), Util.m4326g("M4V "), Util.m4326g("M4A "), Util.m4326g("f4v "), Util.m4326g("kddi"), Util.m4326g("M4VP"), Util.m4326g("qt  "), Util.m4326g("MSNV")};

    public static boolean m3816a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return m3817a(extractorInput, true);
    }

    public static boolean m3818b(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return m3817a(extractorInput, false);
    }

    private static boolean m3817a(ExtractorInput extractorInput, boolean z) throws IOException, InterruptedException {
        boolean z2;
        ExtractorInput extractorInput2 = extractorInput;
        long d = extractorInput.mo1341d();
        long j = -1;
        if (d == -1 || d > 4096) {
            d = 4096;
        }
        int i = (int) d;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int i2 = 0;
        int i3 = i2;
        while (i2 < i) {
            parsableByteArray.m4242a(8);
            extractorInput2.mo1340c(parsableByteArray.f5256a, 0, 8);
            long h = parsableByteArray.m4257h();
            int j2 = parsableByteArray.m4259j();
            int i4 = 16;
            if (h == 1) {
                extractorInput2.mo1340c(parsableByteArray.f5256a, 8, 8);
                parsableByteArray.m4247b(16);
                h = parsableByteArray.m4265p();
            } else {
                if (h == 0) {
                    long d2 = extractorInput.mo1341d();
                    if (d2 != j) {
                        h = 8 + (d2 - extractorInput.mo1338c());
                    }
                }
                i4 = 8;
            }
            j = (long) i4;
            if (h < j) {
                return false;
            }
            i2 += i4;
            if (j2 != Atom.f4325B) {
                if (j2 != Atom.f4334K) {
                    if (j2 != Atom.f4336M) {
                        if ((((long) i2) + h) - j >= ((long) i)) {
                            break;
                        }
                        int i5 = (int) (h - j);
                        i2 += i5;
                        if (j2 == Atom.f4350a) {
                            if (i5 < 8) {
                                return false;
                            }
                            parsableByteArray.m4242a(i5);
                            extractorInput2.mo1340c(parsableByteArray.f5256a, 0, i5);
                            i5 /= 4;
                            for (int i6 = 0; i6 < i5; i6++) {
                                if (i6 != 1) {
                                    boolean z3;
                                    int j3 = parsableByteArray.m4259j();
                                    if ((j3 >>> 8) != Util.m4326g("3gp")) {
                                        int[] iArr = f4452a;
                                        int length = iArr.length;
                                        int i7 = 0;
                                        while (i7 < length) {
                                            if (iArr[i7] != j3) {
                                                i7++;
                                            }
                                        }
                                        z3 = false;
                                        if (z3) {
                                            i3 = 1;
                                            break;
                                        }
                                    }
                                    z3 = true;
                                    if (z3) {
                                        i3 = 1;
                                        break;
                                    }
                                } else {
                                    parsableByteArray.m4251d(4);
                                }
                            }
                            if (i3 == 0) {
                                return false;
                            }
                        } else if (i5 != 0) {
                            extractorInput2.mo1339c(i5);
                        }
                    }
                }
                z2 = true;
                break;
            }
            j = -1;
        }
        z2 = false;
        if (i3 == 0 || z != r0) {
            return false;
        }
        return true;
    }
}

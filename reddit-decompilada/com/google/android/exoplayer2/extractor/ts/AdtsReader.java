package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.gms.ads.AdRequest;
import java.util.Arrays;
import java.util.Collections;

public final class AdtsReader implements ElementaryStreamReader {
    private static final byte[] f13066b = new byte[]{(byte) 73, (byte) 68, (byte) 51};
    long f13067a;
    private final boolean f13068c;
    private final ParsableBitArray f13069d;
    private final ParsableByteArray f13070e;
    private final String f13071f;
    private String f13072g;
    private TrackOutput f13073h;
    private TrackOutput f13074i;
    private int f13075j;
    private int f13076k;
    private int f13077l;
    private boolean f13078m;
    private boolean f13079n;
    private long f13080o;
    private int f13081p;
    private TrackOutput f13082q;
    private long f13083r;

    public final void mo1380b() {
    }

    public AdtsReader() {
        this(true, null);
    }

    public AdtsReader(boolean z, String str) {
        this.f13069d = new ParsableBitArray(new byte[7]);
        this.f13070e = new ParsableByteArray(Arrays.copyOf(f13066b, 10));
        m12178c();
        this.f13068c = z;
        this.f13071f = str;
    }

    public final void mo1376a() {
        m12178c();
    }

    public final void mo1378a(ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.m3876a();
        this.f13072g = trackIdGenerator.m3878c();
        this.f13073h = extractorOutput.mo1415a(trackIdGenerator.m3877b(), 1);
        if (this.f13068c) {
            trackIdGenerator.m3876a();
            this.f13074i = extractorOutput.mo1415a(trackIdGenerator.m3877b(), 4);
            this.f13074i.mo1345a(Format.m3573b(trackIdGenerator.m3878c(), "application/id3"));
            return;
        }
        this.f13074i = new DummyTrackOutput();
    }

    public final void mo1377a(long j, boolean z) {
        this.f13067a = j;
    }

    public final void mo1379a(ParsableByteArray parsableByteArray) {
        AdtsReader adtsReader = this;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        while (parsableByteArray.m4246b() > 0) {
            boolean z = true;
            byte[] bArr;
            int i;
            int c;
            switch (adtsReader.f13075j) {
                case 0:
                    bArr = parsableByteArray2.f5256a;
                    i = parsableByteArray2.f5257b;
                    int i2 = parsableByteArray2.f5258c;
                    while (i < i2) {
                        int i3 = i + 1;
                        i = bArr[i] & 255;
                        if (adtsReader.f13077l != AdRequest.MAX_CONTENT_URL_LENGTH || i < 240 || i == 255) {
                            i |= adtsReader.f13077l;
                            if (i == 329) {
                                adtsReader.f13077l = 768;
                            } else if (i == 511) {
                                adtsReader.f13077l = AdRequest.MAX_CONTENT_URL_LENGTH;
                            } else if (i == 836) {
                                adtsReader.f13077l = 1024;
                            } else if (i == 1075) {
                                adtsReader.f13075j = 1;
                                adtsReader.f13076k = f13066b.length;
                                adtsReader.f13081p = 0;
                                adtsReader.f13070e.m4249c(0);
                            } else if (adtsReader.f13077l != 256) {
                                adtsReader.f13077l = 256;
                                i3--;
                            }
                            i = i3;
                        } else {
                            if ((i & 1) != 0) {
                                z = false;
                            }
                            adtsReader.f13078m = z;
                            adtsReader.f13075j = 2;
                            adtsReader.f13076k = 0;
                        }
                        i = i3;
                        parsableByteArray2.m4249c(i);
                        break;
                    }
                    parsableByteArray2.m4249c(i);
                    break;
                case 1:
                    if (!m12172a(parsableByteArray2, adtsReader.f13070e.f5256a, 10)) {
                        break;
                    }
                    adtsReader.f13074i.mo1346a(adtsReader.f13070e, 10);
                    adtsReader.f13070e.m4249c(6);
                    m12171a(adtsReader.f13074i, 0, 10, adtsReader.f13070e.m4262m() + 10);
                    break;
                case 2:
                    if (!m12172a(parsableByteArray2, adtsReader.f13069d.f5252a, adtsReader.f13078m ? 7 : 5)) {
                        break;
                    }
                    adtsReader.f13069d.m4231a(0);
                    if (adtsReader.f13079n) {
                        adtsReader.f13069d.m4234b(10);
                    } else {
                        c = adtsReader.f13069d.m4236c(2) + 1;
                        if (c != 2) {
                            StringBuilder stringBuilder = new StringBuilder("Detected audio object type: ");
                            stringBuilder.append(c);
                            stringBuilder.append(", but assuming AAC LC.");
                            Log.w("AdtsReader", stringBuilder.toString());
                            c = 2;
                        }
                        i = adtsReader.f13069d.m4236c(4);
                        adtsReader.f13069d.m4234b(1);
                        bArr = CodecSpecificDataUtil.m4194a(c, i, adtsReader.f13069d.m4236c(3));
                        Pair a = CodecSpecificDataUtil.m4192a(bArr);
                        Format a2 = Format.m3558a(adtsReader.f13072g, "audio/mp4a-latm", -1, -1, ((Integer) a.second).intValue(), ((Integer) a.first).intValue(), Collections.singletonList(bArr), null, adtsReader.f13071f);
                        adtsReader.f13080o = 1024000000 / ((long) a2.f4031s);
                        adtsReader.f13073h.mo1345a(a2);
                        adtsReader.f13079n = true;
                    }
                    adtsReader.f13069d.m4234b(4);
                    c = (adtsReader.f13069d.m4236c(13) - 2) - 5;
                    if (adtsReader.f13078m) {
                        c -= 2;
                    }
                    m12171a(adtsReader.f13073h, adtsReader.f13080o, 0, c);
                    break;
                case 3:
                    c = Math.min(parsableByteArray.m4246b(), adtsReader.f13081p - adtsReader.f13076k);
                    adtsReader.f13082q.mo1346a(parsableByteArray2, c);
                    adtsReader.f13076k += c;
                    if (adtsReader.f13076k != adtsReader.f13081p) {
                        break;
                    }
                    adtsReader.f13082q.mo1344a(adtsReader.f13067a, 1, adtsReader.f13081p, 0, null);
                    adtsReader.f13067a += adtsReader.f13083r;
                    m12178c();
                    break;
                default:
                    break;
            }
        }
    }

    private boolean m12172a(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = Math.min(parsableByteArray.m4246b(), i - this.f13076k);
        parsableByteArray.m4245a(bArr, this.f13076k, min);
        this.f13076k += min;
        return this.f13076k == i ? true : null;
    }

    final void m12178c() {
        this.f13075j = 0;
        this.f13076k = 0;
        this.f13077l = 256;
    }

    private void m12171a(TrackOutput trackOutput, long j, int i, int i2) {
        this.f13075j = 3;
        this.f13076k = i;
        this.f13082q = trackOutput;
        this.f13083r = j;
        this.f13081p = i2;
    }
}

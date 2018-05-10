package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Collections;

public final class H265Reader implements ElementaryStreamReader {
    private final SeiReader f13131a;
    private String f13132b;
    private TrackOutput f13133c;
    private SampleReader f13134d;
    private boolean f13135e;
    private final boolean[] f13136f = new boolean[3];
    private final NalUnitTargetBuffer f13137g = new NalUnitTargetBuffer(32);
    private final NalUnitTargetBuffer f13138h = new NalUnitTargetBuffer(33);
    private final NalUnitTargetBuffer f13139i = new NalUnitTargetBuffer(34);
    private final NalUnitTargetBuffer f13140j = new NalUnitTargetBuffer(39);
    private final NalUnitTargetBuffer f13141k = new NalUnitTargetBuffer(40);
    private long f13142l;
    private long f13143m;
    private final ParsableByteArray f13144n = new ParsableByteArray();

    private static final class SampleReader {
        long f4596a;
        boolean f4597b;
        int f4598c;
        long f4599d;
        boolean f4600e;
        boolean f4601f;
        boolean f4602g;
        boolean f4603h;
        boolean f4604i;
        long f4605j;
        long f4606k;
        boolean f4607l;
        private final TrackOutput f4608m;

        public SampleReader(TrackOutput trackOutput) {
            this.f4608m = trackOutput;
        }

        final void m3864a(int i) {
            this.f4608m.mo1344a(this.f4606k, this.f4607l, (int) (this.f4596a - this.f4605j), i, null);
        }
    }

    public final void mo1380b() {
    }

    public H265Reader(SeiReader seiReader) {
        this.f13131a = seiReader;
    }

    public final void mo1376a() {
        NalUnitUtil.m4225a(this.f13136f);
        this.f13137g.m3865a();
        this.f13138h.m3865a();
        this.f13139i.m3865a();
        this.f13140j.m3865a();
        this.f13141k.m3865a();
        SampleReader sampleReader = this.f13134d;
        sampleReader.f4600e = false;
        sampleReader.f4601f = false;
        sampleReader.f4602g = false;
        sampleReader.f4603h = false;
        sampleReader.f4604i = false;
        this.f13142l = 0;
    }

    public final void mo1378a(ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.m3876a();
        this.f13132b = trackIdGenerator.m3878c();
        this.f13133c = extractorOutput.mo1415a(trackIdGenerator.m3877b(), 2);
        this.f13134d = new SampleReader(this.f13133c);
        this.f13131a.m3872a(extractorOutput, trackIdGenerator);
    }

    public final void mo1377a(long j, boolean z) {
        this.f13143m = j;
    }

    public final void mo1379a(ParsableByteArray parsableByteArray) {
        H265Reader h265Reader = this;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        while (parsableByteArray.m4246b() > 0) {
            int i = parsableByteArray2.f5257b;
            int i2 = parsableByteArray2.f5258c;
            byte[] bArr = parsableByteArray2.f5256a;
            h265Reader.f13142l += (long) parsableByteArray.m4246b();
            h265Reader.f13133c.mo1346a(parsableByteArray2, parsableByteArray.m4246b());
            while (i < i2) {
                int a = NalUnitUtil.m4222a(bArr, i, i2, h265Reader.f13136f);
                if (a == i2) {
                    m12205a(bArr, i, i2);
                    return;
                }
                int i3;
                byte[] bArr2;
                int i4;
                long j;
                long j2;
                long j3;
                SampleReader sampleReader;
                boolean z;
                boolean z2;
                int c = NalUnitUtil.m4228c(bArr, a);
                int i5 = a - i;
                if (i5 > 0) {
                    m12205a(bArr, i, a);
                }
                i = i2 - a;
                long j4 = h265Reader.f13142l - ((long) i);
                i5 = i5 < 0 ? -i5 : 0;
                long j5 = h265Reader.f13143m;
                if (h265Reader.f13135e) {
                    SampleReader sampleReader2 = h265Reader.f13134d;
                    if (sampleReader2.f4604i && sampleReader2.f4601f) {
                        sampleReader2.f4607l = sampleReader2.f4597b;
                        sampleReader2.f4604i = false;
                        i3 = i2;
                        bArr2 = bArr;
                        i4 = a;
                        j = j5;
                        if (h265Reader.f13140j.m3868b(i5)) {
                            j2 = j;
                        } else {
                            h265Reader.f13144n.m4244a(h265Reader.f13140j.f4610b, NalUnitUtil.m4221a(h265Reader.f13140j.f4610b, h265Reader.f13140j.f4611c));
                            h265Reader.f13144n.m4251d(5);
                            j2 = j;
                            h265Reader.f13131a.m3871a(j2, h265Reader.f13144n);
                        }
                        if (h265Reader.f13141k.m3868b(i5)) {
                            h265Reader.f13144n.m4244a(h265Reader.f13141k.f4610b, NalUnitUtil.m4221a(h265Reader.f13141k.f4610b, h265Reader.f13141k.f4611c));
                            h265Reader.f13144n.m4251d(5);
                            h265Reader.f13131a.m3871a(j2, h265Reader.f13144n);
                        }
                        j3 = h265Reader.f13143m;
                        if (h265Reader.f13135e) {
                            h265Reader.f13137g.m3866a(c);
                            h265Reader.f13138h.m3866a(c);
                            h265Reader.f13139i.m3866a(c);
                        } else {
                            sampleReader = h265Reader.f13134d;
                            sampleReader.f4601f = false;
                            sampleReader.f4602g = false;
                            sampleReader.f4599d = j3;
                            sampleReader.f4598c = 0;
                            sampleReader.f4596a = j4;
                            if (c >= 32) {
                                if (!sampleReader.f4604i && sampleReader.f4603h) {
                                    sampleReader.m3864a(i);
                                    sampleReader.f4603h = false;
                                }
                                if (c <= 34) {
                                    z = true;
                                    sampleReader.f4602g = sampleReader.f4604i ^ true;
                                    sampleReader.f4604i = true;
                                    z2 = (c >= 16 || c > 21) ? false : z;
                                    sampleReader.f4597b = z2;
                                    if (!sampleReader.f4597b) {
                                        if (c > 9) {
                                            z = false;
                                        }
                                    }
                                    sampleReader.f4600e = z;
                                }
                            }
                            z = true;
                            if (c >= 16) {
                            }
                            sampleReader.f4597b = z2;
                            if (sampleReader.f4597b) {
                                if (c > 9) {
                                    z = false;
                                }
                            }
                            sampleReader.f4600e = z;
                        }
                        h265Reader.f13140j.m3866a(c);
                        h265Reader.f13141k.m3866a(c);
                        i = i4 + 3;
                        i2 = i3;
                        bArr = bArr2;
                        parsableByteArray2 = parsableByteArray;
                    } else {
                        if (!sampleReader2.f4602g) {
                            if (!sampleReader2.f4601f) {
                                j = j5;
                            }
                        }
                        if (sampleReader2.f4603h) {
                            j = j5;
                            sampleReader2.m3864a(((int) (j4 - sampleReader2.f4596a)) + i);
                        } else {
                            j = j5;
                        }
                        sampleReader2.f4605j = sampleReader2.f4596a;
                        sampleReader2.f4606k = sampleReader2.f4599d;
                        sampleReader2.f4603h = true;
                        sampleReader2.f4607l = sampleReader2.f4597b;
                    }
                } else {
                    j = j5;
                    h265Reader.f13137g.m3868b(i5);
                    h265Reader.f13138h.m3868b(i5);
                    h265Reader.f13139i.m3868b(i5);
                    if (h265Reader.f13137g.f4609a && h265Reader.f13138h.f4609a && h265Reader.f13139i.f4609a) {
                        int i6;
                        int e;
                        int e2;
                        float f;
                        TrackOutput trackOutput = h265Reader.f13133c;
                        String str = h265Reader.f13132b;
                        NalUnitTargetBuffer nalUnitTargetBuffer = h265Reader.f13137g;
                        NalUnitTargetBuffer nalUnitTargetBuffer2 = h265Reader.f13138h;
                        NalUnitTargetBuffer nalUnitTargetBuffer3 = h265Reader.f13139i;
                        Object obj = new byte[((nalUnitTargetBuffer.f4611c + nalUnitTargetBuffer2.f4611c) + nalUnitTargetBuffer3.f4611c)];
                        i3 = i2;
                        bArr2 = bArr;
                        System.arraycopy(nalUnitTargetBuffer.f4610b, 0, obj, 0, nalUnitTargetBuffer.f4611c);
                        i4 = a;
                        System.arraycopy(nalUnitTargetBuffer2.f4610b, 0, obj, nalUnitTargetBuffer.f4611c, nalUnitTargetBuffer2.f4611c);
                        System.arraycopy(nalUnitTargetBuffer3.f4610b, 0, obj, nalUnitTargetBuffer.f4611c + nalUnitTargetBuffer2.f4611c, nalUnitTargetBuffer3.f4611c);
                        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(nalUnitTargetBuffer2.f4610b, 0, nalUnitTargetBuffer2.f4611c);
                        parsableNalUnitBitArray.m4271a(44);
                        int i7 = 3;
                        int c2 = parsableNalUnitBitArray.m4275c(3);
                        parsableNalUnitBitArray.m4270a();
                        parsableNalUnitBitArray.m4271a(88);
                        parsableNalUnitBitArray.m4271a(8);
                        int i8 = 0;
                        for (i6 = 0; i6 < c2; i6++) {
                            if (parsableNalUnitBitArray.m4273b()) {
                                i8 += 89;
                            }
                            if (parsableNalUnitBitArray.m4273b()) {
                                i8 += 8;
                            }
                        }
                        parsableNalUnitBitArray.m4271a(i8);
                        i6 = 2;
                        if (c2 > 0) {
                            parsableNalUnitBitArray.m4271a((8 - c2) * 2);
                        }
                        parsableNalUnitBitArray.m4278e();
                        i8 = parsableNalUnitBitArray.m4278e();
                        if (i8 == 3) {
                            parsableNalUnitBitArray.m4270a();
                        }
                        int e3 = parsableNalUnitBitArray.m4278e();
                        int e4 = parsableNalUnitBitArray.m4278e();
                        if (parsableNalUnitBitArray.m4273b()) {
                            int i9;
                            int e5 = parsableNalUnitBitArray.m4278e();
                            e = parsableNalUnitBitArray.m4278e();
                            e2 = parsableNalUnitBitArray.m4278e();
                            int e6 = parsableNalUnitBitArray.m4278e();
                            if (i8 != 1) {
                                if (i8 != 2) {
                                    i9 = 1;
                                    e3 -= i9 * (e5 + e);
                                    e4 -= (i8 != 1 ? 2 : 1) * (e2 + e6);
                                }
                            }
                            i9 = 2;
                            if (i8 != 1) {
                            }
                            e3 -= i9 * (e5 + e);
                            e4 -= (i8 != 1 ? 2 : 1) * (e2 + e6);
                        }
                        e = e3;
                        e2 = e4;
                        parsableNalUnitBitArray.m4278e();
                        parsableNalUnitBitArray.m4278e();
                        a = parsableNalUnitBitArray.m4278e();
                        i8 = parsableNalUnitBitArray.m4273b() ? 0 : c2;
                        while (i8 <= c2) {
                            parsableNalUnitBitArray.m4278e();
                            parsableNalUnitBitArray.m4278e();
                            parsableNalUnitBitArray.m4278e();
                            i8++;
                        }
                        parsableNalUnitBitArray.m4278e();
                        parsableNalUnitBitArray.m4278e();
                        parsableNalUnitBitArray.m4278e();
                        parsableNalUnitBitArray.m4278e();
                        parsableNalUnitBitArray.m4278e();
                        parsableNalUnitBitArray.m4278e();
                        i8 = 4;
                        if (parsableNalUnitBitArray.m4273b() && parsableNalUnitBitArray.m4273b()) {
                            c2 = 0;
                            while (c2 < i8) {
                                e3 = 0;
                                while (e3 < 6) {
                                    if (parsableNalUnitBitArray.m4273b()) {
                                        i6 = Math.min(64, 1 << (i8 + (c2 << 1)));
                                        if (c2 > 1) {
                                            parsableNalUnitBitArray.m4277d();
                                        }
                                        for (i8 = 0; i8 < i6; i8++) {
                                            parsableNalUnitBitArray.m4277d();
                                        }
                                        i6 = 3;
                                    } else {
                                        parsableNalUnitBitArray.m4278e();
                                        i6 = i7;
                                    }
                                    e3 += c2 == i6 ? i6 : 1;
                                    i7 = i6;
                                    i8 = 4;
                                }
                                i6 = i7;
                                c2++;
                                i6 = 2;
                                i8 = 4;
                            }
                        }
                        parsableNalUnitBitArray.m4271a(i6);
                        if (parsableNalUnitBitArray.m4273b()) {
                            parsableNalUnitBitArray.m4271a(8);
                            parsableNalUnitBitArray.m4278e();
                            parsableNalUnitBitArray.m4278e();
                            parsableNalUnitBitArray.m4270a();
                        }
                        c2 = parsableNalUnitBitArray.m4278e();
                        i6 = 0;
                        boolean z3 = false;
                        e3 = 0;
                        while (i6 < c2) {
                            int i10;
                            if (i6 != 0) {
                                z3 = parsableNalUnitBitArray.m4273b();
                            }
                            if (z3) {
                                parsableNalUnitBitArray.m4270a();
                                parsableNalUnitBitArray.m4278e();
                                for (i7 = 0; i7 <= e3; i7++) {
                                    if (parsableNalUnitBitArray.m4273b()) {
                                        parsableNalUnitBitArray.m4270a();
                                    }
                                }
                                i10 = c2;
                            } else {
                                e3 = parsableNalUnitBitArray.m4278e();
                                i7 = parsableNalUnitBitArray.m4278e();
                                e4 = e3 + i7;
                                i10 = c2;
                                for (c2 = 0; c2 < e3; c2++) {
                                    parsableNalUnitBitArray.m4278e();
                                    parsableNalUnitBitArray.m4270a();
                                }
                                for (c2 = 0; c2 < i7; c2++) {
                                    parsableNalUnitBitArray.m4278e();
                                    parsableNalUnitBitArray.m4270a();
                                }
                                e3 = e4;
                            }
                            i6++;
                            c2 = i10;
                        }
                        if (parsableNalUnitBitArray.m4273b()) {
                            for (c2 = 0; c2 < parsableNalUnitBitArray.m4278e(); c2++) {
                                parsableNalUnitBitArray.m4271a((a + 4) + 1);
                            }
                        }
                        parsableNalUnitBitArray.m4271a(2);
                        float f2 = 1.0f;
                        if (parsableNalUnitBitArray.m4273b() && parsableNalUnitBitArray.m4273b()) {
                            a = parsableNalUnitBitArray.m4275c(8);
                            if (a == 255) {
                                a = parsableNalUnitBitArray.m4275c(16);
                                i2 = parsableNalUnitBitArray.m4275c(16);
                                if (!(a == 0 || i2 == 0)) {
                                    f2 = ((float) a) / ((float) i2);
                                }
                            } else if (a < NalUnitUtil.f5249b.length) {
                                f = NalUnitUtil.f5249b[a];
                                trackOutput.mo1345a(Format.m3560a(str, "video/hevc", e, e2, Collections.singletonList(obj), f));
                                h265Reader.f13135e = true;
                                if (h265Reader.f13140j.m3868b(i5)) {
                                    j2 = j;
                                } else {
                                    h265Reader.f13144n.m4244a(h265Reader.f13140j.f4610b, NalUnitUtil.m4221a(h265Reader.f13140j.f4610b, h265Reader.f13140j.f4611c));
                                    h265Reader.f13144n.m4251d(5);
                                    j2 = j;
                                    h265Reader.f13131a.m3871a(j2, h265Reader.f13144n);
                                }
                                if (h265Reader.f13141k.m3868b(i5)) {
                                    h265Reader.f13144n.m4244a(h265Reader.f13141k.f4610b, NalUnitUtil.m4221a(h265Reader.f13141k.f4610b, h265Reader.f13141k.f4611c));
                                    h265Reader.f13144n.m4251d(5);
                                    h265Reader.f13131a.m3871a(j2, h265Reader.f13144n);
                                }
                                j3 = h265Reader.f13143m;
                                if (h265Reader.f13135e) {
                                    h265Reader.f13137g.m3866a(c);
                                    h265Reader.f13138h.m3866a(c);
                                    h265Reader.f13139i.m3866a(c);
                                } else {
                                    sampleReader = h265Reader.f13134d;
                                    sampleReader.f4601f = false;
                                    sampleReader.f4602g = false;
                                    sampleReader.f4599d = j3;
                                    sampleReader.f4598c = 0;
                                    sampleReader.f4596a = j4;
                                    if (c >= 32) {
                                        sampleReader.m3864a(i);
                                        sampleReader.f4603h = false;
                                        if (c <= 34) {
                                            z = true;
                                            sampleReader.f4602g = sampleReader.f4604i ^ true;
                                            sampleReader.f4604i = true;
                                            if (c >= 16) {
                                            }
                                            sampleReader.f4597b = z2;
                                            if (sampleReader.f4597b) {
                                                if (c > 9) {
                                                    z = false;
                                                }
                                            }
                                            sampleReader.f4600e = z;
                                        }
                                    }
                                    z = true;
                                    if (c >= 16) {
                                    }
                                    sampleReader.f4597b = z2;
                                    if (sampleReader.f4597b) {
                                        if (c > 9) {
                                            z = false;
                                        }
                                    }
                                    sampleReader.f4600e = z;
                                }
                                h265Reader.f13140j.m3866a(c);
                                h265Reader.f13141k.m3866a(c);
                                i = i4 + 3;
                                i2 = i3;
                                bArr = bArr2;
                                parsableByteArray2 = parsableByteArray;
                            } else {
                                StringBuilder stringBuilder = new StringBuilder("Unexpected aspect_ratio_idc value: ");
                                stringBuilder.append(a);
                                Log.w("H265Reader", stringBuilder.toString());
                            }
                        }
                        f = f2;
                        trackOutput.mo1345a(Format.m3560a(str, "video/hevc", e, e2, Collections.singletonList(obj), f));
                        h265Reader.f13135e = true;
                        if (h265Reader.f13140j.m3868b(i5)) {
                            h265Reader.f13144n.m4244a(h265Reader.f13140j.f4610b, NalUnitUtil.m4221a(h265Reader.f13140j.f4610b, h265Reader.f13140j.f4611c));
                            h265Reader.f13144n.m4251d(5);
                            j2 = j;
                            h265Reader.f13131a.m3871a(j2, h265Reader.f13144n);
                        } else {
                            j2 = j;
                        }
                        if (h265Reader.f13141k.m3868b(i5)) {
                            h265Reader.f13144n.m4244a(h265Reader.f13141k.f4610b, NalUnitUtil.m4221a(h265Reader.f13141k.f4610b, h265Reader.f13141k.f4611c));
                            h265Reader.f13144n.m4251d(5);
                            h265Reader.f13131a.m3871a(j2, h265Reader.f13144n);
                        }
                        j3 = h265Reader.f13143m;
                        if (h265Reader.f13135e) {
                            sampleReader = h265Reader.f13134d;
                            sampleReader.f4601f = false;
                            sampleReader.f4602g = false;
                            sampleReader.f4599d = j3;
                            sampleReader.f4598c = 0;
                            sampleReader.f4596a = j4;
                            if (c >= 32) {
                                sampleReader.m3864a(i);
                                sampleReader.f4603h = false;
                                if (c <= 34) {
                                    z = true;
                                    sampleReader.f4602g = sampleReader.f4604i ^ true;
                                    sampleReader.f4604i = true;
                                    if (c >= 16) {
                                    }
                                    sampleReader.f4597b = z2;
                                    if (sampleReader.f4597b) {
                                        if (c > 9) {
                                            z = false;
                                        }
                                    }
                                    sampleReader.f4600e = z;
                                }
                            }
                            z = true;
                            if (c >= 16) {
                            }
                            sampleReader.f4597b = z2;
                            if (sampleReader.f4597b) {
                                if (c > 9) {
                                    z = false;
                                }
                            }
                            sampleReader.f4600e = z;
                        } else {
                            h265Reader.f13137g.m3866a(c);
                            h265Reader.f13138h.m3866a(c);
                            h265Reader.f13139i.m3866a(c);
                        }
                        h265Reader.f13140j.m3866a(c);
                        h265Reader.f13141k.m3866a(c);
                        i = i4 + 3;
                        i2 = i3;
                        bArr = bArr2;
                        parsableByteArray2 = parsableByteArray;
                    }
                }
                i3 = i2;
                bArr2 = bArr;
                i4 = a;
                if (h265Reader.f13140j.m3868b(i5)) {
                    j2 = j;
                } else {
                    h265Reader.f13144n.m4244a(h265Reader.f13140j.f4610b, NalUnitUtil.m4221a(h265Reader.f13140j.f4610b, h265Reader.f13140j.f4611c));
                    h265Reader.f13144n.m4251d(5);
                    j2 = j;
                    h265Reader.f13131a.m3871a(j2, h265Reader.f13144n);
                }
                if (h265Reader.f13141k.m3868b(i5)) {
                    h265Reader.f13144n.m4244a(h265Reader.f13141k.f4610b, NalUnitUtil.m4221a(h265Reader.f13141k.f4610b, h265Reader.f13141k.f4611c));
                    h265Reader.f13144n.m4251d(5);
                    h265Reader.f13131a.m3871a(j2, h265Reader.f13144n);
                }
                j3 = h265Reader.f13143m;
                if (h265Reader.f13135e) {
                    h265Reader.f13137g.m3866a(c);
                    h265Reader.f13138h.m3866a(c);
                    h265Reader.f13139i.m3866a(c);
                } else {
                    sampleReader = h265Reader.f13134d;
                    sampleReader.f4601f = false;
                    sampleReader.f4602g = false;
                    sampleReader.f4599d = j3;
                    sampleReader.f4598c = 0;
                    sampleReader.f4596a = j4;
                    if (c >= 32) {
                        sampleReader.m3864a(i);
                        sampleReader.f4603h = false;
                        if (c <= 34) {
                            z = true;
                            sampleReader.f4602g = sampleReader.f4604i ^ true;
                            sampleReader.f4604i = true;
                            if (c >= 16) {
                            }
                            sampleReader.f4597b = z2;
                            if (sampleReader.f4597b) {
                                if (c > 9) {
                                    z = false;
                                }
                            }
                            sampleReader.f4600e = z;
                        }
                    }
                    z = true;
                    if (c >= 16) {
                    }
                    sampleReader.f4597b = z2;
                    if (sampleReader.f4597b) {
                        if (c > 9) {
                            z = false;
                        }
                    }
                    sampleReader.f4600e = z;
                }
                h265Reader.f13140j.m3866a(c);
                h265Reader.f13141k.m3866a(c);
                i = i4 + 3;
                i2 = i3;
                bArr = bArr2;
                parsableByteArray2 = parsableByteArray;
            }
        }
    }

    private void m12205a(byte[] bArr, int i, int i2) {
        if (this.f13135e) {
            SampleReader sampleReader = this.f13134d;
            if (sampleReader.f4600e) {
                int i3 = (i + 2) - sampleReader.f4598c;
                if (i3 < i2) {
                    sampleReader.f4601f = (bArr[i3] & 128) != 0;
                    sampleReader.f4600e = false;
                } else {
                    sampleReader.f4598c += i2 - i;
                }
            }
        } else {
            this.f13137g.m3867a(bArr, i, i2);
            this.f13138h.m3867a(bArr, i, i2);
            this.f13139i.m3867a(bArr, i, i2);
        }
        this.f13140j.m3867a(bArr, i, i2);
        this.f13141k.m3867a(bArr, i, i2);
    }
}

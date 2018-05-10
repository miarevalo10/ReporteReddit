package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Ac3Reader implements ElementaryStreamReader {
    long f13048a;
    private final ParsableBitArray f13049b;
    private final ParsableByteArray f13050c;
    private final String f13051d;
    private String f13052e;
    private TrackOutput f13053f;
    private int f13054g;
    private int f13055h;
    private boolean f13056i;
    private long f13057j;
    private Format f13058k;
    private int f13059l;

    public final void mo1380b() {
    }

    public Ac3Reader() {
        this(null);
    }

    public Ac3Reader(String str) {
        this.f13049b = new ParsableBitArray(new byte[8]);
        this.f13050c = new ParsableByteArray(this.f13049b.f5252a);
        this.f13054g = 0;
        this.f13051d = str;
    }

    public final void mo1376a() {
        this.f13054g = 0;
        this.f13055h = 0;
        this.f13056i = false;
    }

    public final void mo1378a(ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.m3876a();
        this.f13052e = trackIdGenerator.m3878c();
        this.f13053f = extractorOutput.mo1415a(trackIdGenerator.m3877b(), 1);
    }

    public final void mo1377a(long j, boolean z) {
        this.f13048a = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo1379a(com.google.android.exoplayer2.util.ParsableByteArray r19) {
        /*
        r18 = this;
        r0 = r18;
        r1 = r19;
    L_0x0004:
        r2 = r19.m4246b();
        if (r2 <= 0) goto L_0x0113;
    L_0x000a:
        r2 = r0.f13054g;
        r3 = 2;
        r4 = 1;
        r5 = 0;
        switch(r2) {
            case 0: goto L_0x00d2;
            case 1: goto L_0x0046;
            case 2: goto L_0x0013;
            default: goto L_0x0012;
        };
    L_0x0012:
        goto L_0x0004;
    L_0x0013:
        r2 = r19.m4246b();
        r3 = r0.f13059l;
        r4 = r0.f13055h;
        r3 = r3 - r4;
        r2 = java.lang.Math.min(r2, r3);
        r3 = r0.f13053f;
        r3.mo1346a(r1, r2);
        r3 = r0.f13055h;
        r3 = r3 + r2;
        r0.f13055h = r3;
        r2 = r0.f13055h;
        r3 = r0.f13059l;
        if (r2 != r3) goto L_0x0004;
    L_0x0030:
        r6 = r0.f13053f;
        r7 = r0.f13048a;
        r9 = 1;
        r10 = r0.f13059l;
        r11 = 0;
        r12 = 0;
        r6.mo1344a(r7, r9, r10, r11, r12);
        r2 = r0.f13048a;
        r6 = r0.f13057j;
        r2 = r2 + r6;
        r0.f13048a = r2;
        r0.f13054g = r5;
        goto L_0x0004;
    L_0x0046:
        r2 = r0.f13050c;
        r2 = r2.f5256a;
        r6 = r19.m4246b();
        r7 = r0.f13055h;
        r8 = 8;
        r7 = 8 - r7;
        r6 = java.lang.Math.min(r6, r7);
        r7 = r0.f13055h;
        r1.m4245a(r2, r7, r6);
        r2 = r0.f13055h;
        r2 = r2 + r6;
        r0.f13055h = r2;
        r2 = r0.f13055h;
        if (r2 != r8) goto L_0x0067;
    L_0x0066:
        goto L_0x0068;
    L_0x0067:
        r4 = r5;
    L_0x0068:
        if (r4 == 0) goto L_0x0004;
    L_0x006a:
        r2 = r0.f13049b;
        r2.m4231a(r5);
        r2 = r0.f13049b;
        r2 = com.google.android.exoplayer2.audio.Ac3Util.m3644a(r2);
        r4 = r0.f13058k;
        if (r4 == 0) goto L_0x0091;
    L_0x0079:
        r4 = r2.f4084c;
        r6 = r0.f13058k;
        r6 = r6.f4030r;
        if (r4 != r6) goto L_0x0091;
    L_0x0081:
        r4 = r2.f4083b;
        r6 = r0.f13058k;
        r6 = r6.f4031s;
        if (r4 != r6) goto L_0x0091;
    L_0x0089:
        r4 = r2.f4082a;
        r6 = r0.f13058k;
        r6 = r6.f4018f;
        if (r4 == r6) goto L_0x00af;
    L_0x0091:
        r9 = r0.f13052e;
        r10 = r2.f4082a;
        r11 = -1;
        r12 = -1;
        r13 = r2.f4084c;
        r14 = r2.f4083b;
        r15 = 0;
        r16 = 0;
        r4 = r0.f13051d;
        r17 = r4;
        r4 = com.google.android.exoplayer2.Format.m3558a(r9, r10, r11, r12, r13, r14, r15, r16, r17);
        r0.f13058k = r4;
        r4 = r0.f13053f;
        r6 = r0.f13058k;
        r4.mo1345a(r6);
    L_0x00af:
        r4 = r2.f4085d;
        r0.f13059l = r4;
        r6 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r2 = r2.f4086e;
        r9 = (long) r2;
        r6 = r6 * r9;
        r2 = r0.f13058k;
        r2 = r2.f4031s;
        r9 = (long) r2;
        r6 = r6 / r9;
        r0.f13057j = r6;
        r2 = r0.f13050c;
        r2.m4249c(r5);
        r2 = r0.f13053f;
        r4 = r0.f13050c;
        r2.mo1346a(r4, r8);
        r0.f13054g = r3;
        goto L_0x0004;
    L_0x00d2:
        r2 = r19.m4246b();
        r6 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        r7 = 11;
        if (r2 <= 0) goto L_0x00fe;
    L_0x00dc:
        r2 = r0.f13056i;
        if (r2 != 0) goto L_0x00ec;
    L_0x00e0:
        r2 = r19.m4250d();
        if (r2 != r7) goto L_0x00e8;
    L_0x00e6:
        r2 = r4;
        goto L_0x00e9;
    L_0x00e8:
        r2 = r5;
    L_0x00e9:
        r0.f13056i = r2;
        goto L_0x00d2;
    L_0x00ec:
        r2 = r19.m4250d();
        if (r2 != r6) goto L_0x00f6;
    L_0x00f2:
        r0.f13056i = r5;
        r2 = r4;
        goto L_0x00ff;
    L_0x00f6:
        if (r2 != r7) goto L_0x00fa;
    L_0x00f8:
        r2 = r4;
        goto L_0x00fb;
    L_0x00fa:
        r2 = r5;
    L_0x00fb:
        r0.f13056i = r2;
        goto L_0x00d2;
    L_0x00fe:
        r2 = r5;
    L_0x00ff:
        if (r2 == 0) goto L_0x0004;
    L_0x0101:
        r0.f13054g = r4;
        r2 = r0.f13050c;
        r2 = r2.f5256a;
        r2[r5] = r7;
        r2 = r0.f13050c;
        r2 = r2.f5256a;
        r2[r4] = r6;
        r0.f13055h = r3;
        goto L_0x0004;
    L_0x0113:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.Ac3Reader.a(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }
}

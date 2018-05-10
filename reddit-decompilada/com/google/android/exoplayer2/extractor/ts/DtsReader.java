package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import org.jcodec.containers.mxf.model.BER;

public final class DtsReader implements ElementaryStreamReader {
    private final ParsableByteArray f13086a = new ParsableByteArray(new byte[15]);
    private final String f13087b;
    private String f13088c;
    private TrackOutput f13089d;
    private int f13090e;
    private int f13091f;
    private int f13092g;
    private long f13093h;
    private Format f13094i;
    private int f13095j;
    private long f13096k;

    public final void mo1380b() {
    }

    public DtsReader(String str) {
        this.f13086a.f5256a[0] = Byte.MAX_VALUE;
        this.f13086a.f5256a[1] = (byte) -2;
        this.f13086a.f5256a[2] = BER.ASN_LONG_LEN;
        this.f13086a.f5256a[3] = (byte) 1;
        this.f13090e = 0;
        this.f13087b = str;
    }

    public final void mo1376a() {
        this.f13090e = 0;
        this.f13091f = 0;
        this.f13092g = 0;
    }

    public final void mo1378a(ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.m3876a();
        this.f13088c = trackIdGenerator.m3878c();
        this.f13089d = extractorOutput.mo1415a(trackIdGenerator.m3877b(), 1);
    }

    public final void mo1377a(long j, boolean z) {
        this.f13096k = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo1379a(com.google.android.exoplayer2.util.ParsableByteArray r11) {
        /*
        r10 = this;
    L_0x0000:
        r0 = r11.m4246b();
        if (r0 <= 0) goto L_0x00d0;
    L_0x0006:
        r0 = r10.f13090e;
        r1 = 1;
        r2 = 0;
        switch(r0) {
            case 0: goto L_0x00a8;
            case 1: goto L_0x0041;
            case 2: goto L_0x000e;
            default: goto L_0x000d;
        };
    L_0x000d:
        goto L_0x0000;
    L_0x000e:
        r0 = r11.m4246b();
        r1 = r10.f13095j;
        r3 = r10.f13091f;
        r1 = r1 - r3;
        r0 = java.lang.Math.min(r0, r1);
        r1 = r10.f13089d;
        r1.mo1346a(r11, r0);
        r1 = r10.f13091f;
        r1 = r1 + r0;
        r10.f13091f = r1;
        r0 = r10.f13091f;
        r1 = r10.f13095j;
        if (r0 != r1) goto L_0x0000;
    L_0x002b:
        r3 = r10.f13089d;
        r4 = r10.f13096k;
        r6 = 1;
        r7 = r10.f13095j;
        r8 = 0;
        r9 = 0;
        r3.mo1344a(r4, r6, r7, r8, r9);
        r0 = r10.f13096k;
        r3 = r10.f13093h;
        r0 = r0 + r3;
        r10.f13096k = r0;
        r10.f13090e = r2;
        goto L_0x0000;
    L_0x0041:
        r0 = r10.f13086a;
        r0 = r0.f5256a;
        r3 = r11.m4246b();
        r4 = r10.f13091f;
        r5 = 15;
        r4 = 15 - r4;
        r3 = java.lang.Math.min(r3, r4);
        r4 = r10.f13091f;
        r11.m4245a(r0, r4, r3);
        r0 = r10.f13091f;
        r0 = r0 + r3;
        r10.f13091f = r0;
        r0 = r10.f13091f;
        if (r0 != r5) goto L_0x0062;
    L_0x0061:
        goto L_0x0063;
    L_0x0062:
        r1 = r2;
    L_0x0063:
        if (r1 == 0) goto L_0x0000;
    L_0x0065:
        r0 = r10.f13086a;
        r0 = r0.f5256a;
        r1 = r10.f13094i;
        if (r1 != 0) goto L_0x007e;
    L_0x006d:
        r1 = r10.f13088c;
        r3 = r10.f13087b;
        r1 = com.google.android.exoplayer2.audio.DtsUtil.m3703a(r0, r1, r3);
        r10.f13094i = r1;
        r1 = r10.f13089d;
        r3 = r10.f13094i;
        r1.mo1345a(r3);
    L_0x007e:
        r1 = com.google.android.exoplayer2.audio.DtsUtil.m3704b(r0);
        r10.f13095j = r1;
        r3 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r0 = com.google.android.exoplayer2.audio.DtsUtil.m3702a(r0);
        r0 = (long) r0;
        r3 = r3 * r0;
        r0 = r10.f13094i;
        r0 = r0.f4031s;
        r0 = (long) r0;
        r3 = r3 / r0;
        r0 = (int) r3;
        r0 = (long) r0;
        r10.f13093h = r0;
        r0 = r10.f13086a;
        r0.m4249c(r2);
        r0 = r10.f13089d;
        r1 = r10.f13086a;
        r0.mo1346a(r1, r5);
        r0 = 2;
        r10.f13090e = r0;
        goto L_0x0000;
    L_0x00a8:
        r0 = r11.m4246b();
        if (r0 <= 0) goto L_0x00c7;
    L_0x00ae:
        r0 = r10.f13092g;
        r0 = r0 << 8;
        r10.f13092g = r0;
        r0 = r10.f13092g;
        r3 = r11.m4250d();
        r0 = r0 | r3;
        r10.f13092g = r0;
        r0 = r10.f13092g;
        r3 = 2147385345; // 0x7ffe8001 float:NaN double:1.0609493273E-314;
        if (r0 != r3) goto L_0x00a8;
    L_0x00c4:
        r10.f13092g = r2;
        r2 = r1;
    L_0x00c7:
        if (r2 == 0) goto L_0x0000;
    L_0x00c9:
        r0 = 4;
        r10.f13091f = r0;
        r10.f13090e = r1;
        goto L_0x0000;
    L_0x00d0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.DtsReader.a(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }
}

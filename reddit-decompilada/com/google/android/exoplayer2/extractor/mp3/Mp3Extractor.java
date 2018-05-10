package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class Mp3Extractor implements Extractor {
    public static final ExtractorsFactory f12925a = new C11301();
    private static final int f12926b = Util.m4326g("Xing");
    private static final int f12927c = Util.m4326g("Info");
    private static final int f12928d = Util.m4326g("VBRI");
    private final int f12929e;
    private final long f12930f;
    private final ParsableByteArray f12931g;
    private final MpegAudioHeader f12932h;
    private final GaplessInfoHolder f12933i;
    private ExtractorOutput f12934j;
    private TrackOutput f12935k;
    private int f12936l;
    private Metadata f12937m;
    private Seeker f12938n;
    private long f12939o;
    private long f12940p;
    private int f12941q;

    static class C11301 implements ExtractorsFactory {
        C11301() {
        }

        public final Extractor[] mo1342a() {
            return new Extractor[]{new Mp3Extractor()};
        }
    }

    interface Seeker extends SeekMap {
        long mo3349a(long j);
    }

    private static boolean m12073a(int i, long j) {
        return ((long) (i & -128000)) == (j & -128000);
    }

    public Mp3Extractor() {
        this(0);
    }

    public Mp3Extractor(int i) {
        this(i, -9223372036854775807L);
    }

    public Mp3Extractor(int i, long j) {
        this.f12929e = i;
        this.f12930f = j;
        this.f12931g = new ParsableByteArray((int) 10);
        this.f12932h = new MpegAudioHeader();
        this.f12933i = new GaplessInfoHolder();
        this.f12939o = 1;
    }

    public final boolean mo1353a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return m12074a(extractorInput, true);
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        this.f12934j = extractorOutput;
        this.f12935k = this.f12934j.mo1415a(0, 1);
        this.f12934j.mo1416a();
    }

    public final void mo1351a(long j, long j2) {
        this.f12936l = 0;
        this.f12939o = -9223372036854775807L;
        this.f12940p = 0;
        this.f12941q = 0;
    }

    public final int mo1350a(com.google.android.exoplayer2.extractor.ExtractorInput r29, com.google.android.exoplayer2.extractor.PositionHolder r30) throws java.io.IOException, java.lang.InterruptedException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r28 = this;
        r0 = r28;
        r1 = r29;
        r2 = r0.f12936l;
        r3 = -1;
        r4 = 0;
        if (r2 != 0) goto L_0x000f;
    L_0x000a:
        r0.m12074a(r1, r4);	 Catch:{ EOFException -> 0x000e }
        goto L_0x000f;
    L_0x000e:
        return r3;
    L_0x000f:
        r2 = r0.f12938n;
        r5 = 1;
        if (r2 != 0) goto L_0x0154;
    L_0x0014:
        r7 = new com.google.android.exoplayer2.util.ParsableByteArray;
        r2 = r0.f12932h;
        r2 = r2.f4263c;
        r7.<init>(r2);
        r2 = r7.f5256a;
        r6 = r0.f12932h;
        r6 = r6.f4263c;
        r1.mo1340c(r2, r4, r6);
        r2 = r0.f12932h;
        r2 = r2.f4261a;
        r2 = r2 & r5;
        r6 = 21;
        r8 = 36;
        if (r2 == 0) goto L_0x003b;
    L_0x0031:
        r2 = r0.f12932h;
        r2 = r2.f4265e;
        if (r2 == r5) goto L_0x0039;
    L_0x0037:
        r2 = r8;
        goto L_0x0045;
    L_0x0039:
        r2 = r6;
        goto L_0x0045;
    L_0x003b:
        r2 = r0.f12932h;
        r2 = r2.f4265e;
        if (r2 == r5) goto L_0x0042;
    L_0x0041:
        goto L_0x0039;
    L_0x0042:
        r6 = 13;
        goto L_0x0039;
    L_0x0045:
        r6 = r7.f5258c;
        r9 = r2 + 4;
        if (r6 < r9) goto L_0x005c;
    L_0x004b:
        r7.m4249c(r2);
        r6 = r7.m4259j();
        r9 = f12926b;
        if (r6 == r9) goto L_0x005a;
    L_0x0056:
        r9 = f12927c;
        if (r6 != r9) goto L_0x005c;
    L_0x005a:
        r12 = r6;
        goto L_0x0071;
    L_0x005c:
        r6 = r7.f5258c;
        r9 = 40;
        if (r6 < r9) goto L_0x0070;
    L_0x0062:
        r7.m4249c(r8);
        r6 = r7.m4259j();
        r8 = f12928d;
        if (r6 != r8) goto L_0x0070;
    L_0x006d:
        r6 = f12928d;
        goto L_0x005a;
    L_0x0070:
        r12 = r4;
    L_0x0071:
        r6 = f12926b;
        r13 = 0;
        if (r12 == r6) goto L_0x009a;
    L_0x0076:
        r6 = f12927c;
        if (r12 != r6) goto L_0x007b;
    L_0x007a:
        goto L_0x009a;
    L_0x007b:
        r2 = f12928d;
        if (r12 != r2) goto L_0x0095;
    L_0x007f:
        r6 = r0.f12932h;
        r8 = r29.mo1338c();
        r10 = r29.mo1341d();
        r2 = com.google.android.exoplayer2.extractor.mp3.VbriSeeker.m17180a(r6, r7, r8, r10);
        r6 = r0.f12932h;
        r6 = r6.f4263c;
        r1.mo1335b(r6);
        goto L_0x00f4;
    L_0x0095:
        r29.mo1332a();
        r2 = r13;
        goto L_0x00f4;
    L_0x009a:
        r6 = r0.f12932h;
        r8 = r29.mo1338c();
        r10 = r29.mo1341d();
        r6 = com.google.android.exoplayer2.extractor.mp3.XingSeeker.m17185a(r6, r7, r8, r10);
        if (r6 == 0) goto L_0x00db;
    L_0x00aa:
        r7 = r0.f12933i;
        r7 = r7.m3752a();
        if (r7 != 0) goto L_0x00db;
    L_0x00b2:
        r29.mo1332a();
        r2 = r2 + 141;
        r1.mo1339c(r2);
        r2 = r0.f12931g;
        r2 = r2.f5256a;
        r7 = 3;
        r1.mo1340c(r2, r4, r7);
        r2 = r0.f12931g;
        r2.m4249c(r4);
        r2 = r0.f12933i;
        r7 = r0.f12931g;
        r7 = r7.m4256g();
        r8 = r7 >> 12;
        r7 = r7 & 4095;
        if (r8 > 0) goto L_0x00d7;
    L_0x00d5:
        if (r7 <= 0) goto L_0x00db;
    L_0x00d7:
        r2.f4252b = r8;
        r2.f4253c = r7;
    L_0x00db:
        r2 = r0.f12932h;
        r2 = r2.f4263c;
        r1.mo1335b(r2);
        if (r6 == 0) goto L_0x00f3;
    L_0x00e4:
        r2 = r6.a_();
        if (r2 != 0) goto L_0x00f3;
    L_0x00ea:
        r2 = f12927c;
        if (r12 != r2) goto L_0x00f3;
    L_0x00ee:
        r2 = r28.m12075b(r29);
        goto L_0x00f4;
    L_0x00f3:
        r2 = r6;
    L_0x00f4:
        r0.f12938n = r2;
        r2 = r0.f12938n;
        if (r2 == 0) goto L_0x0107;
    L_0x00fa:
        r2 = r0.f12938n;
        r2 = r2.a_();
        if (r2 != 0) goto L_0x010d;
    L_0x0102:
        r2 = r0.f12929e;
        r2 = r2 & r5;
        if (r2 == 0) goto L_0x010d;
    L_0x0107:
        r2 = r28.m12075b(r29);
        r0.f12938n = r2;
    L_0x010d:
        r2 = r0.f12934j;
        r6 = r0.f12938n;
        r2.mo1417a(r6);
        r2 = r0.f12935k;
        r14 = 0;
        r6 = r0.f12932h;
        r15 = r6.f4262b;
        r16 = -1;
        r17 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r6 = r0.f12932h;
        r6 = r6.f4265e;
        r7 = r0.f12932h;
        r7 = r7.f4264d;
        r20 = -1;
        r8 = r0.f12933i;
        r8 = r8.f4252b;
        r9 = r0.f12933i;
        r9 = r9.f4253c;
        r23 = 0;
        r24 = 0;
        r25 = 0;
        r26 = 0;
        r10 = r0.f12929e;
        r10 = r10 & 2;
        if (r10 == 0) goto L_0x0142;
    L_0x013f:
        r27 = r13;
        goto L_0x0145;
    L_0x0142:
        r13 = r0.f12937m;
        goto L_0x013f;
    L_0x0145:
        r18 = r6;
        r19 = r7;
        r21 = r8;
        r22 = r9;
        r6 = com.google.android.exoplayer2.Format.m3556a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
        r2.mo1345a(r6);
    L_0x0154:
        r2 = r0.f12941q;
        if (r2 != 0) goto L_0x01c1;
    L_0x0158:
        r29.mo1332a();
        r2 = r0.f12931g;
        r2 = r2.f5256a;
        r6 = 4;
        r2 = r1.mo1337b(r2, r4, r6, r5);
        if (r2 != 0) goto L_0x0167;
    L_0x0166:
        return r3;
    L_0x0167:
        r2 = r0.f12931g;
        r2.m4249c(r4);
        r2 = r0.f12931g;
        r2 = r2.m4259j();
        r6 = r0.f12936l;
        r6 = (long) r6;
        r6 = m12073a(r2, r6);
        if (r6 == 0) goto L_0x01bb;
    L_0x017b:
        r6 = com.google.android.exoplayer2.extractor.MpegAudioHeader.m3754a(r2);
        if (r6 != r3) goto L_0x0182;
    L_0x0181:
        goto L_0x01bb;
    L_0x0182:
        r6 = r0.f12932h;
        com.google.android.exoplayer2.extractor.MpegAudioHeader.m3755a(r2, r6);
        r6 = r0.f12939o;
        r8 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 != 0) goto L_0x01b4;
    L_0x0192:
        r2 = r0.f12938n;
        r6 = r29.mo1338c();
        r6 = r2.mo3349a(r6);
        r0.f12939o = r6;
        r6 = r0.f12930f;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 == 0) goto L_0x01b4;
    L_0x01a4:
        r2 = r0.f12938n;
        r6 = 0;
        r6 = r2.mo3349a(r6);
        r8 = r0.f12939o;
        r10 = r0.f12930f;
        r10 = r10 - r6;
        r8 = r8 + r10;
        r0.f12939o = r8;
    L_0x01b4:
        r2 = r0.f12932h;
        r2 = r2.f4263c;
        r0.f12941q = r2;
        goto L_0x01c1;
    L_0x01bb:
        r1.mo1335b(r5);
        r0.f12936l = r4;
        return r4;
    L_0x01c1:
        r2 = r0.f12935k;
        r6 = r0.f12941q;
        r1 = r2.mo1343a(r1, r6, r5);
        if (r1 != r3) goto L_0x01cc;
    L_0x01cb:
        return r3;
    L_0x01cc:
        r2 = r0.f12941q;
        r2 = r2 - r1;
        r0.f12941q = r2;
        r1 = r0.f12941q;
        if (r1 <= 0) goto L_0x01d6;
    L_0x01d5:
        return r4;
    L_0x01d6:
        r1 = r0.f12939o;
        r5 = r0.f12940p;
        r7 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r5 = r5 * r7;
        r3 = r0.f12932h;
        r3 = r3.f4264d;
        r7 = (long) r3;
        r5 = r5 / r7;
        r8 = r1 + r5;
        r7 = r0.f12935k;
        r10 = 1;
        r1 = r0.f12932h;
        r11 = r1.f4263c;
        r12 = 0;
        r13 = 0;
        r7.mo1344a(r8, r10, r11, r12, r13);
        r1 = r0.f12940p;
        r3 = r0.f12932h;
        r3 = r3.f4267g;
        r5 = (long) r3;
        r1 = r1 + r5;
        r0.f12940p = r1;
        r0.f12941q = r4;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.a(com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.extractor.PositionHolder):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m12074a(com.google.android.exoplayer2.extractor.ExtractorInput r13, boolean r14) throws java.io.IOException, java.lang.InterruptedException {
        /*
        r12 = this;
        if (r14 == 0) goto L_0x0005;
    L_0x0002:
        r0 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        goto L_0x0007;
    L_0x0005:
        r0 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
    L_0x0007:
        r13.mo1332a();
        r1 = r13.mo1338c();
        r3 = 0;
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        r2 = 0;
        if (r1 != 0) goto L_0x0087;
    L_0x0015:
        r1 = r2;
    L_0x0016:
        r3 = r12.f12931g;
        r3 = r3.f5256a;
        r4 = 10;
        r13.mo1340c(r3, r2, r4);
        r3 = r12.f12931g;
        r3.m4249c(r2);
        r3 = r12.f12931g;
        r3 = r3.m4256g();
        r5 = com.google.android.exoplayer2.metadata.id3.Id3Decoder.f13228a;
        if (r3 != r5) goto L_0x0072;
    L_0x002e:
        r3 = r12.f12931g;
        r5 = 3;
        r3.m4251d(r5);
        r3 = r12.f12931g;
        r3 = r3.m4262m();
        r5 = r4 + r3;
        r6 = r12.f12937m;
        if (r6 != 0) goto L_0x006d;
    L_0x0040:
        r6 = new byte[r5];
        r7 = r12.f12931g;
        r7 = r7.f5256a;
        java.lang.System.arraycopy(r7, r2, r6, r2, r4);
        r13.mo1340c(r6, r4, r3);
        r3 = r12.f12929e;
        r3 = r3 & 2;
        if (r3 == 0) goto L_0x0055;
    L_0x0052:
        r3 = com.google.android.exoplayer2.extractor.GaplessInfoHolder.f4250a;
        goto L_0x0056;
    L_0x0055:
        r3 = 0;
    L_0x0056:
        r4 = new com.google.android.exoplayer2.metadata.id3.Id3Decoder;
        r4.<init>(r3);
        r3 = r4.m12295a(r6, r5);
        r12.f12937m = r3;
        r3 = r12.f12937m;
        if (r3 == 0) goto L_0x0070;
    L_0x0065:
        r3 = r12.f12933i;
        r4 = r12.f12937m;
        r3.m3753a(r4);
        goto L_0x0070;
    L_0x006d:
        r13.mo1339c(r3);
    L_0x0070:
        r1 = r1 + r5;
        goto L_0x0016;
    L_0x0072:
        r13.mo1332a();
        r13.mo1339c(r1);
        r3 = r13.mo1334b();
        r1 = (int) r3;
        if (r14 != 0) goto L_0x0082;
    L_0x007f:
        r13.mo1335b(r1);
    L_0x0082:
        r5 = r1;
        r1 = r2;
        r3 = r1;
        r4 = r3;
        goto L_0x008b;
    L_0x0087:
        r1 = r2;
        r3 = r1;
        r4 = r3;
        r5 = r4;
    L_0x008b:
        r6 = r12.f12931g;
        r6 = r6.f5256a;
        r7 = 1;
        if (r1 <= 0) goto L_0x0094;
    L_0x0092:
        r8 = r7;
        goto L_0x0095;
    L_0x0094:
        r8 = r2;
    L_0x0095:
        r9 = 4;
        r6 = r13.mo1337b(r6, r2, r9, r8);
        if (r6 == 0) goto L_0x00eb;
    L_0x009c:
        r6 = r12.f12931g;
        r6.m4249c(r2);
        r6 = r12.f12931g;
        r6 = r6.m4259j();
        if (r3 == 0) goto L_0x00b0;
    L_0x00a9:
        r10 = (long) r3;
        r8 = m12073a(r6, r10);
        if (r8 == 0) goto L_0x00b7;
    L_0x00b0:
        r8 = com.google.android.exoplayer2.extractor.MpegAudioHeader.m3754a(r6);
        r10 = -1;
        if (r8 != r10) goto L_0x00d8;
    L_0x00b7:
        r1 = r4 + 1;
        if (r4 != r0) goto L_0x00c6;
    L_0x00bb:
        if (r14 != 0) goto L_0x00c5;
    L_0x00bd:
        r13 = new com.google.android.exoplayer2.ParserException;
        r14 = "Searched too many bytes.";
        r13.<init>(r14);
        throw r13;
    L_0x00c5:
        return r2;
    L_0x00c6:
        if (r14 == 0) goto L_0x00d1;
    L_0x00c8:
        r13.mo1332a();
        r3 = r5 + r1;
        r13.mo1339c(r3);
        goto L_0x00d4;
    L_0x00d1:
        r13.mo1335b(r7);
    L_0x00d4:
        r4 = r1;
        r1 = r2;
        r3 = r1;
        goto L_0x008b;
    L_0x00d8:
        r1 = r1 + 1;
        if (r1 != r7) goto L_0x00e3;
    L_0x00dc:
        r3 = r12.f12932h;
        com.google.android.exoplayer2.extractor.MpegAudioHeader.m3755a(r6, r3);
        r3 = r6;
        goto L_0x00e5;
    L_0x00e3:
        if (r1 == r9) goto L_0x00eb;
    L_0x00e5:
        r8 = r8 + -4;
        r13.mo1339c(r8);
        goto L_0x008b;
    L_0x00eb:
        if (r14 == 0) goto L_0x00f2;
    L_0x00ed:
        r5 = r5 + r4;
        r13.mo1335b(r5);
        goto L_0x00f5;
    L_0x00f2:
        r13.mo1332a();
    L_0x00f5:
        r12.f12936l = r3;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.a(com.google.android.exoplayer2.extractor.ExtractorInput, boolean):boolean");
    }

    private Seeker m12075b(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.mo1340c(this.f12931g.f5256a, 0, 4);
        this.f12931g.m4249c(0);
        MpegAudioHeader.m3755a(this.f12931g.m4259j(), this.f12932h);
        return new ConstantBitrateSeeker(extractorInput.mo1338c(), this.f12932h.f4266f, extractorInput.mo1341d());
    }
}

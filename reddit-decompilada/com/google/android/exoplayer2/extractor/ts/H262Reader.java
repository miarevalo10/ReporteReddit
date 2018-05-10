package com.google.android.exoplayer2.extractor.ts;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;
import org.jcodec.codecs.mpeg12.MPEGConst;

public final class H262Reader implements ElementaryStreamReader {
    private static final double[] f13103c = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String f13104a;
    private TrackOutput f13105b;
    private boolean f13106d;
    private long f13107e;
    private final boolean[] f13108f = new boolean[4];
    private final CsdBuffer f13109g = new CsdBuffer();
    private long f13110h;
    private boolean f13111i;
    private long f13112j;
    private long f13113k;
    private long f13114l;
    private boolean f13115m;
    private boolean f13116n;

    private static final class CsdBuffer {
        static final byte[] f4557a = new byte[]{(byte) 0, (byte) 0, (byte) 1};
        boolean f4558b;
        public int f4559c;
        public int f4560d;
        public byte[] f4561e = new byte[128];

        public final void m3858a(byte[] bArr, int i, int i2) {
            if (this.f4558b) {
                i2 -= i;
                if (this.f4561e.length < this.f4559c + i2) {
                    this.f4561e = Arrays.copyOf(this.f4561e, (this.f4559c + i2) * 2);
                }
                System.arraycopy(bArr, i, this.f4561e, this.f4559c, i2);
                this.f4559c += i2;
            }
        }
    }

    public final void mo1380b() {
    }

    public final void mo1376a() {
        NalUnitUtil.m4225a(this.f13108f);
        CsdBuffer csdBuffer = this.f13109g;
        csdBuffer.f4558b = false;
        csdBuffer.f4559c = 0;
        csdBuffer.f4560d = 0;
        this.f13110h = 0;
        this.f13111i = false;
    }

    public final void mo1378a(ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.m3876a();
        this.f13104a = trackIdGenerator.m3878c();
        this.f13105b = extractorOutput.mo1415a(trackIdGenerator.m3877b(), 2);
    }

    public final void mo1377a(long j, boolean z) {
        this.f13112j = j;
    }

    public final void mo1379a(ParsableByteArray parsableByteArray) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i = parsableByteArray2.f5257b;
        int i2 = parsableByteArray2.f5258c;
        byte[] bArr = parsableByteArray2.f5256a;
        this.f13110h += (long) parsableByteArray.m4246b();
        this.f13105b.mo1346a(parsableByteArray2, parsableByteArray.m4246b());
        while (true) {
            int a = NalUnitUtil.m4222a(bArr, i, i2, r0.f13108f);
            if (a != i2) {
                long j;
                boolean z;
                int i3 = a + 3;
                int i4 = parsableByteArray2.f5256a[i3] & 255;
                boolean z2 = true;
                if (!r0.f13106d) {
                    boolean z3;
                    CsdBuffer csdBuffer;
                    String str;
                    Object copyOf;
                    int i5;
                    int i6;
                    int i7;
                    float f;
                    Format a2;
                    int i8;
                    Pair create;
                    int i9 = a - i;
                    if (i9 > 0) {
                        r0.f13109g.m3858a(bArr, i, a);
                    }
                    i = i9 < 0 ? -i9 : 0;
                    CsdBuffer csdBuffer2 = r0.f13109g;
                    if (csdBuffer2.f4558b) {
                        csdBuffer2.f4559c -= i;
                        if (csdBuffer2.f4560d == 0 && i4 == MPEGConst.EXTENSION_START_CODE) {
                            csdBuffer2.f4560d = csdBuffer2.f4559c;
                        } else {
                            csdBuffer2.f4558b = false;
                            z3 = true;
                            if (z3) {
                                csdBuffer = r0.f13109g;
                                str = r0.f13104a;
                                copyOf = Arrays.copyOf(csdBuffer.f4561e, csdBuffer.f4559c);
                                i5 = copyOf[5] & 255;
                                i6 = ((copyOf[4] & 255) << 4) | (i5 >> 4);
                                i7 = ((i5 & 15) << 8) | (copyOf[6] & 255);
                                f = 1.0f;
                                switch ((copyOf[7] & 240) >> 4) {
                                    case 2:
                                        f = ((float) (4 * i7)) / ((float) (3 * i6));
                                        break;
                                    case 3:
                                        f = ((float) (16 * i7)) / ((float) (9 * i6));
                                        break;
                                    case 4:
                                        f = ((float) (121 * i7)) / ((float) (100 * i6));
                                        break;
                                }
                                a2 = Format.m3560a(str, "video/mpeg2", i6, i7, Collections.singletonList(copyOf), f);
                                i8 = (copyOf[7] & 15) - 1;
                                if (i8 >= 0 || i8 >= f13103c.length) {
                                    j = 0;
                                } else {
                                    double d = f13103c[i8];
                                    i = csdBuffer.f4560d + 9;
                                    int i10 = (copyOf[i] & 96) >> 5;
                                    i = copyOf[i] & 31;
                                    if (i10 != i) {
                                        d *= (((double) i10) + 1.0d) / ((double) (i + 1));
                                    }
                                    j = (long) (1000000.0d / d);
                                }
                                create = Pair.create(a2, Long.valueOf(j));
                                r0.f13105b.mo1345a((Format) create.first);
                                r0.f13107e = ((Long) create.second).longValue();
                                r0.f13106d = true;
                            }
                        }
                    } else if (i4 == MPEGConst.SEQUENCE_HEADER_CODE) {
                        csdBuffer2.f4558b = true;
                    }
                    csdBuffer2.m3858a(CsdBuffer.f4557a, 0, CsdBuffer.f4557a.length);
                    z3 = false;
                    if (z3) {
                        csdBuffer = r0.f13109g;
                        str = r0.f13104a;
                        copyOf = Arrays.copyOf(csdBuffer.f4561e, csdBuffer.f4559c);
                        i5 = copyOf[5] & 255;
                        i6 = ((copyOf[4] & 255) << 4) | (i5 >> 4);
                        i7 = ((i5 & 15) << 8) | (copyOf[6] & 255);
                        f = 1.0f;
                        switch ((copyOf[7] & 240) >> 4) {
                            case 2:
                                f = ((float) (4 * i7)) / ((float) (3 * i6));
                                break;
                            case 3:
                                f = ((float) (16 * i7)) / ((float) (9 * i6));
                                break;
                            case 4:
                                f = ((float) (121 * i7)) / ((float) (100 * i6));
                                break;
                        }
                        a2 = Format.m3560a(str, "video/mpeg2", i6, i7, Collections.singletonList(copyOf), f);
                        i8 = (copyOf[7] & 15) - 1;
                        if (i8 >= 0) {
                        }
                        j = 0;
                        create = Pair.create(a2, Long.valueOf(j));
                        r0.f13105b.mo1345a((Format) create.first);
                        r0.f13107e = ((Long) create.second).longValue();
                        r0.f13106d = true;
                    }
                }
                if (i4 != 0) {
                    if (i4 != MPEGConst.SEQUENCE_HEADER_CODE) {
                        if (i4 == MPEGConst.GROUP_START_CODE) {
                            r0.f13115m = true;
                        }
                        i = i3;
                        parsableByteArray2 = parsableByteArray;
                    }
                }
                int i11 = i2 - a;
                if (r0.f13111i && r0.f13116n && r0.f13106d) {
                    r0.f13105b.mo1344a(r0.f13114l, r0.f13115m, ((int) (r0.f13110h - r0.f13113k)) - i11, i11, null);
                }
                if (r0.f13111i) {
                    if (!r0.f13116n) {
                        z = false;
                        if (i4 == 0) {
                            z2 = z;
                        }
                        r0.f13116n = z2;
                        i = i3;
                        parsableByteArray2 = parsableByteArray;
                    }
                }
                r0.f13113k = r0.f13110h - ((long) i11);
                j = r0.f13112j != -9223372036854775807L ? r0.f13112j : r0.f13111i ? r0.f13114l + r0.f13107e : 0;
                r0.f13114l = j;
                z = false;
                r0.f13115m = false;
                r0.f13112j = -9223372036854775807L;
                r0.f13111i = true;
                if (i4 == 0) {
                    z2 = z;
                }
                r0.f13116n = z2;
                i = i3;
                parsableByteArray2 = parsableByteArray;
            } else if (!r0.f13106d) {
                r0.f13109g.m3858a(bArr, i, i2);
                return;
            } else {
                return;
            }
        }
    }
}

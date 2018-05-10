package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class PesReader implements TsPayloadReader {
    private final ElementaryStreamReader f13163a;
    private final ParsableBitArray f13164b = new ParsableBitArray(new byte[10]);
    private int f13165c = null;
    private int f13166d;
    private TimestampAdjuster f13167e;
    private boolean f13168f;
    private boolean f13169g;
    private boolean f13170h;
    private int f13171i;
    private int f13172j;
    private boolean f13173k;
    private long f13174l;

    public PesReader(ElementaryStreamReader elementaryStreamReader) {
        this.f13163a = elementaryStreamReader;
    }

    public final void mo1385a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        this.f13167e = timestampAdjuster;
        this.f13163a.mo1378a(extractorOutput, trackIdGenerator);
    }

    public final void mo1383a() {
        this.f13165c = 0;
        this.f13166d = 0;
        this.f13170h = false;
        this.f13163a.mo1376a();
    }

    public final void mo1384a(ParsableByteArray parsableByteArray, boolean z) {
        if (z) {
            switch (this.f13165c) {
                case false:
                case true:
                    break;
                case true:
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                    break;
                case true:
                    if (!this.f13172j) {
                        StringBuilder stringBuilder = new StringBuilder("Unexpected start indicator: expected ");
                        stringBuilder.append(this.f13172j);
                        stringBuilder.append(" more bytes");
                        Log.w("PesReader", stringBuilder.toString());
                    }
                    this.f13163a.mo1380b();
                    break;
                default:
                    break;
            }
            m12221a(1);
        }
        while (parsableByteArray.m4246b() <= false) {
            int i = 0;
            switch (this.f13165c) {
                case false:
                    parsableByteArray.m4251d(parsableByteArray.m4246b());
                    break;
                case true:
                    if (!m12222a(parsableByteArray, this.f13164b.f5252a, 9)) {
                        break;
                    }
                    this.f13164b.m4231a(0);
                    z = this.f13164b.m4236c(24);
                    if (!z) {
                        StringBuilder stringBuilder2 = new StringBuilder("Unexpected start code prefix: ");
                        stringBuilder2.append(z);
                        Log.w("PesReader", stringBuilder2.toString());
                        this.f13172j = -1;
                        z = false;
                    } else {
                        this.f13164b.m4234b(8);
                        z = this.f13164b.m4236c(16);
                        this.f13164b.m4234b(5);
                        this.f13173k = this.f13164b.m4237c();
                        this.f13164b.m4234b(2);
                        this.f13168f = this.f13164b.m4237c();
                        this.f13169g = this.f13164b.m4237c();
                        this.f13164b.m4234b(6);
                        this.f13171i = this.f13164b.m4236c(8);
                        if (z) {
                            this.f13172j = ((z + 6) - true) - this.f13171i;
                        } else {
                            this.f13172j = -1;
                        }
                        z = true;
                    }
                    if (z) {
                        i = 2;
                    }
                    m12221a(i);
                    break;
                case true:
                    if (m12222a(parsableByteArray, this.f13164b.f5252a, Math.min(true, this.f13171i)) && m12222a(parsableByteArray, (byte[]) false, this.f13171i)) {
                        this.f13164b.m4231a(0);
                        this.f13174l = -9223372036854775807L;
                        if (this.f13168f) {
                            this.f13164b.m4234b(4);
                            long c = ((long) this.f13164b.m4236c(3)) << 30;
                            this.f13164b.m4234b(1);
                            c |= (long) (this.f13164b.m4236c(15) << 15);
                            this.f13164b.m4234b(1);
                            c |= (long) this.f13164b.m4236c(15);
                            this.f13164b.m4234b(1);
                            if (!this.f13170h && this.f13169g) {
                                this.f13164b.m4234b(4);
                                long c2 = ((long) this.f13164b.m4236c(3)) << 30;
                                this.f13164b.m4234b(1);
                                c2 |= (long) (this.f13164b.m4236c(15) << true);
                                this.f13164b.m4234b(1);
                                long c3 = ((long) this.f13164b.m4236c(15)) | c2;
                                this.f13164b.m4234b(1);
                                this.f13167e.m4286b(c3);
                                this.f13170h = true;
                            }
                            this.f13174l = this.f13167e.m4286b(c);
                        }
                        this.f13163a.mo1377a(this.f13174l, this.f13173k);
                        m12221a(3);
                        break;
                    }
                case true:
                    z = parsableByteArray.m4246b();
                    if (this.f13172j != -1) {
                        i = z - this.f13172j;
                    }
                    if (i > 0) {
                        z -= i;
                        parsableByteArray.m4247b(parsableByteArray.f5257b + z);
                    }
                    this.f13163a.mo1379a(parsableByteArray);
                    if (this.f13172j == -1) {
                        break;
                    }
                    this.f13172j -= z;
                    if (!this.f13172j) {
                        this.f13163a.mo1380b();
                        m12221a(1);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void m12221a(int i) {
        this.f13165c = i;
        this.f13166d = 0;
    }

    private boolean m12222a(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = Math.min(parsableByteArray.m4246b(), i - this.f13166d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.m4251d(min);
        } else {
            parsableByteArray.m4245a(bArr, this.f13166d, min);
        }
        this.f13166d += min;
        if (this.f13166d == i) {
            return true;
        }
        return null;
    }
}

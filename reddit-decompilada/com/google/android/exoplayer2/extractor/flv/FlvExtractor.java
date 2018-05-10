package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class FlvExtractor implements Extractor, SeekMap {
    public static final ExtractorsFactory f12844a = new C11281();
    private static final int f12845e = Util.m4326g("FLV");
    public int f12846b;
    public int f12847c;
    public long f12848d;
    private final ParsableByteArray f12849f = new ParsableByteArray(4);
    private final ParsableByteArray f12850g = new ParsableByteArray(9);
    private final ParsableByteArray f12851h = new ParsableByteArray(11);
    private final ParsableByteArray f12852i = new ParsableByteArray();
    private ExtractorOutput f12853j;
    private int f12854k = 1;
    private int f12855l;
    private AudioTagPayloadReader f12856m;
    private VideoTagPayloadReader f12857n;
    private ScriptTagPayloadReader f12858o;

    static class C11281 implements ExtractorsFactory {
        C11281() {
        }

        public final Extractor[] mo1342a() {
            return new Extractor[]{new FlvExtractor()};
        }
    }

    public final boolean a_() {
        return false;
    }

    public final long mo1329b(long j) {
        return 0;
    }

    public final boolean mo1353a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.mo1340c(this.f12849f.f5256a, 0, 3);
        this.f12849f.m4249c(0);
        if (this.f12849f.m4256g() != f12845e) {
            return false;
        }
        extractorInput.mo1340c(this.f12849f.f5256a, 0, 2);
        this.f12849f.m4249c(0);
        if ((this.f12849f.m4252e() & 250) != 0) {
            return false;
        }
        extractorInput.mo1340c(this.f12849f.f5256a, 0, 4);
        this.f12849f.m4249c(0);
        int j = this.f12849f.m4259j();
        extractorInput.mo1332a();
        extractorInput.mo1339c(j);
        extractorInput.mo1340c(this.f12849f.f5256a, 0, 4);
        this.f12849f.m4249c(0);
        if (this.f12849f.m4259j() == null) {
            return true;
        }
        return false;
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        this.f12853j = extractorOutput;
    }

    public final void mo1351a(long j, long j2) {
        this.f12854k = 1;
        this.f12855l = 0;
    }

    public final int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        while (true) {
            boolean z = true;
            int i = 0;
            switch (this.f12854k) {
                case 1:
                    if (extractorInput.mo1333a(this.f12850g.f5256a, 0, 9, true) == null) {
                        z = false;
                    } else {
                        this.f12850g.m4249c(0);
                        this.f12850g.m4251d(4);
                        positionHolder = this.f12850g.m4250d();
                        boolean z2 = (positionHolder & 4) != 0;
                        if ((positionHolder & 1) != null) {
                            i = 1;
                        }
                        if (z2 && this.f12856m == null) {
                            this.f12856m = new AudioTagPayloadReader(this.f12853j.mo1415a(8, 1));
                        }
                        if (i != 0 && this.f12857n == null) {
                            this.f12857n = new VideoTagPayloadReader(this.f12853j.mo1415a(9, 2));
                        }
                        if (this.f12858o == null) {
                            this.f12858o = new ScriptTagPayloadReader();
                        }
                        this.f12853j.mo1416a();
                        this.f12853j.mo1417a(this);
                        this.f12855l = (this.f12850g.m4259j() - 9) + 4;
                        this.f12854k = 2;
                    }
                    if (z) {
                        break;
                    }
                    return -1;
                case 2:
                    extractorInput.mo1335b(this.f12855l);
                    this.f12855l = 0;
                    this.f12854k = 3;
                    break;
                case 3:
                    if (extractorInput.mo1333a(this.f12851h.f5256a, 0, 11, true) == null) {
                        z = false;
                    } else {
                        this.f12851h.m4249c(0);
                        this.f12846b = this.f12851h.m4250d();
                        this.f12847c = this.f12851h.m4256g();
                        this.f12848d = (long) this.f12851h.m4256g();
                        this.f12848d = (((long) (this.f12851h.m4250d() << 24)) | this.f12848d) * 1000;
                        this.f12851h.m4251d(3);
                        this.f12854k = 4;
                    }
                    if (z) {
                        break;
                    }
                    return -1;
                case 4:
                    if (this.f12846b == 8 && this.f12856m != null) {
                        this.f12856m.m3764b(m12026b(extractorInput), this.f12848d);
                    } else if (this.f12846b == 9 && this.f12857n != null) {
                        this.f12857n.m3764b(m12026b(extractorInput), this.f12848d);
                    } else if (this.f12846b != 18 || this.f12858o == null) {
                        extractorInput.mo1335b(this.f12847c);
                        z = false;
                    } else {
                        this.f12858o.m3764b(m12026b(extractorInput), this.f12848d);
                    }
                    this.f12855l = 4;
                    this.f12854k = 2;
                    if (!z) {
                        break;
                    }
                    return 0;
                default:
                    break;
            }
        }
    }

    private ParsableByteArray m12026b(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (this.f12847c > this.f12852i.m4248c()) {
            this.f12852i.m4244a(new byte[Math.max(this.f12852i.m4248c() * 2, this.f12847c)], 0);
        } else {
            this.f12852i.m4249c(0);
        }
        this.f12852i.m4247b(this.f12847c);
        extractorInput.mo1336b(this.f12852i.f5256a, 0, this.f12847c);
        return this.f12852i;
    }

    public final long mo1328b() {
        return this.f12858o.f12859a;
    }
}

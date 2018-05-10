package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class Ac3Extractor implements Extractor {
    public static final ExtractorsFactory f13042a = new C11341();
    private static final int f13043b = Util.m4326g("ID3");
    private final long f13044c;
    private final Ac3Reader f13045d;
    private final ParsableByteArray f13046e;
    private boolean f13047f;

    static class C11341 implements ExtractorsFactory {
        C11341() {
        }

        public final Extractor[] mo1342a() {
            return new Extractor[]{new Ac3Extractor()};
        }
    }

    public Ac3Extractor() {
        this(0);
    }

    public Ac3Extractor(long j) {
        this.f13044c = j;
        this.f13045d = new Ac3Reader();
        this.f13046e = new ParsableByteArray(2786);
    }

    public final boolean mo1353a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int m;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i = 0;
        while (true) {
            extractorInput.mo1340c(parsableByteArray.f5256a, 0, 10);
            parsableByteArray.m4249c(0);
            if (parsableByteArray.m4256g() != f13043b) {
                break;
            }
            parsableByteArray.m4251d(3);
            m = parsableByteArray.m4262m();
            i += 10 + m;
            extractorInput.mo1339c(m);
        }
        extractorInput.mo1332a();
        extractorInput.mo1339c(i);
        m = 0;
        int i2 = i;
        while (true) {
            extractorInput.mo1340c(parsableByteArray.f5256a, 0, 5);
            parsableByteArray.m4249c(0);
            if (parsableByteArray.m4252e() != 2935) {
                extractorInput.mo1332a();
                i2++;
                if (i2 - i >= 8192) {
                    return false;
                }
                extractorInput.mo1339c(i2);
                m = 0;
            } else {
                m++;
                if (m >= 4) {
                    return true;
                }
                int a = Ac3Util.m3642a(parsableByteArray.f5256a);
                if (a == -1) {
                    return false;
                }
                extractorInput.mo1339c(a - 5);
            }
        }
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        this.f13045d.mo1378a(extractorOutput, new TrackIdGenerator(0, 1));
        extractorOutput.mo1416a();
        extractorOutput.mo1417a(new Unseekable(-9223372036854775807L));
    }

    public final void mo1351a(long j, long j2) {
        this.f13047f = 0;
        this.f13045d.mo1376a();
    }

    public final int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        extractorInput = extractorInput.mo1331a(this.f13046e.f5256a, 0, 2786);
        if (extractorInput == -1) {
            return -1;
        }
        this.f13046e.m4249c(0);
        this.f13046e.m4247b(extractorInput);
        if (this.f13047f == null) {
            this.f13045d.f13048a = this.f13044c;
            this.f13047f = true;
        }
        this.f13045d.mo1379a(this.f13046e);
        return 0;
    }
}

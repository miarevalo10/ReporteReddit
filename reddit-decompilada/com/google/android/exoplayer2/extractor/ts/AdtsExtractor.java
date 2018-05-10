package com.google.android.exoplayer2.extractor.ts;

import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class AdtsExtractor implements Extractor {
    public static final ExtractorsFactory f13060a = new C11351();
    private static final int f13061b = Util.m4326g("ID3");
    private final long f13062c;
    private final AdtsReader f13063d;
    private final ParsableByteArray f13064e;
    private boolean f13065f;

    static class C11351 implements ExtractorsFactory {
        C11351() {
        }

        public final Extractor[] mo1342a() {
            return new Extractor[]{new AdtsExtractor()};
        }
    }

    public AdtsExtractor() {
        this(0);
    }

    public AdtsExtractor(long j) {
        this.f13062c = j;
        this.f13063d = new AdtsReader();
        this.f13064e = new ParsableByteArray((int) HttpStatus.HTTP_OK);
    }

    public final boolean mo1353a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int m;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.f5256a);
        int i = 0;
        while (true) {
            extractorInput.mo1340c(parsableByteArray.f5256a, 0, 10);
            parsableByteArray.m4249c(0);
            if (parsableByteArray.m4256g() != f13061b) {
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
        int i2 = m;
        int i3 = i;
        while (true) {
            extractorInput.mo1340c(parsableByteArray.f5256a, 0, 2);
            parsableByteArray.m4249c(0);
            if ((parsableByteArray.m4252e() & 65526) != 65520) {
                extractorInput.mo1332a();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                extractorInput.mo1339c(i3);
                m = 0;
                i2 = m;
            } else {
                m++;
                if (m >= 4 && i2 > 188) {
                    return true;
                }
                extractorInput.mo1340c(parsableByteArray.f5256a, 0, 4);
                parsableBitArray.m4231a(14);
                int c = parsableBitArray.m4236c(13);
                if (c <= 6) {
                    return false;
                }
                extractorInput.mo1339c(c - 6);
                i2 += c;
            }
        }
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        this.f13063d.mo1378a(extractorOutput, new TrackIdGenerator(0, 1));
        extractorOutput.mo1416a();
        extractorOutput.mo1417a(new Unseekable(-9223372036854775807L));
    }

    public final void mo1351a(long j, long j2) {
        this.f13065f = 0;
        this.f13063d.m12178c();
    }

    public final int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        extractorInput = extractorInput.mo1331a(this.f13064e.f5256a, 0, HttpStatus.HTTP_OK);
        if (extractorInput == -1) {
            return -1;
        }
        this.f13064e.m4249c(0);
        this.f13064e.m4247b(extractorInput);
        if (this.f13065f == null) {
            this.f13063d.f13067a = this.f13062c;
            this.f13065f = true;
        }
        this.f13063d.mo1379a(this.f13064e);
        return 0;
    }
}

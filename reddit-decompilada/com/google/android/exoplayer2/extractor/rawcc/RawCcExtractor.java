package com.google.android.exoplayer2.extractor.rawcc;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class RawCcExtractor implements Extractor {
    private static final int f13033a = Util.m4326g("RCC\u0001");
    private final Format f13034b;
    private final ParsableByteArray f13035c = new ParsableByteArray(9);
    private TrackOutput f13036d;
    private int f13037e = null;
    private int f13038f;
    private long f13039g;
    private int f13040h;
    private int f13041i;

    public RawCcExtractor(Format format) {
        this.f13034b = format;
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        extractorOutput.mo1417a(new Unseekable(-9223372036854775807L));
        this.f13036d = extractorOutput.mo1415a(0, 3);
        extractorOutput.mo1416a();
        this.f13036d.mo1345a(this.f13034b);
    }

    public final boolean mo1353a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        this.f13035c.m4241a();
        extractorInput.mo1340c(this.f13035c.f5256a, 0, 8);
        if (this.f13035c.m4259j() == f13033a) {
            return true;
        }
        return false;
    }

    public final int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        while (true) {
            boolean z = true;
            int i = 0;
            switch (this.f13037e) {
                case null:
                    this.f13035c.m4241a();
                    if (extractorInput.mo1333a(this.f13035c.f5256a, 0, 8, true) != null) {
                        if (this.f13035c.m4259j() != f13033a) {
                            throw new IOException("Input not RawCC");
                        }
                        this.f13038f = this.f13035c.m4250d();
                        i = 1;
                    }
                    if (i != 0) {
                        this.f13037e = 1;
                        break;
                    }
                    return -1;
                case 1:
                    this.f13035c.m4241a();
                    if (this.f13038f == null) {
                        if (extractorInput.mo1333a(this.f13035c.f5256a, 0, 5, true) != null) {
                            this.f13039g = (this.f13035c.m4257h() * 1000) / 45;
                            this.f13040h = this.f13035c.m4250d();
                            this.f13041i = 0;
                            if (z) {
                                this.f13037e = 2;
                                break;
                            }
                            this.f13037e = 0;
                            return -1;
                        }
                    } else if (this.f13038f != 1) {
                        positionHolder = new StringBuilder("Unsupported version number: ");
                        positionHolder.append(this.f13038f);
                        throw new ParserException(positionHolder.toString());
                    } else if (extractorInput.mo1333a(this.f13035c.f5256a, 0, 9, true) != null) {
                        this.f13039g = this.f13035c.m4261l();
                        this.f13040h = this.f13035c.m4250d();
                        this.f13041i = 0;
                        if (z) {
                            this.f13037e = 0;
                            return -1;
                        }
                        this.f13037e = 2;
                    }
                    z = false;
                    if (z) {
                        this.f13037e = 2;
                    } else {
                        this.f13037e = 0;
                        return -1;
                    }
                case 2:
                    m12151b(extractorInput);
                    this.f13037e = 1;
                    return 0;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    public final void mo1351a(long j, long j2) {
        this.f13037e = 0;
    }

    private void m12151b(ExtractorInput extractorInput) throws IOException, InterruptedException {
        while (this.f13040h > 0) {
            this.f13035c.m4241a();
            extractorInput.mo1336b(this.f13035c.f5256a, 0, 3);
            this.f13036d.mo1346a(this.f13035c, 3);
            this.f13041i += 3;
            this.f13040h--;
        }
        if (this.f13041i > null) {
            this.f13036d.mo1344a(this.f13039g, 1, this.f13041i, 0, null);
        }
    }
}

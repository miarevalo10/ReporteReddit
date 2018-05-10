package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import java.io.IOException;

public final class WavExtractor implements Extractor, SeekMap {
    public static final ExtractorsFactory f13214a = new C11381();
    private ExtractorOutput f13215b;
    private TrackOutput f13216c;
    private WavHeader f13217d;
    private int f13218e;
    private int f13219f;

    static class C11381 implements ExtractorsFactory {
        C11381() {
        }

        public final Extractor[] mo1342a() {
            return new Extractor[]{new WavExtractor()};
        }
    }

    public final boolean a_() {
        return true;
    }

    public final boolean mo1353a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return WavHeaderReader.m3883a(extractorInput) != null ? true : null;
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        this.f13215b = extractorOutput;
        this.f13216c = extractorOutput.mo1415a(0, 1);
        this.f13217d = null;
        extractorOutput.mo1416a();
    }

    public final void mo1351a(long j, long j2) {
        this.f13219f = 0;
    }

    public final int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        WavHeader wavHeader;
        ExtractorInput extractorInput2 = extractorInput;
        if (this.f13217d == null) {
            r0.f13217d = WavHeaderReader.m3883a(extractorInput);
            if (r0.f13217d == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            wavHeader = r0.f13217d;
            r0.f13216c.mo1345a(Format.m3557a(null, "audio/raw", (wavHeader.f4637b * wavHeader.f4640e) * wavHeader.f4636a, 32768, r0.f13217d.f4636a, r0.f13217d.f4637b, r0.f13217d.f4641f, null, null, 0, null));
            r0.f13218e = r0.f13217d.f4639d;
        }
        wavHeader = r0.f13217d;
        boolean z = (wavHeader.f4642g == 0 || wavHeader.f4643h == 0) ? false : true;
        if (!z) {
            WavHeaderReader.m3884a(extractorInput2, r0.f13217d);
            r0.f13215b.mo1417a(r0);
        }
        int a = r0.f13216c.mo1343a(extractorInput2, 32768 - r0.f13219f, true);
        if (a != -1) {
            r0.f13219f += a;
        }
        int i = r0.f13219f / r0.f13218e;
        if (i > 0) {
            long c = ((extractorInput.mo1338c() - ((long) r0.f13219f)) * 1000000) / ((long) r0.f13217d.f4638c);
            int i2 = i * r0.f13218e;
            r0.f13219f -= i2;
            r0.f13216c.mo1344a(c, 1, i2, r0.f13219f, null);
        }
        if (a == -1) {
            return -1;
        }
        return 0;
    }

    public final long mo1328b() {
        WavHeader wavHeader = this.f13217d;
        return ((wavHeader.f4643h / ((long) wavHeader.f4639d)) * 1000000) / ((long) wavHeader.f4637b);
    }

    public final long mo1329b(long j) {
        WavHeader wavHeader = this.f13217d;
        return Math.min((((j * ((long) wavHeader.f4638c)) / 1000000) / ((long) wavHeader.f4639d)) * ((long) wavHeader.f4639d), wavHeader.f4643h - ((long) wavHeader.f4639d)) + wavHeader.f4642g;
    }
}

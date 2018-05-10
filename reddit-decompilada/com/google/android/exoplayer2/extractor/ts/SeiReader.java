package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.text.cea.CeaUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

final class SeiReader {
    private final List<Format> f4622a;
    private final TrackOutput[] f4623b;

    public SeiReader(List<Format> list) {
        this.f4622a = list;
        this.f4623b = new TrackOutput[list.size()];
    }

    public final void m3872a(ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        for (int i = 0; i < this.f4623b.length; i++) {
            boolean z;
            StringBuilder stringBuilder;
            trackIdGenerator.m3876a();
            TrackOutput a = extractorOutput.mo1415a(trackIdGenerator.m3877b(), 3);
            Format format = (Format) this.f4622a.get(i);
            String str = format.f4018f;
            if (!"application/cea-608".equals(str)) {
                if (!"application/cea-708".equals(str)) {
                    z = false;
                    stringBuilder = new StringBuilder("Invalid closed caption mime type provided: ");
                    stringBuilder.append(str);
                    Assertions.m4185a(z, stringBuilder.toString());
                    a.mo1345a(Format.m3561a(format.f4013a == null ? format.f4013a : trackIdGenerator.m3878c(), str, format.f4036x, format.f4037y, format.f4038z));
                    this.f4623b[i] = a;
                }
            }
            z = true;
            stringBuilder = new StringBuilder("Invalid closed caption mime type provided: ");
            stringBuilder.append(str);
            Assertions.m4185a(z, stringBuilder.toString());
            if (format.f4013a == null) {
            }
            a.mo1345a(Format.m3561a(format.f4013a == null ? format.f4013a : trackIdGenerator.m3878c(), str, format.f4036x, format.f4037y, format.f4038z));
            this.f4623b[i] = a;
        }
    }

    public final void m3871a(long j, ParsableByteArray parsableByteArray) {
        CeaUtil.m4064a(j, parsableByteArray, this.f4623b);
    }
}

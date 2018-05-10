package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class SpliceInfoSectionReader implements SectionPayloadReader {
    private TimestampAdjuster f13189a;
    private TrackOutput f13190b;
    private boolean f13191c;

    public final void mo1387a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        this.f13189a = timestampAdjuster;
        trackIdGenerator.m3876a();
        this.f13190b = extractorOutput.mo1415a(trackIdGenerator.m3877b(), 4);
        this.f13190b.mo1345a(Format.m3573b(trackIdGenerator.m3878c(), "application/x-scte35"));
    }

    public final void mo1386a(ParsableByteArray parsableByteArray) {
        long j = -9223372036854775807L;
        if (!this.f13191c) {
            if (this.f13189a.m4284a() != -9223372036854775807L) {
                this.f13190b.mo1345a(Format.m3554a("application/x-scte35", this.f13189a.m4284a()));
                this.f13191c = true;
            } else {
                return;
            }
        }
        int b = parsableByteArray.m4246b();
        this.f13190b.mo1346a(parsableByteArray, b);
        TrackOutput trackOutput = this.f13190b;
        parsableByteArray = this.f13189a;
        if (parsableByteArray.f5280b != -9223372036854775807L) {
            j = parsableByteArray.f5280b;
        } else if (parsableByteArray.f5279a != Long.MAX_VALUE) {
            j = parsableByteArray.f5279a;
        }
        trackOutput.mo1344a(j, 1, b, 0, null);
    }
}

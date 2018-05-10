package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Id3Reader implements ElementaryStreamReader {
    private final ParsableByteArray f13145a = new ParsableByteArray(10);
    private TrackOutput f13146b;
    private boolean f13147c;
    private long f13148d;
    private int f13149e;
    private int f13150f;

    public final void mo1376a() {
        this.f13147c = false;
    }

    public final void mo1378a(ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.m3876a();
        this.f13146b = extractorOutput.mo1415a(trackIdGenerator.m3877b(), 4);
        this.f13146b.mo1345a(Format.m3573b(trackIdGenerator.m3878c(), "application/id3"));
    }

    public final void mo1377a(long j, boolean z) {
        if (z) {
            this.f13147c = true;
            this.f13148d = j;
            this.f13149e = 0;
            this.f13150f = 0;
        }
    }

    public final void mo1379a(ParsableByteArray parsableByteArray) {
        if (this.f13147c) {
            int b = parsableByteArray.m4246b();
            if (this.f13150f < 10) {
                int min = Math.min(b, 10 - this.f13150f);
                System.arraycopy(parsableByteArray.f5256a, parsableByteArray.f5257b, this.f13145a.f5256a, this.f13150f, min);
                if (this.f13150f + min == 10) {
                    this.f13145a.m4249c(0);
                    if (73 == this.f13145a.m4250d() && 68 == this.f13145a.m4250d()) {
                        if (51 == this.f13145a.m4250d()) {
                            this.f13145a.m4251d(3);
                            this.f13149e = 10 + this.f13145a.m4262m();
                        }
                    }
                    Log.w("Id3Reader", "Discarding invalid ID3 tag");
                    this.f13147c = false;
                    return;
                }
            }
            b = Math.min(b, this.f13149e - this.f13150f);
            this.f13146b.mo1346a(parsableByteArray, b);
            this.f13150f += b;
        }
    }

    public final void mo1380b() {
        if (this.f13147c && this.f13149e != 0) {
            if (this.f13150f == this.f13149e) {
                this.f13146b.mo1344a(this.f13148d, 1, this.f13149e, 0, null);
                this.f13147c = false;
            }
        }
    }
}

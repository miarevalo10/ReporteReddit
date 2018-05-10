package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

public final class SectionReader implements TsPayloadReader {
    private final SectionPayloadReader f13183a;
    private final ParsableByteArray f13184b = new ParsableByteArray(32);
    private int f13185c;
    private int f13186d;
    private boolean f13187e;
    private boolean f13188f;

    public SectionReader(SectionPayloadReader sectionPayloadReader) {
        this.f13183a = sectionPayloadReader;
    }

    public final void mo1385a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        this.f13183a.mo1387a(timestampAdjuster, extractorOutput, trackIdGenerator);
        this.f13188f = true;
    }

    public final void mo1383a() {
        this.f13188f = true;
    }

    public final void mo1384a(ParsableByteArray parsableByteArray, boolean z) {
        int d = z ? parsableByteArray.m4250d() + parsableByteArray.f5257b : -1;
        if (this.f13188f) {
            if (z) {
                this.f13188f = false;
                parsableByteArray.m4249c(d);
                this.f13186d = 0;
            } else {
                return;
            }
        }
        while (parsableByteArray.m4246b() <= false) {
            boolean z2 = true;
            if (this.f13186d < true) {
                if (!this.f13186d) {
                    z = parsableByteArray.m4250d();
                    parsableByteArray.m4249c(parsableByteArray.f5257b - 1);
                    if (z) {
                        this.f13188f = true;
                        return;
                    }
                }
                z = Math.min(parsableByteArray.m4246b(), 3 - this.f13186d);
                parsableByteArray.m4245a(this.f13184b.f5256a, this.f13186d, z);
                this.f13186d += z;
                if (this.f13186d) {
                    this.f13184b.m4242a(3);
                    this.f13184b.m4251d(1);
                    z = this.f13184b.m4250d();
                    int d2 = this.f13184b.m4250d();
                    if ((z & 128) == 0) {
                        z2 = false;
                    }
                    this.f13187e = z2;
                    this.f13185c = (((z & 15) << 8) | d2) + true;
                    if (this.f13184b.m4248c() < this.f13185c) {
                        z = this.f13184b.f5256a;
                        this.f13184b.m4242a(Math.min(4098, Math.max(this.f13185c, z.length * 2)));
                        System.arraycopy(z, 0, this.f13184b.f5256a, 0, 3);
                    }
                }
            } else {
                z = Math.min(parsableByteArray.m4246b(), this.f13185c - this.f13186d);
                parsableByteArray.m4245a(this.f13184b.f5256a, this.f13186d, z);
                this.f13186d += z;
                if (this.f13186d != this.f13185c) {
                    continue;
                } else {
                    if (!this.f13187e) {
                        this.f13184b.m4242a(this.f13185c);
                    } else if (Util.m4299a(this.f13184b.f5256a, this.f13185c, -1)) {
                        this.f13188f = true;
                        return;
                    } else {
                        this.f13184b.m4242a(this.f13185c - 4);
                    }
                    this.f13183a.mo1386a(this.f13184b);
                    this.f13186d = 0;
                }
            }
        }
    }
}

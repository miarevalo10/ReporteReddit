package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class DvbSubtitleReader implements ElementaryStreamReader {
    private final List<DvbSubtitleInfo> f13097a;
    private final TrackOutput[] f13098b;
    private boolean f13099c;
    private int f13100d;
    private int f13101e;
    private long f13102f;

    public DvbSubtitleReader(List<DvbSubtitleInfo> list) {
        this.f13097a = list;
        this.f13098b = new TrackOutput[list.size()];
    }

    public final void mo1376a() {
        this.f13099c = false;
    }

    public final void mo1378a(ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        for (int i = 0; i < this.f13098b.length; i++) {
            DvbSubtitleInfo dvbSubtitleInfo = (DvbSubtitleInfo) this.f13097a.get(i);
            trackIdGenerator.m3876a();
            TrackOutput a = extractorOutput.mo1415a(trackIdGenerator.m3877b(), 3);
            a.mo1345a(Format.m3570a(trackIdGenerator.m3878c(), "application/dvbsubs", Collections.singletonList(dvbSubtitleInfo.f4626c), dvbSubtitleInfo.f4624a, null));
            this.f13098b[i] = a;
        }
    }

    public final void mo1377a(long j, boolean z) {
        if (z) {
            this.f13099c = true;
            this.f13102f = j;
            this.f13101e = 0;
            this.f13100d = 2;
        }
    }

    public final void mo1380b() {
        if (this.f13099c) {
            for (TrackOutput a : this.f13098b) {
                a.mo1344a(this.f13102f, 1, this.f13101e, 0, null);
            }
            this.f13099c = false;
        }
    }

    public final void mo1379a(ParsableByteArray parsableByteArray) {
        if (this.f13099c && (this.f13100d != 2 || m12188a(parsableByteArray, 32))) {
            int i = 0;
            if (this.f13100d != 1 || m12188a(parsableByteArray, 0)) {
                int i2 = parsableByteArray.f5257b;
                int b = parsableByteArray.m4246b();
                TrackOutput[] trackOutputArr = this.f13098b;
                int length = trackOutputArr.length;
                while (i < length) {
                    TrackOutput trackOutput = trackOutputArr[i];
                    parsableByteArray.m4249c(i2);
                    trackOutput.mo1346a(parsableByteArray, b);
                    i++;
                }
                this.f13101e += b;
            }
        }
    }

    private boolean m12188a(ParsableByteArray parsableByteArray, int i) {
        if (parsableByteArray.m4246b() == 0) {
            return false;
        }
        if (parsableByteArray.m4250d() != i) {
            this.f13099c = false;
        }
        this.f13100d--;
        return this.f13099c;
    }
}

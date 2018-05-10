package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

abstract class StreamReader {
    long f4513a;
    int f4514b;
    private final OggPacket f4515c = new OggPacket();
    private TrackOutput f4516d;
    private ExtractorOutput f4517e;
    private OggSeeker f4518f;
    private long f4519g;
    private long f4520h;
    private int f4521i;
    private SetupData f4522j;
    private long f4523k;
    private boolean f4524l;
    private boolean f4525m;

    static class SetupData {
        Format f4511a;
        OggSeeker f4512b;

        SetupData() {
        }
    }

    private static final class UnseekableOggSeeker implements OggSeeker {
        public final long mo1369a(long j) {
            return 0;
        }

        public final long mo1370a(ExtractorInput extractorInput) throws IOException, InterruptedException {
            return -1;
        }

        private UnseekableOggSeeker() {
        }

        public final SeekMap mo1371a() {
            return new Unseekable(-9223372036854775807L);
        }
    }

    protected abstract boolean mo1373a(ParsableByteArray parsableByteArray, long j, SetupData setupData) throws IOException, InterruptedException;

    protected abstract long mo1374b(ParsableByteArray parsableByteArray);

    final void m3835a(ExtractorOutput extractorOutput, TrackOutput trackOutput) {
        this.f4517e = extractorOutput;
        this.f4516d = trackOutput;
        mo1372a(true);
    }

    protected void mo1372a(boolean z) {
        if (z) {
            this.f4522j = new SetupData();
            this.f4513a = 0;
            this.f4514b = false;
        } else {
            this.f4514b = true;
        }
        this.f4519g = -1;
        this.f4520h = 0;
    }

    final void m3834a(long j, long j2) {
        OggPacket oggPacket = this.f4515c;
        oggPacket.f4494a.m3826a();
        oggPacket.f4495b.m4241a();
        oggPacket.f4496c = -1;
        oggPacket.f4497d = false;
        if (j == 0) {
            mo1372a(this.f4524l ^ 1);
            return;
        }
        if (this.f4514b != null) {
            this.f4519g = this.f4518f.mo1369a(j2);
            this.f4514b = 2;
        }
    }

    final int m3831a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        boolean z = true;
        while (z) {
            if (this.f4515c.m3825a(extractorInput)) {
                this.f4523k = extractorInput.mo1338c() - this.f4513a;
                z = mo1373a(this.f4515c.f4495b, this.f4513a, this.f4522j);
                if (z) {
                    this.f4513a = extractorInput.mo1338c();
                }
            } else {
                this.f4514b = 3;
                return -1;
            }
        }
        this.f4521i = this.f4522j.f4511a.f4031s;
        if (!this.f4525m) {
            this.f4516d.mo1345a(this.f4522j.f4511a);
            this.f4525m = true;
        }
        if (this.f4522j.f4512b != null) {
            this.f4518f = this.f4522j.f4512b;
        } else if (extractorInput.mo1341d() == -1) {
            this.f4518f = new UnseekableOggSeeker();
        } else {
            OggPageHeader oggPageHeader = this.f4515c.f4494a;
            this.f4518f = new DefaultOggSeeker(this.f4513a, extractorInput.mo1341d(), this, oggPageHeader.f4507h + oggPageHeader.f4508i, oggPageHeader.f4502c);
        }
        this.f4522j = null;
        this.f4514b = 2;
        extractorInput = this.f4515c;
        if (extractorInput.f4495b.f5256a.length != 65025) {
            extractorInput.f4495b.f5256a = Arrays.copyOf(extractorInput.f4495b.f5256a, Math.max(65025, extractorInput.f4495b.f5258c));
        }
        return 0;
    }

    final int m3832a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        ExtractorInput extractorInput2 = extractorInput;
        long a = this.f4518f.mo1370a(extractorInput2);
        if (a >= 0) {
            positionHolder.f4268a = a;
            return 1;
        }
        if (a < -1) {
            mo1375c(-(a + 2));
        }
        if (!r0.f4524l) {
            r0.f4517e.mo1417a(r0.f4518f.mo1371a());
            r0.f4524l = true;
        }
        if (r0.f4523k <= 0) {
            if (!r0.f4515c.m3825a(extractorInput2)) {
                r0.f4514b = 3;
                return -1;
            }
        }
        r0.f4523k = 0;
        ParsableByteArray parsableByteArray = r0.f4515c.f4495b;
        a = mo1374b(parsableByteArray);
        if (a >= 0 && r0.f4520h + a >= r0.f4519g) {
            long a2 = m3833a(r0.f4520h);
            r0.f4516d.mo1346a(parsableByteArray, parsableByteArray.f5258c);
            r0.f4516d.mo1344a(a2, 1, parsableByteArray.f5258c, 0, null);
            r0.f4519g = -1;
        }
        r0.f4520h += a;
        return 0;
    }

    protected final long m3833a(long j) {
        return (j * 1000000) / ((long) this.f4521i);
    }

    protected final long m3838b(long j) {
        return (((long) this.f4521i) * j) / 1000000;
    }

    protected void mo1375c(long j) {
        this.f4520h = j;
    }
}

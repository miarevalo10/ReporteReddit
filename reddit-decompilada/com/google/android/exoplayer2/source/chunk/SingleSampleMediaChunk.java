package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.IOException;

public final class SingleSampleMediaChunk extends BaseMediaChunk {
    private final int f19505l;
    private final Format f19506m;
    private volatile int f19507n;
    private volatile boolean f19508o;
    private volatile boolean f19509p;

    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, int i2, int i3, Format format2) {
        super(dataSource, dataSpec, format, i, obj, j, j2, i2);
        this.f19505l = i3;
        this.f19506m = format2;
    }

    public final boolean mo3923f() {
        return this.f19509p;
    }

    public final long mo3358d() {
        return (long) this.f19507n;
    }

    public final void mo1404a() {
        this.f19508o = true;
    }

    public final boolean mo1405b() {
        return this.f19508o;
    }

    public final void mo1406c() throws IOException, InterruptedException {
        try {
            long a = this.j.mo1435a(this.c.m4149a((long) this.f19507n));
            if (a != -1) {
                a += (long) this.f19507n;
            }
            ExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.j, (long) this.f19507n, a);
            BaseMediaChunkOutput baseMediaChunkOutput = this.f18963a;
            baseMediaChunkOutput.m12368a(0);
            TrackOutput a2 = baseMediaChunkOutput.mo1414a(this.f19505l);
            a2.mo1345a(this.f19506m);
            for (int i = 0; i != -1; i = a2.mo1343a(defaultExtractorInput, RedditJobManager.f10810d, true)) {
                this.f19507n += i;
            }
            a2.mo1344a(this.h, 1, this.f19507n, 0, null);
            this.f19509p = true;
        } finally {
            Util.m4307a(this.j);
        }
    }
}

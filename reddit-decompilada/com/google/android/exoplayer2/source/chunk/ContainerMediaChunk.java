package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.TrackOutputProvider;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public class ContainerMediaChunk extends BaseMediaChunk {
    private final int f19499l;
    private final long f19500m;
    private final ChunkExtractorWrapper f19501n;
    private volatile int f19502o;
    private volatile boolean f19503p;
    private volatile boolean f19504q;

    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, int i2, int i3, long j3, ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, format, i, obj, j, j2, i2);
        this.f19499l = i3;
        this.f19500m = j3;
        this.f19501n = chunkExtractorWrapper;
    }

    public final int mo4256e() {
        return this.k + this.f19499l;
    }

    public final boolean mo3923f() {
        return this.f19504q;
    }

    public final long mo3358d() {
        return (long) this.f19502o;
    }

    public final void mo1404a() {
        this.f19503p = true;
    }

    public final boolean mo1405b() {
        return this.f19503p;
    }

    public final void mo1406c() throws IOException, InterruptedException {
        DataSpec a = this.c.m4149a((long) this.f19502o);
        ExtractorInput defaultExtractorInput;
        try {
            defaultExtractorInput = new DefaultExtractorInput(this.j, a.f5169c, this.j.mo1435a(a));
            if (this.f19502o == 0) {
                TrackOutputProvider trackOutputProvider = this.f18963a;
                trackOutputProvider.m12368a(this.f19500m);
                this.f19501n.m12378a(trackOutputProvider);
            }
            Extractor extractor = this.f19501n.f13315a;
            boolean z = false;
            int i = 0;
            while (i == 0 && !this.f19503p) {
                i = extractor.mo1350a(defaultExtractorInput, null);
            }
            if (i != 1) {
                z = true;
            }
            Assertions.m4186b(z);
            this.f19502o = (int) (defaultExtractorInput.mo1338c() - this.c.f5169c);
            Util.m4307a(this.j);
            this.f19504q = true;
        } catch (Throwable th) {
            Util.m4307a(this.j);
        }
    }
}

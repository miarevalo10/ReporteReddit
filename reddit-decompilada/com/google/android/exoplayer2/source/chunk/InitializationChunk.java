package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class InitializationChunk extends Chunk {
    private final ChunkExtractorWrapper f16962a;
    private volatile int f16963b;
    private volatile boolean f16964k;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, 2, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.f16962a = chunkExtractorWrapper;
    }

    public final long mo3358d() {
        return (long) this.f16963b;
    }

    public final void mo1404a() {
        this.f16964k = true;
    }

    public final boolean mo1405b() {
        return this.f16964k;
    }

    public final void mo1406c() throws IOException, InterruptedException {
        DataSpec a = this.c.m4149a((long) this.f16963b);
        ExtractorInput defaultExtractorInput;
        try {
            defaultExtractorInput = new DefaultExtractorInput(this.j, a.f5169c, this.j.mo1435a(a));
            if (this.f16963b == 0) {
                this.f16962a.m12378a(null);
            }
            Extractor extractor = this.f16962a.f13315a;
            int i = 0;
            while (i == 0 && !this.f16964k) {
                i = extractor.mo1350a(defaultExtractorInput, null);
            }
            boolean z = true;
            if (i == 1) {
                z = false;
            }
            Assertions.m4186b(z);
            this.f16963b = (int) (defaultExtractorInput.mo1338c() - this.c.f5169c);
            Util.m4307a(this.j);
        } catch (Throwable th) {
            Util.m4307a(this.j);
        }
    }
}

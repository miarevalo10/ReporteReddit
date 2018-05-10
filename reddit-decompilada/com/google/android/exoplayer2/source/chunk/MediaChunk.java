package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;

public abstract class MediaChunk extends Chunk {
    public final int f16965k;

    public abstract boolean mo3923f();

    public MediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, int i2) {
        super(dataSource, dataSpec, 1, format, i, obj, j, j2);
        Assertions.m4182a((Object) format);
        this.f16965k = i2;
    }

    public int mo4256e() {
        return this.f16965k + 1;
    }
}

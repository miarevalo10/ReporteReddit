package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;

public abstract class BaseMediaChunk extends MediaChunk {
    BaseMediaChunkOutput f18963a;
    int[] f18964b;

    public BaseMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, int i2) {
        super(dataSource, dataSpec, format, i, obj, j, j2, i2);
    }
}

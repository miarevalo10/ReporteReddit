package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.util.Assertions;

public abstract class Chunk implements Loadable {
    public final DataSpec f13302c;
    public final int f13303d;
    public final Format f13304e;
    public final int f13305f;
    public final Object f13306g;
    public final long f13307h;
    public final long f13308i;
    protected final DataSource f13309j;

    public abstract long mo3358d();

    public Chunk(DataSource dataSource, DataSpec dataSpec, int i, Format format, int i2, Object obj, long j, long j2) {
        this.f13309j = (DataSource) Assertions.m4182a((Object) dataSource);
        this.f13302c = (DataSpec) Assertions.m4182a((Object) dataSpec);
        this.f13303d = i;
        this.f13304e = format;
        this.f13305f = i2;
        this.f13306g = obj;
        this.f13307h = j;
        this.f13308i = j2;
    }
}

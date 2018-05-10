package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;

public final class DashWrappingSegmentIndex implements DashSegmentIndex {
    private final ChunkIndex f13376a;

    public final int mo1423a() {
        return 0;
    }

    public final boolean mo1429b() {
        return true;
    }

    public DashWrappingSegmentIndex(ChunkIndex chunkIndex) {
        this.f13376a = chunkIndex;
    }

    public final int mo1424a(long j) {
        return this.f13376a.f12820a;
    }

    public final long mo1426a(int i) {
        return this.f13376a.f12824e[i];
    }

    public final long mo1427a(int i, long j) {
        return this.f13376a.f12823d[i];
    }

    public final RangedUri mo1428b(int i) {
        return new RangedUri(null, this.f13376a.f12822c[i], (long) this.f13376a.f12821b[i]);
    }

    public final int mo1425a(long j, long j2) {
        return this.f13376a.m11994a(j);
    }
}

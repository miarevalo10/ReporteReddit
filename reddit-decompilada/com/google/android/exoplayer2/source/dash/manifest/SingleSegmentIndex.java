package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.source.dash.DashSegmentIndex;

final class SingleSegmentIndex implements DashSegmentIndex {
    private final RangedUri f13395a;

    public final int mo1423a() {
        return 0;
    }

    public final int mo1424a(long j) {
        return 1;
    }

    public final int mo1425a(long j, long j2) {
        return 0;
    }

    public final long mo1426a(int i) {
        return 0;
    }

    public final long mo1427a(int i, long j) {
        return j;
    }

    public final boolean mo1429b() {
        return true;
    }

    public SingleSegmentIndex(RangedUri rangedUri) {
        this.f13395a = rangedUri;
    }

    public final RangedUri mo1428b(int i) {
        return this.f13395a;
    }
}

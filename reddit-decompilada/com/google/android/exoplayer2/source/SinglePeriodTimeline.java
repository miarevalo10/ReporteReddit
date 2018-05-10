package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.util.Assertions;

public final class SinglePeriodTimeline extends Timeline {
    private static final Object f13290b = new Object();
    private final long f13291c;
    private final long f13292d;
    private final long f13293e;
    private final long f13294f;
    private final long f13295g;
    private final long f13296h;
    private final boolean f13297i;
    private final boolean f13298j;

    public final int mo1302b() {
        return 1;
    }

    public final int mo1303c() {
        return 1;
    }

    public SinglePeriodTimeline(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2);
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.f13291c = j;
        this.f13292d = j2;
        this.f13293e = j3;
        this.f13294f = j4;
        this.f13295g = j5;
        this.f13296h = j6;
        this.f13297i = z;
        this.f13298j = z2;
    }

    public final Window mo1301a(int i, Window window, long j) {
        Assertions.m4181a(i, 1);
        long j2 = this.f13296h;
        if (this.f13298j) {
            j2 += j;
            if (j2 > r0.f13294f) {
                j2 = -9223372036854775807L;
            }
        }
        return window.m3629a(r0.f13291c, r0.f13292d, r0.f13297i, r0.f13298j, j2, r0.f13294f, 0, r0.f13295g);
    }

    public final Period mo1300a(int i, Period period, boolean z) {
        Assertions.m4181a(i, 1);
        Object obj = z ? f13290b : 0;
        return period.m3624a(obj, obj, this.f13293e, -this.f13295g);
    }

    public final int mo1299a(Object obj) {
        return f13290b.equals(obj) != null ? null : -1;
    }
}

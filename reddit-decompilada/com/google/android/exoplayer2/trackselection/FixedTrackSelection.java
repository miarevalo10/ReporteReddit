package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;

public final class FixedTrackSelection extends BaseTrackSelection {
    private final int f17050e;
    private final Object f17051f;

    public final int mo3368a() {
        return 0;
    }

    public final void mo3369a(long j) {
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i) {
        this(trackGroup, i, (byte) 0);
    }

    private FixedTrackSelection(TrackGroup trackGroup, int i, byte b) {
        super(trackGroup, new int[]{i});
        this.f17050e = 0;
        this.f17051f = null;
    }

    public final int mo3370b() {
        return this.f17050e;
    }

    public final Object mo3371c() {
        return this.f17051f;
    }
}

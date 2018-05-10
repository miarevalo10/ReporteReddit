package com.google.android.exoplayer2.trackselection;

import java.util.Arrays;

public final class TrackSelectionArray {
    public final int f5147a;
    public final TrackSelection[] f5148b;
    private int f5149c;

    public TrackSelectionArray(TrackSelection... trackSelectionArr) {
        this.f5148b = trackSelectionArr;
        this.f5147a = trackSelectionArr.length;
    }

    public final TrackSelection[] m4133a() {
        return (TrackSelection[]) this.f5148b.clone();
    }

    public final int hashCode() {
        if (this.f5149c == 0) {
            this.f5149c = 527 + Arrays.hashCode(this.f5148b);
        }
        return this.f5149c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return Arrays.equals(this.f5148b, ((TrackSelectionArray) obj).f5148b);
            }
        }
        return null;
    }
}

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class TrackGroup {
    public final int f4782a;
    public final Format[] f4783b;
    private int f4784c;

    public TrackGroup(Format... formatArr) {
        Assertions.m4186b(formatArr.length > 0);
        this.f4783b = formatArr;
        this.f4782a = formatArr.length;
    }

    public final int m3974a(Format format) {
        for (int i = 0; i < this.f4783b.length; i++) {
            if (format == this.f4783b[i]) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.f4784c == 0) {
            this.f4784c = 527 + Arrays.hashCode(this.f4783b);
        }
        return this.f4784c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                TrackGroup trackGroup = (TrackGroup) obj;
                return this.f4782a == trackGroup.f4782a && Arrays.equals(this.f4783b, trackGroup.f4783b) != null;
            }
        }
        return false;
    }
}

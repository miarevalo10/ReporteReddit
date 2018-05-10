package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
import java.util.Comparator;

public abstract class BaseTrackSelection implements TrackSelection {
    protected final TrackGroup f13583a;
    protected final int f13584b;
    protected final int[] f13585c;
    final Format[] f13586d;
    private final long[] f13587e;
    private int f13588f;

    private static final class DecreasingBandwidthComparator implements Comparator<Format> {
        private DecreasingBandwidthComparator() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Format) obj2).f4014b - ((Format) obj).f4014b;
        }
    }

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        int i = 0;
        Assertions.m4186b(iArr.length > 0);
        this.f13583a = (TrackGroup) Assertions.m4182a((Object) trackGroup);
        this.f13584b = iArr.length;
        this.f13586d = new Format[this.f13584b];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.f13586d[i2] = trackGroup.f4783b[iArr[i2]];
        }
        Arrays.sort(this.f13586d, new DecreasingBandwidthComparator());
        this.f13585c = new int[this.f13584b];
        while (i < this.f13584b) {
            this.f13585c[i] = trackGroup.m3974a(this.f13586d[i]);
            i++;
        }
        this.f13587e = new long[this.f13584b];
    }

    public final TrackGroup mo1459d() {
        return this.f13583a;
    }

    public final int mo1461e() {
        return this.f13585c.length;
    }

    public final Format mo1456a(int i) {
        return this.f13586d[i];
    }

    public final int mo1457b(int i) {
        return this.f13585c[i];
    }

    public final int mo1455a(Format format) {
        for (int i = 0; i < this.f13584b; i++) {
            if (this.f13586d[i] == format) {
                return i;
            }
        }
        return -1;
    }

    public final int mo1458c(int i) {
        for (int i2 = 0; i2 < this.f13584b; i2++) {
            if (this.f13585c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public final Format mo1462f() {
        return this.f13586d[mo3368a()];
    }

    public final int mo1463g() {
        return this.f13585c[mo3368a()];
    }

    public final boolean mo1460d(int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean a = m12636a(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.f13584b && !a) {
            a = (i2 == i || m12636a(i2, elapsedRealtime)) ? false : true;
            i2++;
        }
        if (!a) {
            return false;
        }
        this.f13587e[i] = Math.max(this.f13587e[i], elapsedRealtime + 60000);
        return true;
    }

    protected final boolean m12636a(int i, long j) {
        return this.f13587e[i] > j;
    }

    public int hashCode() {
        if (this.f13588f == 0) {
            this.f13588f = (31 * System.identityHashCode(this.f13583a)) + Arrays.hashCode(this.f13585c);
        }
        return this.f13588f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
                return this.f13583a == baseTrackSelection.f13583a && Arrays.equals(this.f13585c, baseTrackSelection.f13585c) != null;
            }
        }
        return false;
    }
}

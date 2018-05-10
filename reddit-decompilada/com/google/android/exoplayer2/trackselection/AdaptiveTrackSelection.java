package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import io.fabric.sdk.android.services.common.AbstractSpiCall;

public class AdaptiveTrackSelection extends BaseTrackSelection {
    private final BandwidthMeter f17039e;
    private final int f17040f;
    private final long f17041g;
    private final long f17042h;
    private final long f17043i;
    private final float f17044j;
    private int f17045k = m17350b(0);
    private int f17046l = 1;

    public static final class Factory implements com.google.android.exoplayer2.trackselection.TrackSelection.Factory {
        private final BandwidthMeter f13577a;
        private final int f13578b = 2500000;
        private final int f13579c = AbstractSpiCall.DEFAULT_TIMEOUT;
        private final int f13580d = 25000;
        private final int f13581e = 25000;
        private final float f13582f = 0.75f;

        public Factory(BandwidthMeter bandwidthMeter) {
            this.f13577a = bandwidthMeter;
        }

        public final /* synthetic */ TrackSelection mo1454a(TrackGroup trackGroup, int[] iArr) {
            return new AdaptiveTrackSelection(trackGroup, iArr, this.f13577a, this.f13578b, (long) this.f13579c, (long) this.f13580d, (long) this.f13581e, this.f13582f);
        }
    }

    public final Object mo3371c() {
        return null;
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter, int i, long j, long j2, long j3, float f) {
        super(trackGroup, iArr);
        this.f17039e = bandwidthMeter;
        this.f17040f = i;
        this.f17041g = j * 1000;
        this.f17042h = j2 * 1000;
        this.f17043i = j3 * 1000;
        this.f17044j = f;
    }

    public final void mo3369a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.f17045k;
        this.f17045k = m17350b(elapsedRealtime);
        if (this.f17045k != i) {
            if (!m12636a(i, elapsedRealtime)) {
                Format format = this.f13586d[i];
                Format format2 = this.f13586d[this.f17045k];
                if (format2.f4014b > format.f4014b && j < this.f17041g) {
                    this.f17045k = i;
                } else if (format2.f4014b < format.f4014b && j >= this.f17042h) {
                    this.f17045k = i;
                }
            }
            if (this.f17045k != i) {
                this.f17046l = 3;
            }
        }
    }

    public final int mo3368a() {
        return this.f17045k;
    }

    public final int mo3370b() {
        return this.f17046l;
    }

    private int m17350b(long j) {
        long a = this.f17039e.mo1471a();
        a = a == -1 ? (long) this.f17040f : (long) (((float) a) * this.f17044j);
        int i = 0;
        int i2 = 0;
        while (i < this.b) {
            if (j == Long.MIN_VALUE || !m12636a(i, j)) {
                if (((long) this.f13586d[i].f4014b) <= a) {
                    return i;
                }
                i2 = i;
            }
            i++;
        }
        return i2;
    }
}

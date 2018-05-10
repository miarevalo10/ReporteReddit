package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.SlidingPercentile;
import java.util.Collections;

public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener<Object> {
    private final Handler f13649a;
    private final EventListener f13650b;
    private final SlidingPercentile f13651c;
    private final Clock f13652d;
    private int f13653e;
    private long f13654f;
    private long f13655g;
    private long f13656h;
    private long f13657i;
    private long f13658j;

    public DefaultBandwidthMeter() {
        this((byte) 0);
    }

    private DefaultBandwidthMeter(byte b) {
        this((char) (byte) 0);
    }

    private DefaultBandwidthMeter(char c) {
        this(Clock.f5216a);
    }

    private DefaultBandwidthMeter(Clock clock) {
        this.f13649a = null;
        this.f13650b = null;
        this.f13651c = new SlidingPercentile();
        this.f13652d = clock;
        this.f13658j = -1;
    }

    public final synchronized long mo1471a() {
        return this.f13658j;
    }

    public final synchronized void mo1473b() {
        if (this.f13653e == 0) {
            this.f13654f = this.f13652d.mo1496a();
        }
        this.f13653e++;
    }

    public final synchronized void mo1472a(int i) {
        this.f13655g += (long) i;
    }

    public final synchronized void mo1474c() {
        int i;
        int i2 = 0;
        Assertions.m4186b(this.f13653e > 0);
        long a = this.f13652d.mo1496a();
        final int i3 = (int) (a - this.f13654f);
        long j = (long) i3;
        this.f13656h += j;
        this.f13657i += this.f13655g;
        if (i3 > 0) {
            int i4;
            Sample sample;
            float f = (float) ((this.f13655g * 8000) / j);
            SlidingPercentile slidingPercentile = this.f13651c;
            int sqrt = (int) Math.sqrt((double) this.f13655g);
            if (slidingPercentile.f5275f != 1) {
                Collections.sort(slidingPercentile.f5273d, SlidingPercentile.f5270a);
                slidingPercentile.f5275f = 1;
            }
            if (slidingPercentile.f5278i > 0) {
                Sample[] sampleArr = slidingPercentile.f5274e;
                i4 = slidingPercentile.f5278i - 1;
                slidingPercentile.f5278i = i4;
                sample = sampleArr[i4];
            } else {
                sample = new Sample();
            }
            i4 = slidingPercentile.f5276g;
            slidingPercentile.f5276g = i4 + 1;
            sample.f5267a = i4;
            sample.f5268b = sqrt;
            sample.f5269c = f;
            slidingPercentile.f5273d.add(sample);
            slidingPercentile.f5277h += sqrt;
            while (slidingPercentile.f5277h > slidingPercentile.f5272c) {
                i = slidingPercentile.f5277h - slidingPercentile.f5272c;
                Sample sample2 = (Sample) slidingPercentile.f5273d.get(0);
                if (sample2.f5268b <= i) {
                    slidingPercentile.f5277h -= sample2.f5268b;
                    slidingPercentile.f5273d.remove(0);
                    if (slidingPercentile.f5278i < 5) {
                        Sample[] sampleArr2 = slidingPercentile.f5274e;
                        int i5 = slidingPercentile.f5278i;
                        slidingPercentile.f5278i = i5 + 1;
                        sampleArr2[i5] = sample2;
                    }
                } else {
                    sample2.f5268b -= i;
                    slidingPercentile.f5277h -= i;
                }
            }
            if (this.f13656h >= 2000 || this.f13657i >= 524288) {
                SlidingPercentile slidingPercentile2 = this.f13651c;
                if (slidingPercentile2.f5275f != 0) {
                    Collections.sort(slidingPercentile2.f5273d, SlidingPercentile.f5271b);
                    slidingPercentile2.f5275f = 0;
                }
                float f2 = 0.5f * ((float) slidingPercentile2.f5277h);
                sqrt = 0;
                while (i2 < slidingPercentile2.f5273d.size()) {
                    sample = (Sample) slidingPercentile2.f5273d.get(i2);
                    sqrt += sample.f5268b;
                    if (((float) sqrt) >= f2) {
                        f = sample.f5269c;
                        break;
                    }
                    i2++;
                }
                f = slidingPercentile2.f5273d.isEmpty() ? Float.NaN : ((Sample) slidingPercentile2.f5273d.get(slidingPercentile2.f5273d.size() - 1)).f5269c;
                this.f13658j = Float.isNaN(f) ? -1 : (long) f;
            }
        }
        final long j2 = this.f13655g;
        final long j3 = this.f13658j;
        if (!(this.f13649a == null || this.f13650b == null)) {
            this.f13649a.post(new Runnable(this) {
                final /* synthetic */ DefaultBandwidthMeter f5177d;

                public void run() {
                }
            });
        }
        i = this.f13653e - 1;
        this.f13653e = i;
        if (i > 0) {
            this.f13654f = a;
        }
        this.f13655g = 0;
    }
}

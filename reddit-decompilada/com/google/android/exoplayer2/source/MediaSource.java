package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import java.io.IOException;

public interface MediaSource {

    public interface Listener {
        void mo1413a(Timeline timeline, Object obj);
    }

    public static final class MediaPeriodId {
        public static final MediaPeriodId f4751a = new MediaPeriodId(-1, -1, -1);
        public final int f4752b;
        public final int f4753c;
        public final int f4754d;

        public MediaPeriodId(int i) {
            this(i, -1, -1);
        }

        public MediaPeriodId(int i, int i2, int i3) {
            this.f4752b = i;
            this.f4753c = i2;
            this.f4754d = i3;
        }

        public final MediaPeriodId m3936a(int i) {
            return this.f4752b == i ? this : new MediaPeriodId(i, this.f4753c, this.f4754d);
        }

        public final boolean m3937a() {
            return this.f4753c != -1;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
                    return this.f4752b == mediaPeriodId.f4752b && this.f4753c == mediaPeriodId.f4753c && this.f4754d == mediaPeriodId.f4754d;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (31 * (((527 + this.f4752b) * 31) + this.f4753c)) + this.f4754d;
        }
    }

    MediaPeriod mo1407a(MediaPeriodId mediaPeriodId, Allocator allocator);

    void mo1408a() throws IOException;

    void mo1410a(ExoPlayer exoPlayer, Listener listener);

    void mo1411a(MediaPeriod mediaPeriod);

    void mo1412b();
}

package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import com.google.android.exoplayer2.C0377C;
import com.google.android.exoplayer2.PlaybackParameters;

public final class StandaloneMediaClock implements MediaClock {
    public boolean f13710a;
    public long f13711b;
    private long f13712c;
    private PlaybackParameters f13713d = PlaybackParameters.f4054a;

    public final void m12715a() {
        if (this.f13710a) {
            m12716a(mo1494v());
            this.f13710a = false;
        }
    }

    public final void m12716a(long j) {
        this.f13712c = j;
        if (this.f13710a != null) {
            this.f13711b = SystemClock.elapsedRealtime();
        }
    }

    public final void m12717a(MediaClock mediaClock) {
        m12716a(mediaClock.mo1494v());
        this.f13713d = mediaClock.mo1495w();
    }

    public final long mo1494v() {
        long j = this.f13712c;
        if (!this.f13710a) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f13711b;
        if (this.f13713d.f4055b == 1.0f) {
            return j + C0377C.m3540b(elapsedRealtime);
        }
        return j + (elapsedRealtime * ((long) this.f13713d.f4057d));
    }

    public final PlaybackParameters mo1493a(PlaybackParameters playbackParameters) {
        if (this.f13710a) {
            m12716a(mo1494v());
        }
        this.f13713d = playbackParameters;
        return playbackParameters;
    }

    public final PlaybackParameters mo1495w() {
        return this.f13713d;
    }
}

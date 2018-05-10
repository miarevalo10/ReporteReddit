package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;

final class MediaPeriodInfoSequence {
    final Period f4050a = new Period();
    final Window f4051b = new Window();
    Timeline f4052c;
    int f4053d;

    public static final class MediaPeriodInfo {
        public final MediaPeriodId f4043a;
        public final long f4044b;
        public final long f4045c;
        public final long f4046d;
        public final long f4047e;
        public final boolean f4048f;
        public final boolean f4049g;

        MediaPeriodInfo(MediaPeriodId mediaPeriodId, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.f4043a = mediaPeriodId;
            this.f4044b = j;
            this.f4045c = j2;
            this.f4046d = j3;
            this.f4047e = j4;
            this.f4048f = z;
            this.f4049g = z2;
        }

        public final MediaPeriodInfo m3585a() {
            return new MediaPeriodInfo(this.f4043a.m3936a(-1), this.f4044b, this.f4045c, this.f4046d, this.f4047e, this.f4048f, this.f4049g);
        }
    }

    public final MediaPeriodId m3593a(int i, long j) {
        this.f4052c.mo1300a(i, this.f4050a, false);
        j = this.f4050a.m3623a(j);
        if (j == -1) {
            return new MediaPeriodId(i);
        }
        return new MediaPeriodId(i, j, this.f4050a.f4067h[j]);
    }

    public final MediaPeriodInfo m3590a(MediaPeriodInfo mediaPeriodInfo, int i) {
        return m3591a(mediaPeriodInfo, mediaPeriodInfo.f4043a.m3936a(i));
    }

    final MediaPeriodInfo m3591a(MediaPeriodInfo mediaPeriodInfo, MediaPeriodId mediaPeriodId) {
        long b;
        long j;
        MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodInfo;
        MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long j2 = mediaPeriodInfo2.f4044b;
        long j3 = mediaPeriodInfo2.f4045c;
        boolean a = m3586a(mediaPeriodId2, j3);
        boolean a2 = m3587a(mediaPeriodId2, a);
        this.f4052c.mo1300a(mediaPeriodId2.f4752b, this.f4050a, false);
        if (mediaPeriodId.m3937a()) {
            b = r0.f4050a.m3628b(mediaPeriodId2.f4753c, mediaPeriodId2.f4754d);
        } else if (j3 == Long.MIN_VALUE) {
            b = r0.f4050a.f4063d;
        } else {
            j = j3;
            return new MediaPeriodInfo(mediaPeriodId2, j2, j3, mediaPeriodInfo2.f4046d, j, a, a2);
        }
        j = b;
        return new MediaPeriodInfo(mediaPeriodId2, j2, j3, mediaPeriodInfo2.f4046d, j, a, a2);
    }

    final MediaPeriodInfo m3592a(MediaPeriodId mediaPeriodId, long j, long j2) {
        this.f4052c.mo1300a(mediaPeriodId.f4752b, this.f4050a, false);
        if (!mediaPeriodId.m3937a()) {
            j = this.f4050a.m3627b(j2);
            if (j == -1) {
                j = Long.MIN_VALUE;
            } else {
                j = this.f4050a.f4065f[j];
            }
            return m3589a(mediaPeriodId.f4752b, j2, j);
        } else if (this.f4050a.m3626a(mediaPeriodId.f4753c, mediaPeriodId.f4754d) == null) {
            return null;
        } else {
            return m3588a(mediaPeriodId.f4752b, mediaPeriodId.f4753c, mediaPeriodId.f4754d, j);
        }
    }

    final MediaPeriodInfo m3588a(int i, int i2, int i3, long j) {
        long j2;
        int i4 = i2;
        int i5 = i3;
        MediaPeriodId mediaPeriodId = new MediaPeriodId(i, i4, i5);
        boolean a = m3586a(mediaPeriodId, Long.MIN_VALUE);
        boolean a2 = m3587a(mediaPeriodId, a);
        long b = this.f4052c.mo1300a(mediaPeriodId.f4752b, this.f4050a, false).m3628b(mediaPeriodId.f4753c, mediaPeriodId.f4754d);
        if (i5 == this.f4050a.f4067h[i4]) {
            j2 = r0.f4050a.f4068i;
        } else {
            j2 = 0;
        }
        return new MediaPeriodInfo(mediaPeriodId, j2, Long.MIN_VALUE, j, b, a, a2);
    }

    final MediaPeriodInfo m3589a(int i, long j, long j2) {
        long j3;
        long j4 = j2;
        MediaPeriodId mediaPeriodId = new MediaPeriodId(i);
        boolean a = m3586a(mediaPeriodId, j4);
        boolean a2 = m3587a(mediaPeriodId, a);
        this.f4052c.mo1300a(mediaPeriodId.f4752b, this.f4050a, false);
        if (j4 == Long.MIN_VALUE) {
            j3 = r0.f4050a.f4063d;
        } else {
            j3 = j4;
        }
        return new MediaPeriodInfo(mediaPeriodId, j, j4, -9223372036854775807L, j3, a, a2);
    }

    private boolean m3586a(MediaPeriodId mediaPeriodId, long j) {
        int a = this.f4052c.mo1300a(mediaPeriodId.f4752b, this.f4050a, false).m3622a();
        if (a == 0) {
            return true;
        }
        a--;
        boolean a2 = mediaPeriodId.m3937a();
        if (this.f4050a.f4065f[a] == Long.MIN_VALUE) {
            j = this.f4050a.f4066g[a];
            if (j == -1) {
                return false;
            }
            mediaPeriodId = (a2 && mediaPeriodId.f4753c == a && mediaPeriodId.f4754d == j - 1) ? 1 : null;
            if (mediaPeriodId == null) {
                if (a2 || this.f4050a.f4067h[a] != j) {
                    return false;
                }
            }
            return true;
        } else if (a2 || j != Long.MIN_VALUE) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m3587a(MediaPeriodId mediaPeriodId, boolean z) {
        if (!this.f4052c.mo1301a(this.f4052c.mo1300a(mediaPeriodId.f4752b, this.f4050a, false).f4062c, this.f4051b, 0).f4075e) {
            if ((this.f4052c.m3630a(mediaPeriodId.f4752b, this.f4050a, this.f4051b, this.f4053d) == -1 ? 1 : null) == null || !z) {
                return false;
            }
            return true;
        }
        return false;
    }
}

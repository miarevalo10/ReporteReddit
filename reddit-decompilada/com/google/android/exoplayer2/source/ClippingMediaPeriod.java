package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod.Callback;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;

public final class ClippingMediaPeriod implements MediaPeriod, Callback {
    public final MediaPeriod f16911a;
    public long f16912b = -9223372036854775807L;
    public long f16913c = -9223372036854775807L;
    private Callback f16914d;
    private ClippingSampleStream[] f16915e = new ClippingSampleStream[null];
    private boolean f16916f = true;

    private static final class ClippingSampleStream implements SampleStream {
        boolean f13234a;
        boolean f13235b;
        private final MediaPeriod f13236c;
        private final SampleStream f13237d;
        private final long f13238e;
        private final long f13239f;

        public ClippingSampleStream(MediaPeriod mediaPeriod, SampleStream sampleStream, long j, long j2, boolean z) {
            this.f13236c = mediaPeriod;
            this.f13237d = sampleStream;
            this.f13238e = j;
            this.f13239f = j2;
            this.f13234a = z;
        }

        public final boolean mo1399a() {
            return this.f13237d.mo1399a();
        }

        public final void mo1400b() throws IOException {
            this.f13237d.mo1400b();
        }

        public final int mo1397a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (this.f13234a) {
                return -3;
            }
            if (this.f13235b) {
                decoderInputBuffer.f4220a = 4;
                return -4;
            }
            formatHolder = this.f13237d.mo1397a(formatHolder, decoderInputBuffer, z);
            if (this.f13239f == Long.MIN_VALUE || ((formatHolder != -4 || decoderInputBuffer.f12801d < this.f13239f) && !(formatHolder == -3 && this.f13236c.mo1402d() == Long.MIN_VALUE))) {
                if (formatHolder == -4 && !decoderInputBuffer.m3715c()) {
                    decoderInputBuffer.f12801d -= this.f13238e;
                }
                return formatHolder;
            }
            decoderInputBuffer.mo1321a();
            decoderInputBuffer.f4220a = 4;
            this.f13235b = true;
            return -4;
        }

        public final void mo1398a(long j) {
            this.f13237d.mo1398a(this.f13238e + j);
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod) {
        this.f16911a = mediaPeriod;
    }

    public final void mo3353a(Callback callback, long j) {
        this.f16914d = callback;
        this.f16911a.mo3353a(this, this.f16912b + j);
    }

    public final void b_() throws IOException {
        this.f16911a.b_();
    }

    public final TrackGroupArray mo3355b() {
        return this.f16911a.mo3355b();
    }

    public final long mo3351a(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        TrackSelection[] trackSelectionArr2 = trackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int i = 0;
        this.f16915e = new ClippingSampleStream[sampleStreamArr2.length];
        SampleStream[] sampleStreamArr3 = new SampleStream[sampleStreamArr2.length];
        int i2 = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i2 >= sampleStreamArr2.length) {
                break;
            }
            r8.f16915e[i2] = (ClippingSampleStream) sampleStreamArr2[i2];
            if (r8.f16915e[i2] != null) {
                sampleStream = r8.f16915e[i2].f13237d;
            }
            sampleStreamArr3[i2] = sampleStream;
            i2++;
        }
        long a = r8.f16911a.mo3351a(trackSelectionArr2, zArr, sampleStreamArr3, zArr2, j + r8.f16912b);
        boolean z = true;
        if (r8.f16916f) {
            boolean z2;
            if (r8.f16912b != 0) {
                for (TrackSelection trackSelection : trackSelectionArr2) {
                    if (trackSelection != null && !MimeTypes.m4212a(trackSelection.mo1462f().f4018f)) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                if (z2) {
                    z2 = true;
                    r8.f16916f = z2;
                }
            }
            z2 = false;
            r8.f16916f = z2;
        }
        if (a != j + r8.f16912b) {
            if (a >= r8.f16912b) {
                if (r8.f16913c != Long.MIN_VALUE) {
                    if (a <= r8.f16913c) {
                    }
                }
            }
            z = false;
        }
        Assertions.m4186b(z);
        while (i < sampleStreamArr2.length) {
            if (sampleStreamArr3[i] == null) {
                r8.f16915e[i] = null;
            } else if (sampleStreamArr2[i] == null || r8.f16915e[i].f13237d != sampleStreamArr3[i]) {
                r8.f16915e[i] = new ClippingSampleStream(r8, sampleStreamArr3[i], r8.f16912b, r8.f16913c, r8.f16916f);
            }
            sampleStreamArr2[i] = r8.f16915e[i];
            i++;
        }
        return a - r8.f16912b;
    }

    public final void mo3352a(long j) {
        this.f16911a.mo3352a(j + this.f16912b);
    }

    public final long mo3357c() {
        if (this.f16916f) {
            for (ClippingSampleStream clippingSampleStream : this.f16915e) {
                if (clippingSampleStream != null) {
                    clippingSampleStream.f13234a = false;
                }
            }
            this.f16916f = false;
            long c = mo3357c();
            return c != -9223372036854775807L ? c : 0;
        } else {
            long c2 = this.f16911a.mo3357c();
            if (c2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            boolean z = true;
            Assertions.m4186b(c2 >= this.f16912b);
            if (this.f16913c != Long.MIN_VALUE) {
                if (c2 > this.f16913c) {
                    z = false;
                }
            }
            Assertions.m4186b(z);
            return c2 - this.f16912b;
        }
    }

    public final long mo1402d() {
        long d = this.f16911a.mo1402d();
        if (d != Long.MIN_VALUE) {
            if (this.f16913c == Long.MIN_VALUE || d < this.f16913c) {
                return Math.max(0, d - this.f16912b);
            }
        }
        return Long.MIN_VALUE;
    }

    public final long mo3354b(long j) {
        boolean z = false;
        for (ClippingSampleStream clippingSampleStream : this.f16915e) {
            if (clippingSampleStream != null) {
                clippingSampleStream.f13235b = false;
            }
        }
        long b = this.f16911a.mo3354b(this.f16912b + j);
        if (b == j + this.f16912b || (b >= this.f16912b && (this.f16913c == Long.MIN_VALUE || b <= this.f16913c))) {
            z = true;
        }
        Assertions.m4186b(z);
        return b - this.f16912b;
    }

    public final long mo1403e() {
        long e = this.f16911a.mo1403e();
        if (e != Long.MIN_VALUE) {
            if (this.f16913c == Long.MIN_VALUE || e < this.f16913c) {
                return e - this.f16912b;
            }
        }
        return Long.MIN_VALUE;
    }

    public final boolean mo1401c(long j) {
        return this.f16911a.mo1401c(j + this.f16912b);
    }

    public final void mo3347a(MediaPeriod mediaPeriod) {
        mediaPeriod = (this.f16912b == -9223372036854775807L || this.f16913c == -9223372036854775807L) ? null : true;
        Assertions.m4186b(mediaPeriod);
        this.f16914d.mo3347a(this);
    }
}

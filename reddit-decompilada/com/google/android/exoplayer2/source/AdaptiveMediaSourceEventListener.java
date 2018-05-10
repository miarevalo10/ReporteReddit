package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.C0377C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public interface AdaptiveMediaSourceEventListener {

    public static final class EventDispatcher {
        public final Handler f4741a;
        public final AdaptiveMediaSourceEventListener f4742b;
        private final long f4743c;

        public EventDispatcher(Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
            this(handler, adaptiveMediaSourceEventListener, 0);
        }

        public EventDispatcher(Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, long j) {
            this.f4741a = adaptiveMediaSourceEventListener != null ? (Handler) Assertions.m4182a((Object) handler) : null;
            this.f4742b = adaptiveMediaSourceEventListener;
            this.f4743c = j;
        }

        public final void m3926a(DataSpec dataSpec, int i, long j) {
            m3923a(dataSpec, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j);
        }

        public final void m3923a(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
            if (this.f4742b != null) {
                Handler handler = r14.f4741a;
                final DataSpec dataSpec2 = dataSpec;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j4 = j;
                final long j5 = j2;
                C04081 c04081 = r0;
                final long j6 = j3;
                C04081 c040812 = new Runnable(r14) {
                    final /* synthetic */ EventDispatcher f4696j;

                    public void run() {
                        EventDispatcher.m3920a(this.f4696j, j4);
                        EventDispatcher.m3920a(this.f4696j, j5);
                    }
                };
                handler.post(c04081);
            }
        }

        public final void m3927a(DataSpec dataSpec, int i, long j, long j2, long j3) {
            m3924a(dataSpec, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public final void m3924a(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            if (this.f4742b != null) {
                final DataSpec dataSpec2 = dataSpec;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                C04092 c04092 = r0;
                final long j8 = j3;
                Handler handler = r14.f4741a;
                final long j9 = j4;
                final long j10 = j5;
                C04092 c040922 = new Runnable(r14) {
                    final /* synthetic */ EventDispatcher f4708l;

                    public void run() {
                        EventDispatcher.m3920a(this.f4708l, j6);
                        EventDispatcher.m3920a(this.f4708l, j7);
                    }
                };
                handler.post(c04092);
            }
        }

        public final void m3930b(DataSpec dataSpec, int i, long j, long j2, long j3) {
            m3929b(dataSpec, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public final void m3929b(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            if (this.f4742b != null) {
                final DataSpec dataSpec2 = dataSpec;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                C04103 c04103 = r0;
                final long j8 = j3;
                Handler handler = r14.f4741a;
                final long j9 = j4;
                final long j10 = j5;
                C04103 c041032 = new Runnable(r14) {
                    final /* synthetic */ EventDispatcher f4720l;

                    public void run() {
                        EventDispatcher.m3920a(this.f4720l, j6);
                        EventDispatcher.m3920a(this.f4720l, j7);
                    }
                };
                handler.post(c04103);
            }
        }

        public final void m3928a(DataSpec dataSpec, int i, long j, long j2, long j3, IOException iOException, boolean z) {
            m3925a(dataSpec, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
        }

        public final void m3925a(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            if (this.f4742b != null) {
                final DataSpec dataSpec2 = dataSpec;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                C04114 c04114 = r0;
                final long j8 = j3;
                Handler handler = r14.f4741a;
                final long j9 = j4;
                final long j10 = j5;
                final IOException iOException2 = iOException;
                final boolean z2 = z;
                C04114 c041142 = new Runnable(r14) {
                    final /* synthetic */ EventDispatcher f4734n;

                    public void run() {
                        AdaptiveMediaSourceEventListener a = this.f4734n.f4742b;
                        EventDispatcher.m3920a(this.f4734n, j6);
                        EventDispatcher.m3920a(this.f4734n, j7);
                        a.m3931a(iOException2);
                    }
                };
                handler.post(c04114);
            }
        }

        public final void m3922a(int i, Format format, int i2, Object obj, long j) {
            if (this.f4742b != null) {
                final int i3 = i;
                final Format format2 = format;
                final int i4 = i2;
                final Object obj2 = obj;
                final long j2 = j;
                r8.f4741a.post(new Runnable(r8) {
                    final /* synthetic */ EventDispatcher f4740f;

                    public void run() {
                        EventDispatcher.m3920a(this.f4740f, j2);
                    }
                });
            }
        }

        static /* synthetic */ long m3920a(EventDispatcher eventDispatcher, long j) {
            j = C0377C.m3539a(j);
            if (j == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return eventDispatcher.f4743c + j;
        }
    }

    void m3931a(IOException iOException);
}

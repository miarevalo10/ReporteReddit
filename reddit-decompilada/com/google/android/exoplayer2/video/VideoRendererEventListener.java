package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;

public interface VideoRendererEventListener {

    public static final class EventDispatcher {
        final Handler f5359a;
        final VideoRendererEventListener f5360b;

        class C04291 implements Runnable {
            final /* synthetic */ DecoderCounters f5339a;
            final /* synthetic */ EventDispatcher f5340b;

            C04291(EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
                this.f5340b = eventDispatcher;
                this.f5339a = decoderCounters;
            }

            public void run() {
                this.f5340b.f5360b.mo1290a(this.f5339a);
            }
        }

        class C04302 implements Runnable {
            final /* synthetic */ String f5341a;
            final /* synthetic */ long f5342b;
            final /* synthetic */ long f5343c;
            final /* synthetic */ EventDispatcher f5344d;

            C04302(EventDispatcher eventDispatcher, String str, long j, long j2) {
                this.f5344d = eventDispatcher;
                this.f5341a = str;
                this.f5342b = j;
                this.f5343c = j2;
            }

            public void run() {
                this.f5344d.f5360b.mo1292a(this.f5341a, this.f5342b, this.f5343c);
            }
        }

        class C04313 implements Runnable {
            final /* synthetic */ Format f5345a;
            final /* synthetic */ EventDispatcher f5346b;

            C04313(EventDispatcher eventDispatcher, Format format) {
                this.f5346b = eventDispatcher;
                this.f5345a = format;
            }

            public void run() {
                this.f5346b.f5360b.mo1289a(this.f5345a);
            }
        }

        class C04324 implements Runnable {
            final /* synthetic */ int f5347a;
            final /* synthetic */ long f5348b;
            final /* synthetic */ EventDispatcher f5349c;

            C04324(EventDispatcher eventDispatcher, int i, long j) {
                this.f5349c = eventDispatcher;
                this.f5347a = i;
                this.f5348b = j;
            }

            public void run() {
                this.f5349c.f5360b.mo1286a(this.f5347a, this.f5348b);
            }
        }

        public EventDispatcher(Handler handler, VideoRendererEventListener videoRendererEventListener) {
            this.f5359a = videoRendererEventListener != null ? (Handler) Assertions.m4182a((Object) handler) : null;
            this.f5360b = videoRendererEventListener;
        }

        public final void m4344a(int i, int i2, int i3, float f) {
            if (this.f5360b != null) {
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                final float f2 = f;
                this.f5359a.post(new Runnable(this) {
                    final /* synthetic */ EventDispatcher f5354e;

                    public void run() {
                        this.f5354e.f5360b.mo1285a(i4, i5, i6, f2);
                    }
                });
            }
        }

        public final void m4345a(final Surface surface) {
            if (this.f5360b != null) {
                this.f5359a.post(new Runnable(this) {
                    final /* synthetic */ EventDispatcher f5356b;

                    public void run() {
                        this.f5356b.f5360b.mo1288a(surface);
                    }
                });
            }
        }

        public final void m4346a(final DecoderCounters decoderCounters) {
            if (this.f5360b != null) {
                this.f5359a.post(new Runnable(this) {
                    final /* synthetic */ EventDispatcher f5358b;

                    public void run() {
                        decoderCounters.m3723a();
                        this.f5358b.f5360b.mo1295b(decoderCounters);
                    }
                });
            }
        }
    }

    void mo1285a(int i, int i2, int i3, float f);

    void mo1286a(int i, long j);

    void mo1288a(Surface surface);

    void mo1289a(Format format);

    void mo1290a(DecoderCounters decoderCounters);

    void mo1292a(String str, long j, long j2);

    void mo1295b(DecoderCounters decoderCounters);
}

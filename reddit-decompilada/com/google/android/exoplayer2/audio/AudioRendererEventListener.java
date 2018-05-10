package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;

public interface AudioRendererEventListener {

    public static final class EventDispatcher {
        final Handler f4121a;
        final AudioRendererEventListener f4122b;

        class C03811 implements Runnable {
            final /* synthetic */ DecoderCounters f4105a;
            final /* synthetic */ EventDispatcher f4106b;

            C03811(EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
                this.f4106b = eventDispatcher;
                this.f4105a = decoderCounters;
            }

            public void run() {
                this.f4106b.f4122b.mo1297c(this.f4105a);
            }
        }

        class C03822 implements Runnable {
            final /* synthetic */ String f4107a;
            final /* synthetic */ long f4108b;
            final /* synthetic */ long f4109c;
            final /* synthetic */ EventDispatcher f4110d;

            C03822(EventDispatcher eventDispatcher, String str, long j, long j2) {
                this.f4110d = eventDispatcher;
                this.f4107a = str;
                this.f4108b = j;
                this.f4109c = j2;
            }

            public void run() {
                this.f4110d.f4122b.mo1296b(this.f4107a, this.f4108b, this.f4109c);
            }
        }

        class C03833 implements Runnable {
            final /* synthetic */ Format f4111a;
            final /* synthetic */ EventDispatcher f4112b;

            C03833(EventDispatcher eventDispatcher, Format format) {
                this.f4112b = eventDispatcher;
                this.f4111a = format;
            }

            public void run() {
                this.f4112b.f4122b.mo1294b(this.f4111a);
            }
        }

        class C03844 implements Runnable {
            final /* synthetic */ int f4113a;
            final /* synthetic */ long f4114b;
            final /* synthetic */ long f4115c;
            final /* synthetic */ EventDispatcher f4116d;

            C03844(EventDispatcher eventDispatcher, int i, long j, long j2) {
                this.f4116d = eventDispatcher;
                this.f4113a = i;
                this.f4114b = j;
                this.f4115c = j2;
            }

            public void run() {
                this.f4116d.f4122b.mo1287a(this.f4113a, this.f4114b, this.f4115c);
            }
        }

        class C03866 implements Runnable {
            final /* synthetic */ int f4119a;
            final /* synthetic */ EventDispatcher f4120b;

            C03866(EventDispatcher eventDispatcher, int i) {
                this.f4120b = eventDispatcher;
                this.f4119a = i;
            }

            public void run() {
                this.f4120b.f4122b.mo1284a(this.f4119a);
            }
        }

        public EventDispatcher(Handler handler, AudioRendererEventListener audioRendererEventListener) {
            this.f4121a = audioRendererEventListener != null ? (Handler) Assertions.m4182a((Object) handler) : null;
            this.f4122b = audioRendererEventListener;
        }

        public final void m3658a(final DecoderCounters decoderCounters) {
            if (this.f4122b != null) {
                this.f4121a.post(new Runnable(this) {
                    final /* synthetic */ EventDispatcher f4118b;

                    public void run() {
                        decoderCounters.m3723a();
                        this.f4118b.f4122b.mo1298d(decoderCounters);
                    }
                });
            }
        }
    }

    void mo1284a(int i);

    void mo1287a(int i, long j, long j2);

    void mo1294b(Format format);

    void mo1296b(String str, long j, long j2);

    void mo1297c(DecoderCounters decoderCounters);

    void mo1298d(DecoderCounters decoderCounters);
}

package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource.Listener;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.Loader.ReleaseCallback;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ExtractorMediaSource implements Listener, MediaSource {
    private final Uri f13253a;
    private final Factory f13254b;
    private final ExtractorsFactory f13255c;
    private final int f13256d;
    private final Handler f13257e;
    private final EventListener f13258f;
    private final Period f13259g;
    private final String f13260h;
    private final int f13261i;
    private Listener f13262j;
    private long f13263k;
    private boolean f13264l;

    public interface EventListener {
        void m3934b(IOException iOException);
    }

    public final void mo1408a() throws IOException {
    }

    public ExtractorMediaSource(Uri uri, Factory factory, ExtractorsFactory extractorsFactory, Handler handler, EventListener eventListener) {
        this(uri, factory, extractorsFactory, handler, eventListener, (byte) 0);
    }

    private ExtractorMediaSource(Uri uri, Factory factory, ExtractorsFactory extractorsFactory, Handler handler, EventListener eventListener, byte b) {
        this(uri, factory, extractorsFactory, handler, eventListener, '\u0000');
    }

    private ExtractorMediaSource(Uri uri, Factory factory, ExtractorsFactory extractorsFactory, Handler handler, EventListener eventListener, char c) {
        this.f13253a = uri;
        this.f13254b = factory;
        this.f13255c = extractorsFactory;
        this.f13256d = -1;
        this.f13257e = handler;
        this.f13258f = eventListener;
        this.f13260h = null;
        this.f13261i = 1048576;
        this.f13259g = new Period();
    }

    public final void mo1410a(ExoPlayer exoPlayer, Listener listener) {
        this.f13262j = listener;
        m12319b(1, false);
    }

    public final MediaPeriod mo1407a(MediaPeriodId mediaPeriodId, Allocator allocator) {
        Assertions.m4184a(mediaPeriodId.f4752b == null ? true : null);
        return new ExtractorMediaPeriod(this.f13253a, this.f13254b.mo1475a(), this.f13255c.mo1342a(), this.f13256d, this.f13257e, this.f13258f, this, allocator, this.f13260h, this.f13261i);
    }

    public final void mo1411a(MediaPeriod mediaPeriod) {
        ReleaseCallback releaseCallback = (ExtractorMediaPeriod) mediaPeriod;
        boolean a = releaseCallback.f16926a.m12694a(releaseCallback);
        if (releaseCallback.f16929d && !a) {
            for (SampleQueue d : releaseCallback.f16928c) {
                d.m12361d();
            }
        }
        releaseCallback.f16927b.removeCallbacksAndMessages(null);
        releaseCallback.f16933h = true;
    }

    public final void mo1412b() {
        this.f13262j = null;
    }

    public final void mo1409a(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.f13263k;
        }
        if (!(this.f13263k == j && this.f13264l == z) && (this.f13263k == -9223372036854775807L || j != -9223372036854775807L)) {
            m12319b(j, z);
        }
    }

    private void m12319b(long j, boolean z) {
        this.f13263k = j;
        this.f13264l = z;
        this.f13262j.mo1413a(new SinglePeriodTimeline(this.f13263k, this.f13264l), false);
    }
}

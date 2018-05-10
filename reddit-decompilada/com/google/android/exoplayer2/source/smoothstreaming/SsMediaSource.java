package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C0377C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource.Listener;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower.Dummy;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;

public final class SsMediaSource implements MediaSource, Callback<ParsingLoadable<SsManifest>> {
    private final Uri f13514a;
    private final Factory f13515b;
    private final SsChunkSource.Factory f13516c;
    private final int f13517d;
    private final long f13518e;
    private final EventDispatcher f13519f;
    private final Parser<? extends SsManifest> f13520g;
    private final ArrayList<SsMediaPeriod> f13521h;
    private Listener f13522i;
    private DataSource f13523j;
    private Loader f13524k;
    private LoaderErrorThrower f13525l;
    private long f13526m;
    private SsManifest f13527n;
    private Handler f13528o;

    class C04191 implements Runnable {
        final /* synthetic */ SsMediaSource f4897a;

        C04191(SsMediaSource ssMediaSource) {
            this.f4897a = ssMediaSource;
        }

        public void run() {
            this.f4897a.m12580d();
        }
    }

    public final /* synthetic */ void mo1419a(Loadable loadable, long j, long j2) {
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        this.f13519f.m3927a(parsingLoadable.f13682a, parsingLoadable.f13683b, j, j2, parsingLoadable.f13685d);
        this.f13527n = (SsManifest) parsingLoadable.f13684c;
        this.f13526m = j - j2;
        m12579c();
        if (this.f13527n.f4919d != null) {
            this.f13528o.postDelayed(new C04191(this), Math.max(0, (this.f13526m + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    static {
        ExoPlayerLibraryInfo.m3553a("goog.exo.smoothstreaming");
    }

    public SsMediaSource(Uri uri, Factory factory, SsChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, factory2, handler, adaptiveMediaSourceEventListener, (byte) 0);
    }

    private SsMediaSource(Uri uri, Factory factory, SsChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, byte b) {
        this(uri, factory, new SsManifestParser(), factory2, handler, adaptiveMediaSourceEventListener);
    }

    private SsMediaSource(Uri uri, Factory factory, Parser<? extends SsManifest> parser, SsChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, parser, factory2, handler, adaptiveMediaSourceEventListener, (byte) 0);
    }

    private SsMediaSource(Uri uri, Factory factory, Parser<? extends SsManifest> parser, SsChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, byte b) {
        Assertions.m4186b((byte) 1);
        this.f13527n = null;
        if (uri == null) {
            uri = null;
        } else if (Util.m4323d(uri.getLastPathSegment()).equals("manifest") == (byte) 0) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.f13514a = uri;
        this.f13515b = factory;
        this.f13520g = parser;
        this.f13516c = factory2;
        this.f13517d = 3;
        this.f13518e = 30000;
        this.f13519f = new EventDispatcher(handler, adaptiveMediaSourceEventListener);
        this.f13521h = new ArrayList();
    }

    public final void mo1410a(ExoPlayer exoPlayer, Listener listener) {
        this.f13522i = listener;
        if (this.f13527n != null) {
            this.f13525l = new Dummy();
            m12579c();
            return;
        }
        this.f13523j = this.f13515b.mo1475a();
        this.f13524k = new Loader("Loader:Manifest");
        this.f13525l = this.f13524k;
        this.f13528o = new Handler();
        m12580d();
    }

    public final void mo1408a() throws IOException {
        this.f13525l.mo1477c();
    }

    public final MediaPeriod mo1407a(MediaPeriodId mediaPeriodId, Allocator allocator) {
        Assertions.m4184a(mediaPeriodId.f4752b == null ? true : null);
        MediaPeriodId ssMediaPeriod = new SsMediaPeriod(this.f13527n, this.f13516c, this.f13517d, this.f13519f, this.f13525l, allocator);
        this.f13521h.add(ssMediaPeriod);
        return ssMediaPeriod;
    }

    public final void mo1411a(MediaPeriod mediaPeriod) {
        for (ChunkSampleStream c : ((SsMediaPeriod) mediaPeriod).f17021c) {
            c.m12394c();
        }
        this.f13521h.remove(mediaPeriod);
    }

    public final void mo1412b() {
        this.f13522i = null;
        this.f13527n = null;
        this.f13523j = null;
        this.f13526m = 0;
        if (this.f13524k != null) {
            this.f13524k.m12694a(null);
            this.f13524k = null;
        }
        if (this.f13528o != null) {
            this.f13528o.removeCallbacksAndMessages(null);
            this.f13528o = null;
        }
    }

    private void m12579c() {
        SsMediaSource ssMediaSource = this;
        for (int i = 0; i < ssMediaSource.f13521h.size(); i++) {
            SsMediaPeriod ssMediaPeriod = (SsMediaPeriod) ssMediaSource.f13521h.get(i);
            SsManifest ssManifest = ssMediaSource.f13527n;
            ssMediaPeriod.f17020b = ssManifest;
            for (ChunkSampleStream chunkSampleStream : ssMediaPeriod.f17021c) {
                ((SsChunkSource) chunkSampleStream.f13327b).mo3376a(ssManifest);
            }
            ssMediaPeriod.f17019a.mo3348a(ssMediaPeriod);
        }
        long j = Long.MIN_VALUE;
        long j2 = Long.MAX_VALUE;
        for (StreamElement streamElement : ssMediaSource.f13527n.f4921f) {
            if (streamElement.f4910k > 0) {
                long min = Math.min(j2, streamElement.f4914o[0]);
                j = Math.max(j, streamElement.f4914o[streamElement.f4910k - 1] + streamElement.m4022a(streamElement.f4910k - 1));
                j2 = min;
            }
        }
        if (j2 == Long.MAX_VALUE) {
            Timeline singlePeriodTimeline = new SinglePeriodTimeline(ssMediaSource.f13527n.f4919d ? -9223372036854775807L : 0, 0, 0, 0, true, ssMediaSource.f13527n.f4919d);
        } else if (ssMediaSource.f13527n.f4919d) {
            if (ssMediaSource.f13527n.f4923h != -9223372036854775807L && ssMediaSource.f13527n.f4923h > 0) {
                j2 = Math.max(j2, j - ssMediaSource.f13527n.f4923h);
            }
            long j3 = j2;
            long j4 = j - j3;
            long b = j4 - C0377C.m3540b(ssMediaSource.f13518e);
            if (b < 5000000) {
                b = Math.min(5000000, j4 / 2);
            }
            Timeline singlePeriodTimeline2 = new SinglePeriodTimeline(-9223372036854775807L, j4, j3, b, true, true);
        } else {
            long j5 = ssMediaSource.f13527n.f4922g != -9223372036854775807L ? ssMediaSource.f13527n.f4922g : j - j2;
            Timeline singlePeriodTimeline3 = new SinglePeriodTimeline(j2 + j5, j5, j2, 0, true, false);
        }
        ssMediaSource.f13522i.mo1413a(r1, ssMediaSource.f13527n);
    }

    private void m12580d() {
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.f13523j, this.f13514a, 4, this.f13520g);
        this.f13519f.m3926a(parsingLoadable.f13682a, parsingLoadable.f13683b, this.f13524k.m12692a(parsingLoadable, this, this.f13517d));
    }
}

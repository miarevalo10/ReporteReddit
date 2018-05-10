package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
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
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.Loader.ReleaseCallback;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.List;

public final class HlsMediaSource implements MediaSource, PrimaryPlaylistListener {
    private final Uri f13401a;
    private final HlsDataSourceFactory f13402b;
    private final int f13403c;
    private final EventDispatcher f13404d;
    private HlsPlaylistTracker f13405e;
    private Listener f13406f;

    static {
        ExoPlayerLibraryInfo.m3553a("goog.exo.hls");
    }

    public HlsMediaSource(Uri uri, Factory factory, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, handler, adaptiveMediaSourceEventListener, (byte) 0);
    }

    private HlsMediaSource(Uri uri, Factory factory, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, byte b) {
        this(uri, new DefaultHlsDataSourceFactory(factory), handler, adaptiveMediaSourceEventListener);
    }

    private HlsMediaSource(Uri uri, HlsDataSourceFactory hlsDataSourceFactory, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this.f13401a = uri;
        this.f13402b = hlsDataSourceFactory;
        this.f13403c = 3;
        this.f13404d = new EventDispatcher(handler, adaptiveMediaSourceEventListener);
    }

    public final void mo1410a(ExoPlayer exoPlayer, Listener listener) {
        Assertions.m4186b(this.f13405e == null ? true : null);
        this.f13405e = new HlsPlaylistTracker(this.f13401a, this.f13402b, this.f13404d, this.f13403c, this);
        this.f13406f = listener;
        exoPlayer = this.f13405e;
        exoPlayer.f13506h.m12692a(new ParsingLoadable(exoPlayer.f13500b.mo1438a(), exoPlayer.f13499a, 4, exoPlayer.f13501c), exoPlayer, exoPlayer.f13502d);
    }

    public final void mo1408a() throws IOException {
        HlsPlaylistTracker hlsPlaylistTracker = this.f13405e;
        hlsPlaylistTracker.f13506h.mo1477c();
        if (hlsPlaylistTracker.f13508j != null) {
            hlsPlaylistTracker.m12575b(hlsPlaylistTracker.f13508j);
        }
    }

    public final MediaPeriod mo1407a(MediaPeriodId mediaPeriodId, Allocator allocator) {
        Assertions.m4184a(mediaPeriodId.f4752b == null ? true : null);
        return new HlsMediaPeriod(this.f13405e, this.f13402b, this.f13403c, this.f13404d, allocator);
    }

    public final void mo1411a(MediaPeriod mediaPeriod) {
        HlsMediaPeriod hlsMediaPeriod = (HlsMediaPeriod) mediaPeriod;
        hlsMediaPeriod.f16997a.f13505g.remove(hlsMediaPeriod);
        hlsMediaPeriod.f16998b.removeCallbacksAndMessages(null);
        for (ReleaseCallback releaseCallback : hlsMediaPeriod.f16999c) {
            boolean a = releaseCallback.f13415c.m12694a(releaseCallback);
            if (releaseCallback.f13421i && !a) {
                for (SampleQueue d : releaseCallback.f13419g) {
                    d.m12361d();
                }
            }
            releaseCallback.f13418f.removeCallbacksAndMessages(null);
            releaseCallback.f13425m = true;
        }
    }

    public final void mo1412b() {
        if (this.f13405e != null) {
            HlsPlaylistTracker hlsPlaylistTracker = this.f13405e;
            hlsPlaylistTracker.f13506h.m12694a(null);
            for (MediaPlaylistBundle mediaPlaylistBundle : hlsPlaylistTracker.f13503e.values()) {
                mediaPlaylistBundle.f13488a.m12694a(null);
            }
            hlsPlaylistTracker.f13504f.removeCallbacksAndMessages(null);
            hlsPlaylistTracker.f13503e.clear();
            this.f13405e = null;
        }
        this.f13406f = null;
    }

    public final void mo1439a(HlsMediaPlaylist hlsMediaPlaylist) {
        Timeline singlePeriodTimeline;
        HlsMediaSource hlsMediaSource = this;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        long j = hlsMediaPlaylist2.f13462k ? 0 : -9223372036854775807L;
        long a = hlsMediaPlaylist2.f13462k ? C0377C.m3539a(hlsMediaPlaylist2.f13454c) : -9223372036854775807L;
        long j2 = hlsMediaPlaylist2.f13453b;
        if (hlsMediaSource.f13405e.f13509k) {
            long j3;
            long j4 = hlsMediaPlaylist2.f13461j ? hlsMediaPlaylist2.f13454c + hlsMediaPlaylist2.f13465n : -9223372036854775807L;
            List list = hlsMediaPlaylist2.f13464m;
            if (j2 == -9223372036854775807L) {
                long j5;
                if (list.isEmpty()) {
                    j5 = 0;
                } else {
                    j5 = ((Segment) list.get(Math.max(0, list.size() - 3))).f4884d;
                }
                j3 = j5;
            } else {
                j3 = j2;
            }
            singlePeriodTimeline = new SinglePeriodTimeline(j, a, j4, hlsMediaPlaylist2.f13465n, hlsMediaPlaylist2.f13454c, j3, true, hlsMediaPlaylist2.f13461j ^ 1);
        } else {
            Timeline singlePeriodTimeline2 = new SinglePeriodTimeline(j, a, hlsMediaPlaylist2.f13454c + hlsMediaPlaylist2.f13465n, hlsMediaPlaylist2.f13465n, hlsMediaPlaylist2.f13454c, j2 == -9223372036854775807L ? 0 : j2, true, false);
        }
        hlsMediaSource.f13406f.mo1413a(singlePeriodTimeline, new HlsManifest(hlsMediaSource.f13405e.f13507i, hlsMediaPlaylist2));
    }
}

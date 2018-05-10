package com.reddit.frontpage.widgets.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.view.Surface;
import com.danikula.videocache.HttpProxyCacheServer;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayer.EventListener;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.instabug.chat.model.Attachment;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.RedditVideo;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.BaseEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerChangePageTypeEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerEvent.VideoPlayerPayload;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerFullScreenEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerMuteEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerOverflowEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerPauseEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerPlayEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerReplayEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerRotateFullScreenEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerSaveEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerScrollActivatedEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerScrollAutoPlayEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerScrollPauseClosedEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerScrollPauseEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerSeekEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerServedVideoEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerUnmuteEvent;
import com.reddit.frontpage.video.proxy.DashProxy;
import java.math.BigInteger;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import timber.log.Timber;

public class VideoPlayer {
    private static final DefaultBandwidthMeter f22208h = new DefaultBandwidthMeter();
    private static final SimpleArrayMap<String, VideoPlayer> f22209i = new SimpleArrayMap();
    private static final CookieManager f22210j;
    private long f22211A = 0;
    private long f22212B = 0;
    private int f22213C;
    private Long f22214D;
    private Long f22215E = null;
    private final EventListener f22216F = new C27051(this);
    private final VideoRendererEventListener f22217G = new C23872(this);
    private final AudioRendererEventListener f22218H = new C23883(this);
    final String f22219a;
    String f22220b;
    public SimpleExoPlayer f22221c;
    SurfaceTexture f22222d;
    public boolean f22223e;
    public long f22224f = 0;
    @Inject
    HttpProxyCacheServer f22225g;
    private final Context f22226k;
    private final String f22227l;
    private String f22228m;
    private final Handler f22229n;
    private DefaultTrackSelector f22230o;
    private EventLogger f22231p;
    private int f22232q;
    private boolean f22233r;
    private boolean f22234s = true;
    private Factory f22235t;
    private Set<VideoListener> f22236u;
    private Link f22237v;
    private String f22238w;
    private long f22239x;
    private String f22240y;
    private long f22241z = 0;

    public interface VideoListener {
        void mo4999a();

        void mo5000a(int i, int i2);

        void mo5001a(boolean z, int i);
    }

    class C23872 implements VideoRendererEventListener {
        final /* synthetic */ VideoPlayer f29556a;

        C23872(VideoPlayer videoPlayer) {
            this.f29556a = videoPlayer;
        }

        public final void m30556a(DecoderCounters decoderCounters) {
            Timber.a("videoEnabled, id [%s]", new Object[]{this.f29556a.f22227l});
        }

        public final void m30557a(String str, long j, long j2) {
            Timber.a("videoDecoderInitialized [%s], id [%s]", new Object[]{str, this.f29556a.f22227l});
        }

        public final void m30555a(Format format) {
            Timber.a("videoFormatChanged [%s], id [%s]", new Object[]{Format.a(format), this.f29556a.f22227l});
        }

        public final void m30553a(int i, long j) {
            Timber.a("droppedFrames [%d], id [%s]", new Object[]{Integer.valueOf(i), this.f29556a.f22227l});
        }

        public final void m30552a(int i, int i2, int i3, float f) {
            Timber.a("onVideoSizeChanged, width [%d], height [%d], id[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this.f29556a.f22227l});
            if (this.f29556a.f22236u != 0 && this.f29556a.f22236u.isEmpty() == 0) {
                for (VideoListener a : this.f29556a.f22236u) {
                    a.mo5000a(i, i2);
                }
            }
        }

        public final void m30554a(Surface surface) {
            Timber.a("onRenderedFirstFrame, id [%s]", new Object[]{this.f29556a.f22227l});
            if (this.f29556a.f22236u != null && this.f29556a.f22236u.isEmpty() == null) {
                for (VideoListener a : this.f29556a.f22236u) {
                    a.mo4999a();
                }
            }
        }

        public final void m30558b(DecoderCounters decoderCounters) {
            Timber.a("onVideoDisabled, id [%s]", new Object[]{this.f29556a.f22227l});
        }
    }

    class C23883 implements AudioRendererEventListener {
        final /* synthetic */ VideoPlayer f29557a;

        C23883(VideoPlayer videoPlayer) {
            this.f29557a = videoPlayer;
        }

        public final void m30563c(DecoderCounters decoderCounters) {
            Timber.a("audioEnabled, id [%s]", new Object[]{this.f29557a.f22227l});
            VideoPlayer.m24351f(this.f29557a);
        }

        public final void m30559a(int i) {
            Timber.a("audioSessionId [%d], id [%s]", new Object[]{Integer.valueOf(i), this.f29557a.f22227l});
        }

        public final void m30562b(String str, long j, long j2) {
            Timber.a("audioDecoderInitialized [%s], id [%s]", new Object[]{str, this.f29557a.f22227l});
        }

        public final void m30561b(Format format) {
            Timber.a("audioFormatChanged [%s], id [%s]", new Object[]{Format.a(format), this.f29557a.f22227l});
        }

        public final void m30560a(int i, long j, long j2) {
            Timber.a("onAudioTrackUnderrun, buffer size [%d], buffer millis [%d], elapsed millis [%d], id [%s]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), this.f29557a.f22227l});
        }

        public final void m30564d(DecoderCounters decoderCounters) {
            Timber.a("audioDisabled, id [%s]", new Object[]{this.f29557a.f22227l});
        }
    }

    class ScrubLoadControl implements LoadControl {
        final /* synthetic */ VideoPlayer f29558a;
        private final DefaultAllocator f29559b = new DefaultAllocator();

        public final void m30565a() {
        }

        public final boolean m30567a(long j) {
            return true;
        }

        public final boolean m30568a(long j, boolean z) {
            return j >= 60000;
        }

        public final void m30569b() {
        }

        public final void m30570c() {
        }

        ScrubLoadControl(VideoPlayer videoPlayer) {
            this.f29558a = videoPlayer;
        }

        public final void m30566a(Renderer[] rendererArr, TrackSelectionArray trackSelectionArray) {
            int i = 0;
            int i2 = 0;
            while (i < rendererArr.length) {
                if (trackSelectionArray.b[i] != null) {
                    i2 += Util.d(rendererArr[i].a());
                }
                i++;
            }
            this.f29559b.a(i2);
        }

        public final Allocator m30571d() {
            return this.f29559b;
        }
    }

    public static abstract class VideoListenerAdapter implements VideoListener {
        public void mo4999a() {
        }

        public void mo5000a(int i, int i2) {
        }

        public void mo5001a(boolean z, int i) {
        }
    }

    class C27051 implements EventListener {
        final /* synthetic */ VideoPlayer f34573a;

        C27051(VideoPlayer videoPlayer) {
            this.f34573a = videoPlayer;
        }

        public final void m35398a(Timeline timeline) {
            Timber.a("onTimelineChanged, id [%s]", new Object[]{this.f34573a.f22227l});
        }

        public final void m35399a(TrackSelectionArray trackSelectionArray) {
            Timber.a("onTracksChanged, id [%s]", new Object[]{this.f34573a.f22227l});
        }

        public final void m35400a(boolean z) {
            Timber.a("onLoadingChanged, id [%s]", new Object[]{this.f34573a.f22227l});
        }

        public final void m35401a(boolean z, int i) {
            Iterator it;
            if (this.f34573a.f22221c != null) {
                this.f34573a.f22239x = Math.max(this.f34573a.f22239x, this.f34573a.f22221c.f());
            }
            switch (i) {
                case 1:
                    Timber.b("Player [%s] state changed: IDLE", new Object[]{this.f34573a.f22227l});
                    break;
                case 2:
                    Timber.b("Player [%s] state changed: BUFFERING", new Object[]{this.f34573a.f22227l});
                    if (this.f34573a.f22214D == null) {
                        this.f34573a.f22214D = Long.valueOf(System.currentTimeMillis());
                        break;
                    }
                    break;
                case 3:
                    Timber.b("Player [%s] state changed: READY, should play [%s]", new Object[]{this.f34573a.f22227l, Boolean.valueOf(z)});
                    if (this.f34573a.f22215E == null) {
                        this.f34573a.f22215E = Long.valueOf(System.currentTimeMillis() - this.f34573a.f22214D.longValue());
                    }
                    VideoPlayer.m24351f(this.f34573a);
                    break;
                case 4:
                    Timber.b("Player [%s] state changed: ENDED", new Object[]{this.f34573a.f22227l});
                    if (!(this.f34573a.f22236u == null || this.f34573a.f22236u.isEmpty())) {
                        it = this.f34573a.f22236u.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                        break;
                    }
                default:
                    break;
            }
            if (this.f34573a.f22236u != null) {
                for (VideoListener a : this.f34573a.f22236u) {
                    a.mo5001a(z, i);
                }
            }
        }

        public final void m35397a(ExoPlaybackException exoPlaybackException) {
            Timber.e("onPlayerError, error [%s], id [%s]", new Object[]{exoPlaybackException.getMessage(), this.f34573a.f22227l});
        }

        public final void m35396a() {
            if (PlaybackProgressView.getBeforeProgressChangeMills() > 0 && this.f34573a.f22221c != null) {
                this.f34573a.f22241z = this.f34573a.f22241z + (this.f34573a.f22221c.f() - PlaybackProgressView.getBeforeProgressChangeMills());
            }
            int d = this.f34573a.f22221c.d();
            if (d > 0) {
                this.f34573a.f22239x = (this.f34573a.f22221c.e() * ((long) d)) + this.f34573a.f22221c.f();
            }
            if (this.f34573a.f22221c.f() == this.f34573a.f22221c.e()) {
                this.f34573a.f22213C = this.f34573a.f22213C + 1;
            }
            if (this.f34573a.f22213C > 0 && d == 0) {
                this.f34573a.f22239x = (this.f34573a.f22221c.e() * ((long) this.f34573a.f22213C)) + this.f34573a.f22221c.f();
            }
        }
    }

    static {
        CookieManager cookieManager = new CookieManager();
        f22210j = cookieManager;
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
    }

    public static VideoPlayer m24336a(Context context, String str, String str2) {
        context = m24348c(context, str, str2);
        context.m24345b((boolean) null);
        m24356k(context);
        return context;
    }

    public static VideoPlayer m24343b(Context context, String str, String str2) {
        context = m24348c(context, str, str2);
        context.m24345b(true);
        m24356k(context);
        return context;
    }

    public static VideoPlayer m24338a(String str) {
        Timber.b("Get player for id [%s]", new Object[]{str});
        VideoPlayer videoPlayer = (VideoPlayer) f22209i.get(str);
        if (videoPlayer == null) {
            Timber.b("No instance of player for id [%s]", new Object[]{str});
        } else {
            Timber.b("Existing player for id [%s], instances [%d]", new Object[]{str, Integer.valueOf(f22209i.size())});
        }
        return videoPlayer;
    }

    public static VideoPlayer m24337a(ExoPlayer exoPlayer) {
        for (int i = 0; i < f22209i.size(); i++) {
            VideoPlayer videoPlayer = (VideoPlayer) f22209i.get(f22209i.b(i));
            if (videoPlayer != null && videoPlayer.f22221c == exoPlayer) {
                return videoPlayer;
            }
        }
        return null;
    }

    public final void m24361a(String str, String str2, boolean z) {
        String str3 = str;
        int i = 2;
        Timber.b("Set video URL [%s] for player [%s]", new Object[]{str3, this.f22227l});
        this.f22228m = str2;
        this.f22234s = z;
        if (str3 != null && !str3.equals(r0.f22220b)) {
            MediaSource hlsMediaSource;
            r0.f22220b = str3;
            if (r0.f22235t == null) {
                r0.f22235t = m24347c(true);
            }
            Uri parse = Uri.parse(str);
            r0.f22232q = Util.i(parse.getLastPathSegment());
            MediaSource dashMediaSource;
            switch (r0.f22232q) {
                case 0:
                    dashMediaSource = new DashMediaSource(Uri.parse(DashProxy.m30475a(parse.toString())), m24347c(false), new DefaultDashChunkSource.Factory(r0.f22235t), r0.f22229n, r0.f22231p);
                    break;
                case 1:
                    dashMediaSource = new SsMediaSource(parse, m24347c(false), new DefaultSsChunkSource.Factory(r0.f22235t), r0.f22229n, r0.f22231p);
                    break;
                case 2:
                    hlsMediaSource = new HlsMediaSource(parse, r0.f22235t, r0.f22229n, r0.f22231p);
                    break;
                case 3:
                    if (r0.f22234s && !parse.toString().startsWith("/storage")) {
                        parse = Uri.parse(r0.f22225g.a(parse.toString(), true));
                    }
                    MediaSource extractorMediaSource = new ExtractorMediaSource(parse, r0.f22235t, new DefaultExtractorsFactory(), r0.f22229n, r0.f22231p);
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unsupported type: ");
                    stringBuilder.append(r0.f22232q);
                    throw new IllegalStateException(stringBuilder.toString());
            }
            SimpleExoPlayer simpleExoPlayer = r0.f22221c;
            if (!r0.f22234s) {
                i = 0;
            }
            simpleExoPlayer.a(i);
            if (r0.f22221c != null) {
                r0.f22221c.a(hlsMediaSource, true, false);
            }
        }
    }

    public final String m24357a() {
        return this.f22228m != null ? this.f22228m : this.f22220b;
    }

    public final void m24362a(boolean z) {
        String str = "Setting audio %s";
        Object[] objArr = new Object[1];
        objArr[0] = z ? ModEventBuilder.f27453d : "unmuted";
        Timber.b(str, objArr);
        if (z != this.f22223e) {
            if (this.f22221c != null) {
                this.f22221c.a(z ? 0.0f : 1.0f);
            } else {
                this.f22233r = z;
            }
            this.f22223e = z;
        }
    }

    public final void m24359a(Link link, String str, String str2) {
        this.f22237v = link;
        this.f22238w = str;
        this.f22240y = str2;
    }

    private static VideoPlayer m24348c(Context context, String str, String str2) {
        Timber.b("New player for id [%s]", new Object[]{str});
        return new VideoPlayer(context, str, str2);
    }

    public final void m24363b() {
        m24362a(this.f22223e ^ 1);
    }

    public final void m24366c() {
        Timber.b("Start playback for player [%s]", new Object[]{this.f22227l});
        if (this.f22221c != null) {
            this.f22221c.a(true);
        }
    }

    public final void m24368d() {
        Timber.b("Pause playback for player [%s]", new Object[]{this.f22227l});
        if (this.f22221c != null) {
            this.f22221c.a(false);
        }
    }

    public final void m24358a(long j) {
        if (this.f22221c != null) {
            this.f22221c.a(j);
        }
    }

    public final long m24369e() {
        return this.f22221c != null ? this.f22221c.e() : 0;
    }

    public final boolean m24365b(String str) {
        if (this.f22219a.equals(str)) {
            Timber.b("Release player for owner [%s], id [%s]", new Object[]{str, this.f22227l});
            Timber.b("ReleaseInternal, releasing player for [%s]", new Object[]{this.f22227l});
            if (this.f22221c != null) {
                this.f22221c.c();
                this.f22221c = null;
                this.f22230o = null;
                this.f22231p = null;
                this.f22220b = null;
                f22209i.remove(this.f22227l);
                Timber.b("Release player [%s], instances [%s]", new Object[]{this.f22227l, Integer.valueOf(f22209i.size())});
            } else {
                Timber.d("Player is null for player [%s]", new Object[]{this.f22227l});
            }
            this.f22236u = null;
            if (this.f22222d != null) {
                Timber.b("Release surface texture for owner [%s]", new Object[]{this.f22219a});
                this.f22222d.release();
                this.f22222d = null;
            }
            return true;
        }
        Timber.b("Not Releasing player for id [%s] as [%s] is not owner", new Object[]{this.f22227l, str});
        return false;
    }

    public final boolean m24370f() {
        if (!TextUtils.isEmpty(this.f22220b)) {
            boolean z = (TextUtils.isEmpty(this.f22220b) || this.f22232q == 3) ? false : true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void m24360a(VideoListener videoListener) {
        if (this.f22236u == null) {
            this.f22236u = new HashSet();
        }
        this.f22236u.add(videoListener);
    }

    public final void m24364b(VideoListener videoListener) {
        if (this.f22236u != null) {
            this.f22236u.remove(videoListener);
        }
    }

    public final boolean m24371g() {
        String str = "Is playing: [%s]";
        Object[] objArr = new Object[1];
        boolean z = this.f22221c != null && this.f22221c.b();
        objArr[0] = Boolean.valueOf(z);
        Timber.b(str, objArr);
        return this.f22221c != null && this.f22221c.b();
    }

    public final long m24372h() {
        return this.f22221c != null ? this.f22221c.f() : 0;
    }

    public final int m24373i() {
        return this.f22221c != null ? this.f22221c.a() : 1;
    }

    public final boolean m24374j() {
        return this.f22221c == null;
    }

    private VideoPlayer(Context context, String str, String str2) {
        FrontpageApplication.m28870f().mo4700a(this);
        this.f22226k = context;
        this.f22227l = str;
        this.f22219a = str2;
        this.f22229n = new Handler();
        if (CookieHandler.getDefault() != f22210j) {
            CookieHandler.setDefault(f22210j);
        }
    }

    private void m24345b(boolean z) {
        this.f22230o = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(f22208h));
        this.f22221c = ExoPlayerFactory.a(this.f22226k, this.f22230o, z ? new ScrubLoadControl(this) : new DefaultLoadControl());
        this.f22221c.a(this.f22216F);
        this.f22221c.e = this.f22217G;
        this.f22221c.d = this.f22218H;
    }

    private static void m24356k(VideoPlayer videoPlayer) {
        f22209i.put(videoPlayer.f22227l, videoPlayer);
        Timber.b("New instance player for id [%s] owner [%s], instances [%d]", new Object[]{videoPlayer.f22227l, videoPlayer.f22219a, Integer.valueOf(f22209i.size())});
    }

    private Factory m24347c(boolean z) {
        if (z) {
            z = f22208h;
        } else {
            z = false;
        }
        return new DefaultDataSourceFactory(this.f22226k, z, new DefaultHttpDataSourceFactory(Config.b, z));
    }

    public final void m24367c(String str) {
        String str2 = str;
        if (this.f22221c != null) {
            if (r1.f22237v != null) {
                BaseEvent videoPlayerPlayEvent;
                int i = -1;
                switch (str.hashCode()) {
                    case -1765388797:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_ACTIVATED)) {
                            i = 13;
                            break;
                        }
                        break;
                    case -1006754816:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_PAUSE)) {
                            i = 10;
                            break;
                        }
                        break;
                    case -310130919:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_AUTOPLAY)) {
                            i = 11;
                            break;
                        }
                        break;
                    case 57243770:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_CLICK_REPLAY)) {
                            i = 9;
                            break;
                        }
                        break;
                    case 136645589:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_CLICK_OVERFLOW)) {
                            i = 5;
                            break;
                        }
                        break;
                    case 151362757:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_CLICK_UNMUTE)) {
                            i = 4;
                            break;
                        }
                        break;
                    case 335121260:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_CLICK_MUTE)) {
                            i = 3;
                            break;
                        }
                        break;
                    case 335201415:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_CLICK_PLAY)) {
                            i = 0;
                            break;
                        }
                        break;
                    case 335280848:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_CLICK_SAVE)) {
                            i = 6;
                            break;
                        }
                        break;
                    case 335284171:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_CLICK_SEEK)) {
                            i = 2;
                            break;
                        }
                        break;
                    case 397159118:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_CLICK_FULLSCREEN)) {
                            i = 7;
                            break;
                        }
                        break;
                    case 566133372:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_CHANGE_PAGETYPE)) {
                            i = 12;
                            break;
                        }
                        break;
                    case 763717881:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_PAUSE_CLOSED)) {
                            i = 14;
                            break;
                        }
                        break;
                    case 1644673187:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_ROTATE_FULLSCREEN)) {
                            i = 8;
                            break;
                        }
                        break;
                    case 1801000707:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_CLICK_PAUSE)) {
                            i = 1;
                            break;
                        }
                        break;
                    case 2107927789:
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_SERVED_VIDEO)) {
                            i = 15;
                            break;
                        }
                        break;
                    default:
                        break;
                }
                switch (i) {
                    case 0:
                        videoPlayerPlayEvent = new VideoPlayerPlayEvent();
                        break;
                    case 1:
                        videoPlayerPlayEvent = new VideoPlayerPauseEvent();
                        break;
                    case 2:
                        videoPlayerPlayEvent = new VideoPlayerSeekEvent();
                        break;
                    case 3:
                        videoPlayerPlayEvent = new VideoPlayerMuteEvent();
                        break;
                    case 4:
                        videoPlayerPlayEvent = new VideoPlayerUnmuteEvent();
                        break;
                    case 5:
                        videoPlayerPlayEvent = new VideoPlayerOverflowEvent();
                        break;
                    case 6:
                        videoPlayerPlayEvent = new VideoPlayerSaveEvent();
                        break;
                    case 7:
                        videoPlayerPlayEvent = new VideoPlayerFullScreenEvent();
                        break;
                    case 8:
                        videoPlayerPlayEvent = new VideoPlayerRotateFullScreenEvent();
                        break;
                    case 9:
                        videoPlayerPlayEvent = new VideoPlayerReplayEvent();
                        break;
                    case 10:
                        videoPlayerPlayEvent = new VideoPlayerScrollPauseEvent();
                        break;
                    case 11:
                        videoPlayerPlayEvent = new VideoPlayerScrollAutoPlayEvent();
                        break;
                    case 12:
                        videoPlayerPlayEvent = new VideoPlayerChangePageTypeEvent();
                        break;
                    case 13:
                        videoPlayerPlayEvent = new VideoPlayerScrollActivatedEvent();
                        break;
                    case 14:
                        videoPlayerPlayEvent = new VideoPlayerScrollPauseClosedEvent();
                        break;
                    case 15:
                        videoPlayerPlayEvent = new VideoPlayerServedVideoEvent();
                        break;
                    default:
                        return;
                }
                try {
                    VideoPlayerPayload videoPlayerPayload = (VideoPlayerPayload) videoPlayerPlayEvent.payload;
                    videoPlayerPayload.base_url = r1.f22237v.getPermalink();
                    videoPlayerPayload.listing_name = r1.f22240y;
                    if (r1.f22239x / 1000 == r1.f22221c.e() / 1000 && videoPlayerPayload.max_timestamp_served == 0) {
                        r1.f22239x = 0;
                    }
                    if (r1.f22224f == r1.f22221c.e() && r1.f22221c.f() < r1.f22224f) {
                        r1.f22224f = 0;
                    }
                    videoPlayerPayload.max_timestamp_served = Math.max(0, Math.max(r1.f22221c.f(), r1.f22239x) - r1.f22224f);
                    if (r1.f22241z > 0) {
                        r1.f22212B += Math.abs(r1.f22241z);
                    } else {
                        r1.f22211A += Math.abs(r1.f22241z);
                    }
                    r1.f22241z = 0;
                    PlaybackProgressView.m24274a();
                    if (videoPlayerPlayEvent instanceof VideoPlayerServedVideoEvent) {
                        videoPlayerPayload.max_timestamp_served += r1.f22211A - r1.f22212B;
                        r1.f22211A = 0;
                        r1.f22212B = 0;
                        if (videoPlayerPayload.max_timestamp_served == 0) {
                            return;
                        }
                    }
                    videoPlayerPayload.nsfw = r1.f22237v.isNsfw();
                    videoPlayerPayload.page_type = r1.f22238w;
                    Object obj = null;
                    RedditVideo redditVideo = r1.f22237v.getMedia() != null ? r1.f22237v.getMedia().getRedditVideo() : null;
                    long duration = redditVideo != null ? ((long) redditVideo.getDuration()) * 1000 : r1.f22237v instanceof ClientLink ? ((ClientLink) r1.f22237v).getVideoDuration() * 1000 : 0;
                    if (duration > 0) {
                        videoPlayerPayload.percent_served = ((float) videoPlayerPayload.max_timestamp_served) / ((float) duration);
                        videoPlayerPayload.video_duration = duration;
                    }
                    videoPlayerPayload.spoiler = r1.f22237v.isSpoiler();
                    if (r1.f22237v.getSubredditDetail() != null) {
                        boolean z;
                        String name = r1.f22237v.getSubredditDetail().getName();
                        if (name != null) {
                            int indexOf = name.indexOf(95);
                            if (indexOf >= 0) {
                                name = name.substring(indexOf + 1);
                            }
                            videoPlayerPayload.sr_id = new BigInteger(name, 36).longValue();
                        }
                        videoPlayerPayload.sr_fullname = r1.f22237v.getSubredditDetail().getName();
                        videoPlayerPayload.sr_name = r1.f22237v.getSubredditDetail().display_name_prefixed.substring(2);
                        videoPlayerPayload.target_author_name = r1.f22237v.getAuthor();
                        videoPlayerPayload.target_created_ts = r1.f22237v.getCreatedUtc();
                        videoPlayerPayload.target_id = new BigInteger(r1.f22237v.getId(), 36).longValue();
                        videoPlayerPayload.target_fullname = r1.f22237v.getName();
                        videoPlayerPayload.target_url = r1.f22237v.getUrl();
                        videoPlayerPayload.target_url_domain = r1.f22237v.getDomain();
                        videoPlayerPayload.target_type = r1.f22237v.isGif() ? "gif" : Attachment.TYPE_VIDEO;
                        if (!SessionManager.b().c.isAnonymous()) {
                            videoPlayerPayload.user_name = SessionManager.b().c.getUsername();
                            Account account = (Account) AccountStorage.b.a(videoPlayerPayload.user_name);
                            if (account != null) {
                                obj = account.getId();
                            }
                        }
                        if (!TextUtils.isEmpty(obj)) {
                            videoPlayerPayload.user_id = new BigInteger(obj, 36).longValue();
                        }
                        if (redditVideo != null) {
                            videoPlayerPayload.vertical = redditVideo.getHeight() > redditVideo.getWidth();
                        } else if (r1.f22237v instanceof ClientLink) {
                            videoPlayerPayload.vertical = ((ClientLink) r1.f22237v).getVideoHeight() > ((ClientLink) r1.f22237v).getVideoWidth();
                        }
                        videoPlayerPayload.video_time = r1.f22221c.f();
                        String url = r1.f22237v.getUrl();
                        if (url != null) {
                            int lastIndexOf = url.lastIndexOf(47);
                            if (lastIndexOf >= 0 && lastIndexOf < url.length() - 1) {
                                videoPlayerPayload.media_id = url.substring(lastIndexOf + 1);
                            }
                        }
                        if (!str2.equals(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_ACTIVATED)) {
                            if (!str2.equals(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_PAUSE)) {
                                z = false;
                                videoPlayerPayload.pinned_player = z;
                                videoPlayerPayload.load_time = r1.f22215E == null ? r1.f22215E.longValue() : System.currentTimeMillis() - r1.f22214D.longValue();
                                videoPlayerPayload.video_first_frame = r1.f22215E;
                                Timber.a("VideoPlayer Analytics [%s] %s", new Object[]{str2, videoPlayerPayload});
                                if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_SERVED_VIDEO) || videoPlayerPayload.max_timestamp_served >= 100) {
                                    AppAnalytics.m21854a(videoPlayerPlayEvent);
                                    return;
                                }
                                return;
                            }
                        }
                        z = true;
                        videoPlayerPayload.pinned_player = z;
                        if (r1.f22215E == null) {
                        }
                        videoPlayerPayload.load_time = r1.f22215E == null ? r1.f22215E.longValue() : System.currentTimeMillis() - r1.f22214D.longValue();
                        videoPlayerPayload.video_first_frame = r1.f22215E;
                        Timber.a("VideoPlayer Analytics [%s] %s", new Object[]{str2, videoPlayerPayload});
                        if (str2.equals(VideoPlayerEvent.VIDEO_PLAYER_SERVED_VIDEO)) {
                        }
                        AppAnalytics.m21854a(videoPlayerPlayEvent);
                        return;
                    }
                    Timber.d("No subreddit, skipping analytics", new Object[0]);
                } catch (Throwable th) {
                    Timber.c(th, "Failed to send video player analytics", new Object[0]);
                }
            }
        }
    }

    static /* synthetic */ void m24351f(VideoPlayer videoPlayer) {
        if (videoPlayer.f22233r && videoPlayer.f22221c != null) {
            videoPlayer.f22233r = false;
            videoPlayer.f22221c.a(0.0f);
            videoPlayer.f22223e = true;
        }
    }
}

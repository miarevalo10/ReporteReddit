package com.reddit.frontpage.ui.detail.video;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.evernote.android.state.State;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer.EventListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.LightboxActivity;
import com.reddit.frontpage.MainActivity;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerEvent;
import com.reddit.frontpage.ui.detail.BaseDetailScreen;
import com.reddit.frontpage.ui.detail.FlexContainerDetailScreen;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.ScreenUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.VideoStateUtil;
import com.reddit.frontpage.util.VideoStateUtil.VideoState;
import com.reddit.frontpage.util.VideoUtil;
import com.reddit.frontpage.widgets.video.VideoEventBus.VideoEventWrapper;
import com.reddit.frontpage.widgets.video.VideoPlayer;
import com.reddit.frontpage.widgets.video.VideoPlayer.VideoListener;
import com.reddit.frontpage.widgets.video.VideoPlayer.VideoListenerAdapter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.TimeUnit;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.parceler.Parcels;

public class VideoDetailScreen extends FlexContainerDetailScreen {
    private boolean aA = false;
    private final OnClickListener aB = new VideoDetailScreen$$Lambda$0(this);
    private final Runnable aC = new VideoDetailScreen$$Lambda$1(this);
    private final EventListener aD = new C26831(this);
    private final VideoListenerAdapter aE = new C26842(this);
    private final OnOffsetChangedListener aF = new C23303(this);
    String aa;
    VideoPlayer ab;
    private Link ac;
    private boolean ad;
    private String ae;
    private VideoPlayer af;
    private OrientationEventListener ag;
    private boolean ah;
    private int ai;
    private float aj = 0.0f;
    private float ak;
    private int al;
    private int am;
    private int an;
    private boolean ao;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private CompositeDisposable as;
    private boolean at = true;
    private boolean au;
    private VideoState av;
    private final Handler aw = new Handler();
    private boolean ax;
    private boolean ay = false;
    private boolean az;
    @State
    boolean inLandscape;

    class C23303 implements OnOffsetChangedListener {
        final /* synthetic */ VideoDetailScreen f28974a;

        C23303(VideoDetailScreen videoDetailScreen) {
            this.f28974a = videoDetailScreen;
        }

        public final void m30033a(AppBarLayout appBarLayout, int i) {
            if (!this.f28974a.au && ((int) this.f28974a.ak) - i >= appBarLayout.getHeight() - 10 && this.f28974a.ab != null) {
                this.f28974a.au = true;
                this.f28974a.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_PAUSE_CLOSED);
            }
        }
    }

    class C26831 implements EventListener {
        final /* synthetic */ VideoDetailScreen f34272a;

        public final void m34979a() {
        }

        public final void m34980a(ExoPlaybackException exoPlaybackException) {
        }

        public final void m34981a(Timeline timeline) {
        }

        public final void m34982a(TrackSelectionArray trackSelectionArray) {
        }

        public final void m34983a(boolean z) {
        }

        C26831(VideoDetailScreen videoDetailScreen) {
            this.f34272a = videoDetailScreen;
        }

        public final void m34984a(boolean z, int i) {
            if (!(this.f34272a.ah == z && this.f34272a.ai == i)) {
                this.f34272a.ah = z;
                this.f34272a.ai = i;
                boolean z2 = this.f34272a.ac != null && this.f34272a.ac.isVideo() && (!this.f34272a.ah || this.f34272a.ai == 4);
                this.f34272a.m42179g(z2);
            }
            if (z) {
                if (this.f34272a.ai != 4) {
                    ScreenUtil.m23890b(this.f34272a.am_());
                    if (!(this.f34272a.ab == null || this.f34272a.ab.m24374j())) {
                        FrontpageApplication.m28871g().mo5026b();
                        VideoStateUtil.m24048a(this.f34272a.aa, z, this.f34272a.ab.m24372h(), this.f34272a.ab.f22223e);
                    }
                    if (i == 4) {
                        this.f34272a.al();
                    }
                }
            }
            ScreenUtil.m23891c(this.f34272a.am_());
            FrontpageApplication.m28871g().mo5026b();
            VideoStateUtil.m24048a(this.f34272a.aa, z, this.f34272a.ab.m24372h(), this.f34272a.ab.f22223e);
            if (i == 4) {
                this.f34272a.al();
            }
        }
    }

    class C26842 extends VideoListenerAdapter {
        final /* synthetic */ VideoDetailScreen f34273a;

        C26842(VideoDetailScreen videoDetailScreen) {
            this.f34273a = videoDetailScreen;
        }

        public final void mo5000a(int i, int i2) {
            this.f34273a.ab.m24364b((VideoListener) this);
            this.f34273a.m42166a((float) i, (float) i2);
            if (i2 > i) {
                this.f34273a.aB();
            }
        }
    }

    static /* synthetic */ boolean m42174d(int i) {
        return (i > 75 && i < 105) || (i > 255 && i < 285);
    }

    static /* synthetic */ boolean m42176e(int i) {
        if (i >= 15 && i <= 345) {
            if (i <= 165 || i >= JpegConst.SOF3) {
                return false;
            }
        }
        return true;
    }

    public final int ag() {
        return 0;
    }

    final /* synthetic */ void aj() {
        if (this.ab != null) {
            if (this.ab.m24371g()) {
                aq();
                return;
            }
            this.ab.m24361a(this.aa, Util.m24038j(this.ac), this.ao);
            this.ab.m24359a(this.ac, "comments", null);
            this.simpleExoPlayerView.setPlayer(this.ab.f22221c);
            this.ab.m24366c();
            if (!this.ab.f22223e) {
                FrontpageApplication.m28873i().mo5025a().m23652a();
            }
            this.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_ACTIVATED);
        }
    }

    public static VideoDetailScreen m42165a(Link link, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("com.reddit.arg.link", Parcels.m28672a((Object) link));
        bundle2.putBundle("com.reddit.arg.context", bundle);
        return new VideoDetailScreen(bundle2);
    }

    public VideoDetailScreen(Bundle bundle) {
        super(bundle);
        this.aA = bundle.getBundle("com.reddit.arg.context").getBoolean("com.reddit.arg.fromFeed");
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.detailList.getRecycledViewPool().a();
        return this.K;
    }

    public final void mo7209b(Activity activity) {
        super.mo7209b(activity);
        if (this.ag != null) {
            this.ag.enable();
        }
        this.ar = true;
        if (this.ab == null && this.ac != null && FrontpageApplication.m28865a(MainActivity.class.getSimpleName()) != null && aD() == null) {
            am();
        }
        if (this.ab != null) {
            if (this.az != null) {
                this.ab.m24368d();
                ScreenUtil.m23891c(am_());
            } else {
                this.ab.m24366c();
                ScreenUtil.m23890b(am_());
            }
        }
        if (this.ab != null) {
            this.ab.f22224f = this.ab.m24372h();
        }
    }

    protected final void m42198c(Activity activity) {
        Activity am_ = am_();
        if (!(am_ == null || !((BaseActivity) am_).f40727b || this.ab == null)) {
            ak();
        }
        boolean z = (this.ab == null || this.ab.m24371g()) ? false : true;
        this.az = z;
        this.af = this.ab;
        ap();
        super.c(activity);
    }

    protected final void m42200d(Activity activity) {
        super.d(activity);
        ak();
        if (this.af != null) {
            this.af.m24368d();
            ScreenUtil.m23891c(am_());
            this.af = null;
        }
    }

    private void ak() {
        if (this.ab != null) {
            this.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_SERVED_VIDEO);
        }
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        if ((aC() == null || this.ay != null) && this.ap == null) {
            this.ay = false;
            if (am_() != null) {
                am_().setRequestedOrientation(1);
            }
            this.ap = false;
            if (this.appBarLayout != null) {
                this.appBarLayout.a(this.aF);
            }
            as();
            this.as = new CompositeDisposable();
            if (!(this.simpleExoPlayerView == null || this.simpleExoPlayerView.getVideoEventBus() == null)) {
                this.as.mo5631a(this.simpleExoPlayerView.getVideoEventBus().asObservable().observeOn(SchedulerProvider.m23887c()).subscribe(new VideoDetailScreen$$Lambda$5(this)));
            }
            this.as.mo5631a(MainActivity.m42706f().debounce(200, TimeUnit.MILLISECONDS).observeOn(SchedulerProvider.m23887c()).subscribe(new VideoDetailScreen$$Lambda$7(this)));
            this.as.mo5631a(BaseDetailScreen.f39142P.filter(VideoDetailScreen$$Lambda$8.f28972a).debounce(200, TimeUnit.MILLISECONDS).observeOn(SchedulerProvider.m23887c()).subscribe(new VideoDetailScreen$$Lambda$9(this)));
            this.as.mo5631a(FrontpageApplication.m28872h().mo4570c().getBus().filter(new VideoDetailScreen$$Lambda$10(this)).observeOn(SchedulerProvider.m23887c()).subscribe(new VideoDetailScreen$$Lambda$11(this)));
            this.as.mo5631a(BaseActivity.m42469e().observeOn(SchedulerProvider.m23887c()).subscribe(new VideoDetailScreen$$Lambda$6(this)));
        }
    }

    protected final void mo6993c(View view) {
        if (this.appBarLayout != null) {
            this.appBarLayout.b(this.aF);
        }
        ap();
        aB();
        if (this.as != null) {
            this.as.mo5626a();
            this.as = null;
        }
        this.aw.removeCallbacks(this.aC);
        this.ay = true;
        ScreenUtil.m23891c(am_());
        super.mo6993c(view);
    }

    public final boolean mo6986J() {
        this.ax = true;
        if (this.ab != null) {
            this.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CHANGE_PAGETYPE);
            ak();
        }
        return false;
    }

    public final void mo7683a(int i) {
        this.al = (16711680 & i) >> 16;
        this.am = (65280 & i) >> 8;
        this.an = i & 255;
        i = Color.argb(0, this.al, this.am, this.an);
        if (this.toolbar != null) {
            this.toolbar.setBackgroundColor(i);
            this.toolbar.setAlpha(1.0f);
            this.toolbar.setVisibility(0);
        }
        if (this.toolbarDivider != 0) {
            this.toolbarDivider.setVisibility(8);
        }
    }

    public final View mo7682T() {
        TypedValue typedValue = new TypedValue();
        if (this.videoContainer != null) {
            if (this.videoContainer.getContext().getTheme().resolveAttribute(16843499, typedValue, true)) {
                this.ak = (float) TypedValue.complexToDimensionPixelSize(typedValue.data, ao_().getDisplayMetrics());
            }
            this.videoContainer.setVisibility(0);
        }
        if (aD()) {
            al();
        } else {
            am();
        }
        if (this.toolbarImageView != null) {
            this.toolbarImageView.setVisibility(8);
        }
        return null;
    }

    private boolean al() {
        if (this.simpleExoPlayerView != null) {
            this.ac = this.f39153F;
            Point point = new Point(this.videoContainer.getWidth(), this.videoContainer.getHeight());
            Link link = this.ac;
            boolean z = FrontpageSettings.a().g() && (!(this.ab == null || this.ab.m24373i() == 4) || (this.ab != null && this.ab.m24373i() == 1));
            ImageResolution a = LinkUtil.m23775a(link, z, point);
            if (a != null) {
                float height = (float) a.getHeight();
                float width = (float) a.getWidth();
                m42166a(width, height);
                if (height > width) {
                    aB();
                }
                this.simpleExoPlayerView.m24330a(a.getUrl(), (int) width, (int) height);
                return true;
            }
        }
        return false;
    }

    public final void mo7690f(boolean z) {
        m42180h(z);
    }

    public final void mo7436L() {
        if (this.ab != null) {
            this.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CLICK_OVERFLOW);
        }
    }

    private void am() {
        if (this.simpleExoPlayerView != null && !this.ax) {
            this.ac = this.f39153F;
            this.simpleExoPlayerView.setSizeToggleListener(new VideoDetailScreen$$Lambda$2(this));
            boolean z = false;
            this.detailList.setNestedScrollingEnabled(false);
            this.appBarLayout.a(new VideoDetailScreen$$Lambda$3(this));
            this.aa = Util.m23963a(this.ac, new Point(this.videoContainer.getWidth(), this.videoContainer.getHeight()));
            if (TextUtils.isEmpty(this.aa)) {
                this.videoContainer.setOnClickListener(new VideoDetailScreen$$Lambda$4(this));
                m42179g(true);
            } else {
                an();
                this.videoContainer.setOnClickListener(this.aB);
                if (this.ac.isVideo() && !this.ah) {
                    z = true;
                }
                m42179g(z);
            }
            if (!(al() || this.ab == null)) {
                this.ab.m24360a(this.aE);
            }
            this.simpleExoPlayerView.m24329a(this.ab);
        }
    }

    final /* synthetic */ void ai() {
        if (this.ag != null) {
            this.ag.disable();
        }
        aq();
        if (this.ab != null) {
            this.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CLICK_FULLSCREEN);
        }
    }

    final /* synthetic */ void mo7689b(int i) {
        if ((!this.ah || this.ai == 4) && this.e) {
            float f = ((float) (-i)) / (this.aj - this.ak);
            if (this.toolbar != null) {
                this.toolbar.setBackgroundColor(Color.argb((int) (255.0f * f), this.al, this.am, this.an));
            }
            this.simpleExoPlayerView.setCanPlay(i == 0 ? 1 : 0);
        }
    }

    final /* synthetic */ void ah() {
        IntentUtil.m23757a(am_(), this.ac, m39101W() ? "onboarding_post_detail" : "post_detail");
    }

    private void an() {
        if (this.aa != null && this.ab == null) {
            boolean z;
            boolean z2;
            VideoPlayer videoPlayer;
            boolean z3;
            ViewParent parent;
            FrontpageApplication.m28871g().mo5026b();
            this.av = VideoStateUtil.m24046a(this.aa);
            this.ad = ao();
            boolean z4 = false;
            if (VideoUtil.m24056a(this.aa) && !this.ac.isGif()) {
                if (!Util.m24022e(this.ac)) {
                    z = false;
                    this.ao = z;
                    this.ae = VideoUtil.m24053a(this.ac);
                    this.ab = VideoPlayer.m24338a(this.ae);
                    this.af = null;
                    if (this.ab != null) {
                        this.ab = VideoPlayer.m24336a(this.f39167y.getContext(), this.ae, ar());
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.ab.f22221c.a(this.aD);
                    this.ah = this.ab.m24371g();
                    if (!aC()) {
                        if (z2) {
                            videoPlayer = this.ab;
                            if (this.av != null) {
                                if (this.av.isMuted()) {
                                    z3 = false;
                                    videoPlayer.m24362a(z3);
                                }
                            }
                            z3 = true;
                            videoPlayer.m24362a(z3);
                        }
                        if (this.ad || (this.av != null && this.av.getPosition() > 0)) {
                            this.ab.m24361a(this.aa, Util.m24038j(this.ac), this.ao);
                            this.simpleExoPlayerView.setUseController(Util.m24022e(this.ac) ^ true);
                            this.simpleExoPlayerView.setShowControllerInitially(Util.m24022e(this.ac) ^ true);
                            this.simpleExoPlayerView.setAcceptTouchesAlways(Util.m24022e(this.ac));
                            this.ab.m24359a(this.ac, "comments", null);
                            if (!(!z2 || this.av == null || this.ab.m24371g())) {
                                this.ab.m24358a(this.av.getPosition());
                            }
                        }
                    }
                    this.simpleExoPlayerView.setUseController(true);
                    this.simpleExoPlayerView.setShowControllerInitially(this.ad ^ true);
                    if (this.ad || (this.av != null && this.av.getPosition() > 0)) {
                        this.simpleExoPlayerView.setPlayer(this.ab.f22221c);
                    }
                    this.simpleExoPlayerView.setIsMutable(this.ao ^ true);
                    this.simpleExoPlayerView.setMuteAlwaysVisible(this.ao ^ true);
                    if (this.ad) {
                        if (this.ar) {
                            for (parent = this.K.getParent(); parent != null; parent = parent.getParent()) {
                                if (parent instanceof ViewPager) {
                                    z4 = true;
                                    break;
                                }
                            }
                            if (!z4) {
                                m42180h(true);
                            }
                        } else {
                            this.ab.m24366c();
                            ScreenUtil.m23890b(am_());
                            if (!this.ab.f22223e) {
                                FrontpageApplication.m28873i().mo5025a().m23652a();
                            }
                            this.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_ACTIVATED);
                        }
                    }
                }
            }
            z = true;
            this.ao = z;
            this.ae = VideoUtil.m24053a(this.ac);
            this.ab = VideoPlayer.m24338a(this.ae);
            this.af = null;
            if (this.ab != null) {
                z2 = false;
            } else {
                this.ab = VideoPlayer.m24336a(this.f39167y.getContext(), this.ae, ar());
                z2 = true;
            }
            this.ab.f22221c.a(this.aD);
            this.ah = this.ab.m24371g();
            if (aC()) {
                if (z2) {
                    videoPlayer = this.ab;
                    if (this.av != null) {
                        if (this.av.isMuted()) {
                            z3 = false;
                            videoPlayer.m24362a(z3);
                        }
                    }
                    z3 = true;
                    videoPlayer.m24362a(z3);
                }
                this.ab.m24361a(this.aa, Util.m24038j(this.ac), this.ao);
                this.simpleExoPlayerView.setUseController(Util.m24022e(this.ac) ^ true);
                this.simpleExoPlayerView.setShowControllerInitially(Util.m24022e(this.ac) ^ true);
                this.simpleExoPlayerView.setAcceptTouchesAlways(Util.m24022e(this.ac));
                this.ab.m24359a(this.ac, "comments", null);
                this.ab.m24358a(this.av.getPosition());
            }
            this.simpleExoPlayerView.setUseController(true);
            this.simpleExoPlayerView.setShowControllerInitially(this.ad ^ true);
            this.simpleExoPlayerView.setPlayer(this.ab.f22221c);
            this.simpleExoPlayerView.setIsMutable(this.ao ^ true);
            this.simpleExoPlayerView.setMuteAlwaysVisible(this.ao ^ true);
            if (this.ad) {
                if (this.ar) {
                    for (parent = this.K.getParent(); parent != null; parent = parent.getParent()) {
                        if (parent instanceof ViewPager) {
                            z4 = true;
                            break;
                        }
                    }
                    if (z4) {
                        m42180h(true);
                    }
                } else {
                    this.ab.m24366c();
                    ScreenUtil.m23890b(am_());
                    if (this.ab.f22223e) {
                        FrontpageApplication.m28873i().mo5025a().m23652a();
                    }
                    this.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_ACTIVATED);
                }
            }
        }
    }

    private boolean ao() {
        if (this.av != null) {
            return !this.av.isPaused() && VideoUtil.m24054a();
        } else {
            return VideoUtil.m24054a();
        }
    }

    private void ap() {
        if (this.ab != null) {
            this.ab.m24364b(this.aE);
            if (this.ab.f22221c != null) {
                this.ab.f22221c.b(this.aD);
            }
            if (!(this.ap || this.aA)) {
                this.ab.m24368d();
                ScreenUtil.m23891c(am_());
                this.af = null;
            }
            if (!this.aq && !this.ap && this.ab.m24365b(ar())) {
                FrontpageApplication.m28871g().mo5026b();
                VideoStateUtil.m24049b(this.aa);
                if (this.simpleExoPlayerView != null) {
                    this.simpleExoPlayerView.setPlayer(null);
                }
                this.af = null;
            } else if (this.simpleExoPlayerView != null) {
                this.simpleExoPlayerView.m24328a();
            }
            this.aq = false;
            this.ap = false;
            this.ab = null;
        }
    }

    private void m42180h(boolean z) {
        if (this.ar != z) {
            this.ar = z;
            if (this.simpleExoPlayerView != null) {
                if (this.ab == null && z) {
                    an();
                }
                this.ad = ao();
                if (this.ab != null) {
                    if (z && this.ad) {
                        this.ab.m24366c();
                        ScreenUtil.m23890b(am_());
                        this.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_ACTIVATED);
                        if (!this.ab.f22223e) {
                            FrontpageApplication.m28873i().mo5025a().m23652a();
                        }
                    } else {
                        if (!this.ab.m24374j()) {
                            FrontpageApplication.m28871g().mo5026b();
                            VideoStateUtil.m24048a(this.aa, this.ab.m24371g(), this.ab.m24372h(), this.ab.f22223e);
                        }
                        this.ab.m24368d();
                        ScreenUtil.m23891c(am_());
                    }
                }
            }
        }
        as();
        if (this.ag != null) {
            if (z) {
                this.ag.enable();
                return;
            }
            this.ag.disable();
        }
    }

    private void aq() {
        if (this.ac != null && am_() != null && !aD()) {
            boolean z = true;
            this.ap = true;
            if (!(this.ab == null || this.ab.m24374j())) {
                FrontpageApplication.m28871g().mo5026b();
                boolean c = VideoStateUtil.m24050c(this.aa);
                FrontpageApplication.m28871g().mo5026b();
                String str = this.aa;
                boolean g = this.ab.m24371g();
                long h = this.ab.m24372h();
                if (!c || !this.ab.f22223e) {
                    z = false;
                }
                VideoStateUtil.m24048a(str, g, h, z);
                FrontpageApplication.m28871g().mo5026b();
                VideoStateUtil.m24051d(this.aa);
            }
            if (this.ab != null) {
                this.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CHANGE_PAGETYPE);
            }
            IntentUtil.m23757a(am_(), this.ac, m39101W() ? "onboarding_post_detail" : "post_detail");
        }
    }

    private String ar() {
        StringBuilder stringBuilder = new StringBuilder("DETAILS_");
        stringBuilder.append(this.ae);
        return stringBuilder.toString();
    }

    private void as() {
        if (this.ag == null && am_() != null) {
            this.ag = new OrientationEventListener(this, am_()) {
                final /* synthetic */ VideoDetailScreen f21195a;

                public void onOrientationChanged(int i) {
                    if (this.f21195a.ar && this.f21195a.e) {
                        if (VideoDetailScreen.m42174d(i)) {
                            if (this.f21195a.inLandscape == 0 && ScreenUtil.m23889a() == 0) {
                                this.f21195a.ag.disable();
                                this.f21195a.inLandscape = true;
                                this.f21195a.aq();
                                if (this.f21195a.ab != 0) {
                                    this.f21195a.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_ROTATE_FULLSCREEN);
                                }
                            }
                        } else if (VideoDetailScreen.m42176e(i) != 0) {
                            this.f21195a.inLandscape = false;
                        }
                    }
                }
            };
            this.ag.enable();
        }
    }

    final void mo7684x() {
        if (this.toolbar != null && this.at && this.ab != null && this.ab.m24371g()) {
            this.at = false;
            this.toolbar.animate().alpha(0.0f).setDuration((long) ao_().getInteger(17694721)).setInterpolator(new AccelerateInterpolator()).withEndAction(new VideoDetailScreen$$Lambda$12(this));
        }
    }

    private void aB() {
        if (this.ag != null) {
            this.ag.disable();
            this.ag = null;
        }
    }

    private void m42166a(float f, float f2) {
        Point a = Util.m23955a(am_());
        int min = Math.min(a.x, a.y);
        LayoutParams layoutParams = this.simpleExoPlayerView.getLayoutParams();
        layoutParams.width = min;
        float f3 = (float) min;
        layoutParams.height = (int) Math.min(0.5625f * f3, (f2 / f) * f3);
        this.aj = (float) layoutParams.height;
        this.simpleExoPlayerView.setLayoutParams(layoutParams);
    }

    private boolean aC() {
        Activity am_ = am_();
        return am_ != null && ((MainActivity) am_).f40815d;
    }

    private static boolean aD() {
        return FrontpageApplication.m28867b(LightboxActivity.class.getSimpleName());
    }

    protected final void ai_() {
        if (this.ab != null) {
            this.ab.m24368d();
        }
        ScreenUtil.m23891c(am_());
        super.ai_();
    }

    protected final void mo7685V() {
        this.aq = true;
    }

    private void m42179g(boolean z) {
        RecyclerView recyclerView = this.detailList;
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(z);
        }
        if (this.collapsingToolbarLayout != null) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) this.collapsingToolbarLayout.getLayoutParams();
            layoutParams.a = z ? true : true;
            this.collapsingToolbarLayout.setLayoutParams(layoutParams);
        }
    }

    final /* synthetic */ void m42194a(VideoEventWrapper videoEventWrapper) {
        this.aw.removeCallbacks(this.aC);
        switch (videoEventWrapper.f22206a) {
            case null:
            case 2:
                if (this.toolbar != null && this.at == null) {
                    this.at = true;
                    this.toolbar.setVisibility(0);
                    this.toolbar.animate().alpha(1.0f).setDuration((long) ao_().getInteger(17694721)).setInterpolator(new DecelerateInterpolator());
                    break;
                }
            case 1:
                mo7684x();
                return;
            case 3:
                if (this.at != null) {
                    this.aw.postDelayed(this.aC, (long) this.simpleExoPlayerView.getControlShowTimeout());
                    return;
                }
                break;
            default:
                break;
        }
    }
}

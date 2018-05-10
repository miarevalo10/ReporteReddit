package com.reddit.frontpage.ui.detail.video;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.Votable.AdAnalyticsInfo;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.LightboxActivity;
import com.reddit.frontpage.commons.analytics.events.v2.TheaterModeEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.TheaterModeEvents;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerEvent;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.SaveMediaScreen;
import com.reddit.frontpage.ui.listener.SwipeDismissListener;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.PermissionUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.ScreenUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.VideoStateUtil;
import com.reddit.frontpage.util.VideoStateUtil.VideoState;
import com.reddit.frontpage.util.VideoUtil;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView$$Lambda$0;
import com.reddit.frontpage.widgets.video.VideoEventBus.VideoEventWrapper;
import com.reddit.frontpage.widgets.video.VideoPlayer;
import com.reddit.frontpage.widgets.video.VideoPlayer.VideoListenerAdapter;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.TimeUnit;

@TargetApi(16)
public class VideoPlayerScreen extends SaveMediaScreen {
    private int f40144A = 0;
    private boolean f40145B;
    private CompositeDisposable f40146C;
    private final Handler f40147D = new Handler();
    private final VideoListenerAdapter f40148E = new C26851(this);
    private final OnClickListener f40149F = new VideoPlayerScreen$$Lambda$0(this);
    private final Runnable f40150G = new VideoPlayerScreen$$Lambda$1(this);
    @State
    String fullName;
    @State
    String gifUri;
    @State
    boolean hasNavBar;
    @State
    String imageUri;
    @State
    boolean isPlaying;
    @State
    String mp4Uri;
    @State
    boolean overflowMenuOpen;
    @BindView
    SimpleExoPlayerView simpleExoPlayerView;
    @BindView
    Toolbar toolbar;
    @State
    int videoHeight = -1;
    @BindView
    ViewGroup videoLayout;
    @State
    boolean videoOrientationLandscape = true;
    @State
    int videoWidth = -1;
    VideoPlayer f40151x;
    private String f40152y;
    private OrientationEventListener f40153z;

    class C23312 implements OnVoteChangeListener {
        final /* synthetic */ VideoPlayerScreen f28983a;

        public final boolean mo4894a() {
            return true;
        }

        C23312(VideoPlayerScreen videoPlayerScreen) {
            this.f28983a = videoPlayerScreen;
        }

        public final void mo4893a(String str, int i, AdAnalyticsInfo adAnalyticsInfo) {
            TheaterModeEventBuilder.m21947a("click", i == 1 ? TheaterModeEvents.NOUN_UPVOTE : TheaterModeEvents.NOUN_DOWNVOTE);
        }
    }

    class C26851 extends VideoListenerAdapter {
        final /* synthetic */ VideoPlayerScreen f34274a;

        C26851(VideoPlayerScreen videoPlayerScreen) {
            this.f34274a = videoPlayerScreen;
        }

        public final void mo5001a(boolean z, int i) {
            if (this.f34274a.f40151x && this.f34274a.f40151x.m24370f() && !this.f34274a.f40151x.m24374j()) {
                FrontpageApplication.m28871g().mo5026b();
                VideoStateUtil.m24048a(this.f34274a.mp4Uri, this.f34274a.f40151x.m24371g(), this.f34274a.f40151x.m24372h(), this.f34274a.f40151x.f22223e);
                if (this.f34274a.f40151x && this.f34274a.f40151x.m24373i() && FrontpageSettings.a().g()) {
                    z = LinkUtil.m23775a(this.f34274a.link, false, Util.m23993b());
                    if (z) {
                        this.f34274a.imageUri = z.getUrl();
                        this.f34274a.simpleExoPlayerView.setShutterImageUri(this.f34274a.imageUri);
                    }
                }
            }
            if (i == true && this.f34274a.simpleExoPlayerView && this.f34274a.f40151x) {
                this.f34274a.simpleExoPlayerView.m24329a(this.f34274a.f40151x);
            }
        }
    }

    final /* synthetic */ void ab() {
        m39063w();
    }

    protected final void mo7441d(boolean z) {
    }

    public final int mo7141s() {
        return C1761R.layout.screen_lightbox_video;
    }

    final /* synthetic */ void aa() {
        if (this.simpleExoPlayerView == null || Math.abs(this.simpleExoPlayerView.getTranslationY()) <= 100.0f) {
            TheaterModeEventBuilder.m21947a("click", TheaterModeEvents.NOUN_POST_TITLE);
            ((ViewGroup) this.K).setLayoutTransition(new LayoutTransition());
            m39064x();
            mo7435X();
        }
    }

    public static VideoPlayerScreen m40931a(Link link, String str) {
        VideoPlayerScreen videoPlayerScreen = new VideoPlayerScreen();
        videoPlayerScreen.link = link;
        Point b = Util.m23993b();
        ImageResolution a = LinkUtil.m23775a(link, FrontpageSettings.a().g(), b);
        if (a != null) {
            videoPlayerScreen.imageUri = a.getUrl();
            videoPlayerScreen.videoWidth = a.getWidth();
            videoPlayerScreen.videoHeight = a.getHeight();
        }
        videoPlayerScreen.mp4Uri = Util.m23963a(link, b);
        videoPlayerScreen.gifUri = Util.m24040k(link);
        videoPlayerScreen.sourcePage = str;
        videoPlayerScreen.fullName = link.getName();
        return videoPlayerScreen;
    }

    public static VideoPlayerScreen m40932a(String str, String str2, String str3) {
        VideoPlayerScreen videoPlayerScreen = new VideoPlayerScreen();
        videoPlayerScreen.imageUri = str;
        videoPlayerScreen.mp4Uri = str2;
        videoPlayerScreen.gifUri = null;
        videoPlayerScreen.sourcePage = str3;
        videoPlayerScreen.fullName = null;
        return videoPlayerScreen;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.videoLayout.setOnClickListener(this.f40149F);
        if (TextUtils.isEmpty(this.imageUri) == null) {
            this.simpleExoPlayerView.m24330a(this.imageUri, this.videoWidth, this.videoHeight);
        }
        this.simpleExoPlayerView.setSizeToggleListener(new VideoPlayerScreen$$Lambda$4(this));
        this.simpleExoPlayerView.setDragListener(new VideoPlayerScreen$$Lambda$5(this));
        this.simpleExoPlayerView.setOnTouchListener(mo7442y());
        ac();
        layoutInflater = LinkUtil.m23775a(this.link, FrontpageSettings.a().g(), Util.m23955a(am_()));
        if (layoutInflater != null) {
            this.videoOrientationLandscape = layoutInflater.getWidth() >= layoutInflater.getHeight() ? 1 : null;
            layoutInflater = Util.m23963a(this.link, Util.m23993b());
            FrontpageApplication.m28871g().mo5026b();
            layoutInflater = VideoStateUtil.m24046a(layoutInflater);
            if (layoutInflater != null) {
                layoutInflater = (!VideoUtil.m24054a() || layoutInflater.isPlaying() == null) ? null : 1;
                this.isPlaying = layoutInflater;
            } else {
                this.isPlaying = VideoUtil.m24054a();
            }
        }
        this.isPlaying = VideoUtil.m24054a();
        this.hasNavBar = FrontpageSettings.a().a.getBoolean("com.reddit.frontpage.device_has_software_keys", true);
        this.simpleExoPlayerView.setLink(this.link);
        this.simpleExoPlayerView.setViewCommentsListener(new VideoPlayerScreen$$Lambda$2(this));
        this.simpleExoPlayerView.setOnVoteChangeListener(new C23312(this));
        this.simpleExoPlayerView.setOnShareListener(new VideoPlayerScreen$$Lambda$3(viewGroup));
        super.mo7441d(false);
        return this.K;
    }

    static final /* synthetic */ void m40936b(ViewGroup viewGroup, String str) {
        LinkUtil.m23780a(viewGroup.getContext(), str);
        TheaterModeEventBuilder.m21947a("click", TheaterModeEvents.NOUN_SHARE);
    }

    protected final void m40962b(View view, Bundle bundle) {
        super.b(view, bundle);
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        if (!(this.f40151x != null || this.mp4Uri == null || this.link == null || am_() == null)) {
            boolean z;
            VideoPlayer videoPlayer;
            this.f40152y = VideoUtil.m24053a(this.link);
            this.f40151x = VideoPlayer.m24338a(this.f40152y);
            boolean z2 = false;
            view = this.f40151x == null ? 1 : null;
            if (view != null) {
                this.f40151x = VideoPlayer.m24336a(am_(), this.f40152y, ad());
            }
            FrontpageApplication.m28871g().mo5026b();
            VideoState a = VideoStateUtil.m24046a(this.mp4Uri);
            if (a != null) {
                this.f40151x.f22224f = a.getPosition();
            }
            if (VideoUtil.m24056a(this.mp4Uri) && !this.link.isGif()) {
                if (!Util.m24028f(this.link)) {
                    z = false;
                    this.f40151x.m24361a(this.mp4Uri, Util.m24038j(this.link), z);
                    if (!this.link.isGif()) {
                        if (Util.m24022e(this.link)) {
                            FrontpageApplication.m28873i().mo5025a().m23652a();
                            videoPlayer = this.f40151x;
                            if (a != null && a.isMuted()) {
                                z2 = true;
                            }
                            videoPlayer.m24362a(z2);
                            this.f40151x.m24359a(this.link, "full_screen", null);
                            this.f40151x.m24360a(this.f40148E);
                            this.simpleExoPlayerView.setIsMutable(true ^ z);
                            this.simpleExoPlayerView.setPlayer(this.f40151x.f22221c);
                            if (view == null) {
                                if (a != null && a.getPosition() > 0) {
                                    this.f40151x.m24358a(a.getPosition());
                                }
                            } else if (this.f40151x.m24373i() == 4) {
                                this.f40151x.m24358a(0);
                            }
                            this.simpleExoPlayerView.m24329a(this.f40151x);
                        }
                    }
                    videoPlayer = this.f40151x;
                    z2 = true;
                    videoPlayer.m24362a(z2);
                    this.f40151x.m24359a(this.link, "full_screen", null);
                    this.f40151x.m24360a(this.f40148E);
                    this.simpleExoPlayerView.setIsMutable(true ^ z);
                    this.simpleExoPlayerView.setPlayer(this.f40151x.f22221c);
                    if (view == null) {
                        this.f40151x.m24358a(a.getPosition());
                    } else if (this.f40151x.m24373i() == 4) {
                        this.f40151x.m24358a(0);
                    }
                    this.simpleExoPlayerView.m24329a(this.f40151x);
                }
            }
            z = true;
            this.f40151x.m24361a(this.mp4Uri, Util.m24038j(this.link), z);
            if (this.link.isGif()) {
                if (Util.m24022e(this.link)) {
                    FrontpageApplication.m28873i().mo5025a().m23652a();
                    videoPlayer = this.f40151x;
                    z2 = true;
                    videoPlayer.m24362a(z2);
                    this.f40151x.m24359a(this.link, "full_screen", null);
                    this.f40151x.m24360a(this.f40148E);
                    this.simpleExoPlayerView.setIsMutable(true ^ z);
                    this.simpleExoPlayerView.setPlayer(this.f40151x.f22221c);
                    if (view == null) {
                        this.f40151x.m24358a(a.getPosition());
                    } else if (this.f40151x.m24373i() == 4) {
                        this.f40151x.m24358a(0);
                    }
                    this.simpleExoPlayerView.m24329a(this.f40151x);
                }
            }
            videoPlayer = this.f40151x;
            z2 = true;
            videoPlayer.m24362a(z2);
            this.f40151x.m24359a(this.link, "full_screen", null);
            this.f40151x.m24360a(this.f40148E);
            this.simpleExoPlayerView.setIsMutable(true ^ z);
            this.simpleExoPlayerView.setPlayer(this.f40151x.f22221c);
            if (view == null) {
                this.f40151x.m24358a(a.getPosition());
            } else if (this.f40151x.m24373i() == 4) {
                this.f40151x.m24358a(0);
            }
            this.simpleExoPlayerView.m24329a(this.f40151x);
        }
        if (this.f40151x != null) {
            this.f40151x.m24360a(this.f40148E);
        }
        if (this.f40144A == null) {
            ac();
        }
        if (this.f40153z == null) {
            this.f40153z = new OrientationEventListener(this, am_()) {
                final /* synthetic */ VideoPlayerScreen f21199a;

                public void onOrientationChanged(int i) {
                    if (!ScreenUtil.m23889a()) {
                        if (i <= 345) {
                            if (i >= 15) {
                                if ((i > 75 && i < 105) || (i > 255 && i < 285)) {
                                    this.f21199a.f40144A = 2;
                                    if (!(this.f21199a.hasNavBar == 0 || this.f21199a.simpleExoPlayerView == 0)) {
                                        this.f21199a.simpleExoPlayerView.setProgressVerticalOffset(0);
                                        this.f21199a.simpleExoPlayerView.setProgressHorizontalOffset(this.f21199a.ag());
                                    }
                                }
                                if (this.f21199a.f40151x != 0 && this.f21199a.isPlaying != 0) {
                                    this.f21199a.f40151x.m24366c();
                                    return;
                                }
                            }
                        }
                        if ("post_detail".equals(this.f21199a.sourcePage) == 0) {
                            if ("onboarding_post_detail".equals(this.f21199a.sourcePage) == 0) {
                                i = 0;
                                if (i != 0 && this.f21199a.f40144A == 2) {
                                    this.f21199a.f40153z.disable();
                                    this.f21199a.f40145B = true;
                                    this.f21199a.mo7435X();
                                }
                                if (!(this.f21199a.hasNavBar == 0 || this.f21199a.simpleExoPlayerView == 0)) {
                                    this.f21199a.simpleExoPlayerView.setProgressHorizontalOffset(0);
                                    this.f21199a.simpleExoPlayerView.setProgressVerticalOffset(this.f21199a.ag());
                                }
                                if (this.f21199a.f40151x != 0) {
                                }
                            }
                        }
                        i = 1;
                        this.f21199a.f40153z.disable();
                        this.f21199a.f40145B = true;
                        this.f21199a.mo7435X();
                        this.f21199a.simpleExoPlayerView.setProgressHorizontalOffset(0);
                        this.f21199a.simpleExoPlayerView.setProgressVerticalOffset(this.f21199a.ag());
                        if (this.f21199a.f40151x != 0) {
                        }
                    }
                }
            };
        }
        this.f40153z.enable();
        if (this.isPlaying != null) {
            if (this.f40151x != null) {
                this.f40151x.m24366c();
                af();
            }
            if (this.f40151x != null && this.f40151x.f22223e == null) {
                FrontpageApplication.m28873i().mo5025a().m23652a();
            }
        }
        this.f40146C = new CompositeDisposable();
        if (!(this.simpleExoPlayerView == null || this.simpleExoPlayerView.getVideoEventBus() == null)) {
            this.f40146C.mo5631a(this.simpleExoPlayerView.getVideoEventBus().asObservable().observeOn(SchedulerProvider.m23887c()).subscribe(new VideoPlayerScreen$$Lambda$6(this)));
        }
        this.f40146C.mo5631a(LightboxActivity.m42691f().debounce(200, TimeUnit.MILLISECONDS).observeOn(SchedulerProvider.m23887c()).subscribe(new VideoPlayerScreen$$Lambda$7(this)));
        this.f40146C.mo5631a(BaseActivity.m42469e().filter(VideoPlayerScreen$$Lambda$8.f28981a).observeOn(SchedulerProvider.m23887c()).subscribe(new VideoPlayerScreen$$Lambda$9(this)));
        if (!(this.simpleExoPlayerView == null || this.hasNavBar == null)) {
            view = am_() != null ? am_().getResources().getConfiguration().orientation : 2;
            if (this.videoOrientationLandscape && view == 2) {
                this.simpleExoPlayerView.setProgressHorizontalOffset(ag());
                return;
            }
            this.simpleExoPlayerView.setProgressVerticalOffset(ag());
        }
    }

    protected final void m40955a(Activity activity) {
        super.a(activity);
        this.f40145B = null;
    }

    protected final void m40963c(Activity activity) {
        af();
        if (this.f40151x != null) {
            this.f40151x.m24367c(VideoPlayerEvent.VIDEO_PLAYER_SERVED_VIDEO);
        }
        boolean z = this.f40151x != null && this.f40151x.m24371g();
        this.isPlaying = z;
        if (!(this.f40145B || this.f40151x == null || Util.m24022e(this.link))) {
            this.f40151x.m24368d();
        }
        super.c(activity);
    }

    public final void mo7191l() {
        super.mo7191l();
        if (this.f40146C != null) {
            this.f40146C.mo5626a();
            this.f40146C = null;
        }
    }

    protected final void ae_() {
        ae();
        super.ae_();
    }

    public final void m40956a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_lightbox_video, menu);
        if (TextUtils.isEmpty(this.gifUri) != null) {
            menu.findItem(C1761R.id.action_save_gif).setVisible(false);
        }
        if (this.link != null && this.link.isGif() == null && Util.m24022e(this.link) == null && TextUtils.isEmpty(this.mp4Uri) == null) {
            menu.findItem(C1761R.id.action_save_video).setVisible(false);
        }
    }

    public final boolean mo7201a(MenuItem menuItem) {
        String scrubberMediaUrl;
        switch (menuItem.getItemId()) {
            case 16908332:
                mo7435X();
                return true;
            case C1761R.id.action_save_gif:
                m40934a(this.gifUri);
                return true;
            case C1761R.id.action_save_video:
                if (!(this.link.getMedia() == null || this.link.getMedia().getRedditVideo() == null)) {
                    String fallbackUrl = this.link.getMedia().getRedditVideo().getFallbackUrl();
                    scrubberMediaUrl = this.link.getMedia().getRedditVideo().getScrubberMediaUrl();
                    if (TextUtils.isEmpty(fallbackUrl)) {
                        fallbackUrl = scrubberMediaUrl;
                    }
                    m40934a(fallbackUrl);
                }
                return true;
            case C1761R.id.action_share:
                Context am_ = am_();
                scrubberMediaUrl = this.mediaUri != null ? this.mediaUri : this.mp4Uri != null ? this.mp4Uri : this.gifUri;
                a(IntentUtil.m23746a(am_, LinkUtil.m23778a(scrubberMediaUrl)));
                return true;
            default:
                return super.mo7201a(menuItem);
        }
    }

    protected final String mo7433T() {
        return Util.m24027f((int) C1761R.string.save_video_success);
    }

    protected final String mo7434U() {
        return Util.m24027f((int) C1761R.string.error_unable_save_video);
    }

    protected final void mo7440a(int[] iArr) {
        if (PermissionUtil.m23866a(iArr) == null) {
            m37532c((int) 2131886372);
        }
    }

    public final void mo7436L() {
        if (this.f40151x != null) {
            this.f40151x.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CLICK_OVERFLOW);
        }
    }

    public final boolean mo6986J() {
        this.f40145B = true;
        ae();
        return false;
    }

    protected final void mo7437O() {
        this.f40145B = true;
        ae();
        super.mo7437O();
    }

    private void ac() {
        Configuration configuration = ao_() != null ? ao_().getConfiguration() : null;
        this.f40144A = configuration != null ? configuration.orientation : 1;
    }

    protected final SwipeDismissListener mo7442y() {
        this.f40145B = true;
        return super.mo7442y();
    }

    private String ad() {
        StringBuilder stringBuilder = new StringBuilder("THEATER_");
        stringBuilder.append(this.f40152y);
        return stringBuilder.toString();
    }

    private void m40934a(String str) {
        Util.m23975a((Screen) this, str, "mp4");
        if (this.f40151x != null) {
            this.f40151x.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CLICK_SAVE);
        }
    }

    final void mo7435X() {
        if (this.f40151x != null) {
            this.f40151x.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CHANGE_PAGETYPE);
        }
        ae();
        am_().finish();
    }

    private void ae() {
        boolean b;
        af();
        if (this.f40151x != null) {
            b = this.f40151x.m24365b(ad());
            this.f40151x.m24364b(this.f40148E);
            this.f40151x = null;
        } else {
            b = false;
        }
        if (this.simpleExoPlayerView != null) {
            if (b) {
                this.simpleExoPlayerView.setPlayer(null);
            } else {
                this.simpleExoPlayerView.m24328a();
            }
            this.simpleExoPlayerView.setDragListener(null);
            this.simpleExoPlayerView.setLongClickListener(null);
            this.simpleExoPlayerView = null;
        }
    }

    private void af() {
        if (this.f40151x != null && this.f40151x.m24370f() && !this.f40151x.m24374j()) {
            FrontpageApplication.m28871g().mo5026b();
            VideoStateUtil.m24048a(this.mp4Uri, this.f40151x.m24371g(), this.f40151x.m24372h(), this.f40151x.f22223e);
        }
    }

    final /* synthetic */ void m40957a(VideoEventWrapper videoEventWrapper) throws Exception {
        this.f40147D.removeCallbacks(this.f40150G);
        switch (videoEventWrapper.f22206a) {
            case null:
            case 2:
                m39046S();
                break;
            case 1:
                if (this.overflowMenuOpen == null) {
                    m39045R();
                    return;
                }
                break;
            case 3:
                this.f40147D.postDelayed(this.f40150G, (long) ao_().getInteger(C1761R.integer.exoplayer_control_timeout_millis));
                return;
            default:
                break;
        }
    }

    final /* synthetic */ void m40958a(Boolean bool) throws Exception {
        this.overflowMenuOpen = bool.booleanValue();
        if (this.overflowMenuOpen == null) {
            m39045R();
        }
        mo7436L();
    }

    private int ag() {
        Resources ao_ = ao_();
        if (ao_ != null) {
            int identifier = ao_.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                return ao_.getDimensionPixelSize(identifier);
            }
        }
        return 126;
    }

    protected final void mo7438P() {
        if (this.simpleExoPlayerView != null) {
            new Handler().postDelayed(new SimpleExoPlayerView$$Lambda$0(this.simpleExoPlayerView), 0);
        }
    }

    protected final void mo7439Q() {
        if (this.simpleExoPlayerView != null) {
            this.simpleExoPlayerView.f22181b.m24305b(true);
        }
    }

    protected final void mo6993c(View view) {
        if (this.f40153z != null) {
            this.f40153z.disable();
            this.f40153z = null;
        }
        this.f40144A = 0;
        this.f40147D.removeCallbacks(this.f40150G);
        super.mo6993c(view);
    }

    final /* synthetic */ void m40953Z() {
        if (this.e) {
            m39045R();
        }
    }
}

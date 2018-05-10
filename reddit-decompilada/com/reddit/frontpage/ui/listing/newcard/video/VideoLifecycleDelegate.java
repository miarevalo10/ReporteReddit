package com.reddit.frontpage.ui.listing.newcard.video;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerEvent;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.NetworkUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.ScreenUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.VideoStateUtil;
import com.reddit.frontpage.util.VideoStateUtil.VideoState;
import com.reddit.frontpage.util.VideoUtil;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView.SizeToggleListener;
import com.reddit.frontpage.widgets.video.VideoPlayer;
import com.reddit.frontpage.widgets.video.VideoPlayer.VideoListener;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import timber.log.Timber;

public class VideoLifecycleDelegate {
    static final Subject<String> f21419a = PublishSubject.create();
    private final SizeToggleListener f21420A = new C23511(this);
    public final Activity f21421b;
    final VideoView f21422c;
    final SimpleExoPlayerView f21423d;
    public boolean f21424e;
    public boolean f21425f;
    public VideoPlayer f21426g;
    boolean f21427h;
    boolean f21428i;
    String f21429j;
    boolean f21430k;
    boolean f21431l;
    Link f21432m;
    public int f21433n = -1;
    public Consumer<Integer> f21434o;
    public Consumer<Integer> f21435p;
    LinkPresentationModel f21436q;
    private final View f21437r;
    private final int f21438s;
    private final int f21439t;
    private boolean f21440u;
    private String f21441v;
    private boolean f21442w;
    private boolean f21443x;
    private final Rect f21444y = new Rect();
    private CompositeDisposable f21445z;

    private static final class ContentDimensions {
        final int f21417a;
        final int f21418b;

        ContentDimensions(int i, int i2) {
            this.f21417a = i;
            this.f21418b = i2;
        }
    }

    class C23511 implements SizeToggleListener {
        final /* synthetic */ VideoLifecycleDelegate f29154a;

        C23511(VideoLifecycleDelegate videoLifecycleDelegate) {
            this.f29154a = videoLifecycleDelegate;
        }

        public final void mo4970a() {
            this.f29154a.f21422c.ad_();
            this.f29154a.m23516a();
        }
    }

    class C23522 implements VideoListener {
        final /* synthetic */ VideoLifecycleDelegate f29155a;

        public final void mo4999a() {
        }

        public final void mo5000a(int i, int i2) {
        }

        C23522(VideoLifecycleDelegate videoLifecycleDelegate) {
            this.f29155a = videoLifecycleDelegate;
        }

        public final void mo5001a(boolean z, int i) {
            switch (i) {
                case 2:
                    this.f29155a.f21423d.f22180a.setVisibility(8);
                    return;
                case 3:
                    this.f29155a.f21423d.m24329a(this.f29155a.f21426g);
                    return;
                case 4:
                    ScreenUtil.m23891c(this.f29155a.f21421b);
                    break;
                default:
                    break;
            }
        }
    }

    public final void m23517a(int i) {
        this.f21434o.mo4813a(Integer.valueOf(i));
    }

    public final void m23520a(Consumer<Integer> consumer) {
        this.f21434o = consumer;
    }

    public final void m23524b(Consumer<Integer> consumer) {
        this.f21435p = consumer;
    }

    public VideoLifecycleDelegate(int i, int i2, VideoView videoView, View view, SimpleExoPlayerView simpleExoPlayerView) {
        this.f21438s = i;
        this.f21439t = i2;
        this.f21422c = videoView;
        this.f21437r = view;
        this.f21423d = simpleExoPlayerView;
        this.f21421b = Util.m23954a(simpleExoPlayerView.getContext());
    }

    public final void m23523b(int i) {
        this.f21433n = i;
    }

    final void m23516a() {
        this.f21424e = true;
        if (this.f21426g != null) {
            this.f21426g.m24367c(VideoPlayerEvent.VIDEO_PLAYER_SERVED_VIDEO);
            m23530h();
            this.f21423d.m24328a();
            this.f21426g.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CLICK_FULLSCREEN);
            this.f21426g.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CHANGE_PAGETYPE);
            if (Util.m24028f(this.f21432m)) {
                this.f21426g.m24368d();
            }
            this.f21426g = null;
            this.f21422c.a_(this.f21432m);
            this.f21422c.mo6966b(this.f21436q);
        }
    }

    public final void m23519a(LinkPresentationModel linkPresentationModel) {
        this.f21436q = linkPresentationModel;
        m23518a(new ClientLink(linkPresentationModel.av));
    }

    public final void m23518a(Link link) {
        this.f21432m = link;
        this.f21440u = VideoUtil.m24054a();
        this.f21431l = this.f21440u;
        this.f21430k = false;
        this.f21424e = false;
        this.f21425f = false;
        this.f21428i = false;
        this.f21442w = false;
        this.f21437r.setOnClickListener(null);
        Point point = new Point(this.f21438s, this.f21439t);
        ImageResolution a = LinkUtil.m23775a(link, FrontpageSettings.a().g(), point);
        if (a == null) {
            this.f21423d.setVisibility(8);
            return;
        }
        boolean z;
        float width;
        int E;
        ContentDimensions contentDimensions;
        this.f21429j = Util.m23996b(link, point);
        Timber.b("VideoCardLinkViewHolder: extracted mp4 url [%s] %s", new Object[]{link.getTitle(), this.f21429j});
        if (!link.isGif()) {
            if (link.getPreview() == null) {
                z = false;
                this.f21427h = z;
                if (m23512p()) {
                    this.f21423d.setPlayer(null);
                    this.f21441v = "no_video";
                    this.f21437r.setOnClickListener(new VideoLifecycleDelegate$$Lambda$1(this, link));
                } else {
                    if (this.f21440u) {
                        this.f21423d.setShowShutterImage(false);
                    }
                    if (!this.f21422c.mo6957C()) {
                        m23531i();
                    }
                    this.f21437r.setOnClickListener(new VideoLifecycleDelegate$$Lambda$0(this, link));
                }
                link = (float) a.getHeight();
                width = (float) a.getWidth();
                E = this.f21422c.mo6959E();
                if (link < width) {
                    link = (int) ((((float) E) / link) * width);
                } else {
                    int i = E;
                    E = (int) Math.max((float) FrontpageApplication.f27402a.getResources().getDimensionPixelSize(C1761R.dimen.link_image_min_height), (((float) E) / width) * link);
                    link = i;
                }
                contentDimensions = new ContentDimensions(link, E);
                this.f21423d.getLayoutParams().height = contentDimensions.f21418b;
                this.f21423d.m24330a(a.getUrl(), contentDimensions.f21417a, contentDimensions.f21418b);
                this.f21423d.setMuteAlwaysInvisible(true);
            }
        }
        z = true;
        this.f21427h = z;
        if (m23512p()) {
            this.f21423d.setPlayer(null);
            this.f21441v = "no_video";
            this.f21437r.setOnClickListener(new VideoLifecycleDelegate$$Lambda$1(this, link));
        } else {
            if (this.f21440u) {
                this.f21423d.setShowShutterImage(false);
            }
            if (this.f21422c.mo6957C()) {
                m23531i();
            }
            this.f21437r.setOnClickListener(new VideoLifecycleDelegate$$Lambda$0(this, link));
        }
        link = (float) a.getHeight();
        width = (float) a.getWidth();
        E = this.f21422c.mo6959E();
        if (link < width) {
            int i2 = E;
            E = (int) Math.max((float) FrontpageApplication.f27402a.getResources().getDimensionPixelSize(C1761R.dimen.link_image_min_height), (((float) E) / width) * link);
            link = i2;
        } else {
            link = (int) ((((float) E) / link) * width);
        }
        contentDimensions = new ContentDimensions(link, E);
        this.f21423d.getLayoutParams().height = contentDimensions.f21418b;
        this.f21423d.m24330a(a.getUrl(), contentDimensions.f21417a, contentDimensions.f21418b);
        this.f21423d.setMuteAlwaysInvisible(true);
    }

    public final void m23522b() {
        this.f21424e = true;
        if (this.f21426g != null) {
            m23530h();
            this.f21426g.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CHANGE_PAGETYPE);
            this.f21423d.m24328a();
            this.f21426g = null;
        }
    }

    public final void m23525c() {
        this.f21424e = true;
    }

    public final void m23526d() {
        if (m23512p()) {
            if (this.f21426g == null && !this.f21422c.mo6957C()) {
                m23531i();
            }
            this.f21445z = new CompositeDisposable();
            this.f21445z.mo5631a(f21419a.distinctUntilChanged().subscribe(new VideoLifecycleDelegate$$Lambda$4(this), VideoLifecycleDelegate$$Lambda$5.f29151a));
            this.f21445z.mo5631a(FrontpageApplication.m28872h().mo4570c().getBus().filter(new VideoLifecycleDelegate$$Lambda$6(this)).observeOn(SchedulerProvider.m23887c()).subscribe(new VideoLifecycleDelegate$$Lambda$7(this)));
            this.f21445z.mo5631a(BaseActivity.m42469e().observeOn(SchedulerProvider.m23887c()).filter(VideoLifecycleDelegate$$Lambda$2.f29148a).subscribe(new VideoLifecycleDelegate$$Lambda$3(this)));
            if (this.f21426g != null) {
                if (!this.f21443x) {
                    FrontpageApplication.m28871g().mo5026b();
                    VideoState a = VideoStateUtil.m24046a(this.f21429j);
                    if (a != null) {
                        this.f21426g.f22224f = a.getPosition();
                        this.f21443x = true;
                    }
                }
                boolean q = m23513q();
                if (q != this.f21425f) {
                    if (this.f21440u && !this.f21426g.m24371g()) {
                        this.f21430k = true;
                        if (!this.f21428i) {
                            this.f21428i = true;
                            this.f21426g.m24367c(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_AUTOPLAY);
                        }
                        if (this.f21435p != null && q) {
                            this.f21435p.mo4813a(Integer.valueOf(this.f21433n));
                        }
                    }
                    m23521a(q);
                } else if (!(q || this.f21426g == null || !this.f21426g.m24371g())) {
                    m23511o();
                }
            }
            m23514r();
        }
    }

    public final void m23527e() {
        this.f21443x = false;
        if (m23512p()) {
            if (this.f21426g != null && this.f21426g.m24372h() > 0 && this.f21422c.mo6956B()) {
                this.f21426g.m24368d();
                m23530h();
                if (!this.f21442w) {
                    this.f21426g.m24367c(VideoPlayerEvent.VIDEO_PLAYER_SERVED_VIDEO);
                    this.f21442w = true;
                }
                this.f21428i = true;
            }
            if (this.f21445z != null) {
                this.f21445z.mo5626a();
                this.f21445z = null;
            }
            m23529g();
        }
    }

    public final void m23528f() {
        if (this.f21426g != null) {
            m23527e();
        }
    }

    private void m23511o() {
        if (!this.f21422c.mo6957C()) {
            m23530h();
            this.f21426g.m24368d();
            this.f21426g.m24367c(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_PAUSE);
        }
    }

    private boolean m23512p() {
        if (TextUtils.isEmpty(this.f21429j)) {
            if (this.f21432m.getPreview() == null) {
                return false;
            }
        }
        return true;
    }

    public final void m23521a(boolean z) {
        this.f21425f = z;
        if (z) {
            boolean z2;
            FrontpageSettings a;
            if (!(this.f21426g && this.f21426g.f22221c)) {
                m23531i();
            }
            m23514r();
            FrontpageApplication.m28871g().mo5026b();
            z = VideoStateUtil.m24046a(this.f21429j);
            boolean z3 = false;
            if (z) {
                if (!z.isPlaying()) {
                    z2 = false;
                    if (z2) {
                        this.f21430k = true;
                        a = FrontpageSettings.a();
                        if (a.h() == 1 || (a.h() == 2 && NetworkUtil.m23843c())) {
                            z3 = true;
                        }
                        if (z && r0 && this.f21426g.m24369e() > z.getPosition()) {
                            this.f21426g.m24358a(z.getPosition());
                        }
                        this.f21426g.m24366c();
                        ScreenUtil.m23890b(this.f21421b);
                        if (!this.f21426g.f22223e) {
                            FrontpageApplication.m28873i().mo5025a().m23652a();
                        }
                        this.f21423d.setPlayer(this.f21426g.f22221c);
                        f21419a.onNext(this.f21432m.getId());
                    }
                    return;
                }
            }
            z2 = true;
            if (z2) {
                this.f21430k = true;
                a = FrontpageSettings.a();
                z3 = true;
                this.f21426g.m24358a(z.getPosition());
                this.f21426g.m24366c();
                ScreenUtil.m23890b(this.f21421b);
                if (this.f21426g.f22223e) {
                    FrontpageApplication.m28873i().mo5025a().m23652a();
                }
                this.f21423d.setPlayer(this.f21426g.f22221c);
                f21419a.onNext(this.f21432m.getId());
            }
            return;
        }
        if (this.f21426g) {
            m23511o();
        }
    }

    private void m23514r() {
        if (this.f21426g == null || this.f21426g.f22221c == null || this.f21426g.f22221c.c != null) {
            this.f21423d.setMuteAlwaysInvisible(false);
        } else {
            this.f21423d.setMuteAlwaysInvisible(true);
        }
    }

    public final void m23529g() {
        if (this.f21426g != null) {
            if (!this.f21424e && this.f21422c.mo6958D()) {
                m23530h();
                this.f21426g.m24368d();
                ScreenUtil.m23891c(this.f21421b);
            }
            if (!this.f21424e) {
                if (this.f21426g.m24365b(m23515s())) {
                    this.f21423d.setPlayer(null);
                    this.f21426g = null;
                }
            }
            this.f21423d.m24328a();
            this.f21426g = null;
        }
    }

    final void m23530h() {
        if (this.f21430k && this.f21426g != null && !this.f21426g.m24374j()) {
            boolean a;
            FrontpageApplication.m28871g().mo5026b();
            String str = this.f21429j;
            if (this.f21427h) {
                a = VideoUtil.m24054a();
            } else {
                a = this.f21431l;
            }
            VideoStateUtil.m24048a(str, a, this.f21426g.m24372h(), this.f21426g.f22223e);
        }
    }

    final void m23531i() {
        FrontpageApplication.m28871g().mo5026b();
        VideoState a = VideoStateUtil.m24046a(this.f21429j);
        this.f21441v = VideoUtil.m24053a(this.f21432m);
        this.f21426g = VideoPlayer.m24338a(this.f21441v);
        boolean z = false;
        final boolean z2 = this.f21426g == null;
        if (z2) {
            boolean z3;
            this.f21426g = VideoPlayer.m24336a(FrontpageApplication.f27402a.getApplicationContext(), this.f21441v, m23515s());
            VideoPlayer videoPlayer = this.f21426g;
            if (a != null) {
                if (!a.isMuted()) {
                    z3 = false;
                    videoPlayer.m24362a(z3);
                    this.f21426g.m24361a(this.f21429j, Util.m24038j(this.f21432m), this.f21427h);
                    if (a != null && this.f21440u) {
                        this.f21426g.m24358a(a.getPosition());
                    }
                }
            }
            z3 = true;
            videoPlayer.m24362a(z3);
            this.f21426g.m24361a(this.f21429j, Util.m24038j(this.f21432m), this.f21427h);
            this.f21426g.m24358a(a.getPosition());
        }
        this.f21426g.m24359a(this.f21432m, this.f21422c.mo6971y(), this.f21422c.mo6970x());
        if (a != null) {
            boolean z4 = this.f21440u && a.isPlaying();
            this.f21440u = z4;
        }
        this.f21423d.setUseController(this.f21427h ^ true);
        this.f21423d.setIsMutable(this.f21427h ^ true);
        this.f21423d.setMuteAlwaysVisible(this.f21427h ^ true);
        this.f21423d.setAcceptTouchesAlways(this.f21427h);
        m23514r();
        this.f21423d.setSizeToggleListener(this.f21420A);
        if (!this.f21440u) {
            if (a == null || a.getPosition() <= 0) {
                this.f21423d.setShowControllerInitially(true);
                this.f21423d.setPlayer(null);
                if (this.f21426g.m24371g() || this.f21426g.m24372h() > 0) {
                    z = true;
                }
                this.f21430k = z;
                if (this.f21440u) {
                    this.f21423d.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ VideoLifecycleDelegate f21416b;

                        public boolean onPreDraw() {
                            this.f21416b.f21423d.getViewTreeObserver().removeOnPreDrawListener(this);
                            if (this.f21416b.f21426g != null) {
                                FrontpageApplication.m28871g().mo5026b();
                                VideoState a = VideoStateUtil.m24046a(this.f21416b.f21429j);
                                boolean z = false;
                                if (this.f21416b.m23513q()) {
                                    boolean z2 = (a == null || a.isPlaying()) && !this.f21416b.f21422c.mo6957C();
                                    if (z2) {
                                        this.f21416b.f21430k = true;
                                        this.f21416b.f21431l = true;
                                        this.f21416b.f21426g.m24366c();
                                        ScreenUtil.m23890b(this.f21416b.f21421b);
                                        if (!this.f21416b.f21426g.f22223e) {
                                            FrontpageApplication.m28873i().mo5025a().m23652a();
                                        }
                                        VideoLifecycleDelegate.f21419a.onNext(this.f21416b.f21432m.getId());
                                    }
                                } else if (!this.f21416b.f21422c.mo6957C()) {
                                    this.f21416b.f21426g.m24368d();
                                }
                                if (z2) {
                                    VideoPlayer c = this.f21416b.f21426g;
                                    if (a == null || a.isMuted()) {
                                        z = true;
                                    }
                                    c.m24362a(z);
                                }
                            }
                            return true;
                        }
                    });
                    this.f21423d.invalidate();
                } else if (a != null && a.getPosition() > 0) {
                    this.f21426g.m24358a(a.getPosition());
                }
                this.f21426g.m24360a(new C23522(this));
            }
        }
        int i = ((this.f21440u || a.isPlaying()) && this.f21426g.m24373i() != 4) ? 1 : 0;
        this.f21423d.setShowControllerInitially(i ^ true);
        if (!this.f21422c.mo6957C()) {
            this.f21423d.setPlayer(this.f21426g.f22221c);
        }
        z = true;
        this.f21430k = z;
        if (this.f21440u) {
            this.f21423d.getViewTreeObserver().addOnPreDrawListener(/* anonymous class already generated */);
            this.f21423d.invalidate();
        } else {
            this.f21426g.m24358a(a.getPosition());
        }
        this.f21426g.m24360a(new C23522(this));
    }

    public final VideoPlayer m23532j() {
        return this.f21426g;
    }

    private String m23515s() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f21422c.mo6972z());
        stringBuilder.append(this.f21441v);
        return stringBuilder.toString();
    }

    public final void m23533k() {
        if (this.f21426g != null) {
            this.f21426g.m24368d();
            ScreenUtil.m23891c(this.f21421b);
        }
    }

    public final void m23534l() {
        if (this.f21426g == null) {
            m23531i();
            m23526d();
            return;
        }
        this.f21426g.m24366c();
        ScreenUtil.m23890b(this.f21421b);
    }

    private boolean m23513q() {
        boolean z = this.f21440u;
        if (!z) {
            z = this.f21426g != null && this.f21430k;
        }
        if (!z) {
            FrontpageApplication.m28871g().mo5026b();
            VideoState a = VideoStateUtil.m24046a(this.f21429j);
            z = a != null && a.isPlaying();
        }
        if (!z) {
            return false;
        }
        this.f21423d.getLocalVisibleRect(this.f21444y);
        if (this.f21444y.top >= 0) {
            if (this.f21444y.top <= this.f21423d.getHeight()) {
                Timber.b("[%s]: Percent visible: [%f]", new Object[]{this.f21432m.getId(), Float.valueOf(((float) (this.f21444y.bottom - this.f21444y.top)) / ((float) this.f21423d.getHeight()))});
                return ((float) (this.f21444y.bottom - this.f21444y.top)) / ((float) this.f21423d.getHeight()) >= 0.6f;
            }
        }
        return false;
    }
}

package com.reddit.frontpage.widgets.video;

import android.content.Context;
import android.os.SystemClock;
import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayer.EventListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.bus.VideoPlayerStateChangedEventBus.PlayerState;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerEvent;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.ScreenUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.video.VideoEventBus.VideoEventWrapper;
import io.reactivex.disposables.CompositeDisposable;

public class PlaybackControlView extends FrameLayout {
    String f22113a;
    int f22114b;
    ClippingBounds f22115c;
    private final ComponentListener f22116d;
    private final View f22117e;
    private final View f22118f;
    private final View f22119g;
    private ExoPlayer f22120h;
    private VideoEventBus f22121i;
    private CompositeDisposable f22122j;
    private boolean f22123k;
    private int f22124l;
    private long f22125m;
    private boolean f22126n;
    private final Fade f22127o;
    private final Runnable f22128p;

    private final class ComponentListener implements OnClickListener, EventListener {
        final /* synthetic */ PlaybackControlView f34565a;

        public final void m35374a() {
        }

        public final void m35375a(ExoPlaybackException exoPlaybackException) {
        }

        public final void m35376a(Timeline timeline) {
        }

        public final void m35377a(TrackSelectionArray trackSelectionArray) {
        }

        public final void m35378a(boolean z) {
        }

        private ComponentListener(PlaybackControlView playbackControlView) {
            this.f34565a = playbackControlView;
        }

        public final void m35379a(boolean z, int i) {
            this.f34565a.m24258d();
        }

        public final void onClick(View view) {
            if (this.f34565a.f22120h != null) {
                VideoPlayer a = VideoPlayer.m24337a(this.f34565a.f22120h);
                boolean z = true;
                if (this.f34565a.f22117e == view) {
                    this.f34565a.f22120h.a(this.f34565a.f22126n);
                    z = this.f34565a.f22126n;
                    if (!(this.f34565a.f22126n == null || a == null)) {
                        a.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CLICK_PLAY);
                    }
                    ScreenUtil.m23890b(Util.m24014d(this.f34565a.getContext()));
                } else {
                    if (this.f34565a.f22118f == view) {
                        this.f34565a.f22120h.a(false);
                        ScreenUtil.m23891c(Util.m24014d(this.f34565a.getContext()));
                        if (a != null) {
                            a.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CLICK_PAUSE);
                        }
                    } else if (this.f34565a.f22119g == view && this.f34565a.f22126n != null) {
                        ScreenUtil.m23890b(Util.m24014d(this.f34565a.getContext()));
                        this.f34565a.f22120h.a(this.f34565a.f22115c != null ? ((long) this.f34565a.f22115c.f22104b) * 1000 : 0);
                        this.f34565a.f22120h.a(true);
                        if (a != null) {
                            a.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CLICK_REPLAY);
                        }
                    }
                    z = false;
                }
                FrontpageApplication.m28872h().mo4570c().post(new PlayerState(this.f34565a.f22113a, z));
            }
            this.f34565a.m24269b();
        }
    }

    public PlaybackControlView(Context context) {
        this(context, null);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22126n = true;
        this.f22114b = -1;
        this.f22128p = new PlaybackControlView$$Lambda$0(this);
        this.f22116d = new ComponentListener();
        LayoutInflater.from(context).inflate(C1761R.layout.simple_exoplayer_control_view, this);
        setDescendantFocusability(262144);
        this.f22117e = findViewById(C1761R.id.exo_play);
        if (this.f22117e != null) {
            this.f22117e.setOnClickListener(this.f22116d);
        }
        this.f22119g = findViewById(C1761R.id.exo_replay);
        if (this.f22119g != null) {
            this.f22119g.setOnClickListener(this.f22116d);
        }
        this.f22118f = findViewById(C1761R.id.exo_pause);
        if (this.f22118f != null) {
            this.f22118f.setOnClickListener(this.f22116d);
        }
        this.f22127o = new Fade();
        this.f22127o.a((long) getResources().getInteger(17694721));
    }

    public ExoPlayer getPlayer() {
        return this.f22120h;
    }

    public final void m24266a(ExoPlayer exoPlayer, String str) {
        this.f22113a = str;
        if (this.f22120h != exoPlayer) {
            if (this.f22120h != null) {
                this.f22120h.b(this.f22116d);
            }
            this.f22120h = exoPlayer;
            if (exoPlayer != null) {
                exoPlayer.a(this.f22116d);
            }
        }
        m24258d();
    }

    public void setCanPlay(boolean z) {
        this.f22126n = z;
    }

    public int getShowTimeoutMs() {
        return this.f22124l;
    }

    public void setShowTimeoutMs(int i) {
        this.f22124l = i;
    }

    public final void m24267a(boolean z) {
        if (!m24268a()) {
            TransitionManager.a(this, this.f22127o);
            setVisibility(0);
            m24257c(false);
            if (this.f22121i != null) {
                this.f22121i.post(new VideoEventWrapper(0, this.f22114b));
            }
            m24258d();
            m24261e();
        }
        if (z) {
            m24269b();
        } else {
            removeCallbacks(this.f22128p);
        }
    }

    public final void m24270b(boolean z) {
        if (m24268a()) {
            TransitionManager.a(this, this.f22127o);
            setVisibility(8);
            m24257c(true);
            if (this.f22121i != null && z) {
                this.f22121i.post(new VideoEventWrapper(1, this.f22114b));
            }
            removeCallbacks(this.f22128p);
            this.f22125m = -9223372036854775807L;
        }
    }

    public final boolean m24268a() {
        return getVisibility() == 0;
    }

    public void setVideoEventBus(VideoEventBus videoEventBus) {
        this.f22121i = videoEventBus;
        this.f22114b = videoEventBus.getSenderId();
        m24256c();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f22123k = true;
        m24256c();
        if (this.f22125m != -9223372036854775807L) {
            long uptimeMillis = this.f22125m - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                m24270b(true);
            } else {
                postDelayed(this.f22128p, uptimeMillis);
            }
        }
        m24258d();
    }

    public void onDetachedFromWindow() {
        this.f22123k = false;
        removeCallbacks(this.f22128p);
        if (this.f22122j != null) {
            this.f22122j.mo5626a();
            this.f22122j = null;
        }
        super.onDetachedFromWindow();
    }

    private void m24256c() {
        if (this.f22122j != null) {
            this.f22122j.mo5626a();
        }
        if (this.f22123k) {
            this.f22122j = new CompositeDisposable();
            if (this.f22121i != null) {
                this.f22122j.mo5631a(this.f22121i.asObservable().filter(new PlaybackControlView$$Lambda$1(this)).observeOn(SchedulerProvider.m23887c()).subscribe(new PlaybackControlView$$Lambda$2(this)));
                this.f22121i.post(new VideoEventWrapper(m24268a() ^ 1, this.f22114b));
            }
            this.f22122j.mo5631a(FrontpageApplication.m28872h().mo4569b().f22106a.filter(new PlaybackControlView$$Lambda$3(this)).observeOn(SchedulerProvider.m23887c()).subscribe(new PlaybackControlView$$Lambda$4(this)));
        }
    }

    final void m24269b() {
        removeCallbacks(this.f22128p);
        if (this.f22124l > 0) {
            this.f22125m = SystemClock.uptimeMillis() + ((long) this.f22124l);
            if (this.f22123k) {
                postDelayed(this.f22128p, (long) this.f22124l);
                return;
            }
        }
        this.f22125m = -9223372036854775807L;
    }

    private void m24258d() {
        if (m24268a()) {
            if (this.f22123k) {
                int i;
                int i2 = 1;
                int i3 = 0;
                int i4 = (this.f22120h == null || !this.f22120h.b()) ? 0 : 1;
                int i5 = (this.f22120h == null || this.f22119g == null || (this.f22120h.a() != 4 && (this.f22115c == null || (this.f22120h.f() + 500) / 1000 < ((long) this.f22115c.f22105c)))) ? 0 : 1;
                if (this.f22117e != null) {
                    int i6;
                    i = (i4 == 0 || !this.f22117e.isFocused()) ? 0 : 1;
                    View view = this.f22117e;
                    if (i5 == 0) {
                        if (i4 == 0) {
                            i6 = 0;
                            view.setVisibility(i6);
                        }
                    }
                    i6 = 8;
                    view.setVisibility(i6);
                } else {
                    i = 0;
                }
                if (this.f22118f != null) {
                    if (i4 != 0 || !this.f22118f.isFocused()) {
                        i2 = 0;
                    }
                    i |= i2;
                    View view2 = this.f22118f;
                    if (i5 == 0) {
                        if (i4 != 0) {
                            i4 = 0;
                            view2.setVisibility(i4);
                        }
                    }
                    i4 = 8;
                    view2.setVisibility(i4);
                }
                if (this.f22119g != null) {
                    i |= i5;
                    View view3 = this.f22119g;
                    if (i5 == 0) {
                        i3 = 8;
                    }
                    view3.setVisibility(i3);
                }
                if (i != 0) {
                    m24261e();
                }
            }
        }
    }

    private void m24257c(boolean z) {
        int i = 0;
        if (this.f22117e != null) {
            this.f22117e.setVisibility(z ? 8 : 0);
        }
        if (this.f22118f != null) {
            this.f22118f.setVisibility(z ? 8 : 0);
        }
        if (this.f22119g != null) {
            View view = this.f22119g;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    private void m24261e() {
        Object obj = null;
        Object obj2 = (this.f22120h == null || !this.f22120h.b()) ? null : 1;
        if (!(this.f22120h == null || this.f22119g == null || this.f22120h.a() != 4)) {
            obj = 1;
        }
        if (obj2 == null && obj == null && this.f22117e != null) {
            this.f22117e.requestFocus();
        } else if (obj2 == null || obj != null || this.f22118f == null) {
            if (obj != null) {
                this.f22119g.requestFocus();
            }
        } else {
            this.f22118f.requestFocus();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        int keyCode = keyEvent.getKeyCode();
        boolean z2 = false;
        if (this.f22120h != null) {
            boolean z3;
            if (!(keyCode == 85 || keyCode == 126)) {
                if (keyCode != 127) {
                    z3 = false;
                    if (!z3) {
                        if (keyEvent.getAction() == 0) {
                            if (keyCode != 85) {
                                switch (keyCode) {
                                    case 126:
                                        this.f22120h.a(this.f22126n);
                                        break;
                                    case 127:
                                        this.f22120h.a(false);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.f22120h.a(this.f22120h.b() ^ true);
                        }
                        m24267a(true);
                        z = true;
                        if (z || super.dispatchKeyEvent(keyEvent) != null) {
                            z2 = true;
                        }
                        if (z2) {
                            m24267a(true);
                        }
                        return z2;
                    }
                }
            }
            z3 = true;
            if (!z3) {
                if (keyEvent.getAction() == 0) {
                    if (keyCode != 85) {
                        switch (keyCode) {
                            case 126:
                                this.f22120h.a(this.f22126n);
                                break;
                            case 127:
                                this.f22120h.a(false);
                                break;
                            default:
                                break;
                        }
                    }
                    this.f22120h.a(this.f22120h.b() ^ true);
                }
                m24267a(true);
                z = true;
                z2 = true;
                if (z2) {
                    m24267a(true);
                }
                return z2;
            }
        }
        z = false;
        z2 = true;
        if (z2) {
            m24267a(true);
        }
        return z2;
    }
}

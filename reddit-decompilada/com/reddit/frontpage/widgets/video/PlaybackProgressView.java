package com.reddit.frontpage.widgets.video;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayer.EventListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerEvent;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.widgets.LinkFooterView;
import com.reddit.frontpage.widgets.LinkFooterView.OnShareListener;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView.SizeToggleListener;
import com.reddit.frontpage.widgets.video.VideoEventBus.VideoEventWrapper;
import com.reddit.frontpage.widgets.video.VideoPlayer.VideoListener;
import com.reddit.frontpage.widgets.video.VideoPlayer.VideoListenerAdapter;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PlaybackProgressView extends FrameLayout {
    private static long f22133I;
    public static final SeekDispatcher f22134a = PlaybackProgressView$$Lambda$10.f29547a;
    private static final AtomicInteger f22135u = new AtomicInteger(0);
    private boolean f22136A;
    private boolean f22137B;
    private boolean f22138C;
    private boolean f22139D;
    private VideoEventBus f22140E;
    private Disposable f22141F;
    private Disposable f22142G;
    private Disposable f22143H;
    private final Runnable f22144J;
    private final VideoListener f22145K;
    final ImageButton f22146b;
    ExoPlayer f22147c;
    boolean f22148d;
    int f22149e;
    private final ComponentListener f22150f;
    private final View f22151g;
    private final View f22152h;
    private final TextView f22153i;
    private final TextView f22154j;
    private final SeekBar f22155k;
    private final StringBuilder f22156l;
    private final Formatter f22157m;
    private final Window f22158n;
    private final ImageButton f22159o;
    private final TextureView f22160p;
    private final LinearLayout f22161q;
    private final LinkFooterView f22162r;
    private VideoPlayer f22163s;
    private String f22164t;
    private final int f22165v;
    private String f22166w;
    private final SeekDispatcher f22167x;
    private SizeToggleListener f22168y;
    private boolean f22169z;

    interface SeekDispatcher {
        boolean mo5076a(ExoPlayer exoPlayer, int i, long j);
    }

    class C27041 extends VideoListenerAdapter {
        final /* synthetic */ PlaybackProgressView f34566a;

        C27041(PlaybackProgressView playbackProgressView) {
            this.f34566a = playbackProgressView;
        }

        public final void mo5000a(int i, int i2) {
            float a = ((float) this.f34566a.f22165v) * (((float) i2) / ((float) i));
            i = this.f34566a.f22160p.getLayoutParams();
            i.height = (int) (a + 1056964608);
            this.f34566a.f22160p.setLayoutParams(i);
        }
    }

    private final class ComponentListener implements OnClickListener, OnSeekBarChangeListener, EventListener {
        final /* synthetic */ PlaybackProgressView f34567a;
        private int f34568b;
        private int f34569c;
        private Disposable f34570d;
        private final Subject<Long> f34571e;

        public final void m35383a(ExoPlaybackException exoPlaybackException) {
        }

        public final void m35385a(TrackSelectionArray trackSelectionArray) {
        }

        public final void m35386a(boolean z) {
        }

        private ComponentListener(PlaybackProgressView playbackProgressView) {
            this.f34567a = playbackProgressView;
            this.f34571e = PublishSubject.create();
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
            this.f34567a.f22136A = true;
            this.f34567a.m24279a(new VideoEventWrapper(2, this.f34567a.f22149e));
            if (this.f34567a.f22163s != null) {
                this.f34570d = this.f34571e.throttleLast(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.m26509a()).subscribe(new PlaybackProgressView$ComponentListener$$Lambda$0(this));
                this.f34568b = this.f34567a.f22155k.getLeft() + this.f34567a.f22155k.getPaddingLeft();
                this.f34569c = this.f34567a.f22155k.getRight() - this.f34567a.f22155k.getPaddingRight();
                this.f34567a.f22160p.setVisibility(0);
                this.f34567a.f22160p.setTranslationX(m35381b());
            }
        }

        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                long a = PlaybackProgressView.m24273a(this.f34567a, i);
                this.f34571e.onNext(Long.valueOf(a));
                this.f34567a.m24275a(a);
                if (this.f34567a.f22154j) {
                    this.f34567a.f22154j.setText(this.f34567a.m24284b(a));
                }
                if (this.f34567a.f22163s != null && this.f34567a.f22136A != null) {
                    this.f34567a.f22160p.setTranslationX(m35381b());
                }
            }
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
            this.f34567a.f22136A = false;
            if (this.f34570d != null) {
                this.f34570d.mo5626a();
                this.f34570d = null;
            }
            if (this.f34567a.f22147c != null) {
                PlaybackProgressView.m24277a(this.f34567a, this.f34567a.f22147c, PlaybackProgressView.m24273a(this.f34567a, seekBar.getProgress()));
                seekBar = VideoPlayer.m24337a(this.f34567a.f22147c);
                if (seekBar != null) {
                    seekBar.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CLICK_SEEK);
                }
            }
            this.f34567a.f22160p.setVisibility(4);
            if (this.f34567a.f22147c.b() != null) {
                this.f34567a.m24279a(new VideoEventWrapper(3, this.f34567a.f22149e));
            }
        }

        public final void m35387a(boolean z, int i) {
            this.f34567a.m24306c();
        }

        public final void m35382a() {
            this.f34567a.m24291e();
            this.f34567a.m24306c();
        }

        public final void m35384a(Timeline timeline) {
            this.f34567a.m24291e();
            this.f34567a.m24306c();
        }

        public final void onClick(View view) {
            if (view == this.f34567a.f22146b) {
                PlaybackProgressView.m24298k(this.f34567a);
                return;
            }
            if (view == this.f34567a.f22159o) {
                PlaybackProgressView.m24300m(this.f34567a);
            }
        }

        private float m35381b() {
            return (((float) this.f34568b) + (((float) (this.f34569c - this.f34568b)) * (((float) this.f34567a.f22155k.getProgress()) / 1000.0f))) - (((float) this.f34567a.f22165v) / 2.0f);
        }
    }

    static final /* synthetic */ boolean m24280a(ExoPlayer exoPlayer, int i, long j) {
        f22133I = exoPlayer.f();
        exoPlayer.a(i, j);
        return true;
    }

    public static long getBeforeProgressChangeMills() {
        return f22133I;
    }

    public static void m24274a() {
        f22133I = 0;
    }

    public PlaybackProgressView(Context context) {
        this(context, null);
    }

    public PlaybackProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlaybackProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22148d = false;
        this.f22144J = new PlaybackProgressView$$Lambda$0(this);
        this.f22145K = new C27041(this);
        this.f22158n = new Window();
        this.f22156l = new StringBuilder();
        this.f22157m = new Formatter(this.f22156l, Locale.getDefault());
        this.f22150f = new ComponentListener();
        this.f22167x = f22134a;
        LayoutInflater.from(context).inflate(C1761R.layout.exoplayer_progress_view, this);
        setDescendantFocusability(262144);
        this.f22151g = findViewById(C1761R.id.exo_bottom_container);
        this.f22152h = findViewById(C1761R.id.exo_progress_container);
        this.f22146b = (ImageButton) findViewById(C1761R.id.exo_mute_button);
        this.f22153i = (TextView) findViewById(C1761R.id.exo_duration);
        this.f22154j = (TextView) findViewById(C1761R.id.exo_position);
        this.f22155k = (SeekBar) findViewById(C1761R.id.exo_progress);
        this.f22160p = (TextureView) findViewById(C1761R.id.exo_thumb_scrubber);
        this.f22161q = (LinearLayout) findViewById(C1761R.id.exo_link_footer_layout);
        this.f22162r = (LinkFooterView) findViewById(C1761R.id.exo_link_footer_view);
        context = ResourcesUtil.m22740i(getContext(), C1761R.attr.rdt_player_control_color);
        LayerDrawable layerDrawable = (LayerDrawable) this.f22155k.getProgressDrawable().mutate();
        layerDrawable.findDrawableByLayerId(16908301).setColorFilter(context, Mode.SRC_IN);
        this.f22155k.setProgressDrawable(layerDrawable);
        attributeSet = this.f22155k.getThumb().mutate();
        attributeSet.setColorFilter(context, Mode.SRC_IN);
        this.f22155k.setThumb(attributeSet);
        this.f22146b.setOnClickListener(this.f22150f);
        this.f22155k.setOnSeekBarChangeListener(this.f22150f);
        this.f22155k.setMax(1000);
        this.f22159o = (ImageButton) findViewById(C1761R.id.exo_size_toggle);
        if (this.f22159o != null) {
            this.f22159o.setVisibility(8);
            this.f22159o.setOnClickListener(this.f22150f);
        }
        this.f22165v = getResources().getDimensionPixelSize(C1761R.dimen.exoplayer_thumb_dimension);
    }

    public ExoPlayer getPlayer() {
        return this.f22147c;
    }

    public final void m24302a(ExoPlayer exoPlayer, String str) {
        this.f22166w = str;
        if (this.f22147c == exoPlayer) {
            if (exoPlayer == null) {
                this.f22151g.setVisibility(8);
                this.f22146b.setVisibility(8);
                this.f22152h.setVisibility(8);
            }
            return;
        }
        if (this.f22147c != null) {
            this.f22147c.b(this.f22150f);
        }
        this.f22147c = exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.a(this.f22150f);
            if (this.f22137B != null) {
                this.f22151g.setVisibility(0);
                this.f22146b.setVisibility(0);
                this.f22152h.setVisibility(8);
            }
            exoPlayer = VideoPlayer.m24337a(exoPlayer);
            if (exoPlayer != null) {
                this.f22146b.setImageResource(exoPlayer.f22223e ? C1761R.drawable.icon_audio_on : C1761R.drawable.icon_audio_off);
                if (exoPlayer.m24371g() == null) {
                    m24303a(false);
                }
            }
            if (this.f22166w != null) {
                if (this.f22163s == null) {
                    exoPlayer = new StringBuilder("SCRUBBER_");
                    exoPlayer.append(f22135u.getAndIncrement());
                    this.f22164t = exoPlayer.toString();
                    this.f22163s = VideoPlayer.m24343b(getContext().getApplicationContext(), this.f22164t, this.f22164t);
                }
                this.f22163s.m24360a(this.f22145K);
                this.f22163s.m24361a(this.f22166w, null, false);
                this.f22163s.m24368d();
                this.f22163s.m24362a(true);
                this.f22163s.f22221c.a(this.f22160p);
            } else {
                m24292f();
            }
        } else {
            m24292f();
        }
        m24304b();
    }

    public void setSizeToggleListener(SizeToggleListener sizeToggleListener) {
        this.f22168y = sizeToggleListener;
    }

    public final void m24303a(boolean z) {
        View view = this.f22137B ? this.f22152h : this.f22151g;
        if ((!this.f22148d && view.getAnimation() != null && view.getAnimation().hasEnded()) || (!this.f22148d && view.getAnimation() == null)) {
            this.f22148d = true;
            view.setAlpha(0.0f);
            if (!this.f22138C) {
                this.f22146b.setVisibility(this.f22139D ? 0 : 4);
            }
            this.f22151g.setVisibility(0);
            this.f22152h.setVisibility(0);
            view.animate().alpha(1.0f).setDuration(z ? (long) getResources().getInteger(17694721) : 0).setInterpolator(new LinearInterpolator()).withEndAction(new PlaybackProgressView$$Lambda$1(this));
        }
    }

    public final void m24305b(boolean z) {
        View view = this.f22137B ? this.f22152h : this.f22151g;
        if ((this.f22148d && view.getAnimation() != null && view.getAnimation().hasEnded()) || (this.f22148d && view.getAnimation() == null)) {
            this.f22160p.setVisibility(8);
            this.f22148d = false;
            view.animate().alpha(0.0f).setInterpolator(new LinearInterpolator()).setDuration(z ? (long) getResources().getInteger(17694721) : 0).withEndAction(new PlaybackProgressView$$Lambda$2(this, view));
        }
    }

    public void setSizeToggleImage(int i) {
        if (this.f22159o != null) {
            if (i != 0) {
                this.f22159o.setImageResource(i);
                this.f22159o.setVisibility(0);
                return;
            }
            this.f22159o.setVisibility(8);
        }
    }

    public void setHasSizeToggle(boolean z) {
        if (this.f22159o != null) {
            this.f22159o.setVisibility(z ? false : true);
        }
    }

    public void setMuteAlwaysVisible(boolean z) {
        this.f22137B = z;
        ImageButton imageButton = this.f22146b;
        z = (z || this.f22148d) ? false : true;
        imageButton.setVisibility(z);
    }

    public void setMuteAlwaysInvisible(boolean z) {
        this.f22138C = z;
        this.f22146b.setVisibility(this.f22138C ? 4 : 0);
    }

    public void setIsMutable(boolean z) {
        this.f22139D = z;
        this.f22146b.setVisibility(z ? false : true);
    }

    public void setVideoEventBus(VideoEventBus videoEventBus) {
        this.f22140E = videoEventBus;
        this.f22149e = videoEventBus.getSenderId();
        m24289d();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f22169z = true;
        m24289d();
        this.f22142G = FrontpageApplication.m28872h().mo4568a().getBus().filter(PlaybackProgressView$$Lambda$5.f29550a).filter(new PlaybackProgressView$$Lambda$6(this)).map(new PlaybackProgressView$$Lambda$7(this)).observeOn(SchedulerProvider.m23887c()).subscribe(new PlaybackProgressView$$Lambda$8(this));
        this.f22143H = FrontpageApplication.m28873i().mo5025a().f21699a.observeOn(SchedulerProvider.m23887c()).subscribe(new PlaybackProgressView$$Lambda$9(this));
        m24304b();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f22169z = false;
        removeCallbacks(this.f22144J);
        m24292f();
        if (this.f22141F != null) {
            this.f22141F.mo5626a();
            this.f22141F = null;
        }
        if (this.f22142G != null) {
            this.f22142G.mo5626a();
            this.f22142G = null;
        }
        if (this.f22143H != null) {
            this.f22143H.mo5626a();
            this.f22143H = null;
        }
    }

    private void m24289d() {
        if (this.f22169z && this.f22140E != null) {
            this.f22141F = this.f22140E.asObservable().filter(new PlaybackProgressView$$Lambda$3(this)).observeOn(SchedulerProvider.m23887c()).subscribe(new PlaybackProgressView$$Lambda$4(this));
        }
    }

    static final /* synthetic */ boolean m24282a(Integer num) throws Exception {
        return num.intValue() == 24 ? true : null;
    }

    final void m24304b() {
        if (this.f22148d && this.f22169z) {
            m24291e();
            m24306c();
        }
    }

    private void m24291e() {
        Timeline i = this.f22147c != null ? this.f22147c.i() : null;
        boolean z = false;
        boolean z2 = (i == null || i.a()) ? false : true;
        if (z2) {
            i.a(this.f22147c.d(), this.f22158n, 0);
            z = this.f22158n.d;
        }
        this.f22155k.setEnabled(z);
    }

    private void m24275a(long j) {
        if (this.f22154j != null && !this.f22136A) {
            this.f22154j.setText(m24284b(j));
        }
    }

    private String m24284b(long j) {
        if (j == -9223372036854775807L) {
            j = 0;
        }
        j = (j + 500) / 1000;
        long j2 = j % 60;
        long j3 = (j / 60) % 60;
        j /= 3600;
        this.f22156l.setLength(0);
        if (j > 0) {
            return this.f22157m.format("%d:%02d:%02d", new Object[]{Long.valueOf(j), Long.valueOf(j3), Long.valueOf(j2)}).toString();
        }
        return this.f22157m.format("%02d:%02d", new Object[]{Long.valueOf(j3), Long.valueOf(j2)}).toString();
    }

    private int m24286c(long j) {
        long e = this.f22147c == null ? -9223372036854775807L : this.f22147c.e();
        if (e != -9223372036854775807L) {
            if (e != 0) {
                return (int) ((j * 1000) / e);
            }
        }
        return 0;
    }

    private void m24292f() {
        if (this.f22163s != null) {
            this.f22163s.m24364b(this.f22145K);
            this.f22163s.f22221c.a(null);
            this.f22163s.m24365b(this.f22164t);
            this.f22163s = null;
        }
        this.f22160p.setVisibility(8);
    }

    private void m24279a(VideoEventWrapper videoEventWrapper) {
        if (this.f22140E != null) {
            this.f22140E.post(videoEventWrapper);
        }
    }

    public void setLink(Link link) {
        if (link != null) {
            this.f22161q.setVisibility(0);
            this.f22162r.m24175a(link);
        }
    }

    public void setOnShareListener(OnShareListener onShareListener) {
        this.f22162r.setOnShareListener(onShareListener);
    }

    public void setOnVoteChangeListener(OnVoteChangeListener onVoteChangeListener) {
        this.f22162r.setOnVoteChangeListener(onVoteChangeListener);
    }

    public void setLiveCommentClickListener(OnClickListener onClickListener) {
        this.f22162r.setCommentClickListener(onClickListener);
    }

    final void m24306c() {
        long j = 0;
        long e = this.f22147c == null ? 0 : this.f22147c.e();
        if (this.f22153i != null) {
            this.f22153i.setText(m24284b(e));
        }
        e = this.f22147c == null ? 0 : this.f22147c.f();
        m24275a(e);
        if (!this.f22136A) {
            this.f22155k.setProgress(m24286c(e));
        }
        if (this.f22147c != null) {
            j = this.f22147c.g();
        }
        this.f22155k.setSecondaryProgress(m24286c(j));
        removeCallbacks(this.f22144J);
        int a = this.f22147c == null ? 1 : this.f22147c.a();
        if (a != 1 && a != 4) {
            long j2 = 1000;
            if (this.f22147c.b() && a == 3) {
                long j3 = 1000 - (e % 1000);
                j2 = j3 < 200 ? 1000 + j3 : j3;
            }
            postDelayed(this.f22144J, j2);
        }
    }

    static /* synthetic */ long m24273a(PlaybackProgressView playbackProgressView, int i) {
        long e = playbackProgressView.f22147c == null ? -9223372036854775807L : playbackProgressView.f22147c.e();
        if (e == -9223372036854775807L) {
            return null;
        }
        return (e * ((long) i)) / 1000;
    }

    static /* synthetic */ void m24277a(PlaybackProgressView playbackProgressView, ExoPlayer exoPlayer, long j) {
        if (playbackProgressView.f22167x.mo5076a(exoPlayer, exoPlayer.d(), j) == null) {
            playbackProgressView.m24306c();
        }
    }

    static /* synthetic */ void m24298k(PlaybackProgressView playbackProgressView) {
        playbackProgressView.m24279a(new VideoEventWrapper(3, playbackProgressView.f22149e));
        if (playbackProgressView.f22147c != null) {
            VideoPlayer a = VideoPlayer.m24337a(playbackProgressView.f22147c);
            if (a != null) {
                a.m24363b();
                boolean z = a.f22223e;
                if (z) {
                    FrontpageApplication.m28873i().mo5025a().m23653b();
                } else {
                    FrontpageApplication.m28873i().mo5025a().m23652a();
                }
                playbackProgressView.f22146b.setImageResource(z ? C1761R.drawable.icon_audio_on : C1761R.drawable.icon_audio_off);
                a.m24367c(z ? VideoPlayerEvent.VIDEO_PLAYER_CLICK_MUTE : VideoPlayerEvent.VIDEO_PLAYER_CLICK_UNMUTE);
            }
        }
    }

    static /* synthetic */ void m24300m(PlaybackProgressView playbackProgressView) {
        playbackProgressView.m24279a(new VideoEventWrapper(1, playbackProgressView.f22149e));
        if (playbackProgressView.f22168y != null) {
            playbackProgressView.f22168y.mo4970a();
            playbackProgressView.m24305b(false);
        }
    }
}

package com.reddit.frontpage.widgets.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayer.EventListener;
import com.google.android.exoplayer2.R;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.SimpleExoPlayer.VideoListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.widgets.LinkFooterView.OnShareListener;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import timber.log.Timber;

public final class SimpleExoPlayerView extends FrameLayout {
    private VideoEventBus f22175A;
    private VideoPlayer f22176B;
    private final SurfaceTextureListener f22177C;
    private final Runnable f22178D;
    private final Runnable f22179E;
    public final PlaybackControlView f22180a;
    public final PlaybackProgressView f22181b;
    private final AspectRatioFrameLayout f22182c;
    private final View f22183d;
    private final ImageView f22184e;
    private final ImageView f22185f;
    private final View f22186g;
    private final ComponentListener f22187h;
    private final ProgressBar f22188i;
    private final View f22189j;
    private SimpleExoPlayer f22190k;
    private boolean f22191l;
    private boolean f22192m;
    private boolean f22193n;
    private final boolean f22194o;
    private boolean f22195p;
    private final int f22196q;
    private final int f22197r;
    private final int f22198s;
    private DragEventListener f22199t;
    private LongClickListener f22200u;
    private boolean f22201v;
    private float f22202w;
    private boolean f22203x;
    private final Handler f22204y;
    private String f22205z;

    class C19341 implements SurfaceTextureListener {
        final /* synthetic */ SimpleExoPlayerView f22172a;

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        C19341(SimpleExoPlayerView simpleExoPlayerView) {
            this.f22172a = simpleExoPlayerView;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            i = VideoPlayer.m24337a(this.f22172a.f22190k);
            if (i != 0 && i.f22221c != 0 && i.f22222d != surfaceTexture) {
                Timber.b("Setting surface texture for owner [%s], texture [%s]", new Object[]{i.f22219a, surfaceTexture.toString()});
                i.f22222d = surfaceTexture;
                i.f22221c.a(new Surface(surfaceTexture));
            }
        }
    }

    class C19352 implements Runnable {
        final /* synthetic */ SimpleExoPlayerView f22173a;

        C19352(SimpleExoPlayerView simpleExoPlayerView) {
            this.f22173a = simpleExoPlayerView;
        }

        public void run() {
            if (this.f22173a.f22200u != null) {
                long currentTimeMillis = System.currentTimeMillis();
                MotionEvent obtain = MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
                this.f22173a.dispatchTouchEvent(obtain);
                obtain.recycle();
            }
        }
    }

    class C19363 implements Runnable {
        final /* synthetic */ SimpleExoPlayerView f22174a;

        C19363(SimpleExoPlayerView simpleExoPlayerView) {
            this.f22174a = simpleExoPlayerView;
        }

        public void run() {
            if (this.f22174a.f22188i != null) {
                this.f22174a.f22188i.setVisibility(0);
            }
        }
    }

    public interface DragEventListener {
        void mo4972a();
    }

    public interface ExoPlayerViewCommentsListener {
        void mo4971a();
    }

    public interface LongClickListener {
    }

    public interface SizeToggleListener {
        void mo4970a();
    }

    private final class ComponentListener implements EventListener, VideoListener {
        final /* synthetic */ SimpleExoPlayerView f34572a;

        public final void m35388a() {
        }

        public final void m35390a(ExoPlaybackException exoPlaybackException) {
        }

        public final void m35391a(Timeline timeline) {
        }

        public final void m35393a(boolean z) {
        }

        private ComponentListener(SimpleExoPlayerView simpleExoPlayerView) {
            this.f34572a = simpleExoPlayerView;
        }

        public final void m35389a(int i, int i2, float f) {
            if (this.f34572a.f22182c != null) {
                this.f34572a.f22182c.setAspectRatio(i2 == 0 ? 1065353216 : (((float) i) * f) / ((float) i2));
            }
        }

        public final void m35395b() {
            if (this.f34572a.f22183d != null) {
                if (this.f34572a.f22190k == null || (!this.f34572a.f22190k.b() && this.f34572a.f22190k.f() <= 0)) {
                    this.f34572a.f22183d.setVisibility(0);
                } else {
                    this.f34572a.f22183d.setVisibility(4);
                }
            }
        }

        public final void m35392a(TrackSelectionArray trackSelectionArray) {
            this.f34572a.m24318c();
        }

        public final void m35394a(boolean z, int i) {
            this.f34572a.f22204y.removeCallbacks(this.f34572a.f22179E);
            if (this.f34572a.f22188i != null && !this.f34572a.f22195p && z && i == 2) {
                this.f34572a.f22204y.postDelayed(this.f34572a.f22179E, 250);
            } else if (this.f34572a.f22188i != null) {
                this.f34572a.f22188i.setVisibility(8);
            }
            if (i == 4) {
                this.f34572a.f22192m = true;
            }
            this.f34572a.m24313a(z, i);
            this.f34572a.m24316b(false);
            if (this.f34572a.f22176B) {
                this.f34572a.m24329a(this.f34572a.f22176B);
            }
        }
    }

    public SimpleExoPlayerView(Context context) {
        this(context, null);
    }

    public SimpleExoPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleExoPlayerView(Context context, AttributeSet attributeSet, int i) {
        boolean theme;
        boolean z;
        boolean z2;
        int i2;
        int resourceId;
        boolean z3;
        super(context, attributeSet, i);
        this.f22204y = new Handler();
        this.f22177C = new C19341(this);
        this.f22178D = new C19352(this);
        this.f22179E = new C19363(this);
        int i3 = 5000;
        int i4 = C1761R.layout.exo_simple_player_view;
        int i5 = 1;
        if (attributeSet != null) {
            theme = context.getTheme();
            z = R.styleable.SimpleExoPlayerView;
            attributeSet = theme.obtainStyledAttributes(attributeSet, z, 0, 0);
            try {
                i4 = attributeSet.getResourceId(8, C1761R.layout.exo_simple_player_view);
                theme = attributeSet.getBoolean(16, true);
                z = attributeSet.getBoolean(11, true);
                z2 = attributeSet.getBoolean(6, false);
                i5 = attributeSet.getInt(14, 1);
                i2 = attributeSet.getInt(9, 0);
                i3 = attributeSet.getInt(12, 5000);
                resourceId = attributeSet.getResourceId(13, 0);
                z3 = attributeSet.getBoolean(4, false);
                this.f22201v = attributeSet.getBoolean(7, false);
            } finally {
                attributeSet.recycle();
            }
        } else {
            theme = true;
            z = theme;
            z2 = false;
            i2 = z2;
            resourceId = i2;
            z3 = resourceId;
        }
        LayoutInflater.from(context).inflate(i4, this);
        this.f22187h = new ComponentListener();
        setDescendantFocusability(262144);
        this.f22182c = (AspectRatioFrameLayout) findViewById(C1761R.id.exo_content_frame);
        if (this.f22182c != null) {
            this.f22182c.setResizeMode(i2);
        }
        this.f22183d = findViewById(C1761R.id.exo_shutter);
        if (this.f22183d != null) {
            this.f22184e = (ImageView) this.f22183d.findViewById(C1761R.id.exo_shutter_image);
            this.f22185f = (ImageView) this.f22183d.findViewById(C1761R.id.exo_shutter_control);
        } else {
            this.f22184e = null;
            this.f22185f = null;
        }
        this.f22188i = (ProgressBar) findViewById(C1761R.id.exo_buffering_indicator);
        if (this.f22188i != null) {
            attributeSet = ResourcesUtil.m22740i(getContext(), C1761R.attr.rdt_player_control_color);
            Drawable mutate = this.f22188i.getIndeterminateDrawable().mutate();
            mutate.setColorFilter(attributeSet, Mode.SRC_IN);
            this.f22188i.setProgressDrawable(mutate);
        }
        if (this.f22182c == null || i5 == 0) {
            this.f22186g = null;
        } else {
            attributeSet = new LayoutParams(-1, -1);
            if (i5 != 2) {
                this.f22186g = new SurfaceView(context);
            } else {
                this.f22186g = new TextureView(context);
            }
            this.f22186g.setLayoutParams(attributeSet);
            this.f22182c.addView(this.f22186g, 0);
        }
        this.f22189j = findViewById(C1761R.id.play_button);
        if (theme) {
            this.f22180a = (PlaybackControlView) findViewById(C1761R.id.exo_playback_control);
            this.f22180a.setVisibility(8);
            if (z2) {
                this.f22181b = null;
            } else {
                this.f22181b = (PlaybackProgressView) findViewById(C1761R.id.exo_progress_view);
                this.f22181b.setSizeToggleImage(resourceId);
                this.f22181b.setHasSizeToggle(z3);
                this.f22181b.setMuteAlwaysVisible(this.f22201v);
                this.f22175A = new VideoEventBus();
                this.f22181b.setVideoEventBus(this.f22175A);
                this.f22180a.setVideoEventBus(this.f22175A);
            }
        } else {
            this.f22180a = null;
            this.f22181b = null;
        }
        this.f22196q = i3;
        this.f22191l = theme;
        this.f22192m = z;
        this.f22194o = z2;
        m24315b();
        this.f22197r = getResources().getDimensionPixelSize(C1761R.dimen.exoplayer_vertical_drag_threshold);
        this.f22198s = getResources().getDimensionPixelSize(C1761R.dimen.exoplayer_vertical_detection_threshold);
    }

    public final void m24328a() {
        if (this.f22190k != null) {
            this.f22190k.b.clear();
            this.f22190k.a(null);
            this.f22190k.b(this.f22187h);
            this.f22190k = null;
            this.f22176B = null;
        }
        if (this.f22191l) {
            this.f22180a.m24270b(true);
            this.f22180a.m24266a(null, null);
            if (!this.f22194o) {
                this.f22181b.m24302a(null, null);
            }
        }
        this.f22204y.removeCallbacksAndMessages(null);
    }

    public final void setPlayer(SimpleExoPlayer simpleExoPlayer) {
        if (this.f22190k == simpleExoPlayer) {
            if (simpleExoPlayer == null) {
                if (this.f22185f != null) {
                    this.f22185f.setVisibility(0);
                }
                if (this.f22183d != null) {
                    this.f22183d.setVisibility(0);
                }
                if (this.f22191l != null) {
                    this.f22180a.m24270b(true);
                    this.f22181b.m24305b(false);
                }
            }
            return;
        }
        if (this.f22190k != null) {
            this.f22190k.b.clear();
            this.f22190k.a(null);
            this.f22190k.b(this.f22187h);
            this.f22190k.a(null);
            this.f22176B = null;
        } else if (this.f22185f != null) {
            this.f22185f.setVisibility(8);
        }
        if (this.f22183d != null && (this.f22190k == null || this.f22190k.f() == 0)) {
            this.f22183d.setVisibility(0);
        }
        this.f22190k = simpleExoPlayer;
        if (simpleExoPlayer != null) {
            if (this.f22189j != null) {
                this.f22189j.setVisibility(8);
            }
            VideoPlayer a = VideoPlayer.m24337a((ExoPlayer) simpleExoPlayer);
            if (a == null) {
                throw new IllegalStateException("Player instance not owned by VideoPlayer");
            }
            if (this.f22191l) {
                this.f22180a.m24266a(simpleExoPlayer, a.f22220b);
                if (!this.f22194o) {
                    this.f22181b.m24302a((ExoPlayer) simpleExoPlayer, a.m24357a());
                    if (!this.f22192m) {
                        this.f22181b.m24305b(false);
                    }
                }
            } else {
                if (this.f22180a != null) {
                    this.f22180a.m24270b(true);
                    this.f22180a.m24266a(null, null);
                }
                if (this.f22181b != null) {
                    this.f22181b.m24302a(null, null);
                }
            }
            if (this.f22186g instanceof TextureView) {
                simpleExoPlayer.a((TextureView) this.f22186g);
            } else if (this.f22186g instanceof SurfaceView) {
                simpleExoPlayer.a((SurfaceView) this.f22186g);
            }
            simpleExoPlayer.a(this.f22187h);
            simpleExoPlayer.a(this.f22187h);
            if (m24316b(false) && !this.f22194o) {
                this.f22181b.m24303a(false);
            }
            m24313a(simpleExoPlayer.b(), simpleExoPlayer.a());
            m24318c();
        } else if (this.f22191l != null) {
            this.f22180a.m24266a(null, null);
            if (this.f22194o == null) {
                this.f22181b.m24302a(null, null);
            }
            m24315b();
        }
        this.f22204y.removeCallbacksAndMessages(null);
    }

    public final VideoEventBus getVideoEventBus() {
        return this.f22175A;
    }

    public final int getControlShowTimeout() {
        return this.f22196q;
    }

    public final void setSizeToggleListener(SizeToggleListener sizeToggleListener) {
        if (!this.f22194o) {
            this.f22181b.setSizeToggleListener(sizeToggleListener);
        }
    }

    public final void setCanPlay(boolean z) {
        if (this.f22191l) {
            this.f22180a.setCanPlay(z);
        }
    }

    public final void setDragListener(DragEventListener dragEventListener) {
        this.f22199t = dragEventListener;
    }

    public final void setLongClickListener(LongClickListener longClickListener) {
        this.f22200u = longClickListener;
    }

    public final void setResizeMode(int i) {
        if (this.f22182c != null) {
            this.f22182c.setResizeMode(i);
        }
    }

    public final boolean getUseController() {
        return this.f22191l;
    }

    public final void setUseController(boolean z) {
        if (this.f22180a != null) {
            this.f22191l = z;
            if (z) {
                String str;
                this.f22180a.setVisibility(0);
                z = this.f22190k ? VideoPlayer.m24337a(this.f22190k) : false;
                PlaybackControlView playbackControlView = this.f22180a;
                ExoPlayer exoPlayer = this.f22190k;
                if (z) {
                    str = z.f22220b;
                } else {
                    str = null;
                }
                playbackControlView.m24266a(exoPlayer, str);
                if (!this.f22194o) {
                    if (z) {
                        this.f22181b.m24302a(this.f22190k, z.m24357a());
                    } else {
                        this.f22181b.m24302a(this.f22190k, null);
                    }
                }
                if (z) {
                    this.f22180a.m24267a(true);
                    if (!this.f22194o) {
                        this.f22181b.m24303a(true);
                        return;
                    }
                }
                this.f22180a.m24270b(true ^ this.f22192m);
                if (!this.f22194o) {
                    this.f22181b.m24305b(false);
                }
                return;
            }
            this.f22180a.m24270b(true);
            this.f22180a.m24266a(null, null);
            if (!this.f22194o) {
                this.f22181b.m24302a(null, null);
            }
        }
    }

    public final void setAcceptTouchesAlways(boolean z) {
        this.f22193n = z;
    }

    public final void setShowShutterImage(boolean z) {
        if (z) {
            this.f22185f.setVisibility(0);
            this.f22189j.setVisibility(0);
            this.f22180a.setVisibility(0);
            return;
        }
        this.f22185f.setVisibility(8);
        this.f22189j.setVisibility(8);
        this.f22180a.setVisibility(8);
    }

    public final void setIsMutable(boolean z) {
        if (this.f22181b != null) {
            this.f22181b.setIsMutable(z);
        }
    }

    public final void setMuteAlwaysVisible(boolean z) {
        if (!this.f22194o) {
            this.f22181b.setMuteAlwaysVisible(z);
        }
    }

    public final void setMuteAlwaysInvisible(boolean z) {
        this.f22181b.setMuteAlwaysInvisible(z);
    }

    public final void setShowControllerInitially(boolean z) {
        this.f22192m = z;
    }

    private void m24315b() {
        if (this.f22180a != null) {
            this.f22180a.m24270b(true);
        }
    }

    public final View getVideoSurfaceView() {
        return this.f22186g;
    }

    public final void setShutterImageUri(String str) {
        m24330a(str, -1, -1);
    }

    public final void m24330a(String str, int i, int i2) {
        if (!(this.f22183d == null || this.f22184e == null || (this.f22205z != null && this.f22205z.equals(str)))) {
            if (this.f22184e != null) {
                GlideApp.a(this.f22184e).a(this.f22184e);
            }
            this.f22205z = str;
            str = GlideApp.a(getContext()).b(str).diskCacheStrategy(DiskCacheStrategy.a);
            if (i > 0 && i2 > 0) {
                str = str.override(i, i2);
            }
            str.into(this.f22184e);
        }
        if (this.f22182c != null && i > 0 && i2 > 0) {
            this.f22182c.setAspectRatio(((float) i) / ((float) i2));
        }
        if (this.f22190k == null) {
            this.f22183d.setVisibility(0);
        }
    }

    public final void setShutterImage(Bitmap bitmap) {
        if (this.f22183d != null && this.f22184e != null) {
            this.f22182c.setAspectRatio(((float) bitmap.getWidth()) / ((float) bitmap.getHeight()));
            this.f22184e.setImageBitmap(bitmap);
            if (this.f22190k == null) {
                this.f22183d.setVisibility(0);
            }
        }
    }

    public final void m24331a(boolean z) {
        this.f22195p = z;
        if (z && this.f22191l) {
            this.f22180a.m24270b(true);
        }
    }

    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        if (this.f22191l != null) {
            if (this.f22190k != null) {
                m24316b(true);
                return true;
            }
        }
        return null;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f22190k != null) {
            if (this.f22191l || this.f22193n) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        this.f22203x = false;
                        this.f22202w = motionEvent.getY();
                        if (this.f22200u != null) {
                            this.f22204y.postDelayed(this.f22178D, 400);
                            break;
                        }
                        break;
                    case 1:
                        this.f22204y.removeCallbacks(this.f22178D);
                        if (!this.f22203x) {
                            float y = this.f22202w - motionEvent.getY();
                            if (this.f22199t == null || Math.abs(y) < ((float) this.f22197r)) {
                                if (this.f22191l != null) {
                                    this.f22192m = true;
                                    if (this.f22180a.m24268a() == null) {
                                        m24316b(true);
                                        break;
                                    }
                                    this.f22180a.m24270b(true);
                                    break;
                                }
                            }
                            this.f22199t.mo4972a();
                            break;
                        }
                        break;
                    case 2:
                        if (this.f22200u != null && Math.abs(this.f22202w - motionEvent.getY()) > ((float) this.f22198s)) {
                            this.f22204y.removeCallbacks(this.f22178D);
                            this.f22204y.postDelayed(this.f22178D, 400);
                            break;
                        }
                    case 3:
                        this.f22203x = true;
                        this.f22204y.removeCallbacks(this.f22178D);
                        break;
                    default:
                        break;
                }
                if (this.f22193n == null) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final void setProgressVerticalOffset(int i) {
        if (this.f22191l && i >= 0) {
            LayoutParams layoutParams = this.f22181b.getLayoutParams();
            if (layoutParams instanceof MarginLayoutParams) {
                ((MarginLayoutParams) layoutParams).bottomMargin = i;
                this.f22181b.setLayoutParams(layoutParams);
            }
        }
    }

    public final void setProgressHorizontalOffset(int i) {
        if (this.f22191l && i >= 0) {
            LayoutParams layoutParams = this.f22181b.getLayoutParams();
            if (layoutParams instanceof MarginLayoutParams) {
                ((MarginLayoutParams) layoutParams).rightMargin = i;
                this.f22181b.setLayoutParams(layoutParams);
            }
        }
    }

    private boolean m24316b(boolean z) {
        if (this.f22191l && this.f22190k != null) {
            if (this.f22192m) {
                if (this.f22195p) {
                    this.f22180a.m24270b(true);
                    return false;
                }
                boolean z2;
                boolean z3;
                int a = this.f22190k.a();
                if (!(a == 1 || a == 4)) {
                    if (this.f22190k.b()) {
                        z2 = false;
                        z3 = this.f22180a.m24268a() && this.f22180a.getShowTimeoutMs() <= 0;
                        this.f22180a.setShowTimeoutMs(z2 ? 0 : this.f22196q);
                        if (!(z || z2)) {
                            if (z3) {
                                return false;
                            }
                        }
                        this.f22180a.m24267a(true);
                        return true;
                    }
                }
                z2 = true;
                if (!this.f22180a.m24268a()) {
                }
                if (z2) {
                }
                this.f22180a.setShowTimeoutMs(z2 ? 0 : this.f22196q);
                if (z3) {
                    return false;
                }
                this.f22180a.m24267a(true);
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m24313a(boolean r3, int r4) {
        /*
        r2 = this;
        r0 = r2.f22183d;
        if (r0 == 0) goto L_0x0031;
    L_0x0004:
        r0 = 0;
        switch(r4) {
            case 1: goto L_0x002a;
            case 2: goto L_0x0017;
            case 3: goto L_0x000a;
            case 4: goto L_0x002a;
            default: goto L_0x0009;
        };
    L_0x0009:
        goto L_0x0031;
    L_0x000a:
        if (r3 != 0) goto L_0x0023;
    L_0x000c:
        r3 = r2.f22190k;
        r3 = r3.f();
        r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r3 <= 0) goto L_0x0031;
    L_0x0016:
        goto L_0x0023;
    L_0x0017:
        if (r3 == 0) goto L_0x0031;
    L_0x0019:
        r3 = r2.f22190k;
        r3 = r3.f();
        r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r3 <= 0) goto L_0x0031;
    L_0x0023:
        r3 = r2.f22183d;
        r4 = 4;
        r3.setVisibility(r4);
        goto L_0x0031;
    L_0x002a:
        r3 = r2.f22183d;
        r4 = 0;
        r3.setVisibility(r4);
        return;
    L_0x0031:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.widgets.video.SimpleExoPlayerView.a(boolean, int):void");
    }

    private void m24318c() {
        if (this.f22190k != null) {
            TrackSelectionArray h = this.f22190k.h();
            int i = 0;
            while (i < h.a) {
                if (this.f22190k.b(i) != 2 || h.b[i] == null) {
                    i++;
                } else {
                    return;
                }
            }
            if (this.f22183d != null) {
                this.f22183d.setVisibility(0);
            }
        }
    }

    public final void setLink(Link link) {
        if (this.f22181b != null) {
            this.f22181b.setLink(link);
        }
    }

    public final void setOnShareListener(OnShareListener onShareListener) {
        if (this.f22181b != null) {
            this.f22181b.setOnShareListener(onShareListener);
        }
    }

    public final void setOnVoteChangeListener(OnVoteChangeListener onVoteChangeListener) {
        if (this.f22181b != null) {
            this.f22181b.setOnVoteChangeListener(onVoteChangeListener);
        }
    }

    public final void setViewCommentsListener(ExoPlayerViewCommentsListener exoPlayerViewCommentsListener) {
        if (this.f22181b != null) {
            this.f22181b.setLiveCommentClickListener(new SimpleExoPlayerView$$Lambda$1(exoPlayerViewCommentsListener));
        }
    }

    static final /* synthetic */ void m24311a(ExoPlayerViewCommentsListener exoPlayerViewCommentsListener) {
        if (exoPlayerViewCommentsListener != null) {
            exoPlayerViewCommentsListener.mo4971a();
        }
    }

    public final void m24329a(VideoPlayer videoPlayer) {
        if (!(videoPlayer == null || videoPlayer.f22221c == null)) {
            if (videoPlayer.f22221c.c != null) {
                setMuteAlwaysInvisible(false);
                if (videoPlayer == null && videoPlayer.f22221c != null && videoPlayer.f22221c.c == null) {
                    this.f22176B = videoPlayer;
                    return;
                } else {
                    this.f22176B = null;
                }
            }
        }
        setMuteAlwaysInvisible(true);
        if (videoPlayer == null) {
        }
        this.f22176B = null;
    }
}

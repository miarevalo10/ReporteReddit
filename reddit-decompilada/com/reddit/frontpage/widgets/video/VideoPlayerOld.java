package com.reddit.frontpage.widgets.video;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer.EventListener;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.ui.listener.VideoPlayingListener;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.VideoUtil;
import com.reddit.frontpage.widgets.video.VideoPlayer.VideoListener;
import com.reddit.frontpage.widgets.video.VideoPlayer.VideoListenerAdapter;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import timber.log.Timber;

public abstract class VideoPlayerOld extends FrameLayout {
    private static final AtomicInteger f22242c = new AtomicInteger(0);
    private static final Map<VideoPlayerOld, Void> f22243d = new WeakHashMap();
    private static VideoPlayerScreenReceiver f22244e;
    protected SimpleExoPlayer f22245a;
    protected String f22246b;
    private long f22247f;
    private boolean f22248g;
    private VideoPlayer f22249h;
    private String f22250i;
    private String f22251j;
    private View f22252k;
    private VideoPlayingListener f22253l;
    private final EventListener f22254m;
    private final VideoListener f22255n;
    @BindView
    View playIcon;
    @BindView
    ImageView previewImage;
    @BindView
    View shutter;
    @BindView
    View spinner;
    @BindView
    AspectRatioFrameLayout videoFrame;

    public static class VideoPlayerScreenReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            Timber.b("Releasing all video players due to screen off", new Object[null]);
            VideoPlayerOld.m24380d();
        }
    }

    class C27061 implements EventListener {
        final /* synthetic */ VideoPlayerOld f34574a;

        public final void m35402a() {
        }

        public final void m35403a(ExoPlaybackException exoPlaybackException) {
        }

        public final void m35404a(Timeline timeline) {
        }

        public final void m35405a(TrackSelectionArray trackSelectionArray) {
        }

        public final void m35406a(boolean z) {
        }

        C27061(VideoPlayerOld videoPlayerOld) {
            this.f34574a = videoPlayerOld;
        }

        public final void m35407a(boolean z, int i) {
            if (i != 1) {
                if (i == 3) {
                    if (z) {
                        this.f34574a.mo5073b();
                    }
                }
                return;
            }
            this.f34574a.m24398p();
        }
    }

    class C27072 extends VideoListenerAdapter {
        final /* synthetic */ VideoPlayerOld f34575a;

        C27072(VideoPlayerOld videoPlayerOld) {
            this.f34575a = videoPlayerOld;
        }

        public final void mo5000a(int i, int i2) {
            if (this.f34575a.f22249h != null) {
                if (this.f34575a.f22249h.f22221c == this.f34575a.f22245a) {
                    AspectRatioFrameLayout aspectRatioFrameLayout = this.f34575a.videoFrame;
                    float f = 1.0f;
                    if (i2 != 0) {
                        f = (((float) i) * 1065353216) / ((float) i2);
                    }
                    aspectRatioFrameLayout.setAspectRatio(f);
                    this.f34575a.m24397o();
                }
            }
        }

        public final void mo4999a() {
            this.f34575a.mo5072a();
            if (this.f34575a.f22253l != null) {
                VideoPlayingListener b = this.f34575a.f22253l;
                String str = this.f34575a.f22246b;
                b.mo4973a();
            }
        }
    }

    protected abstract void mo5074c();

    public abstract int getLayoutId();

    public VideoPlayer getVideoPlayer() {
        return this.f22249h;
    }

    public void setPlayListener(VideoPlayingListener videoPlayingListener) {
        this.f22253l = videoPlayingListener;
    }

    public static void m24377a(View view) {
        Util.m24006c();
        Context context = view.getContext();
        Iterator it = f22243d.keySet().iterator();
        while (it.hasNext()) {
            VideoPlayerOld videoPlayerOld = (VideoPlayerOld) it.next();
            if (videoPlayerOld.getContext() == context) {
                ViewParent viewParent = videoPlayerOld;
                Object parent;
                do {
                    parent = viewParent.getParent();
                    if (parent == null) {
                        break;
                    }
                } while (view != parent);
                videoPlayerOld.m24378a(false);
                it.remove();
            }
        }
    }

    public static void m24380d() {
        Util.m24006c();
        Iterator it = f22243d.keySet().iterator();
        while (it.hasNext()) {
            VideoPlayerOld videoPlayerOld = (VideoPlayerOld) it.next();
            videoPlayerOld.m24378a(false);
            videoPlayerOld.setKeepScreenOn(false);
            it.remove();
        }
        if (f22244e != null) {
            FrontpageApplication.f27402a.unregisterReceiver(f22244e);
            f22244e = null;
        }
    }

    public VideoPlayerOld(Context context) {
        this(context, null);
    }

    public VideoPlayerOld(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayerOld(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22247f = -1;
        this.f22254m = new C27061(this);
        this.f22255n = new C27072(this);
        m24376a(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public VideoPlayerOld(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f22247f = -1;
        this.f22254m = new C27061(this);
        this.f22255n = new C27072(this);
        m24376a(context, attributeSet, i, i2);
    }

    private void m24376a(Context context, AttributeSet attributeSet, int i, int i2) {
        inflate(getContext(), getLayoutId(), this);
        context = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.VideoPlayerOld, i, i2);
        try {
            this.f22248g = context.getBoolean(0, false);
        } finally {
            context.recycle();
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.a(this);
        if (this.f22248g) {
            this.f22252k = this.spinner;
            this.shutter.setVisibility(0);
        } else {
            this.f22252k = this.playIcon;
        }
        this.f22252k.setVisibility(0);
    }

    public final void m24382a(String str) {
        m24383a(str, true, false);
    }

    public final void m24383a(String str, boolean z, boolean z2) {
        m24384a(str, z, z2, null);
    }

    public final void m24384a(String str, boolean z, boolean z2, Link link) {
        Util.m24006c();
        if (TextUtils.isEmpty(str)) {
            Timber.b("Autoplay disabled since there's no URL", new Object[0]);
        } else if (!TextUtils.equals(this.f22246b, str) || this.f22245a == null) {
            this.f22246b = str;
            if (this.f22245a != null) {
                m24378a(true);
            } else {
                m24395m();
            }
            if (z2 || VideoUtil.m24054a()) {
                if (!this.f22248g) {
                    this.playIcon.setVisibility(8);
                }
                Timber.b("%s loaded", new Object[]{str});
                if (link != null) {
                    this.f22250i = VideoUtil.m24053a(link);
                } else {
                    z2 = new StringBuilder("video_player_");
                    z2.append(str);
                    this.f22250i = z2.toString();
                }
                this.f22249h = VideoPlayer.m24338a(this.f22250i);
                if (this.f22249h) {
                    this.f22251j = "video_player_-1";
                } else {
                    z2 = new StringBuilder("video_player_");
                    z2.append(f22242c.incrementAndGet());
                    this.f22251j = z2.toString();
                    this.f22249h = VideoPlayer.m24336a(getContext(), this.f22250i, this.f22251j);
                }
                this.f22249h.m24360a(this.f22255n);
                this.f22245a = this.f22249h.f22221c;
                this.f22245a.a(this.f22254m);
                m24387e();
                Timber.b("CREATING: %s, %s context: %s", new Object[]{str, this.f22245a, getContext()});
                Util.m24006c();
                f22243d.put(this, false);
                if (f22244e == null) {
                    f22244e = new VideoPlayerScreenReceiver();
                    FrontpageApplication.f27402a.registerReceiver(f22244e, new IntentFilter("android.intent.action.SCREEN_OFF"));
                }
                mo5074c();
                if (z) {
                    this.f22249h.m24366c();
                    setKeepScreenOn(true);
                    return;
                }
                this.f22249h.m24368d();
                return;
            }
            Timber.b("%s won't be loaded", new Object[]{str});
        }
    }

    protected final void m24387e() {
        if (this.f22249h == null) {
            Timber.d("exoPlayer was null in preparePlayer()", new Object[0]);
        } else {
            this.f22249h.m24361a(this.f22246b, null, true);
        }
    }

    public final boolean m24388f() {
        return this.f22245a != null;
    }

    public final void m24389g() {
        if (this.f22249h != null) {
            this.f22249h.m24366c();
            setKeepScreenOn(true);
        }
        Timber.b("PLAYING %s", new Object[]{this.f22246b});
    }

    public final void m24390h() {
        if (this.f22249h != null) {
            this.f22249h.m24368d();
            setKeepScreenOn(false);
        }
    }

    public final boolean m24391i() {
        return this.f22249h != null && this.f22249h.m24371g();
    }

    public final void m24392j() {
        m24378a(true);
    }

    private void m24378a(boolean z) {
        Util.m24006c();
        setKeepScreenOn(false);
        if (this.f22245a != null) {
            this.f22245a.b(this.f22254m);
            this.f22245a = null;
        }
        if (this.f22249h != null) {
            this.f22249h.m24364b(this.f22255n);
            this.f22249h.m24365b(this.f22251j);
            this.f22249h = null;
        }
        this.f22253l = null;
        if (z) {
            f22243d.remove(this);
        }
    }

    public final ImageView getPreviewImage() {
        return this.previewImage;
    }

    public final void m24393k() {
        if (this.f22249h != null) {
            Timber.b("RESUMING %s", new Object[]{this.f22246b});
            this.f22249h.m24358a(this.f22247f);
            this.f22249h.m24366c();
            this.f22247f = -1;
            setKeepScreenOn(true);
        }
    }

    public final void m24394l() {
        if (this.f22249h != null) {
            Timber.b("PAUSING %s", new Object[]{this.f22246b});
            this.f22247f = this.f22245a.f();
            this.f22249h.m24368d();
            setKeepScreenOn(false);
        }
    }

    public final void m24395m() {
        m24398p();
        if (this.f22249h != null) {
            this.f22249h.m24358a(0);
        }
        this.f22247f = -1;
    }

    protected final void m24396n() {
        if (this.previewImage.getVisibility() != 8) {
            m24397o();
            this.previewImage.setVisibility(8);
            this.f22252k.setVisibility(8);
            Timber.b("VideoPlayer hiding preview for %s", new Object[]{this.f22246b});
        }
    }

    protected final void m24397o() {
        this.shutter.setVisibility(4);
    }

    protected void mo5072a() {
        if (this.f22249h != null && this.f22249h.m24371g()) {
            m24396n();
        }
    }

    protected final void m24398p() {
        this.videoFrame.setVisibility(4);
        if (this.previewImage.getVisibility() != 0) {
            if (this.f22248g) {
                this.shutter.setVisibility(0);
            } else {
                this.f22252k.setVisibility(0);
            }
            this.previewImage.setVisibility(0);
            Timber.b("VideoPlayer showing preview for %s", new Object[]{this.f22246b});
        }
    }

    protected void mo5073b() {
        Timber.b("showVideo", new Object[0]);
        this.videoFrame.setVisibility(0);
    }
}

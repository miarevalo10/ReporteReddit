package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;
import com.twitter.sdk.android.tweetui.internal.VideoControlView.MediaPlayerControl;

public class VideoView extends SurfaceView implements MediaPlayerControl {
    private GestureDetector f30803A;
    public Uri f30804a;
    public int f30805b;
    public int f30806c;
    public MediaPlayer f30807d;
    public int f30808e;
    public boolean f30809f;
    OnVideoSizeChangedListener f30810g;
    OnPreparedListener f30811h;
    Callback f30812i;
    private String f30813j;
    private SurfaceHolder f30814k;
    private int f30815l;
    private int f30816m;
    private int f30817n;
    private int f30818o;
    private int f30819p;
    private VideoControlView f30820q;
    private OnCompletionListener f30821r;
    private OnPreparedListener f30822s;
    private int f30823t;
    private OnErrorListener f30824u;
    private OnInfoListener f30825v;
    private OnCompletionListener f30826w;
    private OnInfoListener f30827x;
    private OnErrorListener f30828y;
    private OnBufferingUpdateListener f30829z;

    class C20871 implements OnVideoSizeChangedListener {
        final /* synthetic */ VideoView f24273a;

        C20871(VideoView videoView) {
            this.f24273a = videoView;
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            this.f24273a.f30816m = mediaPlayer.getVideoWidth();
            this.f24273a.f30817n = mediaPlayer.getVideoHeight();
            if (this.f24273a.f30816m != null && this.f24273a.f30817n != null) {
                this.f24273a.getHolder().setFixedSize(this.f24273a.f30816m, this.f24273a.f30817n);
                this.f24273a.requestLayout();
            }
        }
    }

    class C20882 implements OnPreparedListener {
        final /* synthetic */ VideoView f24274a;

        C20882(VideoView videoView) {
            this.f24274a = videoView;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            this.f24274a.f30805b = 2;
            if (this.f24274a.f30822s != null) {
                this.f24274a.f30822s.onPrepared(this.f24274a.f30807d);
            }
            if (this.f24274a.f30820q != null) {
                this.f24274a.f30820q.setEnabled(true);
            }
            this.f24274a.f30816m = mediaPlayer.getVideoWidth();
            this.f24274a.f30817n = mediaPlayer.getVideoHeight();
            int f = this.f24274a.f30808e;
            if (f != null) {
                this.f24274a.mo5515a(f);
            }
            if (this.f24274a.f30816m != 0 && this.f24274a.f30817n != 0) {
                this.f24274a.getHolder().setFixedSize(this.f24274a.f30816m, this.f24274a.f30817n);
                if (this.f24274a.f30818o == this.f24274a.f30816m && this.f24274a.f30819p == this.f24274a.f30817n) {
                    if (this.f24274a.f30806c == 3) {
                        this.f24274a.mo5514a();
                        if (this.f24274a.f30820q != null) {
                            this.f24274a.f30820q.m25990b();
                        }
                    } else if (!this.f24274a.mo5517c() && ((f != 0 || this.f24274a.getCurrentPosition() > null) && this.f24274a.f30820q != null)) {
                        this.f24274a.f30820q.m25990b();
                    }
                }
            } else if (this.f24274a.f30806c == 3) {
                this.f24274a.mo5514a();
            }
        }
    }

    class C20893 implements OnCompletionListener {
        final /* synthetic */ VideoView f24275a;

        C20893(VideoView videoView) {
            this.f24275a = videoView;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f24275a.f30805b = 5;
            this.f24275a.f30806c = 5;
            if (this.f24275a.f30821r != null) {
                this.f24275a.f30821r.onCompletion(this.f24275a.f30807d);
            }
        }
    }

    class C20904 implements OnInfoListener {
        final /* synthetic */ VideoView f24276a;

        C20904(VideoView videoView) {
            this.f24276a = videoView;
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.f24276a.f30825v != null) {
                this.f24276a.f30825v.onInfo(mediaPlayer, i, i2);
            }
            return true;
        }
    }

    class C20915 implements OnErrorListener {
        final /* synthetic */ VideoView f24277a;

        C20915(VideoView videoView) {
            this.f24277a = videoView;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            mediaPlayer = this.f24277a.f30813j;
            StringBuilder stringBuilder = new StringBuilder("Error: ");
            stringBuilder.append(i);
            stringBuilder.append(",");
            stringBuilder.append(i2);
            Log.d(mediaPlayer, stringBuilder.toString());
            this.f24277a.f30805b = -1;
            this.f24277a.f30806c = -1;
            if (this.f24277a.f30820q != null) {
                this.f24277a.f30820q.m25988a();
            }
            return (this.f24277a.f30824u == null || this.f24277a.f30824u.onError(this.f24277a.f30807d, i, i2) != null) ? true : true;
        }
    }

    class C20926 implements OnBufferingUpdateListener {
        final /* synthetic */ VideoView f24278a;

        C20926(VideoView videoView) {
            this.f24278a = videoView;
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            this.f24278a.f30823t = i;
        }
    }

    class C20937 extends SimpleOnGestureListener {
        final /* synthetic */ VideoView f24279a;

        C20937(VideoView videoView) {
            this.f24279a = videoView;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (!(this.f24279a.m31825h() == null || this.f24279a.f30820q == null)) {
                this.f24279a.m31823g();
            }
            return null;
        }
    }

    class C20948 implements Callback {
        final /* synthetic */ VideoView f24280a;

        C20948(VideoView videoView) {
            this.f24280a = videoView;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.f24280a.f30818o = i2;
            this.f24280a.f30819p = i3;
            i = 0;
            surfaceHolder = this.f24280a.f30806c == 3 ? 1 : null;
            if (this.f24280a.f30816m == i2 && this.f24280a.f30817n == i3) {
                i = 1;
            }
            if (this.f24280a.f30807d != 0 && surfaceHolder != null && r4 != 0) {
                if (this.f24280a.f30808e != null) {
                    this.f24280a.mo5515a(this.f24280a.f30808e);
                }
                this.f24280a.mo5514a();
                if (this.f24280a.f30820q != null) {
                    this.f24280a.f30820q.m25990b();
                }
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f24280a.f30814k = surfaceHolder;
            this.f24280a.m31839d();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f24280a.f30814k = null;
            if (this.f24280a.f30820q != null) {
                this.f24280a.f30820q.m25988a();
            }
            this.f24280a.m31808a(true);
        }
    }

    public VideoView(Context context) {
        super(context);
        this.f30813j = "VideoView";
        this.f30805b = 0;
        this.f30806c = 0;
        this.f30814k = null;
        this.f30807d = null;
        this.f30810g = new C20871(this);
        this.f30811h = new C20882(this);
        this.f30826w = new C20893(this);
        this.f30827x = new C20904(this);
        this.f30828y = new C20915(this);
        this.f30829z = new C20926(this);
        this.f30803A = new GestureDetector(getContext(), new C20937(this));
        this.f30812i = new C20948(this);
        m31817e();
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30813j = "VideoView";
        this.f30805b = 0;
        this.f30806c = 0;
        this.f30814k = null;
        this.f30807d = null;
        this.f30810g = new C20871(this);
        this.f30811h = new C20882(this);
        this.f30826w = new C20893(this);
        this.f30827x = new C20904(this);
        this.f30828y = new C20915(this);
        this.f30829z = new C20926(this);
        this.f30803A = new GestureDetector(getContext(), new C20937(this));
        this.f30812i = new C20948(this);
        m31817e();
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.f30816m, i);
        int defaultSize2 = getDefaultSize(this.f30817n, i2);
        if (this.f30816m <= 0 || this.f30817n <= 0) {
            i = defaultSize;
        } else {
            defaultSize = MeasureSpec.getMode(i);
            i = MeasureSpec.getSize(i);
            defaultSize2 = MeasureSpec.getMode(i2);
            i2 = MeasureSpec.getSize(i2);
            if (defaultSize == 1073741824 && defaultSize2 == 1073741824) {
                if (this.f30816m * i2 < this.f30817n * i) {
                    i = (this.f30816m * i2) / this.f30817n;
                } else if (this.f30816m * i2 > this.f30817n * i) {
                    defaultSize2 = (this.f30817n * i) / this.f30816m;
                }
                setMeasuredDimension(i, i2);
            }
            if (defaultSize == 1073741824) {
                defaultSize = (this.f30817n * i) / this.f30816m;
                if (defaultSize2 != Integer.MIN_VALUE || defaultSize <= i2) {
                    i2 = defaultSize;
                }
            } else {
                if (defaultSize2 == 1073741824) {
                    defaultSize2 = (this.f30816m * i2) / this.f30817n;
                    if (defaultSize == Integer.MIN_VALUE && defaultSize2 > i) {
                    }
                } else {
                    int i3 = this.f30816m;
                    int i4 = this.f30817n;
                    if (defaultSize2 != Integer.MIN_VALUE || i4 <= i2) {
                        defaultSize2 = i3;
                        i2 = i4;
                    } else {
                        defaultSize2 = (this.f30816m * i2) / this.f30817n;
                    }
                    if (defaultSize == Integer.MIN_VALUE && r1 > i) {
                        defaultSize2 = (this.f30817n * i) / this.f30816m;
                    }
                }
                i = defaultSize2;
            }
            setMeasuredDimension(i, i2);
        }
        i2 = defaultSize2;
        setMeasuredDimension(i, i2);
    }

    private void m31817e() {
        this.f30816m = 0;
        this.f30817n = 0;
        getHolder().addCallback(this.f30812i);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        requestFocus();
        this.f30805b = 0;
        this.f30806c = 0;
    }

    public final void m31839d() {
        if (this.f30804a != null) {
            if (this.f30814k != null) {
                m31808a(false);
                try {
                    this.f30807d = new MediaPlayer();
                    if (this.f30815l != 0) {
                        this.f30807d.setAudioSessionId(this.f30815l);
                    } else {
                        this.f30815l = this.f30807d.getAudioSessionId();
                    }
                    this.f30807d.setOnPreparedListener(this.f30811h);
                    this.f30807d.setOnVideoSizeChangedListener(this.f30810g);
                    this.f30807d.setOnCompletionListener(this.f30826w);
                    this.f30807d.setOnErrorListener(this.f30828y);
                    this.f30807d.setOnInfoListener(this.f30827x);
                    this.f30807d.setOnBufferingUpdateListener(this.f30829z);
                    this.f30823t = 0;
                    this.f30807d.setLooping(this.f30809f);
                    this.f30807d.setDataSource(getContext(), this.f30804a);
                    this.f30807d.setDisplay(this.f30814k);
                    this.f30807d.setAudioStreamType(3);
                    this.f30807d.setScreenOnWhilePlaying(true);
                    this.f30807d.prepareAsync();
                    this.f30805b = 1;
                    m31820f();
                } catch (Throwable e) {
                    String str = this.f30813j;
                    StringBuilder stringBuilder = new StringBuilder("Unable to open content: ");
                    stringBuilder.append(this.f30804a);
                    Log.w(str, stringBuilder.toString(), e);
                    this.f30805b = -1;
                    this.f30806c = -1;
                    this.f30828y.onError(this.f30807d, 1, 0);
                }
            }
        }
    }

    public void setMediaController(VideoControlView videoControlView) {
        if (this.f30820q != null) {
            this.f30820q.m25988a();
        }
        this.f30820q = videoControlView;
        m31820f();
    }

    private void m31820f() {
        if (this.f30807d != null && this.f30820q != null) {
            this.f30820q.setMediaPlayer(this);
            this.f30820q.setEnabled(m31825h());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f30803A.onTouchEvent(motionEvent)) {
            if (super.onTouchEvent(motionEvent) == null) {
                return null;
            }
        }
        return true;
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.f30822s = onPreparedListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.f30821r = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.f30824u = onErrorListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.f30825v = onInfoListener;
    }

    private void m31808a(boolean z) {
        if (this.f30807d != null) {
            this.f30807d.reset();
            this.f30807d.release();
            this.f30807d = null;
            this.f30805b = 0;
            if (z) {
                this.f30806c = 0;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 82 || i == 5 || i == 6) ? false : true;
        if (m31825h() && z && this.f30820q != null) {
            if (i != 79) {
                if (i != 85) {
                    if (i == 126) {
                        if (this.f30807d.isPlaying() == 0) {
                            mo5514a();
                            this.f30820q.m25988a();
                        }
                        return true;
                    }
                    if (i != 86) {
                        if (i != 127) {
                            m31823g();
                        }
                    }
                    if (this.f30807d.isPlaying() != 0) {
                        mo5516b();
                        this.f30820q.m25990b();
                    }
                    return true;
                }
            }
            if (this.f30807d.isPlaying() != 0) {
                mo5516b();
                this.f30820q.m25990b();
            } else {
                mo5514a();
                this.f30820q.m25988a();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void m31823g() {
        if (this.f30820q.m25991c()) {
            this.f30820q.m25988a();
        } else {
            this.f30820q.m25990b();
        }
    }

    public final void mo5514a() {
        if (m31825h()) {
            this.f30807d.start();
            this.f30805b = 3;
        }
        this.f30806c = 3;
    }

    public final void mo5516b() {
        if (m31825h() && this.f30807d.isPlaying()) {
            this.f30807d.pause();
            this.f30805b = 4;
        }
        this.f30806c = 4;
    }

    public int getDuration() {
        return m31825h() ? this.f30807d.getDuration() : -1;
    }

    public int getCurrentPosition() {
        return m31825h() ? this.f30807d.getCurrentPosition() : 0;
    }

    public final void mo5515a(int i) {
        if (m31825h()) {
            this.f30807d.seekTo(i);
            this.f30808e = 0;
            return;
        }
        this.f30808e = i;
    }

    public final boolean mo5517c() {
        return m31825h() && this.f30807d.isPlaying();
    }

    public int getBufferPercentage() {
        return this.f30807d != null ? this.f30823t : 0;
    }

    private boolean m31825h() {
        return (this.f30807d == null || this.f30805b == -1 || this.f30805b == 0 || this.f30805b == 1) ? false : true;
    }
}

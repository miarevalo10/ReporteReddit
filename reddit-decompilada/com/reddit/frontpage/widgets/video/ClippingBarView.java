package com.reddit.frontpage.widgets.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.MathUtil;
import com.reddit.frontpage.widgets.video.VideoPlayer.VideoListenerAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.TimeUnit;

public class ClippingBarView extends View {
    private static final Subject<Integer> f22054c = PublishSubject.create();
    private static final Subject<Integer> f22055d = PublishSubject.create();
    private int f22056A;
    private int f22057B;
    private int f22058C;
    private int f22059D;
    private int f22060E;
    private int f22061F;
    private int f22062G;
    private int f22063H;
    private float f22064I;
    private float f22065J;
    private float f22066K;
    private long f22067L;
    private float f22068M;
    private float f22069N;
    private int f22070O;
    private float f22071P;
    private ValueAnimator f22072Q;
    private boolean f22073R;
    private boolean f22074S;
    private float f22075T;
    private float f22076U;
    private float f22077V;
    private float f22078W;
    float f22079a;
    private float aa;
    private float ab;
    private float ac;
    private float ad;
    private float ae;
    private float af;
    private int ag;
    private int ah;
    private int ai;
    private boolean aj;
    private int ak;
    private float al;
    private float am;
    private boolean an;
    private Disposable ao;
    private final Handler ap;
    private final ProgressTime aq;
    private final ClipBoundsInSeconds ar;
    private final Subject<Long> as;
    private final VideoListenerAdapter at;
    private final Runnable au;
    private final Runnable av;
    private final Runnable aw;
    VideoPlayer f22080b;
    private final RectF f22081e;
    private final Path f22082f;
    private int f22083g;
    private float f22084h;
    private float f22085i;
    private float f22086j;
    private float f22087k;
    private float f22088l;
    private float f22089m;
    private float f22090n;
    private float f22091o;
    private float f22092p;
    private float f22093q;
    private float f22094r;
    private float f22095s;
    private float f22096t;
    private float f22097u;
    private Paint f22098v;
    private TextPaint f22099w;
    private TextPaint f22100x;
    private String f22101y;
    private int f22102z;

    class C19302 implements Runnable {
        final /* synthetic */ ClippingBarView f22048a;

        C19302(ClippingBarView clippingBarView) {
            this.f22048a = clippingBarView;
        }

        public void run() {
            this.f22048a.an = false;
            this.f22048a.invalidate();
        }
    }

    class C19313 extends AnimatorListenerAdapter {
        final /* synthetic */ ClippingBarView f22049a;

        C19313(ClippingBarView clippingBarView) {
            this.f22049a = clippingBarView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f22049a.f22072Q = null;
            if (this.f22049a.f22073R == null) {
                this.f22049a.f22083g = 3;
            }
        }
    }

    private static final class ClipBoundsInSeconds {
        int f22050a;
        int f22051b;

        private ClipBoundsInSeconds() {
        }

        final int m24232a() {
            return this.f22051b - this.f22050a;
        }
    }

    private static final class ProgressTime {
        int f22052a;
        String f22053b;

        private ProgressTime() {
        }
    }

    class C27021 extends VideoListenerAdapter {
        final /* synthetic */ ClippingBarView f34554a;

        C27021(ClippingBarView clippingBarView) {
            this.f34554a = clippingBarView;
        }

        public final void mo5001a(boolean z, int i) {
            this.f34554a.ag = i;
            if (z) {
                this.f34554a.m24251a();
            } else {
                this.f34554a.ap.removeCallbacks(this.f34554a.au);
            }
        }
    }

    private static int m24234a(float f, long j) {
        return (int) (((((float) j) * f) + 500.0f) / 1000.0f);
    }

    public static Subject<Integer> getClippingEndReachedObservable() {
        return f22054c;
    }

    public static Subject<Integer> getClippingEventObservable() {
        return f22055d;
    }

    final /* synthetic */ void m24252b() {
        this.f22073R = true;
        this.f22080b.m24368d();
    }

    public ClippingBarView(Context context) {
        super(context);
        this.f22081e = new RectF();
        this.f22082f = new Path();
        this.f22083g = 3;
        this.f22102z = -1;
        this.f22070O = -1;
        this.ag = 1;
        this.ai = 0;
        this.ap = new Handler();
        this.aq = new ProgressTime();
        this.ar = new ClipBoundsInSeconds();
        this.as = PublishSubject.create();
        this.at = new C27021(this);
        this.au = new ClippingBarView$$Lambda$0(this);
        this.av = new C19302(this);
        this.aw = new ClippingBarView$$Lambda$1(this);
        m24241a(context, null);
    }

    public ClippingBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22081e = new RectF();
        this.f22082f = new Path();
        this.f22083g = 3;
        this.f22102z = -1;
        this.f22070O = -1;
        this.ag = 1;
        this.ai = 0;
        this.ap = new Handler();
        this.aq = new ProgressTime();
        this.ar = new ClipBoundsInSeconds();
        this.as = PublishSubject.create();
        this.at = new C27021(this);
        this.au = new ClippingBarView$$Lambda$2(this);
        this.av = new C19302(this);
        this.aw = new ClippingBarView$$Lambda$3(this);
        m24241a(context, attributeSet);
    }

    public ClippingBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22081e = new RectF();
        this.f22082f = new Path();
        this.f22083g = 3;
        this.f22102z = -1;
        this.f22070O = -1;
        this.ag = 1;
        this.ai = 0;
        this.ap = new Handler();
        this.aq = new ProgressTime();
        this.ar = new ClipBoundsInSeconds();
        this.as = PublishSubject.create();
        this.at = new C27021(this);
        this.au = new ClippingBarView$$Lambda$4(this);
        this.av = new C19302(this);
        this.aw = new ClippingBarView$$Lambda$5(this);
        m24241a(context, attributeSet);
    }

    @TargetApi(21)
    public ClippingBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f22081e = new RectF();
        this.f22082f = new Path();
        this.f22083g = 3;
        this.f22102z = -1;
        this.f22070O = -1;
        this.ag = 1;
        this.ai = 0;
        this.ap = new Handler();
        this.aq = new ProgressTime();
        this.ar = new ClipBoundsInSeconds();
        this.as = PublishSubject.create();
        this.at = new C27021(this);
        this.au = new ClippingBarView$$Lambda$6(this);
        this.av = new C19302(this);
        this.aw = new ClippingBarView$$Lambda$7(this);
        m24241a(context, attributeSet);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f22075T > 0.0f && this.f22080b != null) {
            this.al = ((this.aa * 2.0f) + this.f22077V) + this.ae;
            this.am = (this.f22095s * this.af) / 2.0f;
            this.f22098v.setColor(this.f22056A);
            this.f22081e.left = this.f22089m + (this.f22084h / 2.0f);
            this.f22081e.top = ((this.al + this.am) + this.f22085i) - (this.f22094r / 2.0f);
            this.f22081e.right = (this.f22081e.left + this.f22076U) - (this.f22084h / 2.0f);
            this.f22081e.bottom = this.f22081e.top + this.f22094r;
            canvas.drawRoundRect(this.f22081e, this.f22086j, this.f22086j, this.f22098v);
            this.f22081e.left = (this.f22089m + (this.f22064I * this.f22076U)) + this.f22084h;
            this.f22081e.right = this.f22089m + (this.f22079a * this.f22076U);
            this.f22098v.setColor(this.f22102z);
            canvas.drawRect(this.f22081e, this.f22098v);
            this.f22081e.right = m24233a(this.f22068M);
            if (this.f22081e.left < this.f22081e.right) {
                this.f22098v.setColor(this.f22059D);
                canvas.drawRect(this.f22081e, this.f22098v);
            }
            float f = 1.0f;
            if (this.f22069N > this.f22068M) {
                this.f22081e.left = Math.max(this.f22089m + (this.f22064I * this.f22076U), m24233a(this.f22068M) + 1.0f);
                this.f22081e.right = m24233a(this.f22069N);
                if (this.f22081e.left < this.f22081e.right) {
                    this.f22098v.setColor(this.f22060E);
                    canvas.drawRect(this.f22081e, this.f22098v);
                }
            }
            float height = this.f22081e.top + (this.f22081e.height() / 2.0f);
            String a = m24238a(this.ah);
            canvas.drawText(a, 0, a.length(), 2.0f * this.aa, height - this.ad, this.f22100x);
            long j = 0;
            if (this.f22067L >= 0) {
                j = this.f22067L;
            }
            a = m24238a(m24235a(j));
            canvas.drawText(a, 0, a.length(), (this.f22075T - this.f22092p) - (this.aa * 2.0f), height - this.ad, this.f22100x);
            m24242a(canvas, 0);
            m24242a(canvas, 1);
            if (!this.an) {
                if (this.f22083g != 0 && this.f22083g != 1 && this.f22083g != 2) {
                    return;
                }
                if (!this.f22073R && (this.f22072Q == null || !this.f22072Q.isRunning())) {
                    return;
                }
            }
            if (this.f22072Q != null && this.f22072Q.isRunning()) {
                f = this.f22074S ? this.f22072Q.getAnimatedFraction() : 1.0f - this.f22072Q.getAnimatedFraction();
            }
            float f2 = this.f22089m + (((this.f22064I + this.f22079a) / 2.0f) * this.f22076U);
            float f3 = ((this.aq.f22052a >= 600 ? this.f22091o : this.f22090n) / 2.0f) + (this.aa * 2.0f);
            this.f22081e.top = 0.0f;
            this.f22081e.bottom = (this.ab * 2.0f) + (this.aa * 2.0f);
            this.f22081e.left = f2 - f3;
            this.f22081e.right = f2 + f3;
            this.f22099w.setTextSize(this.f22077V);
            this.f22098v.setColor(this.f22061F);
            int i = (int) (255.0f * f);
            this.f22098v.setAlpha(i);
            canvas.drawRoundRect(this.f22081e, this.f22088l, this.f22088l, this.f22098v);
            float width = this.f22081e.left + (this.f22081e.width() / 2.0f);
            f2 = this.f22081e.bottom;
            f3 = this.ae / 2.0f;
            this.f22082f.reset();
            this.f22082f.moveTo(width - f3, f2);
            this.f22082f.lineTo(width + f3, f2);
            this.f22082f.lineTo(width, f2 + (f3 * 2.0f));
            this.f22082f.close();
            canvas.drawPath(this.f22082f, this.f22098v);
            this.f22098v.setAlpha(255);
            int i2 = (((int) (((this.f22079a - this.f22064I) * ((float) this.f22067L)) + 0.5f)) + 500) / 1000;
            int i3 = i2 / 60;
            int i4 = i2 % 60;
            this.aq.f22053b = getResources().getString(C1761R.string.clipping_bubble_time_minutes_seconds, new Object[]{this.f22101y, Integer.valueOf(i3), Integer.valueOf(i4)});
            this.aq.f22052a = i2;
            this.f22099w.setAlpha(i);
            canvas.drawText(this.aq.f22053b, 0, this.aq.f22053b.length(), this.f22081e.left + (this.f22081e.width() / 2.0f), (this.f22081e.top + (this.f22081e.height() / 2.0f)) - this.ac, this.f22099w);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (this.f22080b != null) {
                float f;
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        this.f22070O = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
                        this.f22071P = motionEvent.getX(motionEvent.findPointerIndex(this.f22070O));
                        motionEvent = this.f22071P;
                        f = this.f22089m + (this.f22064I * this.f22076U);
                        float f2 = this.f22084h + f;
                        float f3 = (this.f22089m + (this.f22079a * this.f22076U)) - this.f22084h;
                        float f4 = this.f22084h + f3;
                        boolean z = motionEvent >= f - this.f22093q && motionEvent <= this.f22093q + f2;
                        boolean z2 = motionEvent >= f3 - this.f22093q && motionEvent <= f4 + this.f22093q;
                        if (!z || !z2) {
                            if (!z) {
                                if (!z2) {
                                    motionEvent = (motionEvent < f2 || motionEvent > f3) ? 3 : 2;
                                    this.f22083g = motionEvent;
                                    if (this.f22083g == 3) {
                                        f22055d.onNext(Integer.valueOf(0));
                                        this.aj = this.f22080b.m24371g();
                                        if (this.f22083g == null || this.f22083g == 1) {
                                            this.f22074S = true;
                                            m24245c();
                                        }
                                        this.f22065J = this.f22064I;
                                        this.f22066K = this.f22079a;
                                        if (this.f22083g == 2) {
                                            this.f22073R = true;
                                            this.f22080b.m24368d();
                                            break;
                                        }
                                        this.ap.postDelayed(this.aw, 200);
                                        break;
                                    }
                                    return false;
                                }
                            }
                            motionEvent = null;
                            this.f22083g = motionEvent;
                            if (this.f22083g == 3) {
                                return false;
                            }
                            f22055d.onNext(Integer.valueOf(0));
                            this.aj = this.f22080b.m24371g();
                            this.f22074S = true;
                            m24245c();
                            this.f22065J = this.f22064I;
                            this.f22066K = this.f22079a;
                            if (this.f22083g == 2) {
                                this.f22073R = true;
                                this.f22080b.m24368d();
                            } else {
                                this.ap.postDelayed(this.aw, 200);
                            }
                        } else if (motionEvent < (this.f22076U / 2.0f) + this.f22089m) {
                            motionEvent = null;
                            this.f22083g = motionEvent;
                            if (this.f22083g == 3) {
                                return false;
                            }
                            f22055d.onNext(Integer.valueOf(0));
                            this.aj = this.f22080b.m24371g();
                            this.f22074S = true;
                            m24245c();
                            this.f22065J = this.f22064I;
                            this.f22066K = this.f22079a;
                            if (this.f22083g == 2) {
                                this.ap.postDelayed(this.aw, 200);
                            } else {
                                this.f22073R = true;
                                this.f22080b.m24368d();
                            }
                        }
                        motionEvent = 1;
                        this.f22083g = motionEvent;
                        if (this.f22083g == 3) {
                            return false;
                        }
                        f22055d.onNext(Integer.valueOf(0));
                        this.aj = this.f22080b.m24371g();
                        this.f22074S = true;
                        m24245c();
                        this.f22065J = this.f22064I;
                        this.f22066K = this.f22079a;
                        if (this.f22083g == 2) {
                            this.f22073R = true;
                            this.f22080b.m24368d();
                        } else {
                            this.ap.postDelayed(this.aw, 200);
                        }
                        break;
                    case 1:
                        if (this.f22073R == null) {
                            this.f22068M = (this.f22071P - this.f22089m) / this.f22076U;
                            this.f22069N = 0.0f;
                            this.f22080b.m24358a((long) (this.f22068M * ((float) this.f22067L)));
                            invalidate();
                        } else {
                            m24243a(this.f22080b.f22220b, m24234a(this.f22064I, this.f22067L), m24234a(this.f22079a, this.f22067L));
                            if (this.f22083g == null) {
                                this.f22080b.m24358a((long) (this.f22064I * ((float) this.f22067L)));
                            } else if (this.f22083g == 1) {
                                this.f22080b.m24358a(Math.max((long) (this.f22064I * ((float) this.f22067L)), ((long) (this.f22079a * ((float) this.f22067L))) - 3000));
                                this.aj = true;
                            }
                        }
                        f22055d.onNext(Integer.valueOf(1));
                        break;
                    case 2:
                        motionEvent = motionEvent.getX(motionEvent.findPointerIndex(this.f22070O));
                        f = (motionEvent - this.f22089m) / this.f22076U;
                        if (!this.f22073R && Math.abs(motionEvent - this.f22071P) >= ((float) this.ak)) {
                            this.f22073R = true;
                        }
                        if (this.f22073R) {
                            switch (this.f22083g) {
                                case 0:
                                    m24239a(f, this.f22079a);
                                    if (f >= 0.0f && f < this.f22079a - (this.f22084h / this.f22076U) && this.ar.m24232a() > null && (this.ai == null || this.ar.m24232a() <= this.ai)) {
                                        this.f22064I = f;
                                        m24240a(0, 0);
                                        invalidate();
                                        break;
                                    }
                                case 1:
                                    m24239a(this.f22064I, f);
                                    if (f > this.f22064I + (this.f22084h / this.f22076U) && f <= 1.0f && this.ar.m24232a() > null && (this.ai == null || this.ar.m24232a() <= this.ai)) {
                                        this.f22079a = f;
                                        m24240a(1, -3000);
                                        invalidate();
                                        break;
                                    }
                                case 2:
                                    motionEvent = (motionEvent - this.f22071P) / this.f22076U;
                                    f = this.f22065J + motionEvent;
                                    float f5 = this.f22066K + motionEvent;
                                    if (f >= 0.0f && f5 <= 1.0f) {
                                        this.f22064I = f;
                                        this.f22079a = f5;
                                        m24240a(0, 0);
                                        invalidate();
                                        break;
                                    }
                                default:
                                    break;
                            }
                        }
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }
                this.ap.removeCallbacks(this.aw);
                this.f22073R = false;
                if (this.f22083g != null) {
                    if (this.f22083g != 1) {
                        this.f22083g = 3;
                        if (this.aj != null) {
                            this.f22080b.m24366c();
                        }
                        return true;
                    }
                }
                this.f22074S = false;
                m24245c();
                if (this.aj != null) {
                    this.f22080b.m24366c();
                }
                return true;
            }
        }
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.an = false;
        this.ao = this.as.throttleLast(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.m26509a()).subscribe(new ClippingBarView$$Lambda$10(this));
    }

    public void onDetachedFromWindow() {
        this.ap.removeCallbacks(this.au);
        this.ap.removeCallbacks(this.av);
        if (this.ao != null) {
            this.ao.mo5626a();
            this.ao = null;
        }
        if (this.f22080b != null) {
            this.f22080b.m24364b(this.at);
        }
        this.f22080b = null;
        super.onDetachedFromWindow();
    }

    public void setVideoPlayer(VideoPlayer videoPlayer) {
        if (videoPlayer != this.f22080b) {
            if (this.f22080b != null) {
                this.f22080b.m24364b(this.at);
            }
            this.f22080b = videoPlayer;
            if (videoPlayer != null) {
                videoPlayer.m24360a(this.at);
                this.ag = videoPlayer.m24373i();
                this.f22064I = null;
                this.f22079a = 1.0f;
                m24251a();
                return;
            }
            this.ap.removeCallbacks(this.au);
        }
    }

    public void setSpanLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Span must be positive");
        }
        this.ai = i;
        if (i != 0 && this.f22080b != 0) {
            this.an = true;
            this.ap.removeCallbacks(this.av);
            this.ap.postDelayed(this.av, 1500);
            invalidate();
            int a = m24234a(this.f22064I, this.f22067L) + this.ai;
            int a2 = m24234a(this.f22079a, this.f22067L);
            if (a2 > a) {
                i = ObjectAnimator.ofFloat(new float[]{this.f22079a, (((float) a) * 1000.0f) / ((float) this.f22067L)});
                i.setDuration(200);
                i.setInterpolator(new DecelerateInterpolator());
                i.addUpdateListener(new ClippingBarView$$Lambda$9(this));
                i.start();
                if (m24235a(this.f22080b.m24372h()) > a) {
                    this.f22080b.m24368d();
                    this.f22080b.m24358a(((long) a) * 1000);
                }
            }
            m24243a(this.f22080b.f22220b, m24234a(this.f22064I, this.f22067L), Math.min(a2, a));
        }
    }

    private float m24233a(float f) {
        return this.f22089m + (Math.min(this.f22079a, f) * this.f22076U);
    }

    private String m24238a(int i) {
        int i2 = i / 60;
        i %= 60;
        return getResources().getString(C1761R.string.clipping_progress_time_minutes_seconds, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    private void m24239a(float f, float f2) {
        this.ar.f22050a = m24234a(f, this.f22067L);
        this.ar.f22051b = m24234a(f2, this.f22067L);
    }

    private static void m24243a(String str, int i, int i2) {
        ClippingBoundsBus b = FrontpageApplication.m28872h().mo4569b();
        b.f22106a.onNext(new ClippingBounds(str, i, i2));
    }

    private void m24245c() {
        this.f22072Q = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f22072Q.setDuration(200);
        this.f22072Q.setInterpolator(new DecelerateInterpolator());
        this.f22072Q.addUpdateListener(new ClippingBarView$$Lambda$8(this));
        this.f22072Q.addListener(new C19313(this));
        this.f22072Q.start();
    }

    private void m24240a(int i, long j) {
        if (this.f22080b != null) {
            int a = m24234a(i == 0 ? this.f22064I : this.f22079a, this.f22067L);
            this.as.onNext(Long.valueOf(MathUtil.m23811a(((long) m24234a(this.f22064I, this.f22067L)) * 1000, (((long) a) * 1000) + j, ((long) m24234a(this.f22079a, this.f22067L)) * 1000)));
            if (i != 0) {
                a = m24234a(this.f22064I, this.f22067L);
            }
            this.ah = a;
            this.f22068M = ((float) (this.ah * 1000)) / ((float) this.f22067L);
            this.f22069N = 0;
        }
    }

    final void m24251a() {
        if (this.f22080b != null) {
            long h = this.f22080b.m24372h();
            if (h > this.f22080b.m24369e()) {
                h = 0;
            }
            switch (this.ag) {
                case 1:
                    break;
                case 2:
                    this.ap.postDelayed(this.au, 200);
                    break;
                case 3:
                    this.f22067L = this.f22080b.m24369e();
                    this.ah = m24235a(h);
                    this.f22068M = ((float) h) / ((float) this.f22067L);
                    this.f22069N = ((float) this.f22080b.f22221c.g()) / ((float) this.f22067L);
                    if (this.f22080b.m24371g()) {
                        long j;
                        if (this.f22080b.m24373i() == 3) {
                            long j2 = 1000 - (h % 1000);
                            j = j2 < 200 ? j2 + 1000 : j2;
                        } else {
                            j = 1000;
                        }
                        this.ap.postDelayed(this.au, j);
                    }
                    invalidate();
                    break;
                case 4:
                    f22054c.onNext(Integer.valueOf((int) (this.f22067L / 1000)));
                    this.f22067L = this.f22080b.m24369e();
                    this.ah = m24235a(this.f22067L);
                    this.f22068M = 1.0f;
                    invalidate();
                    break;
                default:
                    break;
            }
            if (this.f22079a < 1.0f) {
                int a = m24234a(this.f22079a, this.f22067L);
                if (a > 0 && ((long) a) < this.f22067L / 1000 && m24235a(h) >= a) {
                    f22054c.onNext(Integer.valueOf(a));
                }
            }
        }
    }

    private static int m24235a(long j) {
        return (int) ((j + 500) / 1000);
    }

    private void m24241a(Context context, AttributeSet attributeSet) {
        ClippingBarView clippingBarView = this;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet2, C1761R.styleable.ClippingBarView);
            clippingBarView.f22056A = obtainStyledAttributes.getColor(1, ContextCompat.c(context2, C1761R.color.rdt_meta_text));
            clippingBarView.f22102z = obtainStyledAttributes.getColor(0, -1);
            clippingBarView.f22059D = obtainStyledAttributes.getColor(13, ContextCompat.c(context2, C1761R.color.rdt_lime));
            clippingBarView.f22060E = obtainStyledAttributes.getColor(7, -1);
            clippingBarView.f22057B = obtainStyledAttributes.getColor(8, ContextCompat.c(context2, C1761R.color.rdt_lime));
            clippingBarView.f22061F = obtainStyledAttributes.getColor(3, ContextCompat.c(context2, C1761R.color.rdt_lime));
            clippingBarView.f22062G = obtainStyledAttributes.getColor(5, -1);
            clippingBarView.f22077V = (float) obtainStyledAttributes.getDimensionPixelSize(6, (int) (((double) (displayMetrics.scaledDensity * 14.0f)) + 0.5d));
            clippingBarView.f22078W = (float) obtainStyledAttributes.getDimensionPixelSize(15, (int) (((double) (14.0f * displayMetrics.scaledDensity)) + 0.5d));
            clippingBarView.f22063H = obtainStyledAttributes.getColor(14, -1);
            clippingBarView.f22094r = (float) obtainStyledAttributes.getDimensionPixelSize(2, (int) (((double) (displayMetrics.density * 16.0f)) + 0.5d));
            clippingBarView.f22084h = (float) obtainStyledAttributes.getDimensionPixelSize(12, (int) (((double) (16.0f * displayMetrics.density)) + 0.5d));
            clippingBarView.f22095s = (float) obtainStyledAttributes.getDimensionPixelSize(11, (int) (((double) (32.0f * displayMetrics.density)) + 0.5d));
            clippingBarView.f22086j = (float) obtainStyledAttributes.getDimensionPixelSize(16, (int) (((double) (displayMetrics.density * 2.0f)) + 0.5d));
            clippingBarView.f22087k = (float) obtainStyledAttributes.getDimensionPixelSize(9, (int) (((double) (displayMetrics.density * 2.0f)) + 0.5d));
            clippingBarView.f22088l = (float) obtainStyledAttributes.getDimensionPixelSize(4, (int) (((double) (displayMetrics.density * 2.0f)) + 0.5d));
            clippingBarView.af = obtainStyledAttributes.getFloat(10, 0.5f);
            obtainStyledAttributes.recycle();
        } else {
            clippingBarView.f22056A = ContextCompat.c(context2, C1761R.color.rdt_meta_text);
            clippingBarView.f22102z = -1;
            clippingBarView.f22059D = ContextCompat.c(context2, C1761R.color.rdt_lime);
            clippingBarView.f22060E = -1;
            clippingBarView.f22057B = ContextCompat.c(context2, C1761R.color.rdt_lime);
            clippingBarView.f22061F = ContextCompat.c(context2, C1761R.color.rdt_lime);
            clippingBarView.f22062G = -1;
            clippingBarView.f22077V = displayMetrics.scaledDensity * 14.0f;
            clippingBarView.f22078W = 14.0f * displayMetrics.scaledDensity;
            clippingBarView.f22063H = -1;
            clippingBarView.f22094r = displayMetrics.density * 16.0f;
            clippingBarView.f22084h = 16.0f * displayMetrics.density;
            clippingBarView.f22095s = 32.0f * displayMetrics.density;
            clippingBarView.af = 0.5f;
            clippingBarView.f22086j = displayMetrics.density * 2.0f;
            clippingBarView.f22087k = displayMetrics.density * 2.0f;
            clippingBarView.f22088l = displayMetrics.density * 2.0f;
        }
        clippingBarView.f22058C = ContextCompat.c(context2, C1761R.color.video_preview_handle_grip_color);
        clippingBarView.f22085i = clippingBarView.f22095s / 2.0f;
        clippingBarView.f22096t = displayMetrics.density * 2.0f;
        clippingBarView.f22097u = displayMetrics.density * 8.0f;
        clippingBarView.ae = 6.0f * displayMetrics.density;
        clippingBarView.f22093q = displayMetrics.density * 8.0f;
        clippingBarView.ak = (int) (20.0f * displayMetrics.density);
        clippingBarView.f22098v = new Paint(1);
        clippingBarView.f22098v.setStyle(Style.FILL);
        setBubbleTextPaint(clippingBarView.f22062G);
        clippingBarView.f22101y = getResources().getString(C1761R.string.video_length_label);
        Rect rect = new Rect();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clippingBarView.f22101y);
        stringBuilder.append("9:99");
        String stringBuilder2 = stringBuilder.toString();
        clippingBarView.f22099w.getTextBounds(stringBuilder2, 0, stringBuilder2.length(), rect);
        clippingBarView.f22090n = (float) rect.width();
        stringBuilder = new StringBuilder();
        stringBuilder.append(clippingBarView.f22101y);
        stringBuilder.append("99:99");
        stringBuilder2 = stringBuilder.toString();
        clippingBarView.f22099w.getTextBounds(stringBuilder2, 0, stringBuilder2.length(), rect);
        clippingBarView.f22091o = (float) rect.width();
        clippingBarView.ab = ((float) rect.height()) / 2.0f;
        clippingBarView.ac = (clippingBarView.f22099w.descent() + clippingBarView.f22099w.ascent()) / 2.0f;
        int i = clippingBarView.f22063H;
        float f = clippingBarView.f22078W;
        clippingBarView.f22100x = new TextPaint(1);
        clippingBarView.f22100x.setTextSize(f);
        clippingBarView.f22100x.setColor(i);
        clippingBarView.f22100x.setTextAlign(Align.LEFT);
        clippingBarView.f22100x.setTypeface(Typeface.SANS_SERIF);
        rect = new Rect();
        clippingBarView.f22100x.getTextBounds("99:99", 0, 5, rect);
        clippingBarView.f22092p = (float) rect.width();
        clippingBarView.ad = (clippingBarView.f22100x.descent() + clippingBarView.f22100x.ascent()) / 2.0f;
        clippingBarView.aa = 8.0f * displayMetrics.density;
        clippingBarView.f22089m = ((clippingBarView.f22084h / 2.0f) + clippingBarView.f22092p) + (2.0f * clippingBarView.aa);
        clippingBarView.f22082f.setFillType(FillType.EVEN_ODD);
    }

    private void setBubbleTextPaint(int i) {
        this.f22099w = new TextPaint(1);
        this.f22099w.setTextSize(this.f22077V);
        this.f22099w.setColor(i);
        this.f22099w.setTextAlign(Align.CENTER);
        this.f22099w.setTypeface(Typeface.SANS_SERIF);
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) != 0) {
            i = (float) MeasureSpec.getSize(i);
        } else {
            i = 1132462080 * getResources().getDisplayMetrics().density;
        }
        this.f22075T = i;
        this.f22076U = this.f22075T - (this.f22089m * 2.0f);
        i = (((this.f22095s * (1.0f + this.af)) + (2.0f * this.aa)) + this.f22077V) + this.ae;
        if (MeasureSpec.getMode(i2) != 0) {
            i = Math.min(i, (float) MeasureSpec.getSize(i2));
        }
        setMeasuredDimension((int) (this.f22075T + 1056964608), (int) (i + 1056964608));
    }

    private void m24242a(Canvas canvas, int i) {
        if (i == 0) {
            this.f22081e.left = this.f22089m + (this.f22064I * this.f22076U);
        } else {
            this.f22081e.left = (this.f22089m + (this.f22079a * this.f22076U)) - this.f22084h;
        }
        this.f22081e.right = this.f22081e.left + this.f22084h;
        if (this.f22083g != i || (this.f22073R == 0 && (this.f22072Q == 0 || this.f22072Q.isRunning() == 0))) {
            this.f22081e.top = this.al + this.am;
            this.f22081e.bottom = this.f22081e.top + this.f22095s;
        } else {
            if (this.f22072Q == 0 || this.f22072Q.isRunning() == 0) {
                i = 1065353216;
            } else {
                i = this.f22072Q.getAnimatedFraction();
            }
            this.f22081e.top = this.al + (this.am * (this.f22074S ? 1.0f - i : i));
            RectF rectF = this.f22081e;
            float f = this.f22081e.top + this.f22095s;
            float f2 = this.f22095s * this.af;
            if (!this.f22074S) {
                i = 1065353216 - i;
            }
            rectF.bottom = f + (f2 * i);
        }
        this.f22098v.setColor(this.f22057B);
        canvas.drawRoundRect(this.f22081e, this.f22087k, this.f22087k, this.f22098v);
        i = (this.f22084h - (2.0f * this.f22096t)) / 1077936128;
        RectF rectF2 = this.f22081e;
        rectF2.left += i;
        this.f22081e.right = this.f22081e.left + this.f22096t;
        rectF2 = this.f22081e;
        rectF2.top += this.f22097u;
        rectF2 = this.f22081e;
        rectF2.bottom -= this.f22097u;
        this.f22098v.setColor(this.f22058C);
        canvas.drawRect(this.f22081e, this.f22098v);
        this.f22081e.offset(this.f22096t + i, 0);
        canvas.drawRect(this.f22081e, this.f22098v);
    }
}

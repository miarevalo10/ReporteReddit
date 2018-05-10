package com.instabug.library.invocation.p025a;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.instabug.library.C0593R;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.internal.media.AudioPlayer;
import com.instabug.library.internal.view.C0705a;
import com.instabug.library.internal.view.floatingactionbutton.C1652b;
import com.instabug.library.internal.view.floatingactionbutton.C1653c;
import com.instabug.library.internal.view.floatingactionbutton.RecordingFloatingActionButton;
import com.instabug.library.internal.view.floatingactionbutton.RecordingFloatingActionButton.RecordingState;
import com.instabug.library.invocation.C1381b;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.C0775c;
import com.instabug.library.util.InstabugSDKLogger;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: ScreenRecordingFab */
public class C0725c implements OnClickListener {
    private int f9740A;
    private C1710a f9741B;
    private Subscription f9742C;
    private C0724c f9743D;
    private LayoutParams f9744a;
    private int f9745b = 0;
    private int f9746c = 0;
    private int f9747d = 0;
    private int f9748e = 0;
    private int f9749f = 0;
    private int f9750g = 0;
    private int f9751h = 0;
    private float f9752i;
    private int f9753j;
    private boolean f9754k = false;
    private boolean f9755l = false;
    private boolean f9756m;
    private boolean f9757n = true;
    private C1652b f9758o;
    private C1653c f9759p;
    private C0705a f9760q;
    private int f9761r;
    private int f9762s;
    private int f9763t;
    private int f9764u;
    private int f9765v;
    private Handler f9766w = new Handler();
    private long f9767x;
    private Runnable f9768y = new C07171(this);
    private FrameLayout f9769z;

    /* compiled from: ScreenRecordingFab */
    class C07171 implements Runnable {
        final /* synthetic */ C0725c f9728a;

        C07171(C0725c c0725c) {
            this.f9728a = c0725c;
        }

        public void run() {
            this.f9728a.f9741B.setText(AudioPlayer.getFormattedDurationText(System.currentTimeMillis() - this.f9728a.f9767x));
            this.f9728a.f9766w.postDelayed(this, 1000);
        }
    }

    /* compiled from: ScreenRecordingFab */
    class C07182 implements OnClickListener {
        final /* synthetic */ C0725c f9729a;

        C07182(C0725c c0725c) {
            this.f9729a = c0725c;
        }

        public void onClick(View view) {
            view = this.f9729a.f9758o;
            if (view.f18566f) {
                view.mo3682c();
            } else {
                view.mo3681b();
            }
            if (view.f18566f != null) {
                C0775c.m8366b(Instabug.getApplicationContext());
                this.f9729a.f9757n = false;
                return;
            }
            C0775c.m8364a(Instabug.getApplicationContext());
            this.f9729a.f9757n = true;
        }
    }

    /* compiled from: ScreenRecordingFab */
    class C07193 implements OnClickListener {
        final /* synthetic */ C0725c f9730a;

        C07193(C0725c c0725c) {
            this.f9730a = c0725c;
        }

        public void onClick(View view) {
            if (this.f9730a.f9754k != null) {
                this.f9730a.m8245c();
                if (this.f9730a.f9743D != null) {
                    this.f9730a.f9743D.stop();
                }
                this.f9730a.f9754k = false;
                this.f9730a.f9766w.removeCallbacks(this.f9730a.f9768y);
            }
        }
    }

    /* compiled from: ScreenRecordingFab */
    static class C0723b extends SimpleOnGestureListener {
        C0723b() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return (Math.abs(motionEvent2.getX() - motionEvent.getX()) >= 90.0f || motionEvent2.getY() - motionEvent.getY() <= 1119092736) ? null : true;
        }
    }

    /* compiled from: ScreenRecordingFab */
    public interface C0724c {
        void start();

        void stop();
    }

    /* compiled from: ScreenRecordingFab */
    class C13734 implements Action1<ActivityLifeCycleEvent> {
        final /* synthetic */ C0725c f15500a;

        C13734(C0725c c0725c) {
            this.f15500a = c0725c;
        }

        public final /* synthetic */ void m15407a(Object obj) {
            switch ((ActivityLifeCycleEvent) obj) {
                case RESUMED:
                    C0725c.m8255j(this.f15500a);
                    return;
                case PAUSED:
                    this.f15500a.m8245c();
                    break;
                default:
                    break;
            }
        }
    }

    /* compiled from: ScreenRecordingFab */
    public class C1710a extends RecordingFloatingActionButton {
        final /* synthetic */ C0725c f19285f;
        private GestureDetector f19286k;
        private boolean f19287l = true;
        private C0722a f19288m;
        private long f19289n;
        private float f19290o;
        private float f19291p;
        private boolean f19292q = false;

        /* compiled from: ScreenRecordingFab */
        private class C0722a implements Runnable {
            final /* synthetic */ C1710a f9735a;
            private Handler f9736b;
            private float f9737c;
            private float f9738d;
            private long f9739e;

            private C0722a(C1710a c1710a) {
                this.f9735a = c1710a;
                this.f9736b = new Handler(Looper.getMainLooper());
            }

            public void run() {
                if (this.f9735a.getParent() != null) {
                    float min = Math.min(1.0f, ((float) (System.currentTimeMillis() - this.f9739e)) / 400.0f);
                    this.f9735a.m20532a((int) (((float) this.f9735a.f19285f.f9745b) + ((this.f9737c - ((float) this.f9735a.f19285f.f9745b)) * min)), (int) (((float) this.f9735a.f19285f.f9746c) + ((this.f9738d - ((float) this.f9735a.f19285f.f9746c)) * min)));
                    if (min < 1.0f) {
                        this.f9736b.post(this);
                    }
                }
            }

            static /* synthetic */ void m8234a(C0722a c0722a, float f, float f2) {
                c0722a.f9737c = f;
                c0722a.f9738d = f2;
                c0722a.f9739e = System.currentTimeMillis();
                c0722a.f9736b.post(c0722a);
            }
        }

        public C1710a(C0725c c0725c, Context context) {
            this.f19285f = c0725c;
            super(context);
            this.f19286k = new GestureDetector(context, new C0723b());
            this.f19288m = new C0722a();
            setId(C0593R.id.instabug_floating_button);
        }

        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            this.f19285f.f9744a = (LayoutParams) layoutParams;
            super.setLayoutParams(layoutParams);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.f19287l ? this.f19286k.onTouchEvent(motionEvent) : false) {
                m20531b();
            } else {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                motionEvent = motionEvent.getAction();
                if (motionEvent == null) {
                    this.f19289n = System.currentTimeMillis();
                    this.f19288m.f9736b.removeCallbacks(this.f19288m);
                    this.f19292q = true;
                } else if (motionEvent == 1) {
                    if (System.currentTimeMillis() - this.f19289n < 200) {
                        performClick();
                    }
                    this.f19292q = false;
                    m20531b();
                } else if (motionEvent == 2 && this.f19292q != null) {
                    motionEvent = rawX - this.f19290o;
                    float f = rawY - this.f19291p;
                    if (((float) this.f19285f.f9746c) + f > 50.0f) {
                        m20532a((int) (((float) this.f19285f.f9745b) + motionEvent), (int) (((float) this.f19285f.f9746c) + f));
                        this.f19285f.m8248e();
                        if (this.f19285f.f9755l != null) {
                            this.f19285f.m8247d();
                        }
                        this.f19285f.m8250f();
                    }
                    if (this.f19287l != null && this.f19292q == null && Math.abs(this.f19285f.f9744a.rightMargin) < 50 && Math.abs(this.f19285f.f9744a.topMargin - (getContext().getResources().getDisplayMetrics().heightPixels / 2)) < 250) {
                        m20531b();
                    }
                }
                this.f19290o = rawX;
                this.f19291p = rawY;
            }
            return true;
        }

        private void m20531b() {
            C0722a.m8234a(this.f19288m, (float) (this.f19285f.f9745b >= this.f19285f.f9747d / 2 ? this.f19285f.f9763t : this.f19285f.f9762s), (float) (this.f19285f.f9746c >= this.f19285f.f9748e / 2 ? this.f19285f.f9765v : this.f19285f.f9764u));
        }

        final void m20532a(int i, int i2) {
            this.f19285f.f9745b = i;
            this.f19285f.f9746c = i2;
            this.f19285f.f9744a.leftMargin = this.f19285f.f9745b;
            this.f19285f.f9744a.rightMargin = this.f19285f.f9747d - this.f19285f.f9745b;
            if (this.f19285f.f9751h == 2 && this.f19285f.f9749f > this.f19285f.f9747d) {
                this.f19285f.f9744a.rightMargin = (int) (((float) this.f19285f.f9744a.rightMargin) + (48.0f * this.f19285f.f9752i));
            }
            this.f19285f.f9744a.topMargin = this.f19285f.f9746c;
            this.f19285f.f9744a.bottomMargin = this.f19285f.f9748e - this.f19285f.f9746c;
            setLayoutParams(this.f19285f.f9744a);
        }
    }

    public C0725c(C0724c c0724c) {
        this.f9743D = c0724c;
    }

    public final void m8273b() {
        this.f9742C.c();
        this.f9754k = false;
        this.f9757n = true;
        this.f9766w.removeCallbacks(this.f9768y);
        m8245c();
    }

    private void m8245c() {
        if (this.f9769z != null) {
            this.f9769z.setOnClickListener(null);
            if (this.f9769z.getParent() != null && (this.f9769z.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f9769z.getParent()).removeView(this.f9769z);
            }
        }
    }

    private void m8247d() {
        this.f9769z.removeView(this.f9758o);
        this.f9769z.removeView(this.f9759p);
        this.f9755l = false;
    }

    private void m8248e() {
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams = new LayoutParams(this.f9753j, this.f9753j);
        layoutParams.leftMargin = this.f9744a.leftMargin + ((this.f9740A - this.f9753j) / 2);
        layoutParams.rightMargin = this.f9744a.rightMargin + ((this.f9740A - this.f9753j) / 2);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(this.f9759p.getWidth(), this.f9759p.getHeight());
        layoutParams2.leftMargin = this.f9744a.leftMargin + ((this.f9740A - this.f9753j) / 2);
        layoutParams2.rightMargin = this.f9744a.rightMargin + ((this.f9740A - this.f9753j) / 2);
        if (this.f9744a.topMargin > 2 * (this.f9753j + (this.f9761r * 2))) {
            i = this.f9744a.topMargin - (this.f9753j + this.f9761r);
            i2 = i - (this.f9753j + this.f9761r);
        } else {
            i = (this.f9744a.topMargin + this.f9740A) + this.f9761r;
            i2 = (this.f9753j + i) + this.f9761r;
        }
        layoutParams2.topMargin = i;
        layoutParams.topMargin = i2;
        this.f9758o.setLayoutParams(layoutParams);
        this.f9759p.setLayoutParams(layoutParams2);
    }

    private void m8250f() {
        if (this.f9756m) {
            this.f9756m = false;
            this.f9769z.removeView(this.f9760q);
        }
    }

    public final void m8272a() {
        this.f9742C = CurrentActivityLifeCycleEventBus.getInstance().subscribe(new C13734(this));
    }

    public void onClick(View view) {
        if (this.f9755l != null) {
            m8247d();
        } else if (Math.abs(this.f9744a.leftMargin - this.f9762s) <= 20 || Math.abs(this.f9744a.leftMargin - this.f9763t) <= 20) {
            if (Math.abs(this.f9744a.topMargin - this.f9764u) <= 20 || Math.abs(this.f9744a.topMargin - this.f9765v) <= 20) {
                m8248e();
                this.f9769z.addView(this.f9758o);
                this.f9769z.addView(this.f9759p);
                this.f9755l = true;
            }
        }
        if (this.f9754k == null) {
            this.f9754k = true;
            if (this.f9743D != null) {
                this.f9743D.start();
            }
            C0775c.m8364a(Instabug.getApplicationContext());
            this.f9741B.setRecordingState(RecordingState.RECORDING);
            this.f9767x = System.currentTimeMillis();
            this.f9766w.removeCallbacks(this.f9768y);
            this.f9766w.postDelayed(this.f9768y, 0);
        }
        m8250f();
    }

    static /* synthetic */ void m8255j(C0725c c0725c) {
        Context currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            c0725c.f9769z = new FrameLayout(currentActivity);
            c0725c.f9751h = currentActivity.getResources().getConfiguration().orientation;
            Rect rect = new Rect();
            currentActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i = rect.top;
            c0725c.f9752i = currentActivity.getResources().getDisplayMetrics().density;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            int i2 = c0725c.f9747d;
            int i3 = c0725c.f9748e;
            c0725c.f9748e = currentActivity.getResources().getDisplayMetrics().heightPixels;
            c0725c.f9747d = currentActivity.getResources().getDisplayMetrics().widthPixels;
            if (VERSION.SDK_INT >= 17) {
                currentActivity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                c0725c.f9750g = displayMetrics.heightPixels;
                c0725c.f9749f = displayMetrics.widthPixels;
            }
            c0725c.f9740A = (int) currentActivity.getResources().getDimension(C0593R.dimen.instabug_fab_size_normal);
            c0725c.f9753j = (int) currentActivity.getResources().getDimension(C0593R.dimen.instabug_fab_size_mini);
            c0725c.f9761r = (int) currentActivity.getResources().getDimension(C0593R.dimen.instabug_fab_actions_spacing);
            c0725c.f9762s = 0;
            c0725c.f9763t = c0725c.f9747d - (c0725c.f9740A + c0725c.f9761r);
            c0725c.f9764u = i;
            c0725c.f9765v = c0725c.f9748e - (c0725c.f9740A + c0725c.f9761r);
            c0725c.f9760q = new C0705a(currentActivity);
            c0725c.f9760q.setText(C0593R.string.instabug_str_video_recording_hint);
            c0725c.f9758o = new C1652b(currentActivity);
            if (!C0775c.m8365a() && c0725c.f9758o.getVisibility() == 0) {
                c0725c.f9758o.setVisibility(8);
            }
            if (c0725c.f9757n) {
                c0725c.f9758o.mo3682c();
            } else {
                c0725c.f9758o.mo3681b();
            }
            c0725c.f9758o.setOnClickListener(new C07182(c0725c));
            c0725c.f9759p = new C1653c(currentActivity);
            c0725c.f9759p.setOnClickListener(new C07193(c0725c));
            c0725c.f9741B = new C1710a(c0725c, currentActivity);
            if (c0725c.f9744a == null) {
                c0725c.f9744a = new LayoutParams(c0725c.f9740A, c0725c.f9740A, 51);
                c0725c.f9741B.setLayoutParams(c0725c.f9744a);
                switch (C1381b.m15431c().f15516a.f9783c) {
                    case BOTTOM_RIGHT:
                        c0725c.f9741B.m20532a(c0725c.f9763t, c0725c.f9765v);
                        break;
                    case BOTTOM_LEFT:
                        c0725c.f9741B.m20532a(c0725c.f9762s, c0725c.f9765v);
                        break;
                    case TOP_LEFT:
                        c0725c.f9741B.m20532a(c0725c.f9762s, c0725c.f9764u);
                        break;
                    case TOP_RIGHT:
                        c0725c.f9741B.m20532a(c0725c.f9763t, c0725c.f9764u);
                        break;
                    default:
                        c0725c.f9741B.m20532a(c0725c.f9763t, c0725c.f9765v);
                        break;
                }
            }
            float f = ((float) (c0725c.f9746c * c0725c.f9748e)) / ((float) i3);
            c0725c.f9745b = Math.round(((float) (c0725c.f9745b * c0725c.f9747d)) / ((float) i2));
            c0725c.f9746c = Math.round(f);
            c0725c.f9744a.leftMargin = c0725c.f9745b;
            c0725c.f9744a.rightMargin = c0725c.f9747d - c0725c.f9745b;
            c0725c.f9744a.topMargin = c0725c.f9746c;
            c0725c.f9744a.bottomMargin = c0725c.f9748e - c0725c.f9746c;
            c0725c.f9741B.setLayoutParams(c0725c.f9744a);
            c0725c.f9741B.m20531b();
            if (!(c0725c.f9754k || c0725c.f9756m || c0725c.f9744a.leftMargin == c0725c.f9762s)) {
                c0725c.f9756m = true;
                final ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
                c0725c.f9760q.setLayoutParams(layoutParams);
                c0725c.f9760q.post(new Runnable(c0725c) {
                    final /* synthetic */ C0725c f9732b;

                    public void run() {
                        layoutParams.leftMargin = this.f9732b.f9744a.leftMargin - this.f9732b.f9760q.getWidth();
                        layoutParams.rightMargin = this.f9732b.f9747d - this.f9732b.f9744a.leftMargin;
                        layoutParams.topMargin = this.f9732b.f9744a.topMargin + ((((this.f9732b.f9744a.height + this.f9732b.f9740A) / 2) - this.f9732b.f9760q.getHeight()) / 2);
                        this.f9732b.f9760q.setLayoutParams(layoutParams);
                    }
                });
                c0725c.f9769z.addView(c0725c.f9760q);
            }
            c0725c.f9741B.setOnClickListener(c0725c);
            c0725c.f9769z.addView(c0725c.f9741B);
            c0725c.f9741B.setRecordingState(c0725c.f9754k ? RecordingState.RECORDING : RecordingState.STOPPED);
            ((FrameLayout) currentActivity.getWindow().getDecorView()).addView(c0725c.f9769z, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        InstabugSDKLogger.m8360v(C0725c.class, "current activity equal null");
    }
}

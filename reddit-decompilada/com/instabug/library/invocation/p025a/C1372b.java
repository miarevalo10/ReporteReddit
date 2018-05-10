package com.instabug.library.invocation.p025a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
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
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import com.instabug.library.C0593R;
import com.instabug.library.Instabug;
import com.instabug.library.invocation.C0729a;
import com.instabug.library.invocation.C1381b;
import com.instabug.library.invocation.util.InstabugFloatingButtonEdge;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;

/* compiled from: FloatingButtonInvoker */
public class C1372b implements OnClickListener, C0711a<Void> {
    static final /* synthetic */ boolean f15487g = true;
    int f15488a;
    int f15489b = 0;
    int f15490c = 0;
    int f15491d = 0;
    int f15492e = 0;
    float f15493f;
    private LayoutParams f15494h;
    private int f15495i;
    private int f15496j = 0;
    private C0729a f15497k;
    private C0715c f15498l;
    private int f15499m;

    /* compiled from: FloatingButtonInvoker */
    static class C0712a extends SimpleOnGestureListener {
        C0712a() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return (Math.abs(motionEvent2.getX() - motionEvent.getX()) >= 90.0f || motionEvent2.getY() - motionEvent.getY() <= 1119092736) ? null : true;
        }
    }

    /* compiled from: FloatingButtonInvoker */
    public class C0714b extends ImageButton {
        final /* synthetic */ C1372b f9718a;
        private GestureDetector f9719b;
        private boolean f9720c = true;
        private C0713a f9721d;
        private long f9722e;
        private float f9723f;
        private float f9724g;
        private boolean f9725h = false;

        /* compiled from: FloatingButtonInvoker */
        private class C0713a implements Runnable {
            final /* synthetic */ C0714b f9713a;
            private Handler f9714b;
            private float f9715c;
            private float f9716d;
            private long f9717e;

            private C0713a(C0714b c0714b) {
                this.f9713a = c0714b;
                this.f9714b = new Handler(Looper.getMainLooper());
            }

            public void run() {
                if (this.f9713a.getParent() != null) {
                    float min = Math.min(1.0f, ((float) (System.currentTimeMillis() - this.f9717e)) / 400.0f);
                    this.f9713a.m8232a((int) (((float) this.f9713a.f9718a.f15488a) + ((this.f9715c - ((float) this.f9713a.f9718a.f15488a)) * min)), (int) (((float) this.f9713a.f9718a.f15489b) + ((this.f9716d - ((float) this.f9713a.f9718a.f15489b)) * min)));
                    if (min < 1.0f) {
                        this.f9714b.post(this);
                    }
                }
            }

            static /* synthetic */ void m8229a(C0713a c0713a, float f, float f2) {
                c0713a.f9715c = f;
                c0713a.f9716d = f2;
                c0713a.f9717e = System.currentTimeMillis();
                c0713a.f9714b.post(c0713a);
            }
        }

        public C0714b(C1372b c1372b, Context context) {
            this.f9718a = c1372b;
            super(context);
            this.f9719b = new GestureDetector(context, new C0712a());
            this.f9721d = new C0713a();
            setId(C0593R.id.instabug_floating_button);
        }

        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            this.f9718a.f15494h = (LayoutParams) layoutParams;
            super.setLayoutParams(layoutParams);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.f9720c ? this.f9719b.onTouchEvent(motionEvent) : false) {
                m8230a();
            } else {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                motionEvent = motionEvent.getAction();
                if (motionEvent == null) {
                    this.f9722e = System.currentTimeMillis();
                    this.f9721d.f9714b.removeCallbacks(this.f9721d);
                    this.f9725h = true;
                } else if (motionEvent == 1) {
                    if (System.currentTimeMillis() - this.f9722e < 200) {
                        performClick();
                    }
                    this.f9725h = false;
                    m8230a();
                } else if (motionEvent == 2 && this.f9725h != null) {
                    motionEvent = rawX - this.f9723f;
                    float f = rawY - this.f9724g;
                    if (((float) this.f9718a.f15489b) + f > 50.0f) {
                        m8232a((int) (((float) this.f9718a.f15488a) + motionEvent), (int) (((float) this.f9718a.f15489b) + f));
                    }
                    if (this.f9720c != null && this.f9725h == null && Math.abs(this.f9718a.f15494h.rightMargin) < 50 && Math.abs(this.f9718a.f15494h.topMargin - (getContext().getResources().getDisplayMetrics().heightPixels / 2)) < 250) {
                        m8230a();
                    }
                }
                this.f9723f = rawX;
                this.f9724g = rawY;
            }
            return true;
        }

        private void m8230a() {
            if (C1381b.m15431c().f15516a.f9784d.f9726a == InstabugFloatingButtonEdge.LEFT) {
                C0713a.m8229a(this.f9721d, ((float) this.f9718a.f15488a) >= ((float) this.f9718a.f15495i) / 2.0f ? (float) ((this.f9718a.f15495i - this.f9718a.f15499m) + 10) : -10.0f, (float) (this.f9718a.f15489b > this.f9718a.f15496j - this.f9718a.f15499m ? this.f9718a.f15496j - (this.f9718a.f15499m * 2) : this.f9718a.f15489b));
                return;
            }
            C0713a.m8229a(this.f9721d, (float) (((float) this.f9718a.f15488a) >= ((float) this.f9718a.f15495i) / 2.0f ? this.f9718a.f15495i + 10 : -10 + this.f9718a.f15499m), (float) (this.f9718a.f15489b > this.f9718a.f15496j - this.f9718a.f15499m ? this.f9718a.f15496j - (this.f9718a.f15499m * 2) : this.f9718a.f15489b));
        }

        final void m8232a(int i, int i2) {
            this.f9718a.f15488a = i;
            this.f9718a.f15489b = i2;
            this.f9718a.f15494h.leftMargin = this.f9718a.f15488a + 0;
            this.f9718a.f15494h.rightMargin = this.f9718a.f15495i - this.f9718a.f15488a;
            if (this.f9718a.f15492e == 2 && this.f9718a.f15490c > this.f9718a.f15495i) {
                this.f9718a.f15494h.rightMargin = (int) (((float) this.f9718a.f15494h.rightMargin) + (48.0f * this.f9718a.f15493f));
            }
            this.f9718a.f15494h.topMargin = 0 + this.f9718a.f15489b;
            this.f9718a.f15494h.bottomMargin = this.f9718a.f15496j - this.f9718a.f15489b;
            setLayoutParams(this.f9718a.f15494h);
        }
    }

    /* compiled from: FloatingButtonInvoker */
    public static class C0715c extends FrameLayout {
        public C0715c(Context context) {
            super(context);
        }
    }

    /* compiled from: FloatingButtonInvoker */
    public static class C0716d {
        public InstabugFloatingButtonEdge f9726a = InstabugFloatingButtonEdge.RIGHT;
        public int f9727b = 250;
    }

    public C1372b(C0729a c0729a) {
        this.f15497k = c0729a;
    }

    public final void mo2596a() {
        Context currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            this.f15498l = new C0715c(currentActivity);
            this.f15492e = currentActivity.getResources().getConfiguration().orientation;
            this.f15493f = currentActivity.getResources().getDisplayMetrics().density;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            int i = this.f15495i;
            int i2 = this.f15496j;
            this.f15496j = currentActivity.getResources().getDisplayMetrics().heightPixels;
            this.f15495i = currentActivity.getResources().getDisplayMetrics().widthPixels;
            if (VERSION.SDK_INT >= 17) {
                currentActivity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                this.f15491d = displayMetrics.heightPixels;
                this.f15490c = displayMetrics.widthPixels;
            }
            this.f15499m = (int) (56.0f * this.f15493f);
            View c0714b = new C0714b(this, currentActivity);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            new ShapeDrawable(new OvalShape()).getPaint().setColor(Instabug.getPrimaryColor());
            shapeDrawable.getPaint().setColor(Instabug.getPrimaryColor());
            Drawable layerDrawable = new LayerDrawable(new Drawable[]{r5, shapeDrawable});
            Drawable drawable = layerDrawable;
            drawable.setLayerInset(0, 0, 0, 0, 0);
            drawable.setLayerInset(1, 2, 2, 2, 2);
            c0714b.setBackgroundDrawable(layerDrawable);
            layerDrawable = currentActivity.getResources().getDrawable(C0593R.drawable.instabug_ic_floating_btn);
            if (f15487g || layerDrawable != null) {
                c0714b.setImageDrawable(layerDrawable);
                c0714b.setScaleType(ScaleType.CENTER);
                if (this.f15494h != null) {
                    float f = ((float) (this.f15488a * this.f15495i)) / ((float) i);
                    float f2 = ((float) (this.f15489b * this.f15496j)) / ((float) i2);
                    this.f15488a = Math.round(f);
                    this.f15489b = Math.round(f2);
                    this.f15494h.leftMargin = this.f15488a;
                    this.f15494h.rightMargin = this.f15495i - this.f15488a;
                    this.f15494h.topMargin = this.f15489b;
                    this.f15494h.bottomMargin = this.f15496j - this.f15489b;
                    c0714b.setLayoutParams(this.f15494h);
                    c0714b.m8230a();
                } else if (C1381b.m15431c().f15516a.f9784d.f9726a == InstabugFloatingButtonEdge.LEFT) {
                    this.f15494h = new LayoutParams(this.f15499m, this.f15499m, 51);
                    c0714b.setLayoutParams(this.f15494h);
                    c0714b.m8232a(-10, C1381b.m15431c().f15516a.f9784d.f9727b);
                } else {
                    this.f15494h = new LayoutParams(this.f15499m, this.f15499m, 53);
                    c0714b.setLayoutParams(this.f15494h);
                    c0714b.m8232a(this.f15495i + 10, C1381b.m15431c().f15516a.f9784d.f9727b);
                }
                c0714b.setOnClickListener(this);
                c0714b.setScaleType(ScaleType.CENTER_INSIDE);
                this.f15498l.addView(c0714b);
                ((FrameLayout) currentActivity.getWindow().getDecorView()).addView(this.f15498l, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            throw new AssertionError();
        }
    }

    public void onClick(View view) {
        this.f15497k.mo2599a();
    }

    public final void mo2597b() {
        if (this.f15498l != null) {
            this.f15498l.setOnClickListener(null);
            if (this.f15498l.getParent() != null && (this.f15498l.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f15498l.getParent()).removeView(this.f15498l);
            }
        }
    }
}

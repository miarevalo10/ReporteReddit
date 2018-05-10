package com.twitter.sdk.android.tweetui.internal;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.SwipeableViewProvider;

public class MultiTouchImageView extends ImageView implements SwipeableViewProvider {
    final ScaleGestureDetector f30793a;
    final GestureDetector f30794b;
    final Matrix f30795c;
    final Matrix f30796d;
    final Matrix f30797e;
    final RectF f30798f;
    final RectF f30799g;
    final float[] f30800h;
    boolean f30801i;

    class C20791 extends SimpleOnScaleGestureListener {
        final /* synthetic */ MultiTouchImageView f24226a;

        C20791(MultiTouchImageView multiTouchImageView) {
            this.f24226a = multiTouchImageView;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            this.f24226a.m31800a(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            this.f24226a.m31798a();
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            if (this.f24226a.getScale() < 1.0f) {
                this.f24226a.f30797e.reset();
                this.f24226a.m31798a();
            }
        }
    }

    class C20802 extends SimpleOnGestureListener {
        final /* synthetic */ MultiTouchImageView f24227a;

        C20802(MultiTouchImageView multiTouchImageView) {
            this.f24227a = multiTouchImageView;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f24227a.m31799a(-f, -f2);
            this.f24227a.m31798a();
            if (this.f24227a.f30801i != null && this.f24227a.f30793a.isInProgress() == null) {
                this.f24227a.m31802a(null);
            }
            return true;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (this.f24227a.getScale() > 1.0f) {
                this.f24227a.m31801a(this.f24227a.getScale(), 1.0f, motionEvent.getX(), motionEvent.getY());
            } else {
                this.f24227a.m31801a(this.f24227a.getScale(), 2.0f, motionEvent.getX(), motionEvent.getY());
            }
            return true;
        }
    }

    public MultiTouchImageView(Context context) {
        this(context, (byte) 0);
    }

    private MultiTouchImageView(Context context, byte b) {
        this(context, (char) (byte) 0);
    }

    private MultiTouchImageView(Context context, char c) {
        super(context, null, 0);
        this.f30795c = new Matrix();
        this.f30796d = new Matrix();
        this.f30797e = new Matrix();
        this.f30798f = new RectF();
        this.f30799g = new RectF();
        this.f30800h = new float[9];
        this.f30801i = false;
        this.f30793a = new ScaleGestureDetector(context, new C20791(this));
        this.f30794b = new GestureDetector(context, new C20802(this));
    }

    private boolean m31797c() {
        Drawable drawable = getDrawable();
        return drawable != null && drawable.getIntrinsicWidth() > 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (m31797c()) {
            this.f30798f.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
            z = getDrawable();
            i2 = new RectF(0.0f, 0.0f, (float) z.getIntrinsicWidth(), (float) z.getIntrinsicHeight());
            this.f30796d.reset();
            this.f30796d.setRectToRect(i2, this.f30798f, ScaleToFit.CENTER);
            m31798a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m31797c()) {
            return false;
        }
        m31802a(true);
        boolean onTouchEvent = this.f30793a.onTouchEvent(motionEvent);
        if (!this.f30794b.onTouchEvent(motionEvent)) {
            if (!onTouchEvent) {
                onTouchEvent = false;
                if (!onTouchEvent) {
                    if (super.onTouchEvent(motionEvent) != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        onTouchEvent = true;
        if (onTouchEvent) {
            if (super.onTouchEvent(motionEvent) != null) {
                return false;
            }
        }
        return true;
    }

    final void m31802a(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    final void m31800a(float f, float f2, float f3) {
        this.f30797e.postScale(f, f, f2, f3);
    }

    float getScale() {
        this.f30797e.getValues(this.f30800h);
        return this.f30800h[0];
    }

    final void m31799a(float f, float f2) {
        this.f30797e.postTranslate(f, f2);
    }

    Matrix getDrawMatrix() {
        this.f30795c.set(this.f30796d);
        this.f30795c.postConcat(this.f30797e);
        return this.f30795c;
    }

    final void m31801a(float f, float f2, final float f3, final float f4) {
        f = ValueAnimator.ofFloat(new float[]{f, f2});
        f.setDuration(300);
        f.setInterpolator(new AccelerateDecelerateInterpolator());
        f.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ MultiTouchImageView f24230c;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f24230c.m31800a(((Float) valueAnimator.getAnimatedValue()).floatValue() / this.f24230c.getScale(), f3, f4);
                this.f24230c.m31798a();
            }
        });
        f.start();
    }

    public final boolean mo5513b() {
        return getScale() == 1.0f;
    }

    final void m31798a() {
        Matrix drawMatrix = getDrawMatrix();
        Drawable drawable = getDrawable();
        float f = 0.0f;
        if (drawable != null) {
            this.f30799g.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            drawMatrix.mapRect(this.f30799g);
        }
        RectF rectF = this.f30799g;
        float height = rectF.height() <= this.f30798f.height() ? ((this.f30798f.height() - rectF.height()) / 2.0f) - rectF.top : rectF.top > 0.0f ? -rectF.top : rectF.bottom < this.f30798f.height() ? this.f30798f.height() - rectF.bottom : 0.0f;
        if (rectF.width() <= this.f30798f.width()) {
            this.f30801i = true;
            f = ((this.f30798f.width() - rectF.width()) / 2.0f) - rectF.left;
        } else if (rectF.left > 0.0f) {
            this.f30801i = true;
            f = -rectF.left;
        } else if (rectF.right < this.f30798f.width()) {
            this.f30801i = true;
            f = this.f30798f.width() - rectF.right;
        } else {
            this.f30801i = false;
        }
        m31799a(f, height);
        setScaleType(ScaleType.MATRIX);
        setImageMatrix(getDrawMatrix());
    }
}

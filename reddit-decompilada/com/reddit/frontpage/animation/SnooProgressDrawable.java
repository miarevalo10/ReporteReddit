package com.reddit.frontpage.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.Util;

public class SnooProgressDrawable extends Drawable {
    private static int f19925g = -1;
    private static int f19926h = -1;
    private static int f19927i = -1;
    private Bitmap f19928a;
    private final Paint f19929b;
    private final Paint f19930c;
    private Rect f19931d;
    private final Rect f19932e;
    private final RectF f19933f;
    private int f19934j;
    private int f19935k;
    private final ReversibleInterpolator f19936l;
    private int f19937m;
    private int f19938n;

    private static class ReversibleInterpolator implements Interpolator {
        boolean f19924a;

        private ReversibleInterpolator() {
            this.f19924a = true;
        }

        public float getInterpolation(float f) {
            if (!this.f19924a) {
                f = 1.0f - f;
            }
            return 0.25f + (f / 2.0f);
        }
    }

    public int getOpacity() {
        return -2;
    }

    public void setAlpha(int i) {
    }

    public SnooProgressDrawable(Context context) {
        this(1, context);
    }

    public SnooProgressDrawable(int i, Context context) {
        this.f19932e = new Rect();
        this.f19933f = new RectF();
        this.f19934j = 0;
        this.f19935k = 0;
        this.f19936l = new ReversibleInterpolator();
        this.f19937m = 0;
        this.f19938n = C1761R.drawable.reddit_loader_white;
        if (context != null) {
            context = ResourcesUtil.m22740i(context, C1761R.attr.rdt_active_color);
        } else {
            context = Util.m23950a((int) C1761R.color.rdt_blue);
        }
        this.f19929b = new Paint();
        this.f19929b.setColor(context);
        this.f19929b.setStrokeWidth((float) Util.m24012d((int) C1761R.dimen.quarter_pad));
        this.f19929b.setAntiAlias(true);
        this.f19929b.setDither(true);
        this.f19929b.setStyle(Style.STROKE);
        this.f19929b.setColorFilter(new PorterDuffColorFilter(context, Mode.SRC_IN));
        context = Color.argb(50, Color.red(context), Color.green(context), Color.blue(context));
        this.f19930c = new Paint(this.f19929b);
        this.f19930c.setColor(context);
        if (f19925g == -1 || f19926h == -1 || f19927i == -1) {
            f19925g = Util.m24012d((int) C1761R.dimen.quad_pad);
            f19926h = Util.m24012d((int) C1761R.dimen.quad_pad);
            f19927i = Util.m24012d((int) C1761R.dimen.double_half_pad);
        }
        if (i == 1) {
            m21793b(C1761R.drawable.reddit_loader_white);
        }
        m21794a(0);
    }

    private void m21793b(int i) {
        this.f19938n = i;
        this.f19928a = BitmapFactory.decodeResource(FrontpageApplication.f27402a.getResources(), i);
        this.f19931d = new Rect(0, 0, this.f19928a.getWidth(), this.f19928a.getHeight());
        invalidateSelf();
    }

    public final void m21794a(int i) {
        this.f19934j = i;
        if (i >= 0) {
            this.f19929b.setAlpha(255);
            this.f19935k = (int) ((((float) i) * 1135869952) / 1120403456);
            invalidateSelf();
            if (this.f19938n == C1761R.drawable.reddit_loader_failstate) {
                m21793b(C1761R.drawable.reddit_loader_white);
                return;
            }
        }
        m21793b(C1761R.drawable.reddit_loader_failstate);
    }

    protected void onBoundsChange(Rect rect) {
        int centerX = rect.centerX();
        rect = rect.centerY();
        this.f19932e.left = centerX - (f19925g / 2);
        this.f19932e.top = rect - (f19926h / 2);
        this.f19932e.right = (f19925g / 2) + centerX;
        this.f19932e.bottom = (f19926h / 2) + rect;
        this.f19933f.left = (float) (centerX - f19927i);
        this.f19933f.top = (float) (rect - f19927i);
        this.f19933f.right = (float) (centerX + f19927i);
        this.f19933f.bottom = (float) (rect + f19927i);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        canvas.drawArc(this.f19933f, 270.0f, 360.0f, false, this.f19930c);
        if (this.f19928a != null) {
            canvas.drawBitmap(this.f19928a, this.f19931d, this.f19932e, this.f19929b);
        }
        if (this.f19934j > 0) {
            canvas.drawArc(this.f19933f, 270.0f, (float) this.f19935k, false, this.f19929b);
        }
        if (this.f19934j == null) {
            canvas = (int) (System.currentTimeMillis() % 1000);
            if (this.f19937m > canvas) {
                ReversibleInterpolator reversibleInterpolator = this.f19936l;
                reversibleInterpolator.f19924a ^= 1;
            }
            this.f19937m = canvas;
            this.f19929b.setAlpha((int) (255.0f * this.f19936l.getInterpolation(((float) canvas) / 1000.0f)));
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f19929b.setColorFilter(colorFilter);
        this.f19930c.setColorFilter(colorFilter);
    }
}

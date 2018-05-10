package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;

public class GifDrawable extends Drawable implements Animatable, FrameCallback {
    final GifState f12628a;
    boolean f12629b;
    private boolean f12630c;
    private boolean f12631d;
    private boolean f12632e;
    private int f12633f;
    private int f12634g;
    private boolean f12635h;
    private Paint f12636i;
    private Rect f12637j;

    static final class GifState extends ConstantState {
        final GifFrameLoader f3556a;

        public final int getChangingConfigurations() {
            return 0;
        }

        GifState(GifFrameLoader gifFrameLoader) {
            this.f3556a = gifFrameLoader;
        }

        public final Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public final Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    public int getOpacity() {
        return -2;
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(new GifState(new GifFrameLoader(Glide.m2775a(context), gifDecoder, i, i2, (Transformation) transformation, bitmap)));
    }

    GifDrawable(GifState gifState) {
        this.f12632e = true;
        this.f12634g = -1;
        this.f12628a = (GifState) Preconditions.m3217a((Object) gifState);
    }

    public final Bitmap m11674a() {
        return this.f12628a.f3556a.f3565h;
    }

    public final ByteBuffer m11675b() {
        return this.f12628a.f3556a.f3558a.mo874a().asReadOnlyBuffer();
    }

    public void start() {
        this.f12631d = true;
        this.f12633f = 0;
        if (this.f12632e) {
            m11670d();
        }
    }

    public void stop() {
        this.f12631d = false;
        m11671e();
    }

    private void m11670d() {
        Preconditions.m3221a(this.f12629b ^ true, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f12628a.f3556a.m3071a() != 1) {
            if (!this.f12630c) {
                this.f12630c = true;
                GifFrameLoader gifFrameLoader = this.f12628a.f3556a;
                if (gifFrameLoader.f3563f) {
                    throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
                } else if (gifFrameLoader.f3559b.contains(this)) {
                    throw new IllegalStateException("Cannot subscribe twice in a row");
                } else {
                    boolean isEmpty = gifFrameLoader.f3559b.isEmpty();
                    gifFrameLoader.f3559b.add(this);
                    if (isEmpty && !gifFrameLoader.f3561d) {
                        gifFrameLoader.f3561d = true;
                        gifFrameLoader.f3563f = false;
                        gifFrameLoader.m3075c();
                    }
                }
            } else {
                return;
            }
        }
        invalidateSelf();
    }

    private void m11671e() {
        this.f12630c = false;
        GifFrameLoader gifFrameLoader = this.f12628a.f3556a;
        gifFrameLoader.f3559b.remove(this);
        if (gifFrameLoader.f3559b.isEmpty()) {
            gifFrameLoader.f3561d = false;
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Preconditions.m3221a(this.f12629b ^ 1, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f12632e = z;
        if (!z) {
            m11671e();
        } else if (this.f12631d) {
            m11670d();
        }
        return super.setVisible(z, z2);
    }

    public int getIntrinsicWidth() {
        return this.f12628a.f3556a.m3074b().getWidth();
    }

    public int getIntrinsicHeight() {
        return this.f12628a.f3556a.m3074b().getHeight();
    }

    public boolean isRunning() {
        return this.f12630c;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f12635h = true;
    }

    public void draw(Canvas canvas) {
        if (!this.f12629b) {
            if (this.f12635h) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), m11672f());
                this.f12635h = false;
            }
            canvas.drawBitmap(this.f12628a.f3556a.m3074b(), null, m11672f(), m11673g());
        }
    }

    public void setAlpha(int i) {
        m11673g().setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        m11673g().setColorFilter(colorFilter);
    }

    private Rect m11672f() {
        if (this.f12637j == null) {
            this.f12637j = new Rect();
        }
        return this.f12637j;
    }

    private Paint m11673g() {
        if (this.f12636i == null) {
            this.f12636i = new Paint(2);
        }
        return this.f12636i;
    }

    public ConstantState getConstantState() {
        return this.f12628a;
    }

    public final void mo1001c() {
        Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        GifFrameLoader gifFrameLoader = this.f12628a.f3556a;
        if ((gifFrameLoader.f3562e != null ? gifFrameLoader.f3562e.f19483a : -1) == this.f12628a.f3556a.m3071a() - 1) {
            this.f12633f++;
        }
        if (this.f12634g != -1 && this.f12633f >= this.f12634g) {
            stop();
        }
    }
}

package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.Picasso.LoadedFrom;

final class PicassoDrawable extends BitmapDrawable {
    private static final Paint f23844e = new Paint();
    Drawable f23845a;
    long f23846b;
    boolean f23847c;
    int f23848d = 255;
    private final boolean f23849f;
    private final float f23850g;
    private final LoadedFrom f23851h;

    static void m25782a(ImageView imageView, Context context, Bitmap bitmap, LoadedFrom loadedFrom, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new PicassoDrawable(context, bitmap, drawable, loadedFrom, z, z2));
    }

    static void m25783a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if ((imageView.getDrawable() instanceof AnimationDrawable) != null) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    private PicassoDrawable(Context context, Bitmap bitmap, Drawable drawable, LoadedFrom loadedFrom, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f23849f = z2;
        this.f23850g = context.getResources().getDisplayMetrics().density;
        this.f23851h = loadedFrom;
        context = (loadedFrom == LoadedFrom.MEMORY || z) ? null : 1;
        if (context != null) {
            this.f23845a = drawable;
            this.f23847c = true;
            this.f23846b = SystemClock.uptimeMillis();
        }
    }

    public final void draw(Canvas canvas) {
        if (this.f23847c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f23846b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f23847c = false;
                this.f23845a = null;
                super.draw(canvas);
            } else {
                if (this.f23845a != null) {
                    this.f23845a.draw(canvas);
                }
                super.setAlpha((int) (((float) this.f23848d) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f23848d);
                if (VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.f23849f) {
            f23844e.setColor(-1);
            canvas.drawPath(m25781a(new Point(0, 0), (int) (16.0f * this.f23850g)), f23844e);
            f23844e.setColor(this.f23851h.f23821d);
            canvas.drawPath(m25781a(new Point(0, 0), (int) (15.0f * this.f23850g)), f23844e);
        }
    }

    public final void setAlpha(int i) {
        this.f23848d = i;
        if (this.f23845a != null) {
            this.f23845a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f23845a != null) {
            this.f23845a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    protected final void onBoundsChange(Rect rect) {
        if (this.f23845a != null) {
            this.f23845a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    private static Path m25781a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        i = new Path();
        i.moveTo((float) point.x, (float) point.y);
        i.lineTo((float) point2.x, (float) point2.y);
        i.lineTo((float) point3.x, (float) point3.y);
        return i;
    }
}

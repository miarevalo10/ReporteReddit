package com.reddit.frontpage.animation;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import java.util.ArrayList;
import java.util.List;

public class SnooIndeterminateAnimation extends Drawable implements Runnable {
    private static final List<Bitmap> f19917a = new ArrayList();
    private static final Rect f19918b = new Rect();
    private static final int[] f19919g = new int[]{C1761R.drawable.reddit_loader_00, C1761R.drawable.reddit_loader_01, C1761R.drawable.reddit_loader_02, C1761R.drawable.reddit_loader_03, C1761R.drawable.reddit_loader_04, C1761R.drawable.reddit_loader_05, C1761R.drawable.reddit_loader_06, C1761R.drawable.reddit_loader_07, C1761R.drawable.reddit_loader_08, C1761R.drawable.reddit_loader_09, C1761R.drawable.reddit_loader_10, C1761R.drawable.reddit_loader_11, C1761R.drawable.reddit_loader_12, C1761R.drawable.reddit_loader_13, C1761R.drawable.reddit_loader_14, C1761R.drawable.reddit_loader_15, C1761R.drawable.reddit_loader_16, C1761R.drawable.reddit_loader_17, C1761R.drawable.reddit_loader_18, C1761R.drawable.reddit_loader_19, C1761R.drawable.reddit_loader_20, C1761R.drawable.reddit_loader_21, C1761R.drawable.reddit_loader_22, C1761R.drawable.reddit_loader_23, C1761R.drawable.reddit_loader_24, C1761R.drawable.reddit_loader_25, C1761R.drawable.reddit_loader_26, C1761R.drawable.reddit_loader_27, C1761R.drawable.reddit_loader_28, C1761R.drawable.reddit_loader_29, C1761R.drawable.reddit_loader_30, C1761R.drawable.reddit_loader_31, C1761R.drawable.reddit_loader_32, C1761R.drawable.reddit_loader_33, C1761R.drawable.reddit_loader_34, C1761R.drawable.reddit_loader_35, C1761R.drawable.reddit_loader_36, C1761R.drawable.reddit_loader_37, C1761R.drawable.reddit_loader_38, C1761R.drawable.reddit_loader_39, C1761R.drawable.reddit_loader_40, C1761R.drawable.reddit_loader_41, C1761R.drawable.reddit_loader_42, C1761R.drawable.reddit_loader_43, C1761R.drawable.reddit_loader_44, C1761R.drawable.reddit_loader_45, C1761R.drawable.reddit_loader_46, C1761R.drawable.reddit_loader_47};
    private final Paint f19920c = new Paint();
    private long f19921d = 0;
    private int f19922e;
    private final Rect f19923f = new Rect(0, 0, 0, 0);

    public int getOpacity() {
        return -2;
    }

    public SnooIndeterminateAnimation() {
        if (f19917a.size() == 0) {
            Resources resources = FrontpageApplication.f27402a.getResources();
            for (int decodeResource : f19919g) {
                f19917a.add(BitmapFactory.decodeResource(resources, decodeResource));
            }
            f19918b.set(0, 0, ((Bitmap) f19917a.get(0)).getWidth(), ((Bitmap) f19917a.get(0)).getHeight());
        }
    }

    public Rect getDirtyBounds() {
        return this.f19923f;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f19923f.set(rect);
    }

    public void run() {
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap((Bitmap) f19917a.get(this.f19922e), f19918b, this.f19923f, this.f19920c);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f19921d >= 32) {
            this.f19921d = currentTimeMillis;
            canvas = this.f19922e + 1;
            this.f19922e = canvas;
            if (canvas > f19917a.size() - 1) {
                this.f19922e = null;
            }
        }
        scheduleSelf(this, SystemClock.uptimeMillis() + 32);
    }

    public void setAlpha(int i) {
        this.f19920c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f19920c.setColorFilter(colorFilter);
    }
}

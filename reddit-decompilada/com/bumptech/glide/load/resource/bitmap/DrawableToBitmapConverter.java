package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;

final class DrawableToBitmapConverter {
    private static final BitmapPool f3538a = new C15981();

    class C15981 extends BitmapPoolAdapter {
        public final void mo940a(Bitmap bitmap) {
        }

        C15981() {
        }
    }

    static Resource<Bitmap> m3042a(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        drawable = drawable.getCurrent();
        Object obj = null;
        if (drawable instanceof BitmapDrawable) {
            drawable = ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof Animatable) {
            drawable = null;
        } else {
            drawable = m3043b(bitmapPool, drawable, i, i2);
            obj = 1;
        }
        if (obj == null) {
            bitmapPool = f3538a;
        }
        return BitmapResource.m11573a(drawable, bitmapPool);
    }

    private static Bitmap m3043b(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5) != null) {
                i = new StringBuilder("Unable to draw ");
                i.append(drawable);
                i.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                Log.w("DrawableToBitmap", i.toString());
            }
            return null;
        } else if (i2 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i2 = drawable.getIntrinsicHeight();
            }
            Lock a = TransformationUtils.m3055a();
            a.lock();
            bitmapPool = bitmapPool.mo937a(i, i2, Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmapPool);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return bitmapPool;
            } finally {
                a.unlock();
            }
        } else {
            if (Log.isLoggable("DrawableToBitmap", 5) != null) {
                i = new StringBuilder("Unable to draw ");
                i.append(drawable);
                i.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                Log.w("DrawableToBitmap", i.toString());
            }
            return null;
        }
    }
}

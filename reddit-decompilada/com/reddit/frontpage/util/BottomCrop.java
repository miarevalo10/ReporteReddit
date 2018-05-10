package com.reddit.frontpage.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

public class BottomCrop extends BitmapTransformation {
    public final void m37835a(MessageDigest messageDigest) {
    }

    protected final Bitmap m37834a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Bitmap a = bitmapPool.a(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        if (bitmap == null) {
            bitmap = null;
        } else if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
            float height;
            float width;
            Matrix matrix = new Matrix();
            float f = 0.0f;
            if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
                height = ((float) i2) / ((float) bitmap.getHeight());
                width = (((float) i) - (((float) bitmap.getWidth()) * height)) * 0.5f;
            } else {
                height = ((float) i) / ((float) bitmap.getWidth());
                f = ((float) i2) - (((float) bitmap.getHeight()) * height);
                width = 0.0f;
            }
            matrix.setScale(height, height);
            matrix.postTranslate((float) ((int) (width + 0.5f)), ((float) ((int) f)) + 0.5f);
            if (a == null) {
                i = Bitmap.createBitmap(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
            } else {
                i = a;
            }
            TransformationUtils.a(bitmap, i);
            new Canvas(i).drawBitmap(bitmap, matrix, new Paint(6));
            bitmap = i;
        }
        if (!(a == null || a == bitmap)) {
            bitmapPool.a(a);
        }
        return bitmap;
    }
}

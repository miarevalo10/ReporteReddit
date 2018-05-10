package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class TransformationUtils {
    private static final Paint f3549a = new Paint(6);
    private static final Paint f3550b = new Paint(7);
    private static final Paint f3551c;
    private static final Set<String> f3552d;
    private static final Lock f3553e;

    private static final class NoLock implements Lock {
        public final void lock() {
        }

        public final void lockInterruptibly() throws InterruptedException {
        }

        public final boolean tryLock() {
            return true;
        }

        public final boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public final void unlock() {
        }

        NoLock() {
        }

        public final Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }
    }

    public static int m3050a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return SubsamplingScaleImageView.ORIENTATION_270;
            default:
                return 0;
        }
    }

    public static boolean m3060b(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    static {
        Set hashSet = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        f3552d = hashSet;
        f3553e = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new NoLock();
        Paint paint = new Paint(7);
        f3551c = paint;
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
    }

    public static Lock m3055a() {
        return f3553e;
    }

    public static Bitmap m3054a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        float height;
        float width;
        Matrix matrix = new Matrix();
        float f = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            height = ((float) i2) / ((float) bitmap.getHeight());
            width = (((float) i) - (((float) bitmap.getWidth()) * height)) * 0.5f;
        } else {
            height = ((float) i) / ((float) bitmap.getWidth());
            f = (((float) i2) - (((float) bitmap.getHeight()) * height)) * 0.5f;
            width = 0.0f;
        }
        matrix.setScale(height, height);
        matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (f + 0.5f)));
        Bitmap a = bitmapPool.mo937a(i, i2, m3051a(bitmap));
        m3056a(bitmap, a);
        m3057a(bitmap, a, matrix);
        return a;
    }

    public static Bitmap m3059b(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable("TransformationUtils", 2) != null) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable("TransformationUtils", 2) != null) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap a = bitmapPool.mo937a((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), m3051a(bitmap));
        m3056a(bitmap, a);
        if (Log.isLoggable("TransformationUtils", 2)) {
            StringBuilder stringBuilder = new StringBuilder("request: ");
            stringBuilder.append(i);
            stringBuilder.append("x");
            stringBuilder.append(i2);
            Log.v("TransformationUtils", stringBuilder.toString());
            i2 = new StringBuilder("toFit:   ");
            i2.append(bitmap.getWidth());
            i2.append("x");
            i2.append(bitmap.getHeight());
            Log.v("TransformationUtils", i2.toString());
            i2 = new StringBuilder("toReuse: ");
            i2.append(a.getWidth());
            i2.append("x");
            i2.append(a.getHeight());
            Log.v("TransformationUtils", i2.toString());
            i2 = new StringBuilder("minPct:   ");
            i2.append(min);
            Log.v("TransformationUtils", i2.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        m3057a(bitmap, a, matrix);
        return a;
    }

    public static Bitmap m3061c(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return m3059b(bitmapPool, bitmap, i, i2);
        }
        if (Log.isLoggable("TransformationUtils", 2) != null) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    public static void m3056a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static Bitmap m3053a(BitmapPool bitmapPool, Bitmap bitmap, int i) {
        if (!m3060b(i)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
            default:
                break;
        }
        i = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(i);
        Bitmap a = bitmapPool.mo937a(Math.round(i.width()), Math.round(i.height()), m3051a(bitmap));
        matrix.postTranslate(-i.left, -i.top);
        m3057a(bitmap, a, matrix);
        return a;
    }

    public static Bitmap m3062d(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        i = Math.min(i, i2);
        i2 = (float) i;
        float f = i2 / 2.0f;
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float max = Math.max(i2 / width, i2 / height);
        width *= max;
        max *= height;
        height = (i2 - width) / 2.0f;
        i2 = (i2 - max) / 1073741824;
        RectF rectF = new RectF(height, i2, width + height, max + i2);
        Bitmap a = m3052a(bitmapPool, bitmap);
        i = bitmapPool.mo937a(i, i, Config.ARGB_8888);
        i.setHasAlpha(true);
        f3553e.lock();
        try {
            Canvas canvas = new Canvas(i);
            canvas.drawCircle(f, f, f, f3550b);
            canvas.drawBitmap(a, null, rectF, f3551c);
            canvas.setBitmap(null);
            if (a.equals(bitmap) == null) {
                bitmapPool.mo940a(a);
            }
            return i;
        } finally {
            bitmap = f3553e;
            bitmap.unlock();
        }
    }

    private static Bitmap m3052a(BitmapPool bitmapPool, Bitmap bitmap) {
        if (Config.ARGB_8888.equals(bitmap.getConfig())) {
            return bitmap;
        }
        bitmapPool = bitmapPool.mo937a(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        new Canvas(bitmapPool).drawBitmap(bitmap, 0.0f, 0.0f, null);
        return bitmapPool;
    }

    public static Bitmap m3058b(BitmapPool bitmapPool, Bitmap bitmap, int i) {
        Preconditions.m3221a(i > 0, "roundingRadius must be greater than 0.");
        Bitmap a = m3052a(bitmapPool, bitmap);
        Bitmap a2 = bitmapPool.mo937a(a.getWidth(), a.getHeight(), Config.ARGB_8888);
        a2.setHasAlpha(true);
        Shader bitmapShader = new BitmapShader(a, TileMode.CLAMP, TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, (float) a2.getWidth(), (float) a2.getHeight());
        f3553e.lock();
        try {
            Canvas canvas = new Canvas(a2);
            canvas.drawColor(0, Mode.CLEAR);
            i = (float) i;
            canvas.drawRoundRect(rectF, i, i, paint);
            canvas.setBitmap(0);
            if (a.equals(bitmap) == null) {
                bitmapPool.mo940a(a);
            }
            return a2;
        } finally {
            bitmap = f3553e;
            bitmap.unlock();
        }
    }

    private static Config m3051a(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888;
    }

    private static void m3057a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        f3553e.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f3549a);
            canvas.setBitmap(null);
        } finally {
            f3553e.unlock();
        }
    }
}

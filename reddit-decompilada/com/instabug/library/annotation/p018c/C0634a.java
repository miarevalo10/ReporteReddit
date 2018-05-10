package com.instabug.library.annotation.p018c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.facebook.stetho.server.http.HttpStatus;
import java.lang.reflect.Array;

/* compiled from: BitmapUtility */
public class C0634a {
    public static Bitmap m8071a(Bitmap bitmap, Context context) {
        Bitmap bitmap2 = bitmap;
        Bitmap copy = bitmap2.copy(bitmap.getConfig(), true);
        if (VERSION.SDK_INT > 16) {
            RenderScript create = RenderScript.create(context);
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap2, MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            create2.setRadius(18.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createTyped);
            createTyped.copyTo(copy);
            return copy;
        }
        int i;
        Bitmap bitmap3;
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        copy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[Math.max(width, height)];
        int i5 = 92416;
        int[] iArr6 = new int[92416];
        i2 = 0;
        int i6 = 0;
        while (i6 < i5) {
            iArr6[i6] = i6 / 361;
            i6++;
            i5 = 92416;
        }
        int[][] iArr7 = (int[][]) Array.newInstance(int.class, new int[]{37, 3});
        i6 = 0;
        int i7 = i6;
        int i8 = i7;
        while (true) {
            if (i6 >= height) {
                break;
            }
            int i9 = i2;
            int i10 = i9;
            int i11 = i10;
            int i12 = i11;
            int i13 = i12;
            int i14 = i13;
            int i15 = i14;
            int i16 = i15;
            int i17 = -18;
            int i18 = i16;
            for (i = 18; i17 <= i; i = 18) {
                i = iArr[i7 + Math.min(i3, Math.max(i17, i2))];
                int[] iArr8 = iArr7[i17 + 18];
                iArr8[i2] = (i & 16711680) >> 16;
                iArr8[1] = (i & 65280) >> 8;
                iArr8[2] = i & 255;
                i = 19 - Math.abs(i17);
                i18 += iArr8[i2] * i;
                i9 += iArr8[1] * i;
                i10 += iArr8[2] * i;
                if (i17 > 0) {
                    i11 += iArr8[i2];
                    i12 += iArr8[1];
                    i13 += iArr8[2];
                } else {
                    i14 += iArr8[i2];
                    i15 += iArr8[1];
                    i16 += iArr8[2];
                }
                i17++;
            }
            i = i2;
            int i19 = 18;
            while (i < width) {
                iArr2[i7] = iArr6[i18];
                iArr3[i7] = iArr6[i9];
                iArr4[i7] = iArr6[i10];
                i18 -= i14;
                i9 -= i15;
                i10 -= i16;
                int[] iArr9 = iArr7[((i19 - 18) + 37) % 37];
                i14 -= iArr9[i2];
                i15 -= iArr9[1];
                i16 -= iArr9[2];
                if (i6 == 0) {
                    iArr5[i] = Math.min((i + 18) + 1, i3);
                }
                i2 = iArr[i8 + iArr5[i]];
                iArr9[0] = (i2 & 16711680) >> 16;
                iArr9[1] = (i2 & 65280) >> 8;
                iArr9[2] = i2 & 255;
                i11 += iArr9[0];
                i12 += iArr9[1];
                i13 += iArr9[2];
                i18 += i11;
                i9 += i12;
                i10 += i13;
                i19 = (i19 + 1) % 37;
                iArr9 = iArr7[i19 % 37];
                i14 += iArr9[0];
                i15 += iArr9[1];
                i16 += iArr9[2];
                i11 -= iArr9[0];
                i12 -= iArr9[1];
                i13 -= iArr9[2];
                i7++;
                i++;
                i2 = 0;
            }
            i8 += width;
            i6++;
            i2 = 0;
        }
        i = 0;
        while (i < width) {
            int i20;
            bitmap3 = copy;
            i17 = -18 * width;
            i3 = -18;
            i2 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
            for (i20 = 18; i3 <= i20; i20 = 18) {
                i14 = Math.max(0, i17) + i;
                int[] iArr10 = iArr7[i3 + 18];
                iArr10[0] = iArr2[i14];
                iArr10[1] = iArr3[i14];
                iArr10[2] = iArr4[i14];
                i20 = 19 - Math.abs(i3);
                i2 += iArr2[i14] * i20;
                i6 += iArr3[i14] * i20;
                i7 += iArr4[i14] * i20;
                if (i3 > 0) {
                    i8 += iArr10[0];
                    i9 += iArr10[1];
                    i10 += iArr10[2];
                } else {
                    i11 += iArr10[0];
                    i12 += iArr10[1];
                    i13 += iArr10[2];
                }
                if (i3 < i4) {
                    i17 += width;
                }
                i3++;
            }
            i3 = i;
            i20 = 0;
            i17 = 18;
            while (i20 < height) {
                int[] iArr11;
                iArr[i3] = (((-16777216 & iArr[i3]) | (iArr6[i2] << 16)) | (iArr6[i6] << 8)) | iArr6[i7];
                i2 -= i11;
                i6 -= i12;
                i7 -= i13;
                int[] iArr12 = iArr7[((i17 - 18) + 37) % 37];
                i11 -= iArr12[0];
                i12 -= iArr12[1];
                i13 -= iArr12[2];
                if (i == 0) {
                    iArr11 = iArr6;
                    iArr5[i20] = Math.min(i20 + 19, i4) * width;
                } else {
                    iArr11 = iArr6;
                }
                int i21 = iArr5[i20] + i;
                iArr12[0] = iArr2[i21];
                iArr12[1] = iArr3[i21];
                iArr12[2] = iArr4[i21];
                i8 += iArr12[0];
                i9 += iArr12[1];
                i10 += iArr12[2];
                i2 += i8;
                i6 += i9;
                i7 += i10;
                i17 = (i17 + 1) % 37;
                int[] iArr13 = iArr7[i17];
                i11 += iArr13[0];
                i12 += iArr13[1];
                i13 += iArr13[2];
                i8 -= iArr13[0];
                i9 -= iArr13[1];
                i10 -= iArr13[2];
                i3 += width;
                i20++;
                iArr6 = iArr11;
            }
            i++;
            copy = bitmap3;
            iArr6 = iArr6;
        }
        bitmap3 = copy;
        bitmap3.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap3;
    }

    public static Bitmap m8070a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = (width * HttpStatus.HTTP_OK) / 100;
        int i2 = (height * HttpStatus.HTTP_OK) / 100;
        return Bitmap.createBitmap(Bitmap.createScaledBitmap(bitmap, i, i2, true), Math.abs(i - width) / 2, Math.abs(i2 - height) / 2, width, height);
    }

    public static Bitmap m8072b(Bitmap bitmap) {
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        rect.inset(-6, -6);
        Bitmap createBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float centerX = (float) rect.centerX();
        float centerY = (float) rect.centerY();
        float min = Math.min(centerX, centerY);
        canvas.drawCircle(centerX, centerY, min, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, null, rect, paint);
        bitmap = new Paint(1);
        bitmap.setColor(-16777216);
        bitmap.setStyle(Style.STROKE);
        bitmap.setStrokeWidth(2.0f);
        canvas.drawCircle(centerX, centerY, min - 2.0f, bitmap);
        return createBitmap;
    }
}

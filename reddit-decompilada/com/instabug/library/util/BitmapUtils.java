package com.instabug.library.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.widget.ImageView;
import com.instabug.library.Instabug;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.util.C0773a.C0772a;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class BitmapUtils {

    public interface C0771a {
        void mo2581a(Uri uri);

        void mo2582a(Throwable th);
    }

    public static int getInMemoryByteSizeOfBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        if (VERSION.SDK_INT >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (VERSION.SDK_INT >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static int getOnDiskByteSizeOfBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray().length;
    }

    public static Bitmap getBitmapFromFilePath(String str) {
        try {
            return Media.getBitmap(Instabug.getApplicationContext().getContentResolver(), Uri.fromFile(new File(str)));
        } catch (String str2) {
            str2.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("getBitmapFromFilePath returns null because of ");
            stringBuilder.append(str2.getMessage());
            InstabugSDKLogger.m8357e(BitmapUtils.class, stringBuilder.toString());
            return null;
        }
    }

    public static void compressBitmapAndSave(File file) {
        try {
            Options options = new Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            while ((options.outWidth / i) / 2 >= 900 && (options.outHeight / i) / 2 >= 900) {
                i *= 2;
            }
            options = new Options();
            options.inSampleSize = i;
            Bitmap decodeStream = BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            decodeStream.compress(getImageMimeType(file), 100, new FileOutputStream(file));
            decodeStream.recycle();
        } catch (File file2) {
            file2.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("compressBitmapAndSave bitmap doesn't compressed correctly ");
            stringBuilder.append(file2.getMessage());
            InstabugSDKLogger.m8357e(BitmapUtils.class, stringBuilder.toString());
        }
    }

    private static CompressFormat getImageMimeType(File file) {
        if (file.getName().contains("png") != null) {
            return CompressFormat.PNG;
        }
        return CompressFormat.JPEG;
    }

    public static void loadBitmap(String str, ImageView imageView) {
        new C0773a(imageView).execute(new String[]{str});
    }

    public static void loadBitmap(String str, ImageView imageView, float f, float f2) {
        new C0773a(imageView, f, f2).execute(new String[]{str});
    }

    public static void loadBitmap(String str, ImageView imageView, C0772a c0772a) {
        new C0773a(imageView, c0772a).execute(new String[]{str});
    }

    public static int calculateInSampleSize(Options options) {
        int i = options.outHeight;
        options = options.outWidth;
        int i2 = 1;
        if (i > 500 || options > 500) {
            i /= 2;
            options /= 2;
            while (i / i2 >= 500 && options / i2 >= 500) {
                i2 *= 2;
            }
        }
        return i2;
    }

    public static Bitmap decodeSampledBitmapFromLocalPath(String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, float f, float f2) {
        if (bitmap == null) {
            return null;
        }
        if (f == 0.0f && f2 == 0.0f) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) f, (int) f2, Config.ARGB_8888);
        if (bitmap.getWidth() < bitmap.getHeight() && f > f2) {
            return bitmap;
        }
        if (bitmap.getWidth() > bitmap.getHeight() && f < f2) {
            return bitmap;
        }
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        if (bitmap.getWidth() < bitmap.getHeight()) {
            matrix.setScale(f / ((float) bitmap.getWidth()), f2 / ((float) bitmap.getHeight()));
        } else {
            matrix.setScale(f2 / ((float) bitmap.getHeight()), f / ((float) bitmap.getWidth()));
        }
        canvas.drawBitmap(bitmap, matrix, new Paint());
        return createBitmap;
    }

    private static Bitmap resizeBitmap(Bitmap bitmap, int i) {
        int i2;
        float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
        if (width > 1.0f) {
            i2 = (int) (((float) i) / width);
        } else {
            int i3 = (int) (((float) i) * width);
            i2 = i;
            i = i3;
        }
        return Bitmap.createScaledBitmap(bitmap, i, i2, false);
    }

    public static void saveBitmapAsPNG(Bitmap bitmap, int i, File file, String str, C0771a c0771a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(".png");
        File file2 = new File(file, stringBuilder.toString());
        str = new StringBuilder("image path: ");
        str.append(file2.toString());
        InstabugSDKLogger.m8360v(AttachmentsUtility.class, str.toString());
        try {
            file = new BufferedOutputStream(new FileOutputStream(file2));
            bitmap.compress(CompressFormat.PNG, i, file);
            file.close();
            Uri fromFile = Uri.fromFile(file2);
            if (fromFile != null) {
                c0771a.mo2581a(fromFile);
            } else {
                c0771a.mo2582a(new Throwable("Uri equal null"));
            }
        } catch (Throwable e) {
            c0771a.mo2582a(e);
        }
    }

    public static void saveBitmap(Bitmap bitmap, Context context, C0771a c0771a) {
        context = DiskUtils.getInstabugDirectory(context);
        StringBuilder stringBuilder = new StringBuilder("bug_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("_.jpg");
        File file = new File(context, stringBuilder.toString());
        stringBuilder = new StringBuilder("image path: ");
        stringBuilder.append(file.toString());
        InstabugSDKLogger.m8360v(AttachmentsUtility.class, stringBuilder.toString());
        try {
            context = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(CompressFormat.JPEG, 100, context);
            context.close();
            Uri fromFile = Uri.fromFile(file);
            if (fromFile != null) {
                c0771a.mo2581a(fromFile);
            } else {
                c0771a.mo2582a(new Throwable("Uri equal null"));
            }
        } catch (Throwable e) {
            c0771a.mo2582a(e);
        }
    }

    public static void saveBitmap(Bitmap bitmap, Uri uri, Context context) {
        try {
            bitmap.compress(CompressFormat.PNG, 100, context.getContentResolver().openOutputStream(Uri.fromFile(new File(uri.getPath()))));
        } catch (Bitmap bitmap2) {
            InstabugSDKLogger.m8358e(BitmapUtils.class, bitmap2.getMessage(), bitmap2);
        }
    }

    public static void saveBitmap(Bitmap bitmap, File file, C0771a c0771a) {
        StringBuilder stringBuilder = new StringBuilder("frame_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("_.jpg");
        File file2 = new File(file, stringBuilder.toString());
        stringBuilder = new StringBuilder("video frame path: ");
        stringBuilder.append(file2.toString());
        InstabugSDKLogger.m8360v(AttachmentsUtility.class, stringBuilder.toString());
        try {
            int width;
            file = new BufferedOutputStream(new FileOutputStream(file2));
            if (bitmap.getWidth() > bitmap.getHeight()) {
                width = bitmap.getWidth();
            } else {
                width = bitmap.getHeight();
            }
            if (width > 640) {
                resizeBitmap(bitmap, 640).compress(CompressFormat.JPEG, 90, file);
            } else {
                resizeBitmap(bitmap, 320).compress(CompressFormat.JPEG, 90, file);
            }
            file.close();
            Uri fromFile = Uri.fromFile(file2);
            if (fromFile != null) {
                c0771a.mo2581a(fromFile);
            } else {
                c0771a.mo2582a(new Throwable("Uri equal null"));
            }
        } catch (Throwable e) {
            c0771a.mo2582a(e);
        }
    }
}

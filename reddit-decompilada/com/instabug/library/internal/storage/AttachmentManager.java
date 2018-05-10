package com.instabug.library.internal.storage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SuppressFBWarnings({"RV_RETURN_VALUE_IGNORED_BAD_PRACTICE"})
public class AttachmentManager {
    private static final double MAX_FILE_SIZE_IN_MB = 50.0d;

    public interface C0680a {
    }

    public static java.io.File getAttachmentDirectory(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        r1 = r3.getExternalFilesDir(r0);
        if (r1 == 0) goto L_0x001c;
    L_0x0007:
        r1 = android.os.Environment.getExternalStorageState();
        r2 = "mounted";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x001c;
    L_0x0013:
        r0 = r3.getExternalFilesDir(r0);	 Catch:{ NullPointerException -> 0x001c }
        r0 = r0.getAbsolutePath();	 Catch:{ NullPointerException -> 0x001c }
        goto L_0x0020;
    L_0x001c:
        r0 = getInternalStoragePath(r3);
    L_0x0020:
        r3 = new java.io.File;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r0);
        r0 = "/instabug/";
        r1.append(r0);
        r0 = r1.toString();
        r3.<init>(r0);
        r0 = r3.exists();
        if (r0 != 0) goto L_0x004e;
    L_0x003c:
        r3.mkdirs();
        r0 = new java.io.File;
        r1 = ".nomedia";
        r0.<init>(r3, r1);
        r0.createNewFile();	 Catch:{ IOException -> 0x004a }
        goto L_0x004e;
    L_0x004a:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x004e:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.AttachmentManager.getAttachmentDirectory(android.content.Context):java.io.File");
    }

    public static File getNewDirectory(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getAttachmentDirectory(context));
        stringBuilder.append(Operation.DIVISION);
        stringBuilder.append(str);
        stringBuilder.append(Operation.DIVISION);
        File file = new File(stringBuilder.toString());
        if (file.exists() == null) {
            file.mkdirs();
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
        return file;
    }

    public static File getVideoFile(Context context) {
        context = getVideoRecordingVideosDirectory(context);
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.getDefault());
        StringBuilder stringBuilder = new StringBuilder("video-");
        stringBuilder.append(simpleDateFormat.format(new Date()));
        stringBuilder.append(".mp4");
        return new File(context, stringBuilder.toString());
    }

    public static File getVideoRecordingFramesDirectory(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getAttachmentDirectory(context));
        stringBuilder.append("/frames/");
        File file = new File(stringBuilder.toString());
        if (file.exists() == null) {
            file.mkdirs();
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
        return file;
    }

    public static File getVideoRecordingVideosDirectory(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getAttachmentDirectory(context));
        stringBuilder.append("/videos/");
        File file = new File(stringBuilder.toString());
        if (file.exists() == null) {
            file.mkdirs();
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
        return file;
    }

    public static File getAutoScreenRecordingVideosDirectory(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getAttachmentDirectory(context));
        stringBuilder.append("/auto_recording/");
        File file = new File(stringBuilder.toString());
        if (file.exists() == null) {
            file.mkdirs();
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
        return file;
    }

    public static File getAutoScreenRecordingFile(Context context) {
        context = getAutoScreenRecordingVideosDirectory(context);
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.ENGLISH);
        StringBuilder stringBuilder = new StringBuilder("auto-recording-");
        stringBuilder.append(simpleDateFormat.format(new Date()));
        stringBuilder.append(".mp4");
        return new File(context, stringBuilder.toString());
    }

    private static String getInternalStoragePath(Context context) {
        InstabugSDKLogger.m8359i(AttachmentManager.class, "External storage not available, saving file to internal storage.");
        return context.getFilesDir().getAbsolutePath();
    }

    private static void saveBytesToFile(byte[] bArr, File file) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    private static File getAttachmentFile(Context context, String str) {
        context = getAttachmentDirectory(context);
        File file = new File(context, str);
        if (!file.exists()) {
            return file;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(System.currentTimeMillis()));
        stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        stringBuilder.append(str);
        return new File(context, stringBuilder.toString());
    }

    public static Uri getUriFromBytes(Context context, byte[] bArr, String str) {
        context = getAttachmentFile(context, str);
        try {
            saveBytesToFile(bArr, context);
            return Uri.fromFile(context);
        } catch (Context context2) {
            InstabugSDKLogger.m8358e(AttachmentManager.class, context2.getMessage(), context2);
            return null;
        }
    }

    public static void copyFromUriIntoFile(Context context, Uri uri, File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(context.getContentResolver().openInputStream(uri));
        StringBuilder stringBuilder = new StringBuilder("Target file path: ");
        stringBuilder.append(file.getPath());
        InstabugSDKLogger.m8356d(AttachmentManager.class, stringBuilder.toString());
        uri = new BufferedOutputStream(context.getContentResolver().openOutputStream(Uri.fromFile(file)));
        context = new byte[32768];
        while (true) {
            file = bufferedInputStream.read(context);
            if (file > null) {
                uri.write(context, 0, file);
            } else {
                uri.close();
                bufferedInputStream.close();
                return;
            }
        }
    }

    public static String getGalleryImagePath(Activity activity, Uri uri) {
        activity = activity.managedQuery(uri, new String[]{"_data"}, null, null, null);
        if (activity == null) {
            return null;
        }
        uri = activity.getColumnIndexOrThrow("_data");
        activity.moveToFirst();
        return activity.getString(uri);
    }

    public static Uri getNewFileUri(Context context, Uri uri, String str) {
        if (uri == null) {
            return null;
        }
        String toLowerCase = uri.getLastPathSegment().toLowerCase();
        if (str == null || !SettingsManager.getInstance().getExtraAttachmentFiles().containsKey(uri)) {
            str = toLowerCase;
        }
        str = getAttachmentFile(context, str);
        try {
            copyFromUriIntoFile(context, uri, str);
            if (validateFileSize(uri, str) == null) {
                return null;
            }
            return Uri.fromFile(str);
        } catch (Context context2) {
            InstabugSDKLogger.m8358e(AttachmentManager.class, context2.getMessage(), context2);
            return null;
        }
    }

    public static Uri getNewFileUri(Context context, Uri uri) {
        return getNewFileUri(context, uri, null);
    }

    private static boolean validateFileSize(Uri uri, File file) {
        if (SettingsManager.getInstance().getExtraAttachmentFiles().containsKey(uri) != null) {
            uri = file.length();
            double d = ((double) uri) / 1048576.0d;
            StringBuilder stringBuilder = new StringBuilder("External attachment file size is ");
            stringBuilder.append(uri);
            stringBuilder.append(" bytes or ");
            stringBuilder.append(d);
            stringBuilder.append(" MBs");
            InstabugSDKLogger.m8356d(AttachmentManager.class, stringBuilder.toString());
            if (d > 0) {
                InstabugSDKLogger.m8359i(AttachmentManager.class, "Attachment exceeds 50.0 MBs file size limit, ignoring attachment");
                return null;
            }
        }
        return true;
    }

    public static void saveBitmap(android.graphics.Bitmap r3, android.content.Context r4, com.instabug.library.internal.storage.AttachmentManager.C0680a r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = getAttachmentDirectory(r4);
        r5 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r1 = "bug_";
        r0.<init>(r1);
        r1 = java.lang.System.currentTimeMillis();
        r0.append(r1);
        r1 = "_.jpg";
        r0.append(r1);
        r0 = r0.toString();
        r5.<init>(r4, r0);
        r4 = com.instabug.library.internal.storage.AttachmentManager.class;
        r0 = new java.lang.StringBuilder;
        r1 = "image path: ";
        r0.<init>(r1);
        r1 = r5.toString();
        r0.append(r1);
        r0 = r0.toString();
        com.instabug.library.util.InstabugSDKLogger.m8360v(r4, r0);
        r4 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x0059 }
        r0 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0059 }
        r0.<init>(r5);	 Catch:{ IOException -> 0x0059 }
        r4.<init>(r0);	 Catch:{ IOException -> 0x0059 }
        r0 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ IOException -> 0x0059 }
        r1 = 100;	 Catch:{ IOException -> 0x0059 }
        r3.compress(r0, r1, r4);	 Catch:{ IOException -> 0x0059 }
        r4.close();	 Catch:{ IOException -> 0x0059 }
        r3 = android.net.Uri.fromFile(r5);	 Catch:{ IOException -> 0x0059 }
        if (r3 != 0) goto L_0x0058;	 Catch:{ IOException -> 0x0059 }
    L_0x0051:
        r3 = new java.lang.Throwable;	 Catch:{ IOException -> 0x0059 }
        r4 = "Uri equal null";	 Catch:{ IOException -> 0x0059 }
        r3.<init>(r4);	 Catch:{ IOException -> 0x0059 }
    L_0x0058:
        return;
    L_0x0059:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.AttachmentManager.saveBitmap(android.graphics.Bitmap, android.content.Context, com.instabug.library.internal.storage.AttachmentManager$a):void");
    }

    public static void saveBitmap(android.graphics.Bitmap r3, java.io.File r4, com.instabug.library.internal.storage.AttachmentManager.C0680a r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r1 = "frame_";
        r0.<init>(r1);
        r1 = java.lang.System.currentTimeMillis();
        r0.append(r1);
        r1 = "_.jpg";
        r0.append(r1);
        r0 = r0.toString();
        r5.<init>(r4, r0);
        r4 = com.instabug.library.internal.storage.AttachmentManager.class;
        r0 = new java.lang.StringBuilder;
        r1 = "video frame path: ";
        r0.<init>(r1);
        r1 = r5.toString();
        r0.append(r1);
        r0 = r0.toString();
        com.instabug.library.util.InstabugSDKLogger.m8360v(r4, r0);
        r4 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x007c }
        r0 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x007c }
        r0.<init>(r5);	 Catch:{ IOException -> 0x007c }
        r4.<init>(r0);	 Catch:{ IOException -> 0x007c }
        r0 = r3.getWidth();	 Catch:{ IOException -> 0x007c }
        r1 = r3.getHeight();	 Catch:{ IOException -> 0x007c }
        if (r0 <= r1) goto L_0x004c;	 Catch:{ IOException -> 0x007c }
    L_0x0047:
        r0 = r3.getWidth();	 Catch:{ IOException -> 0x007c }
        goto L_0x0050;	 Catch:{ IOException -> 0x007c }
    L_0x004c:
        r0 = r3.getHeight();	 Catch:{ IOException -> 0x007c }
    L_0x0050:
        r1 = 90;	 Catch:{ IOException -> 0x007c }
        r2 = 640; // 0x280 float:8.97E-43 double:3.16E-321;	 Catch:{ IOException -> 0x007c }
        if (r0 <= r2) goto L_0x0060;	 Catch:{ IOException -> 0x007c }
    L_0x0056:
        r3 = resizeBitmap(r3, r2);	 Catch:{ IOException -> 0x007c }
        r0 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ IOException -> 0x007c }
        r3.compress(r0, r1, r4);	 Catch:{ IOException -> 0x007c }
        goto L_0x006b;	 Catch:{ IOException -> 0x007c }
    L_0x0060:
        r0 = 320; // 0x140 float:4.48E-43 double:1.58E-321;	 Catch:{ IOException -> 0x007c }
        r3 = resizeBitmap(r3, r0);	 Catch:{ IOException -> 0x007c }
        r0 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ IOException -> 0x007c }
        r3.compress(r0, r1, r4);	 Catch:{ IOException -> 0x007c }
    L_0x006b:
        r4.close();	 Catch:{ IOException -> 0x007c }
        r3 = android.net.Uri.fromFile(r5);	 Catch:{ IOException -> 0x007c }
        if (r3 != 0) goto L_0x007b;	 Catch:{ IOException -> 0x007c }
    L_0x0074:
        r3 = new java.lang.Throwable;	 Catch:{ IOException -> 0x007c }
        r4 = "Uri equal null";	 Catch:{ IOException -> 0x007c }
        r3.<init>(r4);	 Catch:{ IOException -> 0x007c }
    L_0x007b:
        return;
    L_0x007c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.AttachmentManager.saveBitmap(android.graphics.Bitmap, java.io.File, com.instabug.library.internal.storage.AttachmentManager$a):void");
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
}

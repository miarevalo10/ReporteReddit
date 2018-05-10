package com.instabug.library.internal.storage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.instabug.library.util.InstabugSDKLogger;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@SuppressFBWarnings({"RV_RETURN_VALUE_IGNORED_BAD_PRACTICE"})
public class DiskUtils {
    public static java.io.File getInstabugDirectory(android.content.Context r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
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
        goto L_0x0027;
    L_0x001c:
        r0 = getInternalStoragePath(r3);
        r3 = com.instabug.library.internal.storage.AttachmentsUtility.class;
        r1 = "External storage not available, saving file to internal storage.";
        com.instabug.library.util.InstabugSDKLogger.m8359i(r3, r1);
    L_0x0027:
        r3 = new java.io.File;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r0);
        r0 = "/instabug/";
        r1.append(r0);
        r0 = r1.toString();
        r3.<init>(r0);
        r0 = r3.exists();
        if (r0 != 0) goto L_0x0058;
    L_0x0043:
        r0 = r3.mkdirs();
        if (r0 == 0) goto L_0x0058;
    L_0x0049:
        r0 = new java.io.File;
        r1 = ".nomedia";
        r0.<init>(r3, r1);
        r0.createNewFile();	 Catch:{ IOException -> 0x0054 }
        goto L_0x0058;
    L_0x0054:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0058:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.DiskUtils.getInstabugDirectory(android.content.Context):java.io.File");
    }

    private static String getInternalStoragePath(Context context) {
        return context.getFilesDir().getAbsolutePath();
    }

    public static void saveBitmapOnDisk(Bitmap bitmap, File file) throws IOException {
        if (bitmap != null && file != null) {
            StringBuilder stringBuilder = new StringBuilder("starting save viewHierarchy image, path: ");
            stringBuilder.append(file.getAbsolutePath());
            stringBuilder.append(", time in MS: ");
            stringBuilder.append(System.currentTimeMillis());
            InstabugSDKLogger.m8360v(DiskUtils.class, stringBuilder.toString());
            OutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            StringBuilder stringBuilder2 = new StringBuilder("viewHierarchy image saved, path: ");
            stringBuilder2.append(file.getAbsolutePath());
            stringBuilder2.append(", time in MS: ");
            stringBuilder2.append(System.currentTimeMillis());
            InstabugSDKLogger.m8360v(DiskUtils.class, stringBuilder2.toString());
        }
    }

    public static void cleanDirectory(File file) {
        if (file.exists() && file.isDirectory()) {
            file = file.listFiles();
            if (file != null) {
                for (File file2 : file) {
                    if (file2.delete()) {
                        StringBuilder stringBuilder = new StringBuilder("file deleted successfully, path: ");
                        stringBuilder.append(file2.getPath());
                        stringBuilder.append(", time in MS: ");
                        stringBuilder.append(System.currentTimeMillis());
                        InstabugSDKLogger.m8360v(DiskUtils.class, stringBuilder.toString());
                    }
                }
            }
        }
    }

    public static void copyFromUriIntoFile(Context context, Uri uri, File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(context.getContentResolver().openInputStream(uri));
        StringBuilder stringBuilder = new StringBuilder("Target file path: ");
        stringBuilder.append(file.getPath());
        InstabugSDKLogger.m8356d(AttachmentsUtility.class, stringBuilder.toString());
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

    public static void deleteFile(String str) {
        new File(str).delete();
    }
}

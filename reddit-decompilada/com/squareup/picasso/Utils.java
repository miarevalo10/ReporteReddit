package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ThreadFactory;

public final class Utils {
    static final StringBuilder f23916a = new StringBuilder();

    @TargetApi(11)
    private static class ActivityManagerHoneycomb {
        static int m25809a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    @TargetApi(12)
    private static class BitmapHoneycombMR1 {
        static int m25810a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    private static class OkHttpLoaderCreator {
        static Downloader m25811a(Context context) {
            return new OkHttpDownloader(context);
        }
    }

    private static class PicassoThread extends Thread {
        public PicassoThread(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    static class PicassoThreadFactory implements ThreadFactory {
        PicassoThreadFactory() {
        }

        public Thread newThread(Runnable runnable) {
            return new PicassoThread(runnable);
        }
    }

    static int m25813a(Bitmap bitmap) {
        int a;
        if (VERSION.SDK_INT >= 12) {
            a = BitmapHoneycombMR1.m25810a(bitmap);
        } else {
            a = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (a >= 0) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder("Negative size: ");
        stringBuilder.append(bitmap);
        throw new IllegalStateException(stringBuilder.toString());
    }

    static <T> T m25818a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static String m25819a(BitmapHunter bitmapHunter) {
        return m25820a(bitmapHunter, "");
    }

    static String m25820a(BitmapHunter bitmapHunter, String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        str = bitmapHunter.f23744k;
        if (str != null) {
            stringBuilder.append(str.f23714b.logId());
        }
        bitmapHunter = bitmapHunter.f23745l;
        if (bitmapHunter != null) {
            int size = bitmapHunter.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || str != null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((Action) bitmapHunter.get(i)).f23714b.logId());
            }
        }
        return stringBuilder.toString();
    }

    static void m25825a(String str, String str2, String str3) {
        m25826a(str, str2, str3, "");
    }

    static void m25826a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    public static String m25821a(Request request) {
        StringBuilder stringBuilder = f23916a;
        if (request.stableKey != null) {
            stringBuilder.ensureCapacity(request.stableKey.length() + 50);
            stringBuilder.append(request.stableKey);
        } else if (request.uri != null) {
            String uri = request.uri.toString();
            stringBuilder.ensureCapacity(uri.length() + 50);
            stringBuilder.append(uri);
        } else {
            stringBuilder.ensureCapacity(50);
            stringBuilder.append(request.resourceId);
        }
        stringBuilder.append('\n');
        if (request.rotationDegrees != 0.0f) {
            stringBuilder.append("rotation:");
            stringBuilder.append(request.rotationDegrees);
            if (request.hasRotationPivot) {
                stringBuilder.append('@');
                stringBuilder.append(request.rotationPivotX);
                stringBuilder.append('x');
                stringBuilder.append(request.rotationPivotY);
            }
            stringBuilder.append('\n');
        }
        if (request.hasSize()) {
            stringBuilder.append("resize:");
            stringBuilder.append(request.targetWidth);
            stringBuilder.append('x');
            stringBuilder.append(request.targetHeight);
            stringBuilder.append('\n');
        }
        if (request.centerCrop) {
            stringBuilder.append("centerCrop\n");
        } else if (request.centerInside) {
            stringBuilder.append("centerInside\n");
        }
        if (request.transformations != null) {
            int size = request.transformations.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(((Transformation) request.transformations.get(i)).m25807b());
                stringBuilder.append('\n');
            }
        }
        request = stringBuilder.toString();
        f23916a.setLength(0);
        return request;
    }

    static void m25824a(java.io.InputStream r0) {
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
        if (r0 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0.close();	 Catch:{ IOException -> 0x0007 }
        return;
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Utils.a(java.io.InputStream):void");
    }

    static boolean m25827a(java.lang.String r4) {
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
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = " ";
        r2 = 2;
        r4 = r4.split(r1, r2);
        r1 = "CACHE";
        r2 = r4[r0];
        r1 = r1.equals(r2);
        r2 = 1;
        if (r1 == 0) goto L_0x0017;
    L_0x0016:
        return r2;
    L_0x0017:
        r1 = r4.length;
        if (r1 != r2) goto L_0x001b;
    L_0x001a:
        return r0;
    L_0x001b:
        r1 = "CONDITIONAL_CACHE";	 Catch:{ NumberFormatException -> 0x0031 }
        r3 = r4[r0];	 Catch:{ NumberFormatException -> 0x0031 }
        r1 = r1.equals(r3);	 Catch:{ NumberFormatException -> 0x0031 }
        if (r1 == 0) goto L_0x0030;	 Catch:{ NumberFormatException -> 0x0031 }
    L_0x0025:
        r4 = r4[r2];	 Catch:{ NumberFormatException -> 0x0031 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x0031 }
        r1 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r4 != r1) goto L_0x0030;
    L_0x002f:
        return r2;
    L_0x0030:
        return r0;
    L_0x0031:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Utils.a(java.lang.String):boolean");
    }

    static com.squareup.picasso.Downloader m25816a(android.content.Context r1) {
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
        r0 = "com.squareup.okhttp.OkHttpClient";	 Catch:{ ClassNotFoundException -> 0x000a }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x000a }
        r0 = com.squareup.picasso.Utils.OkHttpLoaderCreator.m25811a(r1);	 Catch:{ ClassNotFoundException -> 0x000a }
        return r0;
    L_0x000a:
        r0 = new com.squareup.picasso.UrlConnectionDownloader;
        r0.<init>(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Utils.a(android.content.Context):com.squareup.picasso.Downloader");
    }

    static File m25828b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (file.exists() == null) {
            file.mkdirs();
        }
        return file;
    }

    static long m25814a(java.io.File r7) {
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
        r0 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r2 = new android.os.StatFs;	 Catch:{ IllegalArgumentException -> 0x001c }
        r7 = r7.getAbsolutePath();	 Catch:{ IllegalArgumentException -> 0x001c }
        r2.<init>(r7);	 Catch:{ IllegalArgumentException -> 0x001c }
        r7 = r2.getBlockCount();	 Catch:{ IllegalArgumentException -> 0x001c }
        r3 = (long) r7;	 Catch:{ IllegalArgumentException -> 0x001c }
        r7 = r2.getBlockSize();	 Catch:{ IllegalArgumentException -> 0x001c }
        r5 = (long) r7;	 Catch:{ IllegalArgumentException -> 0x001c }
        r3 = r3 * r5;	 Catch:{ IllegalArgumentException -> 0x001c }
        r5 = 50;	 Catch:{ IllegalArgumentException -> 0x001c }
        r2 = r3 / r5;	 Catch:{ IllegalArgumentException -> 0x001c }
        goto L_0x001d;
    L_0x001c:
        r2 = r0;
    L_0x001d:
        r4 = 52428800; // 0x3200000 float:4.7019774E-37 double:2.5903269E-316;
        r2 = java.lang.Math.min(r2, r4);
        r0 = java.lang.Math.max(r2, r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Utils.a(java.io.File):long");
    }

    static boolean m25833d(android.content.Context r2) {
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
        r2 = r2.getContentResolver();
        r0 = 0;
        r1 = "airplane_mode_on";	 Catch:{ NullPointerException -> 0x0010 }
        r2 = android.provider.Settings.System.getInt(r2, r1, r0);	 Catch:{ NullPointerException -> 0x0010 }
        if (r2 == 0) goto L_0x000f;
    L_0x000d:
        r2 = 1;
        return r2;
    L_0x000f:
        return r0;
    L_0x0010:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Utils.d(android.content.Context):boolean");
    }

    static <T> T m25817a(Context context, String str) {
        return context.getSystemService(str);
    }

    static boolean m25829b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == null ? true : null;
    }

    static byte[] m25830b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    static boolean m25832c(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        if (inputStream.read(bArr, 0, 12) != 12 || "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) == null || "WEBP".equals(new String(bArr, 8, 4, "US-ASCII")) == null) {
            return false;
        }
        return true;
    }

    static int m25812a(android.content.res.Resources r6, com.squareup.picasso.Request r7) throws java.io.FileNotFoundException {
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
        r0 = r7.resourceId;
        if (r0 != 0) goto L_0x00a4;
    L_0x0004:
        r0 = r7.uri;
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        goto L_0x00a4;
    L_0x000a:
        r0 = r7.uri;
        r0 = r0.getAuthority();
        if (r0 != 0) goto L_0x0028;
    L_0x0012:
        r6 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r1 = "No package provided: ";
        r0.<init>(r1);
        r7 = r7.uri;
        r0.append(r7);
        r7 = r0.toString();
        r6.<init>(r7);
        throw r6;
    L_0x0028:
        r1 = r7.uri;
        r1 = r1.getPathSegments();
        if (r1 == 0) goto L_0x008e;
    L_0x0030:
        r2 = r1.isEmpty();
        if (r2 == 0) goto L_0x0037;
    L_0x0036:
        goto L_0x008e;
    L_0x0037:
        r2 = r1.size();
        r3 = 0;
        r4 = 1;
        if (r2 != r4) goto L_0x0060;
    L_0x003f:
        r6 = r1.get(r3);	 Catch:{ NumberFormatException -> 0x004a }
        r6 = (java.lang.String) r6;	 Catch:{ NumberFormatException -> 0x004a }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ NumberFormatException -> 0x004a }
        goto L_0x0077;
    L_0x004a:
        r6 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r1 = "Last path segment is not a resource ID: ";
        r0.<init>(r1);
        r7 = r7.uri;
        r0.append(r7);
        r7 = r0.toString();
        r6.<init>(r7);
        throw r6;
    L_0x0060:
        r2 = r1.size();
        r5 = 2;
        if (r2 != r5) goto L_0x0078;
    L_0x0067:
        r7 = r1.get(r3);
        r7 = (java.lang.String) r7;
        r1 = r1.get(r4);
        r1 = (java.lang.String) r1;
        r6 = r6.getIdentifier(r1, r7, r0);
    L_0x0077:
        return r6;
    L_0x0078:
        r6 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r1 = "More than two path segments: ";
        r0.<init>(r1);
        r7 = r7.uri;
        r0.append(r7);
        r7 = r0.toString();
        r6.<init>(r7);
        throw r6;
    L_0x008e:
        r6 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r1 = "No path segments: ";
        r0.<init>(r1);
        r7 = r7.uri;
        r0.append(r7);
        r7 = r0.toString();
        r6.<init>(r7);
        throw r6;
    L_0x00a4:
        r6 = r7.resourceId;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Utils.a(android.content.res.Resources, com.squareup.picasso.Request):int");
    }

    static android.content.res.Resources m25815a(android.content.Context r2, com.squareup.picasso.Request r3) throws java.io.FileNotFoundException {
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
        r0 = r3.resourceId;
        if (r0 != 0) goto L_0x0046;
    L_0x0004:
        r0 = r3.uri;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        goto L_0x0046;
    L_0x0009:
        r0 = r3.uri;
        r0 = r0.getAuthority();
        if (r0 != 0) goto L_0x0027;
    L_0x0011:
        r2 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r1 = "No package provided: ";
        r0.<init>(r1);
        r3 = r3.uri;
        r0.append(r3);
        r3 = r0.toString();
        r2.<init>(r3);
        throw r2;
    L_0x0027:
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0030 }
        r2 = r2.getResourcesForApplication(r0);	 Catch:{ NameNotFoundException -> 0x0030 }
        return r2;
    L_0x0030:
        r2 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r1 = "Unable to obtain resources for package: ";
        r0.<init>(r1);
        r3 = r3.uri;
        r0.append(r3);
        r3 = r0.toString();
        r2.<init>(r3);
        throw r2;
    L_0x0046:
        r2 = r2.getResources();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Utils.a(android.content.Context, com.squareup.picasso.Request):android.content.res.Resources");
    }

    static void m25823a(Looper looper) {
        Handler c20591 = new Handler(looper) {
            public final void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000);
            }
        };
        c20591.sendMessageDelayed(c20591.obtainMessage(), 1000);
    }

    public static void m25822a() {
        if ((Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : null) == null) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static int m25831c(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        context = (context.getApplicationInfo().flags & 1048576) != null ? true : null;
        int memoryClass = activityManager.getMemoryClass();
        if (context != null && VERSION.SDK_INT >= 11) {
            memoryClass = ActivityManagerHoneycomb.m25809a(activityManager);
        }
        return (1048576 * memoryClass) / 7;
    }
}

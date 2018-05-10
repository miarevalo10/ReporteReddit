package com.davemorrissey.labs.subscaleview.decoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;

public class SkiaImageRegionDecoder implements ImageRegionDecoder {
    private BitmapRegionDecoder f12693a;
    private final Object f12694b = new Object();

    public final android.graphics.Point mo1110a(android.content.Context r8, android.net.Uri r9) throws java.lang.Exception {
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
        r7 = this;
        r0 = r9.toString();
        r1 = "android.resource://";
        r1 = r0.startsWith(r1);
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x0078;
    L_0x000e:
        r0 = r9.getAuthority();
        r1 = r8.getPackageName();
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0021;
    L_0x001c:
        r1 = r8.getResources();
        goto L_0x0029;
    L_0x0021:
        r1 = r8.getPackageManager();
        r1 = r1.getResourcesForApplication(r0);
    L_0x0029:
        r9 = r9.getPathSegments();
        r4 = r9.size();
        r5 = 2;
        if (r4 != r5) goto L_0x004f;
    L_0x0034:
        r5 = r9.get(r3);
        r5 = (java.lang.String) r5;
        r6 = "drawable";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x004f;
    L_0x0042:
        r9 = r9.get(r2);
        r9 = (java.lang.String) r9;
        r2 = "drawable";
        r9 = r1.getIdentifier(r9, r2, r0);
        goto L_0x0069;
    L_0x004f:
        if (r4 != r2) goto L_0x0068;
    L_0x0051:
        r0 = r9.get(r3);
        r0 = (java.lang.CharSequence) r0;
        r0 = android.text.TextUtils.isDigitsOnly(r0);
        if (r0 == 0) goto L_0x0068;
    L_0x005d:
        r9 = r9.get(r3);	 Catch:{ NumberFormatException -> 0x0068 }
        r9 = (java.lang.String) r9;	 Catch:{ NumberFormatException -> 0x0068 }
        r9 = java.lang.Integer.parseInt(r9);	 Catch:{ NumberFormatException -> 0x0068 }
        goto L_0x0069;
    L_0x0068:
        r9 = r3;
    L_0x0069:
        r8 = r8.getResources();
        r8 = r8.openRawResource(r9);
        r8 = android.graphics.BitmapRegionDecoder.newInstance(r8, r3);
        r7.f12693a = r8;
        goto L_0x00bd;
    L_0x0078:
        r1 = "file:///android_asset/";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x0095;
    L_0x0080:
        r9 = 22;
        r9 = r0.substring(r9);
        r8 = r8.getAssets();
        r8 = r8.open(r9, r2);
        r8 = android.graphics.BitmapRegionDecoder.newInstance(r8, r3);
        r7.f12693a = r8;
        goto L_0x00bd;
    L_0x0095:
        r1 = "file://";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x00a9;
    L_0x009d:
        r8 = 7;
        r8 = r0.substring(r8);
        r8 = android.graphics.BitmapRegionDecoder.newInstance(r8, r3);
        r7.f12693a = r8;
        goto L_0x00bd;
    L_0x00a9:
        r0 = 0;
        r8 = r8.getContentResolver();	 Catch:{ all -> 0x00d1 }
        r8 = r8.openInputStream(r9);	 Catch:{ all -> 0x00d1 }
        r9 = android.graphics.BitmapRegionDecoder.newInstance(r8, r3);	 Catch:{ all -> 0x00cf }
        r7.f12693a = r9;	 Catch:{ all -> 0x00cf }
        if (r8 == 0) goto L_0x00bd;
    L_0x00ba:
        r8.close();	 Catch:{ Exception -> 0x00bd }
    L_0x00bd:
        r8 = new android.graphics.Point;
        r9 = r7.f12693a;
        r9 = r9.getWidth();
        r0 = r7.f12693a;
        r0 = r0.getHeight();
        r8.<init>(r9, r0);
        return r8;
    L_0x00cf:
        r9 = move-exception;
        goto L_0x00d3;
    L_0x00d1:
        r9 = move-exception;
        r8 = r0;
    L_0x00d3:
        if (r8 == 0) goto L_0x00d8;
    L_0x00d5:
        r8.close();	 Catch:{ Exception -> 0x00d8 }
    L_0x00d8:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder.a(android.content.Context, android.net.Uri):android.graphics.Point");
    }

    public final Bitmap mo1109a(Rect rect, int i) {
        synchronized (this.f12694b) {
            Options options = new Options();
            options.inSampleSize = i;
            options.inPreferredConfig = Config.RGB_565;
            rect = this.f12693a.decodeRegion(rect, options);
            if (rect == null) {
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
        }
        return rect;
    }

    public final boolean mo1111a() {
        return (this.f12693a == null || this.f12693a.isRecycled()) ? false : true;
    }

    public final void mo1112b() {
        this.f12693a.recycle();
    }
}
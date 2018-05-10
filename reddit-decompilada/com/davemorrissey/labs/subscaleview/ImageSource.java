package com.davemorrissey.labs.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public final class ImageSource {
    final Uri f3778a;
    final Bitmap f3779b;
    final Integer f3780c;
    boolean f3781d;
    int f3782e;
    int f3783f;
    Rect f3784g;
    boolean f3785h;

    private ImageSource(Bitmap bitmap) {
        this.f3779b = bitmap;
        this.f3778a = null;
        this.f3780c = null;
        this.f3781d = false;
        this.f3782e = bitmap.getWidth();
        this.f3783f = bitmap.getHeight();
        this.f3785h = false;
    }

    private ImageSource(android.net.Uri r4) {
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
        r3 = this;
        r3.<init>();
        r0 = r4.toString();
        r1 = "file:///";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x002a;
    L_0x000f:
        r1 = new java.io.File;
        r2 = 7;
        r2 = r0.substring(r2);
        r1.<init>(r2);
        r1 = r1.exists();
        if (r1 != 0) goto L_0x002a;
    L_0x001f:
        r1 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x002a }
        r0 = java.net.URLDecoder.decode(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x002a }
        r0 = android.net.Uri.parse(r0);	 Catch:{ UnsupportedEncodingException -> 0x002a }
        r4 = r0;
    L_0x002a:
        r0 = 0;
        r3.f3779b = r0;
        r3.f3778a = r4;
        r3.f3780c = r0;
        r4 = 1;
        r3.f3781d = r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.ImageSource.<init>(android.net.Uri):void");
    }

    private ImageSource(int i) {
        this.f3779b = null;
        this.f3778a = null;
        this.f3780c = Integer.valueOf(i);
        this.f3781d = true;
    }

    public static ImageSource m3364a(int i) {
        return new ImageSource(i);
    }

    public static ImageSource m3366a(String str) {
        if (str == null) {
            throw new NullPointerException("Asset name must not be null");
        }
        StringBuilder stringBuilder = new StringBuilder("file:///android_asset/");
        stringBuilder.append(str);
        return m3367b(stringBuilder.toString());
    }

    public static ImageSource m3367b(String str) {
        if (str == null) {
            throw new NullPointerException("Uri must not be null");
        }
        if (!str.contains("://")) {
            if (str.startsWith(Operation.DIVISION)) {
                str = str.substring(1);
            }
            StringBuilder stringBuilder = new StringBuilder("file:///");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        return new ImageSource(Uri.parse(str));
    }

    public static ImageSource m3365a(Bitmap bitmap) {
        if (bitmap != null) {
            return new ImageSource(bitmap);
        }
        throw new NullPointerException("Bitmap must not be null");
    }

    public final ImageSource m3368a() {
        this.f3781d = true;
        return this;
    }
}

package com.instabug.bug.screenshot.viewhierarchy.utilities;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.os.Build.VERSION;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.instabug.bug.screenshot.viewhierarchy.C0482b;
import com.instabug.library.instacapture.screenshot.ScreenshotTaker;
import com.instabug.library.util.InstabugSDKLogger;
import rx.Observable;
import rx.functions.Func0;

public class BitmapUtils {
    public static Observable<C0482b> captureViewHierarchyRx(final C0482b c0482b) {
        return Observable.a(new Func0<Observable<C0482b>>() {
            public final /* synthetic */ Object call() {
                return Observable.b(BitmapUtils.captureViewWithoutChildren(c0482b));
            }
        });
    }

    private static C0482b captureViewWithoutChildren(C0482b c0482b) {
        Bitmap captureView;
        StringBuilder stringBuilder = new StringBuilder("staring capture viewHierarchy: ");
        stringBuilder.append(c0482b.f9118a);
        InstabugSDKLogger.m8360v(BitmapUtils.class, stringBuilder.toString());
        if (c0482b.f9131n instanceof ViewGroup) {
            boolean[] hideViewChildren = hideViewChildren((ViewGroup) c0482b.f9131n);
            captureView = captureView(c0482b);
            showViewChildren((ViewGroup) c0482b.f9131n, hideViewChildren);
        } else {
            captureView = captureView(c0482b);
        }
        c0482b.f9127j = captureView;
        stringBuilder = new StringBuilder("capture viewHierarchy done successfully: ");
        stringBuilder.append(c0482b.f9118a);
        InstabugSDKLogger.m8360v(BitmapUtils.class, stringBuilder.toString());
        return c0482b;
    }

    private static boolean[] hideViewChildren(ViewGroup viewGroup) {
        boolean[] zArr = new boolean[viewGroup.getChildCount()];
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i).getVisibility() == 0) {
                zArr[i] = true;
                viewGroup.getChildAt(i).setVisibility(4);
            } else {
                zArr[i] = false;
            }
        }
        return zArr;
    }

    private static void showViewChildren(ViewGroup viewGroup, boolean[] zArr) {
        for (int i = 0; i < zArr.length; i++) {
            if (zArr[i]) {
                viewGroup.getChildAt(i).setVisibility(0);
            }
        }
    }

    private static Bitmap captureView(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.draw(canvas);
        int[] iArr = new int[]{0, 0};
        if (VERSION.SDK_INT >= 14 && (view instanceof TextureView)) {
            ScreenshotTaker.drawTextureView((TextureView) view, iArr, canvas);
        }
        if (view instanceof GLSurfaceView) {
            ScreenshotTaker.drawGLSurfaceView((GLSurfaceView) view, iArr, canvas);
        }
        if (VERSION.SDK_INT >= 11 && (view instanceof WebView)) {
            ScreenshotTaker.drawWebView((WebView) view, canvas);
        }
        return createBitmap;
    }

    private static android.graphics.Bitmap cropImageToVisiblyArea(android.graphics.Bitmap r4, android.graphics.Rect r5, android.graphics.Rect r6) throws java.util.IllegalFormatCodePointException {
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
        if (r4 == 0) goto L_0x0089;
    L_0x0003:
        if (r5 == 0) goto L_0x0089;
    L_0x0005:
        r1 = r5.width();
        if (r1 <= 0) goto L_0x0089;
    L_0x000b:
        r1 = r5.height();
        if (r1 <= 0) goto L_0x0089;
    L_0x0011:
        r1 = com.instabug.bug.screenshot.viewhierarchy.utilities.BitmapUtils.class;
        r2 = new java.lang.StringBuilder;
        r3 = "visible rect: ";
        r2.<init>(r3);
        r3 = r5.toString();
        r2.append(r3);
        r3 = ", original rect";
        r2.append(r3);
        r3 = r6.toString();
        r2.append(r3);
        r2 = r2.toString();
        com.instabug.library.util.InstabugSDKLogger.m8360v(r1, r2);
        r1 = com.instabug.bug.screenshot.viewhierarchy.utilities.BitmapUtils.class;
        r2 = new java.lang.StringBuilder;
        r3 = "bitmap width: ";
        r2.<init>(r3);
        r3 = r4.getWidth();
        r2.append(r3);
        r3 = ", bitmap height: ";
        r2.append(r3);
        r3 = r4.getHeight();
        r2.append(r3);
        r2 = r2.toString();
        com.instabug.library.util.InstabugSDKLogger.m8360v(r1, r2);
        r1 = r5.left;
        r2 = r6.left;
        r1 = r1 - r2;
        r2 = r5.top;
        r6 = r6.top;
        r2 = r2 - r6;
        if (r1 < 0) goto L_0x0088;
    L_0x0063:
        if (r2 < 0) goto L_0x0088;
    L_0x0065:
        r6 = r5.width();
        r3 = r4.getWidth();
        if (r6 > r3) goto L_0x0088;
    L_0x006f:
        r6 = r5.height();
        r3 = r4.getHeight();
        if (r6 > r3) goto L_0x0088;
    L_0x0079:
        r6 = r5.width();	 Catch:{ OutOfMemoryError -> 0x0086 }
        r5 = r5.height();	 Catch:{ OutOfMemoryError -> 0x0086 }
        r4 = android.graphics.Bitmap.createBitmap(r4, r1, r2, r6, r5);	 Catch:{ OutOfMemoryError -> 0x0086 }
        goto L_0x0087;
    L_0x0086:
        r4 = r0;
    L_0x0087:
        return r4;
    L_0x0088:
        return r0;
    L_0x0089:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.screenshot.viewhierarchy.utilities.BitmapUtils.cropImageToVisiblyArea(android.graphics.Bitmap, android.graphics.Rect, android.graphics.Rect):android.graphics.Bitmap");
    }

    private static Bitmap scaleBitmap(Bitmap bitmap, int i) {
        if (bitmap == null || bitmap.getWidth() <= i || bitmap.getHeight() <= i) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("scale: ");
        stringBuilder.append(i);
        stringBuilder.append(", bitmap width: ");
        stringBuilder.append(bitmap.getWidth());
        stringBuilder.append(", bitmap height: ");
        stringBuilder.append(bitmap.getHeight());
        InstabugSDKLogger.m8360v(BitmapUtils.class, stringBuilder.toString());
        return Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / i, bitmap.getHeight() / i, 0);
    }

    private static Bitmap captureView(C0482b c0482b) {
        return (c0482b.f9131n == null || c0482b.f9130m == null || c0482b.f9131n.getHeight() <= 0 || c0482b.f9131n.getWidth() <= 0 || c0482b.f9130m.height() <= 0 || c0482b.f9130m.width() <= 0) ? null : scaleBitmap(cropImageToVisiblyArea(captureView(c0482b.f9131n), c0482b.f9130m, c0482b.f9129l), c0482b.f9132o);
    }
}

package com.instabug.library.instacapture.screenshot;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.opengl.GLSurfaceView;
import android.os.Build.VERSION;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.instabug.library.instacapture.p023c.C0668a;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public final class ScreenshotTaker {
    private ScreenshotTaker() {
    }

    public static android.graphics.Bitmap getScreenshotBitmap(android.app.Activity r6, int[] r7) {
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
        if (r6 != 0) goto L_0x000a;
    L_0x0002:
        r6 = new java.lang.IllegalArgumentException;
        r7 = "Parameter activity cannot be null.";
        r6.<init>(r7);
        throw r6;
    L_0x000a:
        r0 = r6.getWindow();
        r0 = r0.getDecorView();
        r1 = com.instabug.library.instacapture.screenshot.FieldHelper.getRootViews(r6, r7);
        r2 = new java.lang.StringBuilder;
        r3 = "viewRoots count: ";
        r2.<init>(r3);
        r3 = r1.size();
        r2.append(r3);
        r2 = r2.toString();
        com.instabug.library.instacapture.p023c.C0668a.m8178a(r2);
        r2 = r0.getWidth();	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        r3 = r0.getHeight();	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        r2 = r2 * r3;	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        r2 = r2 * 4;	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        r2 = (long) r2;	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        r4 = com.instabug.library.instacapture.p023c.C0669b.m8181a(r6);	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        if (r6 >= 0) goto L_0x004e;	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
    L_0x003f:
        r6 = r0.getWidth();	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        r0 = r0.getHeight();	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        r2 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        r6 = android.graphics.Bitmap.createBitmap(r6, r0, r2);	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        goto L_0x005c;	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
    L_0x004e:
        r6 = r0.getWidth();	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        r0 = r0.getHeight();	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        r2 = android.graphics.Bitmap.Config.RGB_565;	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
        r6 = android.graphics.Bitmap.createBitmap(r6, r0, r2);	 Catch:{ IllegalArgumentException -> 0x0060, IllegalArgumentException -> 0x0060 }
    L_0x005c:
        drawRootsToBitmap(r1, r6, r7);
        return r6;
    L_0x0060:
        r6 = 0;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.instacapture.screenshot.ScreenshotTaker.getScreenshotBitmap(android.app.Activity, int[]):android.graphics.Bitmap");
    }

    private static void drawRootsToBitmap(List<RootViewInfo> list, Bitmap bitmap, int[] iArr) {
        for (RootViewInfo drawRootToBitmap : list) {
            drawRootToBitmap(drawRootToBitmap, bitmap, iArr);
        }
    }

    private static void drawRootToBitmap(RootViewInfo rootViewInfo, Bitmap bitmap, int[] iArr) {
        int i = 0;
        if ((rootViewInfo.getLayoutParams().flags & 2) == 2) {
            new Canvas(bitmap).drawARGB((int) (255.0f * rootViewInfo.getLayoutParams().dimAmount), 0, 0, 0);
        }
        Canvas canvas = new Canvas(bitmap);
        canvas.translate((float) rootViewInfo.getLeft(), (float) rootViewInfo.getTop());
        bitmap = null;
        if (iArr != null) {
            bitmap = new int[iArr.length];
        }
        if (iArr != null) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                View findViewById = rootViewInfo.getView().findViewById(iArr[i2]);
                if (findViewById != null) {
                    bitmap[i2] = findViewById.getVisibility();
                    findViewById.setVisibility(4);
                }
            }
        }
        rootViewInfo.getView().draw(canvas);
        drawUnDrawableViews(rootViewInfo.getView(), canvas);
        if (iArr != null) {
            while (i < iArr.length) {
                View findViewById2 = rootViewInfo.getView().findViewById(iArr[i]);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(bitmap[i]);
                }
                i++;
            }
        }
    }

    private static ArrayList<View> drawUnDrawableViews(View view, Canvas canvas) {
        if (view instanceof ViewGroup) {
            ArrayList<View> arrayList = new ArrayList();
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                Collection arrayList2 = new ArrayList();
                arrayList2.add(view);
                arrayList2.addAll(drawUnDrawableViews(childAt, canvas));
                int[] iArr = new int[2];
                childAt.getLocationOnScreen(iArr);
                if (VERSION.SDK_INT >= 14 && (childAt instanceof TextureView)) {
                    drawTextureView((TextureView) childAt, iArr, canvas);
                }
                if (childAt instanceof GLSurfaceView) {
                    drawGLSurfaceView((GLSurfaceView) childAt, iArr, canvas);
                }
                if (VERSION.SDK_INT >= 11 && (childAt instanceof WebView)) {
                    drawWebView((WebView) childAt, canvas);
                }
                arrayList.addAll(arrayList2);
            }
            return arrayList;
        }
        canvas = new ArrayList();
        canvas.add(view);
        return canvas;
    }

    public static void drawGLSurfaceView(GLSurfaceView gLSurfaceView, int[] iArr, Canvas canvas) {
        C0668a.m8178a((CharSequence) "Drawing GLSurfaceView");
        if (gLSurfaceView.getWindowToken() != null) {
            final int width = gLSurfaceView.getWidth();
            final int height = gLSurfaceView.getHeight();
            int[] iArr2 = new int[((0 + height) * width)];
            final IntBuffer wrap = IntBuffer.wrap(iArr2);
            wrap.position(0);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            gLSurfaceView.queueEvent(new Runnable() {
                public final void run() {
                    EGL10 egl10 = (EGL10) EGLContext.getEGL();
                    egl10.eglWaitGL();
                    GL10 gl10 = (GL10) egl10.eglGetCurrentContext().getGL();
                    gl10.glFinish();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    gl10.glReadPixels(0, 0, width, height + 0, 6408, 5121, wrap);
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (GLSurfaceView gLSurfaceView2) {
                gLSurfaceView2.printStackTrace();
            }
            gLSurfaceView2 = new int[(width * height)];
            int i = 0;
            int i2 = i;
            while (i < height) {
                for (int i3 = 0; i3 < width; i3++) {
                    int i4 = iArr2[(i * width) + i3];
                    gLSurfaceView2[(((height - i2) - 1) * width) + i3] = ((i4 & -16711936) | ((i4 << 16) & 16711680)) | ((i4 >> 16) & 255);
                }
                i++;
                i2++;
            }
            gLSurfaceView2 = Bitmap.createBitmap(gLSurfaceView2, width, height, Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(Mode.DST_ATOP));
            canvas.drawBitmap(gLSurfaceView2, (float) iArr[0], (float) iArr[1], paint);
            gLSurfaceView2.recycle();
        }
    }

    @TargetApi(14)
    public static void drawTextureView(TextureView textureView, int[] iArr, Canvas canvas) {
        C0668a.m8178a((CharSequence) "Drawing TextureView");
        textureView = textureView.getBitmap();
        if (textureView != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(Mode.DST_ATOP));
            canvas.drawBitmap(textureView, (float) iArr[0], (float) iArr[1], paint);
            textureView.recycle();
        }
    }

    @TargetApi(11)
    public static void drawWebView(WebView webView, Canvas canvas) {
        int layerType = webView.getLayerType();
        if (layerType == 2) {
            webView.setLayerType(0, null);
            webView.setDrawingCacheEnabled(true);
            webView.buildDrawingCache(true);
            Bitmap drawingCache = webView.getDrawingCache();
            if (drawingCache != null) {
                Paint paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(Mode.DST_ATOP));
                int[] iArr = new int[2];
                webView.getLocationOnScreen(iArr);
                canvas.drawBitmap(drawingCache, (float) iArr[0], (float) iArr[1], paint);
                drawingCache.recycle();
            }
            webView.setDrawingCacheEnabled(false);
            webView.setLayerType(layerType, null);
        }
    }
}

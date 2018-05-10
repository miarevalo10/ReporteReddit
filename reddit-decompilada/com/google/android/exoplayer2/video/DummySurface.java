package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

@TargetApi(17)
public final class DummySurface extends Surface {
    private static boolean f5311b;
    private static boolean f5312c;
    public final boolean f5313a;
    private final DummySurfaceThread f5314d;
    private boolean f5315e;

    private static class DummySurfaceThread extends HandlerThread implements OnFrameAvailableListener, Callback {
        Handler f5302a;
        private final int[] f5303b = new int[1];
        private EGLDisplay f5304c;
        private EGLContext f5305d;
        private EGLSurface f5306e;
        private SurfaceTexture f5307f;
        private Error f5308g;
        private RuntimeException f5309h;
        private DummySurface f5310i;

        public DummySurfaceThread() {
            super("dummySurface");
        }

        public final com.google.android.exoplayer2.video.DummySurface m4336a(boolean r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r3.start();
            r0 = new android.os.Handler;
            r1 = r3.getLooper();
            r0.<init>(r1, r3);
            r3.f5302a = r0;
            monitor-enter(r3);
            r0 = r3.f5302a;	 Catch:{ all -> 0x0047 }
            r1 = 1;	 Catch:{ all -> 0x0047 }
            r2 = 0;	 Catch:{ all -> 0x0047 }
            r4 = r0.obtainMessage(r1, r4, r2);	 Catch:{ all -> 0x0047 }
            r4.sendToTarget();	 Catch:{ all -> 0x0047 }
        L_0x001a:
            r4 = r3.f5310i;	 Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x002c;	 Catch:{ all -> 0x0047 }
        L_0x001e:
            r4 = r3.f5309h;	 Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x002c;	 Catch:{ all -> 0x0047 }
        L_0x0022:
            r4 = r3.f5308g;	 Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x002c;
        L_0x0026:
            r3.wait();	 Catch:{ InterruptedException -> 0x002a }
            goto L_0x001a;
        L_0x002a:
            r2 = r1;
            goto L_0x001a;
        L_0x002c:
            monitor-exit(r3);	 Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0036;
        L_0x002f:
            r4 = java.lang.Thread.currentThread();
            r4.interrupt();
        L_0x0036:
            r4 = r3.f5309h;
            if (r4 == 0) goto L_0x003d;
        L_0x003a:
            r4 = r3.f5309h;
            throw r4;
        L_0x003d:
            r4 = r3.f5308g;
            if (r4 == 0) goto L_0x0044;
        L_0x0041:
            r4 = r3.f5308g;
            throw r4;
        L_0x0044:
            r4 = r3.f5310i;
            return r4;
        L_0x0047:
            r4 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0047 }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.DummySurface.DummySurfaceThread.a(boolean):com.google.android.exoplayer2.video.DummySurface");
        }

        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.f5302a.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    try {
                        int[] iArr;
                        int[] iArr2;
                        message = message.arg1 != null ? 1 : null;
                        this.f5304c = EGL14.eglGetDisplay(0);
                        Assertions.m4187b(this.f5304c != null, "eglGetDisplay failed");
                        int[] iArr3 = new int[2];
                        Assertions.m4187b(EGL14.eglInitialize(this.f5304c, iArr3, 0, iArr3, 1), "eglInitialize failed");
                        EGLConfig[] eGLConfigArr = new EGLConfig[1];
                        int[] iArr4 = new int[1];
                        boolean z = EGL14.eglChooseConfig(this.f5304c, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr4, 0) && iArr4[0] > 0 && eGLConfigArr[0] != null;
                        Assertions.m4187b(z, "eglChooseConfig failed");
                        EGLConfig eGLConfig = eGLConfigArr[0];
                        if (message != null) {
                            iArr = new int[]{12440, 2, 12992, 1, 12344};
                        } else {
                            iArr = new int[]{12440, 2, 12344};
                        }
                        this.f5305d = EGL14.eglCreateContext(this.f5304c, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
                        Assertions.m4187b(this.f5305d != null, "eglCreateContext failed");
                        if (message != null) {
                            iArr2 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                        } else {
                            iArr2 = new int[]{12375, 1, 12374, 1, 12344};
                        }
                        this.f5306e = EGL14.eglCreatePbufferSurface(this.f5304c, eGLConfig, iArr2, 0);
                        Assertions.m4187b(this.f5306e != null, "eglCreatePbufferSurface failed");
                        Assertions.m4187b(EGL14.eglMakeCurrent(this.f5304c, this.f5306e, this.f5306e, this.f5305d), "eglMakeCurrent failed");
                        GLES20.glGenTextures(1, this.f5303b, 0);
                        this.f5307f = new SurfaceTexture(this.f5303b[0]);
                        this.f5307f.setOnFrameAvailableListener(this);
                        this.f5310i = new DummySurface(this, this.f5307f, message);
                        synchronized (this) {
                            notify();
                        }
                    } catch (Message message2) {
                        Log.e("DummySurface", "Failed to initialize dummy surface", message2);
                        this.f5309h = message2;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Message message22) {
                        try {
                            Log.e("DummySurface", "Failed to initialize dummy surface", message22);
                            this.f5308g = message22;
                            synchronized (this) {
                                notify();
                            }
                        } catch (Throwable th) {
                            synchronized (this) {
                                notify();
                            }
                        }
                    }
                    return true;
                case 2:
                    this.f5307f.updateTexImage();
                    return true;
                case 3:
                    try {
                        if (this.f5307f != null) {
                            this.f5307f.release();
                            GLES20.glDeleteTextures(1, this.f5303b, 0);
                        }
                        if (this.f5306e != null) {
                            EGL14.eglDestroySurface(this.f5304c, this.f5306e);
                        }
                        if (this.f5305d != null) {
                            EGL14.eglDestroyContext(this.f5304c, this.f5305d);
                        }
                        this.f5306e = null;
                        this.f5305d = null;
                        this.f5304c = null;
                        this.f5310i = null;
                        this.f5307f = null;
                    } catch (Message message222) {
                        try {
                            Log.e("DummySurface", "Failed to release dummy surface", message222);
                        } catch (Throwable th2) {
                            quit();
                        }
                    }
                    quit();
                    return true;
                default:
                    return true;
            }
        }
    }

    public static synchronized boolean m4338a(Context context) {
        synchronized (DummySurface.class) {
            if (!f5312c) {
                boolean z = false;
                if (Util.f5283a >= 24) {
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null) {
                        if (eglQueryString.contains("EGL_EXT_protected_content")) {
                            if (Util.f5283a != 24 || !"samsung".equals(Util.f5285c)) {
                                if (Util.f5283a >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance") != null) {
                                    context = 1;
                                    if (context != null) {
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                    context = null;
                    if (context != null) {
                        z = true;
                    }
                }
                f5311b = z;
                f5312c = true;
            }
            context = f5311b;
        }
        return context;
    }

    private DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f5314d = dummySurfaceThread;
        this.f5313a = z;
    }

    public final void release() {
        super.release();
        synchronized (this.f5314d) {
            if (!this.f5315e) {
                this.f5314d.f5302a.sendEmptyMessage(3);
                this.f5315e = true;
            }
        }
    }

    public static DummySurface m4337a(Context context, boolean z) {
        if (Util.f5283a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
        if (z) {
            if (m4338a(context) == null) {
                context = null;
                Assertions.m4186b(context);
                return new DummySurfaceThread().m4336a(z);
            }
        }
        context = true;
        Assertions.m4186b(context);
        return new DummySurfaceThread().m4336a(z);
    }
}

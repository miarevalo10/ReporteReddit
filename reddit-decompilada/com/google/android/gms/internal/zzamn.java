package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@zzzv
@TargetApi(14)
public final class zzamn extends Thread implements OnFrameAvailableListener, zzamm {
    private static final float[] f14166f = new float[]{-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean f14167A;
    private volatile boolean f14168B;
    float f14169a;
    float f14170b;
    int f14171c;
    int f14172d;
    SurfaceTexture f14173e;
    private final zzamk f14174g;
    private final float[] f14175h;
    private final float[] f14176i;
    private final float[] f14177j;
    private final float[] f14178k;
    private final float[] f14179l;
    private final float[] f14180m;
    private final float[] f14181n;
    private float f14182o;
    private SurfaceTexture f14183p;
    private int f14184q;
    private int f14185r;
    private int f14186s;
    private FloatBuffer f14187t = ByteBuffer.allocateDirect(f14166f.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private final CountDownLatch f14188u;
    private final Object f14189v;
    private EGL10 f14190w;
    private EGLDisplay f14191x;
    private EGLContext f14192y;
    private EGLSurface f14193z;

    private static int m13371a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m13372a("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        m13372a("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        m13372a("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        m13372a("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Could not compile shader ");
        stringBuilder.append(i);
        stringBuilder.append(":");
        Log.e("SphericalVideoRenderer", stringBuilder.toString());
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        m13372a("deleteShader");
        return 0;
    }

    private static void m13372a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder stringBuilder = new StringBuilder(21 + String.valueOf(str).length());
            stringBuilder.append(str);
            stringBuilder.append(": glError ");
            stringBuilder.append(glGetError);
            Log.e("SphericalVideoRenderer", stringBuilder.toString());
        }
    }

    private static void m13373a(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = (double) f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    private static void m13374a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = ((fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3])) + (fArr2[2] * fArr3[6]);
        fArr[1] = ((fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4])) + (fArr2[2] * fArr3[7]);
        fArr[2] = ((fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5])) + (fArr2[2] * fArr3[8]);
        fArr[3] = ((fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3])) + (fArr2[5] * fArr3[6]);
        fArr[4] = ((fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4])) + (fArr2[5] * fArr3[7]);
        fArr[5] = ((fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5])) + (fArr2[5] * fArr3[8]);
        fArr[6] = ((fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3])) + (fArr2[8] * fArr3[6]);
        fArr[7] = ((fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4])) + (fArr2[8] * fArr3[7]);
        fArr[8] = ((fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5])) + (fArr2[8] * fArr3[8]);
    }

    private static void m13375b(float[] fArr, float f) {
        double d = (double) f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private final void m13376d() {
        float[] fArr;
        float f;
        while (this.f14186s > 0) {
            this.f14183p.updateTexImage();
            this.f14186s--;
        }
        if (this.f14174g.m5420a(this.f14175h)) {
            if (Float.isNaN(this.f14182o)) {
                fArr = this.f14175h;
                float[] fArr2 = new float[]{0.0f, 1.0f, 0.0f};
                float[] fArr3 = new float[]{((fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1])) + (fArr[2] * fArr2[2]), ((fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1])) + (fArr[5] * fArr2[2]), ((fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1])) + (fArr[8] * fArr2[2])};
                this.f14182o = -(((float) Math.atan2((double) fArr3[1], (double) fArr3[0])) - 1.5707964f);
            }
            fArr = this.f14180m;
            f = this.f14182o + this.f14169a;
        } else {
            m13373a(this.f14175h, -1.5707964f);
            fArr = this.f14180m;
            f = this.f14169a;
        }
        m13375b(fArr, f);
        m13373a(this.f14176i, 1.5707964f);
        m13374a(this.f14177j, this.f14180m, this.f14176i);
        m13374a(this.f14178k, this.f14175h, this.f14177j);
        m13373a(this.f14179l, this.f14170b);
        m13374a(this.f14181n, this.f14179l, this.f14178k);
        GLES20.glUniformMatrix3fv(this.f14185r, 1, false, this.f14181n, 0);
        GLES20.glDrawArrays(5, 0, 4);
        m13372a("drawArrays");
        GLES20.glFinish();
        this.f14190w.eglSwapBuffers(this.f14191x, this.f14193z);
    }

    private final boolean m13377e() {
        boolean z = false;
        if (!(this.f14193z == null || this.f14193z == EGL10.EGL_NO_SURFACE)) {
            z = this.f14190w.eglDestroySurface(this.f14191x, this.f14193z) | (this.f14190w.eglMakeCurrent(this.f14191x, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | 0);
            this.f14193z = null;
        }
        if (this.f14192y != null) {
            z |= this.f14190w.eglDestroyContext(this.f14191x, this.f14192y);
            this.f14192y = null;
        }
        if (this.f14191x == null) {
            return z;
        }
        z |= this.f14190w.eglTerminate(this.f14191x);
        this.f14191x = null;
        return z;
    }

    public final void mo1751a() {
        synchronized (this.f14189v) {
            this.f14189v.notifyAll();
        }
    }

    public final void m13379a(int i, int i2) {
        synchronized (this.f14189v) {
            this.f14172d = i;
            this.f14171c = i2;
            this.f14167A = true;
            this.f14189v.notifyAll();
        }
    }

    public final void m13380b() {
        synchronized (this.f14189v) {
            this.f14168B = true;
            this.f14173e = null;
            this.f14189v.notifyAll();
        }
    }

    public final android.graphics.SurfaceTexture m13381c() {
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
        r1 = this;
        r0 = r1.f14173e;
        if (r0 != 0) goto L_0x0006;
    L_0x0004:
        r0 = 0;
        return r0;
    L_0x0006:
        r0 = r1.f14188u;	 Catch:{ InterruptedException -> 0x000b }
        r0.await();	 Catch:{ InterruptedException -> 0x000b }
    L_0x000b:
        r0 = r1.f14183p;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzamn.c():android.graphics.SurfaceTexture");
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f14186s++;
        synchronized (this.f14189v) {
            this.f14189v.notifyAll();
        }
    }

    public zzamn(Context context) {
        super("SphericalVideoProcessor");
        this.f14187t.put(f14166f).position(0);
        this.f14175h = new float[9];
        this.f14176i = new float[9];
        this.f14177j = new float[9];
        this.f14178k = new float[9];
        this.f14179l = new float[9];
        this.f14180m = new float[9];
        this.f14181n = new float[9];
        this.f14182o = Float.NaN;
        this.f14174g = new zzamk(context);
        this.f14174g.f6551c = this;
        this.f14188u = new CountDownLatch(1);
        this.f14189v = new Object();
    }

    public final void run() {
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
        r13 = this;
        r0 = r13.f14173e;
        if (r0 != 0) goto L_0x000f;
    L_0x0004:
        r0 = "SphericalVideoProcessor started with no output texture.";
        com.google.android.gms.internal.zzakb.m5368c(r0);
        r0 = r13.f14188u;
        r0.countDown();
        return;
    L_0x000f:
        r0 = javax.microedition.khronos.egl.EGLContext.getEGL();
        r0 = (javax.microedition.khronos.egl.EGL10) r0;
        r13.f14190w = r0;
        r0 = r13.f14190w;
        r1 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY;
        r0 = r0.eglGetDisplay(r1);
        r13.f14191x = r0;
        r0 = r13.f14191x;
        r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY;
        r2 = 11;
        r3 = 0;
        r4 = 1;
        r5 = 0;
        if (r0 != r1) goto L_0x002f;
    L_0x002c:
        r0 = r5;
        goto L_0x00a4;
    L_0x002f:
        r0 = 2;
        r0 = new int[r0];
        r1 = r13.f14190w;
        r6 = r13.f14191x;
        r0 = r1.eglInitialize(r6, r0);
        if (r0 != 0) goto L_0x003d;
    L_0x003c:
        goto L_0x002c;
    L_0x003d:
        r0 = new int[r4];
        r1 = new javax.microedition.khronos.egl.EGLConfig[r4];
        r8 = new int[r2];
        r8 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344};
        r6 = r13.f14190w;
        r7 = r13.f14191x;
        r10 = 1;
        r9 = r1;
        r11 = r0;
        r6 = r6.eglChooseConfig(r7, r8, r9, r10, r11);
        if (r6 == 0) goto L_0x005a;
    L_0x0053:
        r0 = r0[r5];
        if (r0 <= 0) goto L_0x005a;
    L_0x0057:
        r0 = r1[r5];
        goto L_0x005b;
    L_0x005a:
        r0 = r3;
    L_0x005b:
        if (r0 != 0) goto L_0x005e;
    L_0x005d:
        goto L_0x002c;
    L_0x005e:
        r1 = 3;
        r1 = new int[r1];
        r1 = {12440, 2, 12344};
        r6 = r13.f14190w;
        r7 = r13.f14191x;
        r8 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
        r1 = r6.eglCreateContext(r7, r0, r8, r1);
        r13.f14192y = r1;
        r1 = r13.f14192y;
        if (r1 == 0) goto L_0x002c;
    L_0x0074:
        r1 = r13.f14192y;
        r6 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
        if (r1 != r6) goto L_0x007b;
    L_0x007a:
        goto L_0x002c;
    L_0x007b:
        r1 = r13.f14190w;
        r6 = r13.f14191x;
        r7 = r13.f14173e;
        r0 = r1.eglCreateWindowSurface(r6, r0, r7, r3);
        r13.f14193z = r0;
        r0 = r13.f14193z;
        if (r0 == 0) goto L_0x002c;
    L_0x008b:
        r0 = r13.f14193z;
        r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
        if (r0 != r1) goto L_0x0092;
    L_0x0091:
        goto L_0x002c;
    L_0x0092:
        r0 = r13.f14190w;
        r1 = r13.f14191x;
        r6 = r13.f14193z;
        r7 = r13.f14193z;
        r8 = r13.f14192y;
        r0 = r0.eglMakeCurrent(r1, r6, r7, r8);
        if (r0 != 0) goto L_0x00a3;
    L_0x00a2:
        goto L_0x002c;
    L_0x00a3:
        r0 = r4;
    L_0x00a4:
        r1 = 35633; // 0x8b31 float:4.9932E-41 double:1.7605E-319;
        r6 = com.google.android.gms.internal.zznh.aV;
        r7 = com.google.android.gms.internal.zzkb.m6350f();
        r7 = r7.m6488a(r6);
        r7 = (java.lang.String) r7;
        r8 = r6.f7849c;
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x00c6;
    L_0x00bb:
        r7 = com.google.android.gms.internal.zzkb.m6350f();
        r6 = r7.m6488a(r6);
        r6 = (java.lang.String) r6;
        goto L_0x00c8;
    L_0x00c6:
        r6 = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}";
    L_0x00c8:
        r1 = m13371a(r1, r6);
        if (r1 != 0) goto L_0x00d1;
    L_0x00ce:
        r7 = r5;
        goto L_0x0151;
    L_0x00d1:
        r6 = 35632; // 0x8b30 float:4.9931E-41 double:1.76045E-319;
        r7 = com.google.android.gms.internal.zznh.aW;
        r8 = com.google.android.gms.internal.zzkb.m6350f();
        r8 = r8.m6488a(r7);
        r8 = (java.lang.String) r8;
        r9 = r7.f7849c;
        r8 = r8.equals(r9);
        if (r8 != 0) goto L_0x00f3;
    L_0x00e8:
        r8 = com.google.android.gms.internal.zzkb.m6350f();
        r7 = r8.m6488a(r7);
        r7 = (java.lang.String) r7;
        goto L_0x00f5;
    L_0x00f3:
        r7 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}";
    L_0x00f5:
        r6 = m13371a(r6, r7);
        if (r6 != 0) goto L_0x00fc;
    L_0x00fb:
        goto L_0x00ce;
    L_0x00fc:
        r7 = android.opengl.GLES20.glCreateProgram();
        r8 = "createProgram";
        m13372a(r8);
        if (r7 == 0) goto L_0x0151;
    L_0x0107:
        android.opengl.GLES20.glAttachShader(r7, r1);
        r1 = "attachShader";
        m13372a(r1);
        android.opengl.GLES20.glAttachShader(r7, r6);
        r1 = "attachShader";
        m13372a(r1);
        android.opengl.GLES20.glLinkProgram(r7);
        r1 = "linkProgram";
        m13372a(r1);
        r1 = new int[r4];
        r6 = 35714; // 0x8b82 float:5.0046E-41 double:1.7645E-319;
        android.opengl.GLES20.glGetProgramiv(r7, r6, r1, r5);
        r6 = "getProgramiv";
        m13372a(r6);
        r1 = r1[r5];
        if (r1 == r4) goto L_0x0149;
    L_0x0130:
        r1 = "SphericalVideoRenderer";
        r6 = "Could not link program: ";
        android.util.Log.e(r1, r6);
        r1 = "SphericalVideoRenderer";
        r6 = android.opengl.GLES20.glGetProgramInfoLog(r7);
        android.util.Log.e(r1, r6);
        android.opengl.GLES20.glDeleteProgram(r7);
        r1 = "deleteProgram";
        m13372a(r1);
        goto L_0x00ce;
    L_0x0149:
        android.opengl.GLES20.glValidateProgram(r7);
        r1 = "validateProgram";
        m13372a(r1);
    L_0x0151:
        r13.f14184q = r7;
        r1 = r13.f14184q;
        android.opengl.GLES20.glUseProgram(r1);
        r1 = "useProgram";
        m13372a(r1);
        r1 = r13.f14184q;
        r6 = "aPosition";
        r1 = android.opengl.GLES20.glGetAttribLocation(r1, r6);
        r8 = 3;
        r9 = 5126; // 0x1406 float:7.183E-42 double:2.5326E-320;
        r10 = 0;
        r11 = 12;
        r12 = r13.f14187t;
        r7 = r1;
        android.opengl.GLES20.glVertexAttribPointer(r7, r8, r9, r10, r11, r12);
        r6 = "vertexAttribPointer";
        m13372a(r6);
        android.opengl.GLES20.glEnableVertexAttribArray(r1);
        r1 = "enableVertexAttribArray";
        m13372a(r1);
        r1 = new int[r4];
        android.opengl.GLES20.glGenTextures(r4, r1, r5);
        r6 = "genTextures";
        m13372a(r6);
        r1 = r1[r5];
        r6 = 36197; // 0x8d65 float:5.0723E-41 double:1.78837E-319;
        android.opengl.GLES20.glBindTexture(r6, r1);
        r7 = "bindTextures";
        m13372a(r7);
        r7 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
        r8 = 9729; // 0x2601 float:1.3633E-41 double:4.807E-320;
        android.opengl.GLES20.glTexParameteri(r6, r7, r8);
        r7 = "texParameteri";
        m13372a(r7);
        r7 = 10241; // 0x2801 float:1.435E-41 double:5.0597E-320;
        android.opengl.GLES20.glTexParameteri(r6, r7, r8);
        r7 = "texParameteri";
        m13372a(r7);
        r7 = 10242; // 0x2802 float:1.4352E-41 double:5.06E-320;
        r8 = 33071; // 0x812f float:4.6342E-41 double:1.6339E-319;
        android.opengl.GLES20.glTexParameteri(r6, r7, r8);
        r7 = "texParameteri";
        m13372a(r7);
        r7 = 10243; // 0x2803 float:1.4354E-41 double:5.0607E-320;
        android.opengl.GLES20.glTexParameteri(r6, r7, r8);
        r6 = "texParameteri";
        m13372a(r6);
        r6 = r13.f14184q;
        r7 = "uVMat";
        r6 = android.opengl.GLES20.glGetUniformLocation(r6, r7);
        r13.f14185r = r6;
        r6 = 9;
        r6 = new float[r6];
        r6 = {1065353216, 0, 0, 0, 1065353216, 0, 0, 0, 1065353216};
        r7 = r13.f14185r;
        android.opengl.GLES20.glUniformMatrix3fv(r7, r4, r5, r6, r5);
        r6 = r13.f14184q;
        if (r6 == 0) goto L_0x01de;
    L_0x01dc:
        r6 = r4;
        goto L_0x01df;
    L_0x01de:
        r6 = r5;
    L_0x01df:
        if (r0 == 0) goto L_0x02d3;
    L_0x01e1:
        if (r6 != 0) goto L_0x01e5;
    L_0x01e3:
        goto L_0x02d3;
    L_0x01e5:
        r0 = new android.graphics.SurfaceTexture;
        r0.<init>(r1);
        r13.f14183p = r0;
        r0 = r13.f14183p;
        r0.setOnFrameAvailableListener(r13);
        r0 = r13.f14188u;
        r0.countDown();
        r0 = r13.f14174g;
        r1 = r0.f6550b;
        if (r1 != 0) goto L_0x0231;
    L_0x01fc:
        r1 = r0.f6549a;
        r1 = r1.getDefaultSensor(r2);
        if (r1 != 0) goto L_0x020a;
    L_0x0204:
        r0 = "No Sensor of TYPE_ROTATION_VECTOR";
        com.google.android.gms.internal.zzakb.m5368c(r0);
        goto L_0x0231;
    L_0x020a:
        r2 = new android.os.HandlerThread;
        r6 = "OrientationMonitor";
        r2.<init>(r6);
        r2.start();
        r6 = new android.os.Handler;
        r2 = r2.getLooper();
        r6.<init>(r2);
        r0.f6550b = r6;
        r2 = r0.f6549a;
        r6 = r0.f6550b;
        r1 = r2.registerListener(r0, r1, r5, r6);
        if (r1 != 0) goto L_0x0231;
    L_0x0229:
        r1 = "SensorManager.registerListener failed.";
        com.google.android.gms.internal.zzakb.m5368c(r1);
        r0.m5419a();
    L_0x0231:
        r13.f14167A = r4;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
    L_0x0233:
        r0 = r13.f14168B;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        if (r0 != 0) goto L_0x029b;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
    L_0x0237:
        r13.m13376d();	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r0 = r13.f14167A;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        if (r0 == 0) goto L_0x0282;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
    L_0x023e:
        r0 = r13.f14172d;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r1 = r13.f14171c;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        android.opengl.GLES20.glViewport(r5, r5, r0, r1);	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r0 = "viewport";	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        m13372a(r0);	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r0 = r13.f14184q;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r1 = "uFOVx";	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r0 = android.opengl.GLES20.glGetUniformLocation(r0, r1);	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r1 = r13.f14184q;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r2 = "uFOVy";	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r1 = android.opengl.GLES20.glGetUniformLocation(r1, r2);	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r2 = r13.f14172d;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r4 = r13.f14171c;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r6 = 1063216883; // 0x3f5f66f3 float:0.87266463 double:5.25298936E-315;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        if (r2 <= r4) goto L_0x0272;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
    L_0x0263:
        android.opengl.GLES20.glUniform1f(r0, r6);	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r0 = r13.f14171c;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r0 = (float) r0;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r6 = r6 * r0;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r0 = r13.f14172d;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r0 = (float) r0;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r6 = r6 / r0;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        android.opengl.GLES20.glUniform1f(r1, r6);	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        goto L_0x0280;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
    L_0x0272:
        r2 = r13.f14172d;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r2 = (float) r2;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r2 = r2 * r6;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r4 = r13.f14171c;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r4 = (float) r4;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        r2 = r2 / r4;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        android.opengl.GLES20.glUniform1f(r0, r2);	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
        android.opengl.GLES20.glUniform1f(r1, r6);	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
    L_0x0280:
        r13.f14167A = r5;	 Catch:{ IllegalStateException -> 0x02bd, Throwable -> 0x02ad }
    L_0x0282:
        r0 = r13.f14189v;	 Catch:{ InterruptedException -> 0x0233 }
        monitor-enter(r0);	 Catch:{ InterruptedException -> 0x0233 }
        r1 = r13.f14168B;	 Catch:{ all -> 0x0298 }
        if (r1 != 0) goto L_0x0296;	 Catch:{ all -> 0x0298 }
    L_0x0289:
        r1 = r13.f14167A;	 Catch:{ all -> 0x0298 }
        if (r1 != 0) goto L_0x0296;	 Catch:{ all -> 0x0298 }
    L_0x028d:
        r1 = r13.f14186s;	 Catch:{ all -> 0x0298 }
        if (r1 != 0) goto L_0x0296;	 Catch:{ all -> 0x0298 }
    L_0x0291:
        r1 = r13.f14189v;	 Catch:{ all -> 0x0298 }
        r1.wait();	 Catch:{ all -> 0x0298 }
    L_0x0296:
        monitor-exit(r0);	 Catch:{ all -> 0x0298 }
        goto L_0x0233;	 Catch:{ all -> 0x0298 }
    L_0x0298:
        r1 = move-exception;	 Catch:{ all -> 0x0298 }
        monitor-exit(r0);	 Catch:{ all -> 0x0298 }
        throw r1;	 Catch:{ InterruptedException -> 0x0233 }
    L_0x029b:
        r0 = r13.f14174g;
        r0.m5419a();
        r0 = r13.f14183p;
        r0.setOnFrameAvailableListener(r3);
        r13.f14183p = r3;
        r13.m13377e();
        return;
    L_0x02ab:
        r0 = move-exception;
        goto L_0x02c3;
    L_0x02ad:
        r0 = move-exception;
        r1 = "SphericalVideoProcessor died.";	 Catch:{ all -> 0x02ab }
        com.google.android.gms.internal.zzakb.m5367b(r1, r0);	 Catch:{ all -> 0x02ab }
        r1 = com.google.android.gms.ads.internal.zzbs.m4490i();	 Catch:{ all -> 0x02ab }
        r2 = "SphericalVideoProcessor.run.2";	 Catch:{ all -> 0x02ab }
        r1.m13246a(r0, r2);	 Catch:{ all -> 0x02ab }
        goto L_0x029b;	 Catch:{ all -> 0x02ab }
    L_0x02bd:
        r0 = "SphericalVideoProcessor halted unexpectedly.";	 Catch:{ all -> 0x02ab }
        com.google.android.gms.internal.zzakb.m5371e(r0);	 Catch:{ all -> 0x02ab }
        goto L_0x029b;
    L_0x02c3:
        r1 = r13.f14174g;
        r1.m5419a();
        r1 = r13.f14183p;
        r1.setOnFrameAvailableListener(r3);
        r13.f14183p = r3;
        r13.m13377e();
        throw r0;
    L_0x02d3:
        r0 = r13.f14190w;
        r0 = r0.eglGetError();
        r0 = android.opengl.GLUtils.getEGLErrorString(r0);
        r1 = "EGL initialization failed: ";
        r0 = java.lang.String.valueOf(r0);
        r2 = r0.length();
        if (r2 == 0) goto L_0x02ee;
    L_0x02e9:
        r0 = r1.concat(r0);
        goto L_0x02f3;
    L_0x02ee:
        r0 = new java.lang.String;
        r0.<init>(r1);
    L_0x02f3:
        com.google.android.gms.internal.zzakb.m5368c(r0);
        r1 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r2 = new java.lang.Throwable;
        r2.<init>(r0);
        r0 = "SphericalVideoProcessor.run.1";
        r1.m13246a(r2, r0);
        r13.m13377e();
        r0 = r13.f14188u;
        r0.countDown();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzamn.run():void");
    }
}

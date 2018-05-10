package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@zzzv
public final class zzaff {
    public final AtomicReference<Object> f6262a = new AtomicReference(null);
    private final AtomicReference<ThreadPoolExecutor> f6263b = new AtomicReference(null);
    private final Object f6264c = new Object();
    private String f6265d = null;
    private AtomicBoolean f6266e = new AtomicBoolean(false);
    private final AtomicInteger f6267f = new AtomicInteger(-1);
    private final AtomicReference<Object> f6268g = new AtomicReference(null);
    private ConcurrentMap<String, Method> f6269h = new ConcurrentHashMap(9);

    static Bundle m5082a(String str, boolean z) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (Throwable e) {
            String str2 = "Invalid event ID: ";
            str = String.valueOf(str);
            zzakb.m5367b(str.length() == 0 ? new String(str2) : str2.concat(str), e);
        }
        if (z) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    private final java.lang.reflect.Method m5083e(android.content.Context r4, java.lang.String r5) {
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
        r3 = this;
        r0 = r3.f6269h;
        r0 = r0.get(r5);
        r0 = (java.lang.reflect.Method) r0;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = 0;
        r4 = r4.getClassLoader();	 Catch:{ Exception -> 0x0027 }
        r1 = "com.google.android.gms.measurement.AppMeasurement";	 Catch:{ Exception -> 0x0027 }
        r4 = r4.loadClass(r1);	 Catch:{ Exception -> 0x0027 }
        r1 = 1;	 Catch:{ Exception -> 0x0027 }
        r1 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0027 }
        r2 = java.lang.String.class;	 Catch:{ Exception -> 0x0027 }
        r1[r0] = r2;	 Catch:{ Exception -> 0x0027 }
        r4 = r4.getDeclaredMethod(r5, r1);	 Catch:{ Exception -> 0x0027 }
        r1 = r3.f6269h;	 Catch:{ Exception -> 0x0027 }
        r1.put(r5, r4);	 Catch:{ Exception -> 0x0027 }
        return r4;
    L_0x0027:
        r3.m5094b(r5, r0);
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaff.e(android.content.Context, java.lang.String):java.lang.reflect.Method");
    }

    private final java.lang.reflect.Method m5084f(android.content.Context r3, java.lang.String r4) {
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
        r2 = this;
        r0 = r2.f6269h;
        r0 = r0.get(r4);
        r0 = (java.lang.reflect.Method) r0;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = 0;
        r3 = r3.getClassLoader();	 Catch:{ Exception -> 0x0022 }
        r1 = "com.google.android.gms.measurement.AppMeasurement";	 Catch:{ Exception -> 0x0022 }
        r3 = r3.loadClass(r1);	 Catch:{ Exception -> 0x0022 }
        r1 = new java.lang.Class[r0];	 Catch:{ Exception -> 0x0022 }
        r3 = r3.getDeclaredMethod(r4, r1);	 Catch:{ Exception -> 0x0022 }
        r1 = r2.f6269h;	 Catch:{ Exception -> 0x0022 }
        r1.put(r4, r3);	 Catch:{ Exception -> 0x0022 }
        return r3;
    L_0x0022:
        r2.m5094b(r4, r0);
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaff.f(android.content.Context, java.lang.String):java.lang.reflect.Method");
    }

    private final java.lang.reflect.Method m5085j(android.content.Context r6) {
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
        r5 = this;
        r0 = r5.f6269h;
        r1 = "logEventInternal";
        r0 = r0.get(r1);
        r0 = (java.lang.reflect.Method) r0;
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = 1;
        r6 = r6.getClassLoader();	 Catch:{ Exception -> 0x0037 }
        r1 = "com.google.android.gms.measurement.AppMeasurement";	 Catch:{ Exception -> 0x0037 }
        r6 = r6.loadClass(r1);	 Catch:{ Exception -> 0x0037 }
        r1 = "logEventInternal";	 Catch:{ Exception -> 0x0037 }
        r2 = 3;	 Catch:{ Exception -> 0x0037 }
        r2 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0037 }
        r3 = 0;	 Catch:{ Exception -> 0x0037 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0037 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0037 }
        r3 = java.lang.String.class;	 Catch:{ Exception -> 0x0037 }
        r2[r0] = r3;	 Catch:{ Exception -> 0x0037 }
        r3 = 2;	 Catch:{ Exception -> 0x0037 }
        r4 = android.os.Bundle.class;	 Catch:{ Exception -> 0x0037 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0037 }
        r6 = r6.getDeclaredMethod(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r1 = r5.f6269h;	 Catch:{ Exception -> 0x0037 }
        r2 = "logEventInternal";	 Catch:{ Exception -> 0x0037 }
        r1.put(r2, r6);	 Catch:{ Exception -> 0x0037 }
        return r6;
    L_0x0037:
        r6 = "logEventInternal";
        r5.m5094b(r6, r0);
        r6 = 0;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaff.j(android.content.Context):java.lang.reflect.Method");
    }

    final java.lang.Object m5086a(java.lang.String r5, android.content.Context r6) {
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
        r4 = this;
        r0 = "com.google.android.gms.measurement.AppMeasurement";
        r1 = r4.f6268g;
        r2 = 1;
        r0 = r4.m5091a(r6, r0, r1, r2);
        r1 = 0;
        if (r0 != 0) goto L_0x000d;
    L_0x000c:
        return r1;
    L_0x000d:
        r6 = r4.m5084f(r6, r5);
        r0 = r4.f6268g;	 Catch:{ Exception -> 0x001f }
        r0 = r0.get();	 Catch:{ Exception -> 0x001f }
        r3 = 0;	 Catch:{ Exception -> 0x001f }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x001f }
        r6 = r6.invoke(r0, r3);	 Catch:{ Exception -> 0x001f }
        return r6;
    L_0x001f:
        r4.m5094b(r5, r2);
        r6 = r1;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaff.a(java.lang.String, android.content.Context):java.lang.Object");
    }

    public final void m5087a(Context context, String str) {
        m5089a(context, "_ac", str);
    }

    final void m5088a(android.content.Context r6, java.lang.String r7, android.os.Bundle r8) {
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
        r5 = this;
        r0 = r5.m5090a(r6);
        if (r0 == 0) goto L_0x0032;
    L_0x0006:
        r0 = "com.google.android.gms.measurement.AppMeasurement";
        r1 = r5.f6268g;
        r2 = 1;
        r0 = r5.m5091a(r6, r0, r1, r2);
        if (r0 != 0) goto L_0x0012;
    L_0x0011:
        return;
    L_0x0012:
        r6 = r5.m5085j(r6);
        r0 = r5.f6268g;	 Catch:{ Exception -> 0x002d }
        r0 = r0.get();	 Catch:{ Exception -> 0x002d }
        r1 = 3;	 Catch:{ Exception -> 0x002d }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x002d }
        r3 = 0;	 Catch:{ Exception -> 0x002d }
        r4 = "am";	 Catch:{ Exception -> 0x002d }
        r1[r3] = r4;	 Catch:{ Exception -> 0x002d }
        r1[r2] = r7;	 Catch:{ Exception -> 0x002d }
        r7 = 2;	 Catch:{ Exception -> 0x002d }
        r1[r7] = r8;	 Catch:{ Exception -> 0x002d }
        r6.invoke(r0, r1);	 Catch:{ Exception -> 0x002d }
        return;
    L_0x002d:
        r6 = "logEventInternal";
        r5.m5094b(r6, r2);
    L_0x0032:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaff.a(android.content.Context, java.lang.String, android.os.Bundle):void");
    }

    public final void m5089a(Context context, String str, String str2) {
        if (m5090a(context)) {
            m5088a(context, str, m5082a(str2, "_ac".equals(str)));
        }
    }

    public final boolean m5090a(Context context) {
        if (!((Boolean) zzkb.m6350f().m6488a(zznh.af)).booleanValue() || this.f6266e.get()) {
            return false;
        }
        if (this.f6267f.get() == -1) {
            zzkb.m6345a();
            if (!zzajr.m5335c(context)) {
                zzkb.m6345a();
                if (zzajr.m5338f(context)) {
                    zzakb.m5371e("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                    this.f6267f.set(0);
                }
            }
            this.f6267f.set(1);
        }
        return this.f6267f.get() == 1;
    }

    public final boolean m5091a(android.content.Context r6, java.lang.String r7, java.util.concurrent.atomic.AtomicReference<java.lang.Object> r8, boolean r9) {
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
        r5 = this;
        r0 = r8.get();
        r1 = 1;
        if (r0 != 0) goto L_0x002f;
    L_0x0007:
        r0 = 0;
        r2 = r6.getClassLoader();	 Catch:{ Exception -> 0x0029 }
        r7 = r2.loadClass(r7);	 Catch:{ Exception -> 0x0029 }
        r2 = "getInstance";	 Catch:{ Exception -> 0x0029 }
        r3 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0029 }
        r4 = android.content.Context.class;	 Catch:{ Exception -> 0x0029 }
        r3[r0] = r4;	 Catch:{ Exception -> 0x0029 }
        r7 = r7.getDeclaredMethod(r2, r3);	 Catch:{ Exception -> 0x0029 }
        r2 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0029 }
        r2[r0] = r6;	 Catch:{ Exception -> 0x0029 }
        r6 = 0;	 Catch:{ Exception -> 0x0029 }
        r7 = r7.invoke(r6, r2);	 Catch:{ Exception -> 0x0029 }
        r8.compareAndSet(r6, r7);	 Catch:{ Exception -> 0x0029 }
        return r1;
    L_0x0029:
        r6 = "getInstance";
        r5.m5094b(r6, r9);
        return r0;
    L_0x002f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaff.a(android.content.Context, java.lang.String, java.util.concurrent.atomic.AtomicReference, boolean):boolean");
    }

    public final void m5092b(Context context, String str) {
        m5089a(context, "_ai", str);
    }

    final void m5093b(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
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
        r3 = this;
        r0 = "com.google.android.gms.measurement.AppMeasurement";
        r1 = r3.f6268g;
        r2 = 1;
        r0 = r3.m5091a(r4, r0, r1, r2);
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r4 = r3.m5083e(r4, r6);
        r0 = 0;
        r1 = r3.f6268g;	 Catch:{ Exception -> 0x004f }
        r1 = r1.get();	 Catch:{ Exception -> 0x004f }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x004f }
        r2[r0] = r5;	 Catch:{ Exception -> 0x004f }
        r4.invoke(r1, r2);	 Catch:{ Exception -> 0x004f }
        r4 = 37;	 Catch:{ Exception -> 0x004f }
        r1 = java.lang.String.valueOf(r6);	 Catch:{ Exception -> 0x004f }
        r1 = r1.length();	 Catch:{ Exception -> 0x004f }
        r4 = r4 + r1;	 Catch:{ Exception -> 0x004f }
        r1 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x004f }
        r1 = r1.length();	 Catch:{ Exception -> 0x004f }
        r4 = r4 + r1;	 Catch:{ Exception -> 0x004f }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004f }
        r1.<init>(r4);	 Catch:{ Exception -> 0x004f }
        r4 = "Invoke Firebase method ";	 Catch:{ Exception -> 0x004f }
        r1.append(r4);	 Catch:{ Exception -> 0x004f }
        r1.append(r6);	 Catch:{ Exception -> 0x004f }
        r4 = ", Ad Unit Id: ";	 Catch:{ Exception -> 0x004f }
        r1.append(r4);	 Catch:{ Exception -> 0x004f }
        r1.append(r5);	 Catch:{ Exception -> 0x004f }
        r4 = r1.toString();	 Catch:{ Exception -> 0x004f }
        com.google.android.gms.internal.zzagf.m13278a(r4);	 Catch:{ Exception -> 0x004f }
        return;
    L_0x004f:
        r3.m5094b(r6, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaff.b(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public final void m5094b(String str, boolean z) {
        if (!this.f6266e.get()) {
            StringBuilder stringBuilder = new StringBuilder(30 + String.valueOf(str).length());
            stringBuilder.append("Invoke Firebase method ");
            stringBuilder.append(str);
            stringBuilder.append(" error.");
            zzakb.m5371e(stringBuilder.toString());
            if (z) {
                zzakb.m5371e("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.f6266e.set(true);
            }
        }
    }

    public final boolean m5095b(Context context) {
        return ((Boolean) zzkb.m6350f().m6488a(zznh.ag)).booleanValue() && m5090a(context);
    }

    public final void m5096c(Context context, String str) {
        m5089a(context, "_aq", str);
    }

    public final boolean m5097c(Context context) {
        return ((Boolean) zzkb.m6350f().m6488a(zznh.ah)).booleanValue() && m5090a(context);
    }

    public final java.lang.reflect.Method m5098d(android.content.Context r5, java.lang.String r6) {
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
        r4 = this;
        r0 = r4.f6269h;
        r0 = r0.get(r6);
        r0 = (java.lang.reflect.Method) r0;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = 0;
        r5 = r5.getClassLoader();	 Catch:{ Exception -> 0x0031 }
        r1 = "com.google.firebase.analytics.FirebaseAnalytics";	 Catch:{ Exception -> 0x0031 }
        r5 = r5.loadClass(r1);	 Catch:{ Exception -> 0x0031 }
        r1 = 3;	 Catch:{ Exception -> 0x0031 }
        r1 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0031 }
        r2 = android.app.Activity.class;	 Catch:{ Exception -> 0x0031 }
        r1[r0] = r2;	 Catch:{ Exception -> 0x0031 }
        r2 = 1;	 Catch:{ Exception -> 0x0031 }
        r3 = java.lang.String.class;	 Catch:{ Exception -> 0x0031 }
        r1[r2] = r3;	 Catch:{ Exception -> 0x0031 }
        r2 = 2;	 Catch:{ Exception -> 0x0031 }
        r3 = java.lang.String.class;	 Catch:{ Exception -> 0x0031 }
        r1[r2] = r3;	 Catch:{ Exception -> 0x0031 }
        r5 = r5.getDeclaredMethod(r6, r1);	 Catch:{ Exception -> 0x0031 }
        r1 = r4.f6269h;	 Catch:{ Exception -> 0x0031 }
        r1.put(r6, r5);	 Catch:{ Exception -> 0x0031 }
        return r5;
    L_0x0031:
        r4.m5094b(r6, r0);
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaff.d(android.content.Context, java.lang.String):java.lang.reflect.Method");
    }

    public final boolean m5099d(Context context) {
        return ((Boolean) zzkb.m6350f().m6488a(zznh.ai)).booleanValue() && m5090a(context);
    }

    public final boolean m5100e(Context context) {
        return ((Boolean) zzkb.m6350f().m6488a(zznh.aj)).booleanValue() && m5090a(context);
    }

    public final java.lang.String m5101f(android.content.Context r5) {
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
        r4 = this;
        r0 = r4.m5090a(r5);
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r5 = "";
        return r5;
    L_0x0009:
        r0 = "com.google.android.gms.measurement.AppMeasurement";
        r1 = r4.f6268g;
        r2 = 1;
        r0 = r4.m5091a(r5, r0, r1, r2);
        if (r0 != 0) goto L_0x0017;
    L_0x0014:
        r5 = "";
        return r5;
    L_0x0017:
        r0 = 0;
        r1 = "getCurrentScreenName";	 Catch:{ Exception -> 0x0049 }
        r1 = r4.m5084f(r5, r1);	 Catch:{ Exception -> 0x0049 }
        r2 = r4.f6268g;	 Catch:{ Exception -> 0x0049 }
        r2 = r2.get();	 Catch:{ Exception -> 0x0049 }
        r3 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0049 }
        r1 = r1.invoke(r2, r3);	 Catch:{ Exception -> 0x0049 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0049 }
        if (r1 != 0) goto L_0x0043;	 Catch:{ Exception -> 0x0049 }
    L_0x002e:
        r1 = "getCurrentScreenClass";	 Catch:{ Exception -> 0x0049 }
        r5 = r4.m5084f(r5, r1);	 Catch:{ Exception -> 0x0049 }
        r1 = r4.f6268g;	 Catch:{ Exception -> 0x0049 }
        r1 = r1.get();	 Catch:{ Exception -> 0x0049 }
        r2 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0049 }
        r5 = r5.invoke(r1, r2);	 Catch:{ Exception -> 0x0049 }
        r1 = r5;	 Catch:{ Exception -> 0x0049 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0049 }
    L_0x0043:
        if (r1 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x0049 }
    L_0x0045:
        return r1;	 Catch:{ Exception -> 0x0049 }
    L_0x0046:
        r5 = "";	 Catch:{ Exception -> 0x0049 }
        return r5;
    L_0x0049:
        r5 = "getCurrentScreenName";
        r4.m5094b(r5, r0);
        r5 = "";
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaff.f(android.content.Context):java.lang.String");
    }

    public final String m5102g(Context context) {
        if (!m5090a(context)) {
            return null;
        }
        synchronized (this.f6264c) {
            if (this.f6265d != null) {
                String str = this.f6265d;
                return str;
            }
            this.f6265d = (String) m5086a("getGmpAppId", context);
            str = this.f6265d;
            return str;
        }
    }

    public final String m5103h(Context context) {
        if (!m5090a(context)) {
            return null;
        }
        long longValue = ((Long) zzkb.m6350f().m6488a(zznh.ap)).longValue();
        if (longValue < 0) {
            return (String) m5086a("getAppInstanceId", context);
        }
        if (this.f6263b.get() == null) {
            this.f6263b.compareAndSet(null, new ThreadPoolExecutor(((Integer) zzkb.m6350f().m6488a(zznh.aq)).intValue(), ((Integer) zzkb.m6350f().m6488a(zznh.aq)).intValue(), 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzafh()));
        }
        Future submit = ((ThreadPoolExecutor) this.f6263b.get()).submit(new zzafg(this, context));
        try {
            return (String) submit.get(longValue, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            submit.cancel(true);
            return e instanceof TimeoutException ? "TIME_OUT" : null;
        }
    }

    public final String m5104i(Context context) {
        if (!m5090a(context)) {
            return null;
        }
        Object a = m5086a("generateEventId", context);
        return a != null ? a.toString() : null;
    }
}
